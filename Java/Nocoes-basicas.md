# Seja bem vindo ao Java

# Gustavo Lopes Rodrigues

## Você vai aprender

- Conhecendo a linguagem Java
- Como criar sua primeira aplicação java básica

## Pré-Requisitos

- Nenhum

## Porque Java?

Java é uma linguagem de alto nível, baseada em classes, orientada a objetos de propósito geral, desenvolvida originalmente por James Gosling na Sun Microsystems, com a primeira versão sendo lançada em 1995.

Uma das grandes sacadas da linguagem quando foi criada, foi a capacidade de criar aplicações multiplataforma com apenas uma base de código, mas então fica a pergunta: como isso é possível?

## Compilado Vs Interpretado

Para entendermos como o Java funciona, é preciso antes entender o que significa ser uma linguagem compilada e interpretada. 

### Compilando linguagens

Quando uma linguagem é compilada, significa que o texto fonte que produzimos, será traduzido diretamente para código que a máquina consegue entender.

Linguagens puramente compiladas tem a vantagem de serem mais rápidas e eficientes para executar, além de darem maior controle do hardware e da 
memória para o usuário, do que linguagens interpretadas.

Um exemplo bem famoso de linguagem compilada é a linguagem C, confira só esse trecho de código abaixo.

```c
#include<stdio.h>

int main() {
  printf("Hello world!");
  return 0;
}
```

Temos acima um exemplo que provavelmente muitos programadores conhecem, o famoso "Hello world!". Se usarmos o comando **file** no terminal Linux, para saber do que se trata
esse arquivo, teremos o seguinte resultado:
``` 
$ file hello.c
hello.c: C source, ASCII text
``` 
Como podemos perceber esse nosso arquivo .c é nada mais do que um arquivo de texto, até porque o computador não consegue entender diretamente o que as nossas linhas de código
significa. Para isso que temos o compilador, que irá "traduzir" o nosso código, para um formato que a máquina poderá entender

```
$ gcc hello.c -o hello
``` 

Se rodarmos o **file** nesse arquivo compilado, teremos o seguinte resultado:
``` 
$ file hello
hello: hello: ELF 64-bit LSB pie executable, x86-64...
``` 

a sigla ELF significa "Executable and Linkable File" que é um formato muito comum usado para arquivos executáveis. Em outras palavras, este sim é um arquivo que a máquina consegue entender.

Mas porque essa história importa para o Java?

Bem, vamos então para o nosso primeiro programa em Java:

```java
public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world");
  }
}
```
*Obs.: Todos os arquivos Java precisam ter o nome de suas classes principais, nesse caso a nossa classe principal é o Main, logo nosso arquivo se chama "Main.java".*

Podemos perceber que o nosso código do "Hello world" no Java é bem diferente quando comparado ao código do C, mas vamos passo-a-passo que você irá entender.

Como dito anteriormente, Java é uma linguagem baseada em classes, então todos os componentes do nosso programa são classes, inclusive o método principal que será chamado
está dentro de uma classe.
```java
public class Main {
```

Além disso, a nossa classe que será chamada diretamente, precisa ter uma função principal (main) com essa nomenclatura **public static void main(String[] args)**, caso contrário, o nosso programa não será executado.
```java
  public static void main(String[] args) {
```

Por agora, não iremos explicar o que cada palavra significa nessa declaração da main, apenas entenda que essa é a maneira de declara essa função essencial para a execução do código.

Por fim, estamos usando a classe System.out, para imprimir (print) "Hello world!";
```java
    System.out.println("Hello world");
```

Agora que temos um entendimento inicial básico deste código, vamos tentar rodar ele na nossa máquina, assumindo que você já tenha o Java instalado, vamos então compilar 
esse código usando o **javac** que seria o equivalente ao **gcc**.

``` 
$ javac Main.java
``` 
Com isso podemos executar o nosso código, certo? Mais ou menos, se usarmos o comando file para o arquivo gerado pela compilação (Main.class) temos a seguinte resposta:

``` 
$ file Main.java
Main.class: compiled Java class data, version 62.0
``` 

Como pode perceber, o arquivo gerado não foi do tipo ELF, e como esperado, tentar executar esse código apenas irá resultar em erros. Mas eai fica a pergunta, como podemos rodar esse código então? 

### Linguagens interpretadas

Uma linguagem interpretada é aquela que usa de um interpretador para transformar código fonte e converte-lo em código executável. Exemplos famosos de linguagens interpretadas é Python e o Java, que é tanto compilado e interpretado. 

No primeiro passo para rodarmos nosso código, nós compilamos o arquivo "Main.java" para um "Main.class" que contém na verdade um código intermediário chamado Bytecode. O objetivo de fazer 
esse processo é para que o nosso código possa ser otimizado e colocado em um formato que a Java Virtual Machine (JVM) possa compreender.

Essa é a grande ideia do Java, pois o Bytecode gerado pelo **javac** sempre será o mesmo, porém, a JVM será responsável em traduzir esse código intermediário em código de máquina, independente da máquina (desde que a mesma tenha a JVM instalada).

então, se usarmos o comando **java** podemos chamar a JVM para interpretar o nosso Bytecode e efetivamente executar o nosso programa

``` 
$ java Main.java
Hello world!
``` 

