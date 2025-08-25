package Practice4;
// author @dannita

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Utilities.Comparador;

public class Evento {

    private String nombre;
    private LocalDate fecha;
    private String responsable;
    private static List<Evento> eventos = new ArrayList<>();

    public Evento(String nombre, LocalDate fecha, String responsable) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.responsable = responsable;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public static void ordenarEventos() {
        eventos.sort(Comparador.ORDENAR_POR_FECHA.thenComparing(Comparador.ORDENAR_POR_NOMBRE));
    }

    public static void mostrarEventos() {
        for (Evento e : eventos) {
            System.out.println(e);
        }
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nFecha: " + this.fecha + "\nResponsable: " + this.responsable;
    }

}
