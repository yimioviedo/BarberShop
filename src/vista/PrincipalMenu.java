package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalMenu extends JFrame {
    private JDesktopPane desktopPane;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItemClientes;
    private JMenuItem menuItemProductos;

    public PrincipalMenu() {
        setTitle("Barbería Luan Barber Shop");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        menuBar = new JMenuBar();
        menu = new JMenu("Registrar");
        menuItemClientes = new JMenuItem("Gestionar Clientes");
        menuItemProductos = new JMenuItem("Gestionar Productos");

        menuItemClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClienteView clienteView = new ClienteView();
                desktopPane.add(clienteView);
                clienteView.setVisible(true);
            }
        });

        menuItemProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductoView productoView = new ProductoView();
                desktopPane.add(productoView);
                productoView.setVisible(true);
            }
        });

        menu.add(menuItemClientes);
        menu.add(menuItemProductos);
        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PrincipalMenu frame = new PrincipalMenu();
                frame.setVisible(true);
            }
        });
    }
}

