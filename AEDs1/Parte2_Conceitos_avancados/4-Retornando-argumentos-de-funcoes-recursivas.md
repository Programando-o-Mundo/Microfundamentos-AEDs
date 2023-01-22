# Retornando argumentos de funções recursivas

## Você vai aprender

- Como retornar dados de funções recursivas.
- Uma melhor maneira de visualizar recursão.

## Pré-requisitos

- [Básico de recursão](3-Entendendo-recursao.md)

## Dando um passo adiante

Agora que temos uma compreensão básica em como recursão funciona, exploraremos mais alguns exemplos e ver como podemos usar a recursão para retornar uma resposta, ou no nosso exemplo a seguir, um valor.

## Soma de elementos de um array

Supondo que queremos criar um programa que leia os números de um array e imprima na tela a soma de todos os elementos, como você resolveria esse problema? Começaremos colocando aqui a base do nosso programa:

```c
#include<stdio.h>

int main(void) {
  int soma = 0;
  int n = 7;
  int array[] = {5, 9, 2, 13, 63, 3, 21};
  
  // somar os elementos
  
  printf("A soma dos elementos do array é igual a %d\n", soma);
  return 0;
}
``` 

Esse é o nosso programa base, temos um array com sete elementos e queremos imprimir a soma de todos, a primeira coisa que muitos devem ter pensado é usar uma estrutura de repetição, um for loop, por exemplo:

```c
#include<stdio.h>

int main(void) {
  int soma = 0;
  int n = 7;
  int array[] = {5, 9, 2,13,63,3,21};
  
  for(int i = 0; i < n; i++) {
    soma += array[i];
  }
  
  printf("A soma dos elementos do array é igual a %d\n", soma);
  return 0;
}
}
``` 

Uma dica muito importante quando trabalhamos com recursão. Se está muito difícil enxergar a solução, tente fazer ela iterativamente primeiro, às vezes pode ser mais fácil.

Agora que temos a nossa solução iterativa, proponho transformarmos isso em uma solução recursiva. Primeiramente criaremos as nossas duas funções ```somar``` e ```somar_rec```.

```c
#include<stdio.h>

int somar_rec(int array[], int n, int i) {

}

int somar(int array[], int n) {
    int i = 0;
    return somar_rec(array, n, i);
}

int main(void) {

  int n = 7;
  int array[] = {5, 9, 2,13,63,3,21};
  
  int soma = somar(array,n);
  
  printf("A soma dos elementos do array é igual a %d\n", soma);
  return 0;
}
```

Você deve se lembrar da nossa primeira aula, mas criamos essa primeira função ```somar``` apenas para sera interface da nossa função recursiva ```somar_rec``` e iniciar os atributos importantes da recursão, nesse caso sendo o nosso ```index``` i. 

Além disso, para que a função funcione, precisamos de acesso a duas coisas: o nosso array que queremos somar, e ```n``` que é o seu tamanho. Lembre-se, nós também utilizamos todos esses atributos na solução iterativa.

Note também que as nossas funções retornam um inteiro, já que no final do processo precisamos saber o resultado da soma.

Agora vamos então implementar o restante da lógica.

```c
#include<stdio.h>

int somar_rec(int array[], int n, int i) {

    int soma = 0;

    if (i < n) {
        soma += array[i];
        soma += somar_rec(array, n, ++i);
    }

    return soma;
}

int somar(int array[], int n) {
    int i = 0;
    return somar_rec(array, n, i);
}

int main(void) {
  int soma = 0;
  int n = 7;
  int array[] = {5, 9, 2,13,63,3,21};
  
  int soma = somar(array,n);
  
  printf("A soma dos elementos do array é igual a %d\n", soma);
  return 0;
}
``` 

Note que a nossa solução é bem parecida com o nosso primeiro algoritmo recursivo, e a outra parte lembra a nossa solução iterativa, mas vamos parte por parte em como que o nosso código chega na solução a partir dessa implementação recursiva.

## Empilhando a nossa solução

Vamos então começar na primeira chamada a função ```somar_rec```, sendo assim, estamos na nossa primeira chamada da função recursiva, sendo o valor de "i" igual a zero.

```c
// array[] = {5, 9, 2,13,63,3,21}
// n = 7
// i = 0
int somar_rec(int array[], int n, int i) {
``` 

Entrando na função, iremos então criar a variável ```soma``` e iniciar ela com o valor zero. E então verificaremos a condição se "i" é menor que "n", que neste caso é, já que 0 é menor que 7.

```c
    int soma = 0;

    if (i < n) { // 0 é menor que 7
        soma += array[i];
        soma += somar_rec(array, n, ++i);
    }
```

Como a condição é verdadeira, nós iremos entrar no "if" e iremos somar o conteúdo do índice de "i" do array, com a variável soma. Como o índice é igual a zero então estamos somando o primeiro elemento com a variável soma.

```c
    if (i < n) { // 0 é menor que 7
        soma += array[i]; // 0 + array[0] --> 0 + 5 --> 5
        soma += somar_rec(array, n, ++i);
    }
```

Agora, somaremos a variável "soma" com o resultado da próxima iteração da recursão, já que estamos somando o nosso índice com +1. E então a execução vai para a função chamada e a função atual irá parar a execução até que a chamada seja concluída.

```c
        soma += somar_rec(array, n, ++i);
```

Em outras palavras, enquanto a linha de cima não for concluída, o resto da função não será executado, então salvaremos o valor dessa chamada do ```somar_rec``` e ir para a próxima chamada. Então por enquanto este é o estado atual da recursão:

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

A próxima chamada da recursão seguirá uma ideia bem parecida, com a única diferença sendo o "i" igual a 1.

```c
// array[] = {5, 9, 2,13,63,3,21}
// n = 7
// i = i
int somar_rec(int array[], int n, int i) {

    int soma = 0;

    if (i < n) { // 1 eh menor que 7
        soma += array[i]; // 0 + array[0] --> 0 + 9 --> 9
        soma += somar_rec(array, n, ++i);
    }

    return soma;
}
```

E então quando chegarmos nessa linha novamente:

```c
soma += somar_rec(array, n, ++i);
```
O programa irá fazer o mesmo processo, ele irá salvar esse estado da função e ir para a próxima iteração:

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

Acredito que a essa altura você deve ter notado como que esse padrão funciona, a função recursiva ela empilha funções e os seus estados, com o valor da variável soma sendo um dos elementos do array. Mas, quando é que ela finalmente parará de empilhar? Bem proponho pularmos as iterações e ir direto para o estado final.

Antes do estado final, nossa pilha ficará assim, deixarei ela aqui para que você note o padrão de como a recursão tem funcionado.

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 6 | 21 |
| {5, 9, 2,13,63,3,21} | 7 | 5 | 3 |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

Agora estamos na iteração onde o valor de "i" é 7 e perceba que agora algo diferente irá acontecer, em vez do programa entrar no laço "if" ele irá pular ele, e ir direto para a instrução de retornar enfim retornando o valor zero.

```c
// array[] = {5, 9, 2,13,63,3,21}
// n = 7
// i = 7
int somar_rec(int array[], int n, int i) {

    int soma = 0;

    if (i < n) { // 7 nao eh menor que 7
        soma += array[i];
        soma += somar_rec(array, n, ++i);
    }

    return soma; // o retorno finalmente e chamado
}
```
| array | n | i | soma |
|---|---|---|---|
| {5, 9, 2,13,63,3,21} | 7 | 7 | 0 |
| {5, 9, 2,13,63,3,21} | 7 | 6 | 21 |
| {5, 9, 2,13,63,3,21} | 7 | 5 | 3 |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

"Mas perai, mas a soma não é igual a zero!", e você está correto, só que em vez de voltar para a função "somar" ele irá retornar para a chamada anterior, que foi a sexta chamada da função ```somar_rec```onde o valor de "i" é igual a 6.

Nossa pilha de chamadas está assim:

| array | n | i | soma |
|---|---|---|---|
| {5, 9, 2,13,63,3,21} | 7 | 7 | 0 |
| {5, 9, 2,13,63,3,21} | 7 | 6 | 21 |
| {5, 9, 2,13,63,3,21} | 7 | 5 | 3 |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

Após chegar ao retorno, agora ela está assim:

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 6 | 21 + 0 |
| {5, 9, 2,13,63,3,21} | 7 | 5 | 3 |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

E então retornamos novamente para aquela linha:
```c
        soma += somar_rec(array, n, ++i);
}
```

Se olharmos na tabela, o resultado da variável soma até então era 21, porém como a última chamada retornou com zero, quer dizer que agora fazemos 21 + 0 que é 21.
```c
        soma += somar_rec(array, n, ++i); // 21 + 0 --> 21
}
```

E então novamente, igual à última chamada, saímos do laço "if" e chegamos na instrução de retorno, dessa vez retornando 21.

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 5 | 3 + 21 |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

Percebe o que está acontecendo? Estamos voltando em todas as chamadas, efetuando as somas uma por uma, porém de trás para frente. Esse é o comportamento de uma pilha, onde o último elemento colocado nela é o primeiro a ser chamado. No nosso caso começamos com o último elemento do array e vamos somando do último até o primeiro.

| array | n | i | soma |
|---|---|---|---|
|  |  |  |  |
|  |  |  |  |
|  |  |  |  |
| {5, 9, 2,13,63,3,21} | 7 | 4 | 63 + 23 |
| {5, 9, 2,13,63,3,21} | 7 | 3 | 13 |
| {5, 9, 2,13,63,3,21} | 7 | 2 | 2 |
| {5, 9, 2,13,63,3,21} | 7 | 1 | 9 |
| {5, 9, 2,13,63,3,21} | 7 | 0 | 5 |

E assim por diante, eu poderia colocar as outras tabelas, mas acho que vocês tenham entendido, nós somaremos os números de trás para frente, até voltar para a chamada onde o "i" era igual a 0. Então o que irá acontecer depois disso? Bem, antes da primeira chamada de ```somar_rec``` era a nossa função ```somar``` então o valor e então retornada para ela, que depois é então retornado para a main e imprimido na tela.

```
A soma dos elementos do array é igual a 116
```

## Links úteis

- [Recursion in C](https://www.youtube.com/watch?v=kepBmgvWNDw)
- [Recursion in 100 seconds](https://www.youtube.com/watch?v=rf60MejMz3E)
