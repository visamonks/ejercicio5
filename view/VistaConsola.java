package view;
import model.Mision;
import model.Modulo;
import java.util.Scanner;

public class VistaConsola{
    private Scanner scanner = new Scanner(System.in);
    public void mostrarMenu(){
        mostrarMensaje("----------------------------------------------------------");
        mostrarMensaje("Bienvenido al Menú, elija una de las siguientes opcion:");
        mostrarMensaje("1. Listar los módulos");
        mostrarMensaje("2. Buscar módulo específico (ID/nombre)");
        mostrarMensaje("3. Ordenar por costos de construcción");
        mostrarMensaje("4. Agregar módulos extra");
        mostrarMensaje("5. Salir del programa");

    }
    public int decision(){
        mostrarMensaje("Ingrese qué método de busqueda empleará:");
        mostrarMensaje("1. ID");
        mostrarMensaje("2. Nombre"); 
        int decision = scanner.nextInt();
        scanner.nextLine();
        return decision;
    }

    public int solicitarCantidadModulos() {
    while (true) {
        mostrarMensaje("¿Cuántos módulos deseas agregar?");

        try {
            int cantidad = Integer.parseInt(scanner.nextLine().trim());

            if (cantidad > 0) {
                return cantidad;
            }

            mostrarError("La cantidad debe ser mayor que cero.");
        } catch (NumberFormatException e) {
            mostrarError("Ingresa un número entero.");
        }
    }
}

    public int solicitarId(){
        mostrarMensaje("Ingrese la ID del módulo");

        while(true){
        try{
            int id = scanner.nextInt();
            scanner.nextLine();
        if (id<=0){
            throw new IllegalArgumentException("Esa id no es posible, intente de nuevo");
        }
        else{
            return id;
        }
    }catch (Exception e){
        limpiarEntrada();
        mostrarError("Esta id no es válido, intente de nuevo");
    }
}
}

    public String solicitarNombre(){
        mostrarMensaje("Ingrese el nombre del módulo");
        String nombre = scanner.nextLine();
        return nombre;

    }
    public void mostrarModulos(Mision mision){
        for (Modulo modulo : mision.listarModulo()) {
        System.out.println(modulo);
    }
    }
    public int leerEntero(String mensaje) {
        while (true) {
            mostrarMensaje(mensaje);

            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());

                if (valor > 0) {
                    return valor;
                }

                mostrarError("Ingresa un valor mayor que cero.");
            } catch (NumberFormatException e) {
                mostrarError("Ingresa un número entero válido.");
        }
    }
}

    public double leerDecimal(String mensaje) {
        while (true) {
            mostrarMensaje(mensaje);

            try {
                double valor = Double.parseDouble(scanner.nextLine().trim());

                if (Double.isFinite(valor) && valor > 0) {
                    return valor;
                }

                mostrarError("Ingresa un número válido mayor o igual a cero.");
            } catch (NumberFormatException e) {
                mostrarError("Ingresa un número; usa punto para los decimales.");
            }
        }
    }

    public int leerOpcion(){
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public void limpiarEntrada() {
    scanner.nextLine();
    }
    
    public void detalleModulo(Modulo modulo){
        mostrarMensaje("Detalles del módulo:");
        System.out.println(modulo);
    }

    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
    public void mostrarError(String mensaje){
        System.out.println("Error: " + mensaje);

    }
}

