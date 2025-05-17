package InterfacesJTable;

import InterfacesJTable.vistas.MainWindow;

/**
 * Clase principal de la aplicación
 */
public class InterfazGrafica {

    /**
     * Método principal que inicia la aplicación
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar look and feel de la aplicación
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error al establecer el Look & Feel: " + e.getMessage());
        }

        // Iniciar la aplicación en el Event Dispatch Thread
        java.awt.EventQueue.invokeLater(() -> {
            MainWindow ventanaPrincipal = new MainWindow();
            ventanaPrincipal.setVisible(true);
        });
    }
}
