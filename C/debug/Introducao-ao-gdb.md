# Introdução ao GDB

# Gustavo Lopes Rodrigues

## Você vai aprender

- O que é o GDB.
- Como compilar um programa que será lido pelo GDB.
- Como usar algum dos principais comandos.

## Pré-requisito

- [Introdução a ponteiros em C/C++](../ponteiro/Ponteiro-e-aloca%C3%A7%C3%A3o-de-mem%C3%B3ria.md)
- Ter o GDB Instalado

## O que é o GDB?

GNU Debugger, mais conhecido com o GDB, é uma ferramenta de debugger, ou seja, podemos inspecionar nosso código
com muito mais detalhe e encontrar problemas que não poderiam ser encontrados normalmente.

Por exemplo, muitos programadores ficam frustrados quando aparece o Segmentation Fault, pois é uma mensagem de erro
que não significa muita coisa e não ajuda a dizer onde e porque aconteceu esse erro, é para isso que a ferramenta
do GNU está aqui para nos ajudar.

A ferramenta pode ser usada para fazer debug em várias linguagens, neste caso, vamos usá-la em um 
programa feito na linguagem C.

## Olhando o problema

Primeiro vamos olhar o trecho de código abaixo:

```c
#include<stdio.h>

int main() {

    int *a;
    *a = 5;
    printf("%d\n", *a);
    return 0;
}
```

Ok, agora vamos compilar esse código normalmente, para compilarmos usamos:

```bash
$gcc teste.c
```
ao rodarmos o nosso código recebemos esse erro:
```
Falha de segmentação (imagem do núcleo gravada)
```

Temos aqui um cenário bem comum quando estamos programando na linguagem C, deparamos com um Segmentation Fault, um
erro que acontece quando nosso programa tenta acessar(ler ou escrever) em uma posição ilegal da memória.

Como dito anteriormente, essa mensagem de erro não nos ajuda muito a resolver o nosso problema,
mas não se preocupe, o GDB pode nos auxiliar a resolver a nossa situação

## Preparando o executável para o GDB

Antes de usarmos o GDB, precisamos de usar a diretiva na compilação do nosso programa em C. Antes de mais
nada, você sabe o que é uma diretiva?

<details>
  <summary>Resposta</summary>
  No contexto que estamos, as diretivas de compilação, são opções extras que podemos passar para um compilador,
  na hora de gerar o executável binário do nosso código.
</details>

Neste caso, usaremos a diretiva '-g',  que irá colocar informações de debug no código, baseado nos formatos nativos do
sistema operacional. Em outras palavras, o nosso programa compilado terá informações que poderão ser lidas pelo
GDB, sem isto, não é possível fazer o debug.

Então iremos compilar nosso código da seguinte maneira:
```
$gcc teste.c -g
```
Agora, com o nosso executável pronto, podemos mandá-lo para o GDB, para rodarmos o GDB, usamos o comando"gdb"
mais o nome do nosso executável gerado, logo, o comando será

```
$gdb a.out
```
Observação 1: podemos mudar o nome do nosso executável utilizando a diretiva '-o' e logo em seguida, passar o nome do executável, 
como no exemplo abaixo:
```
$gcc teste.c -o teste -g
```
E então passar para o GDB:
```
gdb teste
```

# Usando o gdb

Se você rodou o comando de execução do GDB corretamente, 
você deve ter caído em uma tela similar a esta

```
GNU gdb (GDB) 11.2
Copyright (C) 2022 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
Type "show copying" and "show warranty" for details.
This GDB was configured as "x86_64-pc-linux-gnu".
Type "show configuration" for configuration details.
For bug reporting instructions, please see:
<https://www.gnu.org/software/gdb/bugs/>.
Find the GDB manual and other documentation resources online at:
    <http://www.gnu.org/software/gdb/documentation/>.

For help, type "help".
Type "apropos word" to search for commands related to "word"...
Reading symbols from a.out...
(gdb) 
```

Não se assuste, seja bem vindo ao GDB. Observe que abaixo de todo esse texto de direitos autorais, temos uma mensagem dizendo

```
Reading symbols from a.out...
```

Isso mostra que o GDB conseguiu ler corretamente o nosso código, e estamos pronto para fazer debug.
Primeiramente vamos aprender a rodar nosso código, para isso utilizamos a palavra chave

```
run
```

Para rodar o código, fazendo isso, conseguimos o seguinte resultado:

```c
(gdb) run
Starting program: /tmp/teste/a.out 
[Thread debugging using libthread_db enabled]
Using host libthread_db library "/usr/lib/libthread_db.so.1".

Program received signal SIGSEGV, Segmentation fault.
0x0000555555555145 in main () at main.c:7
warning: Source file is more recent than executable.
7           printf("%d\n", *a);
```

<details>
  <summary>Pílula</summary>
    Se você estiver rodando algum código, onde existe uma entrada massiva de dados, podemos usar redirecionamento de entrada ,
    junto ao comando run, desta forma:
    ```
    run < pub.in
    ```         
    sendo pub.in o arquivo com a entrada de dados
</details>

Novamente recebemos a mesma mensagem, SIGSEGV é um sinal que sistemas POSIX recebem quando acontece alguma referência inválida a memória
e além disso, o GDB também nos mostra o número e o conteúdo da linha que deu o problema:
  
```
7           printf("%d\n", *a);
```
  
Porém isso ainda não nos ajuda a saber qual é o problema, mas dentro do GDB, temos mais opções, podemos usar o comando
 
```
where
```
  
para montar a pilha de stack, de chamadas das funções e encontrar a sequência de chamadas
que resultou nesse problema.
  
```
(gdb) where
#0  0x0000555555555145 in main () at main.c:7
```
 
Ok, isso não nos ajudou muito, já que não estamos trabalhando com um código bem simples. Talvez o  comando
  
```
break
```
  
possa nos ajudar, este comando irá para pedir ao GDB parar em uma linha de código durante a execução do mesmo,
vamos pedir para ele parar a execução na linha que deu nosso problema, ou seja:
  
```
break 7
```
  
```
(gdb) break 7
Breakpoint 1 at 0x555555555141: file main.c, line 7.
```
  
Pronto, agora vamos executar o nosso programa novamente, usando o comando *run*.
  
```
(gdb) run
The program being debugged has been started already.
Start it from the beginning? (y or n) y
Starting program: /tmp/teste/a.out 
[Thread debugging using libthread_db enabled]
Using host libthread_db library "/usr/lib/libthread_db.so.1".

Breakpoint 1, main () at main.c:7
7           printf("%d\n", *a);
(gdb) 
```

Agora o nosso programa (ainda em execução) está parado na linha que pedimos, em seguida, podemos agora pedir para o GDB
imprimir o valor de uma variável nossa usando o comando
  
```
print
```
 
Acompanhado do nome da variável que queremos imprimir, ou seja:
  
```
print a
```
  
Vamos executar o comando:

```
(gdb) print a
$1 = (int *) 0x555555555040 <_start>
(gdb) print *a
$2 = -98693133
```
  
Imprimindo o valor do ponteiro e da varíavel dentro do ponteiro, e encontramos que a mesma contem lixo de memória,
indicando que a variável não foi iniciada corretamente, encontramos o nosso erro. 
  
Podemos agora sair do GDB, usando o comando.
 
```
quit
```
e corrigir o nosso código
  
```c
#include<stdio.h>
#include<stdlib.h>

int main() {

    int *a = (int*)malloc(sizeof(int));
    *a = 5;
    printf("%d\n", *a);
    return 0;
}
```
  
Observação: dentro do GDB, podemos usar o comando

```
help
```
  
acompanhado de outro comando para saber mais opções em como usar este dentro do GDB. Observe o exemplo abaixo:

```
(gdb) help break
break, brea, bre, br, b
Set breakpoint at specified location.
break [PROBE_MODIFIER] [LOCATION] [thread THREADNUM]
        [-force-condition] [if CONDITION]
PROBE_MODIFIER shall be present if the command is to be placed in a
probe point.  Accepted values are `-probe' (for a generic, automatically
guessed probe type), `-probe-stap' (for a SystemTap probe) or 
`-probe-dtrace' (for a DTrace probe).
LOCATION may be a linespec, address, or explicit location as described
below.

With no LOCATION, uses current execution address of the selected
stack frame.  This is useful for breaking on return to a stack frame.

THREADNUM is the number from "info threads".
CONDITION is a boolean expression.
```
 
### links úteis

[Veja mais tutoriais do GDB](https://www.ic.unicamp.br/~rafael/materiais/gdb.html)

[Tutorial mais avançado de GDB](https://www.cprogramming.com/gdb.html)

