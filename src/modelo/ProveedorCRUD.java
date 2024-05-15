package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorCRUD {
    private final Connection conexion;

    public ProveedorCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo proveedor en la base de datos
    public void insertarProveedor(Proveedor proveedor) throws SQLException {
        String query = "INSERT INTO proveedor (nombre_empresa, nombre_contacto, email, telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, proveedor.getNombreEmpresa());
            stmt.setString(2, proveedor.getNombreContacto());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getTelefono());
            stmt.executeUpdate();
        }
    }

    // Método para obtener todos los proveedores de la base de datos
    public List<Proveedor> obtenerTodosProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT * FROM proveedor";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombreEmpresa = rs.getString("nombre_empresa");
                String nombreContacto = rs.getString("nombre_contacto");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                proveedores.add(new Proveedor(id, nombreEmpresa, nombreContacto, email, telefono));
            }
        }
        return proveedores;
    }

    // Método para actualizar un proveedor existente en la base de datos
    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        String query = "UPDATE proveedor SET nombre_empresa=?, nombre_contacto=?, email=?, telefono=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, proveedor.getNombreEmpresa());
            stmt.setString(2, proveedor.getNombreContacto());
            stmt.setString(3, proveedor.getEmail());
            stmt.setString(4, proveedor.getTelefono());
            stmt.setInt(5, proveedor.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un proveedor de la base de datos por su ID
    public void eliminarProveedor(int id) throws SQLException {
        String query = "DELETE FROM proveedor WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

    

