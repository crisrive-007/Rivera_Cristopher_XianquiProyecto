/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

/**
 *
 * @author river
 */
public class LogicaDeVictoria {
    
    public static LogicaDeVictoria victoria = new LogicaDeVictoria();
    
    public boolean gameOver(Piezas[][] piezas) {
        if (verificarFinDePartida(piezas)) {
            return true;
        }
        return false;
    }
    
    public boolean verificarFinDePartida(Piezas[][] piezas) {
        boolean generalRojoVivo = false;
        boolean generalNegroVivo = false;

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                Piezas pieza = piezas[fila][columna];
                if (pieza instanceof General) {
                    if (!pieza.esNegro) {
                        generalRojoVivo = true;
                    } else if (pieza.esNegro) {
                        generalNegroVivo = true;
                    }
                }
            }
        }

        if (!generalRojoVivo) {
            System.out.println("¡El jugador negro gana!");
            return true;
        } else if (!generalNegroVivo) {
            System.out.println("¡El jugador rojo gana!");
            return true;
        }

        return false;
    }
}

