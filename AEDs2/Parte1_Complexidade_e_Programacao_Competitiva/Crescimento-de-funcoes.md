# Crescimento de funções e tipos de notações

## Você vai aprender

- Diferentes tipos de notações

## Pré-requisitos

- Complexidade de tempo e espaço e notação big O

## Outros tipo de notações

Uma das notações mais comuns para descrever o crescimento de funções é a notação "Big O" (O()). No entanto, há outras 
notações que podem ser usadas para descrever o crescimento de funções que não vamos discutir nesta aula.

Em vez disso, vamos falar sobre duas notações que são úteis para descrever o crescimento de funções em termos de ordens 
de magnitude: a notação Theta (Θ()) e a notação Omega (Ω()).

## Notação Theta Θ

A notação Theta é usada para descrever o crescimento de funções quando o comportamento assintótico superior e inferior da 
função é o mesmo. Em outras palavras, quando a função cresce na mesma taxa, independentemente da entrada. Matematicamente, 
podemos dizer que uma função f(n) é Theta(g(n)) se e somente se existem constantes positivas c1 e c2 tais que 0 <= c1 * g(n) <= f(n) <= c2 * g(n) para 
todos os valores de entrada n maiores do que um determinado valor.

Por exemplo, suponha que temos uma função f(n) = n^2 + 3n + 5. Podemos dizer que f(n) é Theta(n^2), porque a função cresce na mesma 
taxa que n^2 para entradas grandes o suficiente.

## Notação Omega Ω

A notação Omega, por outro lado, é usada para descrever o comportamento assintótico inferior de uma função. Matematicamente, podemos 
dizer que uma função f(n) é Omega(g(n)) se e somente se existem constantes positivas c e n0 tais que 0 <= c * g(n) <= f(n) para todos 
os valores de entrada n maiores do que n0.

Por exemplo, se tivermos uma função f(n) = 2n + log n, podemos dizer que f(n) é Omega(n), porque a função cresce pelo menos tão rapidamente 
quanto n para entradas grandes o suficiente.

Embora a notação Theta e a notação Omega sejam menos comuns do que a notação Big O, elas são úteis para descrever com precisão o comportamento 
assintótico de funções em termos de ordens de magnitude. É importante lembrar que a escolha da notação apropriada depende do contexto da análise e 
que cada notação fornece uma visão diferente sobre o crescimento de uma função.

## Links úteis

- [Notação Theta na Wikipédia](https://en.wikipedia.org/wiki/Big_O_notation#Family_of_Bachmann%E2%80%93Landau_notations)
- [Notação Omega na Wikipédia](https://en.wikipedia.org/wiki/Big_O_notation#Family_of_Bachmann%E2%80%93Landau_notations)
- [Notações Assintóticas de Funções na UFMG](https://www.dcc.ufmg.br/dcc200/notes/notacao.pdf)
