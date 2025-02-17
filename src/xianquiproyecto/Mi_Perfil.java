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
public class Mi_Perfil {

    public void Mi_Perfil() {

        JFrame pantalla = new JFrame("Xinagqi");
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

        JButton datos = new JButton("Ver mi Información");
        datos.addActionListener(e -> {
            Player player = new Player(Jugadores.juego.jugador1.getUsername(), Jugadores.juego.jugador1.getPassword());
            JOptionPane.showMessageDialog(null, player.toString());
        });
        JButton cambiar_contraseña = new JButton("Cambiar Contraseña");
        cambiar_contraseña.addActionListener(e -> {
            String contra_actual = Jugadores.juego.jugador1.getPassword();
            String nueva_contra = (JOptionPane.showInputDialog("Ingresa la nueva contraseña:"));
            if (nueva_contra != null) {
                if (nueva_contra.length() == 5) {
                    if (!nueva_contra.equals(contra_actual)) {
                        Jugadores.juego.jugador1.setPassword(nueva_contra);
                        JOptionPane.showMessageDialog(null, "Se ha cambiado la contraseña con exito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "La nueva contraseña no puede ser la misma que la actual.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña debe tener 5 caracteres.");
                }
            }
        });
        JButton eliminar = new JButton("Eliminar Cuenta");
        eliminar.addActionListener(e -> {
            if (Jugadores.juego.eliminar_cuenta() == 0) {
                pantalla.dispose();
                Menu_Inicio menuI = new Menu_Inicio();
                menuI.Menu_Inicio();
            }
        });
        JButton volver = new JButton("Volver al inicio");
        volver.addActionListener(e -> {
            pantalla.dispose();
            Menu_Principal menuP = new Menu_Principal();
            menuP.Menu_Principal();
        });

        Dimension buttonSize = new Dimension(200, 40);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        for (JButton button : new JButton[]{datos, cambiar_contraseña, eliminar, volver}) {
            button.setMaximumSize(buttonSize);
            button.setFont(buttonFont);
            button.setBackground(Color.YELLOW);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        menu.add(Box.createVerticalStrut(50));
        menu.add(titulo);
        menu.add(Box.createVerticalStrut(30));
        menu.add(datos);
        menu.add(Box.createVerticalStrut(10));
        menu.add(cambiar_contraseña);
        menu.add(Box.createVerticalStrut(10));
        menu.add(eliminar);
        menu.add(Box.createVerticalStrut(10));
        menu.add(volver);
        menu.add(Box.createVerticalStrut(100));

        pantalla.add(menu);
        pantalla.setVisible(true);
    }
}
