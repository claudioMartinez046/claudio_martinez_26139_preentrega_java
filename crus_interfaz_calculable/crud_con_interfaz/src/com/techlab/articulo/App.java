package com.techlab.articulo;

import java.util.ArrayList;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);

       ArrayList<Articulo> articulos = new ArrayList<>();
       ArrayList<Categoria> categorias = new ArrayList<>();
       
       //reformular este harcodeado
       precargarCategorias(categorias);

        int opcion;

        do {
            System.out.println("\n======================================================");
            System.out.println(" SISTEMA DE ARTÍCULOS - CLASE 5 (INTERFAZ CALCULABLE)");
            System.out.println("======================================================");
            System.out.println("1 - Ingresar artículo");
            System.out.println("2 - Listar artículos");
            System.out.println("3 - Consultar un artículo");
            System.out.println("4 - Modificar un artículo");
            System.out.println("5 - Eliminar un artículo");
            System.out.println("6 - Listar categorías");
            System.out.println("0 - Salir");
            System.out.println("======================================================");

            opcion = leerEntero(scanner, "Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    ingresarArticulo(scanner, articulos, categorias);
                    break;
                case 2:
                    listarArticulos(articulos);
                    break;
                case 3:
                    consultarArticulo(scanner, articulos);
                    break;
                case 4:
                    modificarArticulo(scanner, articulos, categorias);
                    break;
                case 5:
                    eliminarArticulo(scanner, articulos);
                    break;
                case 6:
                    listarCategorias(categorias);
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("\nError: la opción ingresada no es válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
       //mejorar este harcodeado
      public static void precargarCategorias(ArrayList<Categoria> categorias) {
        categorias.add(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
        categorias.add(new Categoria(2, "Periféricos", "Accesorios para computadora"));
        categorias.add(new Categoria(3, "Alimentos", "Productos alimenticios"));
        categorias.add(new Categoria(4, "Limpieza", "Artículos de limpieza del hogar"));
      }

      public static void ingresarArticulo(Scanner scanner,
        ArrayList<Articulo> articulos,
        ArrayList<Categoria> categorias) 
        {
            System.out.println("\n--- INGRESAR ARTÍCULO ---");
            System.out.println("1 - Artículo electrónico");
            System.out.println("2 - Artículo alimenticio");
            
            int tipo;
            do {
                
            } while (condition:var(boolean));
        }
        



}
