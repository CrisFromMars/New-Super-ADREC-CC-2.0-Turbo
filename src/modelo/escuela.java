package modelo;

/**
 * Clase de tipo enum, para ser aplicados en información de profesores
 *
 * @author CxMars
 */
public enum escuela {

    /**
     * variable Luis de tipo constante
     */
    LUIS("Diseño de bajo nivel", 6),
    /**
     * variable Gameros de tipo constante
     */
    GAMEROS("Fisica", 13),
    /**
     * variable Blanco de tipo constante
     */
    BLANCO("POO", 20),
    /**
     * variable Analu de tipo constante
     */
    ANALU("Clinica Reqerimientos", 5),
    /**
     * variable Amparito de tipo constante
     */
    AMPARITO("Calculo", 20);

    private final String materia;
    private final int tiempoImpartiendo;

    private escuela(String a, int b) {

        materia = a;
        tiempoImpartiendo = b;
    }

    /**
     * metodo Getter para obtener materia
     *
     * @return regresa el nombre de la materia
     */
    public String getMateria() {

        return materia;
    }

    /**
     * metodo Getter para obtener tiempoImpartiendo
     *
     * @return regresa el tiempo que el catedratico lleva dando clases
     */
    public int getTiempoImpartiendo() {

        return tiempoImpartiendo;
    }

}
