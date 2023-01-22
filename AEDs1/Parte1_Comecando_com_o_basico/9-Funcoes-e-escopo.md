# Funções e escopo

## Você irá aprender

- O que são funções.
- Como declarar e usar funções.
- Quais são as regras no uso de funções.
- O que é o escopo.

## Pré-requisitos

- [Estruturas de repetição](8-Estruturas-de-repeticao.md)

## Saindo da main

Até então nossos códigos têm sido escrito na função "main", nós também temos usado algumas funções das bibliotecas da linguagem C, como o **printf** e o **scanf**, agora iremos criar nossas próprias funções, e falar um pouco também de escopo.

## O que são funções?

Funções são módulos que podem conter código e executar funções específicas quando chamados. A grande utilidade de trabalhar com funções é poder separar uma lógica repetida várias vezes no código em funções, e então chamar tais funções quando necessárias. 

Pense o seguinte, quando você chama o **printf** obviamente tem várias coisas acontecendo por baixo dos panos, porque se preocupar em como esse conteúdo está sendo impresso na tela, se você pode apenas chamar uma função que já faz esse serviço para você, essa é a grande utilidade das funções.

Com isso dito, vamos então criar nossas próprias funções.

## Criando nossas próprias funções

### Tipo da função

Primeiramente veremos como é a sintaxe para criar uma função, primeiro começamos com o tipo da função, ou seja, que tipo de dado a função irá retornar para nós. Às vezes queremos que uma função retorne o resultado de um cálculo, um booliano indicando que uma operação foi um sucesso, ou simplesmente retornar nada, pois não é necessário retornar nenhum valor. De qualquer forma, é assim que começamos uma função:

```
void
  ^
 tipo da função
```

Aqui nos temos o uso do tipo especial que falamos anteriormente, o tipo "void", que não é usado para criar variáveis, mas sim funções que retornam nenhum valor, ou, como veremos mais para frente, funções que não recebem nenhum argumento.

### Nome da função

Após colocar o tipo precisamos colocar o nome da função. O nome da função segue a mesma convenção dos nomes de variável.

```
void imprima_hello_world
            ^
      nome da função
``` 

### Argumentos e o cabeçalho da função

Até então fizemos a mesma coisa do que criar uma variável, porém é a partir desse ponto que diferenciaremos a sintaxe de uma variável e uma função. Uma variável iria receber um ponto e vírgula agora, ou então uma atribuição seguido de ponto e vírgula, já uma função recebe dois parênteses:

``` 
void imprima_hello_world()
``` 

Dentro dos parênteses, nós colocamos o que chamamos de os **argumentos** da função, ou seja, variáveis que a função precisa receber para manter o seu funcionamento. Nessa função não colocaremos argumentos, por isso usaremos a palavra "void" para indicar que essa função não tem nenhum argumento.

``` 
void imprima_hello_world(void)
``` 

Obs.: Colocar a palavra "void" é opcional, mas é uma otimização para o compilador, por isso estou colocando.

<details>
  <summary>Pílula</summary>
Esses três componentes que falamos até agora, o tipo, o nome e os argumentos, formam o que chamamos de "o cabeçalho da função" já que é a parte que define as propriedades das mesma.
</details>

Mas agora, proponho imaginarmos um cenário alternativo, suponhamos que queremos colocar argumentos, a sintaxe é bem parecida quando estamos declarando uma variável, porém sem colocar o ponto e vírgula. Em outras palavras, para colocar um argumento na função, colocamos o seu tipo, seguido do nome da variável:

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

Por fim, a parte mais importante de uma função, não se esqueça de colocar as chaves, que indicam o escopo da função:

``` 
void imprima_hello_world(void) { <-- começo da função
  printf("hello world!\n");
} <-- fim da função
``` 

Agora, proponho testarmos nossa nova função, colocaremos em um programa e testar. Importante lembrar que para chamar uma função, colocamos o seu cabeçalho, exceto o tipo, ou seja: colocamos o nome da função seguido de parênteses, e dentro colocamos os argumentos que a mesma precisa (se for especificado que a função precisa de argumentos).

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

Obviamente, você não pode chamar funções que não existem, mas a ordem que você coloca funções importa, olhemos o exemplo abaixo:

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
Perceba que é o mesmo código de antes, porém a nossa função **imprima_hello_world** está abaixo da função "main". Teoricamente é a mesma coisa, mas, na prática, se tentarmos compilar esse código, um estranho aviso irá aparecer, dê uma olhada!

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

Esse erro se dá pelo fato que em tempo de execução a nossa função não existe no programa, já que a leitura de algoritmos, e você deve-se lembrar da primeira aula de algoritmos, ela é "Top-down" ou "de cima para baixo". Por conta disso, prefira duas dessas estratégias:

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

Outra estratégia também válida, é declarar o cabeçalho da função.

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
Note que apenas declarando da função antes da main, é o suficiente para retirar o aviso anterior.

## Funções precisam retornar um valor (exceto quando o tipo delas é void)

Você já deve ter visto desde a primeira aula que usamos essa palavra-chave **return**. Essa palavra, como o nome indica, serve para finalizar a função, retornando um valor com o mesmo tipo indicado pela função. Em outras palavras, se o cabeçalho da função indica o retorno de um inteiro, então só podemos retornar inteiros (ou tipos que podem ser implicitamente convertido para int).

```c
#include<stdio.h>

int somar(int a,int b) { 
  return a + b;
} 

int main(void) {
  printf("%d\n", somar(3,5));
  return 0;
}
```

Uma coisa interessante notar no exemplo acima, é que podemos retornar expressões, ou seja, podemos fazer operações junto ao retorno, desde que essas operações impliquem na criação de uma expressão do tipo especificado pela função de retorno.

Obs.: Não é possível colocar instruções depois do retorno, pois como o retorno implica no término da função, estas instruções seram ignoradas durante a execução do código (exceto se o retorno esteja em uma estrutura condicional).

<details>
  <summary>Pílula</summary>
    No caso da função "main", o retorno dela indica que a aplicação fechou com exito ou não, sendo o número 0 indicando que deu tudo certo, e o número 1 que houve algum problema.
</details>

## Escopo

Agora terminaremos essa aula com uma breve discussão sobre escopos. Você deve se lembrar que falamos bastante dessa palavra, na aula de estruturas condicionais e laços de repetição, mas afinal de contas, o que é o escopo? Uma palavra melhor para escopo é visibilidade, pois é isto que estamos tratando: a visibilidade que uma variável ou função tem em um determinado contexto.

Quando criamos uma variável fora de qualquer função chamamos essa variável de global, ou seja, o nosso código inteiro pode ver essa variável e atualizar o seu valor.

```c
#include<stdio.h>

int a = 5;

int main(void) {
  printf("hello %d!\n", a);
  return 0;
}
``` 

Quando criamos a variável em um escopo, dizemos que essa variável é de escopo local, ou seja, ela só pode ser acessada por aquele escopo (seja esse escopo de função, laço de repetição, estrutura condicional, etc.). 

Uma maneira simples de visualizar esse conceito é com o exemplo abaixo:

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

Neste exemplo a nossa variável **a** está dentro da função "main", logo seu escopo de visibilidade é a função "main" e o laço "for" que tem dentro da "main", porém, ela não é visível para a função **imprima_hello_world**. Da mesma forma, a variável "i" do laço "for" está visível apenas no escopo local do "for" se tentarmos imprimir o valor "i" fora do "for" o compilador irá nos jogar um erro.

## Línks úteis

- [Funções em C - Tutorialspoint](https://www.tutorialspoint.com/cprogramming/c_functions.htm)
- [Funções em C - LinguagemMC](http://linguagemc.com.br/funcoes-em-c/)
