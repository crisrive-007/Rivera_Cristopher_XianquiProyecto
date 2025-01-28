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
public class Soldado extends Piezas{
    
    public void mover(){
        
    }

    public void colocarPieza(JButton celda, int fila, int columna) {
        if (fila == 3 && columna == 0 || fila == 3 && columna == 2 || fila == 3 && columna == 4 || fila == 3 && columna == 6 || fila == 3 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (fila == 6 && columna == 0 || fila == 6 && columna == 2 || fila == 6 && columna == 4 || fila == 6 && columna == 6 || fila == 6 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
