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
public class Carro_de_Guerra extends Piezas{

    public Carro_de_Guerra(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }
    
    public void mover(JButton celda, int fila, int columna){
        int movimientos[] = {fila + 1, columna + 1, columna -1};
    }
    
    public void colocarPieza(JButton celda, int fila, int columna){
        if (fila == 0 && columna == 0 || fila == 0 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/carro_de_guerra-negro.PNG"));
            Image pieza = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon (pieza));
        } else if (fila == 10 && columna == 0 || fila == 10 && columna == 8) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/carro_de_guerra-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
