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

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author PC21
 */
public class Grupo implements Comparable,ManejoDatos {
    //caracteristicas que tendra el grupo
    private String nombre;
    private String descripcion;

    public Grupo() {
    }
    
    @Override
    public void ingresarDatos(){//pide y guarda todos los datos del grupo
        Scanner teclado=new Scanner(System.in);
        System.out.println("\n\n\t\t\t> Ingresa el nombre del grupo: ");
        nombre=teclado.nextLine();
        System.out.println("\t\t\t> Ingresa una descripcion: ");
        descripcion=teclado.nextLine();
    }
    
    @Override
    public void mostrarDatos(){//sirve para mostrar los datos que tiene el grupo
        System.out.println("\n\n\tNombre grupo: "+nombre);
        System.out.println("\tDescripcion grupo:"+descripcion+"\n");
        
        
    }
    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", descripcion=" + descripcion + "}\n";
    }

    @Override
    public int compareTo(Object t) {
        return nombre.compareTo(((Grupo)t).getNombre());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        return hash;
    }
   public boolean equals(Object t){
        if(t instanceof Grupo){
            return nombre.equals(((Grupo) t).nombre);
        }
        return false;
    }
    //set y get de los atributos
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

    @Override
    public void modificarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
