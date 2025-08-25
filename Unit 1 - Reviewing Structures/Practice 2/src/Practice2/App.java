package Practice2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Map<String, Estudiante> mapaEstudiantes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean aux2 = false;

        do {
            System.out.println("Bienvenido al sistema de estudiantes. ¿Que desea realizar?: ");
            System.out.println("1. Cargar nuevo estudiante a la base de datos.");
            System.out.println("2. Modificar el promedio de un estudiante.");
            System.out.println("3. Eliminar a un estudiante de la base de datos.");
            System.out.println("4. Mostrar lista de estudiantes.");
            System.out.println("5. Salir.");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Error: Dato ingresado incorrecto.");
                sc.nextLine();
            }

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("Nombre del estudiante: ");
                    String nombre = sc.nextLine();
                    while (!(nombre.matches("[a-zA-Z]+"))) {
                        System.out.println("Error: No incluya numeros en el nombre.");
                        nombre = sc.nextLine();
                    }
                    System.out.println("Apellido del estudiante: ");
                    String apellido = sc.nextLine();
                    while (!(apellido.matches("[a-zA-Z]+"))) {
                        System.out.println("Error: No incluya numeros en el apellido.");
                        apellido = sc.nextLine();
                    }

                    double promedio = 0.0;
                    boolean aux = false;
                    while (!aux) {
                        try {
                            System.out.println("Promedio del estudiante: ");
                            promedio = sc.nextDouble();
                            if (promedio < 0) {
                                System.out.println("Error: El promedio no puede ser negativo.");
                                promedio = sc.nextDouble();
                            } else {
                                aux = true;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Error: Dato ingresado incorrecto.");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    System.out.println("DNI del estudiante: ");
                    String dni = sc.nextLine();
                    while (dni.matches("[a-zA-Z+]")) {
                        System.out.println("Error: No ingrese letras en el documento del estudiante.");
                        dni = sc.nextLine();
                    }
                    System.out.println("Estudiante agregado con éxito.");
                    mapaEstudiantes.put(dni, new Estudiante(nombre, apellido, promedio));
                    break;

                case 2:
                    sc.nextLine();
                    aux = false;
                    while (!aux) {
                        System.out.println("Ingrese el DNI del estudiante: ");
                        dni = sc.nextLine();
                        while (dni.matches("[a-zA-Z+]")) {
                            System.out.println("Error: No ingrese letras en el documento del estudiante.");
                            dni = sc.nextLine();
                        }

                        if (!(mapaEstudiantes.containsKey(dni))) {
                            System.out.println("El estudiante no se ha encontrado. Intentelo nuevamente.");
                        }

                        for (Map.Entry<String, Estudiante> entry : mapaEstudiantes.entrySet()) {
                            String key = entry.getKey();
                            Estudiante value = entry.getValue();
                            if (key.equals(dni)) {
                                System.out.println("Estudiante encontrado. Ingrese su nuevo promedio: ");
                                promedio = sc.nextDouble();
                                value.setPromedio(promedio);
                                mapaEstudiantes.replace(key, value);
                                System.out.println(entry.getKey());
                                System.out.println(entry.getValue());
                                aux = true;
                            }
                        }
                    }
                    break;
                case 3:
                    sc.nextLine();
                    aux = false;
                    while (!aux) {
                        System.out.println("Ingrese el DNI del estudiante: ");
                        dni = sc.nextLine();
                        while (dni.matches("[a-zA-Z+]")) {
                            System.out.println("Error: No ingrese letras en el documento del estudiante.");
                            dni = sc.nextLine();
                        }
                        try {
                            if (!(mapaEstudiantes.containsKey(dni))) {
                                System.out.print("Error. ");
                            }

                            mapaEstudiantes.remove(dni);
                            System.out.println("Estudiante encontrado y eliminado.");
                            aux = true;
                        } catch (Exception e) {
                            System.out.println("Estudiante no encontrado en base al DNI ingresado.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Lista de estudiantes: ");
                    for (Map.Entry<String, Estudiante> entrada : mapaEstudiantes.entrySet()) {
                        System.out.println(entrada.getKey());
                        System.out.println(entrada.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Nos vemos pronto.");
                    aux2 = true;
                    break;

                default:
                    System.out.println("Error: Tiene que ingresar un numero dentro del rango 1-4.");
            }
        } while (!aux2);

    }

}
