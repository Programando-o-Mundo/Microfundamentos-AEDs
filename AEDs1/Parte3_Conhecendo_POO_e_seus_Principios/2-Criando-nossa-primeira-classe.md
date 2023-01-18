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
  double peso_em_kg;
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
#include<string> 
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

  public String placa;
  public String cor;
  public double peso_em_kg;
  public int altura_em_cm;
  
  public Veiculo(String placa, String cor, double peso, int altura_em_cm) {
  
  }
}
``` 

Com o construtor criado, precisamos iniciar os nossos atributos, mas perceba que tanto o nome dos argumentos da funcao, quanto o nome dos atributos da classe são os mesmos, como é que fazemos essa diferenciação? 

### Palavra chave "this"

As linguagens que tem suporte a POO geralmente usam alguma palavra chave para se referir a atributos que pertencem a classe, no caso de C++ e Java, nós temos a palavra "this", usando ela, podemos diferenciar as variáveis da classe e as variáveis de um escopo local.

```C++
#include<string> 
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
}
``` 

Obs.: Podemos usar a palavra ```this``` para se referir a uma função também.

## Criando funções

Podemos criar funções dentro das nossas classes, usando a mesma sintaxe para criar funções fora da classe. Para dar exemplo, vamos criar uma função para ser chamada, que simula quando pisamos no acelerador do carro.

```C++
#include<string> 
#include<iostream>

class Veiculo {
  
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
    }
    
    void acelerar() {
      std::cout << "Vrrmmmmmm!!\n";
    }
}; 
``` 

```Java
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
``` 
Ótimo! Por fim, vamos então instanciar a nossa classe e chamar os seus atributos.

## Instanciado a nossa classe

Vamos voltar a main e agora vamos instanciar um objeto da nossa classe Veículo. Para instanciar um objeto nós fazemos igual uma declaração de uma estrutura de dados qualquer, primeiro colocamos o tipo, seguido do nome da variável.

```
NomeDaClasse nomeDaVariavel
```

Depois disso, é onde começamos a ter algumas diferenças. Tanto em C++,e em Java, você coloca um sinal de igual, seguido da palavra "new" e o nome da classe,. A diferença chave é que, em C++, você só usa a palavra "new" se a instância que você está criando é feita usando alocação de memória, caso contrário é só retirar a palavra "new".

Depois disso, nós colocamos os parênteses, igual quando estamos invocando uma função, e passamos para dentro dos parênteses os nossos argumentos (se tiver).

### Java
```java
NomeDaClasse nomeDaVariavel = new NomeDaClasse();
```

### C++
```c++
# Usando alocacao dinamica
NomeDaClasse* nomeDaVariavel = new NomeDaClasse();

# Sem alocacao dinamica
NomeDaClasse nomeDaVariavel = NomeDaClasse();
# Tambem pode criar a instancia assim
NomeDaClasse nomeDaVariavel();
``` 

Aqui está um exemplo mais concreto disso:

```Java
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

public class Main {

    public static void main(String[] args) {
        
        Veiculo v = new Veiculo("HDX-3821", "Amarelo", 1554.3, 165);
    }
}
``` 

```C++
#include<string>
#include<iostream>

class Veiculo {
  
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
    }
    
    void acelerar() {
      std::cout << "Vrrmmmmmm!!\n";
    }
}; 

int main(void) {
    Veiculo v = Veiculo("HDX-3821", "Amarelo", 1554.3, 165);
    return 0;
}
``` 

Importante notar que em C++, a ordem que as coisas são declaradas no código é importante e por conta disson lembre-se de declarar a classe antes da função main.

## Chamando os atributos da classe

Para chamar atributos da classe, a sintaxe também é bem parecida, com uma única diferença, colocamos o nome da variável seguido de ponto e o nome do atributo que queremos acessar:

``` 
nomeDaVariavel.nomeDoAtributo
```

Lembrando, atributo pode ser tanto uma função, quanto uma variável.

```Java
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

public class Main {

    public static void main(String[] args) {
        
        Veiculo v = new Veiculo("HDX-3821", "Amarelo", 1554.3, 165);
        v.acelerar();
        v.peso_em_kg = 2033.5;
        System.out.println(v.peso_em_kg);
    }
}
``` 

```C++
#include<string> 
class Veiculo {
  
  public: // Para esse exemplo, coloquei todos os atributos como publico
   
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

int main(void) {
    Veiculo v = Veiculo("HDX-3821", "Amarelo", 1554.3, 165);
    v.acelerar();
    v.peso_em_kg = 2033.5;
    std::cout << v.peso_em_kg << "\n";
    return 0;
}
``` 

## Links úteis

- [Criando a primeira classe em C++](https://www.facom.ufu.br/~flavio/ed1/files/2011-01/ED1_C++_OO_CriacaoClasses.pdf)
- [Criando a primeira classe em Java](https://www.devmedia.com.br/como-criar-minha-primeira-classe-em-java/38940)
