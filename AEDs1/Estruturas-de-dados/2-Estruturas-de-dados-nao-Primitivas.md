# Estruturas de Dados não Primitivas

Até então, temos usados os componentes que a linguagem C tem nos oferecido, inteiros, floats, booleanos, char e etc. Agora nós iremos dar uma olhada breve no mundo de Estruturas de Dados não Primitivas, ou seja, estruturas que são estruturas mais complexas e geralmente são composições feitas usando duas ou mais estruturas primitivas.

## Arrays

Primeiramente nós temos os Arrays ou Arranjos que basicamente é uma cadeia de entidades, por exemplo, podemos ter um array de inteiros, de floats, ou até mesmo uma cadeia de caracteres que na verdade possui um nome específico: "String".

```c
int array[10];
``` 

A sintaxe para criar um array é a mesma de forma geral, temos a nossa declaração, seguida de dois colchetes, e dentro nós colocamos o tamanho do nosso array, neste caso estamos criando um array de inteiros de tamanho dez.

Vamos supor que queremos acessar e modificar/ler o conteúdo desse array, como fazemos isso?

### Acessando arrays

Para fazer acesso a arrays, usamos os mesmos colchetes que usamos para criar o array, para também acessar o seu conteúdo:

```c
int array [10]

int a = array[0];
``` 

Uma observação importante é que quando criamos um array de tamanho dez, você imagine que ele vai da posição 1 até a posição 10, certo? Porém, você irá ver que não só em C, mas em várias linguagens, que na verdade nós temos um array que vai de 0 até 9, sendo o 5 elemento acessado nesse exemplo, sendo 4° elemento. Você provavelmente deve estar muito confuso a respeito disso e deve estar pensando em como isso é possível.

A explicação disso exige um pouco de arquitetura, mas de forma bem simplificada, quando criamos um array, esse array está em alguma posição da memória, vamos supor , ele está na posição 1. Então nesse caso nós temos 10 inteiros, como cada inteiro tem 32 bits ou 4 bytes, então vai da posição 1 até a posição 41, sendo a posição 1 onde começa o primeiro elemento do array.

Quando você faz essa sintaxe ```array[0]```, o que você na verdade está pedindo para linguagem C de forma implícita, é pegar o endereço de onde o array começa na memória (no nosso exemplo 1) e somar com índice que você passou (nesse caso 0) e multiplicar com o tamanho do tipo do array (neste caso o inteiro que é de 4 bytes). Como eu disse anteriormente, o primeiro elemento está na posição 1, e o array começa o ponteiro no primeiro elemento, então (1 + (0 * 4)) = 1, que é justamente o primeiro elemento do array.

É por essa maneira que se quisermos preencher o nosso array usando um laço de repetição for, vamos do índice 0, até que o índice seja menor que 10, porque assim ele vai de 0 a 9.

```c
int n = 10;
int array[n];

for (int i = 0; i < n ; i++) {
  array[i] = i;
}
``` 
