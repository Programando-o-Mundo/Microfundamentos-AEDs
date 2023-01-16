# Entendendo encapsulação e escopo de classes

Durante as duas primeiras aulas de POO, você viu muito falarmos sobre escopo de classes, sendo as com maior frequência: ```public```, e ```private```. Nesta aula, nós iremos entrar em detalhe em como usar essas palavras chaves, além de explicar o padrão do encapsulamento, muito importante quando estamos falando de Programação Orientada a Objetos.

## Protegendo dados de uso indevido

Vamos mais uma vez lembrar das nossas Structs, você devê se lembrar que lá, quando temos algum dado na mesma, podemos acessá-lo sem nenhum problema, basta criar umas instância da Struct e podemos acessar seu atributo sem problemas.

```c
Pessoa p;
p.idade = 18;
```

Em muitos casos, ter esse livre acesso aos membros de uma amarração não é um problema, mas agora, vamos pensar que estamos criando a nossa classe Pessoa para identificar a conta bancária de um cliente qualquer, e agora temos o atributo ```saldo```.

```c
typedef struct Pessoa {
  char nome[50];
  float saldo;
  char cpf[13];
};

 int main(void){
  Pessoa p;
  p.saldo = 50;
 }
 ``` 
 
Obviamente o saldo é algo muito importante, e por conta disso, por questões de segurança, precisamos proteger esse dado de manipulações indevidas, caso contrário alguém poderia aumentar o seu saldo de R$1,00 para R$1.000.000,00 apenas trocando o valor de uma variável, ou até pior, pode diminuir o seu saldo. É por conta de problemas como esse que nós criamos design de software, para implementar soluções que resolvam problemas diversos e inclusive segurança e integridade dos dados. Para o nosso caso, podemos usar um design de software que é a Encapsulação.

## O que é Encapsulação?

Em resumo, encapsulação é um padrão de software, onde colocamos os dados da classe como privado e para acessar e modificar tais dados, usamos funções de escopo público. 

A ideia aqui é bem simples, como o único meio de acessar os dados da classe é a partir dessa funções, nós estamos protegendo a variável de ser modificada de formas imprevisíveis. Além disso caso a lógica de recuperar ou modificar tais dados modifique durante a criação do software (Algo que acontece bem frequentemente na vida útil de qualquer aplicação), o custo para refatorar essas modificações é mais baixo, já que tudo que temos que fazer é modificar essas funções.

### Público e Privado

É aqui que essas palavras chaves entram, pois diferente de C, C++, Java e outras linguagens que possuem POO, também introduzem esse conceito de publico e privado que não tem em outras linguagens. Também temos o especificador ```protected``` mas iremos entrar em maiores detalhes quando falarmos de Herança.

#### Public

Quando dizemos que a variável é publica, quer dizer que tanto dentro quanto fora da classe, podemos acessar esse atributo. Esse é o mesmo comportamento das Structs em C, onde você pode acessar qualquer coisa usando o ponto "." seguido do atributo da struct. A mesma coisa acontece em classes:

#### C++
```c++
#include<iostream>
#include<string>

class Pessoa {
  public:
  
    std::string nome;
    std::string cpf;
    float saldo;
  
    Pessoa(std::string nome, std::string cpf, float saldo) {
      this.nome = nome;
      this.cpf = cpf;
      this.saldo = saldo;
    }
};

int main(void) {
  Pessoa joao = Pessoa("Joao","58423593212",4584);
  std::cout << joao.saldo << "\n";
  return 0;
}
```
#### Java
```Java
class Pessoa {
  public String nome;
  public String cpf;
  public double saldo;
  
  public Pessoa(String nome, String cpf, double saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.saldo = saldo;
  }
}

public class Main {
  public static void main(String[] args) {
    Pessoa joao = new Pessoa("Joao","58423593212",4584);
    System.out.println(joao.saldo);
  }
}
```

Uma observação importante, quando você não coloca nenhum especificador em Java, ele não será "public" mas sim "default", nós não iremos entrar em detalhes disso, pois isso é coisa da linguagem, mas para mais informações, [acesse esse link](https://www.geeksforgeeks.org/access-modifiers-java/).

#### Private

Já o especificador de acesso private, significa que tal atributo não pode ser acessado fora do escopo da classe,e caso a gente tente, o compilador irá nos retornar um erro:

#### C++

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
};

int main(void) {
  Pessoa joao = Pessoa("Joao","58423593212",4584);
  std::cout << joao.saldo << "\n";
  return 0;
}
```

#### Java

```Java
class Pessoa {
  private String nome;
  private String cpf;
  private double saldo;
  
  public Pessoa(String nome, String cpf, double saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.saldo = saldo;
  }
}

public class Main {
  public static void main(String[] args) {
    Pessoa joao = new Pessoa("Joao","58423593212",4584);
    System.out.println(joao.saldo);
  }
}
```

Dê uma olhada no erro que recebemos:

#### C++
```
main.cpp:20:21: error: 'saldo' is a private member of 'Pessoa'
  std::cout << joao.saldo << "\n";
                    ^
main.cpp:9:11: note: declared private here
    float saldo;
          ^
1 error generated.
``` 
#### Java
``` 
Main.java:18: error: cannot find symbol
    System.out.println(joao.saldo);
                           ^
  symbol:   variable saldo
  location: variable joao of type Pessoa
1 error
``` 

Note que em Java o erro é um pouco diferente mas a ideia é a mesma. "Cannot find symbol" quer dizer que, ou ele não existe, ou o escopo de acesso não permite que ele seja visível, logo ele não existe.

Agora fica a questão, se o nosso atributo é privado, como que acessamos ele fora da classe? Para isso, vamos voltar a falar de Encapsulação, mais especificamente, das funções tipo "Getters" e "Setters".

### Getters

Para acessar esses dados, nós temos os getters, uma função que tem como único objetivo retornar o atributo.

### C++
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
  std::cout << joao.get_saldo() << "\n";
  return 0;
}
```
### Java
```Java
class Pessoa {
  private String nome;
  private String cpf;
  private double saldo;

  public Pessoa(String nome, String cpf, double saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.saldo = saldo;
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public double getSaldo() {
    return saldo;
  }
}

public class Main {
  public static void main(String[] args) {
    Pessoa joao = new Pessoa("Joao","58423593212",4584);
    System.out.println(joao.getSaldo());
  }
}
```

Perceba que nós colocamos as funções de getters no espaço de escopo público, dessa forma, podemos acessar essas funções fora da classe. Além disso, o padrão dessas funções é bem simples. O tipo de retorna da função é o tipo da variável, ou seja, se a variável é uma string, o nosso getter precisa retornar uma string. O nome é mais uma questão de convenção, mas geralmente é a palavra "get" acompanhado do nome da variável, então nesse caso: "get_nome". Por fim, temos a função em si, que apenas para princípios práticos, estamos apenas colocando para retornar o dado.

Note que neste caso não usamos a palavra "this" pois diferente do construtor, não temos outra variável chamada "nome" ou "cpf" ou "saldo", neste caso, quando colocarmos qualquer uma dessas variáveis, a linguagem vai entender que você quer acessar o atributo da classe e não uma variável de escopo local.

### Setters

Por outro lado, temos os setters, funções que existem para mudarmos o valor de uma variável.

### C++
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
    
    void set_nome(std::string nome) {
      this->nome = nome;
    }
    
    void set_cpf(std::string cpf) {
      this->cpf = cpf;
    }
    
    void set_saldo(float saldo) {
      this->saldo = saldo;
};

int main(void) {
  Pessoa joao = Pessoa("Joao","58423593212",4584);
  joao.set_saldo(5833);
  std::cout << joao.get_saldo() << "\n";
  return 0;
}
```
### Java
```Java
class Pessoa {
  private String nome;
  private String cpf;
  private double saldo;

  public Pessoa(String nome, String cpf, double saldo) {
    this.nome = nome;
    this.cpf = cpf;
    this.saldo = saldo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
  
}

public class Main {
  public static void main(String[] args) {
    Pessoa joao = new Pessoa("Joao","58423593212",4584);
    joao.setSaldo(5832);
    System.out.println(joao.getSaldo());
  }
}
``` 

Com os setters o padrão é um pouquinho diferente das funções de "getters", primeiramente toda função é void, pois não existe nenhum dado que precisamos voltar. Segundo, colocamos a palavra "set" ao lado do nome da variável. Terceiro, funções setters recebe como argumento o novo valor da nossa variável.

Por fim, como aqui estamos trabalhando com variáveis com o mesmo nome, precisamos usar a palavra "this" para distinguir as variáveis de escopo local e variáveis da classe.

## Links úteis

- [Encapsulation - OOP Concept for Beginners](https://stackify.com/oop-concept-for-beginners-what-is-encapsulation/)
