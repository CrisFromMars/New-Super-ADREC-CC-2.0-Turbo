package GUI;

import catedratics.ampaPoli;
import catedratics.amparito;
import catedratics.analu;
import catedratics.blanco;
import catedratics.gameros;
import catedratics.luis;
import formularios.conectar;
import formularios.escuela;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
    void cargar(String valor) {

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
    void limpiar() {
        txtNomb.setText("");
        txtMate.setText("");
        txtPar1.setText("");
        txtPar2.setText("");
    }

    /**
     * Metodo que bloquea las cajas de texto y botones cuando no se están
     * usando.
     */
    void bloquear() {
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
    void desbloquear() {
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
        jPanel2 = new javax.swing.JPanel();
        lblResu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnProfes = new javax.swing.JButton();
        btnReseProfes = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        txtBuscarAux = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

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
        jLabel6.setText("Datos:");

        jLabel5.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("A");

        jLabel8.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("d");

        jLabel9.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("r");

        jLabel10.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("e");

        jLabel11.setFont(new java.awt.Font("! PEPSI !", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("c");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomb, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPar2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(27, 27, 27)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                .addGap(18, 18, 18)
                .addComponent(btnCalc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalir))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 0)));

        lblResu.setFont(new java.awt.Font("! PEPSI !", 0, 14)); // NOI18N
        lblResu.setForeground(new java.awt.Color(102, 102, 102));
        lblResu.setText("I n t r o d u c e   l o s   v a l o r e s   c o r r e s p o n d i e n t e s");

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
                        .addComponent(lblResu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReseProfes)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProfes)
                        .addGap(66, 66, 66))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProfes))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblResu))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReseProfes)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 255, 0)));

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

        txtBuscarAux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarAuxKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("! PEPSI !", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Buscar:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarAux, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        double cali1, cali2, cali3, resu;
        int aux;
        String nomb, mate;
        nomb = txtNomb.getText();
        mate = txtMate.getText();
        cali1 = 0.3 * Double.parseDouble(txtPar1.getText());
        cali2 = 0.3 * Double.parseDouble(txtPar2.getText());

        if ((cali1 < 0 || cali1 > 10)) {
            lblResu.setText("Introduzca valores entre '0' y '10'");
        } else if (cali2 < 0 || cali2 > 10) {
            lblResu.setText("Introduzca valores entre '0' y '10'");
        } else {
            cali3 = (6 - (cali1 + cali2)) / 0.4;

            aux = (int) (cali3 * 100);

            resu = aux / 100d;

            //Lambda
            if (resu <= 10) {
                List<String> datos = new ArrayList<>();
                datos.add(nomb);

                datos.stream().forEach(d
                        -> lblResu.setText(nomb + " sacaste " + txtPar1.getText() + " y " + txtPar2.getText() + ". Necesitas un " + resu + " para pasar.")
                );
            } else if (resu == 0) {
                lblResu.setText("Ya has aprobado el semestre ;)");
            } else if (resu > 10) {
                lblResu.setText("Lo sentimos, Ya no puedes aprobar el semestre :(");
            }
        }


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

    /**
     * Acción que hara la aplicación cuando reciba clic en el botón guardar,
     * basicamente insertar los datos a la base de datos.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        // TODO add your handling code here:
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

    }//GEN-LAST:event_btnGuardarActionPerformed

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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalc;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnProfes;
    private javax.swing.JButton btnReseProfes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResu;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBuscarAux;
    private javax.swing.JTextField txtMate;
    private javax.swing.JTextField txtNomb;
    private javax.swing.JTextField txtPar1;
    private javax.swing.JTextField txtPar2;
    // End of variables declaration//GEN-END:variables
}
