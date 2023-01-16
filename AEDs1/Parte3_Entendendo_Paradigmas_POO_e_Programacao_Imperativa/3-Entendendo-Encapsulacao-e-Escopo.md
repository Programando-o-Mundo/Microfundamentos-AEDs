# Entendendo encapsulação e escopo de classes

Durante as duas primeiras aulas de POO, você viu muito falarmos sobre escopo de classes, e as três palavras chaves: ```public```, ```protected``` e ```private```. Nesta aula, nós iremos entrar em detalhe em como usar essas palavras chaves, além de explicar o padrão do encapsulamento, muito importante quando estamos falando de Programação Orientada a Objetos.

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
