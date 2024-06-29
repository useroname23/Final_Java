package view;

import java.util.Scanner;

public class ClienteView {
    private Scanner scanner;

    public ClienteView() {
        scanner = new Scanner(System.in);
    }

    public String lerNome() {
        String nome;
        while (true) {
            System.out.print("> Nome do cliente: ");
                nome = scanner.nextLine();
                if (nome.matches("[a-zA-Z\\s]+")) {
                    break;
                } else {
                    System.out.println("Nome inválido. Use apenas letras e espaços.");
                }
            }
        return nome;
    }

    public int lerCpf() {
        int cpf;
        while (true) {
            System.out.print("> CPF do cliente: ");
            if (scanner.hasNextInt()) {
                cpf = scanner.nextInt();
                if (cpf > 0) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Digite novamente. Use um número inteiro positivo.");
                }
                }else {
                System.out.println("Digite novamente. Use um número inteiro positivo.");
                scanner.next();
            }
        }
        return cpf;
    }
        public int lerIdade() {
            int idadi;
            while (true) {
            System.out.print("> Idade do cliente: ");
            if (scanner.hasNextInt()) {
                idadi = scanner.nextInt();
                if (idadi > 0) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Digite novamente. Use um número inteiro positivo.");
                }
                }else {
                System.out.println("Digite novamente. Use um número inteiro positivo.");
                scanner.next();
            }
        }
        return idadi;
    }
    
    public String lerSexo() {
        String sexo;
        while (true) {
            System.out.print("> Sexo do cliente: ");
            sexo = scanner.nextLine();
            if (sexo.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Sexo inválido.");
            }
        }
        return sexo;
}

}
