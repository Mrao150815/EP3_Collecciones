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

/**
 *
 * @author PC21
 */
public class Agenda {
    private String nombre;  
    private String descripcion;
    private HashMap<Grupo, LinkedList<Contacto>>agenda;
}
