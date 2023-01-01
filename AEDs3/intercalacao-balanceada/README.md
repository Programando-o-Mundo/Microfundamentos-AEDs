# Intercalação balanceada

## Definição

A intercalação balanceada é um algoritmo de ordenação externa, para intercalar os elementos de dois ou mais caminhos (que seriam os nossos arquivos) de forma a preservar sua ordem original. O objetivo do algoritmo é produzir um único caminho ordenado que contenha todos os elementos dos caminhos de entrada em sua ordem original, minimizando o número de comparações necessárias para produzir o caminho final. Dentro dos caminhos, também separamos os registros em blocos, que podem ter um número máximo de registros.

## Exemplo

Aqui está um exemplo de como o algoritmo de intercalação balanceada funciona:

**Obs.:** Para exemplos temos cinco registros por bloco e dois caminhos.

**Entrada**: Lista com vários números fora de ordem.

| | | | | | | | | | | | | | |
|---|---|---|---|---|----|----|-----|---|---|----|----|------|----|
| 1 | 5 | 3 | 2 | 7 | 13 | 23 | 235 | 3 | 9 | 34 | 55 | 1634 | 29 |

1 - Separe a lista de números em blocos

2 - Ordene os blocos

3 - Distribua os blocos pelos caminhos de forma intercalada nos caminhos.

**Obs.:** O espaço branco é a separação entre um bloco e outro.

| | | | | | | | | | |
|---|---|---|---|---|----|----|------|----|----|
| 1 | 2 | 3 | 5 | 7 |    | 34 | 55 | 1634 | 29 |

| | | | | |
|----|-----|-----|---|---|
| 13 | 23  | 235 | 3 | 9 |

4 - Faça leitura dos blocos dos caminhos, até o ponteiro do caminho chegar no final. Você irá ler os blocos em grupos, e irá colocar os registros dentro dos blocos de forma ordenada em um novo caminho.

Neste caso temos dois grupos: o primeiro que é formado pelo primeiro bloco do primeiro e segundo caminho, e o segundo grupo só tem o segundo bloco do primeiro caminho.

### Antes

| | | | | | | | | | |
|---|---|---|---|---|----|----|------|----|----|
| 1 | 2 | 3 | 5 | 7 |    | 34 | 55 | 1634 | 29 |

| | | | | |
|----|-----|-----|---|---|
| 13 | 23  | 235 | 3 | 9 |

### Depois

| | | | | | | | | | |
|---|---|---|---|---|----|----|---|----|-----|
| 1 | 2 | 3 | 3 | 5 | 7  | 9  | 13| 23 | 253 |

| | | | | 
|----|----|----|------|
| 29 | 34 | 55 | 1634 |

5 - Repita o passo quatro, até que o número de blocos seja igual ou menor do que o número de caminhos, dessa forma só um caminho novo será gerado e esta será a sua lista ordenada.

**Saída**: Lista com vários números ordenados.
| | | | | | | | | | | | | | |
|---|---|---|---|---|----|----|-----|---|---|----|----|------|----|
| 1 | 2 | 3 | 3 | 5 | 7 | 9 | 13 | 23 | 29 | 34 | 55 | 235 | 1634 |

Nesta seção, você irá encontrar um exemplo em como fazer uma implementação simples do algoritmo usando números como o registro que
queremos ordenar. Também recomendo bastante os vídeos do professor Marcos Kutova para a [explicação do algoritmo](https://youtu.be/CU_zh6Nunu8)
além do [custo computacional](https://youtu.be/RVMnTHpzTdU) do mesmo.

- [Veja a minha implementação do algoritmo](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/tree/main/AEDs3/intercalacao-balanceada/implementacao)

Bons estudos!
