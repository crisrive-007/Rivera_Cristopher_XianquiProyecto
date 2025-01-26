/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

/**
 *
 * @author river
 */
public class Player {
    
    public String username, password;
    public int puntos;
    public int[][] piezas;
    public int cantidad_piezas;
    public int numero;
    public String[] logs;
    public static final int partidas = 10;
    
    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.piezas = new int[8][2];
        this.cantidad_piezas = 0;
        this.logs = new String[partidas];
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public void añadir_log(String log) {
        for (int i = partidas - 1; i > 0; i--) {
            logs[i] = logs[i - 1];
        }
        logs[0] = log;
    }

    public String[] getLogs() {
        return logs;
    }

    public void setLogs(String[] logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "Jugador: " + username + ", Puntos: " + puntos;
    }
}
