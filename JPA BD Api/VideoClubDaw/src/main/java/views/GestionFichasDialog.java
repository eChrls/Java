/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package views;

import controller.FichaTecnicaController;
import controller.PeliculaController;
import entity.FichaTecnica;
import entity.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionFichasDialog extends javax.swing.JDialog {

    private FichaTecnicaController fichaTecnicaController;
    private PeliculaController peliculaController;
    private List<FichaTecnica> fichas;

    public GestionFichasDialog(java.awt.Frame parent, boolean modal,
            FichaTecnicaController fichaTecnicaController,
            PeliculaController peliculaController) {
        super(parent, modal);
        this.fichaTecnicaController = fichaTecnicaController;
        this.peliculaController = peliculaController;
        initComponents();
        personalizarVisual();
        cargarTablaFichas();
        setLocationRelativeTo(parent);
    }

    private void personalizarVisual() {
        java.awt.Font fuenteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20);
        java.awt.Font fuenteBoton = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 16);
        btnAnadir.setFont(fuenteBoton);
        btnEditar.setFont(fuenteBoton);
        btnEliminar.setFont(fuenteBoton);
        btnCerrar.setFont(fuenteBoton);
        getContentPane().setBackground(new java.awt.Color(245, 245, 245));
    }

    private void cargarTablaFichas() {
        fichas = fichaTecnicaController.listarFichasTecnicas();
        String[] columnas = {"ID", "Película", "Género", "Descripción"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (FichaTecnica f : fichas) {
            Object[] fila = {
                f.getIdFicha(),
                f.getPelicula().getTitulo(),
                f.getGenero(),
                f.getDescripcion()
            };
            modelo.addRow(fila);
        }

        tablaFichas.setModel(modelo);
        tablaFichas.setRowHeight(30);
    }

    // NUEVO: Método para obtener películas sin ficha técnica
    private List<Pelicula> obtenerPeliculasSinFicha() {
        List<Pelicula> todas = peliculaController.listarPeliculas();
        List<FichaTecnica> fichas = fichaTecnicaController.listarFichasTecnicas();
        List<Pelicula> sinFicha = new ArrayList<>();
        for (Pelicula p : todas) {
            boolean tieneFicha = false;
            for (FichaTecnica f : fichas) {
                if (f.getPelicula() != null && f.getPelicula().getIdPelicula().equals(p.getIdPelicula())) {
                    tieneFicha = true;
                    break;
                }
            }
            if (!tieneFicha) {
                sinFicha.add(p);
            }
        }
        return sinFicha;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFichas = new javax.swing.JTable();
        btnAnadir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        tablaFichas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaFichas);

        btnAnadir.setText("AÑADIR");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row = tablaFichas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una ficha técnica para eliminar.");
            return;
        }
        FichaTecnica seleccionada = fichas.get(row);
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres eliminar la ficha técnica de la película \"" + seleccionada.getPelicula().getTitulo() + "\"?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            fichaTecnicaController.eliminarFichaTecnica(seleccionada.getIdFicha());
            cargarTablaFichas();
            JOptionPane.showMessageDialog(this, "Ficha técnica eliminada.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
// Supón que tienes una tabla de películas y el admin selecciona una
        // Mostrar un diálogo para seleccionar película sin ficha técnica
        List<Pelicula> peliculasSinFicha = obtenerPeliculasSinFicha();
        if (peliculasSinFicha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay películas sin ficha técnica.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String[] titulos = peliculasSinFicha.stream().map(Pelicula::getTitulo).toArray(String[]::new);
        String seleccion = (String) JOptionPane.showInputDialog(
                this,
                "Selecciona una película para añadir ficha técnica:",
                "Seleccionar película",
                JOptionPane.QUESTION_MESSAGE,
                null,
                titulos,
                titulos[0]
        );
        if (seleccion == null) {
            return; // Cancelado
        }
        Pelicula seleccionada = null;
        for (Pelicula p : peliculasSinFicha) {
            if (p.getTitulo().equals(seleccion)) {
                seleccionada = p;
                break;
            }
        }
        if (seleccionada == null) {
            JOptionPane.showMessageDialog(this, "Error seleccionando película.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FormularioFichaDialog form = new FormularioFichaDialog(
                (java.awt.Frame) this.getParent(),
                true,
                null, // Nueva ficha
                fichaTecnicaController,
                peliculaController
        );
        form.setPeliculaNombre(seleccionada.getTitulo());
        form.setVisible(true);
        cargarTablaFichas();

    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int row = tablaFichas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona una ficha técnica para editar.");
            return;
        }
        FichaTecnica seleccionada = fichas.get(row);
        FormularioFichaDialog form = new FormularioFichaDialog(
                (java.awt.Frame) this.getParent(),
                true,
                seleccionada,
                fichaTecnicaController,
                peliculaController
        );
        form.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                cargarTablaFichas();
            }
        });
        form.setVisible(true);


    }//GEN-LAST:event_btnEditarActionPerformed

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.persistence.EntityManagerFactory emf
                    = javax.persistence.Persistence.createEntityManagerFactory("videoclubdaw");
            FichaTecnicaController fichaTecnicaController = new FichaTecnicaController(emf);
            PeliculaController peliculaController = new PeliculaController(emf);

            GestionFichasDialog dialog = new GestionFichasDialog(
                    new javax.swing.JFrame(),
                    true,
                    fichaTecnicaController,
                    peliculaController
            );
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFichas;
    // End of variables declaration//GEN-END:variables
}
