package model;

public class Atendente extends Funcionario {
    public Atendente(String nome, int cpf, String sexo) {
        super(nome, cpf, sexo);
    }

    @Override
    public void realizarTarefa() {
        System.out.println();
    }
}
