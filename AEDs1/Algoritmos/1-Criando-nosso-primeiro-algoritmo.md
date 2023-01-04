# Criando nosso primeiro algoritmo

# Gustavo Lopes Rodrigues

## Você irá aprender

- Como fazer seu primeiro algoritmo em C
- O que é o GCC
- O que diferencia um arquivo de texto e um executável de máquina

## Pré-requisitos

- O que é um Algoritmo

## Linguagem C

Agora que temos uma noção básica em o quê é um algoritmo e como um funciona, vamos criar o nosso primeiro algoritmo juntos.
Para isso, eu irei usar uma linguagem de programação muito famosa e muito importante para a história da programação chamada C.

Uma importante observação antes de continuar: eu irei ensinar a utilizar a linguagem C no contexto para aprender os conceitos básicos da programação, então teoricamente, você pode usar esses conceitos para aprender toda e qualquer linguagem, já que a grande maioria segue as mesmas ideias. Por mais que esta seja uma linguagem consideravelmente avançada em alguns pontos, acredito que esta ainda seja a mais ideal para começar a ter uma maior familiaridade com os conceitos da Ciência da Computação.

Se você quiser depois dar uma olhada em algumas aulas mais avançadas de C, dê uma olhada no nosso módulo feito especialmente para a linguagem C.

C é uma linguagem de programação de alto nível que foi desenvolvida no início dos anos 1970 por Dennis Ritchie na empresa Bell Labs. Essa linguagem foi projetada para ser de uso geral, portátil e expressiva que pudesse ser usada para uma ampla gama de aplicações.

Uma das principais características do C é por ser uma linguagem muito poderosa, com grande ênfase no controle e na eficiência de baixo nível. Ele fornece vários recursos que permitem aos programadores escrever código próximo ao hardware.

Hoje, C ainda é amplamente utilizado e influenciou o desenvolvimento de muitas outras linguagens de programação. Ele continua sendo uma escolha popular para programação de sistemas e também tem sido usado para uma ampla gama de outras aplicações, incluindo computação científica, finanças e desenvolvimento de jogos.

Vamos então começar a programar em C.

## Nosso primeiro programa

Afins de deixar as aulas mais acessíveis, irei usar um site famoso para criar códigos colaborativos chamado [replit](https://replit.com/).Aqui entre no site, e crie um projeto em branco, pois iremos criar tudo do zero. Se você tiver feito tudo corretamente até aqui, você estará em uma tela parecida com esta:

![image](https://user-images.githubusercontent.com/9157977/210573859-495bf89f-122e-43c8-ac6a-4f3ed5033856.png)

Na esquerda, temos o nosso gerenciador de arquivos, onde todos os nossos arquivos estão atualmente, além de algumas ferramentas e monitor de uso de CPU, RAM e Armazenamento.

![image](https://user-images.githubusercontent.com/9157977/210574142-aabe8368-7da8-46e4-8c50-4cdc6d2d3e21.png)

No centro temos o nosso editor de texto, onde o arquivo que selecionarmos estará aberto para edição nessa seção da janela.

![image](https://user-images.githubusercontent.com/9157977/210574281-57f02f9f-678f-416f-a7a3-0099335d3143.png)

Por fim, na direita, temos a seção do console linux para interagir com a nossa área de trabalho de forma mais avançada.

![image](https://user-images.githubusercontent.com/9157977/210574689-cae7335f-bd11-46ba-b746-b017261de406.png)

Eu irei assumir que você é completamente novo ao mundo Linux, e por isso darei o passo-a-passo nos comandos do Linux, já que este não é o foco da aula. Para criar um novo arquivo na nossa área de trabalho, digite o comando ```touch main.c```, perceba que um novo arquivo foi criado, e este está aberto para edições.

![image](https://user-images.githubusercontent.com/9157977/210575323-ca6c9a3f-657f-4e35-89b1-848588c7ed35.png)

Uma importante observação, a extensão .c é usada é apenas uma convenção para indicar que o nosso arquivo é um arquivo de código-fonte da linguagem C.

Agora que temos o nosso arquivo, vamos criar o nosso programa, por enquanto você irá mais copiar as minhas instruções mesmo, mais tarde entraremos em maior detalhe em como cada coisa funciona. Primeiro inclua no topo do arquivo a instrução
```c
#include <stdio.h>
```
Essa instrução está dizendo para o C incluir a biblioteca "stdio.h" ou "Standard Input Output" que é a biblioteca padrão do C para fazer entrada de saída de dados dentro do programa

Agora, vamos inicializar a nossa função main, que no contexto da maioria das linguagens de programação, é o ponto de partida para o nosso programa:

```c
int main(void) {
}
```

Ótimo, agora vamos preencher a nossa função, com instruções que serão enviados para a máquina, que no caso são duas:

A primeira é para imprimir no terminal a sequência de caractéres "Hello World!\n" e a segunda é para retornar a função com o valor 0;

```c
printf("Hello World!\n");
return 0;
```

Dessa forma chegamos ao nosso programa final que deve ter ficado algo parecido com isso.

```c
#include<stdio.h>

int main(void) {
  printf("Hello World!\n");
  return 0;
}
```
Perfeito, nosso programa está completo, mas como é que executamos o nosso programa? Para isso iremos precisar do GCC ou o [Gnu C Compiler](https://gcc.gnu.org/), este programa é o que chamamos de um Compilador, e é responsável em transformar o nosso código escrito em C, para uma linguagem que a máquina possa entender. 

Para invocarmos o GCC, iremos digitar no console ```gcc main.c```, o resultado será um arquivo chamado "a.out", como pode ser visto na imagem abaixo:

![image](https://user-images.githubusercontent.com/9157977/210578249-3fb34af8-63c9-4e54-afb9-6bcb85f4f05f.png)

Se você tentar abrir o arquivo "a.out" perceberá que este é nada mais do que uma sequência maluca de caracteres, reforçando o que falamos anteriormente:  **linguagens de programação é uma convenção que apenas nós seres humanos entendemos**, enquanto isso, o arquivo gerado pelo GCC é um arquivo que a máquina entende como um arquivo executável. Podemos confirmar isso digitando no console o comando ```file main.c``` onde o console irá exibir que o mesmo é apenas um arquivo de texto, enquanto que ```file a.out``` irá nos mostrar que este é um arquivo ELF (Executable and Linkable File), um tipo de arquivo execútável do Linux.

![image](https://user-images.githubusercontent.com/9157977/210579120-c6fc3ed8-e903-4438-b1ef-af06c7d9483d.png)

Por fim, vamos finalmente rodar o nosso programa, como o que geramos é apenas um executável, podemos digitar ```./a.out``` e dessa forma temos o nosso primeiro programa :)

![image](https://user-images.githubusercontent.com/9157977/210579591-bb8e9e95-b3d4-4170-9e16-b484501ffb11.png)

Isso foi provavelmente bastante informação, então vamos terminar por aqui, até a próxima aula!

## Links úteis

- [Aula completa de AEDs1 - UNIVERSIDADE FERNANDO PESSOA](http://www3.dsi.uminho.pt/iiee/repos/AEDados.pdf)
- [Qual a REAL diferença entre Árquivos Binário e Texto?? - Fabio Akita](https://youtu.be/oSCVb4Ts-G4)
