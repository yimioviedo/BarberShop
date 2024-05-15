package controlador;

import modelo.*;
import vista.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Controlador {
    private Connection conexion;
    private ClienteCRUD clienteCRUD;
    private CitaCRUD citaCRUD;
    private ProductoCRUD productoCRUD;
    private ProveedorCRUD proveedorCRUD;
    private CompraCRUD compraCRUD;
    private BarberoCRUD barberoCRUD;
    private FacturaCRUD facturaCRUD;

    public Controlador() {
        inicializarConexion();
        inicializarCRUD();
    }

    private void inicializarConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306//barber_shop", "USER", "PASS");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    private void inicializarCRUD() {
        clienteCRUD = new ClienteCRUD(conexion);
        citaCRUD = new CitaCRUD(conexion);
        productoCRUD = new ProductoCRUD(conexion);
        proveedorCRUD = new ProveedorCRUD(conexion);
        compraCRUD = new CompraCRUD(conexion);
        barberoCRUD = new BarberoCRUD(conexion);
        facturaCRUD = new FacturaCRUD(conexion);
    }

    // Métodos para gestionar clientes, citas, productos, proveedores, compras, barberos, facturas
    // (omitiendo para brevedad)

    public void agregarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Cliente> obtenerTodosLosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}