package Logica;
// author @dannita

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class Alumno {

    private int legajo;
    private String apellido;
    private String nombre;
    private Set<Materia> misMaterias;

    public Alumno(int legajo, String apellido, String nombre) {
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        misMaterias = new HashSet<>();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMateria(Materia m) {
        if (!misMaterias.contains(m)) {
            misMaterias.add(m);
            JOptionPane.showMessageDialog(null, "Alumno agregado.");
        }
    }

    public int cantidadMaterias() {
        return misMaterias.size();
    }
    
    @Override
    public String toString() {
        return "--Alumno--" + "\nNombre: " + this.nombre + "\nApellido: " + this.apellido + "\nLegajo: " + this.legajo + "\nCantidad de materias a la que está inscrito: " + this.cantidadMaterias();
    }
}
