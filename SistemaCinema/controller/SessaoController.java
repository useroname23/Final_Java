package controller;

import model.*;
import view.SessaoView;
import java.util.List;

public class SessaoController {
    private SessaoView view;
    private FilmeController filmeController;
    private SalaController salaController;

    public SessaoController(SessaoView view, FilmeController filmeController, SalaController salaController) {
        this.view = view;
        this.filmeController = filmeController;
        this.salaController = salaController;
    }

    public Sessao criarSessao() {
        return criarSessao(true);
    }

    public Sessao criarSessao(boolean mostrarMensagemErro) {
        List<Filme> filmes = filmeController.listarFilmes();
        List<Sala> salas = salaController.listarSalas();

        if (filmes.isEmpty() || salas.isEmpty()) {
            if (mostrarMensagemErro) {
                view.mostrarMensagem("> Não existem nenhum filme e/ou sala. \n");
            }
            return null;
        } else {
            System.out.println("> Sessão adicionada com sucesso! \n");
        }

        view.mostrarFilmes(filmes);
        Filme filme = view.selecionarFilme(filmes);

        view.mostrarSalas(salas);
        Sala sala = view.selecionarSala(salas);
        String horario = view.lerHorario();
        return new Sessao(filme, sala, horario);
    }
}
