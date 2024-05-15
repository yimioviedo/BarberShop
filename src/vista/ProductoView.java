package vista;

import controlador.Controlador;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ProductoView extends JFrame {
    private final Controlador controlador;
    private JTextField nombreField, precioField, stockField;
    private JTextArea displayArea;

    public ProductoView(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Productos");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        inputPanel.add(nombreField);

        inputPanel.add(new JLabel("Precio:"));
        precioField = new JTextField();
        inputPanel.add(precioField);

        inputPanel.add(new JLabel("Stock:"));
        stockField = new JTextField();
        inputPanel.add(stockField);

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        inputPanel.add(agregarBtn);

        panel.add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });
        panel.add(actualizarBtn, BorderLayout.SOUTH);

        add(panel);
        mostrarProductos();
    }

    private void agregarProducto() {
        try {
            String nombre = nombreField.getText();
            double precio = Double.parseDouble(precioField.getText());
            int stock = Integer.parseInt(stockField.getText());

            Producto producto = new Producto(nombre, precio, stock);
            controlador.agregarProducto(producto);
            mostrarProductos();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar producto: " + e.getMessage());
        }
    }

    private void mostrarProductos() {
        try {
            List<Producto> productos = controlador.obtenerTodosLosProductos();
            displayArea.setText("");
            for (Producto producto : productos) {
                displayArea.append(producto.toString() + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar productos: " + e.getMessage());
        }
    }
}
    

