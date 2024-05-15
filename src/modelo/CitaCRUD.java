package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CitaCRUD {
    private final Connection conexion;

    public CitaCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    public CitaCRUD() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

// Método para insertar una nueva cita en la base de datos
    public void insertarCita(Cita cita) throws SQLException {
        String query = "INSERT INTO cita (cliente_id, barbero_id, estado_cita, fecha_hora) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, cita.getClienteId());
            stmt.setInt(2, cita.getBarberoId());
            stmt.setString(3, cita.getEstadoCita());
            stmt.setObject(4, cita.getFechaHora());
            stmt.executeUpdate();
        }
    }

    // Método para obtener todas las citas de la base de datos
    public List<Cita> obtenerTodasCitas() throws SQLException {
        List<Cita> citas = new ArrayList<>();
        String query = "SELECT * FROM cita";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int clienteId = rs.getInt("cliente_id");
                int barberoId = rs.getInt("barbero_id");
                String estadoCita = rs.getString("estado_cita");
                LocalDateTime fechaHora = rs.getObject("fecha_hora", LocalDateTime.class);
                citas.add(new Cita(id, clienteId, barberoId, estadoCita, fechaHora));
            }
        }
        return citas;
    }

    // Método para actualizar una cita existente en la base de datos
    public void actualizarCita(Cita cita) throws SQLException {
        String query = "UPDATE cita SET cliente_id=?, barbero_id=?, estado_cita=?, fecha_hora=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, cita.getClienteId());
            stmt.setInt(2, cita.getBarberoId());
            stmt.setString(3, cita.getEstadoCita());
            stmt.setObject(4, cita.getFechaHora());
            stmt.setInt(5, cita.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar una cita de la base de datos por su ID
    public void eliminarCita(int id) throws SQLException {
        String query = "DELETE FROM cita WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}