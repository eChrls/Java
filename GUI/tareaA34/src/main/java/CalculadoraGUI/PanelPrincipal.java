
package CalculadoraGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * Panel principal que contiene:
 * - Área de texto para mostrar operaciones y resultados.
 * - Panel de botones (PanelBotones).
 * Implementa ActionListener para gestionar eventos de botones.
 */
public class PanelPrincipal extends JPanel implements ActionListener {

    private PanelBotones panelBotones;  // Panel con los botones
    private JTextArea areaTexto;        // Área de texto para mostrar datos
    private double primerOperando;      // Primer número ingresado
    private String operador;            // Operador seleccionado

    /**
     * Constructor: inicializa componentes y estado inicial.
     */
    public PanelPrincipal() {
        initComponents();
        operador = "";
        primerOperando = 0;
    }

    /**
     * Inicializa y organiza los componentes gráficos.
     */
    private void initComponents() {
        panelBotones = new PanelBotones();
        areaTexto = new JTextArea(2, 20);
        areaTexto.setEditable(false);
        areaTexto.setBackground(Color.WHITE);

        this.setLayout(new BorderLayout());
        this.add(areaTexto, BorderLayout.NORTH);
        this.add(panelBotones, BorderLayout.SOUTH);

        // Añade ActionListener a cada botón
        for (JButton boton : panelBotones.getGrupoBotones()) {
            boton.addActionListener(this);
        }
    }

    /**
     * Maneja los eventos de los botones.Evento de acción generado por un botón.
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String texto = ((JButton) ae.getSource()).getText();

        // Si es un dígito o punto decimal
        if (texto.length() == 1 && (Character.isDigit(texto.charAt(0)) || texto.charAt(0) == '.')) {
            areaTexto.append(texto);
            return;
        }

        // Si es un operador: +, -, *, /
        switch (texto) {
            case "+":
            case "-":
            case "*":
            case "/":
                primerOperando = Double.parseDouble(areaTexto.getText());
                operador = texto;
                areaTexto.setText("");
                return;
            case "=":
                double segundoOperando = Double.parseDouble(areaTexto.getText());
                double resultado = 0;
                switch (operador) {
                    case "+" -> resultado = primerOperando + segundoOperando;
                    case "-" -> resultado = primerOperando - segundoOperando;
                    case "*" -> resultado = primerOperando * segundoOperando;
                    case "/" -> {
                        if (segundoOperando != 0) {
                            resultado = primerOperando / segundoOperando;
                        } else {
                            areaTexto.setText("Error: División por cero");
                            return;
                        }
                }
                    default -> {
                        return;
                }
                }
                areaTexto.setText(Double.toString(resultado));
                return;

            case "C":
                areaTexto.setText("");
                operador = "";
                primerOperando = 0;
        }
    }
}
