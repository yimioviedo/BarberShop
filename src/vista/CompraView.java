package vista;

import controlador.Controlador;
import modelo.Compra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CompraView extends JFrame {
     private final Controlador controlador;
    private JTextField productoIdField, proveedorIdField, cantidadField, fechaField;
    private JTextArea displayArea;

    public CompraView(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID Producto:"));
        productoIdField = new JTextField();
        inputPanel.add(productoIdField);

        inputPanel.add(new JLabel("ID Proveedor:"));
        proveedorIdField = new JTextField();
        inputPanel.add(proveedorIdField);

        inputPanel.add(new JLabel("Cantidad:"));
        cantidadField = new JTextField();
        inputPanel.add(cantidadField);

        inputPanel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        fechaField = new JTextField();
        inputPanel.add(fechaField);

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCompra();
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
                mostrarCompras();
            }
        });
        panel.add(actualizarBtn, BorderLayout.SOUTH);

        add(panel);
        mostrarCompras();
    }

    private void agregarCompra() {
        try {
            int productoId = Integer.parseInt(productoIdField.getText());
            int proveedorId = Integer.parseInt(proveedorIdField.getText());
            int cantidad = Integer.parseInt(cantidadField.getText());
            String fecha = fechaField.getText();

            Compra compra = new Compra(productoId, proveedorId, cantidad, fecha);
            controlador.agregarCompra(compra);
            mostrarCompras();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar compra: " + e.getMessage());
        }
    }

    private void mostrarCompras() {
        try {
            List<Compra> compras = controlador.obtenerTodasLasCompras();
            displayArea.setText("");
            for (Compra compra : compras) {
                displayArea.append(compra.toString() + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar compras: " + e.getMessage());
        }
    }
}
    

