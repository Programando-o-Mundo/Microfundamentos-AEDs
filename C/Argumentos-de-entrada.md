# Argumentos de entrada

## Você vai aprender

- O que são argumentos de entrada
- Como utilizar eles na linguagem C

## Pré-Requisitos

- [Strings em C](../string/Strings-em-C.md)

## Argumentos de entrada?

Ao declarar a função **main** do nosso programa em C, temos duas maneiras de escrever a função, a primeira você
apenas declara a função e passa nenhum parâmetro. Observe essa primeira alternativa abaixo:
```c
#include<stdio.h>

int main() {
    printf("Hello World");
    return 0;
}
```
Talvez esta, muitos já conhecem, porém existe uma outra maneira, que é utilizando os parâmetros **argc** e **argv**
```c
#include<stdio.h>

int main(int argc, char* argv[]) {
    printf("Hello World");
    return 0;
}
```
Existe mais de uma maneira de utilizar essa nomenclatura, mas ai fica a questão. O que significa esses parâmetros e como utilizá-los?

## Argc e Argv

A palavras **argc** e **argv** são nada mais do que versões curtas das palavras: argument counter (contador de argumentos) e argument vector (vetor de argumentos), e juntos eles possibilitam que
o programador possa mandar parâmetros dinâmicos para dentro do programa durante a execução do mesmo. Importante ressaltar duas coisas.

* Em C não é possível saber o tamanho de um vetor bidimensional sem o uso de uma variável auxiliar, por isso, o **argc** é a nossa variável auxiliar, um int contendo o tamanho do nosso vetor **argv** 
* A esse ponto imagino que vocês já tenham assistido a aula de String e por conta disso, muitos de vocês devem saber que o **char* argv[]** é nada mais do que um vetor de vetores de caracteres, em 
outras palavras, um vetor de Strings.

Por fim. vamos ver um exemplo abaixo, para deixar tudo mais claro.

```c
#include<stdio.h>

int main(int argc, char* argv[]) {
    
    for (int i = 0; i < argc; i++) {
      printf("%s\n", argv[i]);
    }
    return 0;
}
```

Como pode ser ver, estamos usando a variável **argc** para iterar pelos elementos de argv, que então são imprimidos na tela, vamos ver o resultado!

Para passar os nossos parâmetros para o **argv**, iremos passar ele durante a execução do programa, ou seja, primeiros compilamos o nosso código normalmente
```c
$ gcc main.c
``` 

Agora, vamos passar os argumentos ao fazer o ```./a.out``` , ou seja
``` 
./a.out O rato roeu a roupa do rei de roma
``` 

Observe o resultado:
``` 
/a.out 
O 
rato 
roeu 
a 
roupa 
do 
rei 
de 
roma
``` 

Obs.: Perceba que a primeira string do nosso vetor de argumentos **argv** inclui o nosso /a.out, ou seja o nome do nosso executável.

## BÔNUS: envp

### O que são Variáveis de Ambiente?

As variáveis de ambiente, às vezes chamadas de variáveis de shell, são configurações de sistema que podem ser usadas por programas em execução. Elas são definidas no ambiente do sistema e podem conter informações como o diretório de usuário, o tipo de terminal e muitas outras configurações úteis.

As variáveis de ambiente são armazenadas em um conjunto especial de variáveis, coletivamente chamado de ambiente. O nome de uma variável de ambiente é sensível a maiúsculas e minúsculas, e é uma boa prática usar letras maiúsculas para nomear novas variáveis que você define. O valor de uma variável de ambiente é uma sequência de caracteres que não pode conter um caractere nulo, já que o caractere nulo é usado para encerrar a sequência.

## Acesso às Variáveis de Ambiente em C

Para acessar as variáveis de ambiente em um programa C, você pode usar o parâmetro "envp" na função "main". Aqui está um exemplo de como sua função "main" pode ser definida:

```c
#include <stdio.h>

int main(int argc, char *argv[], char *envp[])
{
  // Seu código aqui
  return 0;
}
```

O parâmetro "envp" é um array de strings, semelhante ao parâmetro "argv". Ele contém uma lista das variáveis de ambiente do seu sistema, no formato "NOME=valor". 

### Exemplo de Uso

Para acessar o valor de uma variável de ambiente, você pode usar a função `getenv` que está definida no cabeçalho `stdlib.h`. Aqui está um exemplo de como você pode usá-lo:

```c
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[], char *envp[])
{
  char *home, *host;

  home = getenv("HOME");
  host = getenv("HOSTNAME");

  printf("Seu diretório de usuário é %s em %s.\n", home, host);

  return 0;
}
```

Quando você executa este código, ele imprimirá informações com base nas variáveis de ambiente do sistema, como o diretório de usuário e o nome do host.

### Importante a Lembrar

- Dê preferencia a usar a função "getenv" em vez de usar esse parâmetro, já que o mesmo é padronizado apenas em sistemas do tipo UNIX.
- Não modifique as strings retornadas por `getenv`. Elas são ponteiros para dados que pertencem ao sistema. Se você quiser processar um valor retornado por `getenv`, copie-o para outra string primeiro usando `strcpy`.
- Se você desejar alterar uma variável de ambiente de dentro do seu programa (o que geralmente não é recomendado), use funções como `putenv`, `setenv` e `unsetenv`. Consulte a documentação para obter mais informações sobre essas funções.

As variáveis de ambiente e o parâmetro "envp" são ferramentas poderosas para a comunicação entre programas e para acessar informações de configuração no sistema operacional. Elas desempenham um papel importante na programação em C e podem ser úteis em diversas situações.

### links úteis

[Leia mais sobre o argc e argv](https://www.geeksforgeeks.org/command-line-arguments-in-c-cpp/)
[Leia mais sobre o envp](http://www.crasseux.com/books/ctutorial/Environment-variables.html)
