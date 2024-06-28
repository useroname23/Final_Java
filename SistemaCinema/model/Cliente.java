package model;

public class Cliente {
    private String nome;
    private String cpf;
    private String idade;
    private String sexo;

    public Cliente(String nome, String cpf, String idade, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo =  sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }
}
