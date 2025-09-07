package Logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class DirectorioTelefonico {
    
    private Map<Long, Contacto> mapaDirectorio;

    public DirectorioTelefonico() {
        this.mapaDirectorio = new TreeMap<>();
    }

    public Map<Long, Contacto> getMapaDirectorio() {
        return mapaDirectorio;
    }

    public void setMapaDirectorio(Map<Long, Contacto> mapaDirectorio) {
        this.mapaDirectorio = mapaDirectorio;
    }

    public void agregarContacto(Long numero, Contacto contacto) {
        if (!mapaDirectorio.containsKey(numero)) {
            mapaDirectorio.put(numero, contacto);
        }
    }
    
    public Contacto buscarContacto(Long numero) {
        return mapaDirectorio.get(numero);
    }
    
    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> nros = new TreeSet<>();
        for (Long numeros : mapaDirectorio.keySet()) {
            Contacto contactoAux = mapaDirectorio.get(numeros);
            if (contactoAux.getApellido().equalsIgnoreCase(apellido)) {
                nros.add(numeros);
            }
        }
        return nros;
    }
    
    public ArrayList<Contacto> buscarContactos(String ciudad) {
        ArrayList<Contacto> contactoCiudad = new ArrayList<>();
        for (Long numeros : mapaDirectorio.keySet()) {
            Contacto contactoAux = mapaDirectorio.get(numeros);
            if (contactoAux.getCiudad().equalsIgnoreCase(ciudad)) {
                contactoCiudad.add(contactoAux);
            }
        }
        return contactoCiudad;
    }
    
    public void borrarContacto(Long numero) {
        Iterator<Map.Entry<Long, Contacto>> it = mapaDirectorio.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Long, Contacto> entry = it.next();
            if (entry.getKey().equals(numero)) {
                it.remove();
                break;
            }
        }
    }
    
}
