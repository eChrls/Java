/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import controller.FichaTecnicaController;
import controller.PeliculaController;
import entity.FichaTecnica;
import entity.Pelicula;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Diálogo para alta/edición de ficha técnica.
 */
public class FormularioFichaDialog extends javax.swing.JDialog {

    private FichaTecnica ficha;
    private FichaTecnicaController fichaTecnicaController;
    private List<Pelicula> peliculas;

    public FormularioFichaDialog(java.awt.Frame parent, boolean modal, FichaTecnica ficha, FichaTecnicaController fichaTecnicaController) {
        super(parent, modal);
        this.ficha = ficha;
        this.fichaTecnicaController = fichaTecnicaController;
        // Carga todas las películas para el combo
        javax.persistence.EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("videoclubdaw");
        PeliculaController peliculaController = new PeliculaController(emf);
        peliculas = peliculaController.listarPeliculas();
        initComponents();
        cargarPeliculas();
        if (ficha != null) {
            cargarDatos();
        }
        setLocationRelativeTo(parent);
    }

    private void cargarPeliculas() {
        comboPelicula.removeAllItems();
        for (Pelicula p : peliculas) {
            comboPelicula.addItem(p.getTitulo());
        }
    }

    private void cargarDatos() {
        txtGenero.setText(ficha.getGenero());
        txtDescripcion.setText(ficha.getDescripcion());
        // Selecciona la película asociada
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getIdPelicula().equals(ficha.getPelicula().getIdPelicula())) {
                comboPelicula.setSelectedIndex(i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboPelicula = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Película : ");

        jLabel2.setText("Género : ");

        jLabel3.setText("FORMULARIO FICHA TÉCNICA");

        jLabel4.setText("Descripción :");

        comboPelicula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPeliculaActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescripcion)
                                    .addComponent(txtGenero)
                                    .addComponent(comboPelicula, 0, 350, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnGuardar)
                        .addGap(106, 106, 106)
                        .addComponent(btnCancelar)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comboPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void comboPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPeliculaActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String genero = txtGenero.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        int idx = comboPelicula.getSelectedIndex();

        if (genero.isEmpty() || descripcion.isEmpty() || idx == -1) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pelicula peliculaSeleccionada = peliculas.get(idx);

        if (ficha == null) {
            ficha = new FichaTecnica();
        }
        ficha.setGenero(genero);
        ficha.setDescripcion(descripcion);
        ficha.setPelicula(peliculaSeleccionada);

        try {
            if (ficha.getIdFicha() == null) {
                fichaTecnicaController.crearFichaTecnica(ficha);
            } else {
                fichaTecnicaController.actualizarFichaTecnica(ficha);
            }
            JOptionPane.showMessageDialog(this, "Ficha técnica guardada correctamente.");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            FormularioFichaDialog dialog = new FormularioFichaDialog(
                    null, true, null, null
            );
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboPelicula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtGenero;
    // End of variables declaration//GEN-END:variables
}
