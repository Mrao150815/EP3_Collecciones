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
public class ExcepcionGrupo extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionGrupoContactos</code> without
     * detail message.
     */
    public ExcepcionGrupo() {
    }
    public void grupoNoEncontrado(){
        System.err.println("El grupo no fue encontrado");
    }
    /**
     * Constructs an instance of <code>ExcepcionGrupoContactos</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    
    public ExcepcionGrupo(String msg) {
        super(msg);
    }
}
