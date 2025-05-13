package tareaA31;

import java.awt.BorderLayout;
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

/*
a . El color de los paneles sea diferente al del ejemplo.
b . El nombre de la ventana sea tu nombre y apellidos.
c . La ventana no sea redimensionable.
d . El texto que se muestre en cada uno de los cinco paneles de color sea diferente
(pista: crea los paneles de forma independiente, accede a su etiqueta y 
cambia el texto de la misma usando el método setText de la etiqueta). 
 */
public class tareaFinal extends JPanel implements ActionListener {

    //Componentes graficos: boton y area de texto
    private JButton boton;
    private JTextArea texto;

    public tareaFinal() {

    }

    public static void main(String[] args) {

        //El nombre de la ventana sea tu nombre y apellidos.
        JFrame ventanaPrincipal = new JFrame("Carlos Torralvo");
        //El color de los paneles sea diferente al del ejemplo.
        ventanaPrincipal.setLayout(new BorderLayout());
        ventanaPrincipal.add(new pag9(Color.WHITE, "Panel Norte"), BorderLayout.NORTH);
        ventanaPrincipal.add(new pag9(Color.lightGray, "Panel Sur"), BorderLayout.SOUTH);
        ventanaPrincipal.add(new pag9(Color.CYAN, "Panel Centro"), BorderLayout.CENTER);
        ventanaPrincipal.add(new pag9(Color.GREEN, "Panel Oeste"), BorderLayout.WEST);
        ventanaPrincipal.add(new pag9(Color.YELLOW, "Panel Este"), BorderLayout.EAST);
        //La ventana no sea redimensionable.
        ventanaPrincipal.setResizable(false);
        // El texto que se muestre en cada uno de los cinco paneles de color sea diferente 
        //En clase origen pag9
        
        
        //resto de instrucciones
        ventanaPrincipal.pack();
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        texto.setText("Hola Mundo!");
    }

}
