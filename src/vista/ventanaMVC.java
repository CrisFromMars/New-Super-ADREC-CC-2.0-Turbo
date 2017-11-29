package vista;

import controlador.controladorVentana;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.alumnoDAO;
import modelo.conectar;


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


