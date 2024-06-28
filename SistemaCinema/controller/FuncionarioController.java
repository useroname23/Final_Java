import model.Atendente;
import model.Funcionario;
import model.Gerente;
import view.FuncionarioView;

public class FuncionarioController {
    private FuncionarioView view;

    public FuncionarioController(FuncionarioView view) {
        this.view = view;
    }

    public Funcionario criarFuncionario(String tipo) {
        String nome = view.lerNome();
        int cpf = view.lerCpf();
        String sexo = view.lerSexo();

        if ("Atendente".equalsIgnoreCase(tipo)) {
            return new Atendente(nome, cpf, sexo);
        } else if ("Gerente".equalsIgnoreCase(tipo)) {
            return new Gerente(nome, cpf, sexo);
        } else {
            return null;
        }
    }
}