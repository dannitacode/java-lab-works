package Practice4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean aux2 = false;

        do {
            System.out.println("Bienvenido al sistema de gestion de eventos.");
            System.out.println("1. Ingresar evento.");
            System.out.println("2. Mostrar lista de eventos.");
            System.out.println("3. Salir.");
            try {
              opcion = sc.nextInt();  
            } catch (InputMismatchException ime) {
                System.out.println("Error: Dato ingresado incorrecto.");
                sc.nextLine();
            }
            
            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.println("Ingrese su nombre: ");
                    String nombre = sc.nextLine();
                    while (!(nombre.matches("[a-zA-Z]+"))) {
                        System.out.println("Error: No ingrese numeros en su nombre.");
                        nombre = sc.nextLine();
                    }
                    boolean aux = false;
                    LocalDate fechaFormateada = null;
                    while (!aux) {
                        try {
                            System.out.println("Ingrese la fecha del evento (respete por favor el formato dd/MM/yyyy): ");
                            String fecha = sc.nextLine();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fechaFormateada = LocalDate.parse(fecha, formato);
                            aux = true;
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Error: El formato de la fecha no es el que se esperaba.");
                        }
                    }
                    System.out.println("Nombre del responsable del evento: ");
                    String responsable = sc.nextLine();
                    while (!(responsable.matches("[a-zA-Z]+"))) {
                        System.out.println("Error: No ingrese numeros en su nombre.");
                        responsable = sc.nextLine();
                    }
                    Evento e = new Evento(nombre, fechaFormateada, responsable);
                    e.agregarEvento(e);
                    break;
                case 2:
                    try {
                        Evento.ordenarEventos();
                        Evento.mostrarEventos();
                    } catch (NullPointerException npe) {
                        System.out.println("Error: La lista se encuentra vacía aún.");
                        sc.nextLine();
                    }
                    break;
                    
                case 3:
                    System.out.println("Nos vemos pronto.");
                    aux2 = true;
                    break;
                    
                default: System.out.println("Debe de ingresar un numero de entre 1 y 3.");
            }
        } while (!aux2);
    }
}
