/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab9p1_alejandrocardona;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author jets
 */
public class Lab9P1_AlejandroCardona {
static Scanner read = new Scanner(System.in);
static ArrayList<Libros> libreria = new ArrayList<>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        boolean continuar = true;
        boolean case1 = false;
        while (continuar){
            
            System.out.println("---Menu---");
            System.out.println("Ingrese una opción");
            System.out.println("1. Ejercicio Práctico 1 - Libros y más Libros REMASTERED");
            System.out.println("2. Salir");
            int opcion = read.nextInt();
            switch (opcion){
                case 1 : {
                    boolean continuar2 = true;
                    while(continuar2){
                        System.out.println("---Submenu---");
                        System.out.println("1. Agregar Libro\n2. Listar Libros\n3. Modificar Libro\n4. Eliminar Libro\n5. Buscar libro por título\n6. Buscar Libro según autor\n7.Búsqueda con filtro de género\n8. Salir");
                        int opcion2 = read.nextInt();
                        switch(opcion2){
                            case 1 : 
                                read.nextLine();
                                System.out.println("Ha elegido la opción para agregar un libro, por favor aporte la información solicitada");
                                System.out.print("Título: ");
                                String titulo = read.nextLine();
                                System.out.print("Autor: ");
                                String autor = read.nextLine();
                                System.out.print("Genero: ");
                                String genero = read.nextLine();
                                int edad;
                                do{
                                    System.out.print("Edad mínima: ");
                                    edad = read.nextInt();
                                }while(edad<0);
                                Libros lib = new Libros(titulo,autor,genero,edad);
                                libreria.add(lib);
                                case1 = true;
                            //fin case 1
                            break;
                            
                            case 2 : {
                                if(case1){
                                    System.out.print(printAll(libreria));
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 2
                            break;
                            case 3 : {
                                if(case1){
                                    System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara");
                                    System.out.print(printAll(libreria));
                                    int libInt = read.nextInt() -1; //Este Scanner lo hice así para que si ingresa el libro 1, que cambie el de índice 0, el primero en el librero
                                    while ( libInt >= libreria.size()){
                                    System.out.println("Ingresó un valor de libro no disponible");
                                    System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara");
                                    System.out.print(printAll(libreria));
                                    libInt = read.nextInt() -1;
                                    }
                                    System.out.println("Ha seleccionado el libro: "+libreria.get(libInt).getTitulo()+", ¿qué atributo desea modificar?");
                                    System.out.println("1. Titulo\n2. Autor\n3. Genero\n4. Edad Mínima");
                                    int elem = read.nextInt();
                                    read.nextLine();
                                    switch (elem){
                                        case 1 : {
                                            System.out.print("Modificara el titulo del libro, ingrese un nuevo titulo: ");
                                            libreria.get(libInt).setTitulo(read.nextLine());
                                        }//fin case 1
                                        break;
                                        case 2 : {
                                            System.out.print("Modificara el autor del libro, ingrese un nuevo autor: ");
                                            libreria.get(libInt).setAutor(read.nextLine());
                                        }//fin case 2
                                        break;
                                        case 3 : {
                                            System.out.print("Modificara el género del libro, ingrese un nuevo género: ");
                                            libreria.get(libInt).setGenero(read.nextLine());
                                        }//fin case 3
                                        break;
                                        case 4 : {
                                            System.out.print("Modificara la edad mínima del libro, ingrese una nueva edad: ");
                                            libreria.get(libInt).setEdad(read.nextInt());
                                        }//fin case 4
                                        break;
                                        default : {
                                            System.out.println("Ha ingresado una opcion no valida");
                                        }//fin default
                                        break;
                                    }
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 3
                            break;
                            case 4 : {
                                if(case1){
                                    System.out.println("Ha ingresado la opción de eliminar libros, elija el libro que eliminara");
                                    System.out.print(printAll(libreria));
                                    int libInt = read.nextInt() -1; //Este Scanner lo hice así para que si ingresa el libro 1, que cambie el de índice 0, el primero en el librero
                                    while ( libInt >= libreria.size()){
                                        System.out.println("Ingresó un valor de libro no disponible");
                                        System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara");
                                        System.out.print(printAll(libreria));
                                        libInt = read.nextInt() -1;
                                    }
                                    libreria.remove(libInt);
                                    System.out.print(printAll(libreria));
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 4
                            break;
                            case 5 : {
                                if(case1){
                                    boolean found = false;
                                    read.nextLine();
                                    String acum = "";
                                    System.out.print("Ha elegido buscar por titulo, ingrese el titulo: ");
                                    String booky = read.nextLine();
                                    for (int i = 0; i < libreria.size(); i++){
                                        if(booky.equalsIgnoreCase(libreria.get(i).getTitulo())){
                                            Libros libro = libreria.get(i);
                                            acum+="Título: "+libro.getTitulo()+"\nAutor: "+libro.getAutor()+"\nGénero: "+libro.getGenero()+"\nEdad mínima: "+libro.getEdad()+"\n\n";
                                            found = true;
                                        }
                                    }
                                    if(found){
                                        System.out.println(acum);
                                    }
                                    else{
                                        System.out.println("No se ha encontrado ningún libro por ese titulo");
                                    }
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 5
                            break;
                            case 6 : {
                                if(case1){
                                    boolean found = false;
                                    read.nextLine();
                                    String acum = "";
                                    System.out.print("Ha elegido buscar por autor, ingrese el autor: ");
                                    String booky = read.nextLine();
                                    for (int i = 0; i < libreria.size(); i++){
                                        if(booky.equalsIgnoreCase(libreria.get(i).getAutor())){
                                            Libros libro = libreria.get(i);
                                            acum+="Título: "+libro.getTitulo()+"\nAutor: "+libro.getAutor()+"\nGénero: "+libro.getGenero()+"\nEdad mínima: "+libro.getEdad()+"\n\n";
                                            found = true;
                                        }
                                    }
                                    if(found){
                                        System.out.println(acum);
                                    }
                                    else{
                                        System.out.println("No se ha encontrado ningún libro por ese autor");
                                    }
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 6
                            break;
                            case 7 : {
                                if(case1){
                                    boolean found = false;
                                    read.nextLine();
                                    String acum = "";
                                    System.out.print("Ha elegido filtrar por genero, ingrese el genero: ");
                                    String booky = read.nextLine();
                                    for (int i = 0; i < libreria.size(); i++){
                                        if(booky.equalsIgnoreCase(libreria.get(i).getGenero())){
                                            Libros libro = libreria.get(i);
                                            acum+="Título: "+libro.getTitulo()+"\nAutor: "+libro.getAutor()+"\nGénero: "+libro.getGenero()+"\nEdad mínima: "+libro.getEdad()+"\n\n";
                                            found = true;
                                        }
                                    }
                                    System.out.println("Libros con genero de: "+booky);
                                    if(found){
                                        System.out.println(acum);
                                    }
                                    else{
                                        System.out.println("No se ha encontrado ningún libro por ese genero");
                                    }
                                }
                                else{
                                    System.out.println("Debes añadir un libro primero");
                                }
                            }//fin case 7
                            break;
                            case 8 : {
                                continuar2= false;
                            }//fin case 8
                            break;
                            
                            default : {
                                System.out.println("Has ingresado una opción no válida");
                            }//fin default
                            break;
                            
                        }
                    }
                }//fin case 1
                break;
                
                case 2 : {
                    continuar = false;
                }//fin case 2
                break;
                
                default : {
                    System.out.println("Has ingresado una opción no válida");
                }//fin default
                break;
                
            }//fin switch opcion
        }//fin while continuar
    }//fin main method
    static ArrayList viewLibros (){
        return libreria;
    }
    static String printAll ( ArrayList x){
        
        String acum = "";
        viewLibros();
        for (int i = 0; i<x.size();i++){
            acum+="Libro "+(i+1)+"\n";
            Libros libro = libreria.get(i);
            acum+="Título: "+libro.getTitulo()+"\nAutor: "+libro.getAutor()+"\nGénero: "+libro.getGenero()+"\nEdad mínima: "+libro.getEdad()+"\n\n";
        }
        return acum;
    }
}//fin class
