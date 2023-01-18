# Entendendo Polimorfismo

Para finalizar o tópico de POO, vamos falar um pouco sobre Polimorfismo, que é mais um dos princípios que utilizamos quando trabalhamos com esse paradigma da Computação. A palavra Polimorfismo tem como origem nas palavras "poly" (muitas) e "morphe" (forma(s)) ou em outras palavras "muitas formas" e basicamente descreve um objeto que pode apresentar uma única interface a apresentar múltiplos comportamentos diferentes. Parece um conceito meio arbitrário, mas não se preocupe, acredito que alguns exemplos serão mais do que o suficientes.

## Polimorfismo em tempo de Compilação

A primeira forma de Polimorfismo é a chamada "Compile-time polymorphism" ou "Polimorfismo em tempo de compilação" em tradução literal. Em sumo, esse tipo de polimorfismo recebe esse nome pois reflete um comportamento que é resolvido pelo compilador, durante a compilação do programa-alvo. Aqui nós temos dois tipo de polimorfismo: Sobrecarga de funções (function/method overloading) e Sobrecarga de Operadores (operator overloading).

### Sobrecarga de funções

Você se lembra quando estavamos programando funções recursiva, e nós tinhamos a nossa função interface e a função recursiva?

```c
#include<stdio.h>

void imprimir_hello_world_rec(int i, int n) {
  
  if (i < n) {
    printf("Hello world!\n");
    imprimir_hello_world_rec(++i,n);
  }
}

void imprimir_hello_world(int n) {
  int i = 0;
  imprimir_hello_world_rec(i, n);
}

int main(void) {

  int n = 0;
  scanf("%d", &n);
  imprimir_hello_world(n);
  return 0;
}
```

Perceba que a função interface a função recursiva possuem nomes diferentes, pois em C, não podemos criar funções com o mesmo nome. Porém em linguagens que possuem orientação a objeto isso é possível, graças ao tipo de polimorfismo em questão "Sobrecarga de funções".

```java
    public void imprimir_hello_world(int i, int n) {
        if (i < n) {
            System.out.println("Hello world!\n");
            imprimir_hello_world(++i,n);
        }
    }

    public void imprimir_hello_world(int n) {
        int i = 0;
        imprimir_hello_world(i, n);
    }
```

Aqui está esse mesmo código, só que em Java e usando sobrecarga de funções. Em outras palavras, podemos ter duas funções com o mesmo nome, desde que elas tenham número diferentes de variáveis ou que as variáveis sejam de tipos diferentes.

Uma curiosidade interessante, você também pode replicar esse comportamento para Construtores.

```java
class Pessoa {
  public String nome;
  public String cpf;
  public double saldo;
  
  public Pessoa(String nome, String cpf, double saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.saldo = saldo;
  }
  
  public Pessoa() {
    this.nome = "Joao";
    this.cpf = "123.456.342-43";
    this.saldo = 4945;
  }
}
``` 
Observe que, ambos são construtores e possuem a mesma sintaxe de criação, porém possuem argumentos diferentes, logo, não há conflito na hora de compilar o programa.

### Sobrecarga de Operadores

Já a sobrecarga de operadores é um pouco mais incomum de usar (e nem possui na linguagem Java), mas em resumo, sobrecarga de operadores permite que sejá possível usar os operadores aritméticos, relacionais e lógicos junto as nossas classes que criamos.

Como exemplo, vamos supor que queremos criar um comportamento que permita ver se duas pessoas são as mesmas, fazendo checagem do CPF. A primeira ideia que muito de vocês teriam seria esta:

```c++
#include<iostream>
#include<string>

class Pessoa {
  private:
    std::string nome;
    std::string cpf;
    float saldo;
    
  public:
  
    Pessoa(std::string nome, std::string cpf, float saldo) {
      this->nome = nome;
      this->cpf = cpf;
      this->saldo = saldo;
    }
    // Funcoes getters
    std::string get_nome() {
      return nome;
    }
    
    std::string get_cpf() {
      return cpf;
    }
    
    float get_saldo() {
      return saldo;
    }
};

int main(void) {
  Pessoa joao = Pessoa("Joao","58423593212",4584);
  Pessoa maria = Pessoa("Maria","86821952566",3553);

  if (joao.get_cpf() == maria.get_cpf()) {
    std::cout << "São a mesma pessoa!\n";
  } else {
    
    std::cout << "São pessoas diferentes!\n";
  }
  return 0;
}
```

Aqui nós utilizamos os nossos getters para comparar se as strings que representam o CPF é o mesmo. Porém, utilizando operator overloading, podemos fazer uma solução que é mais simples e elegante.

```c++
#include<iostream>
#include<string>

class Pessoa {
  private:
    std::string nome;
    std::string cpf;
    float saldo;
    
  public:
  
    Pessoa(std::string nome, std::string cpf, float saldo) {
      this->nome = nome;
      this->cpf = cpf;
      this->saldo = saldo;
    }
    // Funcoes getters
    std::string get_nome() {
      return nome;
    }
    
    std::string get_cpf() {
      return cpf;
    }
    
    float get_saldo() {
      return saldo;
    }

    bool operator== (const Pessoa &p1) {
        return this->cpf == p1.cpf;
    }
};

int main(void) {
  Pessoa joao = Pessoa("Joao","58423593212",4584);
  Pessoa maria = Pessoa("Maria","86821952566",3553);

  if (joao == maria) {
    std::cout << "São a mesma pessoa!\n";
  } else {

    std::cout << "São pessoas diferentes!\n";
  }
  return 0;
}
``` 

Observe a sintaxe na hora de usar as funções de sobrecarga de operadores, neste caso, como a operação de igual envolve retornar um operador lógico o tipo de retorno é um booleano "bool", e o nome da função é sempre uma variação de "operator" acompanhado do operador que queremos fazer sobrecarga.

Apesar de ser uma funcionalidade bem interessante, não iremos entrar em mais detalhes já que não utilizamos com tanta frequência e nem é toda linguagem que possui essa funcionalidade. Caso queira ler mais sobre assunto dê uma olhada nos links úteis dessa aula.

## Polimorfismo em tempo de execução

Aqui, como o nome sugere, em vez do Compilador resolver o comportamento múltiplo em tempo de compilação, esse tipo de polimorfismo é resolvido durante a execução do código. Aqui vamos explorar apenas um único tipo que é a Sobreposição de funções/métodos.

### Sobreposição de funções

Em sobrecarga de funções vimos que podemos ter funções com o mesmo nome mas que possuem comportamentos diferentes, dependendo dos argumentos que são passados para mesma. Neste tipo de polimorfismo temos o comportamento contrário, aqui nós teremos uma função que será sobreposta a outra função com o mesmo nome e os mesmos argumentos.

Para melhor exemplificar, vamos voltar para a nossa classe ```Veiculo``` e ```Sedan```, e vamos adicionar o funcionamento para imprimir o tipo de veiculo a partir de uma função.

Em C++ podemos usar a palavra "virtual" para especificar uma função que pode ser redefinida em uma classe filha e a palavra "override" para especificar uma função que está sobrescrevendo uma função já existente. Observe o exemplo abaixo:

```c++
#include<string> 
#include<iostream>

class Veiculo {
  
  protected: 
   
    std::string placa;
    std::string cor;
    float peso_em_kg;
    int altura_em_cm;
    
    public: 
        Veiculo(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) {
          this->placa = placa;
          this->cor = cor;
          this->peso_em_kg = peso_em_kg;
          this->altura_em_cm = altura_em_cm;
          std::cout << "Veiculo iniciado!\n";
        }
        
        void acelerar() {
          std::cout << "Vrrmmmmmm!!\n";
        }

        virtual std::string get_tipo() {
            return "Não definido";
        }

}; 

class Sedan : public Veiculo {
    public: 
        Sedan(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) : Veiculo(placa, cor, peso_em_kg, altura_em_cm) {
        }

        std::string get_tipo() override {
            return "Sedan";
        }
};

int main(void) {
    Sedan v = Sedan("HDX-3821", "Amarelo", 1554.3, 165);
    v.acelerar();
    std::cout << v.get_tipo() << "\n";
    return 0;
}
``` 

Aqui temos a função "get_tipo" que é do tipo "string" e retorna o tipo de veiculo que estamos trabalhando, e na classe "Sedan" essa função é sobrescrita e dessa vez apenas retorna "Sedan".

Já em Java, podemos usar o decorador "@Override" para específicar uma função que foi sobrescrita.

```java
class Veiculo {

    String placa;
    String cor;
    double peso_em_kg;
    int altura_em_cm;
   
    public Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
      this.placa = placa;
      this.cor = cor;
      this.peso_em_kg = peso_em_kg;
      this.altura_em_cm = altura_em_cm;
    }
    
    void acelerar() {
      System.out.println("Vrrmmmmmm!!"); 
    }

    String get_tipo() {
        return "Não definido";
    }
}
  
class Sedan extends Veiculo {

    public Sedan(String placa, String cor, double peso_em_kg, int altura_em_cm) {
        super(placa, cor, peso_em_kg, altura_em_cm);
    }

    @Override
    String get_tipo() {
        return "Sedan";
    }
    
}

  public class Main {
  
      public static void main(String[] args) {
          
          Sedan v = new Sedan("HDX-3821", "Amarelo", 1554.3, 165);
          v.acelerar();
          System.out.println(v.get_tipo());
      }
  }
```

Em Java, existe como também usar esse tipo de polimorfismo de outra maneira, usando "Interfaces", mas para isso, deixarei links úteis para você continuar a sua leitura.

## Links úteis

- [Polymorphism - Microsoft](https://learn.microsoft.com/en-us/dotnet/csharp/fundamentals/object-oriented/polymorphism) 
- [Polymorphism in Java](https://www.geeksforgeeks.org/polymorphism-in-java/)
- [Operator Overloading](https://www.geeksforgeeks.org/operator-overloading-c/)
- [Interfaces em Java](https://www.devmedia.com.br/entendendo-interfaces-em-java/25502)

