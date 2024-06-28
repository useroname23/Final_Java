package model;

public class Cliente {
    private String nome;
    private int cpf;
    private int idade;
    private String sexo;

    public Cliente(String nome, int cpf, int idade, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo =  sexo;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }
}
