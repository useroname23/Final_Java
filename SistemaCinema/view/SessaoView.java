package view;

import java.util.List;
import java.util.Scanner;

import model.Filme;
import model.Sala;

public class SessaoView {
    private Scanner scanner;

    public SessaoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void mostrarFilmes(List<Filme> filmes) {
        System.out.println("\n> Filmes disponíveis:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println("> " + (i + 1) + ". " + filmes.get(i).getTitulo());
        }
    }

    public Filme selecionarFilme(List<Filme> filmes) {
        System.out.print("\n> Selecione o filme (número): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return filmes.get(escolha - 1);
    }

    public void mostrarSalas(List<Sala> salas) {
        System.out.println("\n> Salas disponíveis:");
        for (int i = 0; i < salas.size(); i++) {
            System.out.println("> " + (i + 1) + ". Sala " + salas.get(i).getNumero());
        }
    }

    public Sala selecionarSala(List<Sala> salas) {
        System.out.print("\n> Selecione a sala (número): ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        return salas.get(escolha - 1);
    }

    public String lerHorario() {
        System.out.print("\n> Horário da sessão (formato HH:MM): ");
        String horario = scanner.nextLine();
       
        return horario;
    }
    
}
