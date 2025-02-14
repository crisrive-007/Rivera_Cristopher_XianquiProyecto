/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package xianquiproyecto;

/**
 *
 * @author river
 */
public interface Almacenamiento {
    void agregarPieza(int fila, int columna);
    void eliminarPieza(int fila, int columna);
    void añadir_log(String log);
}
