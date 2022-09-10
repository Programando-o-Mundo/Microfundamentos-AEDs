# Tratando exceções com try catch e throws

# Gustavo Lopes Rodrigues 

## Você vai aprender

- O que é uma exceção
- Diferentes modos de tratar uma exceção

## Pré-Requisitos

- Noções básicas de Java

## Exceções em código

Exceções é um evento que acontece durante a execução de um programa, que 
acaba interrompendo o fluxo normal de um código. Uma exceção pode ocorrer por vários motivos. 

Por exemplo, você pode estar tentando acessar o índice de uma String e acontecer isso.

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

```
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: String index out of range: 20
        at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:47)
        at java.base/java.lang.String.charAt(String.java:693)
        at Main.main(Main.java:14)
``` 

O código vai mandar esse erro para o terminal e terminar a execução do programa, sem chegar no 
println. Nesse caso o nosso problema é que não colocamos a chamada da função **charAt** em volta
de um try catch.

Um bloco **try catch** é onde podemos colocar código que potencialmente pode gerar um ou mais erros.

Observe o exemplo abaixo:

```java
public class Main
{
	public static void main(String[] args) {
      String s = "Hello world";
      char c = 'a';
      try {
        c = s.charAt(20); // Impossível, pois "s" tem tamanho 11
      } catch (StringIndexOutOfBoundsException e) {
        e.printStackTrace();
      }
      System.out.println(c);
  }
}
```

Desta vez, nós declaramos um valor inicial para a variável **c**, e colocamos a lógica que chama a função 
dentro do bloco **try**, neste bloco as funções potencialmente perigosas são colocadas, e caso aconteça 
algum erro, o código vai cair no bloco **catch** onde podemos tratar casos onde aconteça um erro.

Perceba que o **catch** funciona como uma função, e recebe um parâmetro, neste caso ele recebe a nossa exceção, que 
pode ser imprimida com mais detalhes chamando a função **printStackTrace()**. 

Se rodarmos esse código, percebe que, por mais que o erro aconteça, a execução chega até o final.

```
java.lang.StringIndexOutOfBoundsException: Index 20 out of bounds for length 11
        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
        at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
        at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
        at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
        at java.base/java.lang.String.checkIndex(String.java:4557)
        at java.base/java.lang.StringLatin1.charAt(StringLatin1.java:46)
        at java.base/java.lang.String.charAt(String.java:1515)
        at Main.main(Main.java:7)
a
```

Uma coisa importante a notar, é que nem toda função que joga uma exceção irá exigir que você trate
da mesma. Você pode utilizar a função **charAt** e nunca precisar colocar um bloco **try catch** para
tratar possíveis erros.

Mas existe casos onde o tratamento de erro é obrigatório, então vamos olhar esse caso, já abordando também
a outra problemática: "Como podemos tratar múltiplas exceções?"

## Multiplas exceções

Fazer exemplo de tratamento de randomaccessfile e parse de int.

## Links úteis
