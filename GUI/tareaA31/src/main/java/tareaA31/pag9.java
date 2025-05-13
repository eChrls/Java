package tareaA31;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pag9 extends JPanel {

    // Añadimos un componente de tipo etiqueta JLabel
    private JLabel etiqueta;


    //Constructor pasado un color que llama al metodo initComponents()
    public pag9(Color color, String texto) {
        initComponents(texto);
        cambiarColorFondo(color);
    }

    //Metodo que inicializar los elementos graficos del formulario
    private void initComponents(String texto) {
        //Construimos una etiqueta con el texto que queremos que muestre
        etiqueta = new JLabel(texto);

        //Añadimos la etiqueta al contenedor JPanel
        this.add(etiqueta);

    }

    private void cambiarColorFondo(Color color) {
        this.setBackground(color);
    }

    //Getter
    public JLabel getEtiqueta() {
        return etiqueta;
    }

    //Una vez creada la clase anterior se incluye un objeto de tipo de la clase dentro
    //de un contenedor principal (JFrame). 
    public static void main(String[] args) {

        //Construimos la ventana
        JFrame ventanaPrincipal = new JFrame("Aplicacion");

        //Establecemos tamaño y posicion
        ventanaPrincipal.setSize(800, 600);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //coloca la ventana en el centro
        ventanaPrincipal.setLocationRelativeTo(null);
        //añade constructor con color
        // ventanaPrincipal.add(new pag9(Color.lightGray));
        //hace que la ventana se adapte al tamaño
        //ventanaPrincipal.pack();
        //Establecemos el layout (diversas cajas dentro de un marco)
        //Hay que construir y  importar BorderLayout
        ventanaPrincipal.setLayout(new BorderLayout());
        //añadimos los paneles en cada posicion del BorderLayOut
//        ventanaPrincipal.add(new pag9(Color.YELLOW), BorderLayout.NORTH);
//        ventanaPrincipal.add(new pag9(Color.red), BorderLayout.SOUTH);
//        ventanaPrincipal.add(new pag9(Color.gray), BorderLayout.CENTER);
//        ventanaPrincipal.add(new pag9(Color.green), BorderLayout.WEST);
//        ventanaPrincipal.add(new pag9(Color.cyan), BorderLayout.EAST);

    }

}
