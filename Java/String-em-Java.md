# Criando e manipulando Strings em Java

# Gustavo Lopes Rodrigues 

## Você vai aprender

- Tipo String em Java
- Como criar uma String
- Manipulação básica de seus caracteres

## Pré-Requisitos

- Noções básicas de Java

## Strings em Java

String é um tipo de dado usado para representar uma cadeia de caracteres. Praticamente, todas
as linguagens de programação modernas possuem a String implementado, e a linguagem Java é delas.
Por conta disso, diferente de C, por exemplo, aqui já temos tudo pronto na 
palma das mãos (ou nesse caso no nosso editor de código).

## Criando uma string

Para criar uma String, é só declaramos o tipo como qualquer outra variável.

```java
public class Main {

  public static void main(String[] args) {
    String s = "Hello World";
    System.out.println(s);
  }
}
```

Assim como qualquer outro objeto em Java, podemos também criar uma String chamando o seu construtor.

```java
public class Main {

  public static void main(String[] args) {
    String s = new String("Hello world");
    System.out.println(s);
  }
}
```
Tem vários outras maneiras em como podemos iniciar uma String em Java. Mas deixarei esses exemplos para
vocês olharem na documentação oficial da Oracle, que estará na seção de links úteis dessa aula ;-).

Por agora, você entendeu que é simples e prático instanciar uma String, agora como podemos manipular a mesma?

## Acessar um caractere e o tamanho de uma String

As duas funções mais básicas são respectivamente a:

* **charAt()** para acessar um caractere (char) em uma determinada posição da String. 

```java
public class Main {

  public static void main(String[] args) {
    String s = "Hello world";
    char c = s.charAt(6); // sexto caractere da String é o "w"
    System.out.println(c);
  }
}
```

Uma observação importante, é que a função **charAt()** apenas retorna para nós um caractere que está na 
posição indicada, isso significa que não conseguimos usar essa função para mudar um caractere da String.

Além disso, se tentarmos colocar uma posição fora do índice da String, o Java irá nos retornar uma exceção (Exception), chamada
**StringIndexOutOfBoundsException**.

```java
public class Main
{
	public static void main(String[] args) {
      String s = "Hello world";
      char c = s.charAt(20); // Impossível, pois "s" tem tamanho 11
      System.out.println(c);
  }
}
```

Ao tentarmos rodar esse código, teremos a seguinte mensagem:
```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 20
        at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
        at java.base/java.lang.String.charAt(String.java:693)
        at Main.main(Main.java:14)
``` 

Nesse momento não iremos fazer tratamento de exceção, deixaremos isso para uma aula futura, apenas entenda que ao utilizar
essa função, certos cuidados são necessários para não causarmos um erro.

* **length()** para conseguir o tamanho de uma String.
```java

public class Main {

  public static void main(String[] args) {
    String s = "Hello world"
    System.out.println(s.length());
  }
}
```

Importante notar, que essa função retornar o tamanho igual a unidades de unicode, o que evita a maior parte dos problemas com Charset.

### links úteis

[Documentação-oficial-sobre-a-String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
