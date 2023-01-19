# Estruturas condicionais

## O que você vai ver...

- O que são  e como usar estruturas condicionais
- Para que usamos estruturas condicionais
- O que são e como usar operadores relacionais

## Pré-requisitos

- 1-Criando-nosso-primeiro-algoritmo
- 2-Atribuicao-e-declaracao
- 3-Leitura-e-escrita-de-dados

- 1-Estruturas-de-dados-Primitivas

## Usando Estruturas Condicionais

Ao construir o nosso programa, precisamos criar estruturas que são capazes de fazer validação lógica dentro do nosso programa. Vamos voltar ao problema da padaria, e agora estamos trabalhando no caixa, fazendo as contas da compra de uma pessoa. Nós precisamos validar que o dinheiro entregue pela pessoa é o suficiente para realizar as compras, e para essa tarefa e outras, nós precisamos  usar estruturas condicionais. Eis um pequeno exemplo disso em código

```c
#include<stdio.h>
#include<stdbool.h>

int main(void) {

  bool falhou_a_compra = false;
  
  float dinheiro_cliente = 50;
  float total_compras = 20;
  
  if(CONDICAO) {
    printf("A compra foi um sucesso!\n");
  } else {
    printf("Erro! Dinheiro insuficiente!\n");
    falhou_a_compra = true;
  }
  
  return falhou_a_compra ;
}
``` 

Algumas partes desse código você já está familiarizado, mas vamos passo-a-passo decifrá-lo juntos. Primeiramente usamos o booleano ```falhou_compra```responsável em armazenar se a operação foi um sucesso (Obs.: para usarmos booleanos precisamos importar da biblioteca *stdbool*. Em seguida temos dois floats, um sendo a quantidade de dinheiro que o cliente tem ``` dinheiro_cliente``` e o dinheiro total resultado das compras do cliente ```Total_das_compras```. por fim, temos a estrutura condicional **if** e **else**

## Condição

Para fazer uma estrutura condicional funcionar, precisamos criar a nossa condição que irá indicar se o código irá entrar dentro do laço condicional ou não, para isso iremos empregar operadores relacionais e lógicos.

### Operadores relacionais

Estes são os símbolos da matemática que estamos familiares: sinal de maior (>), sinal de menor (<), sinal de igualdade (==), alguns precisam usar sinais diferentes as vezes para serem representados. Eu irei deixar uma lista com os principais sinais abaixo.

| Operador | Relação testada |
|---|---|
| < | Primeiro operando menor que o segundo operando |
| > | Primeiro operando maior que o segundo operando |
| <= | Primeiro operando menor ou igual ao segundo operando |
| >= | Primeiro operando maior ou igual ao segundo operando |
| == | Primeiro operando igual ao segundo operando |
| != | Primeiro operando não é igual ao segundo operando |

Fonte: https://learn.microsoft.com/pt-br/cpp/c-language/c-relational-and-equality-operators?view=msvc-170

Aqui podemos usar essas verificações para criar lógica de verificar se **o dinheiro do cliente é maior ou igual ao preço total das compras**. Então nossa estrutura condicional ficou da seguinte forma:

```c
#include<stdio.h>

int main(void) {

  int sucesso = 0;
  
  float dinheiro_cliente = 50;
  float total_compras = 20;
  
  if (dinheiro_cliente >= total_compras) {
    printf("A compra foi um sucesso!\n");
  } else {
    printf("Erro! Dinheiro insuficiente!\n");
    sucesso = 1;
  }
  
  return sucesso;
}
```

Se rodarmos o nosso código, este funcionará certinho :-) .

```
A compra foi um sucesso!
```

## IF

Vamos agora dar uma pequena olhada na sintaxe das estruturas condicionais

Primeiro temos o **if** ou se, e a sua sintaxe é está, a palavra "if" em caixa baixa, seguido de parênteses, depois tem a condição para entrar no "if", ou seja, a condição precisa ser verdadeira, fecha parênteses e abre e fecha chaves, sendo o código dentro da chave indicando o escopo da estrutura condicional.

Obs.: Quando falarmos de funções voltaremos a falar de escopo, mas pense que quando falamos de escopo nesse caso, estamos falando do espaço onde o programa receberá instruções se a condição da estrutura for aceita, então por exemplo:

```c
//...
  if (dinheiro_cliente >= total_compras) {
    printf("A compra foi um sucesso!\n"); //<--- O espaço entre as chaves é o escopo do "if"
  } //...
``` 
## ELSE 

Em segundo temos o "else". Se a condição do "if" for falsa, então iremos entrar dentro do escopo do "else". A sintaxe dele é bem parecida com a do "if", com a diferença que não temos que checar por nenhuma condição. Importante notar que todo "else" precisa vir após o "if" ou o "else if" que veremos daqui a pouco. Não podemos começar uma estrutura condicional com o "else".

Por fim, temos o "else if"

## ELSE IF

Vamos supor que queremos expandir o nosso programa e queremos adicionar a funcionalidade, caso o nosso usuario tenha entrado com um dinheiro a mais do que ele precisa pra pagar as compras, precisamos que o troco seja retornado a ele, certo? Então vamos criar uma lógica que detecte essa diferença, e imprima na tela o valor do troco recebido.

Para isso, iremos usar o **else if** que vem depois do "if" e não precisa necessariamente ter um "else". Em outras palavras você pode ter um "if", um cadeia de "else if" e pode ou não terminar em um "else".

Vamos então colocar o nosso "else if" entre o "if" e o "else", vamos mudar a lógica do if, para apenas verificar a **igualdade entre o dinheiro do cliente e o total das compras**, e o nosso novo "else if" irá verificar **se o total do dinheiro é maior que a compra feita por ele**

```c
#include<stdio.h>
#include<stdbool.h>

int main(void) {

  bool falhou_a_compra = false;
  
  float dinheiro_cliente = 50;
  float total_compras = 20;
  
  if(dinheiro_cliente == total_compras) {
    printf("A compra foi um sucesso!\n");
  } else if (dinheiro_cliente > total_compras) {
    float troco = 0;
    printf("A compra foi um sucesso, seu troco foi de R$%g reais!\n", troco);
  } else {
    printf("Erro! Dinheiro insuficiente!\n");
    falhou_a_compra = true;
  }
  
  return falhou_a_compra ;
}
```

Ótimo, agora podemos imprimir o troco do cliente, porém, precisamos fazer uma subtração para chegar ao troco, como iremos chegar nisso? Bem, vamos deixar operações aritméticas e operadores lógicos para a próxima aula. Enquanto isso, pegue essa oportunidade para ler um pouco mais do código, e também, dê uma olhada em mais alguns exemplos abaixo de cadeias de estruturas condicionais que são permitidas e não permitidas.

### Permitido
```c
if(a) {

} else if (b) {

} else {

}
``` 

### Permitido
```c
if(a) {

} else if (b) {

} else if (c) {

} else if (d) {

} else {

}
``` 

### Permitido 
```c
if (a) {

} else if(b) {

}
```

### Não permitido 
```c
else if (a){

}
``` 

### Não permitido
```c
else {

}
```

## Línks úteis

- [Operadores relacionais e de igualdade em C](https://learn.microsoft.com/pt-br/cpp/c-language/c-relational-and-equality-operators?view=msvc-170)
- [Olhe mais um exemplo de operadores relacionais em C](http://linguagemc.com.br/operadores-relacionais/)
- [Veja mais sobre estruturas condicionais, e veja um pouco sobre o switch-case](https://www.vichinsky.com.br/Cbasico/pag13b.html#:~:text=A%20linguagem%20C%20nos%20oferece,estrutura%20if...else.&text=A%20estrutura%20if...else%20%C3%A9%20a%20mais%20simples,estrutura%20de%20controle%20do%20C.)
- [Aula mais avançada de processamento condicional](https://homepages.dcc.ufmg.br/~viniciussantos/aeds20161/aula4.pdf)
