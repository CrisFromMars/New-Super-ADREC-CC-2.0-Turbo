package modelo.catedratics;

import vista.Ventana;

/**
 * clase analu que se usara para uso de herencia
 *
 * @author CxMars
 */
public class analu extends Ventana {

    /**
     * metodo que describe que tanto reprueba el catedratico
     */
    public void reprueba() {
        System.out.println("Nadie reprueba con Analu <3");
    }

    /**
     * metodo que indica cual es la asistencia del catedratico
     */
    public void asistencia() {
        System.out.println("ademas falta seguido a sus clases");
    }

    /**
     * metodo que muestra que tanta tarea encarga el catedratico
     */
    public void tarea() {
        System.out.println("y la especialidad de Analu es dejar tarea");
    }

}
