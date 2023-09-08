package app;

import java.util.Scanner;
import dominio.MaquinaDispensadora;
import dominio.Snack;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaquinaDispensadora maquina = new MaquinaDispensadora();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------- Maquina Expendedora --------");
            System.out.println("|    1. Agregar unidad a snack     |");
            System.out.println("|    2. Sacar unidad de snack      |");
            System.out.println("|    3. Mostrar maquina            |");
            System.out.println("|    4. Mostrar snacks agotados    |");
            System.out.println("|    5. Quitar un snack            |");
            System.out.println("|    6. Rellenar un snack          |");
            System.out.println("|    7. Ordenar Precio Descendente |");
            System.out.println("|    8. Ordenar Cantidad Ascendente|");
            System.out.println("|    9. Salir                      |");
            System.out.println("------------------------------------");
            System.out.print("Seleccione una opcion con el numero indicado: ");
            int opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Ingrese el codigo o nombre del snack para agregar unidad: ");
                    String codigoONombreAgregar = scanner.next();
                    if (maquina.existirSnack(codigoONombreAgregar)) {
                        maquina.agregarUnidad(codigoONombreAgregar);
                    } else {
                        System.out.println("El snack no existe en la maquina.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el codigo o nombre del snack para sacar unidad: ");
                    String codigoONombreSacar = scanner.next();
                    if (maquina.existirSnack(codigoONombreSacar)) {
                        maquina.sacarUnidad(codigoONombreSacar);
                    } else {
                        System.out.println("El snack no existe en la maquina.");
                    }
                    break;

                case 3:
                    maquina.mostrarMaquina();
                    break;

                case 4:
                    List<String> agotados = maquina.obtenerSnacksAgotados();
                    if (!agotados.isEmpty()) {
                        System.out.println("Snacks agotados:");
                        for (String codigo : agotados) {
                            System.out.println("Codigo: " + codigo);
                        }
                    } else {
                        System.out.println("No hay snacks agotados.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el codigo del snack para quitarlo por completo: ");
                    String codigoQuitar = scanner.next();
                    maquina.quitarSnackPorCodigo(codigoQuitar);
                    break;

                case 6:
                    System.out.print("Ingrese el codigo del snack para rellenar: ");
                    String codigoRellenar = scanner.next();

                    if (maquina.existirSnack(codigoRellenar)) {
                        Snack snack = maquina.obtenerSnack(codigoRellenar);
                        int cantidadFaltante = 6 - snack.getCantidadDisponible();
                        if (cantidadFaltante > 0) {
                            snack.agregarUnidades(cantidadFaltante);
                            System.out.println("Se han agregado " + cantidadFaltante + " unidades al snack " + snack.getNombre() + ".");
                        } else {
                            System.out.println("El snack " + snack.getNombre() + " no necesita ser rellenado.");
                        }
                    } else {
                        System.out.println("El snack con codigo " + codigoRellenar + " no existe.");
                    }
                    break;
                case 7:
                    System.out.println("Listado de precios en orden descendente: ");
                    List<Snack> ordenadosPrecio = maquina.ordenarPrecio();
                    for (Snack snack : ordenadosPrecio) {
                        String precioFormateado = String.format("%.2f", snack.getPrecio());
                        System.out.println("Nombre: " + snack.getNombre() + ", Precio: " + precioFormateado);
                    }
                    break;
                case 8:
                    System.out.println("Listado de cantidad en orden ascendente: ");
                    List<Snack> ordenadosCantidad = maquina.ordenarCantidad();
                    for (Snack snack : ordenadosCantidad) {
                        System.out.println("Nombre: " + snack.getNombre() + ", Cantidad: " + snack.getCantidadDisponible());
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}
