
package tareaA31;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class pag5 extends JPanel {
    
    // Añadimos un componente de tipo etiqueta JLabel
    private JLabel etiqueta;

    
    //Constructor pasado un color que llama al metodo initComponents()
    public pag5 (Color color){
        initComponents();
        cambiarColorFondo(color);
    }

    //Metodo que inicializar los elementos graficos del formulario
    private void initComponents(){
        //Construimos una etiqueta con el texto que queremos que muestre
        etiqueta = new JLabel ("Esta es mi primera practica");
        
        //Añadimos la etiqueta al contenedor JPanel
        this.add(etiqueta);
        
    }
    
    private void cambiarColorFondo(Color color){
        this.setBackground(color);
    }
    
    //Getter
    public JLabel getEtiqueta(){
        return etiqueta;
    }
    
    //Una vez creada la clase anterior se incluye un objeto de tipo de la clase dentro
   //de un contenedor principal (JFrame). 
    public static void main(String[] args) {
        
        //Construimos la ventana
        JFrame ventanaPrincipal = new JFrame ("Aplicacion");
        
        //Establecemos tamaño y posicion
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.add(new pag5(Color.lightGray));
        

    }
    
    
}
