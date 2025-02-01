/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package xianquiproyecto;

/**
 *
 * @author river
 */
public class XianquiProyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu_Inicio menu = new Menu_Inicio();
        menu.Menu_Inicio();
        
        Tablero tab = new Tablero();
        //tab.iniciarTablero();
        
        Log_In login = new Log_In();
        //login.Log_In();
        
        Crear_Cuenta cuenta = new Crear_Cuenta();
        //cuenta.Crear_Cuenta();
        
    }
    
}
