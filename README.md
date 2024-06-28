Objetivo do Código
O objetivo deste código é implementar um sistema de gerenciamento de cinema que permite controlar e visualizar informações sobre cinemas, clientes, filmes, funcionários, salas e sessões. O sistema segue a arquitetura Model-View-Controller (MVC) para separar a lógica de negócios, a interface do usuário e o controle de fluxo.

Estrutura do Projeto
O projeto é organizado em vários pacotes, cada um contendo classes que seguem a arquitetura MVC:

controller: Contém as classes responsáveis pelo controle da lógica do sistema.
model: Contém as classes que representam os dados e a lógica de negócios.
view: Contém as classes responsáveis pela interface do usuário.
SistemaCinema: Contém a classe principal para executar a aplicação.
Pacotes e Classes

1. controller
CinemaController.java: Gerencia a lógica relacionada ao cinema.
ClienteController.java: Gerencia a lógica relacionada aos clientes.
FilmeController.java: Gerencia a lógica relacionada aos filmes.
FuncionarioController.java: Gerencia a lógica relacionada aos funcionários.
SalaController.java: Gerencia a lógica relacionada às salas.
SessaoController.java: Gerencia a lógica relacionada às sessões.

2. model
Assento.java: Representa um assento em uma sala de cinema.
Atendente.java: Representa um atendente do cinema.
Cinema.java: Representa um cinema.
Cliente.java: Representa um cliente do cinema.
Filme.java: Representa um filme.
Funcionario.java: Representa um funcionário do cinema.
Gerente.java: Representa um gerente do cinema.
Ingresso.java: Representa um ingresso para um filme.
Sala.java: Representa uma sala de cinema.
Sessao.java: Representa uma sessão de filme.

3. view
CinemaView.java: Interface do usuário para visualização do cinema.
ClienteView.java: Interface do usuário para visualização dos clientes.
FilmeView.java: Interface do usuário para visualização dos filmes.
FuncionarioView.java: Interface do usuário para visualização dos funcionários.
SalaView.java: Interface do usuário para visualização das salas.
SessaoView.java: Interface do usuário para visualização das sessões.

4. SistemaCinema
Main.java: Classe principal para executar a aplicação.
Descrição das Classes
CinemaController.java
Controlador responsável por gerenciar a lógica relacionada ao cinema, como adicionar novos cinemas, atualizar informações e listar cinemas existentes.

ClienteController.java
Controlador responsável por gerenciar a lógica relacionada aos clientes, incluindo adicionar novos clientes, atualizar informações de clientes e listar clientes.

FilmeController.java
Controlador responsável por gerenciar a lógica relacionada aos filmes, como adicionar novos filmes, atualizar informações e listar filmes disponíveis.

FuncionarioController.java
Controlador responsável por gerenciar a lógica relacionada aos funcionários, incluindo adicionar novos funcionários, atualizar informações e listar funcionários.

SalaController.java
Controlador responsável por gerenciar a lógica relacionada às salas de cinema, como adicionar novas salas, atualizar informações e listar salas disponíveis.

SessaoController.java
Controlador responsável por gerenciar a lógica relacionada às sessões de cinema, incluindo adicionar novas sessões, atualizar informações e listar sessões disponíveis.

Assento.java
Modelo que representa um assento em uma sala de cinema, com atributos como número do assento, disponibilidade e tipo de assento.

Atendente.java
Modelo que representa um atendente do cinema, com atributos específicos para o papel de atendente.

Cinema.java
Modelo que representa um cinema, com atributos como nome, endereço e lista de salas.

Cliente.java
Modelo que representa um cliente do cinema, com atributos como nome, CPF, e histórico de compras.

Filme.java
Modelo que representa um filme, com atributos como título, duração, gênero e classificação indicativa.

Funcionario.java
Modelo que representa um funcionário do cinema, com atributos comuns a todos os funcionários, como nome, CPF e cargo.

Gerente.java
Modelo que representa um gerente do cinema, com atributos específicos para o papel de gerente.

Ingresso.java
Modelo que representa um ingresso para um filme, com atributos como assento, sessão e preço.

Sala.java
Modelo que representa uma sala de cinema, com atributos como número da sala, capacidade e lista de assentos.

Sessao.java
Modelo que representa uma sessão de filme, com atributos como filme, sala, horário de início e fim.

CinemaView.java
Classe de visualização para exibir informações do cinema e interagir com o usuário.

ClienteView.java
Classe de visualização para exibir informações dos clientes e interagir com o usuário.

FilmeView.java
Classe de visualização para exibir informações dos filmes e interagir com o usuário.

FuncionarioView.java
Classe de visualização para exibir informações dos funcionários e interagir com o usuário.

SalaView.java
Classe de visualização para exibir informações das salas e interagir com o usuário.

SessaoView.java
Classe de visualização para exibir informações das sessões e interagir com o usuário.

Main.java
Classe principal que contém o método main para iniciar a aplicação.

Aonde o ChatGPT foi usado:

O ChatGPT foi usado na criação da documentação e para a correção de alguns erros nas funções.
