import java.io.RandomAccessFile;

/**
 * Classe que implementa um Indice Direto com lista flexivel
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public class indiceDireto {

  //Classe Celula para armazenar os dados
  private static class Celula {

      public int id;
      public long pos;
      public Celula prox;
      public boolean deleted;

      public Celula(int id,long pos,char deleted) {

        this.id = id;
        this.pos = pos;
        this.deleted = (deleted == '*') ? true : false;
        prox = new Celula();
      }

      public Celula(int id,long pos) {

        this.id = id;
        this.pos = pos;
        this.deleted = false;
        prox = new Celula();
      }

      public Celula() {

        id = 0;
        pos = 0;
        deleted = false;
        prox = null;
      }
  }

  public Celula inicio;

  public indiceDireto() {

    inicio = new Celula();
  }
  
  public indiceDireto(String filepath) {

    inicio = new Celula();
    readFile(filepath);

  }

  //Funcao para leitura do arquivo e armazenar todos os registros
  public void readFile(String filepath) {

    long pos = 4;
    int tam = 0;
    int id = 0;
    char deleted = ' ';

    try {

      RandomAccessFile r = new RandomAccessFile(filepath,"r");

      while ( pos < r.length() ) {

        r.seek(pos);
        deleted = r.readChar();
        tam = r.readInt();
        id = r.readInt();
        insert(id,pos + 2,deleted);
        pos += tam + 6;
      }

      r.close();
    }
    catch(Exception e) {

      System.err.println("Nao foi possivel ler o arquivo");
      System.exit(1);
    }
  }

  //Inserir um registro ja deletado
  public void insert(int id,long pos,char deleted) {

    Celula tmp = new Celula(id,pos,deleted);
    tmp.prox = inicio.prox;
    inicio.prox = tmp;
    tmp = null;
  }

  //Inserir um registro nao deletado
  public void insert(int id,long pos) {

    Celula tmp = new Celula(id,pos);
    tmp.prox = inicio.prox;
    inicio.prox = tmp;
    tmp = null;
  }

  //Encontrar um registro e retornar o ID dele
  /*
  Ele faz uma pesquisa linear para encontrar o arquivo
  caso ele tenha encontrado o registro, mas ele esteja
  deletado, ele sera desconsiderado.
  Falha: -1
  Certo: ID
  */
  public long find(int id) {

    Celula i = null;
    long resp = -1;
    boolean stop = false;
    for (i = inicio.prox; i != null && stop == false; i = i.prox) {

      if ( i.id == id) {
        
        if (!i.deleted) {

          resp = i.pos;
        }
        stop = true;
      }
    }
    return resp;

  }

  public void delete(int id) {

    Celula i = null;
    for (i = inicio.prox; i != null && i.id != id; i = i.prox);
    i.deleted = true;

  }

  /*
  
  */
  public void print() {
    Celula i = null;
    for(i = inicio.prox; i != null ; i = i.prox) {

      if(!i.deleted) {

        System.out.println("id: " + i.id + "\npos: " + i.pos);
      }
    }
  }

}