package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.*;
import view.*;


public class CinemaController {
    private Cinema cinema;
    private CinemaView view;
    private FilmeController filmeController;
    private SalaController salaController;

    public CinemaController(Cinema cinema, CinemaView view) {
        this.cinema = cinema;
        this.view = view;
        this.filmeController = new FilmeController(new FilmeView());
        this.salaController = new SalaController(new SalaView());
    }

    public void iniciar() {
        while (true) {
            view.exibirMenu();
            int opcao = view.lerOpcao();
            switch (opcao) {
                case 1:
                    adicionarFilme();
                    break;
                case 2:
                    adicionarSala();
                    break;
                case 3:
                    adicionarSessao();
                    break;
                case 4:
                    comprarIngresso();
                    break;
                case 5:
                    exibirMapaAssentos();
                    break;
                case 6:
                    adicionarFuncionario();
                    break;
                case 7:
                    exibirFuncionarios();
                    break;
                case 0:
                    salvarDados();
                    return;
                default:
                    System.out.println("> Opção inválida.");
            }
        }
    }
    
    private void adicionarFilme() {
        Filme filme = filmeController.criarFilme();
        cinema.adicionarFilme(filme);
        System.out.println("\n> Filme adicionado com sucesso! \n");
    }

    private void adicionarSala() {
        Sala sala = salaController.criarSala();
        cinema.adicionarSala(sala);
        System.out.println("\n> Sala adicionada com sucesso! \n");
    }

    private void adicionarSessao() {
        SessaoView sessaoView = new SessaoView();
        SessaoController sessaoController = new SessaoController(sessaoView, filmeController, salaController);
        Sessao sessao = sessaoController.criarSessao(true);
        if (sessao != null) {
            cinema.adicionarSessao(sessao);
            System.out.println("\n> Sessão adicionada com sucesso! \n");
        }
    }

    private void adicionarFuncionario(){
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioView);

        System.out.println("\n> Adicionar Novo Funcionario");
        String tipo = view.lerString("\n> Tipo de funcionario (Atendente/Gerente): ");
        Funcionario funcionario = funcionarioController.criarFuncionario(tipo);
        if (funcionario != null) {
            cinema.getFuncionarios().add(funcionario);
            System.out.println("\n> " + tipo + " Adicionado com sucesso! \n");
        } else {
            System.out.println("\n> Tipo de funcionário inválido");
        }
    }

    private void exibirFuncionarios() {
        System.out.println("\n> Lista de Funcionários:");
        List<Funcionario> funcionarios = cinema.getFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("> Nenhum funcionário encontrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                funcionario.mostrarInformacoes();
                System.out.println(""); 
            }
        }
    }


    private void comprarIngresso() {
        try {
            List<Sessao> sessoes = cinema.getSessoes();
            if (sessoes.isEmpty()) {
                throw new Exception("Não existem sessões disponíveis.");
            }

            ClienteView clienteView = new ClienteView();
            ClienteController clienteController = new ClienteController(clienteView);
            Cliente cliente = clienteController.criarCliente();

            System.out.println("");
            exibirSessoes();
            int sessaoIndex = view.lerInt("\n> Escolha a sessão (índice): ");
            Sessao sessao = cinema.getSessoes().get(sessaoIndex);
            
            System.out.println("");
            exibirAssentos(sessao);
            int assentoIndex = view.lerInt("\n> Escolha o assento (índice): ");
            Assento assento = sessao.getSala().getAssentos().get(assentoIndex);

            if (!assento.isOcupado()) {
                assento.setOcupado(true);
                Ingresso ingresso = new Ingresso(cliente, sessao, assento);
                cinema.adicionarIngresso(ingresso);
                System.out.println("\n> Ingresso comprado com sucesso! \n");
            } else {
                System.out.println("\n> Assento já ocupado. \n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
    }

    private void exibirSessoes() {
        List<Sessao> sessoes = cinema.getSessoes();
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao sessao = sessoes.get(i);
            System.out.println(i + ". " + sessao.getFilme().getTitulo() + " - " + sessao.getHorario());
        }
    }

    private void exibirAssentos(Sessao sessao) {
        List<Assento> assentos = sessao.getSala().getAssentos();
        for (int i = 0; i < assentos.size(); i++) {
            Assento assento = assentos.get(i);
            System.out.print ((i + 1)+(assento.isOcupado() ? "[X]" : "[O]") + " ");
        }
        System.out.println("\n");
    }

    private void exibirMapaAssentos() {
        for (Sessao sessao : cinema.getSessoes()) {
            System.out.println("\n> Sessão: " + sessao.getFilme().getTitulo() + " - " + sessao.getHorario() + "\n");
            for (Assento assento : sessao.getSala().getAssentos()) {
                System.out.print(assento.isOcupado() ? "[X]" : "[O]");
            }
            System.out.println();
        }
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dadosCinema.txt"))) {
            writer.write("> FILMES <");
            for (Filme filme : cinema.getFilmes()) {
                writer.write("\n> Filme: " + filme.getTitulo() + "\n> Gênero: " + filme.getGenero() + "\n> Duração (em minutos): " + filme.getDuracao() + "\n");
                System.out.println("\n");
            }

            writer.write("\n> SALAS <");
            for (Sala sala : cinema.getSalas()) {
                writer.write("\n> Sala: " + sala.getNumero() + "\n> Assentos:" + sala.getAssentos().size() + "\n");
                System.out.println("\n");
            }

            writer.write("\n> SESSÕES <");
            for (Sessao sessao : cinema.getSessoes()) {
                writer.write("\n> Sessao: " + sessao.getFilme().getTitulo() + "\n> Sala: " + sessao.getSala().getNumero() + "\n> Horário: " + sessao.getHorario() + "\n");
                System.out.println("\n");
            }

            writer.write("\n> INGRESSOS <");
            for (Ingresso ingresso : cinema.getIngressos()) {
                writer.write("\n> Ingresso < \n> CPF: " + ingresso.getCliente().getCpf() + "\n> Nome: "+ingresso.getCliente().getNome() + "\n> Idade: " + ingresso.getCliente().getSexo() +  "\n> Sexo: " + ingresso.getCliente().getSexo() + "\n> Filme: " + ingresso.getSessao().getFilme().getTitulo() + "\n> Sala: " + ingresso.getSessao().getSala().getNumero() + "\n> Assento: " + ingresso.getAssento().getNumero() + "\n");
                System.out.println("\n");
            }
            
            writer.write("\n> FUNCIONÁRIOS <");
            for (Funcionario funcionario : cinema.getFuncionarios()) {
                writer.write("\n> CPF: " + funcionario.getCpf() + "\n> Nome: "+funcionario.getNome() + "\n> Sexo: " + funcionario.getSexo());
                System.out.println("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
