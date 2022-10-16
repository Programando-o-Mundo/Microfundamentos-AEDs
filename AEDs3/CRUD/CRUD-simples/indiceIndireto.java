import java.io.RandomAccessFile;

/**
 * Classe que implementa um Indice Indireto com lista flexivel
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public class indiceIndireto {

  //Classe Celula para armazenar os dados
  private static class Celula {

      public String nome;
      public int id;
      public Celula prox;
      public boolean deleted;

      public Celula(String nome,int id,char deleted) {

        this.nome = nome;
        this.id = id;
        this.deleted = (deleted == '*') ? true : false;
        prox = new Celula();
      }

      public Celula(String nome,int id) {

        this.nome = nome;
        this.id = id;
        this.deleted = false;
        prox = new Celula();
      }

      public Celula() {

        nome = "";
        id = 0;
        deleted = false;
        prox = null;
      }
  }

  public Celula inicio;

  public indiceIndireto() {

    inicio = new Celula();
  }
  
  public indiceIndireto(String filepath) {

    inicio = new Celula();
    readFile(filepath);

  }

  //Funcao para leitura do arquivo e armazenar todos os registros
  public void readFile(String filepath) {

    long pos = 4;
    int tam = 0;
    int id = 0;
    char deleted = ' ';
    String nome = "";

    try {

      RandomAccessFile r = new RandomAccessFile(filepath,"r");

      while ( pos < r.length() ) {

        r.seek(pos);
        deleted = r.readChar();
        tam = r.readInt();
        id = r.readInt();
        nome = r.readUTF();
        insert(nome,id,deleted);
        pos += tam + 6;
      }

      r.close();
    }
    catch(Exception e) {

      System.err.println("Nao foi possivel ler o arquivo");
      System.exit(1);
    }
  }

  public void insert(String nome,int id,char deleted) {

    Celula tmp = new Celula(nome,id,deleted);
    tmp.prox = inicio.prox;
    inicio.prox = tmp;
    tmp = null;
  }

  public void insert(String nome,int id) {

    Celula tmp = new Celula(nome,id);
    tmp.prox = inicio.prox;
    inicio.prox = tmp;
    tmp = null;
  }

  public int find(String nome) {

    Celula i = null;
    int resp = -1;
    boolean stop = false;
    for (i = inicio.prox; i != null && stop == false ; i = i.prox) {
      
      if ( i.nome.equals(nome)) {

        if (!i.deleted) {

          resp = i.id;
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

  @Override
  public String toString() {
    
    String s = "";

    Celula i = null;
    for(i = inicio.prox; i != null ; i = i.prox) {

      if(!i.deleted) {

        s += "Nome: " + i.nome + "\nid: " + i.id + "\n";
      }
    }

    return s;
  }
}