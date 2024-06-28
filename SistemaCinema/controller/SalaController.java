package controller;

import model.*;
import view.*;
import java.util.ArrayList;
import java.util.List;

public class SalaController {
    private SalaView view;
    private List<Sala> salas;

    public SalaController(SalaView view) {
        this.view = view;
        this.salas = new ArrayList<>();
    }

    public Sala criarSala() {
        int numero = view.lerNumeroSala();
        int quantidadeAssentos = view.lerQuantidadeAssentos();
        Sala sala = new Sala(numero, quantidadeAssentos);
        salas.add(sala);
        return sala;
    }

    public List<Sala> listarSalas() {
        return salas;
    }
}
