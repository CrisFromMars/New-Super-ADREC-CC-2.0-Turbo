package catedratics;

import formularios.resenias;

/**
 * Clase luis que se usará para uso de interfaces y clases abstractas
 *
 * @author CxMars
 */
public abstract class luis implements resenias {

    /**
     * metodo que describe que tanto reprueba el catedratico
     */
    public void reprueba() {
        System.out.println("Luis no resprueba uwu");
    }

    /**
     * metodo que indica cual es la asistencia del catedratico
     */
    public void asistencia() {
        System.out.println("tampoco no falta a sus clases");
    }

    /**
     * metodo que muestra que tanta tarea encarga el catedratico
     */
    public void tarea() {
        System.out.println("y encarga poca tarea");
    }

}
