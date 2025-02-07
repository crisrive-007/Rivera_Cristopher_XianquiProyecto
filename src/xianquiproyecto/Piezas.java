/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import javax.swing.JButton;

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
        this.esNegro = true;
    }
    
    //public abstract void mover(JButton celda, int fila, int columna, boolean esNegro);
    
    public abstract void colocarPieza(JButton celda, int fila, int columna);
    
    protected boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 9;
    }
}
