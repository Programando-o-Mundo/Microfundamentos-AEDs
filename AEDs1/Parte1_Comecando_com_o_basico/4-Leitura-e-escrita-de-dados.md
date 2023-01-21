# Leitura e escrita de dados

## Você irá aprender

- Como usar as funções "printf" e "scanf".
- Como usar os formatadores do C.
- O que são e como usar Caracteres de escape.

## Pré-requisitos

- [Atributos e declaração](3-Atribuicao-e-declaracao.md)

## Usando Estruturas Condicionais

Até então temos feito apenas declaração e leitura de variáveis, mas e que tal se agora a gente fizesse escrita desses valores na tela para vermos? Ou melhor ainda, e se a gente fizesse um programa que leia a entrada do teclado realizada pelo usuário? Nesta seção trabalharemos com leitura e escrita de dados, usando como contexto a Linguagem C.

## Standard Input and Output (stdio.h)

Você deve se lembrar da primeira aula quando importamos essa biblioteca "stdio.h", esse nome é uma simplificação de Standard Input and Output, que em outras palavras, é a biblioteca padrão de entrada e saída de dados da linguagem C., em geral, todas as linguagens conseguem efetuar essas operações.

A biblioteca "stdio.h" tem várias funções, mas nesta aula iremos focar em duas funções em específico, uma permite escrever dados do programa no terminal (printf) e a outra permite que o usuário digite um valor e o programa irá ler e armazenar em uma variável para nós (scanf).

## Escrevendo valores na tela com printf

A função **printf** ou "print formatted" permite que a gente escreva valores na tela, e os escreva formatadamente, ou seja, se quisermos que o programa escreva um número em decimal, usamos *%d*, se usarmos *%c*, o **printf** irá escrever um caractere na tela, e assim por diante. Não passarei por todos os formatadores, apenas colocarei uma tabela de consulta, e seguiremos com a utilização da função.

| Formatador | USADO PARA |
|---|---|
| %c | um único caractere |
| %s | uma string |
| %hi | short (com sinal) |
| %hu | short (sem sinal) |
| %Lf | long double |
| %n | sem impressão |
| %d | um inteiro decimal (assume a base 10) |
| %i | um decimal inteiro (detecta a base automaticamente) |
| %o | um inteiro octal (base 8) |
| %x | um inteiro hexadecimal (base 16) |
| %p | um endereço (ou pointer) |
| %f | um número de ponto flutuante para floats |
| %g | um número de ponto flutuante simplificado para o menor número de casas decimais que precisa |
| %u | int decimal sem sinal |
| %e | um número de ponto flutuante em notação científica |
| %E | um número de ponto flutuante em notação científica |
| %% | o símbolo % |

fonte: https://www.freecodecamp.org/portuguese/news/especificadores-de-formatacao-em-c/

Suponhamos que queremos imprimir o valor de um número inteiro na tela que criamos.

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  return 0;
}
``` 

Para isso invocaremos a função **printf**, observe o exemplo abaixo:

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  printf("%d",a);
  return 0;
}
``` 

Vamos explicar o que está acontecendo, primeiramente invocamos a função **printf** ainda não chegamos na aula de funções, então essa sintaxe parece meio confusa, mas de forma simplificada, quando queremos invocar uma função, colocamos o seu nome exato, seguindo de dois parênteses "()".
```
printf()
  ^
 nome
``` 
Nos parênteses colocamos o que chamamos de os argumentos da função, valores para que a função precisa para gerar um resultado. Neste caso para imprimirmos algo na tela precisamos de dois argumentos, o primeiro é uma sequência de caracteres colocadas em aspas duplas (" "), nas aspas duplas colocamos o nosso formatador, que no nosso caso, como queremos imprimir um número decimal, colocamos *%d*. 

```
printf("%d")
        ^
   sequência de caracteres
``` 

O segundo argumento é a variável de onde o "printf" irá ler para substituir nos formatadores.

```
printf("%d", a)
             ^
   variável de onde o %d irá retirar o valor
``` 

Obs.: Argumentos de uma função são separados por vírgula, por exemplo, suponhamos que queremos imprimir um valor "b" junto ao valor "a". 

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  int b = 3;
  printf("%d",a);
  return 0;
}
``` 

É só colocar outro formatador, e adicionar a variável "b" como argumento da função **printf**.

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  int b = 3;
  printf("%d %d",a, b);
  return 0;
}
``` 

Obs.: A ordem que colocamos os nossos argumentos importa, como colocamos o "a" antes do "b" então primeiro será impresso "a" e depois "b", caso queira imprimir as variáveis na ordem invertida, é só inverter a ordem que coloca as variáveis.

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  int b = 3;
  printf("%d %d",b, a);
  return 0;
}
``` 
### Caracteres de Escape

Além disso, podemos empregar algumas ações especiais na função **printf** se usarmos caracteres de escape, caracteres que juntos empregam funcionalidades especiais. Por exemplo, podemos usar o "\n" para saltar uma linha, e o "\t" para dar espaço equivalente a uma tabulação, observe o exemplo abaixo.

```c
#include<stdio.h>

int main(void) {

  int a = 5;
  int b = 3;
  printf("%d\t%d\n",b, a);
  return 0;
}
``` 
Agora estamos dando um espaço equivalente a uma linha após ler os valores, além de que entre os valores estamos dando o espaço equivalente a uma tabulação.

## Lendo valores com scanf

Por fim, temos o **scanf** ou *scan formatted* que como o nome sugere, ele irá ler o teclado da forma que o programador colocar, por exemplo:

```c
#include<stdio.h>

int main(void) {

  int a;
  scanf("%d", &a);
  printf("%d\n",a);
  return 0;
}
``` 
Essa sintaxe parece meio maluca, mas vamos destrinchar ela. A primeira parte vocês já devem estar familiarizados, nome da função, parênteses, sequência de caracteres com os formatadores, e por fim a variável, mas e esse sinal "&"? Bem, novamente não entraremos em detalhes nisso agora, apenas entenda que esse sinal está nos dizendo que estamos passando o endereço da variável "a", pois como queremos atualizar o valor de "a" precisamos passar o endereço de memória, para que o valor dentro de "a" seja sobrescrito.

Além disso, podemos usar o "scanf" para fazer leituras de forma customizada, por exemplo, podemos ler mais de uma variável na mesma linha:

```c
#include<stdio.h>

int main(void) {

  int a,b;
  scanf("%d %d", &a, %b);
  printf("%d\t%d\n",a);
  return 0;
}
``` 
Agora estamos lendo os valores de "a" e "b" separados por espaço.

## Conclusão

Com essa aula, você consegue fazer leitura e escrita pelo teclado usando as funções **printf** e **scanf**. Como dito anteriormente, a biblioteca *stdio.h* possui várias outras funcionalidades, mas não iremos entrar nesse mérito agora. Por enquanto, não se esqueçam de testar esses códigos na máquina de vocês e testar um pouco com outros formatadores, para testar a leitura pelo teclado e a escrita na tela.

## Links úteis

- [Aula de printf e scanf da UFMG](https://homepages.dcc.ufmg.br/~rodolfo/aedsi-2-10/printf_scanf/printfscanf.html)
- [Operação de saída e entrada de dados](http://linguagemc.com.br/operacoes-de-entrada-e-saida-de-dados-em-linguagem-c/)
