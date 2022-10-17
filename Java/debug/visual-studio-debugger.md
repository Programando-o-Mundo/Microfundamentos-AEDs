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

Perceba que a cima da função **Main** tem um marcador dizendo *Debug* que é onde podemos iniciar o processo de depuração (Obs.: você também pode iniciar a depuração clicando no botão ao lado do "play" e clicar em "Debug Java").

![1](https://user-images.githubusercontent.com/9157977/196300335-9209ba3e-63bd-4ce3-9b53-37d2f0613f41.jpg)

Entretanto, se você clicar nele, o programa irá rodar e finalizar normalmente. Isso acontece pois para o processo de debug ser realmente efetivo, precisamos colocar um breakpoint ou um ponto de parada no código.
