package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarberoCRUD {
    private final Connection conexion;

    public BarberoCRUD(Connection conexion) {
        this.conexion = conexion;
    }

    // Método para insertar un nuevo barbero en la base de datos
    public void insertarBarbero(Barbero barbero) throws SQLException {
        String query = "INSERT INTO barbero (nombre, apellido, especialidad, email, telefono) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, barbero.getNombre());
            stmt.setString(2, barbero.getApellido());
            stmt.setString(3, barbero.getEspecialidad());
            stmt.setString(4, barbero.getEmail());
            stmt.setString(5, barbero.getTelefono());
            stmt.executeUpdate();
        }
    }

    // Método para obtener todos los barberos de la base de datos
    public List<Barbero> obtenerTodosBarberos() throws SQLException {
        List<Barbero> barberos = new ArrayList<>();
        String query = "SELECT * FROM barbero";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String especialidad = rs.getString("especialidad");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                barberos.add(new Barbero(id, nombre, apellido, especialidad, email, telefono));
            }
        }
        return barberos;
    }

    // Método para actualizar un barbero existente en la base de datos
    public void actualizarBarbero(Barbero barbero) throws SQLException {
        String query = "UPDATE barbero SET nombre=?, apellido=?, especialidad=?, email=?, telefono=? WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, barbero.getNombre());
            stmt.setString(2, barbero.getApellido());
            stmt.setString(3, barbero.getEspecialidad());
            stmt.setString(4, barbero.getEmail());
            stmt.setString(5, barbero.getTelefono());
            stmt.setInt(6, barbero.getId());
            stmt.executeUpdate();
        }
    }

    // Método para eliminar un barbero de la base de datos por su ID
    public void eliminarBarbero(int id) throws SQLException {
        String query = "DELETE FROM barbero WHERE id=?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void insertar(Barbero barbero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    

