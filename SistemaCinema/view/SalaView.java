package view;

import java.util.List;
import java.util.Scanner;

import model.Sala;

public class SalaView {
    private Scanner scanner;

    public SalaView() {
        this.scanner = new Scanner(System.in);
    }

    public int lerNumeroSala() {
        System.out.print("\n> Número da sala: ");
        return scanner.nextInt();
    }

    public int lerQuantidadeAssentos() {
        System.out.print("> Quantidade de assentos: ");
        return scanner.nextInt();
    }

    public void mostrarSalas(List<Sala> salas) {
        System.out.println("> Salas cadastradas:");
        for (int i = 0; i < salas.size(); i++) {
            System.out.println((i + 1) + ". Sala " + salas.get(i).getNumero());
        }
    }

    public Sala selecionarSala(List<Sala> salas) {
        System.out.print("> Selecione a sala pelo número: ");
        int opcao = scanner.nextInt();
        return salas.get(opcao - 1);
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
