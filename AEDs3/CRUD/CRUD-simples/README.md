# Desafio CRUD para a disciplina de AEDs3

```bash
Nome: Gustavo Lopes Rodrigues
Professor: Marcos André Silveira Kutova
```

## O que eu fiz e não fiz

Create() - implementado e funcional

Read(int id) - implementado e funcional

Read(String secKey) - implementado e funcional

Update() - mais ou menos implementado(O programa não irá conseguir atualizar
registros com tamanhos diferentes)

Delete(int id) - implementado e funcional

Delete(String secKey) - Obs: Eu não lembro de você pedir para fazer isso, mas eu
decidi implementar de qualquer maneira, e ele tá funcionando.

## Observação

Eu peço desculpas que eu não consegui implementar o Update por completo, eu
não me organizei muito bem e deixei coisas serem acumuladas e como resultado
não consegui fazer a implementação que eu queria a tempo.

A ideia que eu tinha originalmente é de que o Update primeiro verificaria se o 
registro existe. Se ele não existe o programa sugere para o usuario primeiro
criar o registro. Caso contrário, então o programa iria resgatar os dados do objeto.
Se o tamanho dos dados for o mesmo que o objeto anterior, o programa então iria só escrever
em cima.

Se os novos dados tiverem tamanho diferente, então o programa precisa reajustar 
o arquivo para encaixar o registro. A maneira que eu iria fazer isso, seria pegar
todos os dados depois do registro a ser atualizado e então, escrever o novo
registro e depois reescrever os registros.
