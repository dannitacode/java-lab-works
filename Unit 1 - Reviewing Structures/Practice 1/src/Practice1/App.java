package Practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    public static final Comparator<Empleado> ORDEN_POR_NOMBRE = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado o1, Empleado o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }
    };

    public static final Comparator<Empleado> ORDEN_POR_SUELDO = new Comparator<Empleado>() {
        @Override
        public int compare(Empleado o1, Empleado o2) {
            return Double.compare(o2.getSueldo(), o1.getSueldo());
        }
    };

    public static void main(String[] args) {
        List<Empleado> listaDeEmpleados = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opcion;
        String nombre = null;
        int legajo = 0;
        double sueldo = 0.0;

        do {
            System.out.println("Ingrese los datos del empleado.");
            System.out.println("Nombre: ");
            nombre = sc.nextLine();
            while (!(nombre.matches("[a-zA-Z]+"))) {
                System.out.println("Error: No ingrese numeros. Intente nuevamente.");
                nombre = sc.nextLine();
            }

            boolean aux2 = false;
            while (!aux2) {
                try {
                    System.out.println("Legajo: ");
                    legajo = sc.nextInt();
                    if (legajo < 0) {
                        System.out.println("Error: El legajo no puede ser negativo. Intente nuevamente.");
                    } else {
                        aux2 = true;
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Error: Dato ingresado incorrecto.");
                    sc.nextLine();
                }
            }

            aux2 = false;
            while (!aux2) {
                try {
                    System.out.println("Sueldo: ");
                    sueldo = sc.nextDouble();
                    if (sueldo < 0) {
                        System.out.println("Error: El sueldo no puede ser negativo. Intente nuevamente.");
                    } else {
                        aux2 = true;
                    }
                } catch (InputMismatchException ime) {
                    System.out.println("Error: Dato ingresado incorrecto.");
                    sc.nextLine();
                }
            }

            Empleado empleado = new Empleado(nombre, legajo, sueldo);
            listaDeEmpleados.add(empleado);
            sc.nextLine();

            do {
                System.out.println("¿Desea cargar otro empleado? (S/N)");
                opcion = sc.nextLine();
                if (opcion.startsWith("S") || opcion.startsWith("s")) {
                    continue;
                } else if (opcion.startsWith("N") || opcion.startsWith("n")) {
                    break;
                } else {
                    System.out.println("Opción incorrecta, intente nuevamente.");
                    continue;
                }
            } while (!opcion.startsWith("S") && !opcion.startsWith("s") && !opcion.startsWith("N") && !opcion.startsWith("n"));

        } while (!opcion.startsWith("N") && !opcion.startsWith("n"));

        for (Empleado e : listaDeEmpleados) {
            System.out.println(e);
        }

        Empleado aux = null;
        boolean aux2 = false;
        while (!aux2) {
            try {
                System.out.println("Ingrese el legajo de un empleado.");
                legajo = sc.nextInt();
                if (legajo < 0) {
                    System.out.println("Error: El legajo no puede ser negativo. Intente nuevamente.");
                } else {
                    aux2 = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error: Dato ingresado incorrecto.");
                sc.nextLine();
            }
        }

        Iterator<Empleado> it = listaDeEmpleados.iterator();
        while (it.hasNext()) {
            aux = it.next();
            if (aux.getLegajo() == legajo) {
                it.remove();
                System.out.println("Empleado eliminado.");
            }
        }

        if (aux.getLegajo() != legajo) {
            System.out.println("Ese legajo no existe en la base de datos de empleados.");
        }

        System.out.println("Empleados restantes: ");
        for (Empleado listaDeEmpleado : listaDeEmpleados) {
            System.out.println(listaDeEmpleado);
        }

        System.out.println("Empleados ordenados alfabéticamente: ");
        Collections.sort(listaDeEmpleados, ORDEN_POR_NOMBRE);
        for (Empleado e : listaDeEmpleados) {
            System.out.println(e);
        }
        System.out.println("Empleados ordenados por sueldo: ");
        Collections.sort(listaDeEmpleados, ORDEN_POR_SUELDO);
        for (Empleado e : listaDeEmpleados) {
            System.out.println(e);
        }

    }
}
