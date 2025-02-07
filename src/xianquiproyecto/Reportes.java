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
public class Reportes {

    public void Reportes() {

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
            Menu_Principal menuP = new Menu_Principal();
            menuP.Menu_Principal();
        });
        topPanel.add(salir);
        topPanel.setOpaque(false);

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/XIANGQI.PNG"));
        Image imagen = icon.getImage().getScaledInstance(300, 85, Image.SCALE_SMOOTH);
        JLabel titulo = new JLabel(new ImageIcon(imagen));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ranking = new JButton("Ranking de Jugadores");
        ranking.setBackground(Color.YELLOW);
        JButton historial = new JButton("Historial de Partidas");
        historial.setBackground(Color.YELLOW);
        JButton volver = new JButton("Salir");
        volver.setBackground(Color.YELLOW);

        Dimension buttonSize = new Dimension(200, 40);
        ranking.setMaximumSize(buttonSize);
        ranking.setFont(new Font("Arial", Font.BOLD, 20));
        ranking.addActionListener(e -> {
            Registro.juego.ordenar_jugadores();
            String ranking_jugadores = "";
            for (int i = 0; i < 10; i++) {
                if(Registro.juego.jugadores[i] != null) {
                    ranking_jugadores += Registro.juego.jugadores[i].toString() + "\n";
                }
            }
            JOptionPane.showMessageDialog(null, ranking_jugadores);
        });
        historial.setMaximumSize(buttonSize);
        historial.setFont(new Font("Arial", Font.BOLD, 20));
        historial.addActionListener(e -> {
            String[] logs = Registro.juego.jugador1.getLogs();
            StringBuilder partidas = new StringBuilder();
            for (String log : logs) {
                if (log != null) {
                    partidas.append(log).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, partidas.toString());
        });
        volver.setMaximumSize(buttonSize);
        volver.setFont(new Font("Arial", Font.BOLD, 20));
        volver.addActionListener(e -> {
            pantalla.dispose();
            Menu_Principal menuP = new Menu_Principal();
            menuP.Menu_Principal();
        });

        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        historial.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(topPanel);
        menu.add(Box.createVerticalStrut(13));
        menu.add(titulo);
        menu.add(Box.createVerticalStrut(30));
        menu.add(ranking);
        menu.add(Box.createVerticalStrut(10));
        menu.add(historial);
        menu.add(Box.createVerticalStrut(10));
        menu.add(volver);
        menu.add(Box.createVerticalStrut(100));

        pantalla.add(menu);
        pantalla.setVisible(true);
    }
}
