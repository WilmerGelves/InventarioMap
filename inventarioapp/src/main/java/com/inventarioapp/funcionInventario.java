package com.inventarioapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class funcionInventario {

    public static void inventario(){
        Scanner sc = new Scanner(System.in);
        Map<String,List<String>> inventario = new HashMap<>();//Creación del Map<String,list<String>>
        
        //Variables globales
        int cantCategorias,insertOpc;
        String categoria,producto;
        boolean  bandera = true;

        System.out.print("\nCantidad de categorias -> ");
        cantCategorias= sc.nextInt();
        
        for(int i = 0 ; i < cantCategorias; i++){ //Iterador de entrada de categorías
            sc.nextLine(); //formatero del buffer
            System.out.print("\nCategoría N°" + (i+1) + ": ");
            categoria = sc.nextLine().toLowerCase().trim(); //Ingreso de cada  categoría del map (key)
            
            System.out.print("\nDesea ingresar productos a la categoria:\n1.Si\n2.No \n ->");
            insertOpc = sc.nextInt();

            while (insertOpc < 1 || insertOpc >2) {
                System.out.println("Por favor ingrese una opción válida.\n1.Si\\n2.No");
                insertOpc = sc.nextInt();
            }
            List<String> productos = new ArrayList<>(); //Creación de la lista. En cada iteración 
                                                        //la lista será una nueva instancia.(List)
            if (insertOpc == 1) {
                while (bandera == true) { //Iterando la lista de productos con un while, mediante uan bandera.

                    sc.nextLine();//formatero del buffer
                    System.out.print("Ingrese el producto: ");
                    producto = sc.nextLine().toLowerCase().trim(); //Ingreso de cada producto de la lista.
                    productos.add(producto);
                    
                    System.out.print("Desea ingresar productos a la categoria:\n1.Si\n2.No\n-> ");
                    insertOpc = sc.nextInt();
                    while (insertOpc < 1 || insertOpc >2) {
                        System.out.println("Por favor ingrese una opción válida.\n1.Si\\n2.No\n-> ");
                        insertOpc = sc.nextInt();
                    }
                    if (insertOpc == 2) {
                        bandera = false;
                    }
                }
            }
            inventario.put(categoria,productos);
            bandera = true;
        }
        //Iterando key-value del map
        System.out.println("Contenido del mapa:");
        for (Map.Entry<String,List<String>> categoriaProducto : inventario.entrySet()) {
            System.out.println(categoriaProducto.getKey() + " -> " + categoriaProducto.getValue());
        }

        sc.nextLine();//formateo del buffer
        //Ingresando un producto a una categoría existente. 
        System.out.println("Categoría a modificar: ");
        categoria = sc.nextLine();

        // Verificando la existencia de la categoría
        
        sc.close();
    }
}
