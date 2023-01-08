# Funções e escopo

Até então nós temos trabalhado com código todo escrito na função "main", nós também temos usado algumas funções das bibliotecas da linguagem C, como o **printf** e o **scanf**, agora nós iremos criar nossas próprias funções, e falar um pouco também de escopo.

## O que são funções?

Funções são módulos que podem conter código e executar funções específicas quando chamados. A grande utilidade de trabalhar com funções é poder separar uma lógica que é repetida várias vezes dentro do código em funções, e então chamar tais funções quando necessárias. 

Pense o seguinte, quando você chama o **printf** obviamente tem várias coisas acontecendo por baixo dos panos, porquê se preocupar em como esse conteúdo está sendo imprimido na tela, se você pode apenas chamar uma função que já faz esse serviço para você, essa é a grande utilidade das funções.

Com isso dito, vamos então criar nossas próprias funções

## Criando nossas próprias funções

### Tipo da função

Primeiramente vamos ver como é a sintaxe para criar uma função, primeiro começamos com o tipo da função, ou seja, que tipo de dado a função irá retornar para nós. As vezes queremos que uma função retorne o resultado de um cálculo, um booleano indicando que uma operação foi um sucesso, ou simplesmente retornar nada, pois não é necessário utilizar a função de tornar valores. De qualquer forma, é assim que começamos uma função:

```
void
  ^
 tipo da função
```

Obs.: Apenas para refrescar sua memória, **void** é um tipo especial que usamos, quando a função não retorna nenhum valor

### Nome da função

Após colocar o tipo precisamos colocar o nome da função. O nome da função segue a mesma convenção dos nomes de variável.

```
void imprima_hello_world
            ^
      nome da função
``` 

### Argumentos

Até então nós temos feito a mesma coisa do que criar uma variável, porém é a partir desse ponto que iremos diferenciar a sintaxe de uma variável e uma função. Uma variável iria receber um ponto e vírgula agora, ou então uma atribuição seguido de ponto e vírgula, já uma função recebe dois parénteses:

``` 
void imprima_hello_world()
``` 

Dentro dos parénteses, nós colocamos o que chamamos de os **argumentos** da função, ou seja, variáveis que a função precisa receber para manter o seu funcionamento. Nessa nossa função não iremos colocar argumentos, por isso usaremos a palavra "void" para indicar que essa função não tem nenhum argumento.

``` 
void imprima_hello_world(void)
``` 

Obs.: Colocar a palavra "void" é opcional, mas é uma otimização para o compilador, então por isso estou colocando.

Mas apenas para ilustração, vamos supor que queremos colocar argumentos, a sintaxe é bem parecida quando estamos declarando uma variável, porém sem colocar o ponto e vírgula. Em outras palavras, para colocar um argumento na função, colocamos o seu tipo , seguido do nome da variável:

``` 
void imprima_hello_world(int a1)
                         ^    ^
                       tipo  nome da variável
``` 

Caso a gente queira colocar mais de uma variável, basta usar a mesma sintaxe, lembrando de separar os argumentos das funções com vírgulas:

``` 
void imprima_hello_world(int a1 , char c1)
                                ^
                           separador dos argumentos
``` 

Por fim, a parte mais importante de uma função, não se esqueça de colocar as chaves, que indicam o escopo da função

``` 
void imprima_hello_world(void) { <-- começo da função
  printf("hello world!\n");
} <-- fim da função
``` 

Agora, vamos testar nossa nova função, vamos colocar em um programa e testar, lembrando que para chamar uma função, colocamos o seu nome, parénteses, seguido dos argumentos que a mesma precisa (se for especificado que a mesma precisa de argumentos).

```c
#include<stdio.h>

void imprima_hello_world(void) { 
  printf("hello world!\n");
} 

int main(void) {
  imprima_hello_world();
  return 0;
}
```

Perfeito, agora você sabe como criar funções! Antes de movermos para falar sobre escopo, vamos falar um pouco sobre as regras de produção de funções:

## Regras da produção de funções

### A função precisa existir antes de ser chamada

Obviamente, você não pode chamar funções que não existem, mas a ordem que você coloca funções importa, vamos olhar o exemplo abaixo:

```c
#include<stdio.h>

int main(void) {
  imprima_hello_world();
  return 0;
}

void imprima_hello_world(void) { 
  printf("hello world!\n");
} 
```
Perceba que é o mesmo código de antes, porém a nossa função **imprima_hello_world** está abaixo da função main. Teoricamente é a mesma coisa, mas na prática se tentarmos compilar esse código, um estranho aviso irá aparecer, dê uma olhada!

```
main.c: In function ‘main’:
main.c:4:3: warning: implicit declaration of function ‘imprima_hello_world’ [-Wimplicit-function-declaration]
    4 |   imprima_hello_world();
      |   ^~~~~~~~~~~~~~~~~~~
main.c: At top level:
main.c:7:6: warning: conflicting types for ‘imprima_hello_world’; have ‘void(void)’
    7 | void imprima_hello_world(void) {
      |      ^~~~~~~~~~~~~~~~~~~
main.c:4:3: note: previous implicit declaration of ‘imprima_hello_world’ with type ‘void(void)’
    4 |   imprima_hello_world();
      |   ^~~~~~~~~~~~~~~~~~~
``` 

Esse erro se dâ pelo fato que em tempo de execução a nossa função não existe no programa, já que a leitura de algoritmos, e você deve-se lembrar da primeira aula de algoritmos ela é "Top-down" ou "de cima para baixo". Por conta disso, prefira duas dessas estratégias:

#### Coloque as funções antes do ponto de serem chamadas dentro do programa

O nosso código antes dessa modificada é um perfeito exemplo disso, já que estamos colocando a nossa função antes da main, não teremos esse problema, pois a função já está "declarada".

```c
#include<stdio.h>

void imprima_hello_world(void) { 
  printf("hello world!\n");
} 

int main(void) {
  imprima_hello_world();
  return 0;
}
```

#### Declare funções no início do programa

Outra estratégia também válida, é declarar a função (igual uma variável), e depois você pode colocar onde você quiser.

```c
#include<stdio.h>

void imprima_hello_world(void);

int main(void) {
  imprima_hello_world();
  return 0;
}

void imprima_hello_world(void) { 
  printf("hello world!\n");
} 
```
Note que apenas colocamos o cabeçalho da função antes da main, e só isso é o suficiente para retirar o aviso anterior.

## Escopo

Agora vamos terminar essa aula com uma breve discussão sobre escopos. Você deve se lembrar que falamos bastante dessa palavra, na aula de estruturas condicionais e laços de repitação, mas afinal de contas, o que é o escopo? Uma palavra melhor para escopo é visibilidade, pois é isto que estamos tratando: a visibilidade que uma variável ou função tem dentro de um determinado contexto.

Quando criamos uma variável fora de qualquer função chamamos essa variável de global, ou seja, o nosso código inteiro pode ver essa variável e atualizar o seu valor.

```c
#include<stdio.h>

int a = 5;

int main(void) {
  printf("hello %d!\n", a);
  return 0;
}
``` 

Quando criamos a variável dentro de um escopo, chamamos essa variável de local, ou seja, ela só pode ser acessada por aquele escopo (seja esse escopo de função, laço de repetição, estrutura condicional, e etc), e por escopos que estão dentros desse mesmo escopo, mas não por escopos de fora, veja o exemplo abaixo:

```c
#include<stdio.h>

void imprima_hello_world(void) { 
  printf("hello %d!\n", a);
} 

int main(void) {
  int a = 5;
  printf("hello %d!\n", a);
  
  for (int i = 0; i < 10; i++) {
    printf("%d + %d = %d", i, a, i+a);
  }
  
  printf("%d", i;
  return 0;
}
```

Neste exemplo a nossa variável **a** está dentro da função main, logo seu escopo de visibilidade é a função main e o laço for que tem dentro da main, porém, ela não é visível para a função **imprima_hello_world**. Da mesma forma, o "i" do laço for está apenas dentro do escopo local do "for" se tentarmos imprimir o valor "i" fora do "for" o compilador irá nos jogar um erro.

## Línks úteis


