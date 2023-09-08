package dominio;

public class Snack {
    protected String codigo;
    protected String nombre;
    protected int cantidadDisponible;
    protected double precio;

    public Snack(String codigo, String nombre, int cantidadInicial, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadInicial;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void agregarUnidad() {
        if (cantidadDisponible < 6) {
            cantidadDisponible++;
        }
    }

    public void sacarUnidad() {
        if (cantidadDisponible > 0) {
            cantidadDisponible--;
        }
    }

    public void agregarUnidades(int cantidad) {
        if (cantidad > 0) {
            cantidadDisponible += cantidad;
        }
    }

    public double getPrecio() {
        return precio;
    }
}
