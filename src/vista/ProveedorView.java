package vista;

import controlador.Controlador;
import modelo.Proveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class ProveedorView extends JFrame {
    private final Controlador controlador;
    private JTextField nombreEmpresaField, nombreContactoField, emailField, telefonoField;
    private JTextArea displayArea;

    public ProveedorView(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Proveedores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nombre Empresa:"));
        nombreEmpresaField = new JTextField();
        inputPanel.add(nombreEmpresaField);

        inputPanel.add(new JLabel("Nombre Contacto:"));
        nombreContactoField = new JTextField();
        inputPanel.add(nombreContactoField);

        inputPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        inputPanel.add(emailField);

        inputPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        inputPanel.add(telefonoField);

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProveedor();
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
                mostrarProveedores();
            }
        });
        panel.add(actualizarBtn, BorderLayout.SOUTH);

        add(panel);
        mostrarProveedores();
    }

    private void agregarProveedor() {
        try {
            String nombreEmpresa = nombreEmpresaField.getText();
            String nombreContacto = nombreContactoField.getText();
            String email = emailField.getText();
            String telefono = telefonoField.getText();

            Proveedor proveedor = new Proveedor(nombreEmpresa, nombreContacto, email, telefono);
            controlador.agregarProveedor(proveedor);
            mostrarProveedores();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar proveedor: " + e.getMessage());
        }
    }

    private void mostrarProveedores() {
        try {
            List<Proveedor> proveedores = controlador.obtenerTodosLosProveedores();
            displayArea.setText("");
            for (Proveedor proveedor : proveedores) {
                displayArea.append(proveedor.toString() + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar proveedores: " + e.getMessage());
        }
    }
}

    

