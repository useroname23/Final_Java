package model;

public abstract class Funcionario {
    private String nome;
    private int cpf;
    private String sexo;

    public Funcionario(String nome, int cpf, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }
    public String getSexo() {
        return sexo;
    }

    public abstract void realizarTarefa();

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Sexo: " + sexo);
    }
}
