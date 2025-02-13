/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author river
 */
public abstract class Piezas {

    protected int fila;
    protected int columna;
    protected boolean esNegro;

    public Piezas(int fila, int columna, boolean esNegro) {
        this.fila = fila;
        this.columna = columna;
        this.esNegro = esNegro;
    }

    public abstract boolean esPosicionValida(int nuevaFila, int nuevaColumna, Piezas[][] piezas);

    public abstract void colocarPieza(JButton celda, int fila, int columna);

    public void moverPieza(int nuevaFila, int nuevaColumna, Piezas[][] piezas, JButton[][] celdas) {
        celdas[fila][columna].setIcon(null);
        piezas[fila][columna] = null;

        this.fila = nuevaFila;
        this.columna = nuevaColumna;
        piezas[nuevaFila][nuevaColumna] = this;
        
        if (LogicaDeVictoria.victoria.gameOver(piezas)) {
            String ganador = this.esNegro ? "Jugador 2 (Negro)" : "Jugador 1 (Rojo)";
            JOptionPane.showMessageDialog(null, ganador + " ha ganado la partida!");
            System.exit(0);
        }
    }

    public boolean esPiezaDelJugadorActualEnPosicion(int fila, int columna, Piezas[][] piezas) {
        Piezas pieza = piezas[fila][columna];
        if (pieza != null) {
            return pieza.esPiezaDelJugadorActual();
        }
        return false;
    }

    public boolean estaEnPalacio(int fila, int columna) {
        if (esNegro) {
            return fila >= 0 && fila <= 2 && columna >= 3 && columna <= 5;
        } else {
            return fila >= 7 && fila <= 9 && columna >= 3 && columna <= 5;
        }
    }

    public boolean esPiezaDelJugadorActual() {
        return (esNegro && Jugadores.juego.jugador_actual == Jugadores.juego.jugador2)
                || (!esNegro && Jugadores.juego.jugador_actual == Jugadores.juego.jugador1);
    }

    public void resaltarMovimientosValidos(Piezas piezaSeleccionada, Piezas[][] piezas, JButton[][] celdas, int fila, int columna) {
        limpiarResaltado(celdas);
        piezaSeleccionada = piezas[fila][columna];

        for (int i = 0; i < celdas.length; i++) {
            for (int j = 0; j < celdas[i].length; j++) {
                if (celdas[i][j] != null) {
                    if (piezaSeleccionada.esPosicionValida(i, j, piezas)) {
                        celdas[i][j].setBackground(Color.GREEN);
                    }
                }
            }
        }
    }

    public void limpiarResaltado(JButton[][] celdas) {
        for (int fila = 0; fila < celdas.length; fila++) {
            for (int columna = 0; columna < celdas[fila].length; columna++) {
                if (celdas[fila][columna] != null) {
                    if ((fila + columna) % 2 == 0) {
                        celdas[fila][columna].setBackground(Color.decode("#cc5d03"));
                    } else {
                        celdas[fila][columna].setBackground(Color.decode("#feae3f"));
                    }
                }
            }
        }
    }

    public void capturarPieza(int nuevaFila, int nuevaColumna, Piezas[][] piezas, JButton[][] celdas, Piezas piezaCapturada) {
        if (piezaCapturada.esNegro) {
            Jugadores.juego.jugador1.eliminarPieza(nuevaFila, nuevaColumna);
        } else {
            Jugadores.juego.jugador2.eliminarPieza(nuevaFila, nuevaColumna);
        }
        moverPieza(nuevaFila, nuevaColumna, piezas, celdas);
    }
}
