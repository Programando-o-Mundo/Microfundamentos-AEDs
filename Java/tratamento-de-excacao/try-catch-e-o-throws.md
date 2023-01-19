# Tratando exceções com try catch e throws

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

Considere o seguinte programa.
```java
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static Integer[] lerNumerosDeArquivo(String arqNome) {

        ArrayList<Integer> numeros = new ArrayList<>();

        RandomAccessFile arq = new RandomAccessFile(arqNome, "r");

        String linha = new String();
        int numero = -1;
        while ((linha = arq.readLine()) != null) {

            numero = Integer.parseInt(linha);
            numeros.add(numero);
        }
	
	arq.close();

        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        return array;
    }

    public static void main(String[] args) {

        Integer[] numeros = lerNumerosDeArquivo("arquivo.txt");

        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
}
```

Talvez nem tudo que você acabou de ler, mas o código chama a função **lerNumerosDeArquivo** para extrair das linhas de um arquivo.txt números válidos, que serão colocados 
dentro de um arranjo de inteiros. Por fim, a função **main** irá imprimir cada número um por um.

Se você tentar executar o código acima, você terá varios erros:
```
Unhandled Exception type FileNotFoundException java
Unhandled Exception type IOException java
Unhandled Exception type IOException java
```

Todos essas exceções o Java pede que você trate elas obrigatoriamente em código. Além disso, tem também o **NumberFormatException** que também pode acontecer no código acima
se alguma linha for encontrada que contém um número inválido, porém o Java não obriga o programador a tratar esse problema.

Um jeito de lidar esse problema, seria rodear toda a lógica do programa que pode dar algum erro de exceção, com um **try catch** e adicionar um bloco **catch** para cada exceção:
```java
public class Main {

    public static Integer[] lerNumerosDeArquivo(String arqNome) {

        ArrayList<Integer> numeros = new ArrayList<>();

        try (RandomAccessFile arq = new RandomAccessFile(arqNome, "r")) {
            String linha = new String();
            int numero = -1;
            while ((linha = arq.readLine()) != null) {

                numero = Integer.parseInt(linha);
                numeros.add(numero);
            }

            arq.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } catch(NumberFormatException nf) {
            nf.printStackTrace();
        }

        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        return array;
    }
```
Com isso, o nosso código agora está funcional e trata todos os possíveis erros, porém, agora a nossa função está muito bagunçada. Se quisermos podemos em vez de usar três blocos **catch** podemos colocar só um, e colocando como argumento o objeto Exception, que conseguirá encapsular todas as exceções ja que o mesmo é a classe pai de todas as exceções.

```java
    public static Integer[] lerNumerosDeArquivo(String arqNome) {

        ArrayList<Integer> numeros = new ArrayList<>();

        try (RandomAccessFile arq = new RandomAccessFile(arqNome, "r")) {
            String linha = new String();
            int numero = -1;
            while ((linha = arq.readLine()) != null) {

                numero = Integer.parseInt(linha);
                numeros.add(numero);
            }

            arq.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 

        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        return array;
    }
``` 
Agora sim, a nossa lógica foi simplificada, porém, em troca, perdemos a flexibilidade de poder manejar cada exceção individualmente. Uma outra alternativa, seria fazer com que a função não trate a exceção, mas sim apenas retornar para função que chamou ela, as exceções para serem tratadas.

Observe o exemplo abaixo
```java
public class Main {

    public static Integer[] lerNumerosDeArquivo(String arqNome) throws FileNotFoundException, NumberFormatException, IOException {

        ArrayList<Integer> numeros = new ArrayList<>();

        RandomAccessFile arq = new RandomAccessFile(arqNome, "r");
        String linha = new String();
        int numero = -1;
        while ((linha = arq.readLine()) != null) {

            numero = Integer.parseInt(linha);
            numeros.add(numero);
        }

        arq.close();

        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        return array;
    }

    public static void main(String[] args) {

        Integer[] numeros = lerNumerosDeArquivo("arquivo.txt");

        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
}
```

Usando a palavra *throws* após a declaração da função, é possível jogar qualquer erro lançado pela função para outra. Desta forma, agora toda a lógica de tratamento de exceção foi colocada na função **main** que está chamado a função **lerNumerosArquivos**, aqui nós temos duas opções em como tratar esse problema na **main**, o primeiro seria fazer a função também usar o *throws*, porém desta forma não estaremos realmente tratando a exceção. A melhor forma aqui seria utilizar um **try catch**.

```java
public static void main(String[] args) {

        Integer[] numeros = null;
        try {
            numeros = lerNumerosDeArquivo("arquivo.txt");
        
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.exit(-1);
        } catch(NumberFormatException nf) {
            nf.printStackTrace();
            System.exit(-1);
        }

        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
```

Pronto agora o nosso programa conseguiu tratar as exceções, e também caso dê algum erro, o nosso programa termina a execução, usando o **System.exit(-1);**.

Para finalizar vamos simplificar mais uma vez o código e permitir uma maior flexibidade no nosso programa. Supondo que eu não queira parar a execução do programa caso eu leia um número impossível, em vez da própria main tratar esse problema, podemos jogar a responsabilidade disso para a nossa função **lerNumeroArquivos** uma vez que fazendo isso, irá nos permitir ainda executar o código e imprimir todos os números válidos no arquivo.

```java
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {

    public static Integer[] lerNumerosDeArquivo(String arqNome)
            throws FileNotFoundException, IOException {

        ArrayList<Integer> numeros = new ArrayList<>();

        RandomAccessFile arq = new RandomAccessFile(arqNome, "r");
        String linha = new String();
        int numero = -1;
        while ((linha = arq.readLine()) != null) {

            try {
                numero = Integer.parseInt(linha);
            } catch(NumberFormatException ne) {
                System.err.println("[ERRO!]: " + linha + " não é um número válido!");
                continue;
            }
            
            numeros.add(numero);
        }

        arq.close();

        Integer[] array = new Integer[numeros.size()];
        array = numeros.toArray(array);

        return array;
    }

    public static void main(String[] args) {

        Integer[] numeros = null;
        String nomeArquivo = "arquivo.txt";
        try {
            numeros = lerNumerosDeArquivo(nomeArquivo);
        
        } catch (FileNotFoundException e) {
            System.err.println("[ERRO] " + nomeArquivo + "não existe!");
            System.exit(-1);
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.exit(-1);
        }

        for (Integer num : numeros) {
            System.out.println(num);
        }
    }
}
```

Pronto, acho que por agora está o suficiente ;-) . Agora tente rodar esse código, colocando os números abaixo em um "arquivo.txt"
```
15
32
66
323
Hello
431
6644
832
```

O seu resultado tem que ser algo parecido com isso:
```
[ERRO!]: Hello não é um número válido!
15
32
66
323
431
6644
832
``` 
## Links úteis

[Leia mais sobre Try Catch](https://www.devmedia.com.br/blocos-try-catch/7339)
