# Estruturas de Dados Primitivas

## Você vai aprender

- O que são Estruturas de Dados
- Qual é a importância das Estruturas de Dados e escolher as estruturas de dados certa
- O que são as Estruturas de Dados Primitivas e quais são elas

## Pré-requisitos

- Introdução a AEDs1

## O Mundo simbolizado pelas Estruturas de Dados

Quando trabalhamos com a construção de algoritmos, precisamos pensar nas entidades que iram suportar e representar os objetos dos nossos problemas de forma fiel. Um exemplo bem simples de visualizar esse conceito é a calculadora, pois nela, precisamos trabalhar com números que possam ter casas decimais e para isso temos o float e o double para representar número com casas decimais, porém qual deles utilizar, pois o float pode ter até 7 casas decimais enquanto que o double pode guardar 15 casas decimais. Esta discussão é para ilustrar a importância das estruturas de dados: organizar dados de maneira que representem o nosso problema de forma fidedigna e eficiente.

Um outro exemplo bem simples seria por exemplo: vamos supor que estamos trabalhando em um aplicativo para uma padaria e temos que fazer um contador para a disponibilidade de um novo pão que estão vendendo agora. Neste caso não precisamos de números com casas decimais, pois não existe ter "2.43 pães disponíveis", então nesse caso precisariamos trabalhar com números inteiros. Porém, ao mesmo tempo não tem como ter "-5 pães disponíveis", e por isso precisamos trabalhar com números inteiros que não possuem o bit de sinal. 

## Definindo Estruturas de Dados

Enfim nós poderiamos continuar essa discussão por horas, mas acredito que tenha ficado mais do que claro o porquê estruturas de dados são tão importantes para nós, mas a final de contas, qual é a definição de Estruturas de Dados? 

Estruturas de Dados são entidades responsáveis em armazenar e organizar dados de forma que podemos acessar, atualizar e processar esses dados de forma eficiente. 

Nesta aula em específica iremos trabalhar com Estruturas de Dados Primitivas que são estruturas de dados básicas que normalmente são construídas dentro de uma linguagem de programação. Além disso, elas são responsáveis em armazenar dados de apenas um tipo de dado.

Aqui estão as estruturas de dados primitivas da linguagem C:

### Inteiro (int)

Inteiros são containers para valores númericos que podem ser negativos ou positivos e não guardam casas decimais. Em sua forma geral, a quantidade máxima de bits que o inteiro pode carregar depende da arquitetura da CPU e do Sistema Operacional, mas tipicamente um Inteiro pode guardar 32 bits e podem guardar 4294967296 números, ou seja, um inteiro pode ir de -2147483648 até 2147483647.

### Ponto flutuante (float e double)

Ponto flutuante descreve um número geralmente de 32 bits, sendo 24 desses bits para dígitos (o que em termos de arquitetura chamamos disso a mantissa) e 8 bits de expoente). Em termos básicos, floats guardam números que podem ter casas decimais, caso você precise de maior precisão, use o double que tem o dobro da precisão do float.

### Booleano (bool)

Inspirado pela algebra booleana, criada pelo matemático inglês George Boole, um booleano descreve um valor que pode ser verdadeiro (true) que é representado pelo número 1, ou pode ser falso (false) que é representado pelo número 0. De forma geral, nós usamos booleanos para fazer lógicas condicionais.

### Caractere (char)

Temos o char que pode guardar um caractere, este caractere irá depender de qual codificação for utilizada, em C tipicamente a codificação usada é ASCII que possui apenas 8 bits (1 byte). Para guardar caracteres de línguas latinas, como os caracteres com acentos, precisamos usar a codificação UTF-8, que utiliza 16 bits (2 bytes)

### Ponteiro (*)

Por fim temos o ponteiro, que não iremos entrar em detalhes nesta aula, pois é um pouco mais complexo, mas basicamente um ponteiro descreve um tipo que guardar o endereço de uma outra variável em nosso programa.

Obs.: Também temos o tipo void, mas entraremos em detalhe em próximas aulas.

## Conclusão

E por enquanto é apenas isto, existe mais algumas pequenas variações nos tipos de dados, como por exemplo o **size_t** do C, que permite guardar números inteiros sem sinal de 16 bits, mas deixaremos esses detalhes para você pesquisar, por agora, você deve ter entendido a importância das estruturas de dados como um dado e você deve agora saber quais são as estruturas de dados primitivas.

## Línks úteis

- [Aula de AEDs1](http://www3.dsi.uminho.pt/iiee/repos/AEDados.pdf)
- [Leia mais sobre tipos de Dados em C](https://byjus.com/gate/data-types-in-c/)
