package controller;
import model.Mision;
import view.VistaConsola;
import model.Modulo;
import model.ModuloEnergia;
import model.ModuloTierra;
import model.ModuloVuelo;

public class ControladorMision {
    private Mision modelo;
    private VistaConsola vista;

    public ControladorMision(Mision modelo,VistaConsola vista){
        this.vista = vista;
        this.modelo = modelo;
    }
    public void iniciar(){
    int opcion = 0;

    do {
        try {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            if (opcion <= 0 || opcion > 5) {
                throw new IllegalArgumentException(
                    "Esa opción no está disponible"
                );
            }

            gestionarOpcion(opcion);

        } catch (NumberFormatException e) {
            vista.mostrarError("Debes ingresar una de las opciones.");

        } catch (IllegalArgumentException e) {
            vista.mostrarError(e.getMessage());

        }catch(java.util.InputMismatchException e){
            vista.limpiarEntrada();
            vista.mostrarError("Debes ingresar un número dentro de las opciones.");

        } catch (java.util.NoSuchElementException e) { 
            return;
            //esto es para cuándo cerrás de forma abrupta la consola.
        }
    } while (opcion != 5);
}

    public void gestionarOpcion(int opcion){
        switch(opcion){
        case 1:
            vista.mostrarModulos(modelo);
            break;

        case 2:
            opcion = vista.decision();
            if (opcion == 1){
                int id = vista.solicitarId();
                Modulo modulo = modelo.buscarModulo(id);
                vista.detalleModulo(modulo);
            }
            else if (opcion == 2){
                String nombre = vista.solicitarNombre();
                Modulo modulo = modelo.buscarModulo(nombre);
                vista.detalleModulo(modulo);
            }
            break;

        case 3:
            modelo.ordenarModuloPorCosto();
            vista.mostrarModulos(modelo);
            break;
        
        case 4:
            agregarModulos();
            break;

        case 5:
            vista.mostrarMensaje("Programa finalizado.");
            break;

        default:
            vista.mostrarError("Opción no válida.");
    }

    

}
public void agregarModulos() {
    int cantidad = vista.leerEntero("¿Cuántos módulos agregarás?");

    int agregados = 0;

    while (agregados < cantidad) {
        vista.mostrarMensaje("1. Módulo de energía");
        vista.mostrarMensaje("2. Módulo de tierra");
        vista.mostrarMensaje("3. Módulo de vuelo");
        int tipo = vista.leerEntero("Ingrese el módulo que desea:");
        switch(tipo){
            case 1:
                int id = vista.leerEntero("Ingresa el ID:");

                if (modelo.buscarModulo(id) != null) {
                    vista.mostrarError("Ese ID ya existe.");
                    continue;
                }

                String nombre = vista.solicitarNombre();
                double costo = vista.leerDecimal("Ingresa el costo:");
                double energia = vista.leerDecimal("Ingresa la energía generada por ciclo:");

            try {
                ModuloEnergia nuevo =
                    new ModuloEnergia(id, nombre, 100, costo, energia);

                    modelo.agregarModulo(nuevo);
                    agregados++;

                vista.mostrarMensaje("Módulo agregado correctamente.");
                    vista.mostrarMensaje("Módulo " + (agregados) + " de " + cantidad);
            } catch (IllegalArgumentException e) {
                vista.mostrarError(e.getMessage());
        }
        break;
            case 2:
                id = vista.leerEntero("Ingresa el ID:");

                if (modelo.buscarModulo(id) != null) {
                    vista.mostrarError("Ese ID ya existe.");
                    continue;
                }

                nombre = vista.solicitarNombre();
                costo = vista.leerDecimal("Ingresa el costo:");
                double tasaDescarga = vista.leerDecimal("Ingresa la tasa de descarga:");

                try {
                    ModuloTierra nuevo =
                        new ModuloTierra(id, nombre, 100, costo, tasaDescarga);

                        modelo.agregarModulo(nuevo);
                        agregados++;

                    vista.mostrarMensaje("Módulo agregado correctamente.");
                        vista.mostrarMensaje("Módulo " + (agregados) + " de " + cantidad);
                } catch (IllegalArgumentException e) {
                    vista.mostrarError(e.getMessage());
        }
        break;
            case 3:
                id = vista.leerEntero("Ingresa el ID:");

                if (modelo.buscarModulo(id) != null) {
                    vista.mostrarError("Ese ID ya existe.");
                    continue;
                }

                nombre = vista.solicitarNombre();
                costo = vista.leerDecimal("Ingresa el costo:");
                double datosGeneradosPorCiclo = vista.leerDecimal("Ingrese los datos generados/ciclo:");

                try {
                    ModuloVuelo nuevo =
                        new ModuloVuelo(id, nombre, 100, costo, datosGeneradosPorCiclo);

                        modelo.agregarModulo(nuevo);
                        agregados++;
                    vista.mostrarMensaje("Módulo agregado correctamente.");
                    vista.mostrarMensaje("Módulo " + (agregados) + " de " + cantidad);
                } catch (IllegalArgumentException e) {
                    vista.mostrarError(e.getMessage());
        }
        break;
        default:
            vista.mostrarError("Tipo no válido");
            continue;
        }
    }
}
}


    

