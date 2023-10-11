# Sejam bem vindos a Algoritmos e Estruturas de Dados I

Aqui é onde tudo começa, neste módulo, você irá desde o começo para entender como podemos combinar Algoritmos e Estruturas de Dados
para resolver os mais diversificados problemas que o mundo da Computação já viu. Essa é uma clássica disciplina de resolução de problemas,
e para resolver tais problemas, primeiro é preciso conhecer as ferramentas que temos em nossa disposição.

Começaremos do mais simples, que no nosso caso é os algoritmos.

## O que é um Algoritmo?

A cada vez mais que os dias se passam, o mundo vai se tornando cada vez mais adepto a tecnologia, até que a mesma faça parte do nosso dia-a-dia. 
Existe três importantes palavras que circulam no mundo da tecnologia e as três são importantes de uma forma ou outra para essa a disciplina em questão. A primeira é hardware que é o meio físico na qual usamos a tecnologia, como é o caso dos celulares e os computadores por exemplo. O segundo termo é o software, que são aplicações construídas para rodar "em cima" do hardware e cumprem nossas tarefas do dia-a-dia (ex: Whatsapp, Google Maps, Google Chrome, entre outros). Por fim, nós temos os algoritmos, mas o que são eles?

Na ciência da computação, um algoritmo é uma sequência de etapas que define um conjunto de instruções de maneira precisa para resolver um determinado problema ou executar uma tarefa específica. Esse conjunto bem definido de instruções pode ser implementado a partir de uma "linguagem de programação", uma poderosa ferramenta computacional padronizada, formada do seu próprio conjuntos de regras sintáticas e semânticas que permitem desenvolvedores colocarem algoritmos para funcionarem na prática. Pense que assim como eu estou utilizando da lingua portuguesa para explicar este tópico para vocês, nós desenvolvedores usamos das linguagens de programação para "explicar" para a máquina como a nossa aplicação será executada.

Mantenha em mente que, quando falamos de Algoritmo nós estamos falando mais do abstrato, da ideia do passo-a-passo que possa resolver um problema específico. Principalmente porquê podemos implementar o mesmo algoritmo de diferentes formas, usando diferentes linguagens de programação. Por outro lado, o Software é a ideia concreta, ou seja, é o algoritmo (ou até um conjunto de algoritmos) implementado de forma unificada, com o objetivo de realizar uma determinada tarefa.

Existem muitos tipos de algoritmos e eles podem ser usados para uma ampla variedade de propósitos. Alguns algoritmos são projetados para resolver tipos específicos de problemas, como classificar uma lista de números ou encontrar o caminho mais curto entre dois pontos. Outros são de uso mais geral e podem ser usados para resolver uma ampla variedade de problemas.

## Resolvendo problemas com algoritmos

Na computação, utilizamos algoritmos para resolver um problema real eficientemente, aqui podemos dividir esse processo, de maneira geral, em quatro fases:

### 1 - Identificação e compreensão do problema e seus objetivos.

O primeiro passo e mais simples seria identificar o problema que queremos resolver, por exemplo, suponhamos que estamos fazendo um jogo, e o nosso problema atual é que queremos criar um sistema que persiga o jogador, apenas passando por cima do caminho e não das paredes. Este é o nosso problema, nossos objetivos então seriam:

- Fazer o inimigo mover;
- Fazer o inimigo não poder se mover pela diagonal, apenas para cima, baixo, esquerda e direita;
- Fazer o inimigo calcular a trajetória até jogador;
- Fazer o inimigo chegar até o jogador, evitando colidir com a parede;
- Fazer o inimigo chegar até o jogador da forma mais eficiente possível;

![ai](https://user-images.githubusercontent.com/9157977/210408979-2d6b6827-8842-4003-8508-79a2d47bd90d.jpg)

O quadrado verde é o jogador, os quadrados cinzas representa as paredes e o quadrado vermelho é o inimigo.

### 2 - Conceptualização da solução.

O segundo passo seria fazer o conceito da nossa solução, isso acontece, pois de maneira geral, podemos resolver o mesmo problema só que de formas diferentes. Neste caso, nós estamos trabalhando com o campo da produção de um algoritmo de "Pathfinding", em outras palavras, algoritmos exclusivamente feitos para calcular a rota mais curta entre dois pontos. 

### 3 - Definição do algoritmo para resolução do problema.

Perfeito, então queremos trabalhar com Pathfinding, mas ainda assim, isto não é a solução, pois o campo de Pathfinding possui um número incontável de algoritmos. Por isso precisamos ser mais precisos ainda e dizer: "Qual algoritmo de Pathfinding eu irei usar para resolver o meu problema?". Para exemplo prático, usaremos o algoritmo [A*](https://www.inf.ufsc.br/~alexandre.goncalves.silva/courses/14s2/ine5633/trabalhos/t1/A%20%20%20Pathfinding%20para%20Iniciantes.pdf), muito utilizado no campo dos jogos para calcular a rota mais eficiente utilizando inteligência artificial.

### 4 - Codificação da solução através de um programa computacional.

Por fim temos o último passo, codificar o nosso algoritmo utilizando um programa computacional, no nosso caso, uma linguagem de programação, ferramentas que utilizamos para comunicar instruções para a máquina, sem ter que comunicar diretamente com a máquina. Abaixo temos um exemplo de um programa feito na linguagem de programação Python, para codificar a nossa solução.

**Obs.:** Não se preocupe, vocês não têm a obrigação de entender o que está acontecendo no código, apenas entender que isso é uma solução 
para o nosso problema e também para exemplificar o processo de codificação.

```python
def aStarSearch(problem: SearchProblem, heuristic=nullHeuristic):

    priority_queue    = util.PriorityQueue()
    path              = []

    visited = set()

    start_node = problem.getStartState()

    if problem.isGoalState(start_node):
        return ["Stop"]

    priority_queue.push((start_node,path), 0)

    while not priority_queue.isEmpty():
        
        curr_node, path = priority_queue.pop()

        if problem.isGoalState(curr_node):
            return path

        neighbors = problem.getSuccessors(curr_node)

        for node in neighbors:

            if node[POSITION] not in visited:

                cost=problem.getCostOfActions(path + [node[DIRECTION]]) + heuristic(node[POSITION],problem)
                
                priority_queue.push((node[POSITION], path + [node[DIRECTION]]), cost)
                visited.add(node[POSITION])
```

![ai2](https://user-images.githubusercontent.com/9157977/210409079-0edfb743-7b8d-4c23-a054-176ef118cacc.jpg)

Inimigo fez o trajeto até o jogador, representando com a linha vermelha.

Vocês provavelmente deve ter notado que a nossa solução foi feita de cima para baixo ou "Top-down", essa é uma forma de aproximação muito comum para resolução de problemas reais, onde escrevemos uma sequência de instruções para serem executadas usando uma aproximação descendente. De uma maneira simplificada, pense como se a construção de um algoritmo é como se estivessemos cozinhando uma receita, onde temos os ingredientes e um conjunto de instruções a serem seguidos, geralmente de cima para baixo.

Sobre a parte técnica dos algoritmos acredito que por agora seja o suficiente. Existe mais detalhes que deveriam ser levados em conta quanto a produção de algoritmos, mas por agora, acredito que seja o suficiente. O que devemos realmente focar no momento é como começar a construir os nossos primeiros algoritmos, e para isso nós temos que aprender a usar uma linguagem de programação. Antes disso, voltando a nossa analogia da receita de comida, nós temos que apresentar os ingredientes, que nesse caso, seriam as Estruturas de Dados.

## Estruturas de Dados

Estruturas de dados são formas de representar itens de dados logicamente relacionados ao dados que queremos representar. Isso parece muito confuso, mas pense o seguinte: Suponhamos que estamos trabalhando em uma padaria, e que estamos trabalhando no caixa. Neste cenário, imagine que você esteja contabilizando o valor total da compra do cliente, para isso você precisa de um número, mais precisamente, números com casas decimais. Essa representação numérica pertence a um grupo matemático chamado de "números reais" e na computação chamamos essa representação de números de ponto flutuante ou apenas "float". Observe como que a forma como representamos os dados do nosso problema precisa ser escolhida com cuidado, pois se escolhermos um número inteiro por exemplo, parte dos dados da compra poderiam ser perdidos e logo, nosso algoritmo não representa fielmente os dados que queremos armazenar.

Além disso, é desejável que a estrutura de dado, também seja eficiente, ou seja, não use recursos a mais do que precisa, por exemplo, estamos programando o interruptor de uma lâmpada, sabemos aqui que temos dois estados: ligado (ON) e desligado (OFF), para isso temos uma estrutura de dado chamado boolean (ou simplesmente bool) que representa um dígito (0 ou 1) onde 0 representa falso "False" e pode ser a nossa lâmpada desligada, e 1 representa verdadeiro "True" e pode ser a nossa lâmpada ligada. Veja que neste exemplo, tanto um número real, quanto um número inteiro poderiam resolver o nosso problema, porém estariamos usando um canhão para matar uma formiga, já que precisamos apenas de dois números.

Quando estamos escrevendo o nosso algoritmo, nós declaramos essas estruturas da mesma forma que escrevemos números ou palavras em um pedaço de papel, e junto aos conjuntos de instruções fornecido pelas linguagens de programação, nós conseguimos dar luz aos programas que conseguem tornar as nossas vidas diárias mais simples e confortáveis.

# Por enquanto é so...

É claro que tem muito mais a ser explorado na disciplina, como por exemplo, você sabia que existem dois tipos de estruturas de dados? As chamadas estruturas de dados primitivas e não primitivas? Quais são as suas diferenças, bem, acredito que por enquanto seja o suficiente, e em aulas futuras iremos voltar para este tópico. Com os conhecimentos aqui vocês tiveram uma pequena amostra no quê a disciplina irá trabalhar. Recomendo fortemente também dar uma olhada para o material complementar dessa aula, pois contém outras fontes de recursos na qual você pode aprender a disciplina.

Muito obrigado e até a próxima! 

## Links úteis

- [Aula completa de AEDs1 - UNIVERSIDADE FERNANDO PESSOA](http://www3.dsi.uminho.pt/iiee/repos/AEDados.pdf)
- [CS50 - Uma das melhores aulas introdutórias de Computação do Mundo!](https://youtu.be/8mAITcNt710)
