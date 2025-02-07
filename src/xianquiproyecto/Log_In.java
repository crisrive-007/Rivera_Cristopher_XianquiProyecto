/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author river
 */
public class Log_In {

    public void Log_In() {

        JFrame pantalla = new JFrame("Inicio de Sesion");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(500, 400);
        pantalla.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton salir = new JButton("Salir");
        salir.setBackground(Color.YELLOW);
        salir.setForeground(Color.BLACK);
        salir.setFont(new Font("Arial", Font.BOLD, 14));
        salir.addActionListener(e -> {
            Menu_Inicio menu = new Menu_Inicio();
            menu.Menu_Inicio();
            pantalla.dispose();
        });
        topPanel.add(salir);
        topPanel.setOpaque(false);

        JPanel log_in = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        log_in.setLayout(new BoxLayout(log_in, BoxLayout.Y_AXIS));

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/XIANGQI.PNG"));
        Image imagen = icon.getImage().getScaledInstance(300, 85, Image.SCALE_SMOOTH);
        JLabel titulo = new JLabel(new ImageIcon(imagen));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsername = new JLabel("Nombre de usuario:");
        lblUsername.setForeground(Color.YELLOW);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 20));
        JTextField username = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblUsername, gbc);

        gbc.gridx = 1;
        formPanel.add(username, gbc);

        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setForeground(Color.YELLOW);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
        JPasswordField contraseña = new JPasswordField(15);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblPassword, gbc);

        gbc.gridx = 1;
        formPanel.add(contraseña, gbc);

        JButton Login = new JButton("Iniciar Sesión");
        Login.setBackground(Color.YELLOW);
        Login.setAlignmentX(Component.CENTER_ALIGNMENT);
        Login.setFont(new Font("Arial", Font.BOLD, 20));

        Login.addActionListener(e -> {
            Player jugador = Registro.juego.inicio_sesion(0, username.getText(), new String(contraseña.getPassword()));

            if (jugador == null) {
                username.setText("");
                contraseña.setText("");
            } else {
                pantalla.dispose();
                Menu_Principal menu = new Menu_Principal();
                menu.Menu_Principal();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(Login, gbc);

        log_in.add(topPanel);
        log_in.add(Box.createVerticalStrut(13));
        log_in.add(titulo);
        log_in.add(Box.createVerticalStrut(30));
        log_in.add(formPanel);
        log_in.add(Box.createVerticalStrut(10));
        log_in.add(Login);
        log_in.add(Box.createVerticalStrut(50));

        pantalla.add(log_in, BorderLayout.CENTER);
        pantalla.setVisible(true);
    }
}
