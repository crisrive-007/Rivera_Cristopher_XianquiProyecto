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
    
    int movimientos[] = {fila + 1, columna + 1, columna -1};

    public Soldado(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }
    
    public void mover(JButton celda, int fila, int columna, boolean esNegro){
        
    }

    public void colocarPieza(JButton celda, int fila, int columna) {
        if (fila == 3 && columna == 0 || fila == 3 && columna == 2 || fila == 3 && columna == 4 || fila == 3 && columna == 6 || fila == 3 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (fila == 7 && columna == 0 || fila == 7 && columna == 2 || fila == 7 && columna == 4 || fila == 7 && columna == 6 || fila == 7 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
