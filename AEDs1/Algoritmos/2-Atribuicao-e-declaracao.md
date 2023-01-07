# Atribuição e declaração

# Gustavo Lopes Rodrigues

## Você irá aprender

- O que é atribuição, declaração e inicialização
- O que são variáveis
- Como declarar e atribuir variáveis em C
- O que não fazer quando declarar e atribuir varíaveis em C

## Pré-requisitos

- 1-Criando-nosso-primeiro-algoritmo
- 1-Estruturas-de-dados-Primitivas

## Atribuição e Declaração de variáveis

Temos agora o nosso primeiro algoritmo, porém, tudo que sabemos fazer até então e criar a função principal e imprimir texto na tela, vamos passar para o próximo passo que seria declarar e atribuir valor a variáveis.

## Declaração e variáveis

Variáveis são objetos capazes de reter e representar um valor ou expressão, na linguagem C a sintaxe para declaração são duas:

- Colocar tipo da variável, nome e por fim ponto e vírgula. (Tipo 1)
- Colocar tipo da variável, nome , sinal de igual "=" e por fim um valor, seguido de ponto e vírgula. (Tipo 2)
```c
// Tipo 1
int a;
// Tipo 2
int a = 5;
```

Obs.: Você também pode declarar mais de uma variável na mesma linha, colocando as variáveis entre vírgulas, a única condição é que todas as variáveis serão do mesmo tipo

Exemplo:

```c
// Três variáveis do tipo int
int a,b,c;
```

Além disso, podemos declarar uma variável como **constante**.

```c
const int a = 5;
``` 
Falaremos mais de constantes quando for abordado atribuição.

Por fim, é importante ressaltar que tem duas coisas importantes no mundo da declaração:

### Declarar uma variável duas vezes

Não podemos declarar a mesma variável duas vezes, ou seja, se o exemplo anterior fosse um código real, o Compilador me retornaria com erro.

```c
#include<stdio.h>

int main(void) {
    int a;
    int a = 5;
    return 0;
}
```
"Redefinition" é um problema que o compilador de C detecta, quando uma variável é redeclarada, ou seja, você faz a sua declaração e tentar declara-la novamente.
```
main.c: In function ‘main’:
main.c:5:9: error: redefinition of ‘a’
    5 |     int a = 5;
      |         ^
main.c:4:9: note: previous definition of ‘a’ with type ‘int’
    4 |     int a = 2;
      |         ^
guara:teste$ gcc main.c 
main.c: In function ‘main’:
main.c:5:9: error: redeclaration of ‘a’ with no linkage
    5 |     int a = 5;
      |         ^
main.c:4:9: note: previous declaration of ‘a’ with type ‘int’
    4 |     int a;
      |         ^
```

### Nome as variáveis

Quanto ao nome das variáveis, não se preocupe, você pode dar o nome que quiser, desde que siga essa regra: precisa começar com *"_"* ou letra e pode 
ter uma sequência praticamente infinita de letras, digitos ou *"_"* até encontrar um espaço vazio ou outro caractere.

```c
int A233;  // válido
int _a233; // válido
int 2a3_;  // inválido
```

Isso não é um tópico tão importante ao mundo de Algoritmo e Estrutura de Dados, mas é uma habilidade muito importante saber dar nome significativos para suas variáveis. Se quiser olhar mais para este tópico, deixarei um link na seção de "Línks úteis" dessa aula.

Ok, então agora você entende o que é uma declaração, mas é uma atribuição?

## Atribuição

Atribuição é nada mais do que o processo de atribuir um valor para uma variável. Você provavelmente deve ter observado que o "Tipo 2" de declaração também inclui uma atribuição, é uma declaração seguida de uma inicialização, pois essa atribuição está inicializando a variável. 

```c
// Tipo 1
int a = 5;
// Tipo 2
a = 5;
```

Além disso, também podemos fazer apenas uma atribuição, colocando o nome da variável seguido do sinal de igual "=", o novo valor da variável e o ponto e vírgula ";".

Agora vamos falar dos casos proibídos:

### Reatribuir uma constante

Aqui, diferente da declaração, nós podemos reatribuir um valor para uma variável, desde que a nossa variável não seja uma constante.

```c
// Permitido
int a = 5;
a = 3;
// Nao permitido
const int b = 3;
b = 7;
```

Se colocarmos esse código na função main e rodar, recebemos o seguinte aviso

```
main.c: In function ‘main’:
main.c:9:7: error: assignment of read-only variable ‘b’
    9 |     b = 7;
      |       ^
``` 

Isso se deve ao fato de que variáveis constantes só podem ser atribuidas uma única vez, ou seja, após ela ser declarada e atribuída, nós não podemos mudar o seu valor, podemos apenas ler o valor. É por esse motivo que o compilador nomeou a variável "b" como "read-only variable".

### Atribuir com um tipo diferente

Durante a atribuição, precisamos respeitar o tipo que a variável pertence, ou seja, se a nossa variável é do tipo "int" evite atribuir outros tipos, como por exemplo: atribuir um ponto flutuante (float) para um inteiro.
```c
int a = 5.7;
``` 
Esse tipo de comando não irá fazer o GCC acionar algum tipo de erro, mas pode gerar comportamentos inesperados e até erros durante a execução. Neste caso, em vez de 5.7, a variável **a** irá armazenar o valor 5.

## Links úteis

- [Naming Things in Code](https://www.youtube.com/watch?v=-J3wNP6u5YU)
- [C Variables](https://www.youtube.com/watch?v=aIQk1O08zpg)
