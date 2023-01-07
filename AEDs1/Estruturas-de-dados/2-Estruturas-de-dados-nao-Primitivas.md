# Estruturas de Dados não Primitivas

# Gustavo Lopes Rodrigues

## Você irá ver nessa aula:

- O que são estruturas de dados não primitivas
- Alguns exemplos dessas estruturas na linguagem C
- Como utilizar elas na linguagem

## Pré-requisitos

- 1-Estruturas-de-dados-Primitivas
- [Todas as aulas de algoritmos e sugerido ter assistido até aqui](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/tree/main/AEDs1/Algoritmos)

## Aplicando 

Até então, temos usados os componentes que a linguagem C tem nos oferecido, inteiros, floats, booleanos, char e etc. Agora nós iremos dar uma olhada breve no mundo de Estruturas de Dados não Primitivas, ou seja, estruturas que são estruturas mais complexas e geralmente são composições feitas usando duas ou mais estruturas primitivas, sejam elas do mesmo tipo ou não.

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

A explicação disso exige um pouco de arquitetura, mas de forma bem simplificada, quando criamos um array, esse array está em alguma posição da memória, vamos supor , ele está na posição 0. Então nesse caso nós temos 10 inteiros, como cada inteiro tem 32 bits ou 4 bytes, então vai da posição 0 até a posição 40, sendo a posição 0 onde começa o primeiro elemento do array.

![Diagrama sem nome drawio](https://user-images.githubusercontent.com/9157977/211172398-dd4748c3-a654-4830-95dd-f2488bfa0bbb.png)

Pegando a imagme acima como exemplo, quando usamos essa sintaxe```array[0]```, o que você na verdade está pedindo para linguagem C de forma implícita, é pegar o endereço de onde o array começa na memória (no nosso exemplo 0) e somar com índice que você passou (nesse caso 0) e multiplicar com o tamanho do tipo do array (neste caso o inteiro que é de 4 bytes). Como eu disse anteriormente, o primeiro elemento está na posição 0, e o array começa o ponteiro no primeiro elemento, então (0 + (0 * 4)) = 0, que é justamente o primeiro elemento do array.

É por essa maneira que se quisermos preencher o nosso array usando um laço de repetição for, vamos do índice 0, até que o índice seja menor que 10, porque assim ele vai de 0 a 9.

```c
int n = 10;
int array[n];

for (int i = 0; i < n ; i++) {
  array[i] = i;
}
``` 
### Struct

Vamos supor que queremos representar uma pessoa, porém, uma pessoa tem várias características, nome, idade, altura, peso e etc. Para isso nós iremos precisar de Structs, que são estruturas que chamamos de amarrações, pois elas literalmente amarram varias outras estruturas de dados para criar uma nova estrutura.

```c
struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
};
``` 

Como pode ver criamos uma struct de uma Pessoa e possui essa sintáxe, você coloca a palavra "struct" seguido do nome da struct" logo temos um abre e fecha chaves, sendo que o fecha chaves precisa ser acompanhado de um ponto e vírgula depois. Por fim, dentro das chaves, nós declaramos os componentes da nossa struct, que você pode ver no exemplo acima.

Agora para iniciar e instanciar valores dentro da nossa struct e imprimí-los na tela, podemos ver o exemplo abaixo:

```c
#include<stdio.h>
#include<string.h>

struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
};

int main(void) {

  struct Pessoa p;
  p.idade = 25;
  strcpy(p.nome,"Joao");
  p.altura_em_cm = 180;
  p.peso_em_kg = 75;

  printf("Nome: %s\nIdade = %d\nAltura em cm = %d\nPeso (em kg) = %g\n", p.nome, p.idade, p.altura_em_cm, p.peso_em_kg);
}
```

Obs.: Se essa sintaxe "strcpy" parece muito estranho para você, não deixe de olhar a nossa aula sobre Strings.

Uma curiosidade, existe outra maneira de criar structs que é usando a palavra typedef:

```c
typedef struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
}Pessoa;
```

Adicionando essa palavra, podemos evitar de usar a palavra "struct" toda vez que declaramos uma "Pessoa":

```c
int main(void) {

  Pessoa p;
  p.idade = 25;
  strcpy(p.nome,"Joao");
  p.altura_em_cm = 180;
  p.peso_em_kg = 75;

  printf("Nome: %s\nIdade = %d\nAltura em cm = %d\nPeso (em kg) = %g\n", p.nome, p.idade, p.altura_em_cm, p.peso_em_kg);
}
``` 

Existe mais exemplos de Estruturas não primitivas, mas por enquanto acredito que essas sejam as mais importantes de aprender.

## Línks úteis

- [C Structs](https://www.youtube.com/watch?v=oKXP1HZ8xIs)
- [C Arrays](https://www.youtube.com/watch?v=eE9MnoS0lc0)
- [Leia mais sobre Strings em C](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/blob/main/C/string/Strings-em-C.md)
