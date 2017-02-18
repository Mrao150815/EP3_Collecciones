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
class Fecha implements Comparable {
    private int dia;
    private int anio;
    private int mes;
    private static final int ANIOZERO=1900;
    private static final int ANIOACTUAL=2017;

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
    
    
    public void ingresoFecha(){ //ingresa el dia, mes y año de uno por uno y valida que sea correcta: que este dentro de los rangos
        Scanner teclado = new Scanner(System.in);
        
        
        System.out.printf("\t\t>Mes: ");
        mes = teclado.nextInt();
        if(mes>=1 && mes<=12){//valida que el mes este dentro del rango
            System.out.printf("\t\t>Dia: ");
            dia = teclado.nextInt();
            if(dia>=1 && dia<=31){
                System.out.printf("\t\t>Año: ");
                anio = teclado.nextInt();
                if(anio>=ANIOZERO && anio<=ANIOACTUAL){
                    System.out.printf("Fecha correcta");
                }else{
                    System.out.printf("Problema en año: Fecha invalida\n");
                    //pone los 0 en la fecha, para que no tenga el dia, mes y año ingresado
                    dia=0;
                    mes=0;
                    anio=0;
                }
            }else{
                System.out.printf("Problema en dia: Fecha invalida\n");
                dia=0;
                mes=0;
            }
        }else{
            mes=0;//es para que no tenga el dato ingresado
            System.out.printf("Problema en dia: Fecha invalida\n");
        }
    }
    
    @Override
    public String toString() {
        return "Fecha{" + dia + "/" + mes + "/" + anio + '}';
    }

    @Override
    public int compareTo(Object o) {
       return 1; 
    }

    
}
