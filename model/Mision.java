package model;
import java.util.ArrayList;
import java.util.Collections;

public class Mision {
    private ArrayList <Modulo> modulos = new ArrayList<>();
    private RecursosMision recursos;
    public Mision(RecursosMision recursos){
        this.recursos = recursos;
        cargarModulosIniciales();
    }
    
    private void cargarModulosIniciales(){
        modulos.add(new ModuloEnergia(93210, "Panel solar", 100, 300, 50));
        modulos.add(new ModuloTierra(29410, "Antena de descarga", 100, 400, 300));
        modulos.add(new ModuloVuelo(93021, "Sénsor orbitador", 100, 250, 100));
        modulos.add(new ModuloEnergia(93210, "Batería", 100, 400, 100));
        modulos.add(new ModuloTierra(29410, "Antena de descarga", 100, 400, 300));
        modulos.add(new ModuloVuelo(93021, "Cámara orbitante", 100, 250, 100));
        modulos.add(new ModuloEnergia(93210, "Panel solar", 100, 300, 50));
        modulos.add(new ModuloTierra(29410, "Antena protectora", 100, 400, 300));
        modulos.add(new ModuloVuelo(93021, "Sénsor orbitador", 100, 250, 100));
        modulos.add(new ModuloEnergia(93210, "Set de baterías", 300, 900, 225));
    }
    public ArrayList<Modulo> listarModulo(){
        return new ArrayList<>(modulos);
    }
    
    public Modulo buscarModulo(int id){
        for (int i = 0; i<modulos.size();i++){
            if (modulos.get(i).getId()== id){
                return modulos.get(i);
            }
        }
        return null;
}

    public Modulo buscarModulo(String nombre){
                for (int i = 0; i<modulos.size();i++){
            if (modulos.get(i).getNombre().equalsIgnoreCase(nombre.trim())){
                //trim elimina los espacios al inicio y el final, algo así:
                //( panel solar o panel solar ), el ignore case es para
                // que panel solar, PANEL SOLAR y Panel solar; muestren lo mismo
                return modulos.get(i);
            }
        }
        return null;
    }
    public void ordenarModuloPorCosto(){
        Collections.sort(modulos);
    }
    public void agregarModulo(Modulo nuevo) {
    if (buscarModulo(nuevo.getId()) != null) {
        throw new IllegalArgumentException("Ese ID ya existe.");
    }

    modulos.add(nuevo);
}

    public RecursosMision getRecursos(){
        return recursos;

    }
}
