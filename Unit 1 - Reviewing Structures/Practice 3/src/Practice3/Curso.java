package Practice3;
// author @dannita

import java.time.LocalDate;

public class Curso {

    private String codigo;
    private String nombre;
    private LocalDate inicioCurso;
    private LocalDate finCurso;

    public Curso(String codigo, String nombre, LocalDate inicioCurso, LocalDate finCurso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.inicioCurso = inicioCurso;
        this.finCurso = finCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toString() {
        return "Codigo: " + this.codigo + "\nNombre: " + this.nombre + "\nInicio del curso: " + this.inicioCurso + "\nFin del curso: " + this.finCurso;
    }
}
