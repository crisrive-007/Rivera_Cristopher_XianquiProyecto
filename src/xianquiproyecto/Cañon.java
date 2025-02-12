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
public class Cañon extends Piezas {

    public Cañon(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        if (fila != nuevaFila && columna != nuevaColumna) {
            return false;
        }

        int contadorPiezas = 0;

        if (fila == nuevaFila) {
            int menor = Math.min(columna, nuevaColumna);
            int mayor = Math.max(columna, nuevaColumna);

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[fila][i] != null) {
                    contadorPiezas++;
                }
            }

            if (piezas[nuevaFila][nuevaColumna] != null) {
                contadorPiezas++;
            }

            return (contadorPiezas == 0 || contadorPiezas == 1);

        } else {
            int menor = Math.min(fila, nuevaFila);
            int mayor = Math.max(fila, nuevaFila);

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[i][columna] != null) {
                    contadorPiezas++;
                }
            }

            if (piezas[nuevaFila][nuevaColumna] != null) {
                contadorPiezas++;
            }

            return (contadorPiezas == 0 || contadorPiezas == 1);
        }
    }
    
    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/cañon-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/cañon-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
