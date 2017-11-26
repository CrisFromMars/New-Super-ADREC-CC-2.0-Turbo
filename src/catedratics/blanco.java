package catedratics;

import formularios.resenias;

/**
 *
 * @author CxMars
 */
public abstract class blanco implements resenias {

    public void reprueba() {
        System.out.println("Dr. Blanco no resprueba a nadie");
    }

    public void asistencia() {
        System.out.println("solo falta una vez por semestre");
    }

    public void tarea() {
        System.out.println("y nunca encarga tarea");
    }

}
