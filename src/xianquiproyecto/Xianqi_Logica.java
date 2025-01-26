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
public class Xianqi_Logica {
    
    public Player jugador1;
    public Player jugador2;
    public Player jugador_actual = null;
    public Player[] jugadores = new Player[100];
    public int jugadores_registrados = 0;
    
    
    public void ordenar_jugadores() {
        int n = jugadores.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (jugadores[j] != null && jugadores[j + 1] != null && jugadores[j].getPuntos() < jugadores[j + 1].getPuntos()) {
                    Player temp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = temp;
                }
            }
        }
    }
    
    public void eliminar_cuenta() {
        if (jugador1 != null) {
            jugador1.setUsername("");
            jugador1.setPuntos(0);
        }
    }
    
    public Player inicio_sesion(String username, String password) {
        for (int i = 0; i < jugadores_registrados; i++) {
            if (jugadores[i].getUsername().equals(username) && jugadores[i].getPassword().equals(password)) {
                jugador1 = jugadores[i];
                return jugadores[i];
            }
        }
        System.out.println("Error: Username o contraseña incorrectos.");
        return null;
    }
    
    public void crear_jugador(String username, String password) {
        if (jugadores_registrados >= jugadores.length) {
            return;
        }

        jugadores[jugadores_registrados] = new Player(username, password);
        jugadores_registrados++;
    }
    
    public boolean usuario_existente(String username) {
        for (int i = 0; i < jugadores_registrados; i++) {
            if (jugadores[i].getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public Player jugador2(String username) {
        for (int i = 0; i < jugadores_registrados; i++) {
            if (jugadores[i].getUsername().equals(username) && !username.equalsIgnoreCase(String.valueOf(jugador1.getUsername()))) {
                jugador2 = jugadores[i];
                return jugadores[i];
            } else if (username.equalsIgnoreCase(String.valueOf(jugador1.getUsername()))) {
                JOptionPane.showMessageDialog(null, "No se puede ingresar el nombre del jugador actual.");
            }
        }
        return null;
    }
    
}
