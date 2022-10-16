import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

//Bibliotecas importadasport Register.java;

/**
 * Classe do CRUD
 * @author Gustavo Lopes Rodrigues
 * @version 2.0
 */
public class CRUD<T extends Register> {

  //Dados do meu CRUD
  private Constructor<T> constructor;
  private RandomAccessFile arquive;

  //Indices Direto e Indireto armazenado em uma Hash e ArvoreB+
  private HashExtensivel ld;      
  private ArvoreBMais_String_Int li;

  //Construtor
  public CRUD(Constructor<T> constructor,String filepath) {

    //Atribuindo o construtor e definindo o arquivo de destino
    this.constructor = constructor;

    //Criando o arquivo (caso ele nao exista)
    File f = new File("data");
    if (!f.exists()) {

      f.mkdir();
    
}
    //Tentando iniciar o arquivo para a leitura e escrita de dados
    try {

      arquive = new RandomAccessFile("data/" + filepath + ".data", "rw");
    }
    catch(FileNotFoundException fnfe) {
      
      System.err.println("Impossivel abrir o arquivo " + filepath);
    }

    //Escrita da ID na primeira linha(caso o arquivo esteja vazio)
    try { 

      //Se o arquivo estiver vazio
      if (arquive.length() <= 0) {

        arquive.writeInt(0);
      }

      //Criar os Indice Direto e Indireto
      ld = new HashExtensivel(10,"data/" + filepath + "Id" + ".data",
                               "data/" + filepath + "cestos" + ".data");

      li = new ArvoreBMais_String_Int(10,"data/" + filepath + "Ii" + ".data");
    }
    catch(Exception e) {

      System.err.println("Erro na leitura do arquivo");
    }
      

  }

  //Criando um novo dado a ser armazenado
  /*
  A funcao recebe um objeto generico, e leh a primeira posicao
  no arquivo(que e a ID do proximo objeto).Logo apos isso, ele
  pega os dados do objeto, e escreve o registro na ultima
  posicao do arquivo. Antes de terminar a funcao
  ele atualiza a ID no inicio do arquivo.

  */
  public int create(T object)  {

    int id = -1;
    
    byte[] objectData;
    long pos;

    try { 

      arquive.seek(0);

      id = arquive.readInt(); 
      object.setID(id);

      objectData = object.toByteArray();
      pos = arquive.length();
      arquive.seek(pos);

      ld.create(id,pos+2);
      li.create(object.getSecKey(),id);

      arquive.writeChar(' ');               //Esse espaco vazio eh a lapide
      arquive.writeInt(objectData.length);
      arquive.write(objectData);

      arquive.seek(0);
      arquive.writeInt(id+1);
    }
    catch (Exception e) {

      id = -1;
      System.err.println("Impossivel a leitura desse arquivo");
    }

    return id;
  }


    
  //Lendo um objeto a partir da ID
  /*
  A funcao recebe a ID(chave primaria),e apartir da ID
  encontra a posicao do registro no indice direto. Com a
  posicao encontrada, o programa entao vai na posicao e
  faz a leitura dos dados e entao armazena tais dados no
  objeto que será retornado.
  */
  public T read(int id) {

    T object = null;
    int size = 0;
    long pos = -1;

    try {

      pos = ld.read(id);
      if(pos < 0) {

        throw new Exception("Esse registro nao existe ou foi apagado");
      }

      arquive.seek(pos);

      size = arquive.readInt();
			byte[] data = new byte[size];
      arquive.read(data);

			object = constructor.newInstance();
			object.fromByteArray(data);

    }
    catch(Exception e) {
      
      System.err.println("Nao foi possivel fazer a leitura do registro");
    }

    return object;
  }

  //Lendo um objeto a partir da chave secundaria
  /*
  A funcao recebe uma String(chave secundaria). Como
  a chave secundaria guarda a ID do objeto, o programa
  basicamente encontra a ID a partir da chave secundaria
  e executa a funcao "read(int id)".
  */
  public T read(String secKey) {

    long pos = -1;
    T object = null;

    try {

      pos = li.read(secKey);
    }
    catch (Exception e) {

      System.err.println("Nao foi possivel ler a chave");
    }

    if ( pos >= 0 ) {

      object = read((int)pos);
    }
    else {

      System.err.println("Esse registro nao foi encontrado ou foi deletado");
    }
    return object;
  }

  //Atualiza um registro 
  /*
  Primeiro ele verifica se o objeto que o 
  usuario quer atualizar existe no registro,
  depois de confirmado a existencia do objeto,
  ele agora precisa verificar se o novo objeto
  tem o mesmo tamanho(ou menor tamanho) do antigo objeto.
  Se o objeto que tem que ser atualizado atender essa
  especificacao, entao o objeto e apenas rescrito.
  Caso o novo objeto seja maior do que o registro,
  entao o objeto atual no registro sera deletado,
  e o novo objeto sera adicionado no fim do arquivo
  */
  public boolean update(T object){

    boolean resp = false;

    int id = -1;
    long pos = -1;
    int tam = 0;
    byte[] objectData;

    try {

      id = object.getID();
      pos = ld.read(id);
      objectData = object.toByteArray();  

      if (pos < 0 ) {

        System.err.println("Erro, objeto não existe ou foi deletado");
        resp = false;
      }
      else {

        arquive.seek(pos);
        tam = arquive.readInt();
        if ( objectData.length <= tam ) {

          arquive.write(objectData);
          resp = true;
        }
        else {

          delete(id);
          create(object);
          resp = true;

        }

      }

    }
    catch(Exception e) {

      System.err.println("Nao foi possivel atualizar o registro");
    }

    return resp;
  }

  //Deleta um registro a partir da ID
  /*
  A funcao recebe a id(chave primaria) e encontra
  a partir do Indice Direto encontra a posicao
  do registro no arquivo. Para deletar o registro,
  ele recebe a marcacao '*', indicando que o mesmo
  deve ser ignorado. Para certificar que ele nao
  podera ser mais usado, ele tambem eh deletado
  do Indice Direto e Indireto.
  */
  public void delete(int id){

    long pos = -1;
    T auxObject = null;

    try {

      pos = ld.read(id) - 2;
      if ( pos < 0 ) {
        
        System.err.println("Esse registro não existe ou foi apagado");
      }

      auxObject = read(id);

      ld.delete(id);
      li.delete(auxObject.getSecKey());

      arquive.seek(pos);
      arquive.writeChar('*');
    }
    catch(Exception e) {
      
      System.err.println("Nao foi possivel fazer a leitura do registro");
    }

  }

  //Deleta um registro a partir da chave secundaria
  /*
  Procura pela chave secundaria, se tiver encontrado,
  manda a ID para a funcao "delete(int id)"
  */
  public void delete(String secKey) {

    int pos = -1;

    try {

      pos = li.read(secKey);
    }
    catch (Exception e) {

      System.err.println("Nao foi possivel ler a chave");
    }

    if ( pos >= 0 ) {

      delete((int)pos);
    }
    else {

      System.err.println("Esse registro nao foi encontrado ou foi deletado");
    }
  }

}