package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.Controlador;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

public class ClienteView extends JInternalFrame {
    private JTextField nombreField, apellidoField, telefonoField, emailField;
    private JButton registrarButton, eliminarButton;

    public ClienteView() {
        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);
        setResizable(true);

        nombreField = new JTextField(20);
        apellidoField = new JTextField(20);
        telefonoField = new JTextField(20);
        emailField = new JTextField(20);

        registrarButton = new JButton("Guardar");
        eliminarButton = new JButton("Eliminar");

        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String telefono = telefonoField.getText();
                String email = emailField.getText();
                
                Cliente cliente = new Cliente(0, nombre, apellido, telefono, email);
                Controlador controlador = new Controlador();
                try {
                    controlador.registrarCliente(cliente);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                Controlador controlador = new Controlador();
                try {
                    controlador.eliminarCliente(nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Apellido:"));
        add(apellidoField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(new JLabel("Email:"));
        add(emailField);
        add(registrarButton);
        add(eliminarButton);
    }
}
