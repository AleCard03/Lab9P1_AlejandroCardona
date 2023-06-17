/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p1_alejandrocardona;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author jets
 */
public class Libros {
    static ArrayList<Libros> b = new ArrayList<Libros>();
    private String titulo, autor, genero;
    private int edad;
    public Libros ( String tituloN , String autorN , String generoN , int edadN){
        this.titulo = tituloN;
        this.autor = autorN;
        this.genero = generoN;
        this.edad = edadN;
    }

    public void addLibros(Libros x){
        b.add(x);
    }
    
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String tituloN) {
        this.titulo = tituloN;
    }
    public String getAutor(){
        return this.autor;
    }
    

    public void setAutor(String autorN) {
        this.autor = autorN;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String generoN) {
        this.genero = generoN;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edadN) {
        this.edad = edadN;
    }
    
    
}
