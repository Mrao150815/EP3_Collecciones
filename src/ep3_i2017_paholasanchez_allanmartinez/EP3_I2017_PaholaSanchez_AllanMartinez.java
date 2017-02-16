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
        menu();
        
        
            /*Agenda agendaCont= new Agenda();
            Scanner t= new Scanner (System.in);
            String nombre;
            agendaCont.insertarGrupo();
            System.out.println(agendaCont.toString());
            System.out.println("Ingresa el grupo a buscar");
            System.out.println("Ingresa el nombre del grupo");
            nombre=t.nextLine();
            agendaCont.buscarGrupo(nombre);
        */
    }
    
    
    static public void menu(){
      
        Scanner teclado = new Scanner(System.in);
        int opc;
        
        do{
        
            System.out.println("\t SELECCIONE UNA DE LAS SIGUIENTES OPCIONES: \n");
            System.out.println("\t\t  _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.println("\t\t|\t 1. Agregar Grupo.                                           |");
            System.out.println("\t\t|\t 2. Agregar tarjeta de contacto a un grupo existente.        |");
            System.out.println("\t\t|\t 3. Eliminar un grupo.                                       |");
            System.out.println("\t\t|\t 4. Eliminar una terjeta de grupo.                           |");
            System.out.println("\t\t|\t 5. Consultar todas las tarjetas de contacto diferentes.     |");
            System.out.println("\t\t|\t 6. Consultar contactos que pertenezcan a más de un grupo.   |");
            System.out.println("\t\t|\t 7. Consultar un grupo.                                      |");
            System.out.println("\t\t|\t 8. Consultar un contacto.                                   |");
            System.out.println("\t\t|\t 9. Consultar un contacto por su fecha de nacimiento.        |");
            System.out.println("\t\t|\t 10. Modificar un grupo.                                     |");
            System.out.println("\t\t|\t 11. Modificar un contacto.                                  |");
            System.out.println("\t\t|\t 12. Ver todo.                                               |");
            System.out.println("\t\t|\t 0. Salir.                                                   |");
            System.out.println("\t\t| _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
            opc = teclado.nextInt();

            switch (opc) {

                case 1://Agregar Grupo
                    break;

                case 2://Agregar tarjeta de contacto a un grupo existente
                    break;

                case 3://Eliminar un grupo
                    break;

                case 4://Eliminar una terjeta de grupo
                    break;

                case 5://Consultar todas las tarjetas de contacto diferentes
                    break;

                case 6://Consultar contactos que pertenezcan a más de un grupo
                    break;

                case 7://Consultar un grupo
                    break;

                case 8://Consultar un contacto
                    break;

                case 9://Consultar un contacto por su fecha de nacimiento
                    break;

                case 10://Modificar un grupo.
                    break;

                case 11://Modificar un contacto
                    break;

                case 12://ver todo
                    break;

                case 0://salir
                    System.out.println("Fin del programa\n\n");
                    break;

            }
            
        }while(opc!=0);
    
    }
    
}
