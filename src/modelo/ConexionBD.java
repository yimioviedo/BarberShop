package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    // Datos de conexión a la base de datos barber_shop
    private static final String URL = "jdbc:mysql://localhost:3306/barber_shop";
    private static final String USER = "root";
    private static final String PASS = "";
    

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar con la base de datos", e);
        }
    }
}
    
    
    