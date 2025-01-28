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
public class Caballo extends Piezas {

    public void mover() {

    }

    public void colocarPieza(JButton celda, int fila, int columna) {
        if (fila == 0 && columna == 1 || fila == 0 && columna == 7) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/caballo-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (fila == 9 && columna == 1 || fila == 9 && columna == 7) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/caballo-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}