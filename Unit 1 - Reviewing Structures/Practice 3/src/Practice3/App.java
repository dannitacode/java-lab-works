package Practice3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Set<Curso> conjuntoCursos = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        boolean aux = false;
        int opcion = 0;

        do {
            System.out.println("Bievenido al programa de cursos. Escoja la opcion que desea realizar: ");
            System.out.println("1. Agregar un curso.");
            System.out.println("2. Eliminar curso.");
            System.out.println("3. Lista de los cursos disponibles.");
            System.out.println("4. Salir.");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Error: Dato ingresado incorrecto.");
                sc.nextLine();
            }

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nombre del curso: ");
                    String nombre = sc.nextLine();
                    while (!(nombre.matches("[a-zA-Z]+"))) {
                        System.out.println("Error: No ingrese numeros en el nombre.");
                        nombre = sc.nextLine();
                    }
                    System.out.println("Codigo del curso: ");
                    String codigo = sc.nextLine();

                    boolean aux2 = false;
                    LocalDate fechaInicioFormateada = null;
                    while (!aux2) {
                        try {
                            System.out.println("Fecha de inicio del curso (respete el formato dd/MM/yyyy): ");
                            String fechaInicio = sc.nextLine();
                            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fechaInicioFormateada = LocalDate.parse(fechaInicio, formatoFecha);
                            aux2 = true;
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Error: Formato de fecha no respetado.");
                        }
                    }
                    aux2 = false;
                    LocalDate fechaFinFormateada = null;
                    while (!aux2) {
                        try {
                            System.out.println("Fecha de fin de curso (respete el formato dd/MM/yyyy): ");
                            String fechaFin = sc.nextLine();
                            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fechaFinFormateada = LocalDate.parse(fechaFin, formatoFecha);
                            aux2 = true;
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Error: Formato de fecha no respetado.");
                        }
                    }
                    conjuntoCursos.add(new Curso(codigo, nombre, fechaInicioFormateada, fechaFinFormateada));
                    break;

                case 2:
                    aux2 = false;
                    Curso aux3 = null;
                    while (!aux2) {
                        try {
                            System.out.println("Ingrese el código del curso para eliminarlo: ");
                            codigo = sc.nextLine();
                            for (Curso cursito : conjuntoCursos) {
                                if (cursito.getCodigo().equalsIgnoreCase(codigo)) {
                                    aux3 = cursito;
                                    break;
                                }
                            }
                            if (aux3 != null) {
                                conjuntoCursos.remove(aux3);
                                System.out.println("Curso eliminado.");
                                aux2 = true;
                            } else {
                                System.out.println("No se ha encontrado el curso.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;

                case 3:
                    if (conjuntoCursos.isEmpty()) {
                        System.out.println("La lista de cursos está vacía.");

                    } else {
                        System.out.println("Lista de los cursos: ");
                        for (Curso cursito : conjuntoCursos) {
                            System.out.println(cursito);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nos vemos pronto.");
                    aux = true;
                    break;
                default:
                    System.out.println("Error: Tiene que ingresar un numero dentro del rango 1-4.");
            }
        } while (!aux);

    }

}
