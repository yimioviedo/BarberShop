package controlador;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

public class Controlador {
    private ClienteCRUD clienteCRUD;
    private ProductoCRUD productoCRUD;

    public Controlador() {
        clienteCRUD = new ClienteCRUD(ConexionDB.conectar());
        productoCRUD = new ProductoCRUD(ConexionDB.conectar());
    }

    public void registrarCliente(Cliente cliente) throws java.sql.SQLException {
        clienteCRUD.insertarCliente(cliente);
    }

    public void eliminarCliente(String nombre) throws java.sql.SQLException {
        clienteCRUD.eliminarClientePorNombre(nombre);
    }

    public void registrarProducto(Producto producto) {
        try {
            productoCRUD.insertarProducto(producto);
        } catch (java.sql.SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto(String nombre) throws java.sql.SQLException {
        productoCRUD.eliminarProductoPorNombre(nombre);
    }
}
