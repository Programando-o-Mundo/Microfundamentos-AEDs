# Leitura de Strings em C

## Você vai aprender

- Diferentes tipos de como ler uma String.
- Como imprimir e manipular caracteres de uma String.

## Pré-requisito

- [Strings em C](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs2/blob/main/Strings-em-C.md)

## Lendo Strings a partir do teclado

Agora que sabemos declarar uma String, queremos permitir que o usuário possa inserir uma String pelo teclado.
Existe diferentes maneiras de permitir isso e será apresentando todos, assim como também as suas vantagens e desvantagens

## scanf

O scanf, pertence a família de funções de leitura de dados de acordo com o formato descrito. Este formato pode conter conversão que depois são
armazenadas no ponteiro da variável indicada.

```c
int scanf(const char *format, ...)
```
Para fazer a leitura, essa função utiliza de expressões formatadoras, para indicar o tipo de dado que
está sendo lido, no caso da string, utilizamos %s

```c
#include<stdio.h>

int main() {

    int n = 40;
    char s[n];

    scanf("%s",s);

    printf("%s", s);
    return 0;
}
```
Observação que desta forma, não é possível fazer a leitura de uma string que contém um espaço
em branco no meio da mesma, para isso usamos o formatador %[^\n]s

```c
#include<stdio.h>

int main() {

    int n = 40;
    char s[n];

    scanf("%39[^\n]s", s);

    printf("%s", s);
    return 0;
}
```

Note que colocamos n-1(neste caso 39) junto ao formatador, sabe porque fazemos isso?

<details>
  <summary>Resposta</summary>
  A função scanf não possui buffer overflow protection, ou seja, se o usuário entrar com uma string maior do que o tamanho da
  string s, o programa retornará com um erro. Por causa disto, muitos programadores evitam usar o scanf para leitura de strings.
</details>

# fgets

O fgets, é uma função utilizado para ler uma entrada de tamanho n
(ou quando um newline ('\n') é lido), de alguma stream qualquer. 

```c
char *fgets(char *str, int n, FILE* stream)
```

No contexto dessa função, stream se refere a um pointeiro para um arquivo (FILE*),
porém podemos passar o parâmetro stdin, para que possamos fazer a leitura pelo teclado.

```c
#include<stdio.h>

int main() {

    int n = 40;
    char s[n];

    fgets(s,n,stdin);

    printf("%s", s);
    return 0;
}
```

Obs: Após o uso do fgets é aconselhável colocar o null terminator no final da palavra. O fgets coloca
esse caractere especial na string, porém ele está na última posição do array (n-1) , e se a palavra não
possui tamanho n isso pode resultar em um problema.

```c
#include<stdio.h>
#include<string.h>

int main() {

    int n = 40;
    char s[n];

    fgets(s,n,stdin);
    s[strlen(s)-1] = '\0'; // strlen retorna o tamanho da string

    printf("%s", s);
    return 0;
}
```

Obs.: a função strlen retorna a quantidade de caracteres na String, mais detalhes serão vistos em aulas futuras.

Você sabe porque colocar o null terminator no final da String?

<details>
  <summary>Resposta</summary>
  Ao pressionar "enter" o fgets irá armazenar um newline junto a palavra digitada pelo usuário, ou seja, se digitarmos
  "hello world" o que na verdade será armazenado é "hello world\n".
</details>

## getline

Por fim, temos a função getline, que é uma extensão da biblioteca GNU e foi padronizada no C no POSIX 2008. O getline
tem uma funcionalidade muito parecida com o fgets como pode ser visto abaixo:

```c
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int main() {

    size_t n = 40;
    char *s = NULL;

    getline(&s,&n,stdin);
    s[strlen(s)-1] = '\0'; // strlen retorna o tamanho da string

    printf("%s\n", s);
    free(s);
    return 0;
}
```

Observação: o tipo "size_t" é um inteiro de 8 bits sem sinal, usado para indicar tamanho.
Observação²: não é necessário fazer a alocação dinâmica da String no uso do getline.

Agora fica  a pergunta: qual destes métodos você deveria utilizar?

## Qual função utilizar?

De forma geral, evite utilizar o scanf, pois este é tipicamente utilizado leitura de números, sem contar que existe o problema do
buffer overflow protection, que impede do programador ter muito controle da entrada do scanf sem qualquer tipo de manipulação avançada.

A função getline é uma boa opção, se o seu programa apenas trabalha com strings usando alocação dinâmica. Porém essa função
é presente apenas em sistemas operacionais POSIX, então usuários de Windows não podem desfrutar de usar dessa função (a não ser que o programador insira
a função de forma deliberada).

A opção que está aberta para todos então seria o fgets, porém tome cuidado pois este não consegue detectar e não irá parar a leitura
em caso de encontrar NULL.

### links úteis

[Leia mais sobre o scanf](https://homepages.dcc.ufmg.br/~rodolfo/aedsi-2-10/printf_scanf/printfscanf.html)

[Leia mais sobre o getline](https://man7.org/linux/man-pages/man3/getline.3.html)

[Leia mais sobre o fgets](https://www.pucsp.br/~so-comp/cursoc/aulas/c970.html)


