import model.Cliente;
import view.ClienteView;

public class ClienteController {
    private ClienteView view;

    public ClienteController(ClienteView view) {
        this.view = view;
    }

    public Cliente criarCliente() {
        String nome = view.lerNome();
        int cpf = view.lerCpf();
        int idade = view.lerIdade();
        String sexo = view.lerSexo();
        return new Cliente(nome, cpf, idade, sexo);
    }
}
