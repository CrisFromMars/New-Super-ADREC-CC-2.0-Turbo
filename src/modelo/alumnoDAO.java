package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vista.Ventana;

/**
 *
 * @author CxMars
 */
public class alumnoDAO extends Ventana{
    
    DefaultTableModel model;
    
    public void insertarAlumno(){
    
    conectar cc = new conectar();
        Connection cn = cc.conexion();
        String nom, mate, par1, par2;
        String sql = "";
        nom = txtNomb.getText();
        mate = txtMate.getText();
        par1 = txtPar1.getText();
        par2 = txtPar2.getText();
        sql = "INSERT INTO alumno (nomAlumno, materia, caliUnoMateria, caliDosMateria) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nom);
            pst.setString(2, mate);
            pst.setString(3, par1);
            pst.setString(4, par2);
            int n = pst.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado con exito");
                bloquear();
                cargar("");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
