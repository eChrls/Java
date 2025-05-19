package Login;
import java.awt.GridLayout;
import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

// Clase principal que extiende de JFrame y contiene los campos de login y botones principales
public class VentanaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoPassword;
    private JButton botonLogin;
    private JButton botonRegistrar;
    private JButton botonSalir;

    public VentanaLogin() {
        super("Login de usuario");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 2));

        // Etiqueta y campo de usuario
        this.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        this.add(campoUsuario);

        // Etiqueta y campo de contraseña
        this.add(new JLabel("Contraseña:"));
        campoPassword = new JPasswordField();
        this.add(campoPassword);

        // Botón login
        botonLogin = new JButton("Login");
        botonLogin.addActionListener(e -> login());
        this.add(botonLogin);

        // Botón registro abre modal DialogoRegistro
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.addActionListener(e -> new DialogoRegistro(this));
        this.add(botonRegistrar);

        // Botón salir
        botonSalir = new JButton("Salir");
        botonSalir.addActionListener(e -> System.exit(0));
        this.add(botonSalir);

        // Espacio de relleno
        this.add(new JLabel(""));

        this.setVisible(true);
    }

    // Método login: comprueba si el usuario y contraseña coinciden con algún registro del fichero
    private void login() {
        String usuario = campoUsuario.getText();
        String contrasena = String.valueOf(campoPassword.getPassword());

        try {
            List<String> lineas = Files.readAllLines(Paths.get("usuarios.csv"));
            for (String linea : lineas) {
                String[] partes = linea.split(",");
                if (partes.length == 2 && partes[0].equals(usuario) && partes[1].equals(contrasena)) {
                    JOptionPane.showMessageDialog(this, "Login correcto");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el fichero de usuarios");
        }
    }

    public static void main(String[] args) {
        new VentanaLogin();
    }
}

