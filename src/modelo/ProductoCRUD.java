package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoCRUD {
    private Connection conexion;

    public ProductoCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarProducto(Producto producto) throws SQLException {
        String query = "INSERT INTO producto (proveedor_id, nombre_producto, descripcion, precio, stock) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, producto.getProveedorId());
            stmt.setString(2, producto.getNombreProducto());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.executeUpdate();
        }
    }

    public void eliminarProductoPorNombre(String nombre) throws SQLException {
        String query = "DELETE FROM producto WHERE nombre_producto=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        }
    }
}
    

