package view;

import java.util.Scanner;

public class SessaoView {
    private Scanner scanner;

    public SessaoView() {
        scanner = new Scanner(System.in);
    }

      public int lerInt(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    public String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }

    public String lerHorario() {
        System.out.print("> Horário da sessão (formato HH:MM): ");
        String horario = scanner.nextLine();
       
        return horario;
    }

}
