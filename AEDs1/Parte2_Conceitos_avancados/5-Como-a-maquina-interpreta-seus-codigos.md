# Como a máquina interpreta seus códigos

## Você irá aprender

- Como os primeiros programas funcionavam.
- Porque criamos linguagens de programação.
- Como a máquina cria variáveis e processam informações.

## Pré-requisitos

- [Retornando argumentos de funções recursivas](4-Retornando-argumentos-de-funcoes-recursivas.md)

## Como o meu programa em C funciona?

Se você leu todas as aulas até esta, você agora deve ter uma fundamentação em como programar na linguagem C. Você entende os básicos da sintaxe, e sabe integrar os recursos da linguagem com lógica de programação, para resolver diferentes problemas. Provavelmente uma das dúvidas que vocês devem ter tido enquanto programavam é: como que a máquina interpreta o que estou escrevendo? Por que as coisas funcionam do jeito que elas funcionam? Por que usamos um Compilador?

Algumas peças desse quebra cabeça infelizmente não serão completamente respondidas por mim e nem por essa aula, pois envolve explorar diferentes áreas da Ciência da Computação, principalmente Arquitetura de Computadores e Compiladores. Entretanto, proponho a vocês nesta aula, deixarmos um pouco de lado os exercícios de programação, para explicar um pouco da história da computação.

## A evolução das linguagens de programação

A maneira como os programadores interagem com as linguagens de programação evoluiu ao longo do tempo, à medida que novos paradigmas e tecnologias de programação foram desenvolvidos. Como já vimos em aulas anteriores, o que os nossos programas fazem no final das contas.
São uma sequência finita de instruções que a máquina deve processar. Mas como os programadores programavam antigamente?

Nos primórdios da computação, a programação era feita usando linguagens de montagem (também conhecido como linguagem Assembly), 
o que exigia que os programadores escrevessem um código que correspondesse diretamente ao conjunto de instruções da máquina (mais especificamente
a arquitetura da CPU). Estes conjuntos de instruções eram então traduzidos para binário e então entregues para a máquina. Até hoje linguagens Assembly ainda são utilizadas, porém, é de maneira geral evitada, por ser um processo tedioso e de baixo nível, tornando o desenvolvimento de software uma
tarefa lenta e sujeita a vários erros.

A título de comparação, dê uma olhada nos exemplos abaixo de como escrever um programa que imprima na tela "Hello World!" escrito em C e em Assembly x86_64.

### C

```c
#include<stdio.h>

int main(void) {
  printf("Hello World!\n");
  return 0;
}
```

### Assembly x86_64

```asm
global _start       ; ponto de partida para o Linker

section .text       ; Onde escrevemos codigo

_start:             ; Onde o nosso programa comeca
  mov rax, 1        ; Operacao de escrita (para o Linux)
  mov rdi, 1        ; Especificar para fazer a operacao de escrita para o stdout (Standard Output) ou seja a tela
  mov rsi, msg      ; Especificando a mensagem a ser escrita
  mov rdx, msglen   ; Especificado tamanho da mensagem
  syscall           ; Chamando a kernel para executar o "printf("Hello World!\n");

  mov rax, 60       ; Pedindo para o programa terminar execucao
  mov rdi, 0        ; "O" indicando que foi um sucesso, pense que eh como se fosse o "return 0"
  syscall           ; Chamando a kernel para finalizar o programa

section .data                        ; definir os dados que sao constantes no programa
  msg: db "Hello, world!", 10        ; definir a mensagem "Hello world"
  msglen: equ $ - msg                ; definir tamanho da mensagem
```

Perceba como programar em C é bem mais simples e direto ao ponto comparado a programação em Assembly.

Além disso, vale lembrar que os programas eram escritos usando cartões perfurados (Punched cards). Um cartão perfurado é um pedaço de papel rígido com orifícios perfurados, e cada orifício corresponde a uma instrução ou valor de dados específico.

Os programadores escreveriam o código usando uma máquina de perfuração de teclas, que usaria um teclado padrão e faria furos 
nos cartões com base nas teclas pressionadas. Os cartões perfurados seriam então alimentados em um computador, que leria os furos e executaria as instruções codificadas nos cartões.

O processo de programação com cartões perfurados era também muito exaustivo, pois cada cartão só podia conter uma pequena quantidade de informações e os erros em um cartão teriam que ser corrigidos manualmente. Além disso, as cartas eram frequentemente classificadas e organizadas em baralhos para serem processados pelo computador, o que acrescentava outra camada de complexidade.

![NMAH-AHB2017q015288](https://user-images.githubusercontent.com/9157977/215006705-41257d99-32a9-4d42-b197-dff7390ef802.jpg)

Fonte: https://americanhistory.si.edu/collections/search/object/nmah_1378541

## Programação em alto nível

Mais tarde, foram desenvolvidas linguagens de programação de alto nível, como FORTRAN e COBOL, que usavam uma sintaxe mais legível por humanos e forneciam recursos como variáveis, loops e instruções condicionais. Essas linguagens tornaram a programação muito mais fácil e eficiente, permitindo assim o desenvolvimento de sistemas de software complexos.

Uma coisa que era muito questionado na época, é se realmente valia a pena programar nessas linguagens, vista que elas facilitavam o processo de programação, muitos acreditavam que esses programas seriam lentos e não tão eficientes quanto programas escritos em Assembly. Entretanto,
devido aos imensos avanços nas tecnologias em Compiladores e principalmente em otimização, programas escritos nessas linguagens de alto nível são tão eficientes, que se tornam quase irrelevantes de se escrever em Assembly.

### Hello world in Fortran

```fortran
program main
  ! Isso eh um comentario
  print *, 'Hello, World!'
end program main
``` 

Bem melhor, você não acha?

Mesmo assim, apesar dos avanços nas tecnologias, ainda haviam dois problemas na área da programação, o primeiro era o uso dos cartões perfurados e o segundo é que tais linguagens de programação não permitiam muita flexibilidade em como organizar o código.

Isso tudo mudou nas décadas de 1960 e 1970, quando foi introduzido o conceito de programação estruturada, que enfatizava o uso de código claro e bem organizado, com foco em dividir o programa em pequenos pedaços de código gerenciáveis. Isso levou ao desenvolvimento de linguagens como Pascal e C, 
que suportavam conceitos de programação estruturada. 

Outras importantes invenções dessa época foi: a fita magnética, armazenamento em disco, e terminais interativos que se tornaram mais amplamente disponíveis, permitindo que a programação torna-se um processo mais conveniente.

![less-than-p-greater-than-the-ibm-pc-introduced-in-august-1981-helped-reassure-corporate-customers-that-personal-computing-was-serious-less-than-p-greater-than](https://user-images.githubusercontent.com/9157977/215006841-649bdc79-ff90-43bb-9539-b4c5ca98122b.jpg)

Fonte: https://spectrum.ieee.org/how-the-ibm-pc-won-then-lost-the-personal-computer-market

## Dias atuais

Com essa explicação feita, podemos voltar ao ponto que estamos hoje em dia, onde tudo que queremos fazer está nas pontas dos dedos. Não precisamos de cartões perfurados para programar, muito menos de programar diretamente para o processador da máquina com Assembly. Podemos usar linguagens de programação para abstrair que problemas queremos resolver, com uma sintaxe muito mais simples. Além de usar os compiladores para traduzir as nossas instruções, de forma que o tipo de hardware da nossa máquina possa entender.

Mas fica a pergunta, quais são as principais partes que a máquina usa quando programamos?

## Usando os recursos da máquina

De maneira geral, quatro partes são importantes entender, a CPU, a RAM o disco rígido e a GPU.

### CPU

A CPU, ou Central Processing Unit (Unidade Central de Processamento), é o "cérebro" de um computador. É responsável por executar instruções e 
realizar cálculos.

A CPU é um circuito eletrônico que contém milhões de transistores que podem ser ligados ou desligados para realizar operações (pense que estado de um transistor, ligado e desligado, corresponde a 0 ou 1 em binário). Ele lê instruções da memória, executa cálculos e operações lógicas e armazena os resultados de volta na memória. Ele também se comunica com as outras partes do computador, como memória e armazenamento, para obter dados e enviar resultados.

![2015-04-17-2-copy](https://user-images.githubusercontent.com/9157977/215118380-26e53a5e-bb5e-4751-9fca-e04a3da92e96.jpg)

Fonte: https://www.techtudo.com.br/noticias/2015/04/o-que-e-cpu-entenda-qual-e-o-significado-da-sigla-e-sua-importancia.ghtml

Do ponto de vista da programação, a CPU é importante porque é o dispositivo que executa as instruções que compõem um programa. Quando 
um programa é executado em um computador, a CPU lê as instruções da memória e as executa, realizando cálculos e operações lógicas conforme 
especificado pelo código. A CPU também é responsável pelo gerenciamento da memória e armazenamento além da comunicação com outros dispositivos, 
como dispositivos de entrada/saída.

### RAM

RAM, ou Random Access Memory (Memória de acesso aleatório), é um tipo de memória de computador usada para armazenar temporariamente dados que a 
CPU pode acessar rapidamente. É chamado de "acesso aleatório" porque a CPU pode acessar qualquer local de memória em qualquer ordem, ao contrário 
da memória sequencial, como uma unidade de fita.

A RAM é uma memória volátil, o que significa que ela é apagada quando o computador é desligado. A RAM é normalmente usada para armazenar dados 
aos quais a CPU precisa de acesso imediato, como as instruções e os dados do programa que está sendo executado no momento.

![memory-ddr4](https://user-images.githubusercontent.com/9157977/215118708-83ef5d3d-eb16-49f4-9e91-efeab95b63be.jpg)

Fonte: https://www.computerhope.com/jargon/r/ram.htm

Do ponto de vista da programação, a RAM é importante porque é usada para armazenar o programa e os dados nos quais a CPU está trabalhando no momento. 
Quando um programa é executado, ele é carregado na RAM, onde a CPU pode acessar e executar rapidamente as instruções. Ter RAM suficiente é importante 
para o bom funcionamento do programa, pois se não houver RAM suficiente, a CPU terá que trocar dados constantemente entre a RAM e o armazenamento muito 
mais lento, o que pode fazer com que o programa fique lento ou trave.

### Disco rígido (HD)

Um disco rígido (Hard Disk) é um tipo de dispositivo de armazenamento usado para armazenar dados em um computador. Consiste em um ou mais discos rotativos revestidos com um material magnético, no qual os dados são armazenados. Os discos rígidos não são voláteis, o que significa que os dados são retidos mesmo quando o computador está desligado.

![2012-03-05-ilustracao](https://user-images.githubusercontent.com/9157977/215119056-4988ff18-6fe9-4f79-9768-7e189fb12223.jpg)

Fonte: https://www.techtudo.com.br/noticias/2012/03/para-que-serve-o-hd.ghtml

Do ponto de vista da programação, os discos rígidos são importantes porque fornecem um meio de armazenar e recuperar dados que não precisam estar na RAM o tempo todo. Como dito anteriormente, quando um programa é executado, ele é carregado na RAM, onde a CPU pode acessar e executar rapidamente as instruções. No entanto, quando um programa é fechado ou o computador é desligado, fazendo com que dados na RAM sejam perdidos. Os discos rígidos fornecem um meio de armazenar dados permanentemente, para poderem ser recuperados posteriormente quando o programa for executado novamente. Além disso, os discos rígidos também são usados para armazenar o sistema operacional, aplicativos e dados do usuário, para poderem ser acessados mesmo após o computador ser desligado.

Os discos rígidos também vêm em tipos diferentes, como um SSD (unidade de estado sólido), sendo um tipo mais novo de dispositivo de armazenamento, mais rápido e confiável do que os discos rígidos tradicionais. Eles não têm partes móveis, o que significa que eles têm menos probabilidade de falhar e podem acessar os dados mais rapidamente.

### GPU

Até então não trabalharemos com a GPU, pois utilizamos ela mais em casos específicos, mas daremos uma olhada no que ela é e como funciona.

Uma GPU, ou Graphics Processing Unit (Unidade de processamento gráfico), é um tipo especializado de processador projetado para lidar com os cálculos complexos necessários para renderizar imagens e vídeos (operações matriciais). Ele é separado da CPU e otimizado para lidar com abundância de dados em paralelo.

As GPUs são compostas de muitos núcleos pequenos e simples que podem executar cálculos simples, sendo rapidamente adequadas para lidar com 
tarefas como processamento de imagem e vídeo, renderização 3D e aprendizado de máquina. Eles podem realizar muitos cálculos simultaneamente, permitindo que concluam tarefas muito mais rapidamente do que uma CPU sozinha.

![Image04](https://user-images.githubusercontent.com/9157977/215119407-9424ef9c-92ae-4783-a239-5e70764d4a27.jpg)

Fonte: https://marriedgames.com.br/tecnologia/o-que-e-gpu/

Do ponto de vista da programação, a GPU é importante porque permite o processamento mais eficiente de certos tipos de dados. Por exemplo, 
ao trabalhar com imagens ou vídeos, uma GPU pode ser usada para executar rapidamente operações como filtragem de imagens, detecção de objetos e 
reconhecimento facial. Na computação científica e no aprendizado de máquina, a GPU pode ser usada para executar operações complexas de matriz e cálculos de aprendizado profundo muito mais rapidamente do que uma CPU sozinha.

## Conclusão

Com isso, agora vocês têm uma noção geral em como o mundo da programação começou, como os primeiros programas de computação eram feitos, porque programamos do jeito que programamos e quais são os principais componentes do computador que utilizamos e como utilizamos. 

Como dito anteriormente, a resposta de muitas perguntas foram simplificadas por não termos ainda todos os dados, e por isso acredito que as explicações nesta aula sejam mais do que o suficiente, por enquanto. 

Além disso, teve vários pontos onde omitimos dados por conveniência, acredito que muitos de vocês devem ter se perguntando: mas por que paramos na década de 1960? Certamente novas evoluções aconteceram depois disso, certo? Bem essa discussão deixaremos para uma futura aula, quando falarmos sobre POO.

## Links úteis

- [History of Computer, Programming and Coding](https://www.youtube.com/watch?v=M4d3FXu9-3I)
- [Assembly Language in 100 seconds](https://youtu.be/4gwYkEK0gOk)

