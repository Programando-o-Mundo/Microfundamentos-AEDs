# Sejam bem vindos a Algoritmos e Estruras de Dados I

Aqui é onde tudo começa, neste módulo, você irá desde o começo para entender como podemos combinar Algoritmos e Estruturas de Dados
para resolver os mais diversificados problemas que o mundo da Computação já viu. Essa é uma clássica disciplina de resolução de problemas,
e para resolver tais problemas, primeiro é preciso conhecer as ferramentas que temos em nossa disposição.

Vamos começar do mais simples, que no nosso caso é os algoritmos

## O que é um Algoritmo?

A cada vez mais que os dias se passam, o mundo vai se tornando cada vez mais adepto a tecnologia, até que a mesma faça parte do nosso dia-a-dia. 
Uma palavra que tem sido jogada dela para cá é esta: "Algoritmo, mas o que no final das contas é um Algoritmo?

Na ciência da computação, um algoritmo é uma sequência de etapas que define um conjunto de instruções para resolver um determinado problema ou executar uma tarefa específica. Os algoritmos são fundamentais para a ciência da computação e desempenham um papel crucial em muitos aspectos da computação, incluindo processamento de dados, recuperação de informações e ciência computacional.

Os algoritmos são normalmente projetados para serem executados por um computador, embora também possam ser implementados manualmente ou com outras ferramentas. Um algoritmo geralmente é descrito de maneira precisa, passo a passo, usando um conjunto claro e bem definido de instruções.

Existem muitos tipos diferentes de algoritmos e eles podem ser usados ​​para uma ampla variedade de propósitos. Alguns algoritmos são projetados para resolver tipos específicos de problemas, como classificar uma lista de números ou encontrar o caminho mais curto entre dois pontos. Outros são de uso mais geral e podem ser usados ​​para resolver uma ampla variedade de problemas.

## Resolvendo problemas com algoritmos

Dentro da computação, utilizamos algoritmos para resolver um problema do mundo real de forma eficiente, aqui podemos dividir esse processo em quatro fases:

### 1 - Identificação e compreensão do problema e seus objetivos.

O primeiro passo e mais simples seria identificar o problema que queremos resolver, por exemplo, vamos supor que estamos fazendo um jogo, e o nosso problema atual é que queremos criar um sistema que possa perseguir o jogador, apenas passando por cima do caminho e não das paredes. Este é o nosso problema, nossos objetivos então seriam:

- Fazer o inimigo mover
- Fazer o inimigo calcular a trajetória até jogador
- Fazer o inimigo chegar até o jogador, evitando colidir com a parede
- Fazer o inimigo chegar até o jogador da forma mais eficiente possível

### 2 - Conceptualização da solução.

O segundo passo seria fazer o conceito da nossa solução, isso acontece pois de maneira geral, podemos resolver o mesmo problema só que de diversas
formas diferentes. Neste caso, nós estamos trabalhando com o campo da produção de um algoritmo de Pathfinding, em outras palavras, algoritmos que são exclusivamente feitos para calcular a rota mais curta entre dois pontos. 

### 3 - Definição do algoritmo para resolução do problema.

Perfeito, então queremos trabalhar com Pathfinding, mas ainda assim, isto não é a solução, pois o campo de Pathfinding possui um número incontável de algoritmos. Por isso precisamos ser mais precisos ainda e dizer: "Qual algoritmo de Pathfinding eu irei usar para resolver o meu problema?". Para exemplo prático, usaremos o algoritmo [A*](https://www.inf.ufsc.br/~alexandre.goncalves.silva/courses/14s2/ine5633/trabalhos/t1/A%20%20%20Pathfinding%20para%20Iniciantes.pdf), muito utilizado no campo dos jogos para calcular a rota mais eficiente utilizando inteligência artificial.

### 4 - Codificação da solução através de um programa computacional.

Por fim temos o último passo, que é codificar o nosso algoritmo utilizando um programa computacional, no nosso caso, uma linguagem de programação, que são ferramentas que utilizamos para comunicar instruções para a máquina, sem ter que comunicar diretamente com a máquina. Abaixo temos um exemplo de um programa feito na linguagem de programação Python, para codificar a nossa solução.

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

Obs.: Não se preocupe, vocês não tem a obrigação de entender o que está acontecendo aqui em cima, apenas entender que isso é uma solução 
para o nosso problema ;-).

Vocês provavelmente deve ter notado que a nossa solução foi feita de cima para baixo ou "Top-down", essa é uma forma de aproximação muito comum para resolução de problemas do mundo real, e é também chamada de aproximação descendente.

## Estruturas de Dados

Do outro lado da moeda, nós temos Estruturas de dados, que são formas de representar itens de dados que são logicamente relacionados ao dados
que queremos representar. Isso parece muito confuso, mas pense o seguinte: Vamos supor que estamos trabalhando em um algoritmo para 
calcular o troco em uma padaria. Você provavelmente sabe que trabalhos com números que tem casas decimais (por exemplo R$3.14), essa representação
númerica (3.14) chamamos isso de um número com ponto flutuante ou apenas float, e um float é uma estrutura de dado que está logicamente relacionado
com o problema que queremos resolver da vida real.

Um exemplo mais simples ainda, estamos programando o interruptor de uma lâmpada, sabemos aqui que temos dois estados: ligado (ON) e desligado (OFF), para isso temos uma estrutura de dado chamado boolean (ou simplesmente bool) que representa um dígito (0 ou 1) onde 0 representa falso "False" e pode ser a nossa lâmpada desligada, e 1 representa verdadeiro "True" e pode ser a nossa lâmpada ligada.

# Por enquanto é so...

É claro que tem muito mais a ser explorado na disciplina, mas acredito que por enquanto seja o suficiente. Com os conhecimentos aqui vocês tiveram uma pequena amostra em o quê a disciplina irá trabalhar. Fique a vontade para também olhar o material complementar dessa aula, pois contém outras fontes de recursos na qual você pode aprender a disciplina, além do material que foi usado para fazer essa aula.

Muito obrigado e até a próxima! 

## Links úteis

- [Aula completa de AEDs1 - UNIVERSIDADE FERNANDO PESSOA](http://www3.dsi.uminho.pt/iiee/repos/AEDados.pdf)
- [CS50 - Uma das melhores aulas introdutórias de Computação do Mundo!](http://www3.dsi.uminho.pt/iiee/repos/AEDados.pdf)
