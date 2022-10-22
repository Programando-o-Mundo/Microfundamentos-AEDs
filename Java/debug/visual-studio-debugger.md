# Fazendo debug pelo Visual Studio Code

# Gustavo Lopes Rodrigues 

## Você vai aprender

- Como fazer depuração pelo VSCode

## Pré-Requisitos

- Noções básicas de Java
- Ter o Visual Studio Code instalado na sua máquina
- Noções básicas do Visual Studio Code

## Depuração de código

Muitas vezes o programador não terá uma IDE (Integrated Development Environment) para fazer depuração de código. Entretanto, quando temos acesso a tais ferramentas, como a disponibilizada pelo Visual Studio Code, não devemos menosprezar sua capacidade de ajudar a entender mais rápido e mais fácil os problemas que está acontecendo com o código.

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

![image](https://user-images.githubusercontent.com/9157977/196299120-bad11077-9bf9-446a-ac85-be49049ce4ce.png)

Perceba que a cima da função **Main** tem um marcador dizendo *Debug* que é onde podemos iniciar o processo de depuração (Obs.: você também pode iniciar a depuração clicando no botão ao lado do "play" e clicar em **Debug Java**).

![1](https://user-images.githubusercontent.com/9157977/196300335-9209ba3e-63bd-4ce3-9b53-37d2f0613f41.jpg)

Entretanto, se você clicar nele, o programa irá rodar e finalizar normalmente. Isso acontece pois para o processo de debug ser realmente efetivo, precisamos colocar um breakpoint ou um ponto de parada no código.

Para colocar um breakpoint, apenas clique na bolinha vermelha no lado de cada número.

![breakpoint](https://user-images.githubusercontent.com/9157977/197355090-44f6f94f-9f94-4a52-83eb-813d2a27b588.png)

Se clicarmos para rodar o Debug novamente, perceba que agora o nosso código está parado na linha em que colocamos o breakpoint (a linha marcada em amarelo)  e podemos inspecionar o nosso código durante execução. Vamos dar uma olhada na nossa área de trabalho de depuração:

![area-de-trabalho](https://user-images.githubusercontent.com/9157977/197355311-b4d900f9-ab9b-45e6-b945-6c02215de137.png)

Perceba que além disso, temos tambem outras áreas de trabalho que foram abertas pelo depurador, que permitem inspecionar elementos mais específicos do nosso código, vamos dar uma breve pincelada em cada um desses componentes.

# Call Stack

![CallStack](https://user-images.githubusercontent.com/9157977/197355488-5ad8f1cf-82b6-46f6-9f6f-b2931353f543.png)

Primeiramente temos a Pilha de Chamadas ou *Call Stack*, onde temos todas as Threads sendo executas, além da pilha de funções que foram chamadas. Como temos apenas a função "Main" no nosso código, então só temos ela na pilha, porém se tivessemos colocado o breakpoint em uma função que é chamada por outras, isso seria visível pela Call Stack.

# Breakpoints

![image](https://user-images.githubusercontent.com/9157977/197355820-39c57b52-a394-4d5b-8241-0a264a9e900d.png)

# Variables

![image](https://user-images.githubusercontent.com/9157977/197355852-1e376090-b320-4945-9d8b-29328331889f.png)

# Watch

![image](https://user-images.githubusercontent.com/9157977/197356043-9c857b9e-6a15-4f72-be64-acdf56bdca4e.png)

# Ferramentas para passar pelo código

![i](https://user-images.githubusercontent.com/9157977/197356085-0882317e-f0b6-41eb-9816-45a3c3be7e34.png)


# Links úteis

[Documentação oficial](https://code.visualstudio.com/docs/java/java-debugging)
