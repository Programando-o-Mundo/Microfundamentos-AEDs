import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Exemplo de Classe criada para ser um registro do CRUD, 
 * nesse caso temos um Livro 
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public class Book implements Register {

  private int id;
  private String title;
  private String author;
  private float price;

  public String getTitle() {

    return title;
  }

  public String chaveSecundaria() {

    return title;
  }

  public String getAuthor() {

    return author;
  }

  public float getPrice() {

    return price;
  }

  public int getID() {

    return id;
  }

  public void setID(int id) {

    this.id = id;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public void setAuthor(String author) {

    this.author = author;
  }

  public void setPrice(float price) {

    this.price = price;
  }

  @Override
  public String toString() {
    
    String resp = "Title: " + title + "\n" +
                  "Author: " + author + "\n" +
                  "Price: $" + price + "\n" ;

    return resp;
  }
  public Book(String title, String author,float price) {

    setTitle(title);
    setAuthor(author);
    setPrice(price);
  }

  /**
   * Uma observacao importante antes de usar o CRUD, se voce ler a minha implementacao
   * voce vai perceber que eu uso o Constructor<T> do pacote Reflector, para chamar o construtor
   * dos registros no CRUD, a questao eh que para fazer isso todo registro tambem precisa ter pelo menos
   * um construtor vazio, entao nao esqueca de fazer isso na sua implementacao
   */
  public Book() {

    title = "null";
    author = "unknown";
    price = 0;

  }

  public byte[] toByteArray() throws IOException{

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    DataOutputStream dos = new DataOutputStream(baos);

    dos.writeInt(id);
    dos.writeUTF(title);
    dos.writeUTF(author);
    dos.writeFloat(price);

    return baos.toByteArray();
  }
  public void fromByteArray(byte[] ba) throws IOException{
    
    ByteArrayInputStream bais = new ByteArrayInputStream(ba);
    DataInputStream dis = new DataInputStream(bais);

    setID(dis.readInt());
    setTitle(dis.readUTF());
    setAuthor(dis.readUTF());
    setPrice(dis.readFloat());
  }

  @Override
  public String getSecKey() {
    return title;
  }
}