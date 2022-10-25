# Criando Strings em C

# Gustavo Lopes Rodrigues 

## Você vai aprender

- O que é uma String.
- Como declarar uma String em C.
- Quais são os tipos de Strings.
- Quando usar cada um dos tipos.

## Pré-Requisitos

- [Introdução a ponteiros em C/C++](../ponteiro/Ponteiro-e-aloca%C3%A7%C3%A3o-de-mem%C3%B3ria.md)

## O que é uma string?

String é um tipo de dado usado para representar uma cadeia de caracteres. Praticamente, todas
as linguagens de programação modernas possuem a String implementado, entretanto, a linguagem
C não implementa essa como um tipo de dado primitivo.

Então...como declaramos uma string em C?

## Criando uma string

Voltando à nossa definição, uma string é entendida uma cadeia de caracteres, caracteres ou 'char' é um
tipo de dado primitivo que a linguagem C possui, e um possível sinônimo para a palavra 'cadeia'
pode ser 'arranjo' ou 'array'. Logo, podemos representar uma string como uma cadeia de caracteres, observe o exemplo abaixo.

```c
#include<stdio.h>

int main() {
    char s[] = "Hello world";
    printf("%s", s);
    return 0;
}
```

Acima  temos uma cadeia com 11 caracteres, com a adição de um
null terminator('\0'), um caractere especial usado pela linguagem C para indicar o fim de uma string.

Eis as duas maneiras na qual podemos declarar uma string:
```c
char s[40];
char *a = (char*)malloc(sizeof(char)*40);
```

Na superfície as duas maneiras parecem idênticas, porém possuem diferenças importantes que serão explicadas.

## char* x char[]

Na prática, ambos podem ser usados de forma muito parecidas para criar uma String, porém são teoricamente diferentes.

O char* é um ponteiro que é armazenado na Stack, com o seu conteúdo (neste caso a nossa String)
armazenado de forma estática no Heap , e o char[] é um arranjo de caracteres onde todo o conteúdo é armazenado na Stack.

![image](https://user-images.githubusercontent.com/9157977/178162131-ea9e3bb4-b54c-4949-ae20-5e0c28761e99.png)

Fonte: https://i.stack.imgur.com/oew8U.png

Importante notar que, como a memória no Heap é dinâmica e manejada pelo programador, logo, as chances de acontecer erros e
leaks de memória são muitos maiores do que se o programador usar a memória da Stack, que é gerenciada pelo compilador.

Por esse motivo: use char[] quando você está trabalhando com dados onde o tamanho da maior String possível é conhecida. Você irá
ter uma certa perda de memória, mas isto será compensado pelo fato de não ter que se preocupar com alocação de memória.

Se você precisa de mexer com dados massivos e que possuem um tamanho máximo desconhecido, use char* lembrando de tomar
cuidado na hora de alocar e desalocar memória. Mais tarde iremos trabalhar com depuração em C, o que irá permitir maior controle e
visualização da memória que estamos manejando.

Além disso, podemos usar ponteiros para fazer algumas operações a mais com as Strings, mas deixaremos esse tópico quando
conversarmos sobre manipulação de Strings.

## Bônus: caracteres com acento

O tipo char na linguagem C usa 1 byte para armazenar seu conteúdo, isso é algo que pode ser confirmado, imprimindo o
conteúdo da variável CHAR_BIT que indica a quantidade de bits que o tipo char possui.

```c
#include <stdio.h>
#include <limits.h>

int main() {
    printf("%d\n", CHAR_BIT);
    return 0;
}
```

Porque isso é importante? Quando o C foi criado, a tabela de caracteres padrão da época era a ASCII e ela apenas possui
conversão para caracteres da língua inglesa, impossibilitando a utilização de caracteres de outras línguas. Anos depois veio a
tabela Unicode que se tornou o novo padrão, e expandiu o número de caracteres, mas estes precisam de maior espaço de armazenamento.

Considere o código abaixo.
```c
#include <stdio.h>

int main() {
    char maca[] = "maçã";
    printf("%s\n", maca);
    printf("%ld\n", sizeof(maca));
    return 0;
}
```

A palavra maçã possui 4 caracteres, porém o "ç" e o "ã", por estar na tabela Unicode precisa de mais espaço, mais precisamente 2 bytes.
Como os caracteres restantes estão na tabela ASCII e temos o null terminator, temos um total de 7 bytes na palavra "maçã" que pode ser confirmado
utilizando o operador sizeof, que imprime o tamanho da estrutura em bytes.

```
maçã
7
```

Além disso, para imprimir o "ç" ou o "ã" separado, é preciso imprimir os dois bytes que formam a letra, o que pode ser
observado no exemplo abaixo:

```c
#include <stdio.h>

int main() {
    char maca[] = "maçã";
    printf("%c%c\n", maca[2], maca[3]);
    return 0;
}
```

### links úteis

[Operador sizeof](https://docs.microsoft.com/pt-br/cpp/c-language/sizeof-operator-c?view=msvc-170)

[Memória Heap vs Memória Stack](https://blog.pantuza.com/artigos/heap-vs-stack)


