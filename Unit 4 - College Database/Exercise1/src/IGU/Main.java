package IGU;

import Logica.Alumno;
import Persistencia.AlumnoData;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dannita
 */
public class Main {

    public static int prueba(Scanner sc) {
        System.out.println("Bienvenido. Escoja una opcion.");
        System.out.println("1. Insertar alumno.");
        System.out.println("2. Mostrar alumnos.");
        System.out.println("3. Actualizar alumno por apellido.");
        System.out.println("4. Buscar alumno por DNI.");
        System.out.println("5. Baja de alumno.");
        System.out.println("6. Alta de alumno.");
        System.out.println("7. Borrar alumno de la base de datos.");
        System.out.println("8. Salir.");
        int opcion = sc.nextInt();
        return opcion;
    }

    public static void main(String[] args) {
//        AlumnoData alumnoData = new AlumnoData();
//        Scanner sc = new Scanner(System.in);
//        boolean aux = false;
//        do {
//            int opcion = Main.prueba(sc);
//            switch (opcion) {
//                case 1:
//                    System.out.println("Ingrese el DNI del alumno: ");
//                    int dni = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Ingrese el nombre del alumno: ");
//                    String nombre = sc.nextLine();
//                    System.out.println("Ingrese el apellido del alumno: ");
//                    String apellido = sc.nextLine();
//                    System.out.println("Ingrese la fecha de nacimiento del alumno (yyyy-mm-dd): ");
//                    String fechaNacimiento = sc.nextLine();
//                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                    LocalDate fechaFormateada = LocalDate.parse(fechaNacimiento, formato);
//                    System.out.println("Ingrese el estado del alumno: ");
//                    boolean estado = sc.nextBoolean();
//                    alumnoData.ingresarAlumno(new Alumno(dni, nombre, apellido, fechaFormateada, estado));
//                    sc.nextLine();
//                    break;
//                case 2:
//                    alumnoData.mostrarAlumnos();
//                    break;
//                case 3:
//                    System.out.println("Ingrese el DNI del alumno: ");
//                    dni = sc.nextInt();
//                    sc.nextLine();
//                    System.out.println("Ingrese el nuevo apellido del alumno:");
//                    apellido = sc.nextLine();
//                    alumnoData.actualizarAlumno(dni, apellido);
//                    break;
//                case 4:
//                    System.out.println("Ingrese el DNI del alumno: ");
//                    dni = sc.nextInt();
//                    sc.nextLine();
//                    alumnoData.buscarAlumno(dni);
//                    break;
//                case 5:
//                    System.out.println("Ingrese el DNI del alumno: ");
//                    dni = sc.nextInt();
//                    sc.nextLine();
//                    alumnoData.bajaLogica(dni);
//                    break;
//                case 6:
//                    System.out.println("Ingrese el DNI del alumno: ");
//                    dni = sc.nextInt();
//                    sc.nextLine();
//                    alumnoData.altaLogica(dni);
//                    break;
//                case 7:
//                    System.out.println("Ingrese el ID del alumno: ");
//                    int id = sc.nextInt();
//                    sc.nextLine();
//                    alumnoData.borrarAlumno(id);
//                    break;
//                case 8:
//                    System.out.println("Hasta pronto.");
//                    aux = true;
//                    break;
//                default:
//                    System.out.println("Opción incorrecta.");
//            }
//        } while (aux != true);
    }

}
