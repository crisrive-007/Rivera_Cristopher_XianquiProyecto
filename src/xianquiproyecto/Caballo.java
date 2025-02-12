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

    public Caballo(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        int difFila = Math.abs(nuevaFila - fila);
        int difColumna = Math.abs(nuevaColumna - columna);

        if (!((difFila == 2 && difColumna == 1) || (difFila == 1 && difColumna == 2))) {
            return false;
        }

        int filaIntermedia = (difFila == 2) ? (fila + nuevaFila) / 2 : fila;
        int columnaIntermedia = (difColumna == 2) ? (columna + nuevaColumna) / 2 : columna;

        return piezas[filaIntermedia][columnaIntermedia] == null;
    }
    
    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/caballo-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/caballo-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
