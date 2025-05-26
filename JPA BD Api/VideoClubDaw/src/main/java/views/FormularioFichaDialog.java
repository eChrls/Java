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
 * FormularioFichaDialog Permite crear o editar una ficha técnica, asociando una
 * película existente o creando una nueva si no existe.
 */
public class FormularioFichaDialog extends javax.swing.JDialog {

    private FichaTecnica ficha;
    private FichaTecnicaController fichaTecnicaController;
    private PeliculaController peliculaController;

    public FormularioFichaDialog(java.awt.Frame parent, boolean modal, FichaTecnica ficha,
            FichaTecnicaController fichaTecnicaController,
            PeliculaController peliculaController) {
        super(parent, modal);
        this.ficha = ficha;
        this.fichaTecnicaController = fichaTecnicaController;
        this.peliculaController = peliculaController;
        initComponents();
        if (ficha != null) {
            cargarDatos();
        }
        setLocationRelativeTo(parent);
        txtPeliculaNombre.setEditable(false); // El usuario no puede editar el campo

    }

    /**
     * Carga los datos de la ficha técnica en el formulario si se está editando.
     */
    private void cargarDatos() {
        txtGenero.setText(ficha.getGenero());
        txtDescripcion.setText(ficha.getDescripcion());
        if (ficha.getPelicula() != null) {
            txtPeliculaNombre.setText(ficha.getPelicula().getTitulo());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtPeliculaNombre = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Película : ");

        jLabel2.setText("Género : ");

        jLabel3.setText("FORMULARIO FICHA TÉCNICA");

        jLabel4.setText("Descripción :");

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

        txtPeliculaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeliculaNombreActionPerformed(evt);
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
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                    .addComponent(txtGenero)
                                    .addComponent(txtPeliculaNombre)))))
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
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPeliculaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
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

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed
    public void setPeliculaNombre(String nombre) {
        txtPeliculaNombre.setText(nombre);
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombrePelicula = txtPeliculaNombre.getText().trim();
        String genero = txtGenero.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        if (nombrePelicula.isEmpty() || genero.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Buscar si existe la película por título (no crear nunca)
        Pelicula pelicula = null;
        List<Pelicula> lista = peliculaController.listarPeliculas();
        for (Pelicula p : lista) {
            if (p.getTitulo().equalsIgnoreCase(nombrePelicula)) {
                pelicula = p;
                break;
            }
        }

        if (pelicula == null) {
            JOptionPane.showMessageDialog(this, "No existe ninguna película con ese nombre. Primero crea la película.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ficha == null) {
            ficha = new FichaTecnica();
        }
        ficha.setGenero(genero);
        ficha.setDescripcion(descripcion);
        ficha.setPelicula(pelicula);

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

    private void txtPeliculaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeliculaNombreActionPerformed
        // Esto evita que el usuario cambie el nombre de la película en la edición de ficha.
        if (ficha != null && ficha.getPelicula() != null) {
            txtPeliculaNombre.setText(ficha.getPelicula().getTitulo());
            txtPeliculaNombre.setEditable(false);
        }
    }//GEN-LAST:event_txtPeliculaNombreActionPerformed

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.persistence.EntityManagerFactory emf
                    = javax.persistence.Persistence.createEntityManagerFactory("videoclubdaw");
            FichaTecnicaController fichaTecnicaController = new FichaTecnicaController(emf);
            PeliculaController peliculaController = new PeliculaController(emf);

            FormularioFichaDialog dialog = new FormularioFichaDialog(
                    null, // parent frame
                    true, // modal
                    null, // ficha (null para alta, o una FichaTecnica para editar)
                    fichaTecnicaController,
                    peliculaController
            );
            dialog.setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPeliculaNombre;
    // End of variables declaration//GEN-END:variables
}
