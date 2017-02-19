/*
    Evidencia de producto 3 "Estructuras dinamicas" uso de colecciones.
    Fundamentos de Programación Orientada a Objetos
    Ingenieria en informatica IIF 5A
    Maestra:   Alma Delia Nieto Yañez
    Alumnos: Pahola Karina Sanchez Flores SFPO150125
             Martinez Ramirez Allan Axel  MROA150815
    Fecha: 18 de Febrero del 2017
    Decripcion de la clase: Calse fecha se utiliza para comparar y validar fechas,
    asi mismo da el formato al guardarlo.
    
 */
package ep3_i2017_paholasanchez_allanmartinez;

import java.util.Scanner;

/**
 *
 * @author PC21
 */
class Fecha implements ManejoDatos {

    private int dia;
    private int anio;
    private int mes;
    private static final int ANIOZERO = 1900;
    private static final int ANIOACTUAL = 2017;

    public Fecha(int dia, int anio, int mes) {
        this.dia = dia;
        this.anio = anio;
        this.mes = mes;
    }

    public Fecha() {
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "Fecha{" + dia + "/" + mes + "/" + anio + '}';
    }

    @Override
    public boolean equals(Object t) {
        if (t instanceof Fecha) {
            if (((Fecha) t).anio == anio && ((Fecha) t).dia == dia && ((Fecha) t).mes == mes) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.dia;
        hash = 41 * hash + this.anio;
        hash = 41 * hash + this.mes;
        return hash;
    }

    //metodo para almacenar los datos de la fecha
    @Override
    public void ingresarDatos() {
        Scanner teclado = new Scanner(System.in);
        System.out.printf("\t\t\t>Mes: ");
        mes = teclado.nextInt();
        if (mes >= 1 && mes <= 12) {//valida que el mes este dentro del rango
            System.out.printf("\t\t\t>Dia: ");
            dia = teclado.nextInt();
            if (dia >= 1 && dia <= 31) {
                System.out.printf("\t\t\t>Año: ");
                anio = teclado.nextInt();
                if (anio >= ANIOZERO && anio <= ANIOACTUAL) {
                    System.out.printf("\t\t\t\t-Fecha Valida\n");
                } else {
                    System.out.printf("\t\tProblema en año: Fecha invalida\n");
                    //pone los 0 en la fecha, para que no tenga el dia, mes y año ingresado
                    dia = 0;
                    mes = 0;
                    anio = 0;
                }
            } else {
                System.out.printf("\t\tProblema en dia: Fecha invalida\n");
                dia = 0;
                mes = 0;
            }
        } else {
            mes = 0;//es para que no tenga el dato ingresado
            System.out.printf("\t\tProblema en dia: Fecha invalida\n");
        }

    }

    
    //muestra la fecha ingresada
    @Override
    public void mostrarDatos() {
        System.out.println("\t\t- Fecha: " + dia + "-" + "mes" + mes + "año" + "-" + anio);
    }

    
    //metodo que sirve para modificar alguno de los datos de la fecha
    @Override
    public void modificarDatos() {
        Scanner t = new Scanner(System.in);
        System.out.println("\n\n\nEscoge una opcion para modificar ");
        System.out.println("\t\t\t\t |  1. Año.     |");
        System.out.println("\t\t\t\t |  2. Mes.     |");
        System.out.println("\t\t\t\t |  3. Dia.     |");
        switch (t.nextInt()) {
            case 1:
                System.out.println("\t\t\t>Ingresa el nuevo anio: ");
                setAnio(t.nextInt());
                break;
            case 2:
                System.out.println("\t\t\t>Ingresa el nuevo mes: ");
                setMes(t.nextInt());
                break;
            case 3:
                System.out.println("\t\t\t>Ingresa el nuevo dia: ");
                setDia(t.nextInt());
                break;

            default:
                System.out.println("\t\t\t --- ¡OPCION INCORRECTA !");
        }
    }

}
