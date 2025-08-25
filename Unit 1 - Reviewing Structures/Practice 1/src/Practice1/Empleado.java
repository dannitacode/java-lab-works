package Practice1;
// author @dannita

public class Empleado {
    
    private String nombre;
    private int legajo;
    private double sueldo;
    
    public Empleado(String nombre, int legajo, double sueldo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.sueldo = sueldo;
    }
    
    public int getLegajo() {
        return legajo;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nLegajo: " + this.legajo + "\nSueldo: " + this.sueldo;
    }
}
