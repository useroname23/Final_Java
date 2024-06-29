    package view;

    import java.util.Scanner;

    public class FuncionarioView {
        private Scanner scanner;

        public FuncionarioView() {
            scanner = new Scanner(System.in);
        }

        public String lerNome() {
            String nomi;
            while (true) {
                System.out.print("> Nome do funcionario: ");
                nomi = scanner.nextLine();
                if (nomi.matches("[a-zA-Z\\s]+")) {
                    break;
                } else {
                    System.out.println("Nome inválido. Use apenas letras e espaços.");
                }
            }
            return nomi;
        }

        public String lerSexo() {
            String sexo;
            while (true) {
                System.out.print("> Sexo do funcionario: ");
                sexo = scanner.nextLine();
                if (sexo.matches("[a-zA-Z\\s]+")) {
                    break;
                } else {
                    System.out.println("Sexo inválido.");
                }
            }
            return sexo;
        }

        public int lerCpf() {
            int cpf;
            while (true) {
                System.out.print("> Cpf do funcionario: ");
                if (scanner.hasNextInt()) {
                    cpf = scanner.nextInt();
                    scanner.nextLine();
                    if (cpf > 0) {
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

    }