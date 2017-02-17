/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Clase que maneja las excepciones respecto a los grupos en la agenda. 
 */
package ep3_i2017_paholasanchez_allanmartinez;

/**
 *
 * @author axel
 */
public class ExcepcionGrupo extends Exception {

    public ExcepcionGrupo() {
    }
    //Metodos para imprimir el error
    public void grupoNoEncontrado(){
        System.err.println("El grupo no fue encontrado");
    }
    public void grupoExiste(){
        System.err.println("El grupo ya existe");
    }
    public ExcepcionGrupo(String msg) {
        super(msg);
    }
}
