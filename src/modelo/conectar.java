package modelo;

import java.sql.*;
import javax.swing.*;

/**
 * Clase para realizar una conexión a SQL con localhost
 *
 * @author CxMars
 */
public class conectar {

    Connection conect = null;

    /**
     * metodo Connection, que realiza la conexión
     *
     * @return regresa la conexión
     */
    public Connection conexion() {
        try {
            //Cargamos el Driver MySQL
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("org.gjt.mm.mysql.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/bdadrec", "root", "");
            System.out.println("conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error de conexion");
            JOptionPane.showMessageDialog(null, "Error de conexion" + e);
        }
        return conect;
    }

}
