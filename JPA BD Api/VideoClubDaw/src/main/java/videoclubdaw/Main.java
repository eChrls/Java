package videoclubdaw;

import views.LoginFrame;

public class Main {

    public static void main(String[] args) {
        // Establece el Look & Feel Nimbus si está disponible
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Si falla, sigue con el look & feel por defecto
        }

        // Lanza el login en el hilo de eventos de Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}
