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
public class Oficial extends Piezas {
    
    public Oficial(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }
    
    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        if (!estaEnPalacio(nuevaFila, nuevaColumna)) {
            return false;
        }

        int difFila = Math.abs(nuevaFila - fila);
        int difColumna = Math.abs(nuevaColumna - columna);

        return difFila == 1 && difColumna == 1;
    }
    
    private boolean estaEnPalacio(int fila, int columna) {
        if (esNegro) {
            return fila >= 0 && fila <= 2 && columna >= 3 && columna <= 5;
        } else {
            return fila >= 7 && fila <= 9 && columna >= 3 && columna <= 5;
        }
    }
    
    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/oficial-negro.PNG"));
            Image imagen = icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/oficial-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
