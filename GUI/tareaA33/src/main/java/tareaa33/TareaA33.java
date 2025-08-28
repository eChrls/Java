/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tareaa33;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TareaA33 extends JFrame {
    // * Incluye dos JLabel y dos JButton como atributos, en la clase del JFrame
    // Declaramos los componentes como atributos de la clase
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JButton botonAleatorio;
    private JButton botonRaton;
    
    public TareaA33() {
        super("Mi Aplicación");
        
        // * Modifica el layout de esta ventana, a FlowLayout, en el constructor de la ventana
        setLayout(new FlowLayout());
        
        // * Llama al método anterior en el constructor y comprueba resultados
        configurarTamanoYPosicion();
        
        // * Llama al método anterior en el constructor de la ventana
        // Inicializamos y añadimos los componentes al frame
        inicializarComponentes();
        
        // * Llama al método en el constructor y prueba el comportamiento
        // Configuramos el evento del botón aleatorio
        configurarEventoBotonAleatorio();
        
        // * Invoca al método anterior en el constructor y prueba los resultados
        // Configuramos los eventos del botón ratón
        configurarEventosBotonRaton();
        
        // Configuración básica para la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    // * Crea un método privado, que permita modificar el tamaño de este frame a 400x200 px de ancho y alto 
    // * y aparezca justo en el centro de la pantalla
    private void configurarTamanoYPosicion() {
        // Establecemos el tamaño de la ventana a 400x200 píxeles
        setSize(400, 200);
        
        // Centramos la ventana en la pantalla
        setLocationRelativeTo(null);
    }
    
    // * Crea un método privado que inicialice los JLabel con los textos "etiqueta1" y "etiqueta2".
    // * Los botones deben ser inicializados con los textos, "Aleatorio" y "Raton".
    // * El método también añade los cuatro componentes al JFrame, de forma que aparezcan en el siguiente orden: 
    // * boton1, etiqueta1, boton2, etiqueta2.
    private void inicializarComponentes() {
        // Inicializamos etiquetas con textos predeterminados
        etiqueta1 = new JLabel("etiqueta1");
        etiqueta2 = new JLabel("etiqueta2");
        
        // Inicializamos botones con textos específicos
        botonAleatorio = new JButton("Aleatorio");
        botonRaton = new JButton("Raton");
        
        // Añadimos componentes al frame en el orden especificado
        add(botonAleatorio); 
        add(etiqueta1);     
        add(botonRaton); 
        add(etiqueta2);    
    }
    
    // * Crea un método privado y añade al botón "Aleatorio" un controlador de eventos, 
    // * usando clases internas anónimas, de forma que al pulsar sobre él, se genere 
    // * un número aleatorio entre 0 y 10 y se modifique el texto en la etiqueta1.
    private void configurarEventoBotonAleatorio() {
        // Añadimos ActionListener usando clase anónima
        botonAleatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generamos número aleatorio entre 0 y 10
                Random random = new Random();
                int numeroAleatorio = random.nextInt(11); // 0-10 
                
                // Modificamos el texto de la etiqueta1 con el número aleatorio
                etiqueta1.setText("Número: " + numeroAleatorio);
            }
        });
    }
    
    // * Crea un método privado y añade al botón "Raton" un controlador de eventos del tipo MouseListener, 
    // implementado solamente los métodos mouseEntered y mouseExited, de forma que cuando el ratón 
    //  se sitúe sobre el botón cambie de color (elige uno que te guste) y cuando el ratón salga 
    // de la zona del botón, vuelva al color gris.
    // Añade un controlador de eventos de tipo ActionListener sobre el botón "Ratón", para que al pulsar 
    // sobre él, se llame al método que abre el JOption y se modifique el texto de la etiqueta2.
    private void configurarEventosBotonRaton() {
        // Añadimos MouseListener para cambiar color cuando el ratón entra/sale
        botonRaton.addMouseListener(new MouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambiamos a color cyan cuando el ratón entra
                botonRaton.setBackground(Color.CYAN);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // Volvemos al color gris cuando el ratón sale
                botonRaton.setBackground(Color.LIGHT_GRAY);
            }
            
            // Métodos obligatorios de la interfaz sin implementación
            @Override
            public void mouseClicked(MouseEvent e) {}
            
            @Override
            public void mousePressed(MouseEvent e) {}
            
            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        
        // Habilitamos la opción de mostrar el fondo del botón
        botonRaton.setOpaque(true);
        
        // Añadimos ActionListener para mostrar el JOptionPane al hacer clic
        botonRaton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoYModificarEtiqueta();
            }
        });
    }
    
    // * En un método privado, abre un JOption y solicita cualquier dato de tipo texto.
    // * Modifica, en este método, el texto mostrado en el label2 para que sea el texto 
    // * introducido en el JOptionPane.
    private void mostrarDialogoYModificarEtiqueta() {
        // Solicitamos texto al usuario mediante JOptionPane
        String textoIntroducido = JOptionPane.showInputDialog(this, "Introduce un texto:");
        
        // Si el usuario introdujo texto (no canceló), modificamos la etiqueta2
        if (textoIntroducido != null) {
            etiqueta2.setText(textoIntroducido);
        }
    }
    
    // Método principal para ejecutar y probar la aplicación
    public static void main(String[] args) {
        // Creamos la ventana dentro del hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TareaA33();
            }
        });
    }
}