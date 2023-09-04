package dominio;

public class Snack {
    protected String codigo;
    protected String nombre;
    protected int cantidadDisponible;

    public Snack(String codigo, String nombre, int cantidadInicial) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadInicial;
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

}
