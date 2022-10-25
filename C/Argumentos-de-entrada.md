# Argumentos de entrada

# Gustavo Lopes Rodrigues 

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

### links úteis

[Leia mais sobre o argc e argv](https://www.geeksforgeeks.org/command-line-arguments-in-c-cpp/)

