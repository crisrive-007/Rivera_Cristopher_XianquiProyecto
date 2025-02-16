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
public class Menu_Principal {

    public void Menu_Principal() {
        JFrame pantalla = new JFrame("Xiangqi");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(500, 400);
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

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton salir = new JButton("Salir");
        salir.setBackground(Color.YELLOW);
        salir.setForeground(Color.BLACK);
        salir.setFont(new Font("Arial", Font.BOLD, 14));
        salir.addActionListener(e -> {
            pantalla.dispose();
            Menu_Inicio menuI = new Menu_Inicio();
            menuI.Menu_Inicio();
        });
        topPanel.add(salir);
        topPanel.setOpaque(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/XIANGQI.PNG"));
        Image imagen = icon.getImage().getScaledInstance(300, 85, Image.SCALE_SMOOTH);
        JLabel titulo = new JLabel(new ImageIcon(imagen));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jugar = new JButton("Nueva Partida");
        jugar.addActionListener(e -> {
            String jugador2;

            do {
                jugador2 = JOptionPane.showInputDialog("Ingrese el nombre del jugador rival.");
                if (jugador2 == null) {
                    return;
                }
                if (jugador2.equalsIgnoreCase(Jugadores.juego.jugador1.getUsername())) {
                    JOptionPane.showMessageDialog(null, "No se puede ingresar el nombre del jugador actual.");
                }
            } while (jugador2.equalsIgnoreCase(Jugadores.juego.jugador1.getUsername()));

            Player jugador = Jugadores.juego.jugador2(0, jugador2);

            if (jugador != null) {
                JOptionPane.showMessageDialog(null, "Se ha encontrado al jugador " + jugador.getUsername());
                pantalla.dispose();
                Tablero tab = new Tablero();
                tab.iniciarTablero();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado al jugador. Inténtelo de nuevo.");
            }
        });
        JButton reportes = new JButton("Reportes");
        reportes.addActionListener(e -> {
            Reportes report = new Reportes();
            report.Reportes();
            pantalla.dispose();
        });
        JButton perfil = new JButton("Mi Perfil");
        perfil.addActionListener(e -> {
            Mi_Perfil mi_perfil = new Mi_Perfil();
            mi_perfil.Mi_Perfil();
            pantalla.dispose();
        });
        JButton cerrarSesion = new JButton("Cerrar Sesión");
        cerrarSesion.addActionListener(e -> {
            pantalla.dispose();
            Menu_Inicio menuI = new Menu_Inicio();
            menuI.Menu_Inicio();
        });

        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        for (JButton button : new JButton[]{jugar, reportes, perfil, cerrarSesion}) {
            button.setMaximumSize(buttonSize);
            button.setFont(buttonFont);
            button.setBackground(Color.YELLOW);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        menu.add(topPanel);
        menu.add(Box.createVerticalStrut(13));
        menu.add(titulo);
        menu.add(Box.createVerticalStrut(30));
        menu.add(jugar);
        menu.add(Box.createVerticalStrut(10));
        menu.add(reportes);
        menu.add(Box.createVerticalStrut(10));
        menu.add(perfil);
        menu.add(Box.createVerticalStrut(10));
        menu.add(cerrarSesion);
        menu.add(Box.createVerticalStrut(100));

        pantalla.add(menu);
        pantalla.setVisible(true);
    }
}
