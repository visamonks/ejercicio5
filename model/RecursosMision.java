package model;

public class RecursosMision {
    private double energiaDisponible;
    private double datosPendientes;
    private double datosDescargados;

    public RecursosMision(double energiaInicial) {
        this.energiaDisponible = energiaInicial;
        this.datosPendientes = 0;
        this.datosDescargados = 0;
    }

    public void modificarEnergia(double cantidad) {
        this.energiaDisponible += cantidad;
    }

    public void agregarDatosPendientes(double cantidad) {
        this.datosPendientes += cantidad;
    }

    public void descargarDatos(double cantidad) {
        if (cantidad > this.datosPendientes) {
            this.datosDescargados += this.datosPendientes;
            this.datosPendientes = 0;
        } else {
            this.datosPendientes -= cantidad;
            this.datosDescargados += cantidad;
        }
    }

    public double getEnergiaDisponible() {
        return energiaDisponible;
    }

    public double getDatosPendientes() {
        return datosPendientes;
    }

    public double getDatosDescargados() {
        return datosDescargados;
    }

    @Override
    public String toString() {
        return "Energía: " + energiaDisponible + ", Datos pendientes: " + datosPendientes + ", Datos descargados: " + datosDescargados;
    }
}
