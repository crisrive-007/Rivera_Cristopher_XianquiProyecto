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
public class Jugadores {

    public Player jugador1;
    public Player jugador2;
    public Player jugador_actual = null;
    public Player[] jugadores = new Player[100];
    public int jugadores_registrados = 0;
    public static Jugadores juego = new Jugadores();

    public void ordenar_jugadores() {
        for (int i = 0; i < jugadores.length - 1; i++) {
            for (int j = 0; j < jugadores.length - 1 - i; j++) {
                if (jugadores[j] != null && jugadores[j + 1] != null && jugadores[j].getPuntos() < jugadores[j + 1].getPuntos()) {
                    Player temp = jugadores[j];
                    jugadores[j] = jugadores[j + 1];
                    jugadores[j + 1] = temp;
                }
            }
        }
    }

    public int eliminar_cuenta() {
        int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la cuenta?");

        if (eliminar == 0) {
            for (int i = 0; i < jugadores_registrados; i++) {
                if (jugadores[i] == jugador1) {
                    jugadores[i].setActivo(false);
                    JOptionPane.showMessageDialog(null, "Cuenta eliminada exitosamente.");
                    return eliminar;
                }
            }
        }
        return eliminar;
    }

    public Player inicio_sesion(int index, String username, String password) {
        if (this.jugadores[index] == null) {
            JOptionPane.showMessageDialog(null, "Username o contraseña incorrectos.");
            return null;
        }

        if (index < jugadores.length) {
            if (jugadores[index].getUsername().equals(username) && jugadores[index].getPassword().equals(password) && jugadores[index].isActivo()) {
                jugador1 = jugadores[index];
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido, " + username + "!");
                return jugadores[index];
            } else {
                return inicio_sesion(index + 1, username, password);
            }
        }
        JOptionPane.showMessageDialog(null, "Username o contraseña incorrectos.");
        return null;
    }

    public Player crear_jugador(String username, String password) {
        if (usuario_existente(0, username)) {
            JOptionPane.showMessageDialog(null, "Este usuario ya existe. Intente con otro.");
            return null;
        }

        if (password.length() == 5) {
            if (jugadores_registrados < jugadores.length) {
                jugadores[jugadores_registrados] = new Player(username, password);
                jugadores_registrados++;
                JOptionPane.showMessageDialog(null, "Se ha creado al jugador " + username + " exitosamente.");
                return jugadores[jugadores_registrados - 1];
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio para más jugadores.");
                return null;
            }
        } else {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener 5 caracteres.");
            return null;
        }
    }

    public boolean usuario_existente(int index, String username) {
        if (index >= jugadores.length || jugadores[index] == null) {
            return false;
        }

        String usuario_registrado = jugadores[index].getUsername();

        if (jugadores[index].isActivo()) {
            if (username.length() == usuario_registrado.length()) {
                boolean sonIguales = true;
                for (int i = 0; i < username.length(); i++) {
                    char charUsuario = username.charAt(i);
                    char charRegistrado = usuario_registrado.charAt(i);

                    if (Character.toLowerCase(charUsuario) != Character.toLowerCase(charRegistrado)) {
                        sonIguales = false;
                        break;
                    }
                }

                if (sonIguales) {
                    return true;
                }
            }
        }

        return usuario_existente(index + 1, username);
    }

    public Player jugador2(int index, String username) {
        if (index < jugadores_registrados) {
            if (jugadores[index] != null && jugadores[index].isActivo()) {
                if (jugadores[index].getUsername().equalsIgnoreCase(username)) {
                    jugador2 = jugadores[index];
                    return jugadores[index];
                }
            }
            return jugador2(index + 1, username);
        }
        return null;
    }

    public void cambio_turno() {
        if (jugador_actual == jugador1) {
            this.jugador_actual = jugador2;
        } else {
            this.jugador_actual = jugador1;
        }
        JOptionPane.showMessageDialog(null, turno());
    }

    public String turno() {
        return "Es turno del jugador: " + jugador_actual.getUsername();
    }

}
