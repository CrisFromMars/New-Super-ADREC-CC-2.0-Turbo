package modelo.catedratics;

import modelo.resenias;

/**
 * Clase gameros que se usará para uso de interfaces y clases abstractas
 *
 * @author CxMars
 */
public abstract class gameros implements resenias {

    /**
     * metodo que describe que tanto reprueba el catedratico
     */
    public void reprueba() {
        System.out.println("Gameros reprueba a todos");
    }

    /**
     * metodo que indica cual es la asistencia del catedratico
     */
    public void asistencia() {
        System.out.println("nunca falta a sus clases");
    }

    /**
     * metodo que muestra que tanta tarea encarga el catedratico
     */
    public void tarea() {
        System.out.println("y ademas encarga un chin#$ de tarea");
    }

}
