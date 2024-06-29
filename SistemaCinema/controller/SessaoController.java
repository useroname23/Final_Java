package controller;

import model.Filme;
import model.Sala;
import model.Sessao;
import view.SessaoView;

public class SessaoController {
    private SessaoView view;


    public SessaoController(SessaoView view) {
        this.view = view;

    }

    public Sessao criarSessao(Filme filme, Sala sala) {
        String horario = view.lerHorario();
        return new Sessao(filme, sala, horario);
    }
}
