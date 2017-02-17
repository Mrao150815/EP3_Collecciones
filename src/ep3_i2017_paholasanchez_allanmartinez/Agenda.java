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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC21
 */
public class Agenda {

    private String nombre;
    private String descripcion;
    private HashMap<Grupo, LinkedList<Contacto>> agenda;

    public Agenda(String nombre, String descripcion, HashMap<Grupo, LinkedList<Contacto>> agenda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.agenda = agenda;
    }

    public Agenda() {
        agenda = new HashMap<Grupo, LinkedList<Contacto>>();
    }

    public void insertarGrupo() {
        Grupo grupo = new Grupo();
        grupo.ingresarDatos();
        //Que no exista el grupo     
        agenda.put(grupo, new LinkedList<Contacto>());
        insertarContactos(grupo);
    }

    @Override
    public String toString() {
        return "Agenda{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", agenda=" + agenda + '}';
    }

    public Grupo buscarGrupo(String grupo) throws ExcepcionGrupo {
        Iterator i;
        Grupo aux;
        i = agenda.keySet().iterator();
        while (i.hasNext()) {
            aux = (Grupo) i.next();
            if (aux.getNombre().compareTo(grupo) == 0) {
                return aux;
            }
        }
        throw new ExcepcionGrupo();
    }

   

    public void insertarContactos(Grupo grupo) {
        Contacto contacto;
        Scanner teclado = new Scanner(System.in);
        int opc;
        do {
            System.out.println("1.- Añadir un contacto");
            System.out.println("0- Salir");
            opc = teclado.nextInt();
            switch (opc) {
                case 1:
                    contacto = new Contacto();
                    contacto.ingresarDatos();
                    agenda.get(grupo).add(ordenar(grupo, contacto), contacto);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.err.println("Opcion incorrecta");
            }
        } while (opc != 0);

    }

    public int ordenar(Grupo grupo, Contacto nuevo) {
        if (agenda.get(grupo).isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < agenda.size(); i++) {
                if (nuevo.compareTo(agenda.get(grupo).get(i)) > 0 || nuevo.compareTo(agenda.get(grupo).get(i)) == 0) {
                    return i;
                }
            }
        }
        return 1;
    }

    public boolean eliminarContacto(Grupo grupo, String nombre, String apellido) throws ExcepcionContactos {
        Contacto aux = new Contacto(nombre, apellido);
        Contacto aux2;
        LinkedList<Contacto> i = agenda.get(grupo);

        for (int j = 0; j < i.size(); j++) {
            aux2 = i.get(j);
            aux2.mostrarDatos();

            if (aux2.compareTo(aux) == 0) {
                if (agenda.get(grupo).remove(aux2)) {
                    System.out.println("El contacto se elimino, hay probabilidad que existan más");
                }
                return true;
            }
        }
        throw new ExcepcionContactos();

    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int opc;
        do {

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
        } while (menuOpciones(opc) != 0);

    }

    public int menuOpciones(int opc) {

        Scanner teclado = new Scanner(System.in);
        String stAux, stAux2, stAux1;
        Grupo grAux;
        Contacto contAux;
        switch (opc) {
            case 1:
                //Ingresar un grupo;
                insertarGrupo();
                break;

            case 2://Agregar tarjeta de contacto a un grupo existente
                System.out.println("Ingresa el nombre del grupo: ");
                stAux = teclado.nextLine();
                 {
                    try {
                        grAux = buscarGrupo(stAux);
                        do {
                            contAux = new Contacto();
                            contAux.ingresarDatos();
                            agenda.get(grAux).add(ordenar(grAux,contAux),contAux);
                            //agenda.get(stAux).add(insertarContactos());
                            System.out.println("Deseas añadir otro contacto presiona 1[SI] [0]NO");
                        } while (teclado.nextInt() != 0);
                    } catch (ExcepcionGrupo ex) {
                        ex.grupoNoEncontrado();
                    }
                }
                break;

            case 3://Eliminar un grupo
                System.out.println("Ingresa el nombre del grupo a borrar");
                stAux = teclado.nextLine();
                 {
                    try {
                        grAux = buscarGrupo(stAux);
                        System.out.println("Estas seguro que deseas borrarlo 1[SI] 0[NO]");
                        if (teclado.nextInt() != 0) {
                            agenda.remove(grAux);
                            System.out.println("EL grupo ah sido eliminado");
                        } else {
                            System.err.println("El grupo no se elimino");
                        }
                    } catch (ExcepcionGrupo ex) {
                        ex.grupoNoEncontrado();
                    }
                }
                break;

            case 4://Eliminar una terjeta de grupo
                System.out.println("Ingresa el nombre del grupo");
                stAux = teclado.nextLine();
                 {
                    try {
                        grAux = buscarGrupo(stAux);
                        System.out.println("Ingresa el nombre del contacto:");
                        stAux1 = teclado.nextLine();
                        System.out.println("Ingresa el apellido del contacto");
                        stAux2 = teclado.nextLine();
                        eliminarContacto(grAux, stAux1, stAux2);
                    } catch (ExcepcionGrupo ex) {
                        ex.grupoNoEncontrado();
                    } catch (ExcepcionContactos ex) {
                        ex.contactoNoEncontrado();
                    }
                }

                break;

            case 5:

            //Consultar todas las tarjetas de contacto diferentes
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
                mostrarTodo();
                break;

            case 0://salir
                System.out.println("Fin del programa\n\n");
                break;

            default:
                System.out.println("Opcion Invalida");
        }
        return opc;
    }

    public void mostrarTodo() {
        Iterator i;
        Grupo aux;
        i = agenda.keySet().iterator();
        while (i.hasNext()) {
            aux = (Grupo) i.next();
            aux.mostrarDatos();
            mostrarContactos(aux);
        }
    }

    public void mostrarContactos(Grupo aux) {
        Iterator<Contacto> i = agenda.get(aux).iterator();
        Contacto auxCont;
        while (i.hasNext()) {
            auxCont = i.next();
            auxCont.mostrarDatos();
        }
    }

    private Exception ExcepcionContactos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
