package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteCRUD {
    private Connection conexion;

    public ClienteCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.executeUpdate();
        }
    }

    public void eliminarClientePorNombre(String nombre) throws SQLException {
        String query = "DELETE FROM cliente WHERE nombre=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }
}
