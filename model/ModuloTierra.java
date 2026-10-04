package model;

public class ModuloTierra extends Modulo {
    private double tasaDescarga;

    public ModuloTierra(int id, String nombre, double salud, double costoConstruccion, double tasaDescarga) {
        super(id, nombre, salud, costoConstruccion);
        this.tasaDescarga = tasaDescarga;
    }

    public double getTasaDescarga() {
        return tasaDescarga;
    }

    @Override
    public void procesarCiclo(RecursosMision recursos) {
        recursos.descargarDatos(tasaDescarga);
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Tierra, Tasa de descarga: " + tasaDescarga;
    }
}
