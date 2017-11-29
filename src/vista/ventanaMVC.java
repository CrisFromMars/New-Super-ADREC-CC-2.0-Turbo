package vista;

import controlador.controladorVentana;
import modelo.alumnoDAO;


/**
 *
 * @author CxMars
 */
public class ventanaMVC {
    
    public static void main(String[] args){
    
        Ventana vistaC = new Ventana();
        alumnoDAO modeloC = new alumnoDAO();
        controladorVentana controlaC = new controladorVentana(vistaC, modeloC);
        vistaC.setVisible(true);
        vistaC.setLocationRelativeTo(null);
    }
    
}
