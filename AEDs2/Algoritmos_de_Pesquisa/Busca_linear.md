# Algoritmo de Busca Linear

## Você vai aprender

- O que é o algoritmo de busca linear
- Como o algoritmo funciona
- Qual sua complexidade
- Implementação do algoritmo em C e Java

## Pré-requisitos

- Entendimento do tópico de complexidade

## Definição

O algoritmo de busca (ou pesquisa) linear, também conhecido como busca sequencial, é um método simples e direto de pesquisar um elemento em uma coleção 
de dados. Esse algoritmo percorre cada elemento da coleção um por um até que o elemento desejado seja encontrado ou até que a coleção seja totalmente 
percorrida.

## Funcionamento

O funcionamento do algoritmo de busca linear pode ser resumido em quatro etapas:

- Inicialmente, é necessário definir o elemento que se deseja buscar na coleção.

- Em seguida, percorre-se cada elemento da coleção, um por um, e compara-se com o elemento buscado.

- Caso o elemento buscado seja encontrado, o algoritmo retorna a posição em que ele foi encontrado.

- Caso contrário, o algoritmo retorna um valor indicando que o elemento não foi encontrado na coleção.

## Complexidade

No caso dos algoritmos de pesquisa, a complexidade de tempo pode variar dependendo do número de elementos na coleção e da posição em que o 
elemento desejado se encontra. No caso da busca linear, o pior caso ocorre quando o elemento desejado não está presente na coleção ou no final da lista, 
pois será necessário percorrer todos os elementos da coleção antes de concluir que o elemento não está presente. Nesse caso, a complexidade de 
tempo é O(n), em que n é o número de elementos na coleção. Já o melhor caso ocorre quando o elemento desejado é encontrado na primeira posição 
da coleção, e a complexidade de tempo é O(1).

Quanto à complexidade de espaço, os algoritmos de pesquisa geralmente têm complexidade constante, pois o espaço necessário para armazenar a 
coleção não depende do tamanho da entrada. No entanto, em alguns casos, é necessário utilizar variáveis adicionais para controlar o processo 
de busca, e nesses casos a complexidade de espaço pode ser maior.

## Exemplo de código

A seguir, apresento um exemplo de implementação do algoritmo de busca linear em C:

```c
#include <stdio.h>

int buscaLinear(int vetor[], int tamanho, int elemento) {
    int i;
    for (i = 0; i < tamanho; i++) {
        if (vetor[i] == elemento) {
            return i; // retorna a posição em que o elemento foi encontrado
        }
    }
    return -1; // retorna -1 caso o elemento não seja encontrado
}

int main() {
    int vetor[] = {5, 2, 9, 7, 3};
    int tamanho = 5;
    int elementoBuscado = 7;
    int posicao = buscaLinear(vetor, tamanho, elementoBuscado);
    if (posicao == -1) {
        printf("Elemento nao encontrado na colecao\n");
    } else {
        printf("Elemento encontrado na posicao %d\n", posicao);
    }
    return 0;
}
```

Neste exemplo, a função buscaLinear recebe como argumentos um vetor de inteiros, seu tamanho e o elemento que se deseja buscar na coleção. Em seguida, 
o algoritmo percorre cada elemento do vetor comparando-o com o elemento buscado. Caso o elemento seja encontrado, a função retorna a posição em que ele 
foi encontrado. Caso contrário, a função retorna -1.

No main, é criado um vetor de inteiros, definido o tamanho da coleção, o elemento que se deseja buscar e chamada a função buscaLinear. Caso o elemento 
seja encontrado, é impressa a posição em que ele foi encontrado. Caso contrário, é impressa uma mensagem informando que o elemento não foi encontrado 
na coleção.

## Links úteis

- [Busca Sequencial - Pedro Penna](http://desenvolvendosoftware.com.br/algoritmos/busca/busca-sequencial.html)
- [Algoritmos de Busca - UNICAMP](https://ic.unicamp.br/~mc102/aulas/aula11.pdf)
