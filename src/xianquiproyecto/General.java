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
public class General extends Piezas{
    
    public General(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }
    
    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        if (!estaEnPalacio(nuevaFila, nuevaColumna)) {
            return false;
        }

        int difFila = Math.abs(nuevaFila - fila);
        int difColumna = Math.abs(nuevaColumna - columna);

        if (esPiezaDelJugadorActualEnPosicion(nuevaFila, nuevaColumna, piezas)) {
            return false;
        }

        if ((difFila == 1 && difColumna == 0) || (difFila == 0 && difColumna == 1)) {
            if (!hayVisionDirectaConOponente(nuevaFila, nuevaColumna, piezas)) {
                return true;
            }
        }

        return false;
    }

    private boolean estaEnPalacio(int fila, int columna) {
        if (esNegro) {
            return fila >= 7 && fila <= 9 && columna >= 3 && columna <= 5;
        } else {
            return fila >= 0 && fila <= 2 && columna >= 3 && columna <= 5;
        }
    }

    private boolean hayVisionDirectaConOponente(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        int filaOponente = esNegro ? 0 : 9;
        int columnaOponente = nuevaColumna;

        if (columna == columnaOponente) {
            for (int i = Math.min(fila, filaOponente) + 1; i < Math.max(fila, filaOponente); i++) {
                if (piezas[i][columnaOponente] != null) {
                    return false;
                }
            }
            return true;
        }

        if (fila == filaOponente) {
            for (int i = Math.min(columna, columnaOponente) + 1; i < Math.max(columna, columnaOponente); i++) {
                if (piezas[fila][i] != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
    
    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/general-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/general-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
