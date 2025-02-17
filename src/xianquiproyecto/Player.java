/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.util.Calendar;

/**
 *
 * @author river
 */
public class Player implements Almacenamiento {

    public String username, password;
    public int puntos;
    public Calendar fecha_de_ingreso;
    public int dia;
    public int mes;
    public int año;
    public int partidas_ganadas;
    public int partidas_perdidas;
    public boolean activo;
    public int[][] piezas;
    public int cantidad_piezas;
    public int numero;
    public String[] logs;
    public String[] movimientos;
    public static final int partidas = 10;

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.puntos = 0;
        this.fecha_de_ingreso = Calendar.getInstance();
        this.dia = fecha_de_ingreso.get(Calendar.DAY_OF_MONTH);
        this.mes = fecha_de_ingreso.get(Calendar.MONTH) + 1;
        this.año = fecha_de_ingreso.get(Calendar.YEAR);
        this.partidas_ganadas = 0;
        this.partidas_perdidas = 0;
        this.activo = true;
        this.piezas = new int[16][2];
        this.cantidad_piezas = 0;
        this.logs = new String[partidas];
        this.movimientos = new String[100];
    }

    public final String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public final String getPassword() {
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

    public int getPartidas_ganadas() {
        return partidas_ganadas;
    }

    public void setPartidas_ganadas(int partidas_ganadas) {
        this.partidas_ganadas = partidas_ganadas;
    }

    public int getPartidas_perdidas() {
        return partidas_perdidas;
    }

    public void setPartidas_perdidas(int partidas_perdidas) {
        this.partidas_perdidas = partidas_perdidas;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public void agregarPieza(int fila, int columna, Piezas pieza) {
        if (cantidad_piezas < piezas.length) {
            piezas[cantidad_piezas][0] = fila;
            piezas[cantidad_piezas][1] = columna;
            this.cantidad_piezas++;
        }
    }

    @Override
    public void eliminarPieza(int fila, int columna) {
        for (int i = 0; i < cantidad_piezas; i++) {
            if (piezas[i][0] == fila && piezas[i][1] == columna) {
                for (int j = i; j < cantidad_piezas - 1; j++) {
                    piezas[j][0] = piezas[j + 1][0];
                    piezas[j][1] = piezas[j + 1][1];
                }
            }
        }
        cantidad_piezas--;
    }
    
    @Override
    public void agregarMovimientos(String movimiento) {
        for (int i = 0; i < movimientos.length; i++) {
            if(movimientos[i] == null) {
                movimientos[i] = movimiento;
                return;
            }
        }
    }
    
    public String[] getMovimientos() {
        return movimientos;
    }

    @Override
    public void añadir_log(String log) {
        for (int i = partidas - 1; i > 0; i--) {
            if (logs[i - 1] != null) {
                logs[i] = (i + 1) + ". " + logs[i - 1].substring(3);
            }
        }

        logs[0] = "1. " + log;
    }

    public String[] getLogs() {
        String[] logsActualizados = new String[partidas];
        for (int i = 0; i < partidas; i++) {
            if (logs[i] != null) {
                String log = logs[i];
                for (Player jugador : Jugadores.juego.jugadores) {
                    if (jugador != null && !jugador.activo) {
                        log = log.replace(jugador.getUsername(), "'jugador inexistente'");
                    }
                }
                logsActualizados[i] = log;
            }
        }
        return logsActualizados;
    }

    public void setLogs(String[] logs) {
        this.logs = logs;
    }

    @Override
    public String toString() {
        return "Jugador: " + username + "\nPuntos: " + Jugadores.juego.jugador1.getPuntos() + "\nFecha de Ingreso: " + this.dia + "/" + this.mes + "/" + this.año + "\n\nPartidas Ganadas: " + Jugadores.juego.jugador1.getPartidas_ganadas() + "\nPartidas Perdidas: " + Jugadores.juego.jugador1.getPartidas_perdidas();
    }
}
