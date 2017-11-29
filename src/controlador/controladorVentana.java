package controlador;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.alumnoDAO;
import modelo.conectar;
import vista.Ventana;

/**
 *
 * @author CxMars
 */
public class controladorVentana implements ActionListener{
    
    Ventana vistaVentana = new Ventana();
    alumnoDAO modeloVentana = new alumnoDAO();
    
    
    public controladorVentana(Ventana vistaVentana, alumnoDAO modeloVentana){
    
        this.vistaVentana=vistaVentana;
        this.modeloVentana=modeloVentana;
        this.vistaVentana.btnGuardar.addActionListener(this);
        
        
    }

    public controladorVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void inicializarVentana(){}
    
    public void actionPerformed(ActionEvent e){
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        String sql = "";
        String nomAlumno = vistaVentana.txtNomb.getText();
        String materia = vistaVentana.txtMate.getText();
        String caliUnoMateria = vistaVentana.txtPar1.getText();
        String caliDosMateria = vistaVentana.txtPar2.getText();
        sql = "INSERT INTO alumno (nomAlumno, materia, caliUnoMateria, caliDosMateria) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, nomAlumno);
            pst.setString(2, materia);
            pst.setString(3, caliUnoMateria);
            pst.setString(4, caliDosMateria);
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
               // bloquear();
               // cargar("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
