import model.*;
import view.*;
import controller.*;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        CinemaView cinemaView = new CinemaView();
        FilmeView filmeView = new FilmeView();
        SalaView salaView = new SalaView();
        SessaoView sessaoView = new SessaoView();

        FilmeController filmeController = new FilmeController(filmeView);
        SalaController salaController = new SalaController(salaView);
        SessaoController sessaoController = new SessaoController(sessaoView, filmeController, salaController);
        CinemaController cinemaController = new CinemaController(cinema, cinemaView);

        cinemaController.iniciar();

        sessaoController.criarSessao();
    }
}
