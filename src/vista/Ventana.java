package vista;

import modelo.catedratics.ampaPoli;
import modelo.catedratics.amparito;
import modelo.catedratics.analu;
import modelo.catedratics.blanco;
import modelo.catedratics.gameros;
import modelo.catedratics.luis;
import controlador.controladorVentana;
import modelo.conectar;
import modelo.escuela;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.alumnoDAO;
import modelo.*;
import vista.*;
import controlador.*;


/**
 * Clase ventana, que hace que todo funcione, tanto botones, funciones y logica,
 * como conexión a base de datos.
 *
 * @author CxMars
 * @version 2.0
 */
public class Ventana extends javax.swing.JFrame {

    DefaultTableModel model;

    /**
     * constructor principal para inicializar todos los componentes, así como
     * los metodos limpiar, bloquear y cargar los cuales se inicializan desde
     * que arranca la aplicación
     */
    public Ventana() {
        initComponents();
        limpiar();
        bloquear();
        cargar("");
    }

    /**
     * Metodo que carga la tabla de la base de datos en la aplicación.
     *
     * @param valor parametro de tipo String que obtiene como valor el nombre
     * del alumno, o materia que el usuario desea buscar en la tabla.
     */
    public void cargar(String valor) {

        String[] titulos = {"iD", "Nombre", "Materia", "Calif 1", "Calif 2"};
        String[] registros = new String[5];

        String sql = "SELECT * FROM alumno where CONCAT(nomAlumno,' ',materia) LIKE '%" + valor + "%'";

        model = new DefaultTableModel(null, titulos);

        conectar cc = new conectar();
        Connection cn = cc.conexion();
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("IdAlumno");
                registros[1] = rs.getString("nomAlumno");
                registros[2] = rs.getString("materia");
                registros[3] = rs.getString("caliUnoMateria");
                registros[4] = rs.getString("caliDosMateria");
                model.addRow(registros);
            }
            tblDatos.setModel(model);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errorsini cargando tabla que muestra :'v ");
        }
    }

    /**
     * Metodo que limpia las cajas de texto cuando se inicializa la aplicación.
     */
    public void limpiar() {
        txtNomb.setText("");
        txtMate.setText("");
        txtPar1.setText("");
        txtPar2.setText("");
    }

    /**
     * Metodo que bloquea las cajas de texto y botones cuando no se están
     * usando.
     */
    public void bloquear() {
        txtNomb.setEnabled(false);
        txtMate.setEnabled(false);
        txtPar1.setEnabled(false);
        txtPar2.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }

    /**
     * Metodo que desbloquea las cajas de texto y botones cuando se están
     * usando.
     */
    public void desbloquear() {
        txtNomb.setEnabled(true);
        txtMate.setEnabled(true);
        txtPar1.setEnabled(true);
        txtPar2.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "Convert2Lambda"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomb = new javax.swing.JTextField();
        txtMate = new javax.swing.JTextField();
        txtPar1 = new javax.swing.JTextField();
        txtPar2 = new javax.swing.JTextField();
        btnCalc = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblResul = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnProfes = new javax.swing.JButton();
        btnReseProfes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        txtBuscarAux = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculador de Calificaciones ADREC");
        setBackground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 0)));

        jLabel1.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("N o m b r e");

        jLabel2.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("M a t e r i a");

        jLabel3.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("1 e r   P a r c i a l");

        jLabel4.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("2 d o   P a r c i a l");

        txtNomb.setBackground(new java.awt.Color(102, 102, 102));
        txtNomb.setForeground(new java.awt.Color(0, 255, 0));
        txtNomb.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        txtNomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombActionPerformed(evt);
            }
        });

        txtMate.setBackground(new java.awt.Color(102, 102, 102));
        txtMate.setForeground(new java.awt.Color(0, 255, 0));
        txtMate.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        txtMate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMateActionPerformed(evt);
            }
        });

        txtPar1.setBackground(new java.awt.Color(102, 102, 102));
        txtPar1.setForeground(new java.awt.Color(0, 255, 0));
        txtPar1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        txtPar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPar1ActionPerformed(evt);
            }
        });
        txtPar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPar1KeyTyped(evt);
            }
        });

        txtPar2.setBackground(new java.awt.Color(102, 102, 102));
        txtPar2.setForeground(new java.awt.Color(0, 255, 0));
        txtPar2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        txtPar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPar2ActionPerformed(evt);
            }
        });
        txtPar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPar2KeyTyped(evt);
            }
        });

        btnCalc.setBackground(new java.awt.Color(0, 255, 51));
        btnCalc.setFont(new java.awt.Font("! PEPSI !", 0, 10)); // NOI18N
        btnCalc.setForeground(new java.awt.Color(102, 102, 102));
        btnCalc.setText("Calcular Calificación Necesaria");
        btnCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("D a t o s :");

        jLabel5.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("A");

        jLabel8.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("D");

        jLabel9.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("R");

        jLabel10.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("E");

        jLabel11.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("C");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\cxmar\\Pictures\\Logos\\ADREC\\LOGOpeque.png")); // NOI18N
        jLabel12.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCalc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPar2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)))
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnNuevo)
                .addGap(27, 27, 27)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btnCalc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 0)));

        lblResul.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        lblResul.setForeground(new java.awt.Color(102, 102, 102));
        lblResul.setText("I n t r o d u c e   l o s   v a l o r e s   c o r r e s p o n d i e n t e s");

        jLabel7.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("R e s u l t a d o s");

        btnProfes.setText("Profesores");
        btnProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfesActionPerformed(evt);
            }
        });

        btnReseProfes.setText("Reseñas de Profesores");
        btnReseProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReseProfesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblResul, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                        .addGap(50, 50, 50)
                        .addComponent(btnReseProfes)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProfes)
                        .addGap(36, 36, 36))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfes))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnReseProfes)
                        .addContainerGap(38, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResul)
                        .addGap(30, 30, 30))))
        );

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        txtBuscarAux.setText("Buscar Resgistro:)");
        txtBuscarAux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAuxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBuscarAux, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param cali1 variable que almacena la primer calificación.
     * @param cali2 variable que almacena la segunda calificación.
     * @param cali3 variable que almacena la calificación generada por cali1 y
     * cali2.
     * @param resu variable que alimina digitos extra de cali3.
     * @param nomb variable que recibe el nombre del alumno de la caja de texto
     * txtNomb.
     * @param mate variable que recibe el nombre de la materia de la caja de
     * texto txtMate.
     */
    private void btnCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcActionPerformed

    }//GEN-LAST:event_btnCalcActionPerformed

    private void txtPar1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPar1KeyTyped
        char ent = evt.getKeyChar();

        if ((ent < '0' || ent > '9') && (ent != '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPar1KeyTyped

    private void txtPar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPar2KeyTyped
        char ent = evt.getKeyChar();

        if ((ent < '0' || ent > '9') && (ent != '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPar2KeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        txtNomb.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        bloquear();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombActionPerformed
        // TODO add your handling code here:
        txtNomb.transferFocus();
    }//GEN-LAST:event_txtNombActionPerformed

    private void txtMateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMateActionPerformed
        // TODO add your handling code here:
        txtMate.transferFocus();
    }//GEN-LAST:event_txtMateActionPerformed

    private void txtPar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPar1ActionPerformed
        // TODO add your handling code here:
        txtPar1.transferFocus();
    }//GEN-LAST:event_txtPar1ActionPerformed

    private void txtPar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPar2ActionPerformed
        // TODO add your handling code here:
        txtPar2.transferFocus();
    }//GEN-LAST:event_txtPar2ActionPerformed

    private void txtBuscarAuxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarAuxKeyReleased
        // TODO add your handling code here:
        cargar(txtBuscarAux.getText());
    }//GEN-LAST:event_txtBuscarAuxKeyReleased

    private void btnProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfesActionPerformed

        // Enums
        for (escuela maestros : escuela.values()) {

            System.out.printf("El catedratico %s da %s, y lleva %d años dando clase.\n",
                maestros, maestros.getMateria(), maestros.getTiempoImpartiendo());
            System.out.println("  ------");
        }

    }//GEN-LAST:event_btnProfesActionPerformed

    private void btnReseProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReseProfesActionPerformed

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

    }//GEN-LAST:event_btnReseProfesActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCalc;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProfes;
    private javax.swing.JButton btnReseProfes;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblResul;
    private javax.swing.JTable tblDatos;
    public javax.swing.JTextField txtBuscarAux;
    public javax.swing.JTextField txtMate;
    public javax.swing.JTextField txtNomb;
    public javax.swing.JTextField txtPar1;
    public javax.swing.JTextField txtPar2;
    // End of variables declaration//GEN-END:variables
}
