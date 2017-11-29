package controlador;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.alumnoDAO;
import modelo.conectar;
import vista.Ventana;

/**
 *
 * @author CxMars
 */
public class controladorVentana implements ActionListener {

    Ventana vistaVentana = new Ventana();
    alumnoDAO modeloVentana = new alumnoDAO();

    public controladorVentana(Ventana vistaVentana, alumnoDAO modeloVentana) {

        this.vistaVentana = vistaVentana;
        this.modeloVentana = modeloVentana;
        this.vistaVentana.btnGuardar.addActionListener(this);
        this.vistaVentana.btnCalc.addActionListener(this);

    }

    public controladorVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inicializarVentana() {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVentana.btnGuardar) {
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
        if (e.getSource() == vistaVentana.btnCalc) {
            double cali1, cali2, cali3, resu;
            int aux;
            String nomb, mate;
            nomb = vistaVentana.txtNomb.getText();
            mate = vistaVentana.txtMate.getText();
            cali1 = 0.3 * Double.parseDouble(vistaVentana.txtPar1.getText());
            cali2 = 0.3 * Double.parseDouble(vistaVentana.txtPar2.getText());

            if ((cali1 < 0 || cali1 > 10)) {
                vistaVentana.lblResu.setText("Introduzca valores entre '0' y '10'");
            } else if (cali2 < 0 || cali2 > 10) {
                vistaVentana.lblResu.setText("Introduzca valores entre '0' y '10'");
            } else {
                cali3 = (6 - (cali1 + cali2)) / 0.4;

                aux = (int) (cali3 * 100);

                resu = aux / 100d;

                //Lambda
                if (resu <= 10) {
                    List<String> datos = new ArrayList<>();
                    datos.add(nomb);

                    datos.stream().forEach(d
                            -> vistaVentana.lblResu.setText(nomb + " sacaste " + vistaVentana.txtPar1.getText() + " y " + vistaVentana.txtPar2.getText() + ",necesitas un " + resu + " para aprobar " + mate + ".")
                    );
                } else if (resu == 0) {
                    vistaVentana.lblResu.setText("Ya has aprobado el semestre ;)");
                } else if (resu > 10) {
                    vistaVentana.lblResu.setText("Lo sentimos, Ya no puedes aprobar el semestre :(");
                }
            }

        }
    }

}
