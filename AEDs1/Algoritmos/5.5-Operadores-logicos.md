# Operadores lógicos

# Gustavo Lopes Rodrigues

## Você vai aprender

- O que são operadores lógicos
- Quais são e como usar

## Pré-requisitos

- Aulas anteriores

## Definição

Operações lógicas são aquelas que trabalham sobre valores booleanos, ou seja, operadores lógicos são operadores que servem para fazer operações em expressões booleanas. Para deixar isso mais claro, vamos lembrar das operações que fizemos quando estavamos calculando o troco da padaria:

```c
#include<stdio.h>
#include<stdbool.h>

int main(void) {

  bool falhou_a_compra = false;
  
  float dinheiro_cliente = 50;
  float total_compras = 20;
  
  if(dinheiro_cliente == total_compras) {
    printf("A compra foi um sucesso!\n");
  } else if (dinheiro_cliente > total_compras) {
    float troco = 0;
    printf("A compra foi um sucesso, seu troco foi de R$%g reais!\n", troco);
  } else {
    printf("Erro! Dinheiro insuficiente!\n");
    falhou_a_compra = true;
  }
  
  return falhou_a_compra ;
}
```

Quando fazemos as operações ```dinheiro_cliente == total_compras``` e ```dinheiro_cliente > total_compras```, essa operações implicitamente implicam que uma expressão booleano é gerada, e, ao trabalhar com operadores lógicos, nós utilizamos essas expressões ou até mesmo variáveis booleanas, para criar as operações lógicas. Operadores lógicos podem ser usadas em estruturas condicionais ou até mesmo em estruturas de repetições (que ainda chegaremos lá).

Por agora, vamos ver quais são os operadores lógicos, além de ver alguns exemplos.

## AND ( && )

O operador AND recebe duas ou mais expressões booleanas e retorna verdadeiro **se e somente se** ambas expressões forem verdadeiras. Por exemplo:

```c
int x = 5;
int y = 10;
if (x > 0 && y > 0) {
    // ambos x e y são maiores que 0
    // Este bloco será executado
}
```

## OR ( || )

O operador OR recebe duas ou mais expressões booleanas e retorna verdadeiro se pelo menos uma das expressões forem verdadeira. Por exemplo:

```c
int x = -5;
int y = 10;
if (x > 0 || y > 0) {
    // ou x ou y ou ambos são maiores que 0
    // Este bloco será executado
}
``` 

## NOT ( ! )

O operador NOT pega um único operando booleano e retorna o valor oposto. Por exemplo:

```c
bool eh_verdadeiro = false;
if (!eh_verdadeiro) {
    // O operador NOT irá inverter o valor false, o inverso de false é verdadeiro
    // este bloco será executado
}
```

Vale ressaltar que, assim como nos operadores aritméticos, os operadores lógicos costumam ter uma ordem de precedência e uma sequência lógica de avaliação das operações. O operador NOT tem a precedência mais alta, seguido pelo operador AND e pelo operador OR. Porém, em algumas situações, também é possível agrupar as operações utilizando parênteses para indicar a ordem de avaliação.

## Línks uteis

- [Operadores lógicos em C](http://linguagemc.com.br/operadores-logicos-em-c/#:~:text=Os%20operadores%20l%C3%B3gicos%20s%C3%A3o%20utilizados,condi%C3%A7%C3%B5es%20simples%20em%20express%C3%B5es%20l%C3%B3gicas.)
- [Leia mais sobre todos os operadores em C](https://www.inf.ufpr.br/roberto/ci067/02_operad.html)
