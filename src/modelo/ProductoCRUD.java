package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoCRUD {
    private final Connection conexion;

    public ProductoCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public ProductoCRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para insertar un nuevo producto en la base de datos
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

    // Método para obtener todos los productos de la base de datos
    public List<Producto> obtenerTodosProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int proveedorId = rs.getInt("proveedor_id");
                String nombreProducto = rs.getString("nombre_producto");
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                productos.add(new Producto(id, proveedorId, nombreProducto, descripcion, precio, stock));
            }
        }
        return productos;
    }

    // Método para actualizar un producto existente en la base de datos
    public void actualizarProducto(Producto producto) throws SQLException {
        String query = "UPDATE producto SET proveedor_id=?, nombre_producto=?, descripcion=?, precio=?, stock=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, producto.getProveedorId());
            stmt.setString(2, producto.getNombreProducto());
            stmt.setString(3, producto.getDescripcion());
            stmt.setDouble(4, producto.getPrecio());
            stmt.setInt(5, producto.getStock());
            stmt.setInt(6, producto.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un producto de la base de datos por su ID
    public void eliminarProducto(int id) throws SQLException {
        String query = "DELETE FROM producto WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

    

