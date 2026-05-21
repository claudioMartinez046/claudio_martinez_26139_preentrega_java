package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;
//VAMOS A VER HASTA INTERFaS!!!!!
public class App {
        // METODO leerEntero
    public static int leerEntero(Scanner scanner, String mensaje){
        while (true) { 
            //mientras sea true sigue pidiendo numero
            //try intenta ejecutar el codigo
            try {
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
                //catch captura si hubiera una expecion (error)
            } catch (NumberFormatException e) {
            }
        }

            //metodo ingresarArticulo
    }    
    public static void ingresarArticulo(Scanner scanner, ArrayList<String> ListaArticulos){
        System.out.println("Ingrese el artículo:");
        //ingresar descripcion o n ombre del articulo
        String descripcion = leerTextoNoVacio(scanner, "Ingrese la descripción del artículo: ");
        
        //antes de agregar el articulo se valida si existe el art ingresado
        if(existeArticulo(ListaArticulos, descripcion)){
            System.out.println("Error: el artículo ya existe en la lista.");
            return;
        }

        //si no existe se agrega a la lista
        ListaArticulos.add(descripcion);
        System.out.println("Artículo ingresado correctamente.");
    }  
    
        //metodo leerTextoNoVacio
     public static String leerTextoNoVacio(Scanner scanner, String mensaje){
            while (true) {
                 System.out.println(mensaje);
            String texto = scanner.nextLine();
             // texto.trim() elimina los espacios en blanco al principio y al final del texto
            // isEmpty() verifica si el texto está vacío después de eliminar los espacios
            // !true -> false
            // !texto.trim().isEmpty() -> true si el texto no está vacío
            if (!texto.trim().isEmpty()) {
                // voy a retornar a donde fue llamada esta funcion, el texto sin espacios al principio ni al final
                return texto.trim();
            }
            // si el texto está vacío, se muestra un mensaje de error y se vuelve a pedir el texto
            System.out.println("Error: el texto no puede estar vacío. Por favor, ingrese un texto válido.");
            }
        }
        /*
     * MÉTODO: existeArticulo
     * ------------------------------------------------------
     * Este método responde true o false según el artículo exista o no.
     *
     * Recorre toda la lista comparando sin importar mayúsculas/minúsculas.
     *
     * Ejemplo:
     * "Mouse" y "mouse" se consideran el mismo artículo.
     */
    public static boolean existeArticulo(ArrayList<String> articulos, String descripcion) {
        // buscar una alternativa a este method con algun method de ArrayList, como contains, pero no es case insensitive, entonces lo hacemos a mano
        for (String articulo : articulos) {
            if (articulo.equalsIgnoreCase(descripcion.trim())) {
                return true;
            }
        }

        return false;
    }

          
        


    public static void main(String[] args) {
       //creacion de un scanner para el ingreso de datos
       Scanner scanner = new Scanner(System.in);


       //creacion de un ArrayList de String
        ArrayList<String> articulos = new ArrayList<>();

       //variable que guarda la opcion que elige el usuario
        int opcion;
     
       //creacion del menu y uso de do while para mostrar y recorrerlo
       //solo saldra del bucle cuando el usuario ingrese 0
       do {
            // Mostramos el menú principal.
            System.out.println("\n==========================================");
            System.out.println("   SISTEMA BÁSICO DE ARTÍCULOS - CLASE 1");
            System.out.println("==========================================");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar un artículo");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Eliminar un artículo");
            System.out.println("0 - Salir");
            System.out.println("==========================================");
        
            //lee la opcion ingresada por el usuario
            opcion = leerEntero(scanner, "Ingrese una opción: ");
            // cuando la variable opcion tiene el numero sigue con un switch
            switch (opcion) {
                case 1:
                    ingresarArticulo(scanner, articulos);
                    break;
                 case 2:
                     consultarArticulo(articulos);
                    break;
                 case 3:
                    consultarArticulo(scanner,articulos);
                    break;
                 case 4:
                    modificarArticulo(scanner, articulos);
                    break;
                 case 5:
                    eliminarArticulo(scanner, articulos);
                    break;
                 case 0:
                    System.out.println("saliendo del programa...");
                    break;            
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
                    break;
            }
        } while (opcion != 0);
 

        //linea que cierra el scanner al final del programa
        scanner.close();

    }
}
