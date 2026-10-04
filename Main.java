import view.VistaConsola;
import controller.ControladorMision;
import model.Mision;
import model.RecursosMision;
public class Main {
    public static void main(String[] args) {
        Mision modelo = new Mision(new RecursosMision(100));
        VistaConsola view = new VistaConsola();

        ControladorMision controller =
                new ControladorMision(modelo, view);

        view.mostrarMensaje("Sistema Quetzal-2 inicializado correctamente.");
        controller.iniciar();
    }
}
