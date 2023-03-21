# Complexidade de Tempo e Espaço


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

Ao utilizar a notação Big O, é possível comparar a eficiência de diferentes algoritmos em termos de tempo e espaço, ajudando a 
escolher a solução mais adequada para um problema específico.
