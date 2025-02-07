/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xianquiproyecto;

import java.awt.*;
import javax.swing.*;

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

        JPanel casillas = new JPanel(new GridLayout(11, 9));
        casillas.setPreferredSize(new Dimension(400, 500));
        casillas.setBorder(BorderFactory.createLineBorder(Color.decode("#891c00"), 5));

        for (int fila = 0; fila < 11; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (fila == 5) {
                    JLabel rio = new JLabel();
                    rio.setOpaque(true);
                    rio.setBackground(Color.decode("#D2B48C"));
                    casillas.add(rio);
                } else {
                    JButton celda = new JButton();

                    if ((fila + columna) % 2 == 0) {
                        celda.setBackground(Color.decode("#cc5d03"));
                    } else {
                        celda.setBackground(Color.decode("#feae3f"));
                    }

                    if ((fila == 0 || fila == 1 || fila == 2 || fila == 8 || fila == 9 || fila == 10) && columna >= 3 && columna <= 5) {
                        celda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                    }

                    Piezas carro = new Carro_de_Guerra(fila, columna, true);
                    carro.colocarPieza(celda, fila, columna);

                    Caballo caballo = new Caballo(fila, columna, true);
                    caballo.colocarPieza(celda, fila, columna);

                    Elefante elefante = new Elefante(fila, columna, true);
                    elefante.colocarPieza(celda, fila, columna);

                    Oficial oficial = new Oficial(fila, columna, true);
                    oficial.colocarPieza(celda, fila, columna);

                    General general = new General(fila, columna, true);
                    general.colocarPieza(celda, fila, columna);

                    Cañon cañon = new Cañon(fila, columna, true);
                    cañon.colocarPieza(celda, fila, columna);

                    Soldado soldado = new Soldado(fila, columna, true);
                    soldado.colocarPieza(celda, fila, columna);

                    casillas.add(celda);
                }
            }
        }

        JPanel numeros_izquierda = new JPanel(new GridLayout(11, 1));
        numeros_izquierda.setBackground(Color.decode("#891c00"));
        for (int i = 11; i >= 1; i--) { // Del 11 al 1
            JLabel etiqueta = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
            etiqueta.setForeground(Color.WHITE);
            numeros_izquierda.add(etiqueta);
        }

        JPanel numeros_derecha = new JPanel(new GridLayout(11, 1));
        numeros_derecha.setBackground(Color.decode("#891c00"));
        for (int i = 11; i >= 1; i--) { // Del 11 al 1
            JLabel etiqueta = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
            etiqueta.setForeground(Color.WHITE);
            numeros_derecha.add(etiqueta);
        }

        JPanel letras_arriba = new JPanel(new GridLayout(1, 9));
        letras_arriba.setBackground(Color.decode("#891c00"));
        for (char letra = 'A'; letra <= 'I'; letra++) {
            JLabel etiqueta = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
            etiqueta.setForeground(Color.WHITE);
            letras_arriba.add(etiqueta);
        }

        JPanel letras_abajo = new JPanel(new GridLayout(1, 9));
        letras_abajo.setBackground(Color.decode("#891c00"));
        for (char letra = 'A'; letra <= 'I'; letra++) {
            JLabel etiqueta = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
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
