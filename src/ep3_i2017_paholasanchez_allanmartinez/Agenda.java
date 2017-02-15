/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Funcion para guardar los datos de la agenda asi mismo, 
    las estructuras dinamicas. 
 */
package ep3_i2017_paholasanchez_allanmartinez;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author PC21
 */
public class Agenda {
    private String nombre;  
    private String descripcion;
    private HashMap<Grupo, LinkedList<Contacto>>agenda;

    public Agenda(String nombre, String descripcion, HashMap<Grupo, LinkedList<Contacto>> agenda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.agenda = agenda;
    }

    public Agenda() {
        agenda = new HashMap<Grupo, LinkedList<Contacto>>();
    }
    
    public void insertarGrupo(){
        Grupo uno= new Grupo("grupoA","GrupoPrueba");
        LinkedList<Contacto> dos= new LinkedList<Contacto>();
        //Que no exista el grupo 
        agenda.put(uno,insertarContactos(new LinkedList<Contacto>()));
        
    }

    @Override
    public String toString() {
        return "Agenda{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", agenda=" + agenda + '}';
    }
    public  LinkedList<Contacto> insertarContactos(LinkedList<Contacto> aux){
       Contacto contacto;
       Scanner teclado= new Scanner(System.in);
       int opc;
       do{
           System.out.println("1.- Añadir un contacto");
           System.out.println("0- Salir");
           opc=teclado.nextInt();
           switch (opc) {
               case 1:
                   contacto= new Contacto();
                   contacto.ingresarDatos();
                   aux.add(contacto);
                   break;
               case 0:  
                   System.out.println("Saliendo...");
                   break;
               default:
                   System.err.println("Opcion incorrecta");
           }
        }while(opc!=0);
       //ordenar
       return aux;
    }
    
    public LinkedList<Contacto> ordenar(LinkedList<Contacto> agenda, Contacto nuevo){
        
        return aux;
    }
}
