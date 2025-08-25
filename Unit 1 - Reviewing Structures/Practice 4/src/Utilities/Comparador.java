package Utilities;

import Practice4.Evento;
import java.util.Comparator;

public class Comparador {

    public static final Comparator<Evento> ORDENAR_POR_NOMBRE = new Comparator<Evento>() {
        @Override
        public int compare(Evento e1, Evento e2) {
            return e1.getNombre().compareTo(e2.getNombre());
        }
    };

    public static final Comparator<Evento> ORDENAR_POR_FECHA = new Comparator<Evento>() {
        @Override
        public int compare(Evento e1, Evento e2) {
            return e1.getFecha().compareTo(e2.getFecha());
        }
    };

}
