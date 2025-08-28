/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;
// Clase JDialog para registro y modificación de contraseña

import java.awt.GridLayout;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class DialogoRegistro extends JDialog {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JPasswordField campoConfirmar;
    private JCheckBox mostrar;
    private JButton guardar;

    public DialogoRegistro(JFrame owner) {
        super(owner, "Registro de Usuario", true);
        this.setSize(350, 250);
        this.setLocationRelativeTo(owner);
        this.setLayout(new GridLayout(5, 2));

        this.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        this.add(campoUsuario);

        this.add(new JLabel("Contraseña:"));
        campoPassword = new JPasswordField();
        this.add(campoPassword);

        this.add(new JLabel("Confirmar Contraseña:"));
        campoConfirmar = new JPasswordField();
        this.add(campoConfirmar);

        mostrar = new JCheckBox("Mostrar contraseñas");
        mostrar.addActionListener(e -> {
            boolean visible = mostrar.isSelected();
            campoPassword.setEchoChar(visible ? (char) 0 : '•');
            campoConfirmar.setEchoChar(visible ? (char) 0 : '•');
        });
        this.add(mostrar);
        this.add(new JLabel(""));

        guardar = new JButton("Guardar");
        guardar.addActionListener(e -> guardarUsuario());
        this.add(guardar);

        this.setVisible(true);
    }

    // Método que registra o modifica un usuario en el fichero
    private void guardarUsuario() {
        String usuario = campoUsuario.getText();
        String pass = String.valueOf(campoPassword.getPassword());
        String confirm = String.valueOf(campoConfirmar.getPassword());

        if (usuario.isBlank() || pass.isBlank() || confirm.isBlank()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            return;
        }

        Path ruta = Paths.get("usuarios.csv");
        List<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        try {
            if (Files.exists(ruta)) {
                lineas = Files.readAllLines(ruta);
                for (int i = 0; i < lineas.size(); i++) {
                    String[] partes = lineas.get(i).split(",");
                    if (partes[0].equals(usuario)) {
                        lineas.set(i, usuario + "," + pass);
                        encontrado = true;
                        break;
                    }
                }
            }
            if (!encontrado) {
                lineas.add(usuario + "," + pass);
            }
            Files.write(ruta, lineas);
            JOptionPane.showMessageDialog(this, "Usuario registrado/modificado correctamente");
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al escribir en el fichero");
        }
    }
}
