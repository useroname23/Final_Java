package view;

import java.util.List;
import java.util.Scanner;

import model.Filme;

public class FilmeView {
    private Scanner scanner;

    public FilmeView() {
        scanner = new Scanner(System.in);
    }

    public String lerTitulo() {
        System.out.print("\n> Título do filme: ");
        return scanner.nextLine();
    }

    public String lerGenero() {
        System.out.print("> Gênero do filme: ");
        return scanner.nextLine();
    }

    public int lerDuracao() {
        System.out.print("> Duração do filme (em minutos): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();
        return duracao;
    }

    public void mostrarFilmes(List<Filme> filmes) {
        System.out.println("> Filmes cadastrados: <");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println((i + 1) + ". " + filmes.get(i).getTitulo());
        }
    }

    public Filme selecionarFilme(List<Filme> filmes) {
        System.out.print("> Selecione o filme pelo número: <");
        int opcao = scanner.nextInt();
        return filmes.get(opcao - 1);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
