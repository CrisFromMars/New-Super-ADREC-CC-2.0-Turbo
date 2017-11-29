package controlador;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.alumnoDAO;
import modelo.conectar;
import modelo.escuela;
import vista.Ventana;
import modelo.catedratics.*;

/**
 * Clase para que los botones funcionen, es la parte funcional del controlador
 *
 * @author CxMars
 */
public class controladorVentana implements ActionListener {

    Ventana vistaVentana = new Ventana();
    alumnoDAO modeloVentana = new alumnoDAO();

    /**
     * metodo que llama a los botones, vistas y modelos para su conexión.
     *
     * @param vistaVentana Ventana.java
     * @param modeloVentana alumnoDAO.java
     */
    public controladorVentana(Ventana vistaVentana, alumnoDAO modeloVentana) {

        this.vistaVentana = vistaVentana;
        this.modeloVentana = modeloVentana;
        this.vistaVentana.btnGuardar.addActionListener(this);
        this.vistaVentana.btnCalc.addActionListener(this);
        this.vistaVentana.btnProfes.addActionListener(this);
        this.vistaVentana.btnReseProfes.addActionListener(this);

    }

    /**
     * metodo controladorVentana
     */
    public controladorVentana() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * reservado para su futuro eso.
     */
    public void inicializarVentana() {
    }

    /**
     * Metodo que registra las acciones de botones accionados, se incluyen
     * btnGuardar, btnProfes, btnReseProfes y btnCalc.
     */
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
                vistaVentana.lblResul.setText("Introduzca valores entre '0' y '10'");
            } else if (cali2 < 0 || cali2 > 10) {
                vistaVentana.lblResul.setText("Introduzca valores entre '0' y '10'");
            } else {
                cali3 = (6 - (cali1 + cali2)) / 0.4;

                aux = (int) (cali3 * 100);

                resu = aux / 100d;

                //Lambda
                if (resu <= 10) {
                    List<String> datos = new ArrayList<>();
                    datos.add(nomb);

                    datos.stream().forEach(d
                            -> vistaVentana.lblResul.setText(nomb + " sacaste " + vistaVentana.txtPar1.getText() + " y " + vistaVentana.txtPar2.getText() + ",necesitas un " + resu + " para aprobar " + mate + ".")
                    );
                } else if (resu == 0) {
                    vistaVentana.lblResul.setText("Ya has aprobado el semestre ;)");
                } else if (resu > 10) {
                    vistaVentana.lblResul.setText("Lo sentimos, Ya no puedes aprobar el semestre :(");
                }
            }

        }
        if (e.getSource() == vistaVentana.btnProfes) {

            // Enums
            for (escuela maestros : escuela.values()) {

                System.out.printf("El catedratico %s da %s, y lleva %d años dando clase.\n",
                        maestros, maestros.getMateria(), maestros.getTiempoImpartiendo());
                System.out.println("  ------");
            }
        }
        if (e.getSource() == vistaVentana.btnReseProfes) {

            // Interfaces y clases abstractas
            luis ca1 = new luis() {
            };
            gameros ca2 = new gameros() {
            };
            blanco ca3 = new blanco() {
            };

            ca1.reprueba();
            ca1.asistencia();
            ca1.tarea();
            System.out.println("--");

            ca2.reprueba();
            ca2.asistencia();
            ca2.tarea();
            System.out.println("--");

            ca3.reprueba();
            ca3.asistencia();
            ca3.tarea();
            System.out.println("--");

            // Herencia
            System.out.println("");
            analu ca4 = new analu();

            ca4.reprueba();
            ca4.asistencia();
            ca4.tarea();
            System.out.println("--");

            // Polimorfismo
            ampaPoli ca5 = new amparito();

            ampaPoli.reprueba();
            ampaPoli.asistencia();
            ampaPoli.tarea();
        }
    }

}
