package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.Controlador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

public class ProductoView extends JInternalFrame {
    private JTextField nombreField, descripcionField, precioField, stockField;
    private JButton registrarButton, eliminarButton;

    public ProductoView() {
        setTitle("Gestión de Productos");
        setSize(400, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);

        nombreField = new JTextField(20);
        descripcionField = new JTextField(20);
        precioField = new JTextField(20);
        stockField = new JTextField(20);

        registrarButton = new JButton("Guardar");
        eliminarButton = new JButton("Eliminar");

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String descripcion = descripcionField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int stock = Integer.parseInt(stockField.getText());

                Producto producto = new Producto(0, 1, nombre, descripcion, precio, stock);
                Controlador controlador = new Controlador();
                controlador.registrarProducto(producto);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                Controlador controlador = new Controlador();
                try {
                    controlador.eliminarProducto(nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(ProductoView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Descripción:"));
        add(descripcionField);
        add(new JLabel("Precio:"));
        add(precioField);
        add(new JLabel("Stock:"));
        add(stockField);
        add(registrarButton);
        add(eliminarButton);
    }
}
