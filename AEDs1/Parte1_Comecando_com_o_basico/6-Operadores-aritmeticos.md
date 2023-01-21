# Operadores aritmético

## Você vai aprender

- O que são operadores aritméticos.
- Como usar operadores aritméticos.
- 
## Pré-requisitos 

- [Estruturas Condicionais e Operadores relacionais](5-Estruturas-condicionais-e-operadores-relacionais.md)

## Fazendo operações em código

Quando trabalhando variáveis de tipos numéricos, o trabalho de fazer operações entre os números se torna algo muito importante, por conta disso, nessa seção trabalharemos um pouco com operadores aritméticos.

## Operadores aritméticos

Estes são responsáveis em fazer operações matemáticas, como adição, subtração, multiplicação, etc. Em vez de passar por todas as operações uma-por-uma, deixarei abaixo uma tabela com os operadores mais comuns e alguns pequenos exemplos.

| Operador | Responsabilidade | Exemplo |
|---|---|---|
| + | adição | 1 + 1 = 2 |
| - | subtração | 1 - 1 = 0 |
| * | multiplicação | 1 * 3 = 3 |
| / | divisão | 20 / 5 = 4 |
| % | ódulo (ou resto da divisão) | 11 % 2 = 1 |
| -- | incremento | 1++ = 2 |
| ++ | decremento | 1-- = 0 |

Ok, mas como usamos eles em código? Para isso temos duas formas de usar tais operadores.

### Durante uma atribuição ou declaração

A primeira consiste em embutir os nossos operadores, suponhamos que queremos criar uma variável, baseado na soma de duas outras variáveis, para fazer isso, então colocamos dessa forma:

```c
#include<stdio.h>

int main(void) {

    int a = 5;
    int b = 3;
    int c = a + b;
    
    printf("%d\n", c);
    
    return 0;
}
``` 

Note que a ordem na qual as operações são feitas está baseado na mesma ordem de prioridade na matemática, em outras palavras, se você fizer uma operação como ```2+3*4```, sabemos que a operação de multiplicação será feita primeira e depois a soma é efetuada, resultando no número ```14```. Esse mesmo comportamento também acontece em código.

```c
#include<stdio.h>

int main(void) {
    int c = 2 + 3 * 4;
    
    printf("%d\n", c);
    
    return 0;
}
``` 

Porém, caso você queira priorizar algumas operações, então nesse caso fazer a soma antes da multiplicação, podemos usar parênteses, como no exemplo abaixo, onde colocando parênteses entre o 2 e 3, faz com que o resultado da operação seja 20.

```c
#include<stdio.h>

int main(void) {
    int c = (2 + 3) * 4;
    
    printf("%d\n", c);
    
    return 0;
}
```

## Atalho para fazer operação com o próprio número

Proponho pegarmos um dos exemplos lá de trás, como este:

```c
#include<stdio.h>

int main(void) {

    int a = 5;
    int b = 3;
    int c = a + b;
    
    printf("%d\n", c);
    
    return 0;
}
``` 

Agora suponhamos que em vez de colocar o resultado da operação em uma nova variável, queremos colocar na variável "a", por exemplo. Em outras palavras, queremos somar "a" e "b" e colocar o valor dessa operação em "a", a primeira possibilidade que você deve ter pensado seria essa imagino.

```c
#include<stdio.h>

int main(void) {

    int a = 5;
    int b = 3;
    a = a + b;
    
    printf("%d\n", c);
    
    return 0;
}
``` 

Essa versão está correta, porém, existe uma maneira mais simples de indicar essa operação. Quando estamos fazendo uma operação no mesmo operando, podemos usar a seguinte sintaxe, primeiro começamos igual à atribuição, colocando o nome da variável.

```
a
``` 

Depois colocamos o operador da operação que queremos fazer, seguido do sinal de igual "=". Como queremos realizar uma soma, colocamos o sinal de soma.

```
a +=
```

E por fim colocamos à direita do sinal de igual, a expressão que será somada com "a", que neste caso é apenas a variável "b".

```
a += b
``` 

E é assim que o código final fica, sendo que o mesmo resultado é preservado.

```c
#include<stdio.h>

int main(void) {

    int a = 5;
    int b = 3;
    
    a += b;
    
    printf("%d\n", a);
    
    return 0;
}
```

Obs.: Todos os operadores apresentados na tabela acima também podem ser usados, fique a vontade para testar cada um deles no código.

## Incremento e decremento

Você deve ter notado dois operadores diferentes na tabela, incremento e decremento, pois como o nome sugere, ele incrementa ou decrementa o valor de uma variável:

```c
#include<stdio.h>

int main(void) {

    int a = 5;
    
    a++;
    
    printf("%d\n", a); // Valor 6 será imprimido
    
    return 0;
}
```

Uma coisa importante a notar aqui, é que a ordem que você coloca o operador importa, observe o exemplo abaixo:

```c
int a =1; 
int b = a++; // b será igual a 1, a será igual a 2; 
a = 1;
b = ++a; // b será igual a 2, a será igual a 2; 
a = 1;
b = a--; // b será igual a 1, a será igual a 0;
``` 

E por enquanto é isso, agora você sabe como fazer operações aritméticas! Mas agora uma única coisa nos resta: como você calcularia o troco
da padaria do exemplo passado? Fique esse pensamento como lição de casa para vocês, até a próxima!

## Links úteis

- [Operadores e Expressões](https://www.ibm.com/docs/pt-br/tcamfma/6.3.0?topic=tesl-operators-expressions)
- [Operações Matemáticas em C](https://pt.wikibooks.org/wiki/Programar_em_C/Opera%C3%A7%C3%B5es_matem%C3%A1ticas_(B%C3%A1sico)#:~:text=Os%20operadores%20aritm%C3%A9ticos%20b%C3%A1sicos%20s%C3%A3o,(resto%20de%20divis%C3%A3o%20inteira).&text=Note%20que%20uma%20opera%C3%A7%C3%A3o%20entre%20n%C3%BAmeros%20inteiros%20sempre%20retornar%C3%A1%20um%20n%C3%BAmero%20inteiro.)
- [Operadores em C](https://www.inf.ufpr.br/roberto/ci067/02_operad.html)
