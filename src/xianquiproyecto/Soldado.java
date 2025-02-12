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
public class Soldado extends Piezas {

    public Soldado(int fila, int columna, boolean esNegro) {
        super(fila, columna, esNegro);
    }

    @Override
    public boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas) {
        int direccion = esNegro ? 1 : -1;
        boolean esMovimientoValido = false;

        if (esPiezaDelJugadorActualEnPosicion(nuevaFila, nuevaColumna, piezas)) {
            return false;
        }

        if (columna == nuevaColumna && nuevaFila == fila + direccion) {
            esMovimientoValido = true;
        }

        if ((esNegro && fila >= 5) || (!esNegro && fila <= 4)) {
            if (nuevaFila == fila && Math.abs(nuevaColumna - columna) == 1) {
                esMovimientoValido = true;
            }
        }

        if (nuevaFila < 0 || nuevaFila >= 10 || nuevaColumna < 0 || nuevaColumna >= 9) {
            return false;
        }

        return esMovimientoValido;
    }

    @Override
    public void colocarPieza(JButton celda, int fila, int columna) {
        if (esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-negro.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        } else if (!esNegro) {
            ImageIcon ficha = new ImageIcon(getClass().getResource("/imagenes/soldado-rojo.PNG"));
            Image imagen = ficha.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            celda.setIcon(new ImageIcon(imagen));
        }
    }
}
