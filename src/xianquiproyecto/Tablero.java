/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author river
 */
public class Tablero {

    public void iniciarTablero() {

        JFrame pantalla = new JFrame("Xianqi - Nueva partida");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(700, 800);
        pantalla.setBackground(Color.decode("#c05e10"));
        pantalla.setLocationRelativeTo(null);

        JPanel tablero = new JPanel();
        tablero.setBackground(Color.decode("#d9392b"));
        tablero.setPreferredSize(new Dimension(500, 600));
        tablero.setLayout(new BorderLayout());

        JPanel casillas = new JPanel(new GridLayout(10, 9));
        casillas.setPreferredSize(new Dimension(400, 500));
        casillas.setBorder(BorderFactory.createLineBorder(Color.decode("#891c00"), 5));

        for (int fila = 0; fila < 10; fila++) {

            for (int columna = 0; columna < 9; columna++) {
                JButton celda = new JButton();

                if ((fila + columna) % 2 == 0) {
                    celda.setBackground(Color.decode("#cc5d03"));
                } else {
                    celda.setBackground(Color.decode("#feae3f"));
                }
                
                Carro_de_Guerra carro = new Carro_de_Guerra();
                carro.colocarPieza(celda, fila, columna);
                
                Caballo caballo = new Caballo();
                caballo.colocarPieza(celda, fila, columna);
                
                Elefante elefante = new Elefante();
                elefante.colocarPieza(celda, fila, columna);
                
                Oficial oficial = new Oficial();
                oficial.colocarPieza(celda, fila, columna);
                
                General general = new General();
                general.colocarPieza(celda, fila, columna);
                
                Cañon cañon = new Cañon();
                cañon.colocarPieza(celda, fila, columna);

                Soldado soldado = new Soldado();
                soldado.colocarPieza(celda, fila, columna);

                casillas.add(celda);
            }
        }

        JPanel numeros_izquierda = new JPanel(new GridLayout(10, 1));
        numeros_izquierda.setBackground(Color.decode("#891c00"));
        for (int i = 10; i >= 1; i--) {
            JLabel etiqueta = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
            etiqueta.setForeground(Color.WHITE);
            etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
            etiqueta.setVerticalAlignment(SwingConstants.CENTER);
            numeros_izquierda.add(etiqueta);
        }

        JPanel numeros_derecha = new JPanel(new GridLayout(10, 1));
        numeros_derecha.setBackground(Color.decode("#891c00"));
        for (int i = 10; i >= 1; i--) {
            JLabel etiqueta = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
            etiqueta.setForeground(Color.WHITE);
            numeros_derecha.add(etiqueta);
        }

        JPanel letras_arriba = new JPanel(new GridLayout(1, 9));
        letras_arriba.setBackground(Color.decode("#891c00"));
        for (char letra = 'A'; letra <= 'I'; letra++) {
            JLabel etiqueta = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
            etiqueta.setForeground(Color.WHITE);
            letras_arriba.add(etiqueta);
        }

        JPanel letras_abajo = new JPanel(new GridLayout(1, 9));
        letras_abajo.setBackground(Color.decode("#891c00"));
        for (char letra = 'A'; letra <= 'I'; letra++) {
            JLabel etiqueta = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
            etiqueta.setForeground(Color.WHITE);
            letras_abajo.add(etiqueta);
        }

        tablero.add(numeros_izquierda, BorderLayout.WEST);
        tablero.add(numeros_derecha, BorderLayout.EAST);
        tablero.add(letras_arriba, BorderLayout.NORTH);
        tablero.add(letras_abajo, BorderLayout.SOUTH);
        tablero.add(casillas, BorderLayout.CENTER);

        pantalla.add(tablero);

        pantalla.setVisible(true);
    }
}
