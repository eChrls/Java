

package CalculadoraGUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Panel con los 16 botones de la calculadora:
 * dígitos 0–9, operaciones +, –, *, /, resultado = y limpiar C.
 */
public class PanelBotones extends JPanel {

    // Array de botones: 0–9, +, –, *, /, =, C
    private final JButton[] grupoBotones = new JButton[16];

    /**
     * Constructor: inicializa componentes.
     */
    public PanelBotones() {
        initComponents();
    }

    /**
     * Crea los botones, los añade al GridLayout 4x4.
     */
    private void initComponents() {
        // Botones 0–9
        for (int i = 0; i < 10; i++) {
            grupoBotones[i] = new JButton(Integer.toString(i));
        }
        // Operadores y funciones
        grupoBotones[10] = new JButton("+");
        grupoBotones[11] = new JButton("-");
        grupoBotones[12] = new JButton("*");
        grupoBotones[13] = new JButton("/");
        grupoBotones[14] = new JButton("=");
        grupoBotones[15] = new JButton("C");

        // Configuramos GridLayout 4x4 y añadimos botones
        this.setLayout(new GridLayout(4, 4));
        for (JButton boton : grupoBotones) {
            this.add(boton);
        }
    }

    /**
     * Devuelve el array de botones para añadir listeners.
     */
    public JButton[] getGrupoBotones() {
        return grupoBotones;
    }
}
