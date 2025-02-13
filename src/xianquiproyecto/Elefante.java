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

    public Elefante(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        if (nuevaFila == 5) {
            nuevaFila = 6;
        }

        if (Math.abs(nuevaFila - fila) == 2 && Math.abs(nuevaColumna - columna) == 2) {
            int filaIntermedia = (fila + nuevaFila) / 2;
            int columnaIntermedia = (columna + nuevaColumna) / 2;

            if (piezas[filaIntermedia][columnaIntermedia] == null) {
                if ((esNegro && nuevaFila <= 5) || (!esNegro && nuevaFila >= 7)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/elefante-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/elefante-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
