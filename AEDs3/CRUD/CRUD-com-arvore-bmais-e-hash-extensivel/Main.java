/*Classe Main para a realizacao de testes*/

public class Main {
  
  public static void main(String[] args) throws NoSuchMethodException{
  
    //Criando o CRUD do tipo 'Book'
    CRUD<Book> Library = new CRUD<>(Book.class.getConstructor(),"teste");

    /*Testando o "Create"*/

    //Criando o objeto "meuLivro" e armazenando ele no CRUD
    Book meuLivro = new Book("Teste1","Gustavo", 37);
    Library.create(meuLivro);
    System.out.println(meuLivro);

    //Criando o objeto "meuLivro2" e armazenando ele no CRUD
    Book meuLivro2 = new Book("Teste2","Lopes",22);
    Library.create(meuLivro2);
    System.out.println(meuLivro2);

    /*Testando os "Read"*/

    //Caso 1: Lendo o objeto de ID '0' do CRUD e 
    //atribuindo ao objeto 'm' do tipo livro
    Book m = Library.read(0);
    System.out.println(m);

    //Caso 2:Lendo o objeto de String 'Teste2' do CRUD e 
    //atribuindo ao objeto 'n' do tipo livro
    Book n = Library.read("Teste2");
    System.out.println(n);

    /*Testando o Update*/

    //Caso 1: Fazendo atualizacao do objeto 'm' no registro
    //Obs: Nesse caso, o novo registro e maior do que o antigo
    m.setTitle("Testando1");
    Library.update(m);
    System.out.println(m);

    //Caso 2: Fazendo atualizacao do objeto 'n' no registro
    //Obs: Nesse caso, o novo registro e menor do que o antigo
    n.setTitle("Test2");
    Library.update(n);
    System.out.println(n);

    /*Testando o delete*/

    //Caso 1: Deletando a partir da ID
    Library.delete(1);

    //Tentando ler o objeto do ID Deletando
    Book del = Library.read(1);

    //Confirmando que o mesmo foi Deletando
    if(del == null) {

      System.out.println("\nDeu certo");
    }
    else {

      System.out.println("\nPois e parceiro, hora de meter 2^10 prints");
    }

    //Caso 2: Deletando a partir da String
    Library.delete(m.getSecKey());

    //Tentando ler o objeto do ID Deletando
    del = Library.read(m.getSecKey());

    //Confirmando que o mesmo foi Deletando
    if(del == null) {

      System.out.println("\nDeu certo");
    }
    else {

      System.out.println("\nPois e parceiro, hora de meter 2^10 prints");
    }

    //Mensagem para ser imprimida caso tudo dê certo
    System.out.println("\nSe voce chegou aqui, entao parabens :D !");


  }
}
