# projetoAgenda
um projeto simples de CRUD para uma Agenda usando PostgreSQL

# Documentação do Projeto de Agenda em Java

Este documento fornece uma visão geral do projeto de agenda desenvolvido em Java. O projeto permite criar, gerenciar e visualizar contatos em um banco de dados PostgreSQL. Ele oferece uma interface de linha de comando simples para interagir com o sistema de agenda.

## Requisitos

Para executar o projeto, você precisará do seguinte:

1. **Java Development Kit (JDK):** O JDK é necessário para compilar e executar o código Java. Certifique-se de ter o JDK instalado em sua máquina.

2. **Banco de Dados PostgreSQL:** O projeto utiliza um banco de dados PostgreSQL para armazenar os contatos. Você pode ter um banco de dados PostgreSQL instalado localmente ou em um servidor remoto.

## Configuração

1. **Clone o Repositório:** Clone este repositório do GitHub para o seu ambiente local.

2. **Configuração do Banco de Dados:** Se você estiver usando um banco de dados PostgreSQL local, certifique-se de tê-lo instalado e em execução. Se estiver usando um banco de dados remoto, lembre-se de atualizar a URL de conexão no arquivo `ConexaoJDBC.java` para apontar para o banco de dados remoto.

## Executando o Projeto

1. **Compilando:** Navegue para o diretório raiz do projeto onde o arquivo `Principal.java` está localizado. Compile o projeto executando o seguinte comando no terminal:

   ```
   javac Principal.java
   ```

2. **Executando:** Após compilar o projeto, execute-o com o seguinte comando:

   ```
   java Principal
   ```

3. **Interagindo com o Projeto:** O projeto apresentará um menu de opções na linha de comando. Use as opções fornecidas para criar, localizar, atualizar e apagar contatos, além de listar todos os contatos cadastrados. Siga as instruções na tela para inserir os dados necessários.

## Observações

- **Banco de Dados Remoto:** Se você estiver usando um banco de dados PostgreSQL remoto, lembre-se de atualizar a URL de conexão no arquivo `ConexaoJDBC.java`. Certifique-se de ter uma conexão com a internet ao interagir com um banco de dados remoto.

## Conclusão

O projeto de agenda em Java oferece uma maneira simples e prática de criar, gerenciar e visualizar contatos. Com uma configuração mínima, você pode executar o projeto localmente e aproveitar suas funcionalidades de gerenciamento de contatos. Sinta-se à vontade para explorar e personalizar o projeto de acordo com suas necessidades.
