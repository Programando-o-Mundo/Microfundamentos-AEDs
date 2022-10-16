public class Main {
  
  public static void main(String[] args) throws NoSuchMethodException{
  
    CRUD<Book> Library = new CRUD<>(Book.class.getConstructor(),"teste");

    Book meuLivro = new Book("Teste1","Gustavo", 37);
    Library.create(meuLivro);
    System.out.println(meuLivro);

    Book meuLivro2 = new Book("Teste2","Lopes",22);
    Library.create(meuLivro2);
    System.out.println(meuLivro2);

    meuLivro2.setAuthor("Rodrigues");
    Library.update(meuLivro2);

    Book m = Library.read(0);
    System.out.println(m);

    Book n = Library.read("Teste2");
    System.out.println(n);

    System.out.println("INDICE DIRETO");
    Library.printIndiceDireto();
     System.out.println("INDICE INDIRETO");
    Library.printIndiceIndireto();

    Library.delete(0);

    System.out.println("INDICE DIRETO");
    Library.printIndiceDireto();
    System.out.println("INDICE INDIRETO");
    Library.printIndiceIndireto();
  }
}
