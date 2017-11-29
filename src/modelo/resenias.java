package modelo;

/**
 * Interfase de reseñas de tipo abstracto
 *
 * @author CxMars
 */
//Clase abstracta
public abstract interface resenias {

    /**
     * metodo abstracto de que tan seguido un catdratico reprueba
     */
    public void reprueba();

    /**
     * metodo abstracto de que tan seguido un catedratico asiste a sus clses
     */
    public void asistencia();

    /**
     * metodo abstracto de que tanta tarea asignan los catedraticos
     */
    public void tarea();

}
