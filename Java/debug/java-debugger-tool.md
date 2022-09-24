# Fazendo debug por terminal usando o JDB

# Gustavo Lopes Rodrigues 

## Você vai aprender

- O que é debug e quais são suas vantagens
- Como usar o JDB para depurar o seu código.
- Principais comandos do JDB 

## Pré-Requisitos

- Noções básicas de Java

## Depuração de código

Debug ou depuração é uma técnica procedural para inspecionar e encontrar erros em programas defeituosos. A maior parte
das linguagens de programação possuem ferramentas de depuração e a linguagem Java não é diferente. Por mais que a linguagem já
seja bem verbosa para indicar erros tanto de execução quanto compilação, saber fazer depuração pode ser uma ferramenta que pode
te economizar tempo., proporcionando o programador a achar os erros de forma mais rápida.

# JDB

O *java debugger* é uma versão da ferramenta de debug por terminal do Java. A linguagem também tem uma versão para debug em
IDE, mas para esta aula, vamos focar em utilizar a versão por linha de comando, pois esta possui suas próprias vantagens.

Para começar a depuração, primeiro precisamos ter um compilado de Java, observe o programa a seguir:
```java
public class Main {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int c = a + b;

        System.out.println("a + b = " + c);
    }
}
```

Temos aqui um simples programa que irá somar dois valores e imprimi-los na tela. Vamos então compilar o nosso programa, passando 
como parâmetro a flag **-g**.
```
javac -g Main.java
```

Essa flag é um parâmetro que precisamos enviar para o compilador, para colocar informações de debug dentro do compilado gerado. Agora, vamos chamar o *jdb*, da seguinte maneira:
```
jdb Main
```

Note que aqui, quando passamos o nome da classe, o jdb irá debuggar o compilado Java (.class). Se tudo der certo, o seu terminal deverá estar assim:

```
$ jdb Main
Initializing jdb ...
> 
``` 

# Executando principais comandos

## run

Agora vamos tentar rodar o nosso programa, para executá-lo, inserimos o 
comando *run*.

``` 
> run
run Main
Set uncaught java.lang.Throwable
Set deferred uncaught java.lang.Throwable
> 
VM Started: a + b = 8

The application exited
```

Percebe-se que o programa executou, detectou algumas instâncias de exceções que não foram colocadas dentro de um throw e depois do print ser executado, a aplicação foi executada com sucesso e foi consequentemente encerrada.

## Breakpoints com "stop in"

Para colocarmos breakpoints em nosso programa, usamos o comando 
*stop in*. Este comando pode ser invocado de várias maneiras, no exemplo abaixo, estamos pedindo o jdb parar na linha **10** da classe **Main**.

```
> stop in Main:10
Deferring breakpoint Main:10.
It will be set after the class is loaded.
```

Agora se executarmos o nosso programa novamente usando o comando *run*, percebe-se
que o programa irá parar a execução na linha que pedimos.

```
> run
run Main
Set uncaught java.lang.Throwable
Set deferred uncaught java.lang.Throwable
> 
VM Started: Set deferred breakpoint Main:10

Breakpoint hit: "thread=main", Main.main(), line=10 bci=4
10            int c = a + b;

main[1]
```

## list

Com este comando, podemos ver o estado atual onde o processo de debug está:

```
main[1] list
6        public static void main(String[] args) {
7            int a = 5;
8            int b = 3;
9    
10 =>         int c = a + b;
11    
12            System.out.println("a + b = " + c);
13        }
14    }
```

Perceba que o resultado colocou as linhas mais próximas e uma seta (=>) o ponto o 
depurador está parado.

## print

Agora que temos uma instância do programa parado na linha 10, podemos imprimir os valores de nossas variáveis instanciadas antes dessa linha, usando o comando *print*.

``` 
main[1] print a
 a = 5
main[1] print b
 b = 3
``` 

Uma observação interessante, é que como paramos o debug na linha onde c será instanciada, então o programa ainda não instanciou a variável de fato. Isso pode ser observado ao imprimirmos a variável em questão.

```
com.sun.tools.example.debug.expr.ParseException: Name unknown: c
 c = null
``` 

Além disso, podemos também chamar funções de variáveis, observe esse segundo exemplo:

```java
public class Main {

    public static void main(String[] args) {
        String test = "Hello world!";
        int a = 5;
        System.out.println(test + a);
    }
}
```

Vamos executar o jdb e parar na linha do print
```
Initializing jdb ...
> stop in Main:6
Deferring breakpoint Main:6.
It will be set after the class is loaded.
> run
run Main
Set uncaught java.lang.Throwable
Set deferred uncaught java.lang.Throwable
> 
VM Started: Set deferred breakpoint Main:6

Breakpoint hit: "thread=main", Main.main(), line=6 bci=5
6            System.out.println(test + a);
```

A String é uma classe com varias funcionalidades, se você já viu a aula de Strings, 
você deve saber que podemos pegar uma parcela da String usando a função **substring**.
Com o jdb, podemos chamar essa função e passar o parâmetro que quisermos.

```
main[1] print test
 test = "Hello world!"
main[1] print test.substring(5)
 test.substring(5) = " world!"
``` 

# step

Mas enfim, voltando ao primeiro exemplo, se quisermos pular uma linha depois do breakpoint, e confirmar o valor da nossa variável "c", usamos o comando *step*.

``` 
main[1] step
> 
Step completed: "thread=main", Main.main(), line=12 bci=8
12            System.out.println("a + b = " + c);
```

Perceba que o comando pulou a linha vazia e foi direto para o próximo comando
que no nosso caso é o nosso print. Aqui, como passamos da linha 10 onde nós declaramos e inicializamos a variável c, agora podemos confirmar o valor que tem dentro de C, que no caso é 8.

```
main[1] print c
 c = 8
``` 

## cont 

Por fim, para ir para o próximo breakpoint do nosso programa, podemos utilizar o comando *cont*. Como no nosso exemplo não colocamos um segundo breakpoint, então o programa apenas irá executar o nosso print e terminar a execução.

```
main[1] cont
> a + b = 8

The application exited
```

Obs.: Se quisermos sair do programa antes da execução finalizar, podemos 
usar o comando **quit**.

# Links úteis

- [Vídeo explicativo do jdb](https://www.youtube.com/watch?v=yUc8ZCO360Q)
- [Veja mais algumas opções do jdb](https://www.tutorialspoint.com/jdb/jdb_breakpoints.htm)
- [Algumas opções mais avançadas do jdb](http://www.cs.iit.edu/~cs115/documents/JDBDebug/JDBDebug.html)
