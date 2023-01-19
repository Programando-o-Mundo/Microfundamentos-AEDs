# Introdução ao Valgrind

## Você vai aprender

- O que é o Valgrind.
- Como utilizar essa ferramenta para visualizar manejamento de memória.
- O que a ferramenta não é capaz de fazer.

## Pré-requisitos

- [Introdução a ponteiros em C/C++](../ponteiro/Ponteiro-e-aloca%C3%A7%C3%A3o-de-mem%C3%B3ria.md)
- Ter uma máquina com o Linux.
- Instalar o Valgrind.

## Conhecendo a ferramenta

Valgrind é uma ferramenta de depuração e perfilamento de programas de Linux (infelizmente não tem como usá-lo no Windows). Sua função é 
detectar problemas de uso de memória e é perfeito para o programador de C que está usando funções como malloc e o free.

Ele pode ser usado para encontrar erros de uso de memória igual o GDB, porém sua função mais útil 
é encontrar vazamentos de memória.

## Verificando vazamentos de memória

Primeiramente, instale o valgrind na sua máquina. Você consegue instalar ele utilizando
a maioria dos gerenciadores de pacotes do linux como o [apt](https://howtoinstall.co/pt/valgrind) das distros Debian (Ubuntu, Mint, PopOs) ou o 
[pacman](https://archlinux.org/packages/extra/x86_64/valgrind/) das distros Arch (Arch, Manjaro, Garuda).

Com o programa instalado, podemos testar o seu uso.

Considere o programa abaixo:

```c
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_STRING_LENGTH 255

int main() {

    char* string = NULL;
    size_t size  = MAX_STRING_LENGTH;

    getline(&string,&size,stdin);
    string[strlen(string)-1] = '\0';

    printf("%s\n", string);

    return 0;
}
```
Como pode ver, este é um programa simples onde declaramos uma String, e fazemos a leitura pelo teclado usando a função getline.

Inclusive se você rodar esse programa, perceberá que não tem nada de errado na mesma.

Entretanto, se olharmos mais de perto, percebe-se que não colocamos a função free, que irá liberar o ponteiro dessa String da memória
gerando um vazamento. Podemos verificar isso utilizando o Valgrind, para isso precisamos primeiro usar a diretiva '-g' igual vimos na aula de GDB.

```
$gcc main.c -g
```

Ótimo, agora iremos rodar o Valgrind, passando a execução do nosso programa como parâmetro.

```
$valgrind ./a.out
```
```
==45537== Memcheck, a memory error detector
==45537== Copyright (C) 2002-2017, and GNU GPL'd, by Julian Seward et al.
==45537== Using Valgrind-3.18.1 and LibVEX; rerun with -h for copyright info
==45537== Command: ./a.out
==45537== 
```
Se digitarmos uma String qualquer o programa irá finalizar e o Valgrind irá imprimir na tela 
um registro com o uso de memória do programa.
```
==45537== 
==45537== HEAP SUMMARY:
==45537==     in use at exit: 120 bytes in 1 blocks
==45537==   total heap usage: 3 allocs, 2 frees, 2,168 bytes allocated
==45537== 
==45537== LEAK SUMMARY:
==45537==    definitely lost: 120 bytes in 1 blocks
==45537==    indirectly lost: 0 bytes in 0 blocks
==45537==      possibly lost: 0 bytes in 0 blocks
==45537==    still reachable: 0 bytes in 0 blocks
==45537==         suppressed: 0 bytes in 0 blocks
==45537== Rerun with --leak-check=full to see details of leaked memory
==45537== 
==45537== For lists of detected and suppressed errors, rerun with: -s
==45537== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)
```
Percebe que, apesar de nenhum erro ser encontrado, ele detectou que houve uso da heap que não foi liberado, resultando em perca de 
memória da mesma.  Para maior detalhes, o Valgrind nos dá o conselho de adicionar a diretiva
```
--leak-check="full"
```

Para visualizar em maior detalhe onde está acontecendo o erro, logo iremos rodar novamente o programa, dessa vez usando
```
valgrind --leak-check="full" ./a.out
```
<details>
  <summary>Pílula</summary>
Você também consegue colocar os resultados do valgrind em um arquivo separado, usando a diretiva

```--log-file="nome-do-arquivo.log"```
</details>

Rodando novamente o comando, conseguimos o seguinte resultado:

```
==45756== 
==45756== HEAP SUMMARY:
==45756==     in use at exit: 120 bytes in 1 blocks
==45756==   total heap usage: 3 allocs, 2 frees, 2,168 bytes allocated
==45756== 
==45756== 120 bytes in 1 blocks are definitely lost in loss record 1 of 1
==45756==    at 0x4845899: malloc (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==45756==    by 0x4907873: getdelim (in /usr/lib/libc.so.6)
==45756==    by 0x1091AA: main (main.c:12)
==45756== 
==45756== LEAK SUMMARY:
==45756==    definitely lost: 120 bytes in 1 blocks
==45756==    indirectly lost: 0 bytes in 0 blocks
==45756==      possibly lost: 0 bytes in 0 blocks
==45756==    still reachable: 0 bytes in 0 blocks
==45756==         suppressed: 0 bytes in 0 blocks
==45756== 
==45756== For lists of detected and suppressed errors, rerun with: -s
==45756== ERROR SUMMARY: 1 errors from 1 contexts (suppressed: 0 from 0)
```

Percebe-se duas coisas: primeiro que um erro foi efetivamente detectado, e segundo, o valgrind nos mostrou
exatamente onde aconteceu o problema.

```
==45756== 120 bytes in 1 blocks are definitely lost in loss record 1 of 1
==45756==    at 0x4845899: malloc (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==45756==    by 0x4907873: getdelim (in /usr/lib/libc.so.6)
==45756==    by 0x1091AA: main (main.c:12)
```
Percebe que a função getline faz alocação dinâmica da String usando malloc, o que justifica 
porque o nosso programa gerou esse erro, que pode ser resolvido se utilizarmos a função free antes da função
main acabar.

```c
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_STRING_LENGTH 255

int main() {

    char* string = NULL;
    size_t size  = MAX_STRING_LENGTH;

    getline(&string,&size,stdin);
    string[strlen(string)-1] = '\0';

    printf("%s\n", string);
    free(string);

    return 0;
}
```

Agora que o free foi colocado, nenhum erro será encontrado.

```
==46679== 
==46679== HEAP SUMMARY:
==46679==     in use at exit: 0 bytes in 0 blocks
==46679==   total heap usage: 3 allocs, 3 frees, 2,168 bytes allocated
==46679== 
==46679== All heap blocks were freed -- no leaks are possible
==46679== 
==46679== For lists of detected and suppressed errors, rerun with: -s
==46679== ERROR SUMMARY: 0 errors from 0 contexts (suppressed: 0 from 0)
```

## Checagem de erros

Como dito anteriormente, podemos utilizar o Valgrind para checar também uso incorreto de memória.
Considere o código abaixo.

```c
#include<stdio.h>
#include<stdlib.h>

int main() {

    int* vetor = (int*)malloc(sizeof(int)*5);

    vetor[6] = 1;

    return 0;
}
```

Considere a variável "vetor" como sendo um array de inteiros de tamanho cinco. Logo após isso, tentamos inserir no index seis, algo que deveria ser impossível, mas que a linguagem permite. 

Se tentarmos rodar esse código junto ao Valgrind, recebemos a seguinte mensagem de erro.

```
==76989== Invalid write of size 4
==76989==    at 0x109157: main (in /tmp/teste/a.out)
==76989==  Address 0x4a9a058 is 4 bytes after a block of size 20 alloc'd
==76989==    at 0x4845899: malloc (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==76989==    by 0x10914A: main (in /tmp/teste/a.out)
==76989== 
```

Nenhuma falha de segmentação ocorre, mas o programa alerta sobre uma tentativa de escrita
inválida na variável, além de claro, o fato que não liberamos a memória com a função free.

```
==77832== HEAP SUMMARY:
==77832==     in use at exit: 20 bytes in 1 blocks
==77832==   total heap usage: 1 allocs, 0 frees, 20 bytes allocated
==77832== 
==77832== 20 bytes in 1 blocks are definitely lost in loss record 1 of 1
==77832==    at 0x4845899: malloc (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==77832==    by 0x10914A: main (in /tmp/teste/a.out)
==77832== 
==77832== LEAK SUMMARY:
==77832==    definitely lost: 20 bytes in 1 blocks
==77832==    indirectly lost: 0 bytes in 0 blocks
==77832==      possibly lost: 0 bytes in 0 blocks
==77832==    still reachable: 0 bytes in 0 blocks
==77832==         suppressed: 0 bytes in 0 blocks
==77832== 
==77832== For lists of detected and suppressed errors, rerun with: -s
==77832== ERROR SUMMARY: 2 errors from 2 contexts (suppressed: 0 from 0)
```
Outro possível erro que pode acontecer é quando o programador faz uma operação
em um vetor que está parcialmente inicializado.

Considere o código abaixo.

```c
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_STRING_LENGTH 30

int main() {

    char* string = (char*)malloc(sizeof(char)*MAX_STRING_LENGTH);

    printf("%ld",strlen(string));

    return 0;
}
```

Neste código estamos criando uma String por alocação dinâmica e depois imprimindo o tamanho da mesma,
usando a função strlen. Este código se rodarmos normalmente não irá mostrar nenhum erro, porém o Valgrind
irá nos alertar de um problema.

```
==78495== Conditional jump or move depends on uninitialised value(s)
==78495==    at 0x484BD19: strlen (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==78495==    by 0x10917A: main (in /tmp/teste/a.out)
==78495==  Uninitialised value was created by a heap allocation
==78495==    at 0x4845899: malloc (in /usr/lib/valgrind/vgpreload_memcheck-amd64-linux.so)
==78495==    by 0x10916A: main (in /tmp/teste/a.out)
```
Perceba que  a nossa String foi inicializada usando o malloc. Voltando para a nossa aula de iniciação a ponteiros,
a função malloc irá iniciar os seus vetores com lixo de memória. Então, apesar do processo de alocação ter sido um sucesso,
o nosso vetor ainda está com erro, pois a função strlen está tentando ler uma String que contém apenas lixo.

Para consertar esse problema podemos usar a função memset para preencher o vetor com algum valor de nossa escolha, ou
usar a função calloc para iniciar o vetor e já inicializar as posições com o espaço em branco.

```c
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAX_STRING_LENGTH 30


int main() {

    char* string = (char*)calloc(MAX_STRING_LENGTH,sizeof(char));

    printf("%ld",strlen(string));

    free(string);

    return 0;
}
```

Se rodarmos esse código pelo Valgrind, percebe-se que nenhum erro pode ser encontrado.

```
==79601== HEAP SUMMARY:
==79601==     in use at exit: 0 bytes in 0 blocks
==79601==   total heap usage: 2 allocs, 2 frees, 1,054 bytes allocated
==79601== 
==79601== All heap blocks were freed -- no leaks are possible
```

### links úteis

[Veja mais tutoriais do Valgrind](https://www.ic.unicamp.br/~rafael/materiais/valgrind.html)

[Tutorial mais avançado de Valgrind](https://www.cprogramming.com/debugging/valgrind.html)

[Site oficial do Valgrind](https://valgrind.org/info/about.html)



