package vista;

import controlador.Controlador;
import modelo.Cita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CitaView extends JFrame {
    private final Controlador controlador;
    private JTextField clienteIdField, fechaField, horaField, descripcionField;
    private JTextArea displayArea;

    public CitaView(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Gestión de Citas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Cliente ID:"));
        clienteIdField = new JTextField();
        inputPanel.add(clienteIdField);

        inputPanel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        fechaField = new JTextField();
        inputPanel.add(fechaField);

        inputPanel.add(new JLabel("Hora (HH:MM):"));
        horaField = new JTextField();
        inputPanel.add(horaField);

        inputPanel.add(new JLabel("Descripción:"));
        descripcionField = new JTextField();
        inputPanel.add(descripcionField);

        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCita();
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
                mostrarCitas();
            }
        });
        panel.add(actualizarBtn, BorderLayout.SOUTH);

        add(panel);
        mostrarCitas();
    }

    private void agregarCita() {
        try {
            int clienteId = Integer.parseInt(clienteIdField.getText());
            String fecha = fechaField.getText();
            String hora = horaField.getText();
            String descripcion = descripcionField.getText();

            Cita cita = new Cita(clienteId, fecha, hora, descripcion);
            controlador.agregarCita(cita);
            mostrarCitas();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al agregar cita: " + e.getMessage());
        }
    }

    private void mostrarCitas() {
        try {
            List<Cita> citas = controlador.obtenerTodasLasCitas();
            displayArea.setText("");
            for (Cita cita : citas) {
                displayArea.append(cita.toString() + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al mostrar citas: " + e.getMessage());
        }
    }
}
    

