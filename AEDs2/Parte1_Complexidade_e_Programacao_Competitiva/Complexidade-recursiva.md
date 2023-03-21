# Complexidade de funções recursivas

## Você vai aprender

- Como calcular a complexidade de espaço e tempo para funções 
recursivas

## Pré-requisitos

- Conhecimento de Complexidade de Espaço e Tempo
- Notações assintóticas

## Como fazer o cálculo

Para calcular a complexidade de tempo e espaço de uma função recursiva, é necessário entender o número de chamadas recursivas que 
ocorrem e o tempo e espaço consumidos por cada chamada.

A complexidade de tempo de uma função recursiva é geralmente expressa em termos de notação assintótica, como O(n), Θ(n), ou O(log n). A complexidade 
de espaço é expressa de forma semelhante, indicando quanto espaço de memória é usado pela função recursiva.

## Passo-a-passo

Para calcular a complexidade de tempo e espaço de uma função recursiva, é possível seguir os seguintes passos:

 - Identificar o número de chamadas recursivas: Analise a função recursiva para determinar quantas chamadas recursivas são 
feitas em termos de n, o tamanho da entrada.
 - Identificar o tempo e espaço consumidos por cada chamada recursiva: Analise o tempo e espaço consumidos por cada chamada 
recursiva em termos de n. Isso pode incluir o tempo e espaço necessários para executar a chamada recursiva, bem como para 
manter a pilha de chamadas recursivas.
 - Escreva a equação de recorrência: Com base no número de chamadas recursivas e no tempo e espaço consumidos por cada chamada 
recursiva, escreva uma equação de recorrência que descreva a complexidade de tempo ou espaço da função recursiva.
 - Resolva a equação de recorrência: Resolva a equação de recorrência para obter a complexidade de tempo ou espaço final da 
função recursiva.

Por exemplo, considere a seguinte função recursiva que calcula o fatorial de um número:

```java
int fatorial(int n) {
  if (n == 0) return 1;
  return n * fatorial(n - 1);
}
``` 

A função fatorial faz uma única chamada recursiva com um argumento n - 1.

 - Cada chamada recursiva executa uma multiplicação e consome espaço para manter a pilha de chamadas.
 - A equação de recorrência para o tempo de execução é T(n) = T(n-1) + O(1), e a equação de recorrência 
 para o espaço é S(n) = S(n-1) + O(1).
 - Resolvendo a equação de recorrência, podemos ver que a complexidade de tempo é O(n) e a complexidade 
 de espaço é O(n) também. Isso ocorre porque a função fatorial faz n chamadas recursivas, e cada chamada recursiva consome uma quantidade constante de espaço e tempo.

Note que em funções recursivas mais complexas, o processo de análise pode ser mais complicado e pode ser necessário usar 
técnicas avançadas, como a substituição, o método mestre ou a árvore de recursão para calcular a complexidade de tempo e 
espaço de forma precisa.
