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
public class General extends Piezas {

    public General(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas
    ) {
        if (!super.estaEnPalacio(nuevaFila, nuevaColumna)) {
            return false;
        }
        int difFila = Math.abs(nuevaFila - fila);
        int difColumna = Math.abs(nuevaColumna - columna);
        
        if ((difFila == 1 && difColumna == 0) || (difFila == 0 && difColumna == 1)) {
            if (!hayVisionDirectaConOponente(nuevaFila, nuevaColumna, piezas)) {
                return true;
            }
        }
        return false;
    }

    private boolean hayVisionDirectaConOponente(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        int filaOponente = esNegro ? 9 : 0;
        int columnaOponente = nuevaColumna;
        for (int i = Math.min(fila, filaOponente) + 1; i < Math.max(fila, filaOponente); i++) {
            if (piezas[i][columnaOponente] != null) {
                return false;
            }
        }
        return true;
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
