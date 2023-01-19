# Ponteiros e alocação de memória

## Você vai aprender

- O que é um ponteiro.
- Como utilizar ponteiros.
- Como usar ponteiros como um array.

## Requisitos

- Noções básicas de C.

## O que são ponteiros?

Toda variável criada em C e C++ terá seu valor armazenado em alguma posição da memória, quando falamos em ponteiros, 
estamos falando da variável que guarda um endereço (em hexadecimal) para a memória, onde outro valor está armazenado.

Observe o exemplo abaixo:
```c
#include<stdio.h>

int main() {
    int a = 5;
    printf("%p\n", &a);
    return 0;
}
```

O "&" é utilizado para resgatar o ponteiro de uma variável. Nesse código estamos resgatando o endereço de memória onde "a" está alocado 
e é impresso usando o formatador "%p". Este é um possível resultado:
```
0x7ffd7dbfd094
```
Importante notar que a cada execução desse código, o valor do endereço de "a" será diferente, pois o sistema operacional
irá alocar o primeiro espaço disponível encontrado na memória e, por conta disso, espaço que antes estava disponível pode não estar mais.

```
0x7ffff1fe52e4
0x7ffc4a5d1cd4
0x7ffdee2c0f94
0x7ffc58820844
0x7ffc497717e4
0x7ffd7dbfd094
```
Podemos, também, criar uma variável ponteiro, utilizando essa sintaxe:
```c
#include<stdio.h>

int main() {
    int *a;
    printf("%p\n", a);
    return 0;
}
```

## Passando ponteiros para funções

Observe o trecho de código abaixo:

```c
#include<stdio.h>

int foo(int a) {
    a = 7;
    printf("&a = %p\n", &a);
    printf("a = %d\n\n", a);
}

int main() {
    int a = 5;
    foo(a);
    printf("&a = %p\n", &a);
    printf("a = %d\n", a);
    return 0;
}
```
Quando passamos a variável "a" para a função "foo", a linguagem C irá alocar memória, para criar uma nova variável com o
mesmo valor de "a". O resultado disso é que o ponteiro de ambas variáveis será diferente e logo, qualquer modificação na
variável "a" na função "foo" não afetará a variável "a" na função main.

Podemos confirmar isso, olhando para uma das saídas do programa baixo.
```
&a = 0x7ffca3ba7d0c
a = 7

&a = 0x7ffca3ba7d24
a = 5
```
Porém, podemos usar o "&" para passar o endereço de "a" para a função "foo", permitindo que ambas funções compartilhem
da mesma variável
```c
#include<stdio.h>

int foo(int* a) {
    *a = 7;
    printf("&a = %p\n", a);
    printf("a = %d\n\n", *a);
}

int main() {
    int a = 5;
    foo(&a);
    printf("&a = %p\n", &a);
    printf("a = %d\n", a);
    return 0;
}
```
Importante notar que usamos o asterisco "*" antes da variável "a" na hora de designar o valor da variável. Isso acontece pois estamos
desreferenciado o ponteiro, estamos pedindo para que 7 seja designado ao valor que está armazenado no ponteiro de "a". Este é o resultado:
```
&a = 0x7fff314faeb4
a = 7

&a = 0x7fff314faeb4
a = 7
```
## Alocando memória dinamicamente

Até então, temos usado ponteiros que guardam apenas uma variável, porém, podemos usar ponteiros para guardar uma lista de
elementos, um conceito que também chamamos de arrays

Para fazer essa alocação de memória, iremos usar a função "malloc"(memory allocation) da biblioteca stdlib.h, para reservar
um bloco sequêncial da memória.

Veja o exemplo abaixo:
```c
int* arr = (int*)malloc(sizeof(int)*10);
```
Vamos traduzir o que está acontecendo acima. Primeiro temos que fazer o cast (conversão) para o tipo de ponteiro que queremos, neste
caso queremos o ponteiro de um inteiro (int*), uma vez que a função malloc não tem conhecimento do tipo de variável que queremos usar.
Segundo, precisamos passar para o "malloc" a quantidade em bytes para ser alocado, como estamos precisando de um array de inteiros,
usamos a função sizeof, para achar o tamanho em bytes de um inteiro. Por fim, multiplicamos pelo tamanho que gostariamos que o nosso
array seja (nesse caso é 10).

Em resumo, estamos criando um array com espaço para dez inteiros, todos com valores não iniciados (lixo de memória)

Importante notar que, quando fazemos qualquer tipo de alocação dinâmica, precisamos liberar esse espaço no final do nosso
programa para não ocorrer vazamento de memória.  Para isso, utilizamos a função free(), como no exemplo abaixo:

```c
#include<stdio.h>
#include<stdlib.h>

int main() {

    int* arr = (int*)malloc(sizeof(int)*10);

    printf("%d", arr[2]);

    free(arr);
}
```

### links úteis

- [Aprenda mais sobre alocação dinâmica](https://www.geeksforgeeks.org/dynamic-memory-allocation-in-c-using-malloc-calloc-free-and-realloc/)
- [Aprenda mais aplicações de ponteiros e alocação dinâmica](https://www.ime.usp.br/~pf/algoritmos/aulas/pont.html)
- [Assista um vídeo explicativo sobre ponteiros e alocação dinâmica](https://youtu.be/2ybLD6_2gKM)
- [Aprenda conceitos mais avançados de ponteiros, alocação dinâmica, arrays e aritmética com ponteiros](https://youtu.be/zuegQmMdy8M)



