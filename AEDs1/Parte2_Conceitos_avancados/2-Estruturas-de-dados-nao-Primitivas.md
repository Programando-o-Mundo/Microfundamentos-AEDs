# Estruturas de Dados não Primitivas

## Você irá aprender:

- O que são estruturas de dados não primitivas.
- Alguns exemplos dessas estruturas na linguagem C.
- Como utilizar elas na linguagem.

## Pré-requisitos

- [Introdução à ponteiros](1-Introducao-a-ponteiros.md)

## Aplicando 

Até então, temos usados os componentes que a linguagem C tem nos oferecido, inteiros, floats, boolianos, char e etc. Agora olharemos brevemente o mundo de Estruturas de Dados não Primitivas. Em outras palavras, são estruturas mais complexas e geralmente compostas, usando duas ou mais estruturas primitivas, sejam elas do mesmo tipo ou não.

## Arrays

Primeiramente temos os Arrays ou Arranjos que basicamente é uma cadeia de entidades, por exemplo, podemos ter um array de inteiros, de floats, ou até mesmo uma cadeia de caracteres que, na verdade possui um nome específico: "String".

```c
int array[10];
``` 

A sintaxe para criar um array é a mesma de forma geral, temos a nossa declaração, seguida de dois colchetes, e dentro colocamos o tamanho do nosso array, neste caso estamos criando um array de inteiros de tamanho dez.

Vamos supor que queremos acessar e modificar/ler o conteúdo desse array, como fazemos isso?

### Acessando arrays

Para fazer acesso a arrays, usamos os mesmos colchetes que usamos para criar o array, para também acessar o seu conteúdo:

```c
int array [10]

int a = array[5];
``` 

Uma observação importante é que quando criamos um array de tamanho dez, você imagine que ele vai da posição 1 até a posição 10, certo? Porém, você irá ver que não só em C, mas em várias linguagens, que, na verdade, temos um array que vai de 0 até 9, sendo o 5 elemento acessado nesse exemplo, sendo o 4° elemento do array. Você provavelmente deve estar muito confuso a respeito disso e deve estar pensando em por que as coisas são assim.

A explicação disso exige um pouco de arquitetura, mas tentarei explicar esse conceito de forma simplificada. Quando criamos um array, esse array está em alguma posição da memória, suponhamos, ele está na posição 0. Então nesse caso temos um array de 10 inteiros, com cada inteiro tendo 32 bits ou 4 bytes, então vai da posição 0 até a posição 40, sendo a posição 0 onde começa o primeiro elemento do array.

![Diagrama sem nome](https://user-images.githubusercontent.com/9157977/211172527-013888da-8d08-45c0-a0e9-277549e2c9a5.jpg)

Pegaremos o array da imagem acima como nosso array de exemplo, traduziremos o que acontece quando usamos essa sintaxe```array[0]```. A linguagem C de forma implícita, irá pegar o endereço de onde o array começa na memória (no nosso exemplo 0) e então, somar com índice que você passou (nesse caso 0) e multiplicar com o tamanho do tipo do array (neste caso o inteiro que é de 4 bytes). Como eu disse anteriormente, o primeiro elemento está na posição 0, e o array começa o ponteiro no primeiro elemento, então (0 + (0 * 4)) = 0, sendo justamente o primeiro elemento do array.

Obs.: Importante observar que no nosso exemplo, o endereço das posições é colocado decimalmente apenas para melhor visualização. No mundo real, endereços de memória são colocados em forma hexadecimal.

É por essa maneira que se quisermos preencher o nosso array usando um laço de repetição for, vamos do índice 0, até que o índice seja menor que 10, porque assim ele vai de 0 a 9.

```c
int n = 10;
int array[n];

for (int i = 0; i < n ; i++) {
  array[i] = i;
}
``` 

Obs.: Quando passamos arrays para funções, nós na realidade estamos passando um ponteiro do array, logo, se modificarmos o conteúdo de um array numa função na qual o passamos, o seu conteúdo também será modificado na função na qual o array foi chamado.

```c
#include<stdio.h>

void modificar_array(int array[]) {
  array[5] = 53;
]

int main(void) {
  int n = 10;
  int array[n];

  for (int i = 0; i < n ; i++) {
    array[i] = i;
  }
  
  modificar_array(array);
  printf("%d\n", array[5]);
  
  return 0;
}
``` 

### Matriz

Além do array temos a matriz, sendo basicamente um vetor, porém com duas dimensões para armazenar elementos de um tipo. Como declaramos e acessamos elementos de uma matriz pode ser vista no exemplo abaixo:

```c
// Declarando uma matriz
tipo nomeDaVariavel[numeroDeLinhas][numeroDeColunas];

// Acessando um elemento de uma matriz
nomeDaVariavel[indiceLinha][indiceColuna];
``` 

Aqui embaixo temos um exemplo mais concreto de como usar uma matriz, preenchendo valores dentro da estrutura:

```c
int numero_linhas = 3;
int numero_colunas = 3;
int matriz[numero_linhas][numero_colunas];

for ( i=0; i<3; i++ ) {
  for ( j=0; j<3; j++ ) {
     matriz[i][j] = i * j;
  }
}
``` 

Assim como em arrays, quando passamos uma matriz para uma função, na realidade estamos passando o endereço de memória da mesma. E falando em funções, é importante notar que, diferente de arrays, quando você passa matrizes como parâmetro de uma função, é importante especificar no cabeçalho da função a quantidade de colunas.

```c
#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>

// Eh importante passar as dimensoes antes de colocar a matriz
// Lembrando, precisamos especificar o numero de colunas na matriz. Colocar o numero
// de linhas eh opcional, mas também válido. 
// Logo essa sintaxe:
// void preencher_array(int m, int n, int arr[m][n])
// Tambem é valida
void preencher_array(int m, int n, int arr[][n])
{
    int i, j;
    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            printf("arr[%d][%d] = ",i,j);
            scanf("%d", &arr[i][j]);
        }
    }

}

int main()
{
    int i,j,m,n;

    printf("Digite o formato da matriz(m*n):\n-> ");
    scanf("%d*%d",&m,&n);
    
    int a[m][n];
    
    preencher_array(m,n,a);

    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }

    return 0;
}
```

Outra opção para evitar ter que explicitar as dimensões da matriz, é usando alocação dinâmica:

```c
#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>

void preencher_array(int **arr,int m,int n)
{
    int i, j;
    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            printf("arr[%d][%d] = ",i,j);
            scanf("%d", &arr[i][j]);
        }
    }

}

int main()
{
    int i,j,m,n;

    printf("Digite o formato da matriz(m*n):\n-> ");
    scanf("%d*%d",&m,&n);

    int **a=(int **)malloc(m*sizeof(int));
    
    for(i=0;i<n;i++)
        a[i]=(int *)malloc(n*sizeof(int));


    preencher_array(a,m,n);

    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }
    
    for(i=0;i<n;i++)
        free(a[i]);

    free(a);

    return 0;
}
```

### Struct

Suponhamos que queremos representar uma pessoa, porém, uma pessoa tem várias características, nome, idade, altura, peso e etc. Para isso precisaremos de Structs, estruturas que chamamos de amarrações, pois elas literalmente amarram várias outras estruturas de dados para criar uma estrutura.

```c
struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
};
``` 

Como pode ver criamos uma struct de uma Pessoa e possui essa sintaxe, você coloca a palavra "struct" seguido do nome da struct" logo temos um abre e fecha chaves, sendo que o fecha chaves precisa ser acompanhado de um ponto e vírgula depois. Por fim, nas chaves, nós declaramos os componentes da nossa struct, que você pode observar no exemplo acima.

Agora para iniciar e instanciar valores dentro da nossa struct e imprimi-los na tela, podemos ver o exemplo abaixo:

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

Obs.: Se essa sintaxe "strcpy" parece muito estranho para você, não deixe de olhar a nossa aula sobre Strings.

Uma curiosidade, existe outra maneira de criar structs que é usando a palavra typedef:

```c
typedef struct Pessoa {
  char nome[50];
  int idade;
  int altura_em_cm;
  float peso_em_kg;
}Pessoa;
```

Adicionando essa palavra, podemos evitar usar a palavra "struct" toda vez que declaramos uma "Pessoa":

```c
int main(void) {

  Pessoa p;
  p.idade = 25;
  strcpy(p.nome,"Joao");
  p.altura_em_cm = 180;
  p.peso_em_kg = 75;

  printf("Nome: %s\nIdade = %d\nAltura em cm = %d\nPeso (em kg) = %g\n", p.nome, p.idade, p.altura_em_cm, p.peso_em_kg);
}
``` 

Existe mais exemplos de Estruturas não primitivas, mas por enquanto acredito que essas sejam as mais importantes aprender.

## Línks úteis

- [C Structs](https://www.youtube.com/watch?v=oKXP1HZ8xIs)
- [C Arrays](https://www.youtube.com/watch?v=eE9MnoS0lc0)
- [Leia mais sobre Strings em C](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/blob/main/C/string/Strings-em-C.md)
- [Two dimensional (2D) arrays in C](https://beginnersbook.com/2014/01/2d-arrays-in-c-example/#:~:text=The%20two%20dimensional%20(2D)%20array,more%20about%20two%20Dimensional%20array.)
- [Passing 2D arrays into functions](https://www.geeksforgeeks.org/pass-2d-array-parameter-c/)
