package Practice5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static final Comparator<Producto> ORDENAR_POR_PRECIO = new Comparator<Producto>() {
        @Override
        public int compare(Producto t1, Producto t2) {
            return Double.compare(t2.getPrecio(), t1.getPrecio());
        }
    };

    public static final Comparator<Producto> ORDENAR_POR_FECHA = new Comparator<Producto>() {
        @Override
        public int compare(Producto t1, Producto t2) {
            return t1.getFechaDeIngreso().compareTo(t2.getFechaDeIngreso());
        }
    };

    public static void main(String[] args) {
        System.out.println("hola mati estuvo aca");
        List<Producto> productosLista = new ArrayList<>();
        Map<String, Integer> productosMapa = new HashMap();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean aux = false;
        boolean aux2 = false;

        do {
            System.out.println("Gestión de inventario de productos. Ingrese la accion que desee realizar: ");
            System.out.println("1. Agregar productos.");
            System.out.println("2. Actualizar el stock de un producto.");
            System.out.println("3. Eliminar un producto del inventario.");
            System.out.println("4. Mostrar lista de los productos.");
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
                    System.out.println("Nombre del producto: ");
                    String nombre = sc.nextLine();
                    System.out.println("Codigo: ");
                    String codigo = sc.nextLine();
                    System.out.println("Stock: ");
                    Integer stock = sc.nextInt();
                    while (!aux2) {
                        try {
                            if (stock < 0) {
                                System.out.println("Error: El stock no puede ser negativo.");
                                stock = sc.nextInt();
                            } else {
                                aux2 = true;
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Error: El dato ingresado es incorrecto.");
                            sc.nextLine();
                        }
                    }
                    aux2 = false;
                    System.out.println("Precio: ");
                    double precio = sc.nextDouble();
                    while (!aux2)
                        try {
                        if (precio < 0) {
                            System.out.println("Error: El precio no puede ser negativo.");
                            precio = sc.nextInt();
                        } else {
                            aux2 = true;
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("Error: El dato ingresado es incorrecto.");
                        sc.nextLine();
                    }
                    aux2 = false;
                    sc.nextLine();
                    while (!aux2) {
                        try {
                            System.out.println("Fecha de ingreso (respete el formato dd/MM/yyyy): ");
                            String fecha = sc.nextLine();
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate fechaFormateada = LocalDate.parse(fecha, formato);
                            productosLista.add(new Producto(nombre, codigo, precio, fechaFormateada));
                            productosMapa.put(codigo, stock);
                            System.out.println("Producto agregado con exito.");
                            aux2 = true;
                        } catch (DateTimeParseException dtpe) {
                            System.out.println("Error: El formato de fecha no cumple con el solicitado.");
                        }
                    }
                    break;
                case 2:
                    sc.nextLine();
                    aux2 = false;
                    while (!aux2) {
                        System.out.println("Ingrese el codigo del producto: ");
                        codigo = sc.nextLine();
                        try {
                            if (productosMapa.containsKey(codigo)) {
                                Integer stockAct = productosMapa.get(codigo);
                                System.out.println("Producto encontrado, actual stock: " + stockAct);
                                System.out.println("Introduzca el nuevo stock: ");
                                stock = sc.nextInt();
                                while (stock < 0) {
                                    System.out.println("Error: El stock no debe de ser negativo. Vuelva a ingresarlo.");
                                    stock = sc.nextInt();
                                }
                                productosMapa.put(codigo, stock);
                                System.out.println("Stock modificado con exito.");
                                System.out.println("Codigo del producto: " + codigo);
                                System.out.println("Nuevo stock: " + stock);
                                aux2 = true;
                            } else {
                                System.out.println("Producto no encontrado, vuelva a intentarlo.");
                            }
                        } catch (InputMismatchException ime) {
                            System.out.println("Error: Dato ingresado incorrecto.");
                            sc.nextLine();
                        }
                    }
                    break;
                case 3:
                    sc.nextLine();
                    Producto aux3 = null;
                    aux2 = false;
                    while (!aux2) {
                        System.out.println("Ingrese el codigo del producto: ");
                        codigo = sc.nextLine();
                        for (Producto p : productosLista) {
                            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                                aux3 = p;
                                break;
                            }
                        }

                        if (productosLista.isEmpty() && productosMapa.isEmpty()) {
                            System.out.println("Error: La lista de productos se encuentra vacía.");
                            break;
                        }

                        if (aux3 == null && (!(productosMapa.containsKey(codigo)))) {
                            System.out.println("Error. El producto no se ha encontrado.");
                        } else {
                            productosLista.remove(aux3);
                            productosMapa.remove(codigo);
                            System.out.println("Producto eliminado.");
                            aux2 = true;
                        }

                    }
                    break;

                case 4:
                    Collections.sort(productosLista, ORDENAR_POR_PRECIO);
                    System.out.println("Lista ordenada por precio: ");
                    for (Producto p : productosLista) {
                        System.out.println(p);
                    }
                    Collections.sort(productosLista, ORDENAR_POR_FECHA);
                    System.out.println("Lista ordenada por fecha de ingreso: ");
                    for (Producto p : productosLista) {
                        System.out.println(p);
                    }
                    System.out.println("Id de productos y stock correspondiente: ");
                    System.out.println(productosMapa.entrySet());
                    break;
                case 5:
                    System.out.println("Nos vemos pronto!");
                    aux = true;
                    break;

                default:
                    System.out.println("Debe de ingresar un numero de entre 1 y 3.");
            }
        } while (!aux);
    }
}
