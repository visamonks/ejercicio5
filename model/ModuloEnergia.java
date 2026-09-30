package model;

public class ModuloEnergia extends Modulo {
    private double energiaGeneradaPorCiclo;

    public ModuloEnergia(String id, String nombre, double salud, double costoConstruccion, double energiaGenerada) {
        super(id, nombre, salud, costoConstruccion);
        this.energiaGeneradaPorCiclo = energiaGenerada;
    }

    public double getEnergiaGeneradaPorCiclo() {
        return energiaGeneradaPorCiclo;
    }

    @Override
    public void procesarCiclo(RecursosMision recursos) {
        recursos.modificarEnergia(energiaGeneradaPorCiclo);
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: Energía, Energía generada/ciclo: " + energiaGeneradaPorCiclo;
    }
}
