# Criando nossa primeira classe

Anteriormente, nós transformamos uma dos nossos antigos exemplos de Struct para uma classe. Por mais que esse exemplo tenha sido ótimo para iniciar o nosso estudo em classes, acredito que seria melhor darmos alguns passos para trás, e criar uma nova classe do zero, para que possamos melhor entender os conceitos de POO

## Criando uma classe para classificar carros

Vamos supor que agora queremos criar uma classe que possa gerenciar um carro. Um carro pode ser determinado pela sua placa, sua cor, seu peso, e sua altura (pelo menos por agora, vamos deixar essas características). Agora que determinamos o que queremos, vamos então criar a nossa classe, mas antes, vamos rever a sintaxe para criar uma classe.

## Sintaxe da criação de classes.

Primeiramente nós começamos com a palavra ```class```, seguida do nome da nossa classe. Essa sintaxe é muito comum na maioria das linguagens que suportam POO, inclusive C++ e Java.

Obs.: Geralmente criamos classe com o primeiro caractere em caixa alta.
```
class Veiculo
```

A única diferença é que em Java, podemos indicar também o escopo de acesso da classe, com as palavras ```public```, ```private``` e ```protected```. Mas isso não é tão importante assim para nós no momento.

Após isso, nós iremos colocar duas chaves, igual quando criamos uma função:

```C++
class Veiculo {

}; // Note que em C++, precisamos colocar esse ponto-e-vírgula após a segunda chave.
``` 
```Java
class Veiculo {

    
}
``` 
Assim como em funções, as chaves indicam o escopo para os **atributos** da nossa classe, isto é, os membros de dados e funções que pertencem ao nosso veículo.

## Criando variáveis

Agora que temos as nossas classes, vamos criar alguns atributos para a nossa classe, vamos começar criando as nossa variáveis. você vai observar que tanto para criar variáveis e declara funções dentro de classes envolve usar a mesma sintaxe que já estamos acostumados.

```C++
#include<string> // Necessario para usar a std::string
class Veiculo {
  
  std::string placa;
  std::string cor;
  float peso_em_kg;
  int altura_em_cm;
  
}; 
``` 

```Java
class Veiculo {

  String placa;
  String cor;
  float peso_em_kg;
  int altura_em_cm;
}
``` 
Obs.: Observe que diferente de C, C++ e Java possui em suas bibliotecas padrões uma implementação da estrutura String. Esse ```std``` no código de C++ refere ao fato de que essa implementação da String vem da biblioteca padrão do C++ ([C++ Standard Library](https://en.cppreference.com/w/cpp/header)), e por isso não se esqueça de importar a biblioteca específica no seu código.

## Criando construtor

Agora que temos as nossa variáveis, precisamos criar um mecanismo para iniciar as variáveis da nossa classe, para isso, usamos os chamados "Construtores" que são funções especiais na qual são chamadas no momento em que criamos a instância da nossa classe. A sintaxe da crição de construtores é mesma de quando criamos funções, porém esta função tem o nome da nossa classe.

```java
NomeDaClasse(argumentos) {

}
```
Observe os dois exemplos abaixo:

```C++
#include<string> // Necessario para usar a std::string
class Veiculo {
  
  std::string placa;
  std::string cor;
  float peso_em_kg;
  int altura_em_cm;
  
  public: // Aqui estamos indicando a visibilidade dos componentes criados abaixo
  
    Veiculo(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) {
      
    }
}; 
``` 

```Java
class Veiculo {

  String placa;
  String cor;
  float peso_em_kg;
  int altura_em_cm;
  
  // Assim como a criação de classes em Java, também podemos especificar o escopo de acesso dos contrutores assim:
  // public Veiculo(String placa...)
  Veiculo(String placa, String cor, double peso, int altura_em_cm) {
  
  }
}
``` 

Com o construtor criado, precisamos iniciar os nossos atributos, mas perceba que tanto o nome dos argumentos da funcao, quanto o nome dos atributos da classe são os mesmos, como é que fazemos essa diferenciação? 

### Palavra chave "this"

As linguagens que tem suporte a POO geralmente usam alguma palavra chave para se referir a atributos que pertencem a classe, no caso de C++ e Java, nós temos a palavra "this", usando ela, podemos diferenciar as variáveis da classe e as variáveis de um escopo local.

```C++
#include<string> // Necessario para usar a std::string
class Veiculo {
  
  std::string placa;
  std::string cor;
  float peso_em_kg;
  int altura_em_cm;
  
  public: // Aqui estamos indicando a visibilidade dos componentes criados abaixo
  
    Veiculo(std::string placa, std::string cor, float peso_em_kg, int altura_em_cm) {
      this->placa = placa;
      this->cor = cor;
      this->peso_em_kg = peso_em_kg;
      this->altura_em_cm = altura_em_cm;
    }
}; 
``` 

```Java
class Veiculo {

  String placa;
  String cor;
  float peso_em_kg;
  int altura_em_cm;
 
  Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
    this.placa = placa;
    this.cor = cor;
    this.peso_em_kg = peso_em_kg;
    this.altura_em_cm = altura_em_cm;
  }
}
``` 

Obs.: Podemos usar a palavra ```this``` para se referir a uma função também.

## Criando funções

Podemos criar funções dentro das nossas classes, usando a mesma sintaxe para criar funções fora da classe. Para dar exemplo, vamos criar uma função para ser chamada, que simula quando pisamos no acelerador do carro.

```C++
#include<string> // Necessario para usar a std::string
class Veiculo {
  
  std::string placa;
  std::string cor;
  float peso_em_kg;
  int altura_em_cm;
  
  public: // Aqui estamos indicando a visibilidade dos componentes criados abaixo
  
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
``` 

```Java
class Veiculo {

  String placa;
  String cor;
  float peso_em_kg;
  int altura_em_cm;
 
  Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
    this.placa = placa;
    this.cor = cor;
    this.peso_em_kg = peso_em_kg;
    this.altura_em_cm = altura_em_cm;
  }
  
  void acelerar() {
    System.out.println("Vrrmmmmmm!!\n"); 
  }
}
``` 
Ótimo! Por fim, vamos então instanciar a nossa classe e chamar os seus atributos.

## Instanciado a nossa classe e chamando os seus atributos

Vamos voltar a main e agora vamos instanciar um objeto da nossa classe Veículo.

```Java
class Veiculo {

  String placa;
  String cor;
  float peso_em_kg;
  int altura_em_cm;
 
  Veiculo(String placa, String cor, double peso_em_kg, int altura_em_cm) {
    this.placa = placa;
    this.cor = cor;
    this.peso_em_kg = peso_em_kg;
    this.altura_em_cm = altura_em_cm;
  }
  
  void acelerar() {
    System.out.println("Vrrmmmmmm!!\n"); 
  }
}

public class Main {

    public static void main(String[] args) {
        
        Veiculo v = new Veiculo("HDX-3821", "Amarelo", 1554.3, 165);
        v.acelerar();
    }
}
``` 
