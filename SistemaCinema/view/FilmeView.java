package view;

import java.util.Scanner;

public class FilmeView {
    private Scanner scanner;

    public FilmeView() {
        scanner = new Scanner(System.in);
    }

    public String lerTitulo() {
        String titulo;
        while (true) {
            System.out.print("> Título do filme: ");
            titulo = scanner.nextLine();
            if (titulo.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Título inválido. Use apenas letras e espaços.");
            }
        }
        return titulo;
    }

    public String lerGenero() {
        String genero;
        while (true) {
            System.out.print("> Gênero do filme: ");
            genero = scanner.nextLine();
            if (genero.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Gênero inválido. Use apenas letras e espaços.");
            }
        }
        return genero;
    }

    public int lerDuracao() {
        int duracao;
        while (true) {
            System.out.print("> Duração do filme (em minutos): ");
            if (scanner.hasNextInt()) {
                duracao = scanner.nextInt();
                if (duracao > 0) {
                    break;
                } else {
                    System.out.println("Digite novamente. Use um número inteiro positivo.");
                }
                }else {
                System.out.println("Digite novamente. Use um número inteiro positivo.");
                scanner.next();
            }
        }
        return duracao;
    }
}
