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
public class Carro_de_Guerra extends Piezas {

    public Carro_de_Guerra(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        if (fila != nuevaFila && columna != nuevaColumna) {
            return false;
        }

        if (esPiezaDelJugadorActualEnPosicion(nuevaFila, nuevaColumna, piezas)) {
            return false;
        }

        if (fila == nuevaFila) {
            // Movimiento horizontal
            int menor = Math.min(columna, nuevaColumna);
            int mayor = Math.max(columna, nuevaColumna);

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[fila][i] != null) {
                    return false;
                }
            }
        } else {
            // Movimiento vertical
            int menor = Math.min(fila, nuevaFila);
            int mayor = Math.max(fila, nuevaFila);

            for (int i = menor + 1; i < mayor; i++) {
                if (piezas[i][columna] != null) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/carro_de_guerra-negro.PNG"));
            Image pieza = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(pieza));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/carro_de_guerra-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
