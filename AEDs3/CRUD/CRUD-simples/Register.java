import java.io.IOException;  

/**
 * Interface usada pelo registro
 * Para que o usuário use o CRUD, todo objeto T 
 * precisa implementar essas funcoes para que seja 
 * um objeto válido para ser armazenado
 * @author Gustavo Lopes Rodrigues
 * @version 1.0
 */
public interface Register{

  public int getID();
  public void setID(int id);
  public String getSecKey();  //Criado para poder fazer o read(String secKey)

  /**
   * Transforma todo o conteudo de uma classe que implementa o registro
   * em um array de bytes para que possa ser inserido pelo CRUD no arquivo
   * externo
   * @return Array de bytes
   * @throws IOException
   */
  public byte[] toByteArray() throws IOException;

  /**
   * A partir do byte array lido pelo CRUD, ler dados do byte array para dentro
   * da classe.
   * @param ba
   * @throws IOException
   */
  public void fromByteArray(byte[] ba) throws IOException;
}