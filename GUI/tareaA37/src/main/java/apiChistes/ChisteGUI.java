// Interfaz gráfica: recoge opciones, hace petición y muestra chistes.
package apiChistes;

import javax.swing.*;
import java.util.List;
import apiChistes.modelos2.Joke;
import apiChistes.modelos2.ListaChistes;
import apiChistes.conexion_http.ConexionHTTP;
import apiChistes.serviciojson.JsonService;

public class ChisteGUI extends JFrame {

    // componentes de la interfaz
    private JRadioButton rbEsp, rbEng;
    private JComboBox<String> cbCategoria;
    private JTextField tfCantidad;
    private JTextArea taSalida;
    private JButton btnObtener;
    private JCheckBox cbTwoPart; // añado la opcion para 2 partes

    public ChisteGUI() {
        initComponents();
    }

    // initComponents(): método generado por NetBeans para crear la UI
    private void initComponents() {
        rbEsp = new JRadioButton("Español");
        rbEng = new JRadioButton("Inglés");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbEsp);
        bg.add(rbEng);
        rbEsp.setSelected(true);
        //chiste 2 partes
        cbTwoPart = new JCheckBox("Sólo two–part", true);  // marcado por defecto

// Inicializa el combo con todas las categorías soportadas por la API
        cbCategoria = new JComboBox<>(new String[]{
            "Programming",
            "Misc",
            "Dark",
            "Pun",
            "Spooky",
            "Christmas",
            "Any"
        });
        tfCantidad = new JTextField("2", 3);
        btnObtener = new JButton("Obtener Chistes");
        taSalida = new JTextArea(10, 30);
        taSalida.setEditable(false);

        btnObtener.addActionListener(e -> obtenerChistes());

        JPanel panel = new JPanel();
        panel.add(new JLabel("Idioma:"));
        panel.add(rbEsp);
        panel.add(rbEng);
        panel.add(new JLabel("Categoría:"));
        panel.add(cbCategoria);
        panel.add(new JLabel("Cantidad (2-5):"));
        panel.add(tfCantidad);
        panel.add(btnObtener);
        panel.add(cbTwoPart);

        this.add(panel, "North");
        this.add(new JScrollPane(taSalida), "Center");
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    // obtenerChistes(): lee opciones, construye URL, parsea JSON y muestra en textarea
    private void obtenerChistes() {
        try {
            String lang = rbEsp.isSelected() ? "es" : "en";
            String cat = (String) cbCategoria.getSelectedItem();// la categoría elegida en el JComboBox
            int amt = Integer.parseInt(tfCantidad.getText().trim());//la cantidad de chistes que el usuario teclea en el JTextField.
            if (amt < 2 || amt > 5) {
                throw new NumberFormatException();
            }
            
            //Construye la url, primero divide si es 2 partes o 1 parte
            // luego añade categoria, lenguaje y cantidad de chistes (amount)
            String tipo = cbTwoPart.isSelected() ? "type=twopart" : "type=single,twopart";
            String url = String.format(
                    "https://v2.jokeapi.dev/joke/%s?lang=%s&%s&amount=%d",
                    cat, lang, tipo, amt
            );

            // petición HTTP y parseo JSON
            String json = ConexionHTTP.peticionHttpGet(url);
            JsonService<ListaChistes> service = new JsonService<>();
            ListaChistes lista = service.stringToPojo(json, ListaChistes.class);

            taSalida.setText("");
            List<Joke> jokes = lista.getJokes();
            if (jokes == null || jokes.isEmpty()) {
                taSalida.append("No se han obtenido chistes.\n");
                return;
            }
            for (Joke j : jokes) {
                taSalida.append(j.toString() + "\n");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Introduce un número entre 2 y 5.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error al obtener chistes:\n" + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // main(): arranca la GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChisteGUI().setVisible(true));
    }
}
