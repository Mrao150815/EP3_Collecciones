/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3_i2017_paholasanchez_allanmartinez;

/**
 *
 * @author axel
 */
public class ExcepcionContactos extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionContactos</code> without detail
     * message.
     */
    public ExcepcionContactos() {
    }
    public void contactoNoEncontrado(){
        System.err.println("El contacto no se encontro");
    }
    public void errorAlOrdenar(){
        System.err.println("Error al ordenar contactos");
    }
    /**
     * Constructs an instance of <code>ExcepcionContactos</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionContactos(String msg) {
        super(msg);
    }
}
