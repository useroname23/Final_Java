package model;

public class Gerente extends Funcionario {
    public Gerente(String nome, int cpf, String sexo) {
        super(nome, cpf, sexo);
    }

    @Override
    public void realizarTarefa() {
        System.out.println();
    }
}
