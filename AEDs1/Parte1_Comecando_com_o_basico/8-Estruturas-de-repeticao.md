# Estruturas de Repetição

## Você irá aprender

- O que são estruturas de repetição.
- Porque utilizar elas.
- Como utilizar os diferentes tipos de estruturas de repetição.
- Como utilizar as instruções de controle de fluxo.
- 
## Pré-requisitos

- [Operadores lógicos](7-Operadores-logicos.md)

## Tratando problemas repetitivos

Nesta aula trabalharemos com estruturas de repetição ou loops, que, assim como o nome sugere, permite que seja possível fazer loop em um bloco de instruções.

Existem várias maneiras de fazer um loop, cada uma com seus próprios casos de uso específicos. Aqui estão algumas das maneiras mais comuns de fazer um loop em C:

## For

O loop "for" é uma maneira popular criar um loop de repetição, geralmente usada para iterar por um número específico de vezes. A sintaxe básica de um loop "for" em C é a seguinte:

```c

for (inicialização; condição; atualização) {
    // código para ser executado
}
``` 

Como pode ser ver, essa é uma sintaxe um pouco diferente daquela que estamos acostumados, com três partes diferentes separadas por ponto e vírgula, mas veremos um exemplo mais concreto, talvez isso irá ajudar a deixar as coisas mais claras.

```c
for (int i = 0; i < 10; i++) {
    printf("%d\n", i);
}
``` 

Aqui temos um exemplo de um loop "for" usado para imprimir os valores de 0 até 9, acredito que só com esse exemplo tenha ficado mais claro, mas acho importante explicar cada elemento dentro do for.

### Inicialização

Nesta parte você irá fazer a declaração ou atribuição de variáveis, aqui é importante notar que geralmente inicializamos variáveis que serão usadas para iterar pelo **for**.

```
for (int i = 0; i < 10; i++) {
         ^
   inicialização
``` 

Obs.: Aqui podemos tanto fazer declaração como atribuição:

```c
int i;
for (i = 0; i < 10; i++) {
    printf("%d\n", i);
}
``` 

Obs2.: Podemos iniciar mais de uma variável na inicialização (desde que todas tenham o mesmo tipo), separando cada variável com uma vírgula:

```c

for (int i = 0, j = 0; i < 10; i++) {
    printf("%d\n", i);
}
``` 

### Condição de parada

Assim como as estruturas condicionais, loops também utiliza uma condição, chamada "Condição de Parada". Utilizando a mesma lógica, ele entra e continua a fazer a repetição (loop), se a condição for verdadeira. Lembrando obviamente que a nossa condição pode ser também uma expressão.

```
for (int i = 0; i < 10; i++) {
                  ^
             condição de
               parada
``` 

Nesta área, nós geralmente criamos uma condição com a variável que iniciamos na parte de inicialização, no nosso caso o "i" sendo igual a zero, e nós iremos continuar a fazer o loop enquanto "i" for menor que dez (sendo essa a nossa condição).

Obs.: De todas as seções do for, esta é a única que é obrigatória, as outras duas seções podem ser deixadas em branco e o "for" ainda funcionaria.

```c
int i = 0;
for( ; i < 10; ) {
  print("%d\n",i);
  i++;
}
``` 

### Expressão de atualização

Por fim, temos a seção de atualização, pois é nela onde atualizamos as variáveis responsáveis em controlar o fluxo da estrutura. De forma geral, nessa seção incrementamos/decrementamos a variável iniciada na primeira seção. 

Chamamos essa seção de expressão, pois na realidade, podemos fazer uma sequência infinita de atribuições, lembrando obviamente de que precisamos implementar a lógica para que eventualmente faça o código sair do loop, caso contrário, o código irá ficar em um loop infinito.

```
for (int i = 0; i < 10; i++) {
                         ^
                    incremento
``` 
Obs.: a seção de incremento não é acionada quando entramos no laço "for", quando entramos na seção de loop, as instruções de inicialização de condição são acionadas, mas a de incremento é apenas acionadas depois da primeira iteração.

## While

O loop while executa repetidamente um bloco de código enquanto uma condição especificada for verdadeira. A sintaxe básica de um loop while é a seguinte.

```c
while (condição) {
    // código a ser executado
}
```

Aqui, a estrutura funciona de forma bem parecida com o loop for, com a diferença que este apenas possui espaço para colocar a condição, excluindo o espaço para atribuição e incremento/decremento.

Eis um exemplo:

```c
int i = 0;
while (i < 10) {
    printf("%d\n", i);
    i++;
}
```

# Do while

O loop "do-while" é semelhante ao loop "while", mas a condição é verificada após a execução do bloco de código. Isso significa que o bloco de código sempre será executado pelo menos uma vez. A sintaxe básica de um loop "do-while" é a seguinte:

```c
do {
    // código a ser executado
} while (condição);
``` 

Eis um exemplo:

```c
int i = 0;
do {
    printf("%d\n", i);
    i++;
} while (i < 10);
``` 

## Controladores de fluxo

Além dessas construções básicas de loop, a linguagem C, assim como outras linguagens, também fornece várias outras construções usadas para loop, como as instruções **break** e **continue**. Essas construções podem ser usadas para alterar o fluxo de controle em um loop, permitindo estruturas de loop mais complexas e poderosas, porém também podem deixar o código mais confuso/dificíl de ser analisado.

Finalizaremos a aula olhando brevemente como elas funcionam.

### Break

O break funciona para interromper por completo o fluxo do laço de repetição, forçando o mesmo a sair.

```c
for (int i = 0; i < 10; i++) {
    if (i == 5)
      break;
      
    printf("%d\n", i);
}
```
Neste caso, estamos forçando o laço de repetição sair quando "i" for igual a 5, logo terminando o "for" antecipadamente.

### Continue

Diferente do break, que interrompe o funcionamento do loop, a instrução "continue" permite que o laço de repetição seja pulado, como no exemplo abaixo, onde a iteração do 5 é pulada por conta do continue.

```c
for (int i = 0; i < 10; i++) {
    if (i == 5)
      continue;
      
    printf("%d\n", i);
}
```

Depois teste o código, e perceba que agora, o número 5 não é imprimido.
## Línks uteis

- [Loop in C](https://www.programiz.com/c-programming/c-for-loop)
- [Estruturas de Repetição em C - LinguagemMC](http://linguagemc.com.br/a-estrutura-de-repeticao-for-em-c/)
