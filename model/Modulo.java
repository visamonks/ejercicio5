package model;

public abstract class Modulo implements Comparable<Modulo> {
    protected String id;
    protected String nombre;
    protected double salud;
    protected double costoConstruccion;

    public Modulo(String id, String nombre, double salud, double costoConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.salud = salud;
        this.costoConstruccion = costoConstruccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public double getCostoConstruccion() {
        return costoConstruccion;
    }

    public abstract void procesarCiclo(RecursosMision recursos);

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Salud: " + salud + ", Costo: " + costoConstruccion;
    }

    @Override
    public int compareTo(Modulo otro) {
        return Double.compare(this.costoConstruccion, otro.costoConstruccion);
    }
}
