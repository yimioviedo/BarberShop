package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompraCRUD {
    private final Connection conexion;

    public CompraCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar una nueva compra en la base de datos
    public void insertarCompra(Compra compra) throws SQLException {
        String query = "INSERT INTO compra (proveedor_id, producto_id, cantidad, precio_unitario, fecha_compra) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, compra.getProveedorId());
            stmt.setInt(2, compra.getProductoId());
            stmt.setInt(3, compra.getCantidad());
            stmt.setDouble(4, compra.getPrecioUnitario());
            stmt.setObject(5, compra.getFechaCompra());
            stmt.executeUpdate();
        }
    }

    // Método para obtener todas las compras de la base de datos
    public List<Compra> obtenerTodasCompras() throws SQLException {
        List<Compra> compras = new ArrayList<>();
        String query = "SELECT * FROM compra";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int proveedorId = rs.getInt("proveedor_id");
                int productoId = rs.getInt("producto_id");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                LocalDate fechaCompra = rs.getObject("fecha_compra", LocalDate.class);
                compras.add(new Compra(id, proveedorId, productoId, cantidad, precioUnitario, fechaCompra));
            }
        }
        return compras;
    }

    // Método para actualizar una compra existente en la base de datos
    public void actualizarCompra(Compra compra) throws SQLException {
        String query = "UPDATE compra SET proveedor_id=?, producto_id=?, cantidad=?, precio_unitario=?, fecha_compra=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, compra.getProveedorId());
            stmt.setInt(2, compra.getProductoId());
            stmt.setInt(3, compra.getCantidad());
            stmt.setDouble(4, compra.getPrecioUnitario());
            stmt.setObject(5, compra.getFechaCompra());
            stmt.setInt(6, compra.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar una compra de la base de datos por su ID
    public void eliminarCompra(int id) throws SQLException {
        String query = "DELETE FROM compra WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
    

