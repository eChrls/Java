
package tareaA31;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class pag11 extends JPanel implements ActionListener{
    
    //Componentes graficos: boton y area de texto
    private JButton boton;
    private JTextArea texto;
    
    public pag11(){
        initComponents();
    }
    
    private void initComponents(){
        //Tamaño panel
        this.setPreferredSize(new Dimension(600,200));
        //Borde del panel
        this.setBorder(new TitledBorder ("Borde del panel"));
        //creamos el boton
        boton = new JButton ("Saludar");
        //Creamos el textArea de una fila por 25 columnas
        texto = new JTextArea(1,25);
        //Establecemos el color de fondo del textArea
        texto.setBackground(Color.ORANGE);
        //Posicionamiento de componentes con FlowLayout
        this.setLayout(new FlowLayout());
        //Añadimos los componentes
        this.add(boton);
        this.add(texto);
        
        //Se le indica al botejo boton que escuche eventos de tipo click
        //Y se pasa como argumento una referencia de tipo ActionListener
        boton.addActionListener(this);
    }
    
    
    public static void main(String[] args) {
        
        //Construimos la ventana
        JFrame frame = new JFrame("App");
        //La ventana no se puede redimensionar
        frame.setResizable(false);
        //Posicion de la ventana en el centro
        frame.setLocationRelativeTo(null);
        //incluimos el panel de la clase pag11 en la ventana
        frame.add(new pag11());
        frame.pack();
        //hacemos visible la ventana
        frame.setVisible(true);
        //Accion por defecto al pulsar el boton de cierre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    texto.setText("Hola Mundo!");
    }
    
}
