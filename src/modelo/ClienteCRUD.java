package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {
    private final Connection conexion;

    public ClienteCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo cliente en la base de datos
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

    // Método para obtener todos los clientes de la base de datos
    public List<Cliente> obtenerTodosClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                clientes.add(new Cliente(id, nombre, apellido, telefono, email));
            }
        }
        return clientes;
    }

    // Método para actualizar un cliente existente en la base de datos
    public void actualizarCliente(Cliente cliente) throws SQLException {
        String query = "UPDATE cliente SET nombre=?, apellido=?, telefono=?, email=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getId());
            stmt.executeUpdate();
        }
    }

    public void eliminarCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
