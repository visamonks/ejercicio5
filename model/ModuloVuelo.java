package model;

public class ModuloVuelo extends Modulo {
    private double datosGeneradosPorCiclo;

    public ModuloVuelo(int id, String nombre, double salud, double costoConstruccion, double datosGenerados) {
        super(id, nombre, salud, costoConstruccion);
        this.datosGeneradosPorCiclo = datosGenerados;
    }

    public double getDatosGeneradosPorCiclo() {
        return datosGeneradosPorCiclo;
    }

    @Override
    public void procesarCiclo(RecursosMision recursos) {
        recursos.agregarDatosPendientes(datosGeneradosPorCiclo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Vuelo, Datos generados/ciclo: " + datosGeneradosPorCiclo;
    }
}
