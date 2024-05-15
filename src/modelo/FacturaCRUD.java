package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacturaCRUD {
    private final Connection conexion;

    public FacturaCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar una nueva factura en la base de datos
    public void insertarFactura(Factura factura) throws SQLException {
        String query = "INSERT INTO factura (cliente_id, producto_id, servicio_prestado, fecha_hora, total) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, factura.getClienteId());
            stmt.setInt(2, factura.getProductoId());
            stmt.setString(3, factura.getServicioPrestado());
            stmt.setObject(4, factura.getFechaHora());
            stmt.setDouble(5, factura.getTotal());
            stmt.executeUpdate();
        }
    }

    // Método para obtener todas las facturas de la base de datos
    public List<Factura> obtenerTodasFacturas() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        String query = "SELECT * FROM factura";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                int productoId = rs.getInt("producto_id");
                String servicioPrestado = rs.getString("servicio_prestado");
                LocalDateTime fechaHora = rs.getObject("fecha_hora", LocalDateTime.class);
                double total = rs.getDouble("total");
                facturas.add(new Factura(id, clienteId, productoId, servicioPrestado, fechaHora, total));
            }
        }
        return facturas;
    }

    // Método para actualizar una factura existente en la base de datos
    public void actualizarFactura(Factura factura) throws SQLException {
        String query = "UPDATE factura SET cliente_id=?, producto_id=?, servicio_prestado=?, fecha_hora=?, total=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, factura.getClienteId());
            stmt.setInt(2, factura.getProductoId());
            stmt.setString(3, factura.getServicioPrestado());
            stmt.setObject(4, factura.getFechaHora());
            stmt.setDouble(5, factura.getTotal());
            stmt.setInt(6, factura.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar una factura de la base de datos por su ID
    public void eliminarFactura(int id) throws SQLException {
        String query = "DELETE FROM factura WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
    

