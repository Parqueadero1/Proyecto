
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Implementacion Patron de diseño singlenton y conexion a la base de datos
 *
 * @author Paula
 */
public class Conexion {

    private static Connection conn;

    private Conexion() {
    }

    /**
     * Obtener la conexion de la base de datos por medio del driver de mysql
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueadero?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "admin");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
}