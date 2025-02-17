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
    protected JFrame pantalla;
    private JLabel turno;
    private JPanel casillasSuperior;
    private JPanel casillasInferior;
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;
    public JPanel capturasJugador1;
    public JPanel capturasJugador2;
    private JTextArea movimientosJugador1;
    private JTextArea movimientosJugador2;
    private JScrollPane scrollMovimientos1;
    private JScrollPane scrollMovimientos2;
    private Piezas piezaSeleccionada;
    public static Tablero tab = new Tablero();

    public final void iniciarTablero() {
        pantalla = new JFrame("Xiangqi - Nueva partida");
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setSize(1200, 825);
        pantalla.setBackground(Color.decode("#891c00"));
        pantalla.setLocationRelativeTo(null);

        JPanel tablero = new JPanel(new BorderLayout());
        tablero.setBackground(Color.decode("#891c00"));

        turno = new JLabel("Turno: " + Jugadores.juego.jugador1.getUsername(), SwingConstants.CENTER);
        turno.setFont(new Font("Arial", Font.BOLD, 20));
        turno.setForeground(Color.BLACK);
        turno.setBackground(Color.LIGHT_GRAY);
        turno.setOpaque(true);

        JPanel panelTurno = new JPanel(new BorderLayout());
        panelTurno.setBackground(Color.decode("#891c00"));
        panelTurno.add(turno, BorderLayout.CENTER);

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

        capturasJugador1 = new JPanel(new GridLayout(4, 4));
        capturasJugador1.setBackground(Color.LIGHT_GRAY);
        capturasJugador2 = new JPanel(new GridLayout(4, 4));
        capturasJugador2.setBackground(Color.LIGHT_GRAY);

        panelIzquierdo = new JPanel();
        panelIzquierdo.setPreferredSize(new Dimension(255, 0));
        panelIzquierdo.setBackground(Color.LIGHT_GRAY);
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));

        JLabel labelJugador1 = new JLabel("Jugador 1: " + Jugadores.juego.jugador1.getUsername() + " (Rojo)", SwingConstants.CENTER);
        labelJugador1.setFont(new Font("Arial", Font.BOLD, 18));
        labelJugador1.setForeground(Color.RED);
        panelIzquierdo.add(labelJugador1);

        panelIzquierdo.add(Box.createVerticalStrut(20));

        JLabel piezasCapturadas1 = new JLabel("Capturas:", SwingConstants.CENTER);
        piezasCapturadas1.setFont(new Font("Arial", Font.BOLD, 16));
        piezasCapturadas1.setForeground(Color.BLACK);
        panelIzquierdo.add(piezasCapturadas1);
        panelIzquierdo.add(capturasJugador1);

        panelIzquierdo.add(Box.createVerticalStrut(10));

        panelDerecho = new JPanel();
        panelDerecho.setPreferredSize(new Dimension(255, 0));
        panelDerecho.setBackground(Color.LIGHT_GRAY);
        panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));

        JLabel labelJugador2 = new JLabel("Jugador 2: " + Jugadores.juego.jugador2.getUsername() + " (Negro)", SwingConstants.CENTER);
        labelJugador2.setFont(new Font("Arial", Font.BOLD, 18));
        labelJugador2.setForeground(Color.BLACK);
        panelDerecho.add(labelJugador2);

        panelDerecho.add(Box.createVerticalStrut(20));

        JLabel piezasCapturadas2 = new JLabel("Capturas:", SwingConstants.CENTER);
        piezasCapturadas2.setFont(new Font("Arial", Font.BOLD, 16));
        piezasCapturadas2.setForeground(Color.BLACK);
        panelDerecho.add(piezasCapturadas2);
        panelDerecho.add(capturasJugador2);

        panelDerecho.add(Box.createVerticalStrut(10));

        movimientosJugador1 = new JTextArea(10, 20);
        movimientosJugador1.setEditable(false);
        scrollMovimientos1 = new JScrollPane(movimientosJugador1);
        panelIzquierdo.add(scrollMovimientos1);

        movimientosJugador2 = new JTextArea(10, 20);
        movimientosJugador2.setEditable(false);
        scrollMovimientos2 = new JScrollPane(movimientosJugador2);
        panelDerecho.add(scrollMovimientos2);

        tablero.add(crearPanelNumeros(), BorderLayout.WEST);
        tablero.add(crearPanelNumeros(), BorderLayout.EAST);
        tablero.add(crearPanelLetras(), BorderLayout.NORTH);
        tablero.add(crearPanelLetras(), BorderLayout.SOUTH);
        tablero.add(contenedorCasillas, BorderLayout.CENTER);

        JButton botonSalir = new JButton("Rendirse");
        botonSalir.setFont(new Font("Arial", Font.BOLD, 16));
        botonSalir.setBackground(Color.decode("#891c00"));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas abandonar la partida?\n(Se contara como derrota automaticamente.)");

            if (confirmacion == 0) {
                if (Jugadores.juego.jugador_actual == Jugadores.juego.jugador1) {
                    JOptionPane.showMessageDialog(null, "El jugador " + Jugadores.juego.jugador2.getUsername() + " vencio a " + Jugadores.juego.jugador1.getUsername() + ".\n¡Felicidades, has ganado 3 puntos!");
                    Jugadores.juego.jugador2.setPuntos(Jugadores.juego.jugador2.getPuntos() + 3);
                    Jugadores.juego.jugador2.setPartidas_ganadas(Jugadores.juego.jugador2.getPartidas_ganadas() + 1);
                    Jugadores.juego.jugador1.setPartidas_perdidas(Jugadores.juego.jugador1.getPartidas_perdidas() + 1);
                    Jugadores.juego.jugador2.añadir_log("¡El jugador " + Jugadores.juego.jugador2.getUsername() + " gana porque " + Jugadores.juego.jugador1.getUsername() + " ha abandonado la partida!");
                    Jugadores.juego.jugador1.añadir_log("¡El jugador " + Jugadores.juego.jugador1.getUsername() + " pierde contra " + Jugadores.juego.jugador2.getUsername() + " porque ha abandonado la partida!");
                    for (int i = 0; i < 100; i++) {
                        Jugadores.juego.jugador1.movimientos[i] = null;
                        Jugadores.juego.jugador2.movimientos[i] = null;
                    }
                } else if (Jugadores.juego.jugador_actual == Jugadores.juego.jugador2) {
                    JOptionPane.showMessageDialog(null, "El jugador " + Jugadores.juego.jugador1.getUsername() + " vencio a " + Jugadores.juego.jugador2.getUsername() + ".\n¡Felicidades, has ganado 3 puntos!");
                    Jugadores.juego.jugador1.setPuntos(Jugadores.juego.jugador1.getPuntos() + 3);
                    Jugadores.juego.jugador1.setPartidas_ganadas(Jugadores.juego.jugador1.getPartidas_ganadas() + 1);
                    Jugadores.juego.jugador2.setPartidas_perdidas(Jugadores.juego.jugador2.getPartidas_perdidas() + 1);
                    Jugadores.juego.jugador1.añadir_log("¡El jugador " + Jugadores.juego.jugador1.getUsername() + " gana porque " + Jugadores.juego.jugador2.getUsername() + " ha abandonado la partida!");
                    Jugadores.juego.jugador2.añadir_log("¡El jugador " + Jugadores.juego.jugador2.getUsername() + " pierde contra " + Jugadores.juego.jugador1.getUsername() + " porque ha abandonado la partida!");
                    for (int i = 0; i < 100; i++) {
                        Jugadores.juego.jugador1.movimientos[i] = null;
                        Jugadores.juego.jugador2.movimientos[i] = null;
                    }
                }
                pantalla.dispose();
                LogicaDeVictoria.victoria.finDelJuego = true;
                Menu_Principal menu = new Menu_Principal();
                menu.Menu_Principal();
            }
        });

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(Color.LIGHT_GRAY);
        panelBoton.add(botonSalir);

        pantalla.setLayout(new BorderLayout());
        pantalla.add(panelIzquierdo, BorderLayout.WEST);
        pantalla.add(panelTurno, BorderLayout.NORTH);
        pantalla.add(tablero, BorderLayout.CENTER);
        pantalla.add(panelDerecho, BorderLayout.EAST);
        pantalla.add(panelBoton, BorderLayout.SOUTH);

        pantalla.setVisible(true);

        colocarPiezasIniciales();
        Jugadores.juego.jugador_actual = Jugadores.juego.jugador1;
    }

    private String turno() {
        return "Turno: " + Jugadores.juego.jugador_actual.getUsername();
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
        for (int i = 1; i <= 10; i++) {
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

    public void agregarPiezaCapturada(Piezas piezaCapturada) {
        if (piezaCapturada == null) {
            return;
        }

        JLabel pieza_capturada = new JLabel();
        pieza_capturada.setPreferredSize(new Dimension(40, 40));
        pieza_capturada.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

        String nombreArchivo = obtenerNombreArchivoImagen(piezaCapturada);
        ImageIcon imagenPieza = new ImageIcon(getClass().getResource("/imagenes/" + nombreArchivo));
        Image imagen = imagenPieza.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        pieza_capturada.setHorizontalAlignment(SwingConstants.CENTER);
        pieza_capturada.setIcon(new ImageIcon(imagen));

        if (piezaCapturada.esNegro) {
            capturasJugador1.add(pieza_capturada);
        } else {
            capturasJugador2.add(pieza_capturada);
        }
    }

    public String obtenerNombreArchivoImagen(Piezas pieza) {
        String tipoPieza = pieza.getClass().getSimpleName().toLowerCase();
        String color = pieza.esNegro ? "negro" : "rojo";
        return tipoPieza + "-" + color + ".png";
    }

    private void mostrarMovimientos() {
        if (Jugadores.juego.jugador1.getMovimientos() != null) {
            movimientosJugador1.setText("");
            for (String movimiento : Jugadores.juego.jugador1.getMovimientos()) {
                if (movimiento != null) {
                    movimientosJugador1.append(movimiento + "\n");
                }
            }
        }

        if (Jugadores.juego.jugador2.getMovimientos() != null) {
            movimientosJugador2.setText("");
            for (String movimiento : Jugadores.juego.jugador2.getMovimientos()) {
                if (movimiento != null) {
                    movimientosJugador2.append(movimiento + "\n");
                }
            }
        }
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

        LogicaDeVictoria.victoria.finDelJuego = false;

        for (int fila = 0; fila < 10; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (piezas[fila][columna] != null) {
                    Piezas pieza = piezas[fila][columna];
                    if (pieza != null) {
                        if (pieza.esNegro) {
                            if (Jugadores.juego.jugador2 != null) {
                                Jugadores.juego.jugador2.agregarPieza(fila, columna, pieza);
                            }
                        } else if (!pieza.esNegro) {
                            if (Jugadores.juego.jugador1 != null) {
                                Jugadores.juego.jugador1.agregarPieza(fila, columna, pieza);
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
            if (pieza != null) {
                if (pieza.esPiezaDelJugadorActual()) {
                    piezaSeleccionada = pieza;
                    piezaSeleccionada.resaltarMovimientosValidos(piezaSeleccionada, piezas, celdas, fila, columna);
                } else if (!pieza.esPiezaDelJugadorActual()) {
                    JOptionPane.showMessageDialog(null, "Esta pieza no es tuya.");
                }
            }
        } else {
            if (piezaSeleccionada.esPosicionValida(fila, columna, piezas)) {
                Piezas piezaCapturada = piezas[fila][columna];

                if (piezaCapturada != null && piezaCapturada.esNegro != piezaSeleccionada.esNegro) {
                    piezaSeleccionada.capturarPieza(fila, columna, piezas, celdas, piezaCapturada);
                    agregarPiezaCapturada(piezaCapturada);
                }

                piezas[piezaSeleccionada.fila][piezaSeleccionada.columna] = null;
                piezas[fila][columna] = piezaSeleccionada;

                piezaSeleccionada.moverPieza(fila, columna, piezas, celdas);
                String movimiento = "Movimiento: " + piezaSeleccionada.getClass().getSimpleName() + " a Fila: " + (fila + 1) + " - Columna: " + (columna + 1);
                Jugadores.juego.jugador_actual.agregarMovimientos(movimiento);
                mostrarMovimientos();
                piezaSeleccionada.colocarPieza(celdas[fila][columna], fila, columna);

                piezaSeleccionada.limpiarResaltado(celdas);

                if (!LogicaDeVictoria.victoria.gameOver(piezas)) {
                    Jugadores.juego.cambio_turno();
                    turno.setText(turno());
                } else {
                    pantalla.dispose();
                }

                piezaSeleccionada = null;
            } else {
                piezaSeleccionada.limpiarResaltado(celdas);
                piezaSeleccionada = null;
            }
        }
    }
}
