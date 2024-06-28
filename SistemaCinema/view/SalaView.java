package view;

import java.util.Scanner;

public class SalaView {
    private Scanner scanner;

    public SalaView() {
        this.scanner = new Scanner(System.in);
    }

    public int lerNumeroSala() {
        int numeroSala;
        while (true) {
            System.out.print("> Número da sala: ");
            if (scanner.hasNextInt()) {
                numeroSala = scanner.nextInt();
                if (numeroSala > 0) {
                    break;
                } else {
                    System.out.println("Digite novamente. Use um número inteiro positivo.");
                }
            } else {
                System.out.println("Digite novamente. Use um número inteiro positivo.");
                scanner.next();
            }
        }
        return numeroSala;
    }

    public int lerQuantidadeAssentos() {
        int quantidadeAssentos;
        while (true) {
            System.out.print("> Quantidade de assentos: ");
            if (scanner.hasNextInt()) {
                quantidadeAssentos = scanner.nextInt();
                if (quantidadeAssentos > 0) {
                    break;
                } else {
                    System.out.println("Digite novamente. Use um número inteiro positivo.");
                }
            } else {
                System.out.println("Digite novamente.Use um número inteiro positivo.");
                scanner.next(); 
            }
        }
        return quantidadeAssentos;
    }
}
