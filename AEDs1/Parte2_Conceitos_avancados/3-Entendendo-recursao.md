# Entendendo Recursão

## Você irá aprender

- O que é Recursão.
- Como criar uma função recursiva.

## Pré-requisitos

- [Estruturas de dados não primitivas](2-Estruturas-de-dados-nao-Primitivas.md)

## Iterativa vs Recursiva, problemas similares, estratégias diferentes

Alguns módulos atrás, trabalhamos com o problema de fazer uma ação repetidas vezes. Você aprendeu até então que a única solução para esse problema é usar estruturas de repetição (for, while, do while). Porém, existe outra alternativa que ainda não trabalhamos, e que é muito frequentemente utilizada em design de algoritmos, chamada de solução recursiva.

Quando falamos de soluções iterativas e recursivas, nós estamos falando de diferentes maneiras de executar instruções repetidamente. Soluções iterativas envolve, como falamos anteriormente, a utilização de laços de repetição, enquanto soluções recursivas envolve criar um loop chamando a mesma função dentro dela mesma. Parece uma ideia meio maluca, mas dê uma olhada no código abaixo.

```c
#include<stdio.h>

void imprimir_hello_world(void) {
  printf("Hello world!\n");
  imprimir_hello_world();
}

int main(void) {
  imprimir_hello_world();
  return 0;
}
```

Aqui temos uma função **main** que está chamando a função **imprimir_hello_world** e dentro dessa função, tem uma instrução para imprimir na tela "Hello world!" e por fim uma chamada para a própria função. Quando chamamos uma função dentro dela mesma, isso é o que chamamos de uma função recursiva. Entretanto, ao executar esse código perceba o que acontece... exatamente, ele irá imprimir "Hello World!" infinitamente e não irá parar a execução ou ele irá imprimir várias vezes e então irá acontecer uma falha de segmentação pela quantidade absurda de funções recursivas que foram chamadas.

Nós não entraremos em detalhes sobre falha de segmentação, pois isso é um tópico completamente diferente, mas basta entender, quando não controlamos direito o nosso código, e deixamos a recursão entrar em um loop infinito, erros como esses iram aparecer. "Mas como então podemos resolver esse problema?", vamos lembrar para sintaxe para construir o laço "for".

```c
for (inicialização; condição; incremento/decremento) {
    // código para ser executado
}
```

Você provavelmente deve se lembrar que para fazer com que o "for" saísse dele mesmo, nós usamos o segundo elemento dele que é a condição de parada, e é exatamente isso que está faltando para a nossa recursão deixar de ser infinita. Em outras palavras, nós precisamos inserir lógica na função, para que a mesma saiba quando é que é para parar a recursividade. 

Vamos então refatorar o código juntos e talvez você consiga ver o que estou falando.

## Condição de parada da recursividade

Olhando a sintaxe do "for" e alguns exemplos de como um funciona, você deve-se lembrar que também temos inicialização e incremento/decremento de variáveis. Nós também utilizaremos isso para ganhar maior controle da situação. Primeiramente, definiremos o objetivo da nossa função que no meu caso será imprimir a sequência "Hello world!" **n** vezes, sendo "n" um número que o usuário irá escolher. Vamos então colocar essa lógica no programa.

```c
#include<stdio.h>

void imprimir_hello_world(void) {
  printf("Hello world!\n");
  imprimir_hello_world();
}

int main(void) {

  int n = 0;
  scanf("%d", &n);
  imprimir_hello_world();
  return 0;
}
```

Em um mundo ideal, você colocaria aqui algum sistema de verificação e alguma mensagem para informar o usuário, mas deixaremos assim para simplificar a explicação. Mas agora o que fazemos com essa variável "n"? Segundo passo é, criaremos uma função que seja interface para a recursão. 

```c
#include<stdio.h>

void imprimir_hello_world_rec(void) {
  printf("Hello world!\n");
  imprimir_hello_world_rec();
}

void imprimir_hello_world(int n) {
  imprimir_hello_world_rec();
}

int main(void) {

  int n = 0;
  scanf("%d", &n);
  imprimir_hello_world(n);
  return 0;
}
```

Ter uma função que apenas serve para chamar nossa função recursiva é uma boa prática, pois simplifica o processo de manutenção dessa função, para que no futuro, caso o programador queira criar um comportamento para esse componente do código, ele só terá que refatorar a função **imprimir_hello_world**. Outra observação importante é que em C, você não pode ter duas funções com o mesmo nome, então aqui para diferenciar as duas funções, eu apenas adiciono "rec" de "recursivo" na nossa função que realmente é recursiva.

Mas ainda assim, isso ainda não irá resolver nosso problema, por isso, nós vamos agora fazer a inicialização da nossa variável e criar a condição de parada.

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

Agora na nossa função **imprimir_hello_world_rec** temos agora dois argumentos, o "i" que é como se fosse o índice do nosso "for" e o "n" que irá ajudar a recursão a criar a condição de parada necessária para não entrar em um loop infinito. Além disso, note que colocamos um "if" que é a nossa condição de parada, fazendo com que apenas no caso de "i" ser menor que "n" ele irá imprimir na tela "Hello World!" e irá chamar a recursividade novamente. É como se literalmente tivéssemos colocando um freio na recursão. 

Por fim, ao chamar a função dentro do "if" nós enviamos o "i" somado com +1 e "n" não sofre nenhuma alteração.

Por outro lado, a função **imprimir_hello_world** apenas colocamos a inicialização da variável "i" como 0, e inicializamos a recursão, chamando a função **imprimir_hello_world_rec** enviando o "i" e o "n". Perceba como essa estrutura, por mais diferente que seja, ela é bem parecida com o laço "for", porém nós é que somos responsáveis em fazer a "magia" do "for" acontecer: inicialização, condição e o incremento/decremento, nós estamos fazendo tudo por conta própria.

Imagino que muitos de vocês ainda devem estar com dúvidas em como utilizar essa estratégia para a construção de soluções, mas deixaremos isso para uma próxima aula. Por enquanto, terminaremos a aula falando o porquê usar recursividade.

## Porquê recursão

De certa forma, você viu que existe um trabalho a mais ao criar uma recursão do que um laço de repetição. Olha a diferença na solução desse nosso problema acima, só que com iteração.

```c
#include<stdio.h>

void imprimir_hello_world(int n) {
  for (int i = 0; i < n; i++) {
    printf("Hello world!\n");
  }
}

int main(void) {

  int n = 0;
  scanf("%d", &n);
  imprimir_hello_world(n);
  return 0;
}
```
Certamente muito mais simples, mas isso é para ilustrar que nem todo problema deveria ser resolvido com recursão. Da mesma forma, você irá ver que nem toda solução iterativa é a melhor solução possível. Usar recursão ou iteração exige uma análise do problema e ver qual algoritmo é o que mais se adequá ao caso de uso. 

Você irá encontrar mais para frente, que existe estruturas de dados que, devido à maneira na qual elas são construídas, se mostram muito adequadas para usar recursividade, enquanto outras implementações recursivas, como a que a gente acabou de ver, só irá te causar mais dor de cabeça. No fim das contas, é sempre importante aprender a implementar diferentes estratégias para resolver o mesmo problema.

## Línks úteis

- [Aprenda recursão com o problema do fibonnaci](https://www.youtube.com/watch?v=1kBiqUCN888)
- [Recursão em 5 minutos](https://www.youtube.com/watch?v=ivl5-snqul8)
