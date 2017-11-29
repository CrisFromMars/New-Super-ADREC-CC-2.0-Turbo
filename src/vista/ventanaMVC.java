package vista;

import controlador.controladorVentana;
import modelo.alumnoDAO;

/**
 * Clase que controla el MVC
 *
 * @author CxMars
 */
public class ventanaMVC {

    /**
     * main que controla todo:D
     *
     * @param args
     */
    public static void main(String[] args) {

        Ventana vistaC = new Ventana();
        alumnoDAO modeloC = new alumnoDAO();
        controladorVentana controlaC = new controladorVentana(vistaC, modeloC);
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);

    }
}
