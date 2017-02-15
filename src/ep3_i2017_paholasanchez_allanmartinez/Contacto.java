/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Clase de contacto contiene todos 
    los datos relacionados a los contactos, asi mismo sus metodos.
 */
package ep3_i2017_paholasanchez_allanmartinez;

import java.util.Scanner;

public class Contacto implements Comparable {

    private String nombre;
    private String apellido;
    private String correo;
    private String numTelefono;
    private String numCelular;
    private Fecha fechaNac;
    private float deuda;
    private char sexo;
    private String direccion;

    public Contacto() {
        fechaNac = new Fecha();
    }

    /*Constructores*/
    public Contacto(String nombre, String apellido, String correo, String numTelefono, String numCelular, Fecha fechaNac, float deuda, char sexo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numTelefono = numTelefono;
        this.numCelular = numCelular;
        this.fechaNac = fechaNac;
        this.deuda = deuda;
        this.sexo = sexo;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void ingresarDatos() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el nombre del contacto");
        nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido del contacto");
        apellido = teclado.nextLine();
        /*System.out.println("Ingresa el correo de: "+ nombre);
       correo=teclado.nextLine();
       //El num de contactacto contiene letras0
       System.out.println("Ingresa el numero fijo");
       numTelefono=teclado.nextLine();
       System.out.println("Ingresa el numero celular");
       numCelular=teclado.nextLine();
       System.out.println("Ingresa la fecha de nacimiento");
       //Hacer el metodo para ingresar fecha en la clase fecha
       System.out.println("Ingresa la direccion de: "+nombre);
       direccion=teclado.nextLine();
       System.out.println("Ingresa la deuda del contacto");
       deuda=teclado.nextFloat();
       //Que los datos ingresados en el sexo sean diferentes a M o F 
       /*System.out.println("Ingresa el sexo F (femenino) o M (masculino)");
       sexo=(char)teclado.next();
         */
    }

    /*Metdos SET y GET*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getNumCelular() {
        return numCelular;
    }

    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getDeuda() {
        return deuda;
    }

    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", apellido=" + apellido ;
    }

    @Override
    public int compareTo(Object t) {
        if (apellido.compareTo(((Contacto) t).apellido) < 0) {
            return 1;
        } else {
            if (apellido.compareTo(((Contacto) t).apellido) == 0) {
                if (nombre.compareTo(((Contacto) t).nombre) < 0) {
                    return 1;
                } else if (nombre.compareTo(((Contacto) t).nombre) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
            return -1;
        }

    }

}
