# O que é POO?

A programação orientada a objetos (OOP) é um paradigma da programação que usa objetos para representar e manipular dados. Esses objetos são instâncias do que chamamos de classes, ou modelos para objetos e definem as propriedades (membros de dados) e métodos (funções) que os objetos de tal classe terão. 

Pense que classes são como as Structs que estavamos criando em C, porém, essas Structs agora possuem superpoderes, pois além de amarrar variáveis, elas também podem conter funções, além de outras funcionalidades como construtores e funções mágicas, que permitem amarrar a lógica de uma implementação de forma mais natural e simplificada. Exemplo de linguagens que usam OOP incluem: Java, Python, C++ e C#.

## Classes 

Como dito anteriormente, primeiramente nós criamos as nossas classes. Imagine que a nossa classe é nada mais do que o diagrama do projeto de uma casa, ou uma planta de uma casa, onde as informações da casa são armazenadas de forma abstrata. Para exemplificar melhor, vamos pegar aquela Struct de pessoa que fizemos anteriormente.

```c
struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
};
``` 

Aqui nós temos aquela Struct em que amarramos as informações de uma pessoa. Você também deve se lembrar que para instanciar e manipular dados dessa nossa struct, usavamos essa sintaxe:

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
