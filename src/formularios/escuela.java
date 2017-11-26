package formularios;

/**
 *
 * @author CxMars
 */
public enum escuela {

    LUIS("Diseño de bajo nivel", 6),
    GAMEROS("Fisica", 13),
    BLANCO("POO", 20),
    ANALU("Clinica Reqerimientos", 5),
    AMPARITO("Calculo", 20);

    private final String materia;
    private final int tiempoImpartiendo;

    private escuela(String a, int b) {

        materia = a;
        tiempoImpartiendo = b;
    }

    public String getMateria() {

        return materia;
    }

    public int getTiempoImpartiendo() {

        return tiempoImpartiendo;
    }

}
