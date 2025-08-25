package Practice5;
// author @dannita

import java.time.LocalDate;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private LocalDate fechaDeIngreso;

    public Producto(String nombre, String codigo, double precio, LocalDate fechaDeIngreso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nCodigo: " + this.codigo + "\nPrecio: " + this.precio + "\nFecha de ingreso: " + this.fechaDeIngreso;
    }
}
