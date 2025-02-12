/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author river
 */
public class Crear_Cuenta {
    
    public void Crear_Cuenta() {
        
        JFrame pantalla = new JFrame("Crear Cuenta");
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

        JPanel crear_cuenta = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        crear_cuenta.setLayout(new BoxLayout(crear_cuenta, BoxLayout.Y_AXIS));

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

        JButton Signup = new JButton("Crear Cuenta");
        Signup.setBackground(Color.YELLOW);
        Signup.setAlignmentX(Component.CENTER_ALIGNMENT);
        Signup.setFont(new Font("Arial", Font.BOLD, 20));

        Signup.addActionListener(e -> {
            Player jugador_nuevo = Jugadores.juego.crear_jugador(username.getText(), contraseña.getText());
            
            if (jugador_nuevo == null) {
                username.setText("");
                contraseña.setText("");
            } else {
                pantalla.dispose();
                Menu_Inicio menu = new Menu_Inicio();
                menu.Menu_Inicio();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(Signup, gbc);

        crear_cuenta.add(topPanel);
        crear_cuenta.add(Box.createVerticalStrut(13));
        crear_cuenta.add(titulo);
        crear_cuenta.add(Box.createVerticalStrut(30));
        crear_cuenta.add(formPanel);
        crear_cuenta.add(Box.createVerticalStrut(10));
        crear_cuenta.add(Signup);
        crear_cuenta.add(Box.createVerticalStrut(50));

        pantalla.add(crear_cuenta);
        pantalla.setVisible(true);
    }   
}
