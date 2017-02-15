/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: calse principal, donde se instancea la agenda.
    
 */
package ep3_i2017_paholasanchez_allanmartinez;

import java.util.Scanner;

/**
 *
 * @author PC21
 */
public class EP3_I2017_PaholaSanchez_AllanMartinez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda agendaCont= new Agenda();
        Scanner t= new Scanner (System.in);
        String nombre;
        agendaCont.insertarGrupo();
        System.out.println(agendaCont.toString());
        System.out.println("Ingresa el grupo a buscar");
        System.out.println("Ingresa el nombre del grupo");
        nombre=t.nextLine();
        agendaCont.buscaGrupo();
        
        
    }
    
}
