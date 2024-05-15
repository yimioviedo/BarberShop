package vista;

import controlador.Controlador;
import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class Vista {
    private final Controlador controlador;
    private final JFrame frame;
    private final DefaultListModel<Cliente> clienteListModel;
    private final JList<Cliente> clienteList;

    public Vista(Controlador controlador) {
        this.controlador = controlador;

        // Configurar el marco principal
        frame = new JFrame("Gestión de Clientes");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Lista de clientes
        clienteListModel = new DefaultListModel<>();
        clienteList = new JList<>(clienteListModel);
        JScrollPane clienteScrollPane = new JScrollPane(clienteList);
        frame.add(clienteScrollPane, BorderLayout.CENTER);

        // Botón para agregar un cliente
        JButton agregarClienteButton = new JButton("Agregar Cliente");
        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    agregarCliente();
                } catch (SQLException ex) {
                    Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame.add(agregarClienteButton, BorderLayout.SOUTH);
    }

    public void iniciar() {
        frame.setVisible(true);
    }

    private void agregarCliente() throws SQLException {
        String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del cliente:");
        String apellido = JOptionPane.showInputDialog(frame, "Ingrese el apellido del cliente:");
        String telefono = JOptionPane.showInputDialog(frame, "Ingrese el teléfono del cliente:");
        String email = JOptionPane.showInputDialog(frame, "Ingrese el email del cliente:");

        // Crear el cliente y agregarlo a la base de datos
        Cliente cliente = new Cliente(nombre, apellido, telefono, email);
        controlador.insertarCliente(cliente);

        // Actualizar la lista de clientes
        actualizarListaClientes();
    }

    private void actualizarListaClientes() throws SQLException {
        clienteListModel.clear();
        List<Cliente> clientes = controlador.obtenerTodosClientes();
        for (Cliente cliente : clientes) {
            clienteListModel.addElement(cliente);
        }
    }
}
    

