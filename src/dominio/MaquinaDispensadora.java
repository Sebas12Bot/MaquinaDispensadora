package dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

public class MaquinaDispensadora {

    private Map<String, Snack> snacks;

    public MaquinaDispensadora() {
        snacks = new HashMap<>();
        Random aleatorio = new Random();
        for (int i = 1; i <= 12; i++) {
            String codigo = String.valueOf(i);
            String nombre = "Snack" + i;
            int cantidadInicial = 6;
            double precio = 500 +(aleatorio.nextDouble()*4500);
            snacks.put(codigo, new Snack(codigo, nombre, cantidadInicial,precio));
        }
    }

    public boolean existirSnack(String codigoONombre) {
        codigoONombre = codigoONombre.toLowerCase();
        for (Snack snack : snacks.values()) {
            String snackCodigo = snack.getCodigo().toLowerCase();
            String snackNombre = snack.getNombre().toLowerCase();
            if (snackCodigo.equals(codigoONombre) ||
                    snackNombre.equals("snack " + codigoONombre) ||
                    snackNombre.equals(codigoONombre)) {
                return true;
            }
        }
        return false;
    }

    public void agregarUnidad(String codigoONombre) {
        codigoONombre = codigoONombre.toLowerCase();
        if (existirSnack(codigoONombre)) {
            Snack snack = obtenerSnack(codigoONombre);
            snack.agregarUnidad();
        } else {
            System.out.println("El snack ingresado no existe.");
        }
    }

    public void sacarUnidad(String codigoONombre) {
        codigoONombre = codigoONombre.toLowerCase();
        if (existirSnack(codigoONombre)) {
            Snack snack = obtenerSnack(codigoONombre);
            snack.sacarUnidad();
            if (snack.getCantidadDisponible() == 0) {
                snacks.remove(snack.getCodigo());
            }
        } else {
            System.out.println("El snack ingresado no existe.");
        }
    }

    public List<String> obtenerSnacksAgotados() {
        List<String> agotados = new ArrayList<>();
        for (Map.Entry<String, Snack> entry : snacks.entrySet()) {
            String codigo = entry.getKey();
            Snack snack = entry.getValue();
            if (snack.getCantidadDisponible() == 0) {
                agotados.add(codigo);
            }
        }
        return agotados;
    }

    public void quitarSnackPorCodigo(String codigo) {
        if (existirSnack(codigo)) {
            snacks.remove(codigo);
        } else {
            System.out.println("El snack ingresado no existe.");
        }
    }

    public Snack obtenerSnack(String codigoONombre) {
        for (Snack snack : snacks.values()) {
            String snackCodigo = snack.getCodigo().toLowerCase();
            String snackNombre = snack.getNombre().toLowerCase();
            if (snackCodigo.equals(codigoONombre) ||
                    snackNombre.equals("snack " + codigoONombre) ||
                    snackNombre.equals(codigoONombre)) {
                return snack;
            }
        }
        return null;
    }

    public List<Snack> ordenarPrecio() {
        List<Snack> listaOrdenada = new ArrayList<>(snacks.values());
        listaOrdenada.sort(Comparator.comparing(Snack::getPrecio).reversed());
        return listaOrdenada;
    }

    public List<Snack> ordenarCantidad() {
        List<Snack> listaOrdenada = new ArrayList<>(snacks.values());
        listaOrdenada.sort(Comparator.comparing(Snack::getCantidadDisponible));
        return listaOrdenada;
    }

    public void mostrarMaquina() {
        System.out.println("+-------------------------------------------------------------------------+");
        System.out.println("|                         Maquina Expendedora🍫                           |");
        System.out.println("+-------------------------------------------------------------------------+");

        for (int i = 1; i <= 12; i++) {
            if (i % 3 == 1) {
                System.out.print("|");
            }

            String codigo = String.valueOf(i);

            if (snacks.containsKey(codigo)) {
                Snack snack = snacks.get(codigo);
                System.out.printf("   %-7s  ", snack.getNombre());
                System.out.printf("X%d  $%.2f |", snack.getCantidadDisponible(), snack.getPrecio());
            } else {
                System.out.print("           |");
            }

            if (i % 3 == 0) {
                System.out.println();
            }
        }

        System.out.println("+-------------------------------------------------------------------------+");
    }

}
