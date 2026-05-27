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
            //ingresa seleccion de articulo
            do {
                tipo = leerEntero(scanner, "Seleccione el tipo de artículo: ");
                if (tipo != 1 && tipo != 2) {
                    System.out.println("error!! debe elegir entre 1 y 2");
                }
            } while (tipo != 1 && tipo != 2);

            //buscardor de articulo con verificacion
            int codigo = leerEntero(scanner, "Ingrese el código del artículo: ");
            if (buscarArticuloPorCodigo(scanner, codigo)) {
                System.out.println("\nError: ya existe un artículo con ese código.");
                return;
            }
            // ingreso de nombre y precio con su respectiva verificacion
            String nombre = leerTextoNoVacio(scanner, "Ingrese el nombre del articulo: ");
            double precio = leerDoubleNoNegativo(scanner, "Ingrese el precio del artículo: ");

            listarCategorias(categorias);
            Categoria categoria = pedirCategoriaExistente(scanner, categorias);
            
            //declaro objeto articulo //aca se aplicael poli,orfimos
            Articulo articulo;

            //en este if se asigna garantia o vencimiento
            //depende del tipo de articulo que se selecciono
           if (tipo == 1) {
            int garantiaMeses = leerEnteroNoNegativo(scanner, "Ingrese la garantía en meses: ");
            //aca se instancia articulo electronico(hijo) apartir de la clase padre herencia
            articulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
             } 
            else {
            int diasParaVencimiento = leerEnteroNoNegativo(scanner, "Ingrese los días para vencimiento: ");
            articulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasParaVencimiento);
        }

            //los articulos ingresados se cargan en el array
            articulos.add(articulo);

            System.out.println("Artículo ingresado correctamente.");
            System.out.println("Resumen del objeto creado:");
            System.out.println(articulo);
            System.out.println("Precio final calculado: " + articulo.calcularPrecioFinal());
        }
        
         //metodos
        public static void listarArticulos(arrayList<Articulo> articulos){
            println("\n--- LISTA DE ARTÍCULOS ---");
            //verifico si hay articulos cargados
            if (articulos.isEmpty()) {
                println("No hay artículos registrados.");
                return;
            }
            //recorro el array de articulos y los imprimo
            for (Articulo articulo : articulos) {
                System.out.println(articulo);
                //detalle especifico es un metodo abstracto de Articulo que oblica a sus hijas implementar
                System.out.println("Detalle especifico: " + articulo.getDetalleEspecifico());
                //calcular precio final es un metodo de la interfaz calculable que implementan las clases que la invocan
                System.out.println("Precio final calculado: " + articulo.calcularPrecioFinal());
                System.out.println("-----------------------------------");
            }
        }

        public static void consultarArticulo(Scanner scanner, ArrayList<Articulo> articulos){
            System.out.println("\n--- CONSULTAR ARTÍCULO ---");
           
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
                return;
            }
            int codigo = leerEntero(scanner, "Ingrese el código del artículo a consultar: ");
        
            Articulo articulo = buscarArticuloPorCodigo(scanner, codigo);

            if (articulo == null){
                System.out.println("el articulo no existe");
                return;
            }
        
            System.out.println("Artículo encontrado:");
            System.out.println(articulo);
            System.out.println("Detalle específico: " + articulo.getDetalleEspecifico());
            System.out.println("Precio final calculado: " + articulo.calcularPrecioFinal());

        }

        public static void modificarArticulo(
            Scanner scanner,
            ArrayList<Articulo> articulos,
            ArrayList<Categoria> categorias
        ){
            System.out.println("\n--- MODIFICAR ARTÍCULO ---");

            //validacion 
            if (articulos.isEmpty()) {
                System.out.println("No hay artículos cargados.");
                return;
            }
            int codigo = leerEntero(scanner, "Ingrese el código del artículo a modificar: ");
            
            Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

            if (artculo == null){
                System.out.println("el articulo no existe");
                return; 
            }
        }
         
       


}
