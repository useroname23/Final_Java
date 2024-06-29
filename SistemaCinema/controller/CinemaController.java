import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.*;
import view.*;

public class CinemaController {
    private Cinema cinema;
    private CinemaView view;

    public CinemaController(Cinema cinema, CinemaView view) {
        this.cinema = cinema;
        this.view = view;
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
                        editarFuncionario();
                        break;
                    case 8:
                        excluirFuncionario();
                        break;
                    case 9:
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
        FilmeView filmeView = new FilmeView();
        FilmeController filmeController = new FilmeController(filmeView);
        Filme filme = filmeController.criarFilme();
        cinema.adicionarFilme(filme);
        System.out.println("> Filme adicionado com sucesso!\n");
    }

    private void adicionarSala() {
        SalaView salaView = new SalaView();
        SalaController salaController = new SalaController(salaView);
        Sala sala = salaController.criarSala();
        cinema.adicionarSala(sala);
        System.out.println("> Sala adicionada com sucesso!\n");
    }

    private void adicionarSessao() {
        if (cinema.getFilmes().isEmpty() || cinema.getSalas().isEmpty()) {
            System.out.println("> Não há filmes ou salas disponíveis. Adicione-os primeiro.\n");
            return;
        }
        SessaoView sessaoView = new SessaoView();

        System.out.println("> Escolha um filme:");
        for (int i = 0; i < cinema.getFilmes().size(); i++) {
            System.out.println((i + 1) + ". " + cinema.getFilmes().get(i).getTitulo());
        }
        int filmeIndex = sessaoView.lerInt("> Filme: ");
        Filme filmeEscolhido = cinema.getFilmes().get(filmeIndex);

    
        System.out.println("> Escolha uma sala:");
        for (int i = 0; i < cinema.getSalas().size(); i++) {
            System.out.println((i + 1) + ". Sala " + cinema.getSalas().get(i).getNumero());
        }
        int salaIndex = sessaoView.lerInt("> Sala: ");
        Sala salaEscolhida = cinema.getSalas().get(salaIndex);

        System.out.println("> Digite o horário da sessão:");
        String horario = sessaoView.lerString("> Horário: ");
        Sessao sessao = new Sessao(filmeEscolhido, salaEscolhida, horario);

        cinema.adicionarSessao(sessao);
        System.out.println("> Sessão adicionada com sucesso!\n");
    }

    private void comprarIngresso() {
        if (cinema.getFilmes().isEmpty() || cinema.getSalas().isEmpty()) {
            System.out.println("> Sem sessões");
            return;
        }
        ClienteView clienteView = new ClienteView();
        ClienteController clienteController = new ClienteController(clienteView);
        Cliente cliente = clienteController.criarCliente();

        System.out.println("");
        exibirSessoes();
        int sessaoIndex = view.lerInt("\n> Escolha a sessão: ");
        Sessao sessao = cinema.getSessoes().get(sessaoIndex);

        exibirAssentos(sessao);
        int assentoIndex = view.lerInt("\n> Escolha o assento: ");
        Assento assento = sessao.getSala().getAssentos().get(assentoIndex);

        if (!assento.isOcupado()) {
            assento.setOcupado(true);
            Ingresso ingresso = new Ingresso(cliente, sessao, assento);
            cinema.adicionarIngresso(ingresso);
            System.out.println("> Ingresso comprado com sucesso!\n");
        } else {
            System.out.println("> Assento já ocupado.\n");
        }
    }
        
    private void adicionarFuncionario(){
        FuncionarioView funcionarioView = new FuncionarioView();
        FuncionarioController funcionarioController = new FuncionarioController(funcionarioView);

        System.out.println("> Adicionar Novo Funcionario");
        String tipo = view.lerString("> Tipo de funcionario (Atendente/Gerente): ");
        Funcionario funcionario = funcionarioController.criarFuncionario(tipo);
        if (funcionario != null) {
            cinema.getFuncionarios().add(funcionario);
            System.out.println("> " + tipo + " Adicionado com sucesso!\n");
        } else {
            System.out.println("> Tipo de funcionário inválido\n");
        }
    }

    private void editarFuncionario() {
        System.out.println("\n> Editar Funcionario");
        exibirFuncionarios();
        int funcionarioIndex = view.lerInt("> Escolha o número do funcionário a ser editado: ");
    
        if (funcionarioIndex >= 0 && funcionarioIndex < cinema.getFuncionarios().size()) {
            Funcionario funcionario = cinema.getFuncionarios().get(funcionarioIndex);
            FuncionarioView funcionarioView = new FuncionarioView();
            FuncionarioController funcionarioController = new FuncionarioController(funcionarioView);
            funcionarioController.editarFuncionario(funcionario);
            System.out.println("> Funcionário editado com sucesso!\n");
        } else {
            System.out.println("> Índice inválido. Tente novamente.\n");
        }
    }    
    
    private void excluirFuncionario() {
        System.out.println("\n> Excluir Funcionario");
        exibirFuncionarios();
        int funcionarioIndex = view.lerInt("\n> Escolha o número do funcionário a ser excluído: ");
    
        if (funcionarioIndex >= 0 && funcionarioIndex < cinema.getFuncionarios().size()) {
            Funcionario funcionario = cinema.getFuncionarios().remove(funcionarioIndex);
            System.out.println("> Funcionário " + funcionario.getNome() + " excluído com sucesso!\n");
        } else {
            System.out.println("> Índice inválido. Tente novamente.\n");
        }
    }
            
    private void exibirFuncionarios() {
        System.out.println("\n> Lista de Funcionários:");
        List<Funcionario> funcionarios = cinema.getFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("\n> Nenhum funcionário encontrado.");
        } else {
            for (int i = 0; i < funcionarios.size(); i++) {
                System.out.println((i + 1) + ". " + funcionarios.get(i).getNome());
            }
        }
    }    

   private void exibirSessoes() {
        List<Sessao> sessoes = cinema.getSessoes();
        for (int i = 0; i < sessoes.size(); i++) {
            Sessao sessao = sessoes.get(i);
            System.out.println((i + 1) + ". " + sessao.getFilme().getTitulo() + " - " + sessao.getHorario());
        }
    }

    private void exibirAssentos(Sessao sessao) {
        List<Assento> assentos = sessao.getSala().getAssentos();
        for (int i = 0; i < assentos.size(); i++) {
            Assento assento = assentos.get(i);
            String vermelho = "\u001B[31m";
            String branco = "\u001B[37m";
            System.out.print ((i + 1) + (assento.isOcupado() ? (vermelho + "[X]") : (branco + "[O]")) + " ");
        }
        System.out.println();
    }

    private void exibirMapaAssentos() {
        for (Sessao sessao : cinema.getSessoes()) {
            System.out.println("> Sessão: " + sessao.getFilme().getTitulo() + " - " + sessao.getHorario());
            for (Assento assento : sessao.getSala().getAssentos()) {
                System.out.print(assento.isOcupado() ? "[X]" : "[O]");
            }
            System.out.println();
        }
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados.txt"))) {
            for (Filme filme : cinema.getFilmes()) {
                writer.write("> Filme: " + filme.getTitulo() + "\n> Gênero: " + filme.getGenero() + "\n Duração (em minutos): " + filme.getDuracao() + "\n");
                writer.write("\n");
            }
            for (Sala sala : cinema.getSalas()) {
                writer.write("> Sala: " + sala.getNumero() + "\n> Assentos:" + sala.getAssentos().size() + "\n");
                writer.write("\n");
            }
            for (Sessao sessao : cinema.getSessoes()) {
                writer.write(" Sessao: " + sessao.getFilme().getTitulo() + "\n> Sala: " + sessao.getSala().getNumero() + "\n> Horário: " + sessao.getHorario() + "\n");
                writer.write("\n");
            }
            for (Ingresso ingresso : cinema.getIngressos()) {
                writer.write(" Ingresso \n> CPF: " + ingresso.getCliente().getCpf() + "\n> Nome: "+ingresso.getCliente().getNome() + "\n Idade:" + ingresso.getCliente().getIdade() +  "\n> Sexo: " + ingresso.getCliente().getSexo() + "\n> Filme: " + ingresso.getSessao().getFilme().getTitulo() + "\n> Sala: " + ingresso.getSessao().getSala().getNumero() + "\n> Assento: " + ingresso.getAssento().getNumero() + "\n");
                writer.write("\n");
            }
            for (Funcionario funcionario : cinema.getFuncionarios()) {
                writer.write(" Funcionario \n> CPF: " + funcionario.getCpf() + "\n> Nome: "+funcionario.getNome() + "\n> Sexo: " + funcionario.getSexo());
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
