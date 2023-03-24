# Complexidade de Tempo e Espaço

## O que você irá aprender

- O que é Complexidade e sua importância
- O que é Complexidade de Tempo
- O que é Complexidade de Espaço
- Notação Big O

## Pré-requisitos

- Nenhuma

## Complexidade

A Ciência da Computação busca desenvolver soluções eficientes para problemas, e um dos principais aspectos dessa eficiência é a análise da 
complexidade de tempo e espaço dos algoritmos. Essa análise permite avaliar e comparar diferentes soluções, facilitando a escolha da melhor 
abordagem para resolver um problema.

## Complexidade de Tempo:

A complexidade de tempo é uma medida que indica a quantidade de tempo necessário para executar um algoritmo em função do 
tamanho da entrada (n). Ela fornece uma estimativa do desempenho do algoritmo em termos de tempo de execução. Dessa forma, 
é possível prever o comportamento de um algoritmo quando aplicado a conjuntos de dados maiores ou menores.

## Complexidade de Espaço:

A complexidade de espaço é uma medida que indica a quantidade de memória utilizada por um algoritmo em função do tamanho da 
entrada (n). Ela fornece uma estimativa do consumo de recursos de memória (RAM) do algoritmo durante a execução. Isso é importante
porque a quantidade de memória disponível em um sistema é limitada, e algoritmos que consomem menos espaço podem ser mais adequados 
para aplicações com restrições de memória.

## Notação Big O:

A notação Big O é uma forma de descrever a complexidade de tempo e espaço de um algoritmo. Ela expressa a relação entre o 
tamanho da entrada (n) e a quantidade de operações (tempo) ou memória (espaço) consumidas pelo algoritmo. A notação Big O 
foca no comportamento assintótico, ou seja, no crescimento do tempo ou espaço em função do tamanho da entrada à medida que n 
se aproxima do infinito.

A notação Big O é representada como O(f(n)), onde f(n) é uma função que descreve o crescimento da complexidade do algoritmo 
em relação a n. Algumas notações comuns de complexidade são:

 - O(1): complexidade constante, o algoritmo leva um tempo ou espaço constante para ser executado, independentemente do tamanho da entrada.
 - O(log n): complexidade logarítmica, o algoritmo leva um tempo ou espaço proporcional ao logaritmo do tamanho da entrada.
 - O(n): complexidade linear, o algoritmo leva um tempo ou espaço proporcional ao tamanho da entrada.
 - O(n log n): complexidade linearítmica, o algoritmo leva um tempo ou espaço proporcional ao tamanho da entrada multiplicado pelo logaritmo do tamanho da entrada.
 - O(n^2): complexidade quadrática, o algoritmo leva um tempo ou espaço proporcional ao quadrado do tamanho da entrada.
 - O(2^n): complexidade exponencial, o algoritmo leva um tempo ou espaço proporcional a uma potência exponencial do tamanho da entrada.

![bigO](https://danielmiessler.com/images/big-o-chart-tutorial-bazar-aymptotic-notations-1.png)

Ao utilizar a notação Big O, é possível comparar a eficiência de diferentes algoritmos em termos de tempo e espaço, ajudando a 
escolher a solução mais adequada para um problema específico.

## Melhor, médio e pior caso

Além de saber calcular a complexidade, é importante saber também que a complexidade do algoritmo pode variar dependendo das circunstâncias,
e por isso, quando calculamos a complexidade, precisamos calcular o pior, médio e melhor caso. Saber calcular a complexidade desta forma é importante para avaliar o desempenho de um algoritmo em diferentes situações e para escolher o algoritmo mais adequado para uma determinada tarefa.

O pior caso é importante porque indica o tempo máximo que o algoritmo pode levar para concluir uma tarefa, o que é fundamental para garantir que o algoritmo seja viável em todas as situações. É importante escolher um algoritmo que tenha uma complexidade de tempo no pior caso que seja aceitável para a aplicação em questão.

O melhor caso, embora menos crítico, também é importante, pois indica a eficiência máxima do algoritmo em uma situação ideal. Isso pode ser útil para avaliar a qualidade do algoritmo em relação a outras soluções ou para estabelecer um limite superior para a complexidade de tempo.

Já a complexidade de tempo no caso médio é importante porque reflete o desempenho do algoritmo em situações típicas. Embora o pior caso seja geralmente o mais importante, o caso médio pode ser relevante em muitas aplicações, especialmente quando se trata de grandes volumes de dados ou de problemas que exigem muitas iterações.

## Exemplo prático de cálculo de complexidade

Suponha que temos uma função que recebe uma lista de números e retorna o maior número da lista:

```c
#include <stdio.h>

int find_max(int numbers[], int size) {
    int max_number = numbers[0]; // linha 1
    for (int i = 1; i < size; i++) { // linha 2
        if (numbers[i] > max_number) { // linha 3
            max_number = numbers[i]; // linha 4
        }
    }
    return max_number; // linha 5
}

int main(void) {
    int numbers[] = {1, 5, 3, 9, 4};
    int size = sizeof(numbers) / sizeof(int);
    int max_number = find_max(numbers, size);
    printf("O número máximo é: %d\n", max_number);
    return 0;
}
```

### Calculando complexidade de tempo

Para calcular a complexidade de tempo dessa função, começamos analisando cada linha de código para determinar quantas vezes ela será executada para diferentes tamanhos de entrada.

 - A primeira linha cria uma variável max_number e acessa o primeiro elemento da lista, tudo isso é executada uma vez.
 - A segunda linha inicia um loop que será executado n-1 vezes, onde n é o tamanho da lista e -1 pois ignoramos a primeira posição.
 - A terceira linha compara o elemento atual com o número máximo encontrado até agora e é executada n-1 vezes.
 - A quarta linha atualiza a variável max_number se o elemento atual for maior e é executada k vezes, onde k é o número de elementos que são maiores do que o número máximo atual.
 - A quinta linha retorna o número máximo e é executada uma vez.
Podemos somar o número de vezes que cada linha é executada para obter a complexidade de tempo total da função:

```
1 + 1 + ((n-1)*(1 + k)) + 1
```

Aqui, n representa o tamanho da lista e k é o número de elementos que são maiores do que o número máximo atual. Em geral, ignoramos termos menores e constantes, então a complexidade de tempo é O(n).

Isso significa que, para entradas maiores, o tempo de execução da função aumenta proporcionalmente ao tamanho da entrada. Por exemplo, se a lista tiver 1000 elementos, a função será executada aproximadamente 1000 vezes, enquanto se a lista tiver 10000 elementos, a função será executada aproximadamente 10000 vezes.

Uma coisa importante a ser notada, é que para este caso, a complexidade no pior, médio e melhor caso serão iguais, pois em todos os casos, o algoritmo terá que percorrer a lista por inteiro até achar o elemento.

### Cálculo de complexidade de espaço

Para calcular a complexidade de espaço, precisamos determinar quantos bytes serão usados em diferentes tamanhos de entrada. Aqui, estamos assumindo que cada número na lista ocupa um byte de memória.

- A primeira linha cria uma variável max_number, que ocupa 1 byte e acessa o primeiro elemento da lista.
- O loop na segunda linha não usa nenhum espaço adicional.
- A terceira linha também não usa espaço adicional.
- A quarta linha atualiza a variável max_number, que ocupa 1 byte.
- A quinta linha retorna o número máximo, que também ocupa 1 byte.

Portanto, o espaço total utilizado pela função é de 3 bytes: um byte para a variável max_number e um byte para cada um dos dois números retornados.

Em geral, ignoramos termos menores e constantes, então a complexidade de espaço é O(1).

Isso significa que a quantidade de memória utilizada pela função permanece constante, independentemente do tamanho da entrada. O espaço necessário para executar essa função não aumentará à medida que a entrada se tornar maior.

## Links úteis

- [Big O Notation: A Few Examples](https://www.bigocheatsheet.com/) - Um guia interativo que explica como calcular a complexidade de tempo e espaço de algoritmos usando a notação big O.
- [Algorithm Analysis and Big O Notation](https://runestone.academy/runestone/books/published/pythonds/AlgorithmAnalysis/toctree.html) - Um livro online que cobre a análise de algoritmos, incluindo complexidade de tempo e espaço e notação big O, usando a linguagem de programação Python.
- [Asymptotic Notation](https://cp-algorithms.com/complexity/asymptotic-notation.html) - Uma introdução em profundidade à notação assintótica, incluindo big O, big Omega e big Theta, e como calcular a complexidade de tempo e espaço usando essas notações.
- [Big O Cheatsheet](https://www.bigocheatsheet.com/) - Uma folha de referência útil que lista a complexidade de tempo e espaço de vários algoritmos comuns, juntamente com exemplos e gráficos para ajudar a visualizar a complexidade.
- [Analysis of Algorithms](https://en.wikipedia.org/wiki/Analysis_of_algorithms) - Um artigo da Wikipedia que fornece uma visão geral da análise de algoritmos, incluindo a notação big O e outras notações assintóticas.
