package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Datos de conexión a la base de datos barber_shop
    private static final String URL = "jdbc:mysql://localhost:3306/barber_shop";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conectar()throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS); 
    }

    // Método para establecer la conexión
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("¡Conexión a la base de datos barber_shop exitosa!");
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
            System.out.println("Conexión a la base de datos cerrada.");
        }
    }
}
    
    
    
    
    
    