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

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contacto implements Comparable,ManejoDatos {

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
    
    public Contacto(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        
    }

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

    @Override
    public void ingresarDatos() {//ingresa y gurada toda la informacion del contacto
        Scanner teclado = new Scanner(System.in);
        System.out.println("\t\t> Ingresa el nombre del contacto: ");
        nombre = teclado.nextLine();
        System.out.println("\t\t> Ingresa el apellido del contacto: ");
        apellido = teclado.nextLine();
        System.out.println("\t\t> Ingresa la fecha de nacimiento de "+nombre+" :");
        fechaNac.ingresarDatos();
        System.out.println("\t\t> Ingresa el correo de "+ nombre+" :");
        correo=teclado.nextLine();
        System.out.println("\t\t> Ingresa el numero fijo");
        numTelefono=teclado.nextLine();
        System.out.println("\t\t> Ingresa el numero celular");
        numCelular=teclado.nextLine();
        System.out.println("\t\t> Ingresa la direccion de "+nombre+" :");
        direccion=teclado.nextLine();
        System.out.println("\t\t> Ingresa la deuda del contacto: ");
        deuda=teclado.nextFloat();
        //los datos ingresados en el sexo sean diferentes a M o F 
        System.out.println("\t\t> Ingresa el sexo F (femenino) o M (masculino): ");
         try {
             sexo=(char) System.in.read();
         } catch (IOException ex) {
             Logger.getLogger(Contacto.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void mostrarDatos() {//muestar los datos almacenados del contacto
        System.out.println("\t\t INFORMACION DEL CONTACTO: ");
        System.out.println("\t\t- Nombre contacto: " + nombre);
        System.out.println("\t\t- Apellido contacto: " + apellido);
        System.out.println("\t\t- Correo: "+correo);
        System.out.println("\t\t- Numero telefono fijo: "+numTelefono);
        System.out.println("\t\t- Numero telefono celular: "+numCelular);
        System.out.println("\t\t- Fecha de nacimiento: "+fechaNac);
        System.out.println("\t\t- Deuda:"+deuda);
        System.out.println("\t\t- Sexo: "+sexo);
        System.out.println("\t\t- Direccion:"+direccion);
        System.out.println("\n");
        
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
        return "Contacto{" + "nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", numTelefono=" + numTelefono + ", numCelular=" + numCelular + ", fechaNac=" + fechaNac + ", deuda=" + deuda + ", sexo=" + sexo + ", direccion=" + direccion + '}';
    }

    
    
    @Override
    public int compareTo(Object t) {//compara los apellidos y nombre, para colocarlos en orden alfabetico
        if (apellido.compareTo(((Contacto) t).apellido) > 0) {
            return 1;
        } else {
            if (apellido.compareTo(((Contacto) t).apellido) == 0) {
                if (nombre.compareTo(((Contacto) t).nombre) > 0) {
                    return 1;
                } else if (nombre.compareTo(((Contacto) t).nombre) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }else{
                if (nombre.compareTo(((Contacto) t).nombre) > 0) {
                    return 1;
                } else if (nombre.compareTo(((Contacto) t).nombre) == 0) {
                    return 0;
                } else {
                    return -1;
                }
            }   
           }
    }

    @Override 
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + Objects.hashCode(this.apellido);
        return hash;
    }
    @Override
    public boolean equals(Object t){
        if(t instanceof Contacto){
            return nombre.equals(((Contacto) t).nombre) && apellido.equals(((Contacto) t).apellido);
        }
        return false;
    }

    public void menuModificar(){//sub menu auxiliar: este menu sirve para mostrarselo al usuario para pueda escoger cual info. quiere modificar
        System.out.println("ESCOGE UNA OPCION A MODOFCAR: ");
        System.out.println("\t\t|\t1. Nombre.                   |");
        System.out.println("\t\t|\t2. Apellido.                 |");
        System.out.println("\t\t|\t3. Correo.                   |");
        System.out.println("\t\t|\t4. Telefono fijo.            |");
        System.out.println("\t\t|\t5. Telefono celular.         |");
        System.out.println("\t\t|\t6. Fecha de Nacimiento.      |");
        System.out.println("\t\t|\t7. Deuda.                    |");
        System.out.println("\t\t|\t8. Sexo.                     |");
        System.out.println("\t\t|\t9. Direccion.                |");
        System.out.println("\t\t|\t0. Salir.                    |");
    }
    
    
    @Override
    public void modificarDatos() {//segun sea la opcion seleccionada en el metodo de meuModoficar ira a su caso correspondiente
       Scanner teclado= new Scanner(System.in);
       Scanner teclado2=new Scanner(System.in);
       int opc;
       do{
       menuModificar();
       opc=teclado2.nextInt();
           switch (opc){//pide y guarda lo nuevos datos
               case 1:
                   System.out.println("Ingresa el nuevo nombre");
                   setNombre(teclado.nextLine());
                   break;
               case 2:
                   System.out.println("Ingresa el nuevo apellido");
                   setApellido(teclado.nextLine());
                   break;
               case 3:
                   System.out.println("Ingresa el nuevo correo");
                   setCorreo(teclado.nextLine());
                break;
               case 4:
                   System.out.println("Ingresa el nuevo telefono");
                   setNumTelefono(teclado.nextLine());
                   break;
               case 5:
                   System.out.println("Ingresa el nuevo celular");
                   setNumCelular(teclado.nextLine());
                   break;
               case 6:
                   System.out.println("Ingresa la nueva fecha de Nacimiento");
                   fechaNac.modificarDatos();
                   break;
               case 7:
                   System.out.println("Ingresa la nueva deuda del contacto");
                   setDeuda(teclado.nextFloat());
                   break;
               case 8:
                   System.out.println("El sexo se ah cambiado");
                   if(sexo=='M'){
                       sexo='F';
                   }else{
                       if(sexo=='F')
                           sexo='M';
                       else
                           sexo='?';
                   }
                   break;
               case 9:
                   System.out.println("Ingresa la nueva Direccion");
                   setDireccion(teclado.nextLine());
                   break;
               case 0:
                   System.out.println("Saliendo...");
                   break;
               default:
                   System.err.println("Opcion Incorrecta");
           }
       }while(opc!=0);//este menu se repetira hasta que la opcion sea 0
    }

}
