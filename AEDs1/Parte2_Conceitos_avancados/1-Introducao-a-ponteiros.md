# Introdução a ponteiros

## Você irá aprender

- O que é um ponteiro.
- Como utilizar ponteiros.

## Pré-requisitos

- [Conceitos básicos](../Parte1_Comecando_com_o_basico/README.md)

## Trabalhando com endereços de memória

Nós já temos uma aula de ponteiros, que você pode dar uma olhada no nosso módulo da linguagem C, porém, está aula é mais para introduzir esse importante conceito que temos quando falamos de linguagens de programação de baixo nível, o ponteiro.

Você provavelmente deve se lembrar quando estávamos falando de linguagens de programação e eu expliquei em como linguagens de programação é uma forma de criar um programa de forma de alto nível, sem ter que falar a linguagem da máquina exata. 

Sim, está definição é correta, tanto que podemos considerar C dependendo do ponto de vista, como uma linguagem de "alto nível" . Entretanto, a linguagem também C pode ser considerada de baixo nível, pois, diferentes de outras linguagens, ela permite um maior controle da memória, por meio de ponteiros e alocação de memória dinâmica.  

Nós não entraremos no mérito de alocação memória dinâmica, e deixaremos um link da seção de utilidades para explicar isso. Por agora, explicaremos o que é um ponteiro e por que utilizar essa funcionalidade.

## O que é um ponteiro?

```mermaid
classDiagram
    class a{
        tipo(int)
        valor: 5
        endereço: 0x7ffdee2c0f94
    }
``` 

Quando criamos qualquer variável na linguagem C, a variável, além de armazenar um valor, também possui um endereço, onde o seu computador armazena esse valor na memória, nós podemos imprimir esse valor utilizando o formatador especial **%p** como no exemplo abaixo.

```c
#include<stdio.h>

int main(void) {
  int a = 5;
  printf("%p\n", &a);
```

Você provavelmente deve se lembrar de quando usamos o **scanf** precisávamos usar esse "&" para poder fazer a leitura do teclado, isso porque quando colocamos esse sinal acompanhado de uma variável estamos pedindo para extrair o endereço de memória dessa variável, criando um ponteiro.

Em outras palavras, um ponteiro é nada mais que uma variável que guarda o endereço de outra variável. E assim como uma variável qualquer podemos criar uma variável ponteiro utilizando o sinal \"\*\" acompanhado do tipo da variável, como no exemplo abaixo:

```c
#include<stdio.h>

int main(void) {
  int a = 5;
  int* p = &a;
  printf("%p\n", p);
```

```mermaid
classDiagram
    class a{
        tipo(int)
        valor: 5
        endereço: 0x7ffdee2c0f94
    }
    class p{
        tipo(int*)
        valor: 0x7ffdee2c0f94
        endereço: 0x9d23ae1c0a52
    }
``` 

Obs.: Importante notar que assim como a variável, o ponteiro também possui um endereço de memória, permitindo que seja assim criado uma cadeia infinita de ponteiros.

Ok, agora temos um ponteiro, mas o que a final de contas podemos fazer com ele? Uma propriedade muito interessante que podemos fazer com isso é que a partir desse ponteiro,, podemos mudar o valor de "a" sem mexer com a variável "a", vamos ver como fazer isso.

## Desreferenciando memória

Como dito anteriormente, quando trabalhamos com ponteiros, nós temos o endereço de memória de uma variável. Podemos acessar o valor desse endereço de memória utilizando o \"\*\", essa ação permite "desreferenciar" o ponteiro, assim acessando o valor, que está guardado no endereço.

```c
#include<stdio.h>

int main(void) {
  int a = 5;
  int* p = &a;
  printf("%d %d\n", *p, a);
```

Utilizando esse conhecimento podemos usar essa mesma sintaxe, para mudar o valor de "a" fazendo uma atribuição ao conteúdo do endereço armazenado em "p" que no nosso caso é o valor de "a".

```c
#include<stdio.h>

int main(void) {
  int a = 5;
  int* p = &a;
  *p = 7;
  printf("%d %d\n", *p, a);
```

Isso nos permite fazer diferentes tipos de operação que antes não era possível, como, por exemplo, retornar mais de um valor em uma função.

### Retornando dois valores de uma função

Tecnicamente falando, você sabe que não existe como retornar dois valores de uma função, porém, a partir de ponteiros, podemos replicar esse comportamento. Pense no seguinte caso de uso, queremos criar um programa que troque o conteúdo de duas variáveis, na função "main" isso é tranquilo e o exemplo abaixo ilustra isso.

```c
#include<stdio.h>

int main(void) {
  int a = 5;
  int c = 3;
  int tmp = a;
  a = c;
  c = tmp;
  printf("a = %d, c = %d\n", a,c);
  return 0;
}
``` 

Apenas utilizando uma variável temporária conseguimos fazer a troca entre dois elementos, mas e se agora, o objetivo é exportar esse comportamento para uma função, ou seja, criar uma função que faça essa troca para gente. A primeira vista, esse problema não tem solução, pois não é possível retornar dois valores, porém usando ponteiros, isso é possível.

```c
#include<stdio.h>

void trocar(int* a, int* c){
  int tmp = *a;
  *a = *c;
  *c = tmp;
}

int main(void) {
  int a = 5;
  int c = 3;
  
  trocar(&a,&c);
  
  printf("a = %d, c = %d\n", a,c);
  return 0;
}
```

Note que passamos para a função ```trocar``` o endereço de "a" e "c" permitindo que dentro de outra função, seja possível trocar os valores de variáveis que estão dentro de outro escopo.

Obs.: Esse processo de passar um valor para outra função usando ponteiros se chama: passar um valor por referência.

## Conclusão

É claro que isso é o mais básico de ponteiros, mas espero que dessa forma vocês tenham entendido o básico em como trabalhar com essa poderosa ferramenta da linguagem C. Caso se tenham interessado no assunto, não se esqueçam de dar uma olhada no nosso material sobre ponteiros no módulo de C.

## Links úteis

- [Ponteiros e Alocação de memória - C](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/blob/main/C/ponteiro/Ponteiro-e-aloca%C3%A7%C3%A3o-de-mem%C3%B3ria.md)
