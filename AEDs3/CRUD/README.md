# CRUD

CRUD significa Criar (**C**reate), Ler (**R**ead), Atualizar (**U**pdate) e Excluir (**D**elete). Essas são as quatro operações básicas normalmente implementadas para qualquer armazenamento persistente, seja um banco de dados, sistema de arquivos ou algum outro tipo de sistema de armazenamento.

![crud](https://user-images.githubusercontent.com/9157977/210387625-8803252f-d142-4586-b16b-e09701f260f2.jpg)

Fonte: https://devporai.com.br/o-que-e-crud-e-porque-voce-deveria-aprender-a-criar-um/

A operação Create é usada para criar um novo registro ou recurso no sistema de armazenamento. Por exemplo, você pode usar a operação Create para adicionar um novo cliente a um banco de dados ou criar um novo arquivo em um sistema de arquivos.

A operação Read é usada para recuperar um registro ou recurso existente do sistema de armazenamento. Por exemplo, você pode usar a operação Read para procurar um cliente por seu ID ou para ler o conteúdo de um arquivo.

A operação Update é usada para modificar um registro ou recurso existente no sistema de armazenamento. Por exemplo, você pode usar a operação Update para alterar o endereço de um cliente ou atualizar o conteúdo de um arquivo.

A operação Delete é usada para remover um registro ou recurso existente do sistema de armazenamento. Por exemplo, você pode usar a operação Delete para remover um cliente de um banco de dados ou excluir um arquivo de um sistema de arquivos.

As operações CRUD são uma parte fundamental de muitos sistemas de software e geralmente são implementadas como parte da camada de persistência de um aplicativo, responsável por armazenar e recuperar dados de um sistema de armazenamento persistente.

Felizmente neste módulo temos dois exemplos de apoio para ajudar você a criar o seu próprio CRUD genérico, ou seja, você pode usá-lo para armazenar qualquer tipo de Objeto, desde que o mesmo tenha suporte para as operações que o CRUD precisa. A primeira versão **CRUD-simples** possui as implementações básicas do CRUD e além do uso de um índice direto e indireto para melhor atravessia das operações do CRUD. Por fim temos uma segunda implementação que usa de Arvore B+ e Hash Extensível que foi feita por mim, mas as implementações das estruturas de Arvore e Hash foram feitos pelo [Professor Marcos Kutova](https://www.kutova.com/)

- [Crud Simples](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/tree/main/AEDs3/CRUD/CRUD-simples)
- [Crud Avançado](https://github.com/Programando-o-Mundo/Microfundamentos-AEDs/tree/main/AEDs3/CRUD/CRUD-com-arvore-bmais-e-hash-extensivel)

Bons estudos!
