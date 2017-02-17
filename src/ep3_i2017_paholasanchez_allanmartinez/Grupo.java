/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Guarda los datos generales del grupo
 */
package ep3_i2017_paholasanchez_allanmartinez;

import java.util.Scanner;

/**
 *
 * @author PC21
 */
public class Grupo implements Comparable,ManejoDatos {
    private String nombre;
    private String descripcion;

    public Grupo() {
    }
    @Override
    public void ingresarDatos(){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Ingresa el nombre del grupo");
        nombre=teclado.nextLine();
        System.out.println("Ingresa una descripcion");
        descripcion=teclado.nextLine();
    }
    @Override
    public void mostrarDatos(){
        System.out.println("\tNombre grupo: "+nombre);
        System.out.println("\tDescripcion grupo:"+descripcion+"\n");
        
        
    }
    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    @Override
    public int compareTo(Object t) {
        return nombre.compareTo(((Grupo)t).getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
