package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.AlphaComposite;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * FondoPanel
 * Panel personalizado para mostrar una imagen de fondo con opacidad ajustable.
 * Se puede usar como fondo de cualquier JFrame o JPanel en la aplicación.
 *
 * Uso recomendado:
 * - Crea un FondoPanel con la ruta de la imagen y el nivel de opacidad deseado (0.0f totalmente transparente, 1.0f totalmente opaco).
 * - Añade tus componentes encima de este panel.
 */
public class FondoPanel extends JPanel {
    private Image imagen;      // Imagen de fondo
    private float opacidad;    // Nivel de opacidad (0.0f a 1.0f)

    /**
     * Constructor del panel de fond
     */
    public FondoPanel(String rutaImagen, float opacidad) {
        // Carga la imagen del recurso
        this.imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        this.opacidad = opacidad;
        setOpaque(false); // Permite que la imagen se pinte con transparencia[2][3]
    }

    /**
     * Sobrescribe el método paintComponent para pintar la imagen de fondo
     * con la opacidad indicada.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            // Crea un contexto gráfico 2D para aplicar la opacidad
            Graphics2D g2d = (Graphics2D) g.create();
            // Aplica la opacidad al contexto gráfico
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacidad));
            // Dibuja la imagen escalada al tamaño del panel
            g2d.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    }
}
