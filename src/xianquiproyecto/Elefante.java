/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author river
 */
public class Elefante extends Piezas {

    public void mover() {

    }

    public void colocarPieza(JButton celda, int fila, int columna) {
        if (fila == 0 && columna == 2 || fila == 0 && columna == 6) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/elefante-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (fila == 9 && columna == 2 || fila == 9 && columna == 6) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/elefante-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
