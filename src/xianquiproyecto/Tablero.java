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
public final class Tablero {

    private final JButton[][] celdas = new JButton[10][9];
    private final Piezas[][] piezas = new Piezas[10][9];
    private JFrame pantalla;
    private JPanel casillasSuperior;
    private JPanel casillasInferior;
    private Piezas piezaSeleccionada;

    public void iniciarTablero() {
        pantalla = new JFrame("Xiangqi - Nueva partida");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(1180, 810);
        pantalla.setBackground(Color.decode("#891c00"));
        pantalla.setLocationRelativeTo(null);

        JPanel tablero = new JPanel(new BorderLayout());
        tablero.setBackground(Color.decode("#891c00"));

        casillasSuperior = new JPanel(new GridLayout(5, 9));
        casillasInferior = new JPanel(new GridLayout(5, 9));
        casillasSuperior.setPreferredSize(new Dimension(420, 335));
        casillasInferior.setPreferredSize(new Dimension(420, 335));
        casillasSuperior.setBackground(Color.decode("#891c00"));
        casillasInferior.setBackground(Color.decode("#891c00"));

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                JButton celda = crearCelda(fila, columna);
                celdas[fila][columna] = celda;
                if (fila < 5) {
                    casillasSuperior.add(celda);
                } else {
                    casillasInferior.add(celda);
                }
            }
        }

        JPanel contenedorCasillas = new JPanel(new BorderLayout());
        contenedorCasillas.setBackground(Color.CYAN);
        contenedorCasillas.add(casillasSuperior, BorderLayout.NORTH);
        contenedorCasillas.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.CENTER);
        contenedorCasillas.add(casillasInferior, BorderLayout.SOUTH);

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setPreferredSize(new Dimension(255, 0));
        panelIzquierdo.setBackground(Color.LIGHT_GRAY);
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

        JLabel labelJugador1 = new JLabel("Jugador 1: " + Jugadores.juego.jugador1.getUsername(), SwingConstants.CENTER);
        labelJugador1.setFont(new Font("Arial", Font.BOLD, 18));
        labelJugador1.setForeground(Color.BLACK);
        panelIzquierdo.add(labelJugador1);

        panelIzquierdo.add(Box.createVerticalStrut(20));

        JLabel piezasCapturadas1 = new JLabel("Capturas:", SwingConstants.CENTER);
        piezasCapturadas1.setFont(new Font("Arial", Font.BOLD, 16));
        piezasCapturadas1.setForeground(Color.BLACK);
        panelIzquierdo.add(piezasCapturadas1);
        
        JPanel capturasJugador1 = new JPanel(new GridLayout(5, 2));
        capturasJugador1.setBackground(Color.LIGHT_GRAY);
        panelIzquierdo.add(capturasJugador1, BorderLayout.CENTER);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setPreferredSize(new Dimension(255, 0));
        panelDerecho.setBackground(Color.LIGHT_GRAY);
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

        JLabel labelJugador2 = new JLabel("Jugador 2: " + Jugadores.juego.jugador2.getUsername(), SwingConstants.CENTER);
        labelJugador2.setFont(new Font("Arial", Font.BOLD, 18));
        labelJugador2.setForeground(Color.BLACK);
        panelDerecho.add(labelJugador2);
        
        panelDerecho.add(Box.createVerticalStrut(20));

        JLabel piezasCapturadas2 = new JLabel("Capturas:", SwingConstants.CENTER);
        piezasCapturadas2.setFont(new Font("Arial", Font.BOLD, 16));
        piezasCapturadas2.setForeground(Color.BLACK);
        panelDerecho.add(piezasCapturadas2);
        
        JPanel capturasJugador2 = new JPanel(new GridLayout(5, 2));
        capturasJugador2.setBackground(Color.LIGHT_GRAY);
        panelDerecho.add(capturasJugador2, BorderLayout.CENTER);

        tablero.add(crearPanelNumeros(), BorderLayout.WEST);
        tablero.add(crearPanelNumeros(), BorderLayout.EAST);
        tablero.add(crearPanelLetras(), BorderLayout.NORTH);
        tablero.add(crearPanelLetras(), BorderLayout.SOUTH);
        tablero.add(contenedorCasillas, BorderLayout.CENTER);

        JButton botonSalir = new JButton("Salir");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 16));
        botonSalir.setBackground(Color.decode("#891c00"));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.addActionListener(e -> pantalla.dispose());

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.LIGHT_GRAY);
        panelBoton.add(botonSalir);

        pantalla.setLayout(new BorderLayout());
        pantalla.add(panelIzquierdo, BorderLayout.WEST);
        pantalla.add(tablero, BorderLayout.CENTER);
        pantalla.add(panelDerecho, BorderLayout.EAST);
        pantalla.add(panelBoton, BorderLayout.SOUTH);

        pantalla.setVisible(true);

        colocarPiezasIniciales();
        Jugadores.juego.jugador_actual = Jugadores.juego.jugador1;
        JOptionPane.showMessageDialog(null, Jugadores.juego.turno());
    }

    private JButton crearCelda(int fila, int columna) {
        JButton celda = new JButton();
        celda.setBackground((fila + columna) % 2 == 0 ? Color.decode("#cc5d03") : Color.decode("#feae3f"));
        if ((fila == 0 || fila == 1 || fila == 2 || fila == 7 || fila == 8 || fila == 9) && columna >= 3 && columna <= 5) {
            celda.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
        celda.addActionListener(e -> manejarClicCelda(fila, columna));
        return celda;
    }

    private JPanel crearPanelNumeros() {
        JPanel panel = new JPanel(new GridLayout(10, 1));
        panel.setBackground(Color.decode("#891c00"));
        for (int i = 10; i >= 1; i--) {
            JLabel etiqueta = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
            etiqueta.setForeground(Color.WHITE);
            panel.add(etiqueta);
        }
        return panel;
    }

    private JPanel crearPanelLetras() {
        JPanel panel = new JPanel(new GridLayout(1, 9));
        panel.setBackground(Color.decode("#891c00"));
        for (char letra = 'A'; letra <= 'I'; letra++) {
            JLabel etiqueta = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
            etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
            etiqueta.setForeground(Color.WHITE);
            panel.add(etiqueta);
        }
        return panel;
    }

    private void colocarPiezasIniciales() {
        piezas[0][0] = new Carro_de_Guerra(0, 0, true);
        piezas[0][1] = new Caballo(0, 1, true);
        piezas[0][2] = new Elefante(0, 2, true);
        piezas[0][3] = new Oficial(0, 3, true);
        piezas[0][4] = new General(0, 4, true);
        piezas[0][5] = new Oficial(0, 5, true);
        piezas[0][6] = new Elefante(0, 6, true);
        piezas[0][7] = new Caballo(0, 7, true);
        piezas[0][8] = new Carro_de_Guerra(0, 8, true);
        piezas[2][1] = new Cañon(2, 1, true);
        piezas[2][7] = new Cañon(2, 7, true);
        piezas[3][0] = new Soldado(3, 0, true);
        piezas[3][2] = new Soldado(3, 2, true);
        piezas[3][4] = new Soldado(3, 4, true);
        piezas[3][6] = new Soldado(3, 6, true);
        piezas[3][8] = new Soldado(3, 8, true);

        piezas[9][0] = new Carro_de_Guerra(9, 0, false);
        piezas[9][1] = new Caballo(9, 1, false);
        piezas[9][2] = new Elefante(9, 2, false);
        piezas[9][3] = new Oficial(9, 3, false);
        piezas[9][4] = new General(9, 4, false);
        piezas[9][5] = new Oficial(9, 5, false);
        piezas[9][6] = new Elefante(9, 6, false);
        piezas[9][7] = new Caballo(9, 7, false);
        piezas[9][8] = new Carro_de_Guerra(9, 8, false);
        piezas[7][1] = new Cañon(7, 1, false);
        piezas[7][7] = new Cañon(7, 7, false);
        piezas[6][0] = new Soldado(6, 0, false);
        piezas[6][2] = new Soldado(6, 2, false);
        piezas[6][4] = new Soldado(6, 4, false);
        piezas[6][6] = new Soldado(6, 6, false);
        piezas[6][8] = new Soldado(6, 8, false);

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (piezas[fila][columna] != null) {
                    Piezas pieza = piezas[fila][columna];
                    if (pieza != null) {
                        if (pieza.esNegro) {
                            if (Jugadores.juego.jugador2 != null) {
                                Jugadores.juego.jugador2.agregarPieza(fila, columna);
                            }
                        } else {
                            if (Jugadores.juego.jugador1 != null) {
                                Jugadores.juego.jugador1.agregarPieza(fila, columna);
                            }
                        }
                        pieza.colocarPieza(celdas[fila][columna], fila, columna);
                    }
                }
            }
        }
    }

    private void manejarClicCelda(int fila, int columna) {
        Piezas pieza = piezas[fila][columna];

        if (piezaSeleccionada == null) {
            if (pieza != null && pieza.esPiezaDelJugadorActual()) {
                piezaSeleccionada = pieza;
                piezaSeleccionada.resaltarMovimientosValidos(piezaSeleccionada, piezas, celdas, fila, columna);
            }
        } else {
            if (piezaSeleccionada.esPosicionValida(fila, columna, piezas)) {
                Piezas piezaCapturada = piezas[fila][columna];

                if (piezaCapturada != null && piezaCapturada.esNegro != piezaSeleccionada.esNegro) {
                    piezaSeleccionada.capturarPieza(fila, columna, piezas, celdas, piezaCapturada);
                }

                piezas[piezaSeleccionada.fila][piezaSeleccionada.columna] = null;
                piezas[fila][columna] = piezaSeleccionada;

                piezaSeleccionada.moverPieza(fila, columna, piezas, celdas);
                piezaSeleccionada.colocarPieza(celdas[fila][columna], fila, columna);

                piezaSeleccionada.limpiarResaltado(celdas);

                Jugadores.juego.cambio_turno();

                piezaSeleccionada = null;
            } else {
                piezaSeleccionada.limpiarResaltado(celdas);
                piezaSeleccionada = null;
            }
        }
    }
}
