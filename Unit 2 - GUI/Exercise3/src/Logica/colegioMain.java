package Logica;
// @author dannita


public class colegioMain {

    public static void main(String[] args) {
        
        Materia materia0 = new Materia (6, "Web II", 2);
        Materia materia1 = new Materia (8, "Matematicas", 1);
        Materia materia2 = new Materia (4, "Laboratorio de Programacion", 1);
        Alumno alumno0 = new Alumno (1001, "Lopez", "Martin");
        Alumno alumno1 = new Alumno (1002, "Martinez", "Brenda");
        
        // Inscribiendo a Lopez.
        alumno0.agregarMateria(materia0);
        alumno0.agregarMateria(materia1);
        alumno0.agregarMateria(materia2);
        // Incribiendo a Martinez.
        alumno1.agregarMateria(materia0);
        alumno1.agregarMateria(materia1);
        alumno1.agregarMateria(materia2);
        alumno1.agregarMateria(materia2);
        
        System.out.println(alumno0.toString());
        System.out.println(alumno1.toString());
        
        
        
        
        
        
    }

}
