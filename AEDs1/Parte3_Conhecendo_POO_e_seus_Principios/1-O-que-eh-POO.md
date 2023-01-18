# O que é POO?

## Você irá aprender

- O que são Classes e Objetos
- Como criar uma classe
- O que é o escopo de uma classe
- Porque usamos a palavra "this"?
- Como criar funções dentro da nossa classe

## Pré-requisitos

- [Parte 2 - Conceitos Avançados](../Parte2_Conceitos_avancados/README.md)

## Visão panorâmica

Nesta primeira aula, vamos ter uma visão panorâmica de como classes funcionam no geral, tenho certeza que aqui tem bastante informação, mas não se preocupe, nas próximas aulas iremos voltar a pontuar os elementos dessa aula. Sem mais delongas, vamos para a aula.

## Definição

Programação orientada a objetos (OOP) é um paradigma da programação que usa objetos para representar e manipular dados. Esses objetos são instâncias do que chamamos de classes, ou modelos para objetos e que são responsáveis em definir as propriedades (membros de dados) e métodos (funções) que os objetos de tal classe terão. 

Pense que classes são como as Structs que estavamos criando em C, porém, essas Structs agora possuem superpoderes, pois além de amarrar variáveis, elas também podem conter funções, além de outras funcionalidades como construtores e funções mágicas, que permitem amarrar a lógica de uma implementação de forma mais natural e simplificada. Exemplo de linguagens que usam OOP incluem: Java, Python, C++ e C#.

## Structs

Para exemplificar melhor, vamos voltar para a Struct "Pessoa" que fizemos aulas atrás, para explicar como uma classe funciona.

#### C

```c
struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
};
``` 

Você também deve se lembrar que para instanciar e manipular dados dessa nossa struct, usavamos essa sintaxe:

#### C

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

Vamos supor que agora queremos transformar essa Struct em uma classe, como podemos fazer isso?

## Traduzindo a Struct para a Classe

Vamos começar então com mais básico necessário para criar essa classe: 

### C++

```cpp
#include<iostream>
#include<string>

class Pessoa {
  private:
    std::string nome;
    int idade;
    int altura_em_cm;
    float peso_em_kg;
};

int main(void) {
  std::cout << "Hello world!\n";
  // Obs.: Se estivessemos criando essa instancia como ponteiro, nos utilizariamos a palavra "new"
  // antes de Pessoa, assim:
  // Pessoa* joao = new Pessoa();
  Pessoa joao = Pessoa(); // Ou "Pessoa joao();"
  return 0;
}
```

### Java

```java
class Pessoa {
  private String nome;
  private int idade;
  private int altura_em_cm;
  private double peso_em_kg;
}

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!\n");
    Pessoa joao = new Pessoa();
  }
}
```

Até aqui não tem nada de muito novo, nós criamos uma classe, e então instanciamos um objeto da nossa classe, então temos essa variável "joão" que é uma instância da classe "Pessoa". Mas nessa sopa de letrinhas você deve ter notado uma palavra nova: "private".

## Escopo de uma classe

Quando estamos trabalhando com classes, nós precisamos definir quais membros da minha classe são acessíveis fora da classe, e para isso nós temos essas três palavras chave (mais comuns): "private", "public" e "protected".

### Private 

Private significa que esse membro é apenas acessível dentro da classe. Então significa que se tentarmos acessar um elemento da classe, como no exemplo 
abaixo:

#### C++

```cpp
int main(void) {
  std::cout << "Hello world!\n";
  Pessoa joao = Pessoa();
  joao.nome = "João";
  return 0;
}
```

#### Java

```java
public static void main(String[] args) {
  System.out.println("Hello world!\n");
  Pessoa joao = new Pessoa();
  joao.nome= "João";
}
```

Nós iremos receber o erro de que esse membro da classe "nome" é inacessível ou que ele não é visível, e isso acontece justamente por termos utilizado essa palavra chave "private". Mas e se quisermos modificar fora da classe? Para isso usamos a palavra "public"

### Public

Public significa que esse membro pode ser acessado/modificado fora dele. Em outras palavras, se quisermos mudar o nome da nossa pessoa fora da classe, agora podemos.

#### C++

```cpp
class Pessoa {
  public: // Especificamos que essas variáveis agora sao publicas
    std::string nome;
    int idade;
    int altura_em_cm;
    float peso_em_kg;
};
``` 

#### Java

```java
class Pessoa {
  public String nome; 
  public int idade;
  public int altura_em_cm;
  public double peso_em_kg;
}
``` 

A palavra chave protected, iremos deixar para explorar ela quando falarmos de herança.

## Construtor

Você também deve ter notado, que para criar uma instância de uma classe, precisamos invocar essa função com o nome da classe

#### C++

```cpp
Pessoa joao = Pessoa();
```

#### Java

```java
Pessoa joao = new Pessoa();
```

Isso é uma função especial chamada de "Construtor", e ela é sempre chamada quando criamos um objeto de uma classe. No caso, como
não especificamos nenhum construtor, então esse construtor vazio, apenas irá iniciar nossa instância, mas não nossos atributos (nome, idade, altura...).

Para isso então, vamos criar o nosso construtor:

#### C++

```cpp
#include<iostream>
#include<string>

class Pessoa {

  std::string nome;
  int idade;
  int altura_em_cm;
  float peso_em_kg;

  public:
    Pessoa(std::string nome, int idade, int altura_em_cm, float peso_em_kg) {
      this->nome = nome;
      this->idade = idade;
      this->altura_em_cm = altura_em_cm;
      this->peso_em_kg = peso_em_kg;
    }
    // Em c++ nós também temos classes chamadas de "Desconstrutores" que são chamados quando um objeto
    // sai do escopo e está prestes a ser deletado, falaremos disso mais tarde.
};

int main(void) {
  std::cout << "Hello world!\n";
  Pessoa joao = Pessoa("João", 32, 174, 70.3);
  return 0;
}
``` 

#### Java

```java
class Pessoa {
  private String nome;
  private int idade;
  private int altura_em_cm;
  private double peso_em_kg;
 
  public Pessoa(String nome, int idade, int altura_em_cm, double peso_em_kg) {
      this.nome = nome;
      this.idade = idade;
      this.altura_em_cm = altura_em_cm;
      this.peso_em_kg = peso_em_kg;
  }
}

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!\n");
    Pessoa joao = new Pessoa("João", 32, 174, 70.3);
  }
}
```

Obs.: Nós podemos ter mais de um construtor dentro de uma classe, ele só precisa ter argumentos diferentes.

Agora nós criamos um construtor para a nossa classe, lembrando sempre de respeitar a sintaxe das funções de Construtor, onde a função precisa ter o nome da sua classe (Não se esquecendo de especificar o escopo se necessário).

Uma coisa que você deve ter notado é que nós utilizamos essa palavra "this". Essa palavra serve para referenciarmos especificamente elementos da nossa classe. Não precisamos usar sempre essa palavra para referenciar eles, apenas quando dentro de um mesmo escopo, temos duas variáveis com o mesmo nome.

#### Java
```java
  private String nome;
  private int idade;
  private int altura_em_cm;
  private double peso_em_kg;
  
  public Pessoa(String nome, int idade, int altura_em_cm, double peso_em_kg) {
      this.nome = nome; // perceba que "this.nome" se refere ao membro da classe "String nome", enquanto que a variável
                        // "nome" se refere ao parâmetro passado ao construtor da classe
``` 

## Funções dentro da nossa classe

Para finalizar vamos criar uma classe que seja capaz de imprimir os dados da minha variável "João", para isso iremos criar funções dentro das nossas classes que possam fazer essa tarefa de converter dados da nossa classe em String.

Em Java, nós podemos sobrescrever a função mágina "toString()" da nossa classe, para reproduzir esse comportamento. Em C++ iremos apenas criar uma função própria para fazer isso e usar uma classe chamada "std::stringstream" para converter os dados da classe para uma String.


#### C++

```cpp
#include<iostream>
#include<string>
#include <sstream>

class Pessoa {

  std::string nome;
  int idade;
  int altura_em_cm;
  float peso_em_kg;

  public:
    Pessoa(std::string nome, int idade, int altura_em_cm, float peso_em_kg) {
      this->nome = nome;
      this->idade = idade;
      this->altura_em_cm = altura_em_cm;
      this->peso_em_kg = peso_em_kg;
    }

    std::string to_string() {
      std::stringstream s; // criando a nossa stream
      s << "Nome: " << nome << "\nIdade: " << idade << " anos\nAltura (em cm): " << altura_em_cm << "cm\nPeso (em kg): " << peso_em_kg << "kg";
      return s.str(); // convertendo a stream para um tipo de dado que podemos usar na hora de imprimir
    }
};


int main(void) {
  std::cout << "Hello world!\n";
  Pessoa joao("João", 32, 174, 70.3);
  std::cout << joao.to_string() << "\n";
  return 0;
}
``` 

### Java

```java
class Pessoa {
    private String nome;
    private int idade;
    private int altura_em_cm;
    private double peso_em_kg;

    public Pessoa(String nome, int idade, int altura_em_cm, double peso_em_kg) {
        this.nome = nome;
        this.idade = idade;
        this.altura_em_cm = altura_em_cm;
        this.peso_em_kg = peso_em_kg;
    }

    @Override //Override indica uma função que está sendo sobrescrita, falaremos disso nas próximas aulas
    public String toString() {
        return "Nome: " + nome + "\n" +
               "Idade: " + idade + " anos\n" + 
               "Altura (em cm): " + altura_em_cm + "cm\n" +
               "Peso (em kg): " + peso_em_kg + "kg";
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      System.out.println("Hello world!\n");
      Pessoa joao = new Pessoa("João", 32, 174, 70.3);
      System.out.println(joao);
    }
  }
```

E por enquanto é isso, agora você deve ter uma ideia geral de como uma classe funciona. É importante notar que a maior parte dessas ideias nós passamos por alto, e planejo voltar a elas em futuras aulas, então se tudo pareceu muito confuso, não se preocupe.

## Links úteis

- [POO - Dicionário do Programador](https://youtu.be/QY0Kdg83orY)
- [Introdução a programação orientada a objetos](https://youtu.be/SiBw7os-_zI)
