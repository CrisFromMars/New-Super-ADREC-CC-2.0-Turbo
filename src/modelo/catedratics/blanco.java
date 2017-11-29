package modelo.catedratics;

import modelo.resenias;

/**
 * Clase blanco que se usará para uso de interfaces y clases abstractas
 *
 * @author CxMars
 */
public abstract class blanco implements resenias {

    /**
     * metodo que describe que tanto reprueba el catedratico
     */
    public void reprueba() {
        System.out.println("Dr. Blanco no resprueba a nadie");
    }

    /**
     * metodo que indica cual es la asistencia del catedratico
     */
    public void asistencia() {
        System.out.println("solo falta una vez por semestre");
    }

    /**
     * metodo que muestra que tanta tarea encarga el catedratico
     */
    public void tarea() {
        System.out.println("y nunca encarga tarea");
    }

}
