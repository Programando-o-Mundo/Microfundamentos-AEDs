# Entendendo Herança

## Você irá aprender

- O que é Herança.
- Porque usar Herança.
- Como usar Herança.

## Pré-requisitos

- [O que é POO](1-O-que-eh-POO.md)

## Reusando Com

Nesta e na próxima aula trabalharemos com um dos pilares de POO mais importantes que tem. O nome dele é a Herança, onde criamos classes (classe filha) que compartilha dados e métodos herdados de outra classe (classe pai). O objetivo desse princípio é para a generalização de código onde existem muitos componentes com lógicas parecidas/iguais que podem ser abstraídos para uma classe separada.

## Como usar Herança

Primeiramente voltaremos para a nossa classe Veículo. Suponhamos que queremos criar uma classe ```Sedan``` para separar lógica com carros de outros tipos. Obviamente um ```Sedan``` ainda é um carro, então podemos usar a Herança para importar essa lógica da classe Veículo e adicionar em cima da nossa nova classe ```Sedan```.

Observe a sintaxe de como usamos herança:

### C++

```cpp
class Sedan : public Veiculo {
    
};
```

Basicamente, nós criamos a classe e logo após colocar o nome da classe, colocamos dois pontos ":" seguido de um especificador de acesso (opcional) e por fim a classe de onde a nossa nova classe será herdada.

Note que esse especificador de acesso que colocamos, indica qual será a visibilidade dos atributos da classe na qual está sendo herdada. Ou seja, se herdamos de uma classe de forma pública como no exemplo acima.

* Membros públicos herdados podem ser acessados.
* Membros privados herdados não podem ser acessados.

Se colocarmos a herança como privada, então todos os atributos ficaram como privado.

### Java

```java
class Sedan extends Veiculo {

}
```

Em java é mais simples, basta usar a palavra "extends" seguido do nome da classe que queremos herdar. As regras de acesso de escopo são as mesmas de uma herança pública de C++.

## Acessando a classe base da classe filha

Agora que criamos a nossa classe, precisamos iniciar os nossos dados e iniciar o nosso construtor. Em Java, quando criamos uma classe que herda de outra, precisamos chamar o construtor da classe base, usando a palavra ```super```.

### Java

```java
class Veiculo {

    public String placa;
    public String cor;
    public double peso_em_kg;
    public int altura_em_cm;
   
    public Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
      this.placa = placa;
      this.cor = cor;
      this.peso_em_kg = peso_em_kg;
      this.altura_em_cm = altura_em_cm;
    }
    
    void acelerar() {
      System.out.println("Vrrmmmmmm!!\n"); 
    }
}
  
class Sedan extends Veiculo {
    public Sedan(String placa, String cor, double peso_em_kg, int altura_em_cm) {
        super(placa, cor, peso_em_kg, altura_em_cm);
    }
}
``` 

Em c++, nós temos uma sintaxe específica para replicar esse comportamento.

### C++

```cpp
class Veiculo {
  
  public: 
   
    std::string placa;
    std::string cor;
    float peso_em_kg;
    int altura_em_cm;
    
    Veiculo(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) {
      this->placa = placa;
      this->cor = cor;
      this->peso_em_kg = peso_em_kg;
      this->altura_em_cm = altura_em_cm;
    }
    
    void acelerar() {
      std::cout << "Vrrmmmmmm!!\n";
    }
}; 

class Sedan : public Veiculo {
    public: 
        Sedan(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) : Veiculo(placa, cor, peso_em_kg, altura_em_cm) {
           
        }
};
``` 

Em ambas situações, nós estamos criando um construtor na classe filho ```Sedan``` que fará como primeira ação, chamar o construtor da classe pai ```Veiculo```. Podemos comprovar esse comportamento, colocando uma instrução de print nos construtores.

### Java

```java
class Veiculo {

    public String placa;
    public String cor;
    public double peso_em_kg;
    public int altura_em_cm;
   
    public Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
      this.placa = placa;
      this.cor = cor;
      this.peso_em_kg = peso_em_kg;
      this.altura_em_cm = altura_em_cm;
      System.out.println("Veiculo iniciado!");
    }
    
    void acelerar() {
      System.out.println("Vrrmmmmmm!!"); 
    }
}
  
class Sedan extends Veiculo {

    public Sedan(String placa, String cor, double peso_em_kg, int altura_em_cm) {
        super(placa, cor, peso_em_kg, altura_em_cm);
        System.out.println("Sedan iniciado!");
    }
    
}

public class Main {

  public static void main(String[] args) {

      Sedan v = new Sedan("HDX-3821", "Amarelo", 1554.3, 165);
      v.acelerar();
      v.peso_em_kg = 2033.5;
      System.out.println(v.peso_em_kg);
  }
}
```

### C++

```cpp
#include<string> 
#include<iostream>

class Veiculo {
  
  public:
   
    std::string placa;
    std::string cor;
    float peso_em_kg;
    int altura_em_cm;
    
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
}; 

class Sedan : public Veiculo {
    public: 
        Sedan(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) : Veiculo(placa, cor, peso_em_kg, altura_em_cm) {
           std::cout << "Sedan iniciado!\n"; 
        }
};

int main(void) {
    Sedan v = Sedan("HDX-3821", "Amarelo", 1554.3, 165);
    v.acelerar();
    v.peso_em_kg = 2033.5;
    std::cout << v.peso_em_kg << "\n";
    return 0;
}
```

Esse será o resultado do nosso código quando rodamos ele:

```
Veiculo iniciado!
Sedan iniciado!
Vrrmmmmmm!!
2033.5
```

Perceba que primeiro, o código irá executar primeiro o construtor da classe base e depois irá executar o código da classe herdada. 

## Palavra chave "protected"

Até então mantemos um suspense a respeito do que a palavra "protected" faz e agora podemos explicar. Quando criamos uma variável privada na classe pai, nós não podemos acessar ela na classe filha, observe o exemplo abaixo.

### C++

```cpp
#include<string> 
#include<iostream>

class Veiculo {
  
  private: 
   
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
}; 

class Sedan : public Veiculo {
    public: 
        Sedan(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) : Veiculo(placa, cor, peso_em_kg, altura_em_cm) {
           std::cout << "Sedan iniciado!\n"; 
           this->placa = placa;
        }
};

int main(void) {
    Sedan v = Sedan("HDX-3821", "Amarelo", 1554.3, 165);
    v.acelerar();
    return 0;
}
``` 

### Java

```java
class Veiculo {

    private String placa;
    private String cor;
    private double peso_em_kg;
    private int altura_em_cm;
   
    public Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
      this.placa = placa;
      this.cor = cor;
      this.peso_em_kg = peso_em_kg;
      this.altura_em_cm = altura_em_cm;
    }
    
    void acelerar() {
      System.out.println("Vrrmmmmmm!!"); 
    }
}
  
class Sedan extends Veiculo {

    public Sedan(String placa, String cor, double peso_em_kg, int altura_em_cm) {
        super(placa, cor, peso_em_kg, altura_em_cm);
        this.placa = placa;
    }
    
}

  public class Main {
  
      public static void main(String[] args) {
          
          Sedan v = new Sedan("HDX-3821", "Amarelo", 1554.3, 165);
          v.acelerar();
      }
  }
  ```

Agora colocamos as variáveis do ```Veículo``` como privadas e estamos tentando acessar elas pelo construtor da classe ```Sedan```. Esse comportamento irá gerar um erro, pois variáveis de escopo privado não são visíveis para classe filha.

#### C++

```
main.cpp: In constructor ‘Sedan::Sedan(std::string, std::string, float, int)’:
main.cpp:31:18: error: ‘std::string Veiculo::placa’ is private within this context
   31 |            this->placa = placa;
      |                  ^~~~~
main.cpp:8:17: note: declared private here
    8 |     std::string placa;
      |                 ^~~~~
```

### Java

``` 
Main.java:24: error: placa has private access in Veiculo
        this.placa = placa;
``` 

Para consertar isso, precisamos colocar essas variáveis como ```protected``` permitindo assim o acesso delas na classe filha.

```cpp
  protected: 
   
    std::string placa;
    std::string cor;
    float peso_em_kg;
    int altura_em_cm;
````

```java
    protected String placa;
    protected String cor;
    protected double peso_em_kg;
    protected int altura_em_cm;
```

### Armazenando instâncias de uma classe filha

Um comportamento que surgiu com a Herança é a capacidade de armazenar instâncias de uma classe filha em um Array de uma classe pai. Suponhamos que estamos trabalhando em uma loja de Carros e para isso precisamos de um array que represente os carros que estão disponíveis para comprar.

Uma coisa interessante é que podemos guardar instâncias da classe "Sedan" em um array de "Veiculo". O que não podemos fazer é guardar instâncias de uma classe pai na classe filha.

### Java

```java
  public class Main {
  
      public static void main(String[] args) {
          
          Sedan v = new Sedan("HDX-3821", "Amarelo", 1554.3, 165);
          v.acelerar();
          Veiculo[] veiculos = new Veiculo[10];
          veiculos[0] = new Sedan("AVD-5932", "Azul", 1800, 155);
      }
  }
```

### C++

```cpp
#include<string> 
#include<iostream>

class Veiculo {
  
  protected: 
   
    std::string placa;
    std::string cor;
    float peso_em_kg;
    int altura_em_cm;
    
    public: 

        Veiculo() { // Em c++ para criar um array de elementos, precisamos ter um construtor vazio
            
        }

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
    Veiculo vs[10];
    vs[1] = Sedan("AVD-5932", "Azul", 1800, 155);
    return 0;
}
```

Para finalizar essa aula eu gostaria de te fazer um convite para um dos vídeos que está na seção de **Links úteis**. Por mais que Herança possa ser muito útil, e é um dos pilares da Programação Orientada a Objetos, nem sempre usar herança é uma boa opção, e para entender mais sobre o assunto, assista o vídeo que está na seção abaixo.

## Links úteis

- [Inheritance and access specifiers](https://www.learncpp.com/cpp-tutorial/inheritance-and-access-specifiers/)
- [Herança em C++](https://acervolima.com/heranca-em-c/)
- [Entendendo e aplicando Herança em Java](https://www.devmedia.com.br/entendendo-e-aplicando-heranca-em-java/24544)
- [Os problemas de usar Herança](https://youtu.be/hxGOiiR9ZKg)
