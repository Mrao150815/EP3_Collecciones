/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Clase que maneja las excepciones de los contactos
 */
package ep3_i2017_paholasanchez_allanmartinez;

/**
 *
 * @author axel
 */
public class ExcepcionContactos extends Exception {//excepciones de contacto

    /**
     * Creates a new instance of <code>ExcepcionContactos</code> without detail
     * message.
     */
    public ExcepcionContactos() {
    }
    //Metodos para imprimir el mensaje de error.
    public void contactoNoEncontrado(){
        System.err.println("El contacto no se encontro");
    }
    public void errorAlOrdenar(){
        System.err.println("Error al ordenar contactos");
    }
    public ExcepcionContactos(String msg) {
        super(msg);
    }
}
