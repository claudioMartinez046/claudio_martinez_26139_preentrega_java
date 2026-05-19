package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;
//VAMOS A VER HASTA INTERFZAS!!!!!
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
 
    }
}
