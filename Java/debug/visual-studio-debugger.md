# Fazendo debug pelo Visual Studio Code

# Gustavo Lopes Rodrigues 

## Você vai aprender

- Como fazer depuração pelo VSCode

## Pré-Requisitos

- Noções básicas de Java
- Ter o Visual Studio Code instalado na sua máquina
- Noções básicas do Visual Studio Code

## Depuração de código

Muitas vezes o programador não terá uma IDE (Integrated Development Environment) para fazer depuração de código. Entretanto, quando temos acesso a tais ferramentas, como a disponibilizada pelo Visual Studio Code, não devemos menosprezar sua capacidade de ajudar a entender mais rápido e mais fácil os problemas que está acontecendo com o código. Por conta disso, nesta aula irei explicar o básico para você entender em como usar a ferramenta de depuração do VSCode.

Para iniciarmos a depuração, antes de termos um código, precisamos da extensão [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) da Microsoft, para permitir que o processo de debug possa acontecer.

Segundo precisaremos de um código para que seja possível fazer testes, e para isso iremos começar com uma versão um pouco modificada do código visto na aula de JDB.


```java
public class Main {

    public static int somar(int a, int b) {
      return a + b;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        int c = somar(a,b);

        System.out.println("a + b = " + c);
    }
}
```

Ele é simples, mas será o bastante para começarmos a usar a ferramenta. Com agora a sua IDE aberta, você terá uma area de trabalho parecida com isso.

<img src = "https://user-images.githubusercontent.com/9157977/196299120-bad11077-9bf9-446a-ac85-be49049ce4ce.png" alt = "img1" width = "800" />

Perceba que a cima da função **Main** tem um marcador dizendo *Debug* que é onde podemos iniciar o processo de depuração (Obs.: você também pode iniciar a depuração clicando no botão ao lado do "play" e clicar em **Debug Java**).

<img src = "https://user-images.githubusercontent.com/9157977/196300335-9209ba3e-63bd-4ce3-9b53-37d2f0613f41.jpg" alt = "img2" width = "800" />

Entretanto, se você clicar nele, o programa irá rodar e finalizar normalmente. Isso acontece pois para o processo de debug ser realmente efetivo, precisamos colocar um breakpoint ou um ponto de parada no código.

Para colocar um breakpoint, apenas clique na bolinha vermelha no lado de cada número.

<img src = "https://user-images.githubusercontent.com/9157977/197355090-44f6f94f-9f94-4a52-83eb-813d2a27b588.png" alt = "img3" width = "800" />

Se clicarmos para rodar o Debug novamente, perceba que agora o nosso código está parado na linha em que colocamos o breakpoint (a linha marcada em amarelo)  e podemos inspecionar o nosso código durante execução.

<img src = "https://user-images.githubusercontent.com/9157977/197355311-b4d900f9-ab9b-45e6-b945-6c02215de137.png" alt = "img3" width = "800" />

Perceba que além de termos o nosso código, temos tambem outras áreas de trabalho que foram abertas pelo depurador, que permitem inspecionar elementos mais específicos do nosso código, vamos dar uma breve pincelada em cada um desses componentes.

### Call Stack

![CallStack](https://user-images.githubusercontent.com/9157977/197355488-5ad8f1cf-82b6-46f6-9f6f-b2931353f543.png)

Primeiramente temos a Pilha de Chamadas ou *Call Stack*, onde temos todas as Threads sendo executas, além da pilha de funções que foram chamadas nessas Threads. Como temos apenas a função "Main" no nosso código, então só temos ela na pilha, porém se tivessemos colocado o breakpoint em uma função que é chamada por outras, isso seria visível pela Call Stack.

### Breakpoints

![image](https://user-images.githubusercontent.com/9157977/197355820-39c57b52-a394-4d5b-8241-0a264a9e900d.png)

Nesta aba conseguimos verificar todos os breakpoints presente no nosso código, além de que podemos ativar/desativar breakpoints pertence no nosso código, se julgarmos eles necessários ou desnecessários

### Variables

![image](https://user-images.githubusercontent.com/9157977/197355852-1e376090-b320-4945-9d8b-29328331889f.png)

Como o nome da aba sugere, podemos enxergar todas as variáveis presentes no escopo de uma função, ou seja, todas as variáveis que estejam visíveis dentro de uma função. Toda vez que mudamos de escopo (exemplo.: entramos dentro de uma função, de uma função de uma classe), as variáveis que aparecem nessa aba mmudam.

Uma coisa que podemos é clicar com o botão direito nessas variáveis e teremos um menu aberto com novas opções, uma delas é adicionar a variável para aba "Watch".

### Watch

![image](https://user-images.githubusercontent.com/9157977/197356043-9c857b9e-6a15-4f72-be64-acdf56bdca4e.png)

Quando adicionamos uma variável para a aba "Watch" quer dizer que estamos pedindo para o depurador "ficar de olho" em uma variável, e para que toda vez que uma variável for modificada, o código irá parar no ponto em que ela foi modificada e nos mostrar o resultado. Esse comportamento é bem parecido com o breakpoint, só que é como se tivessemos colocado uma condicional para ativar o breakpoint.

## Ferramentas para passar pelo código

Agora que estamos familiriazados com todas as abas do depurador, podemos agora realmente começar o processo de depuração. Para prosseguirmos com a depuração, iremos utilizar os botões de ferramentas que podem ser encontrados na parte superior da IDE. Confira as possíveis ferramentas que podem ser utilizadas.

![i](https://user-images.githubusercontent.com/9157977/197356085-0882317e-f0b6-41eb-9816-45a3c3be7e34.png)

### Continuar (Continue)

![continue](https://user-images.githubusercontent.com/9157977/197887409-3fdc55fc-5b13-4341-a155-e6d4eef3d60a.png)

Esse botão irar permitir que o código pule para o próximo breakpoint possível. Como não temos mais nenhum breakpoint nesse código, clicar nesse botão apenas resultará no processo de depuração parar.

### Passar por cima (Step Over)

![step-over](https://user-images.githubusercontent.com/9157977/197887431-90f0acbc-0f90-429c-817c-d400ffe769dd.png)

Esse botão irá ir para a próxima linha, pulando qualquer chamada de função que existir, na nossa situação atual, pular a linha atual significa passar por toda a execução da função **somar** e pular para a linha de print.

#### Antes 

![image](https://user-images.githubusercontent.com/9157977/197888772-b0f9e83b-b2a1-4040-84bc-2ba3b8029699.png)

#### Depois

![image](https://user-images.githubusercontent.com/9157977/197888829-21f1a62e-c593-4860-a9c5-41880e560005.png)

### Entrar em (Step Into)

![step-into](https://user-images.githubusercontent.com/9157977/197887453-b090ed4e-bf91-47db-b3cf-6abb882b86d9.png)

Esse botão, terá um comportamento bem parecido com o anterior, ele irá para a próxima linha, porém, a linha atual for a chamada de uma função, o código irá entrar dentro da chamada dessa função. Neste caso então, a depuração irá entrar na função **somar**, mostrando o passo-a-passo de sua execução.

#### Antes 

![image](https://user-images.githubusercontent.com/9157977/197888772-b0f9e83b-b2a1-4040-84bc-2ba3b8029699.png)

#### Depois

![image](https://user-images.githubusercontent.com/9157977/197888922-9c870659-301f-4568-823b-ec65339a2d96.png)

### Ir para fora (Step Out)

![step-out](https://user-images.githubusercontent.com/9157977/197887512-b57a2ae2-7805-4380-b670-579f2b6489d6.png)

Vamos supor o seguinte cenário, você entra dentro de uma função, você verifica o que você queria verificar nela e agora quer sair dela e continuar a execução fora da função. Para isso que serve o botão **Step Out** ele termina a execução da função, e retorna para a linha onde essa função foi chamada.

### Recarregar (Reload)

![reload](https://user-images.githubusercontent.com/9157977/197887532-2648f591-a5f6-4e71-9571-6941c5619789.png)

Como o nome sugere, ele irá recarregar o processo de depuração, retornando para o primeiro breakpoint.

### Parar (Stop)

![stop](https://user-images.githubusercontent.com/9157977/197887543-ea0bf1fd-f383-421a-9032-05b50f65955f.png)

Como o nome sugere, o processo de depuração será encerrado de forma prematura. 

**Obs.:** Você também pode interromper o processo de depuração, se você apertar **Ctrl + C** no terminal onde a depuração foi iniciada.

### Hot replace

![hot-replace](https://user-images.githubusercontent.com/9157977/197887565-1b57f898-02d6-4fbe-8d99-a834cd2a3b47.png)

Essa função especial do VSCode, permite o programador trocar o valor de variáveis em tempo de execução. Basta o programador escolher a variável e então clicar
no botão "Hot replace" o depurador irá voltar para o momento da instância da variável e então continuar a depuração com o novo valor.

# Conclusão

Isso conclui todos os básicos para a depuração de código dentro do Visual Studio Code, dessa forma vai ficar muito fácil visualizar os seus códigos assim como também encontrar qualquer erro que possa estar acontecendo que gere exceções ou problemas na lógica do código. Sugiro que para mais informações consulte a página oficial da extensão no site do Visual Studio Code.

# Links úteis

[Documentação oficial](https://code.visualstudio.com/docs/java/java-debugging)
