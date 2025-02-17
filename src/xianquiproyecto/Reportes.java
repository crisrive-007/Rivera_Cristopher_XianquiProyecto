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

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/XIANGQI.PNG"));
        Image imagen = icon.getImage().getScaledInstance(300, 85, Image.SCALE_SMOOTH);
        JLabel titulo = new JLabel(new ImageIcon(imagen));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton ranking = new JButton("Ranking jugadores");
        ranking.setBackground(Color.YELLOW);
        JButton historial = new JButton("Historial de partidas");
        historial.setBackground(Color.YELLOW);
        JButton volver = new JButton("Volver al inicio");
        volver.setBackground(Color.YELLOW);

        Dimension buttonSize = new Dimension(200, 40);
        ranking.setMaximumSize(buttonSize);
        ranking.setFont(new Font("Arial", Font.BOLD, 16));
        ranking.addActionListener(e -> {
            Jugadores.juego.ordenar_jugadores();
            String ranking_jugadores = "";
            int contadorRanking = 1;
            for (int i = 0; i < 10; i++) {
                if (Jugadores.juego.jugadores[i] != null && Jugadores.juego.jugadores[i].isActivo()) {
                    ranking_jugadores += contadorRanking + ". " + Jugadores.juego.jugadores[i].getUsername() + " --- " + Jugadores.juego.jugadores[i].getPuntos() + "\n";
                    contadorRanking++;
                }
            }
            JOptionPane.showMessageDialog(null, ranking_jugadores);
        });
        historial.setMaximumSize(buttonSize);
        historial.setFont(new Font("Arial", Font.BOLD, 16));
        historial.addActionListener(e -> {
            String[] logs = Jugadores.juego.jugador1.getLogs();
            StringBuilder partidas = new StringBuilder();

            boolean hayPartidas = false;
            for (String log : logs) {
                if (log != null) {
                    hayPartidas = true;
                    break;
                }
            }

            if (!hayPartidas) {
                JOptionPane.showMessageDialog(null, "No hay partidas guardadas.");
            } else {
                for (String log : logs) {
                    if (log != null) {
                        partidas.append(log).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, partidas.toString());
            }
        });
        volver.setMaximumSize(buttonSize);
        volver.setFont(new Font("Arial", Font.BOLD, 16));
        volver.addActionListener(e -> {
            pantalla.dispose();
            Menu_Principal menuP = new Menu_Principal();
            menuP.Menu_Principal();
        });

        ranking.setAlignmentX(Component.CENTER_ALIGNMENT);
        historial.setAlignmentX(Component.CENTER_ALIGNMENT);
        volver.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(Box.createVerticalStrut(50));
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
