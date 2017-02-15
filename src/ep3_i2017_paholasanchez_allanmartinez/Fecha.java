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

/**
 *
 * @author PC21
 */
class Fecha {
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

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", anio=" + anio + ", mes=" + mes + '}';
    }
    
    
}
