/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author river
 */
public class Menu_Inicio {
    
    public void Menu_Inicio() {
        
        JFrame pantalla = new JFrame("Xiangqi");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(400, 300);
        pantalla.setLocationRelativeTo(null);

        JPanel menu = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/XIANGQI.PNG"));
        Image imagen = icon.getImage().getScaledInstance(250, 65, Image.SCALE_SMOOTH);
        JLabel titulo = new JLabel(new ImageIcon(imagen));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton log_in = new JButton("Iniciar Sesión");
        log_in.setBackground(Color.YELLOW);
        JButton crear_cuenta = new JButton("Crear Cuenta");
        crear_cuenta.setBackground(Color.YELLOW);
        JButton salir = new JButton("Salir");
        salir.setBackground(Color.YELLOW);

        Dimension buttonSize = new Dimension(150, 30);
        log_in.setMaximumSize(buttonSize);
        crear_cuenta.setMaximumSize(buttonSize);
        salir.setMaximumSize(buttonSize);

        log_in.setAlignmentX(Component.CENTER_ALIGNMENT);
        crear_cuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(Box.createVerticalStrut(20));
        menu.add(titulo);
        menu.add(Box.createVerticalStrut(40));
        menu.add(log_in);
        menu.add(Box.createVerticalStrut(10));
        menu.add(crear_cuenta);
        menu.add(Box.createVerticalStrut(10));
        menu.add(salir);

        pantalla.add(menu);
        pantalla.setVisible(true);
    }
}
