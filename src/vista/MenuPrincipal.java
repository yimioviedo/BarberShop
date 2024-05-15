package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private final Controlador controlador;

    public MenuPrincipal(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1));

        JButton btnClientes = new JButton("Gestionar Clientes");
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteView clienteView = new ClienteView(controlador);
                clienteView.setVisible(true);
            }
        });
        panel.add(btnClientes);

        JButton btnCitas = new JButton("Gestionar Citas");
        btnCitas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CitaView citaView = new CitaView(controlador);
                citaView.setVisible(true);
            }
        });
        panel.add(btnCitas);

        JButton btnProductos = new JButton("Gestionar Productos");
        btnProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoView productoView = new ProductoView(controlador);
                productoView.setVisible(true);
            }
        });
        panel.add(btnProductos);

        JButton btnProveedores = new JButton("Gestionar Proveedores");
        btnProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProveedorView proveedorView = new ProveedorView(controlador);
                proveedorView.setVisible(true);
            }
        });
        panel.add(btnProveedores);

        JButton btnCompras = new JButton("Gestionar Compras");
        btnCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CompraView compraView = new CompraView(controlador);
                compraView.setVisible(true);
            }
        });
        panel.add(btnCompras);

        JButton btnBarberos = new JButton("Gestionar Barberos");
        btnBarberos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BarberoView barberoView = new BarberoView(controlador);
                barberoView.setVisible(true);
            }
        });
        panel.add(btnBarberos);

        JButton btnFacturas = new JButton("Gestionar Facturas");
        btnFacturas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FacturaView facturaView = new FacturaView(controlador);
                facturaView.setVisible(true);
            }
        });
        panel.add(btnFacturas);

        add(panel);
    }
}

    

