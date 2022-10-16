import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;

/**
 * Classe do CRUD
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public class CRUD<T extends Register> {

  //Dados do meu CRUD
  private Constructor<T> constructor;
  private RandomAccessFile arquive;

  //Indices Direto e Indireto armazenado em uma lista flexivel
  private indiceDireto ld;      
  private indiceIndireto li;

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

      arquive = new RandomAccessFile("data/" + filepath + ".dat", "rw");
    }
    catch(FileNotFoundException fnfe) {
      
      System.err.println("Impossivel abrir o arquivo " + filepath);
    }

    //Escrita da ID na primeira linha(caso o arquivo esteja vazio)
    try { 

      //Se o arquivo estiver vazio
      if (arquive.length() <= 0) {

        arquive.writeInt(0);
        ld = new indiceDireto();
        li = new indiceIndireto();
      }
      else {
        
        //Se o arquivo nao estiver vazio, resgatar os registros presentes
        ld = new indiceDireto("data/" + filepath + ".dat");
        li = new indiceIndireto("data/" + filepath + ".dat");
      }
    }
    catch(IOException e) {

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

      arquive.writeChar(' ');               //Esse espaco vazio eh a lapide
      pos = arquive.getFilePointer();
      arquive.writeInt(objectData.length);
      arquive.write(objectData);

      ld.insert(id,pos);
      li.insert(object.getSecKey(),id);

      arquive.seek(0);
      arquive.writeInt(id+1);
    }
    catch (IOException e) {

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

      pos = ld.find(id);
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

    int id = li.find(secKey);
    T object = null;
    if ( id >= 0 ) {

      object = read(id);
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
  tem o mesmo tamanho do antigo objeto.
  */
  public boolean update(T object){

    boolean resp = false;

    int id = object.getID();
    long pos = ld.find(id);
    int tam = 0;
    byte[] objectData;

    if (pos < 0 ) {

      System.err.println("Erro, objeto não existe ou foi deletado");
      resp = false;
    }
    else {

      try {

        objectData = object.toByteArray();  

        arquive.seek(pos);
        tam = arquive.readInt();

        if ( objectData.length <= tam) {
          arquive.write(objectData);
          resp = true;
        } else {
          delete(object.getID());
          create(object);
        }

      }
      catch(Exception e) {
        
         System.err.println("Erro ao atualizar o objeto no arquivo.");
      }
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

    try {

      pos = ld.find(id) - 2;
      if ( pos < 0 ) {
        
        System.err.println("Esse registro não existe ou foi apagado");
      }
      arquive.seek(pos);
      arquive.writeChar('*');
      ld.delete(id);
      li.delete(id);
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

    int pos = li.find(secKey);
    if ( pos >= 0 ) {

      delete((int)pos);
    }
    else {

      System.err.println("Esse registro nao foi encontrado ou foi deletado");
    }
  }

  /*
  Funcoes para imprimir o IndiceDireto e Indireto do CRUD
  */
  public void printIndiceDireto() {

    System.out.println(ld);
  }

  public void printIndiceIndireto() {

    System.out.println(li);
  }

}