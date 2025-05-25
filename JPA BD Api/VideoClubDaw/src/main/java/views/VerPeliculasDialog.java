package views;

import controller.AlquilerController;
import controller.FichaTecnicaController;
import entity.FichaTecnica;
import entity.Pelicula;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Diálogo modal para mostrar las películas disponibles en una tabla. Permite
 * ver ficha técnica y alquilar.
 */
public class VerPeliculasDialog extends javax.swing.JDialog {

    private List<Pelicula> peliculas;
    private boolean esAdmin;
    private FichaTecnicaController fichaTecnicaController;
    private AlquilerController alquilerController;
    private entity.Usuario usuarioLogueado;

    /**
     * Constructor principal.
     */
    public VerPeliculasDialog(
            java.awt.Frame parent,
            boolean modal,
            List<Pelicula> peliculas,
            boolean esAdmin,
            entity.Usuario usuarioLogueado,
            AlquilerController alquilerController,
            FichaTecnicaController fichaTecnicaController
    ) {
        super(parent, modal);
        this.peliculas = peliculas;
        this.esAdmin = esAdmin;
        this.usuarioLogueado = usuarioLogueado;
        this.alquilerController = alquilerController;
        this.fichaTecnicaController = fichaTecnicaController;
        initComponents();
        personalizarVisual();
        cargarTabla();
        setLocationRelativeTo(parent);
    }

    /**
     * Personaliza fuentes, colores y aspecto visual.
     */
    private void personalizarVisual() {
        java.awt.Font fuenteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20);
        java.awt.Font fuenteTabla = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);

        lblTitulo.setFont(fuenteTitulo);
        tablaPeliculas.setFont(fuenteTabla);
        btnAtras.setFont(fuenteTabla);
        getContentPane().setBackground(new java.awt.Color(245, 245, 245));
    }

    /**
     * Carga las películas en la tabla, mostrando ID, título y año.
     */
    private void cargarTabla() {
        // Define las columnas de la tabla
        String[] columnas = {"Portada", "ID", "Título", "Año", "Ver ficha técnica", "Alquilar"};

        // Modelo personalizado para mostrar imágenes y controlar columnas editables
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 5;
            }

            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) {
                    return ImageIcon.class;
                }
                return Object.class;
            }
        };

        // Añade las filas al modelo
        for (Pelicula p : peliculas) {
            ImageIcon icono = null;
            try {
                ImageIcon original = new ImageIcon(getClass().getResource("/img/" + p.getPortada()));
                int ancho = 80, alto = 80;
                int imgAncho = original.getIconWidth();
                int imgAlto = original.getIconHeight();
                double ratio = Math.min((double) ancho / imgAncho, (double) alto / imgAlto);
                int newAncho = (int) (imgAncho * ratio);
                int newAlto = (int) (imgAlto * ratio);
                Image imgEscalada = original.getImage().getScaledInstance(newAncho, newAlto, Image.SCALE_SMOOTH);

                java.awt.image.BufferedImage thumb = new java.awt.image.BufferedImage(ancho, alto, java.awt.image.BufferedImage.TYPE_INT_RGB);
                java.awt.Graphics2D g2 = thumb.createGraphics();
                g2.setColor(java.awt.Color.WHITE);
                g2.fillRect(0, 0, ancho, alto);
                g2.drawImage(imgEscalada, (ancho - newAncho) / 2, (alto - newAlto) / 2, null);
                g2.dispose();

                icono = new ImageIcon(thumb);
            } catch (Exception ex) {
                // Si hay error, deja el icono en null o pon una imagen por defecto
            }

            Object[] fila = {
                icono,
                p.getIdPelicula(),
                p.getTitulo(),
                p.getAnyoEstreno(),
                "Ver ficha técnica",
                "Alquilar"
            };
            modelo.addRow(fila);
        }

        // Asigna el modelo a la tabla y ajusta la altura de las filas
        tablaPeliculas.setModel(modelo);
        tablaPeliculas.setRowHeight(80);

        // IMPORTANTE: Elimina listeners anteriores para evitar duplicados
        for (java.awt.event.MouseListener ml : tablaPeliculas.getMouseListeners()) {
            tablaPeliculas.removeMouseListener(ml);
        }

        // Añade el MouseListener para todas las acciones de la tabla
        tablaPeliculas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablaPeliculas.rowAtPoint(evt.getPoint());
                int col = tablaPeliculas.columnAtPoint(evt.getPoint());

                // 0: Portada (thumbnail)
                if (row >= 0 && col == 0) {
                    Pelicula peliculaSeleccionada = peliculas.get(row);
                    try {
                        ImageIcon original = new ImageIcon(getClass().getResource("/img/" + peliculaSeleccionada.getPortada()));

                        // Calcula tamaño adaptable (máx 500x500, proporcional)
                        int maxAncho = 500, maxAlto = 500;
                        int imgAncho = original.getIconWidth();
                        int imgAlto = original.getIconHeight();
                        double ratio = Math.min((double) maxAncho / imgAncho, (double) maxAlto / imgAlto);
                        int newAncho = (int) (imgAncho * ratio);
                        int newAlto = (int) (imgAlto * ratio);

                        Image imgEscalada = original.getImage().getScaledInstance(newAncho, newAlto, Image.SCALE_SMOOTH);
                        JLabel labelImg = new JLabel(new ImageIcon(imgEscalada));

                        // Crea un JDialog modal para mostrar la imagen
                        JDialog dialogImg = new JDialog((java.awt.Frame) getParent(), "Portada de " + peliculaSeleccionada.getTitulo(), true);
                        dialogImg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        dialogImg.getContentPane().add(labelImg);
                        dialogImg.pack();
                        dialogImg.setResizable(false);
                        dialogImg.setLocationRelativeTo(VerPeliculasDialog.this);
                        dialogImg.setVisible(true);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(VerPeliculasDialog.this, "No se pudo cargar la imagen.");
                    }
                }

                // 4: Ver ficha técnica
                if (row >= 0 && col == 4) {
                    Pelicula peliculaSeleccionada = peliculas.get(row);
                    FichaTecnica ficha = fichaTecnicaController.buscarPorPelicula(peliculaSeleccionada);
                    if (ficha != null) {
                        VerFichaTecnicaDialog dialog = new VerFichaTecnicaDialog((java.awt.Frame) getParent(), true, ficha);
                        dialog.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(VerPeliculasDialog.this, "No hay ficha técnica para esta película.");
                    }
                }

                // 5: Alquilar
                if (row >= 0 && col == 5) {
                    Pelicula peliculaSeleccionada = peliculas.get(row);
                    int confirm = JOptionPane.showConfirmDialog(
                            VerPeliculasDialog.this,
                            "¿Quieres alquilar la película \"" + peliculaSeleccionada.getTitulo() + "\"?",
                            "Confirmar alquiler",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        boolean exito = alquilerController.alquilarPelicula(usuarioLogueado, peliculaSeleccionada);
                        if (exito) {
                            JOptionPane.showMessageDialog(
                                    VerPeliculasDialog.this,
                                    "¡Película alquilada correctamente!",
                                    "Alquiler realizado",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        } else {
                            JOptionPane.showMessageDialog(
                                    VerPeliculasDialog.this,
                                    "Ya tienes esta película alquilada.",
                                    "Alquiler no permitido",
                                    JOptionPane.WARNING_MESSAGE
                            );
                        }
                    }
                }
            }
        });
    }

    /**
     * Acción del botón Atrás: cierra el diálogo.
     */
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPeliculas = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setText("Peliculas Disponibles: ");

        tablaPeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPeliculas);

        btnAtras.setText("Atrás");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crea la lista de películas de prueba
                java.util.List<entity.Pelicula> peliculasPrueba = new java.util.ArrayList<>();
                // Ejemplo de película de prueba
                entity.Pelicula peli = new entity.Pelicula();
                peli.setIdPelicula(1L);
                peli.setTitulo("Película de Prueba");
                peli.setAnyoEstreno(2024);
                peli.setPortada("psicosis.jpg"); // Asegúrate de tener la imagen en /img/
                peliculasPrueba.add(peli);

                // Crea un usuario de prueba
                entity.Usuario usuarioPrueba = new entity.Usuario();
                usuarioPrueba.setIdUsuario(1L);
                usuarioPrueba.setNombre("Usuario Prueba");

                // Crea un EntityManagerFactory de prueba (ajusta el nombre de tu unidad de persistencia)
                javax.persistence.EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("videoclubdaw");

                // Crea los controladores de prueba
                controller.AlquilerController alquilerController = new controller.AlquilerController(emf);
                controller.FichaTecnicaController fichaTecnicaController = new controller.FichaTecnicaController(emf);

                // Llama al constructor completo del diálogo
                VerPeliculasDialog dialog = new VerPeliculasDialog(
                        new javax.swing.JFrame(),
                        true,
                        peliculasPrueba,
                        false,
                        usuarioPrueba,
                        alquilerController,
                        fichaTecnicaController
                );
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaPeliculas;
    // End of variables declaration//GEN-END:variables
}
