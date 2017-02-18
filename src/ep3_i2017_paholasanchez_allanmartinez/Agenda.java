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
import java.util.TreeSet;
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

    /*CONSTRUCTORES*/
    public Agenda(String nombre, String descripcion, HashMap<Grupo, LinkedList<Contacto>> agenda) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.agenda = agenda;
    }

    public Agenda() {
        agenda = new HashMap<Grupo, LinkedList<Contacto>>();
    }
//Metodo para insertar la informacion del grupo

    public void insertarGrupo() throws ExcepcionGrupo {
        Grupo grupo = new Grupo();
        grupo.ingresarDatos();
        //Que no exista el grupo
        if (!agenda.containsKey(grupo)) {
            agenda.put(grupo, new LinkedList<Contacto>());
            insertarContactos(grupo);
        } else {
            throw new ExcepcionGrupo();
        }

    }
//Metodo toString

    @Override
    public String toString() {
        return "Agenda{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", agenda=" + agenda + '}';
    }
//Metodo para buscar un  contacto utilizando un grupo contacto 

    public void buscarContacto(Grupo grupo) throws ExcepcionContactos {
        Scanner teclado = new Scanner(System.in);
        Contacto aux, aux2;
        Iterator<Contacto> i;
        String apellido, nombre;
        System.out.println("\t\t>Ingresa el nombre del contacto: ");
        nombre = teclado.nextLine();
        System.out.println("\t\t>Ingresa el apellido del contacto: ");
        apellido = teclado.nextLine();
        aux = new Contacto(nombre, apellido);
        i = agenda.get(aux).listIterator();
        for (int j = 0; j < agenda.get(grupo).size(); j++) {
            if (aux.compareTo(agenda.get(grupo).get(j)) == 0) {
                agenda.get(grupo).get(j).mostrarDatos();
            }
        }
        throw new ExcepcionContactos();
    }

//Metodfo para buscar un grupo en la agenda y lo retorna.
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

    public boolean modGrupo(String grupo) throws ExcepcionGrupo {
        Scanner sc = new Scanner(System.in);//esta variable leera
        Iterator i;//iterara en el treemap
        Grupo aux;//ayuda a guardar lo leido
        i = agenda.keySet().iterator();
        while (i.hasNext()) {
            aux = (Grupo) i.next();//se guarda loo que se lee
            if (aux.getNombre().compareTo(grupo) == 0) {//se compara que el nombre del grupo leido sea igua al nombre del grupo buscado
                System.out.println("\tNuevos datos para el grupo: ");//si es igual pide los nuevos datos
                System.out.println("\tNuevo nombre: ");
                aux.setNombre(sc.nextLine());//cambia el nombre
                System.out.println("\tNueva descripcion: ");
                aux.setDescripcion(sc.nextLine());//cambia la descripcion
                return true;//retorna verdadero si se cambio
            }
        }
        throw new ExcepcionGrupo();//si no se encuentra lanza la excepcion
    }

//Metodo para insertar contactos cuando se crea un grupo
    public void insertarContactos(Grupo grupo) {
        Contacto contacto;
        Scanner teclado = new Scanner(System.in);
        int opc;
        try {
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

        } catch (ExcepcionContactos ex) {
            ex.errorAlOrdenar();
        }
    }
//Metodo para insertar ordenadamente un contacto en un grupo

    public int ordenar(Grupo grupo, Contacto nuevo) throws ExcepcionContactos {
        if (agenda.get(grupo).isEmpty()) {
            return 0;
        } else {
            for (int i = 0; i < agenda.get(grupo).size(); i++) {
                if (nuevo.compareTo(agenda.get(grupo).get(i)) <= 0) {
                    return i;
                }
            }
            return agenda.get(grupo).size();
        }

    }
//Metodo para eliminar un contacto

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

    public boolean modificarContacto(Grupo grupo, Contacto contacto) throws ExcepcionContactos {
        if (agenda.get(grupo).contains(contacto)) {
            Iterator<Contacto> i = agenda.get(grupo).iterator();
            Contacto aux;
            while (i.hasNext()) {
                aux = i.next();
                if (aux.equals(contacto)) {
                    aux.modificarDatos();
                    return true;
                }
            }
        }
        throw new ExcepcionContactos();

    }

//-------------------------------------------------------Menu donde se muestran las opciones de la agenda
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
//metodo donde se realizan las opciones del menu

    public int menuOpciones(int opc) {

        Scanner teclado = new Scanner(System.in);
        String stAux, stAux2, stAux1;
        Grupo grAux;
        Contacto contAux;
        Fecha fecha;
        switch (opc) {
            case 1: {
                try {
                    //Ingresar un grupo;
                    insertarGrupo();
                } catch (ExcepcionGrupo ex) {
                    ex.grupoExiste();
                }
            }
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
                            agenda.get(grAux).add(ordenar(grAux, contAux), contAux);
                            System.out.println("Deseas añadir otro contacto presiona 1[SI] [0]NO");
                        } while (teclado.nextInt() != 0);
                    } catch (ExcepcionGrupo ex) {
                        ex.grupoNoEncontrado();
                    } catch (ExcepcionContactos ex) {
                        ex.errorAlOrdenar();
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

            case 4://Eliminar una tarjeta de grupo
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
                encontrarTodosContactos();
                break;

            case 6://Consultar contactos que pertenezcan a más de un grupo
                encontrarContVariosGrup();
                break;

            case 7://Consultar un grupo
                System.out.println("Ingresa el nombre del grupo");
                stAux = teclado.nextLine();
                try {
                    grAux = buscarGrupo(stAux);
                    grAux.mostrarDatos();
                    mostrarContactos(grAux);
                } catch (ExcepcionGrupo ex) {
                    ex.grupoNoEncontrado();
                }
                break;

            case 8://Consultar un contacto
                System.out.println("Ingresa el nombre del grupo");
                stAux = teclado.nextLine();
                try {
                    grAux = buscarGrupo(stAux);
                    buscarContacto(grAux);
                } catch (ExcepcionGrupo ex) {
                    ex.grupoNoEncontrado();
                } catch (ExcepcionContactos ex) {
                    ex.contactoNoEncontrado();
                }
                break;

            case 9://Consultar un contacto por su fecha de nacimiento
                System.out.println("Ingresa la fecha a buscar");
                fecha=new Fecha();
                fecha.ingresarDatos();
                mostrarContactosFecha(fecha);
                break;

            case 10://Modificar un grupo.

                System.out.println("Ingresa el nombre del grupo: ");
                stAux = teclado.nextLine();
                try {
                    if (modGrupo(stAux)) {
                        System.out.println("Moficado correctamente");
                    } else {
                        System.out.println("No se pudo modificar el grupo");
                    }

                } catch (ExcepcionGrupo ex) {
                    ex.grupoNoEncontrado();
                }
                break;

            case 11://Modificar un contacto
                System.out.println("Ingresa el nombre del grupo");
                stAux=teclado.nextLine();
            try {
                grAux=buscarGrupo(stAux);
                System.out.println("Ingresa el nombre del contacto");
                stAux1=teclado.nextLine();
                System.out.println("Ingresa el apellido del contacto");
                stAux2=teclado.nextLine();
                modificarContacto(grAux,new Contacto(stAux1,stAux2));
            } catch (ExcepcionGrupo ex) {
               ex.grupoNoEncontrado();
            } catch (ExcepcionContactos ex) {
                ex.contactoNoEncontrado();
            }
        
                
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
//Metodo para encontrar todos los contactos que existen en la agenda.

    public void encontrarTodosContactos() {
        TreeSet<Contacto> arbol = new TreeSet<Contacto>();
        Iterator i = agenda.keySet().iterator();
        Iterator j;
        Grupo grupoAux;
        Contacto auxCont;
        while (i.hasNext()) {
            grupoAux = (Grupo) i.next();
            arbol.addAll(agenda.get(grupoAux).subList(0, agenda.get(grupoAux).size()));

        }
        imprimirContactosEspecial(arbol, "sin repetir encontrados: ");
    }
//Metodo para imprimir un arbol con co0ntactos en especifico

    public void imprimirContactosEspecial(TreeSet<Contacto> arbol, String enunciado) {
        System.out.println("Los contactos " + enunciado + " :\n");
        Iterator<Contacto> i = arbol.iterator();
        Contacto aux;
        while (i.hasNext()) {
            aux = i.next();
            aux.mostrarDatos();
        }
    }
//Metodo para encontrar contactos que existen en dos o más grupos

    public void encontrarContVariosGrup() {
        TreeSet<Contacto> arbol = new TreeSet<Contacto>();
        Iterator i = agenda.keySet().iterator();
        Iterator<Contacto> j;
        Grupo grupoAux;
        Contacto auxCont;
        while (i.hasNext()) {
            grupoAux = (Grupo) i.next();
            j = agenda.get(grupoAux).iterator();
            while (j.hasNext()) {
                auxCont = j.next();
                if (compararContacto(auxCont) != null) {
                    arbol.add(auxCont);
                }
            }
        }

        imprimirContactosEspecial(arbol, "encontrados en varios grupos ");
    }
//Metodo para encontrar cuantas veces un contacto existe en los grupos

    public Contacto compararContacto(Contacto repetido) {
        Iterator<Grupo> i = agenda.keySet().iterator();
        Grupo aux;
        int cont = 0;
        System.out.println("s");
        while (i.hasNext()) {
            System.out.println("e");
            aux = i.next();
            if (agenda.get(aux).contains(repetido)) {
                repetido.mostrarDatos();

                cont++;
            }

        }
        if (cont > 1) {
            return repetido;
        }
        return null;
    }
//Metodo para mostrar todos los contactos y grupos de la agenda

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
//Metodo para mostrar los contactos de una agenda

    public void mostrarContactos(Grupo aux) {
        Iterator<Contacto> i = agenda.get(aux).iterator();
        Contacto auxCont;
        while (i.hasNext()) {
            auxCont = i.next();
            auxCont.mostrarDatos();
        }
    }
    public void mostrarContactosFecha(Fecha fecha){
        Iterator<Grupo> i=agenda.keySet().iterator();
        Iterator<Contacto> j;
        Contacto auxC;
        Grupo auxG;
        while(i.hasNext()){
            auxG=i.next();
            auxG.mostrarDatos();
            j=agenda.get(auxG).iterator();
            while(j.hasNext()){
                auxC=j.next();
                if(auxC.getFechaNac().equals(fecha)){
                    auxC.mostrarDatos();
                }
            }
        }
    }
  
}
