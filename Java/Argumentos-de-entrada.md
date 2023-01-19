# Argumentos de Entrada

## Você vai aprender

- O que são argumentos de entrada
- Como utilizar eles na linguagem Java

## Pré-Requisitos

- [Strings em Java](../string/String-em-Java.md)

## Argumentos de entrada?

Ao declarar a função **main** do nosso programa em Java, você já deve ter percebido que para a função main precisamos passar 
o parâmetro **String[] args**, esse parâmetro são os nossos argumentos (String) que podem ser passados durante a execução do interpretador
do Java.

Observe o exemplo abaixo:

```java

public class Main {

  public static void main(String[] args) {
    for (String s : args) {
      System.out.println(s);
    }
  }
}

``` 
Neste código temos um laço de repetição **for** onde ele irá iterar por cada String no vetor **args**. Para agora ver isso em ação, precisamos
compilar o código java

```
javac Main.java
```

E então chamar a JVM usando o comando *java*, adicionando os argumentos de entradas da seguinte forma.

```
java Main o rato roeu a roupa do rei de roma.
``` 

Se executarmos esse código, teremos o seguinte resultado.

``` 
o
rato
roeu
a
roupa
do
rei
de
roma
```

# Rediricionamento de entrada

Além disso, podemos direcionar o conteúdo de um arquivo para dentro do Java, usando o sinal "<" depois que chamamos o interpretador.

Observe o exemplo abaixo:

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String entrada = "";

    while ((entrada = br.readLine()) != null) {
      System.out.println(entrada);
    }
  }
}
``` 
Neste exemplo, temos um código java que irá fazer leitura pelo teclado, até encontrar EOF (End of File/Fim de arquivo). Agora iremos redirecionar o
conteúdo de um arquivo para ser lido. Observe o nosso **arquivo.txt** de exemplo abaixo:

```
Rosas são vermelhas
Violetas são azuis
```

Para redirecionar o conteúdo desse arquivo para o nosso código, podemos chamar o interpretador da seguinte forma.

```
java Main < arquivo.txt
```

Dessa forma, teremos o seguinte resultado:

``` 
Rosas são vermelhas
Violetas são azuis
```

# Links úteis

* [String args](https://www.scaler.com/topics/string-args-in-java/)



