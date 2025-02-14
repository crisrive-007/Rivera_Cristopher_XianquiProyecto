/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author river
 */
public class LogicaDeVictoria {

    public static LogicaDeVictoria victoria = new LogicaDeVictoria();
    protected boolean finDelJuego;

    public LogicaDeVictoria() {
        this.finDelJuego = false;
    }

    public boolean gameOver(Piezas[][] piezas) {
        if (finDelJuego == false) {
            if (verificarFinDePartida(piezas) == true) {
                Menu_Principal menu = new Menu_Principal();
                menu.Menu_Principal();
                return true;
            }
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
            JOptionPane.showMessageDialog(null, "¡El jugador " + Jugadores.juego.jugador2.getUsername() + " gana!");
            Jugadores.juego.jugador2.añadir_log("¡El jugador " + Jugadores.juego.jugador2.getUsername() + " gana porque se ha comido el general rojo.!");
            Jugadores.juego.jugador1.añadir_log("¡El jugador " + Jugadores.juego.jugador1.getUsername() + " pierde porque se han comido a su general!");
            return true;
        } else if (!generalNegroVivo) {
            JOptionPane.showMessageDialog(null, "¡El jugador " + Jugadores.juego.jugador1.getUsername() + " gana!");
            Jugadores.juego.jugador1.añadir_log("¡El jugador " + Jugadores.juego.jugador1.getUsername() + " gana porque se ha comido el general negro.!");
            Jugadores.juego.jugador2.añadir_log("¡El jugador " + Jugadores.juego.jugador2.getUsername() + " pierde porque se han comido a su general!");
            return true;
        }

        return false;
    }
}
