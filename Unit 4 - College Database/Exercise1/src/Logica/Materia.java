package Logica;

/**
 *
 * @author dannita
 */
public class Materia {
    
    private int id;
    private String nombre;
    private int año;
    private boolean estado;

    public Materia(String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
        this.estado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
