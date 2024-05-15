package vista;

import controlador.Controlador;
import modelo.Factura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class FacturaView extends JFrame {
    private final Controlador controlador;
    private JTextField clienteIdField, totalField, fechaField;
    private JTextArea displayArea;

    public FacturaView(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Facturas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("ID Cliente:"));
        clienteIdField = new JTextField();
        inputPanel.add(clienteIdField);

        inputPanel.add(new JLabel("Total:"));
        totalField = new JTextField();
        inputPanel.add(totalField);

        inputPanel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        fechaField = new JTextField();
        inputPanel.add(fechaField);

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener((ActionEvent e) -> {
            agregarFactura();
        });
        inputPanel.add(agregarBtn);

        panel.add(inputPanel, BorderLayout.NORTH);

        displayArea = new JTextArea();
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JButton actualizarBtn = new JButton("Actualizar");
        actualizarBtn.addActionListener((ActionEvent e) -> {
            mostrarFacturas();
        });
        panel.add(actualizarBtn, BorderLayout.SOUTH);

        add(panel);
        mostrarFacturas();
    }

    private void agregarFactura() {
        int clienteId = Integer.parseInt(clienteIdField.getText());
        double total = Double.parseDouble(totalField.getText());
        String fecha = fechaField.getText();
        Factura factura = new Factura(clienteId, total, fecha);
        controlador.agregarFactura(factura);
        mostrarFacturas();
    }

    private void mostrarFacturas() {
        List<Factura> facturas = controlador.obtenerTodasLasFacturas();
        displayArea.setText("");
        for (Factura factura : facturas) {
            displayArea.append(factura.toString() + "\n");
        }
    }
}
    

