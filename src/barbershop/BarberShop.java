package barbershop;

import com.sun.jdi.connect.spi.Connection;
import modelo.ConexionBD;
import java.sql.SQLException;

public class BarberShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
           ConexionBD miConexion = new ConexionBD();

        try {
               java.sql.Connection conn = miConexion.getConnection();

            // Realizar operaciones con la base de datos usando la conexión 'conn'

            miConexion.closeConnection(conn);
        } catch (SQLException ex) {
            System.err.println("Error general: " + ex.getMessage());
        }
    }
}
    
    

