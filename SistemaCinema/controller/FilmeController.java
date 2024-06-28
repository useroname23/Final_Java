package controller;

import model.Filme;
import view.FilmeView;
import java.util.ArrayList;
import java.util.List;

public class FilmeController {
    private FilmeView view;
    private List<Filme> filmes;

    public FilmeController(FilmeView view) {
        this.view = view;
        this.filmes = new ArrayList<>();
    }

    public Filme criarFilme() {
        String titulo = view.lerTitulo();
        String genero = view.lerGenero();
        int duracao = view.lerDuracao();
        Filme filme = new Filme(titulo, genero, duracao);
        filmes.add(filme);
        return filme;
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }
}
