package controlador;

import modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Controlador {
    private final ClienteCRUD clienteCRUD;
    private final BarberoCRUD barberoCRUD;
    private final CitaCRUD citaCRUD;
    private final ProductoCRUD productoCRUD;
    private final CompraCRUD compraCRUD;
    private final FacturaCRUD facturaCRUD;
    private final ProveedorCRUD proveedorCRUD;

    public Controlador(Connection conexion) {
        this.clienteCRUD = new ClienteCRUD(conexion);
        this.barberoCRUD = new BarberoCRUD(conexion);
        this.citaCRUD = new CitaCRUD(conexion);
        this.productoCRUD = new ProductoCRUD(conexion);
        this.compraCRUD = new CompraCRUD(conexion);
        this.facturaCRUD = new FacturaCRUD(conexion);
        this.proveedorCRUD = new ProveedorCRUD(conexion);
    }

    // Métodos CRUD para Cliente
    public void insertarCliente(Cliente cliente) throws SQLException {
        clienteCRUD.insertarCliente(cliente);
    }

    public List<Cliente> obtenerTodosClientes() throws SQLException {
        return clienteCRUD.obtenerTodosClientes();
    }

    public void actualizarCliente(Cliente cliente) throws SQLException {
        clienteCRUD.actualizarCliente(cliente);
    }

    public void eliminarCliente(int id) throws SQLException {
        clienteCRUD.eliminarCliente(id);
    }

    // Métodos CRUD para Barbero
    public void insertarBarbero(Barbero barbero) throws SQLException {
        barberoCRUD.insertarBarbero(barbero);
    }

    public List<Barbero> obtenerTodosBarberos() throws SQLException {
        return barberoCRUD.obtenerTodosBarberos();
    }

    public void actualizarBarbero(Barbero barbero) throws SQLException {
        barberoCRUD.actualizarBarbero(barbero);
    }

    public void eliminarBarbero(int id) throws SQLException {
        barberoCRUD.eliminarBarbero(id);
    }

    // Métodos CRUD para Cita
    public void insertarCita(Cita cita) throws SQLException {
        citaCRUD.insertarCita(cita);
    }

    public List<Cita> obtenerTodasCitas() throws SQLException {
        return citaCRUD.obtenerTodasCitas();
    }

    public void actualizarCita(Cita cita) throws SQLException {
        citaCRUD.actualizarCita(cita);
    }

    public void eliminarCita(int id) throws SQLException {
        citaCRUD.eliminarCita(id);
    }

    // Métodos CRUD para Producto
    public void insertarProducto(Producto producto) throws SQLException {
        productoCRUD.insertarProducto(producto);
    }

    public List<Producto> obtenerTodosProductos() throws SQLException {
        return productoCRUD.obtenerTodosProductos();
    }

    public void actualizarProducto(Producto producto) throws SQLException {
        productoCRUD.actualizarProducto(producto);
    }

    public void eliminarProducto(int id) throws SQLException {
        productoCRUD.eliminarProducto(id);
    }

    // Métodos CRUD para Compra
    public void insertarCompra(Compra compra) throws SQLException {
        compraCRUD.insertarCompra(compra);
    }

    public List<Compra> obtenerTodasCompras() throws SQLException {
        return compraCRUD.obtenerTodasCompras();
    }

    public void actualizarCompra(Compra compra) throws SQLException {
        compraCRUD.actualizarCompra(compra);
    }

    public void eliminarCompra(int id) throws SQLException {
        compraCRUD.eliminarCompra(id);
    }

    // Métodos CRUD para Factura
    public void insertarFactura(Factura factura) throws SQLException {
        facturaCRUD.insertarFactura(factura);
    }

    public List<Factura> obtenerTodasFacturas() throws SQLException {
        return facturaCRUD.obtenerTodasFacturas();
    }

    public void actualizarFactura(Factura factura) throws SQLException {
        facturaCRUD.actualizarFactura(factura);
    }

    public void eliminarFactura(int id) throws SQLException {
        facturaCRUD.eliminarFactura(id);
    }

    // Métodos CRUD para Proveedor
    public void insertarProveedor(Proveedor proveedor) throws SQLException {
        proveedorCRUD.insertarProveedor(proveedor);
    }

    public List<Proveedor> obtenerTodosProveedores() throws SQLException {
        return proveedorCRUD.obtenerTodosProveedores();
    }

    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        proveedorCRUD.actualizarProveedor(proveedor);
    }

    public void eliminarProveedor(int id) throws SQLException {
        proveedorCRUD.eliminarProveedor(id);
    }
}

