/**
 * Diálogo modal para mostrar los alquileres de un usuario en una tabla.
 * Se puede usar tanto para alquileres activos como para historial.
 *
 * Uso:
 * VerAlquileresDialog dialog = new VerAlquileresDialog(parent, true, listaAlquileres);
 * dialog.setVisible(true);
 */
package views;

import controller.AlquilerController;
import entity.Alquiler;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Casa
 */
public class VerAlquileresDialog extends javax.swing.JDialog {

    private AlquilerController alquilerController;
    private List<Alquiler> alquileresActivos;
    private boolean esHistorial;

    // Constructor profesional: pasa controlador y lista de alquileres
    public VerAlquileresDialog(
            java.awt.Frame parent,
            boolean modal,
            List<Alquiler> alquileres,
            AlquilerController alquilerController,
            boolean esHistorial
    ) {
        super(parent, modal);
        this.alquilerController = alquilerController;
        this.alquileresActivos = alquileres;
        this.esHistorial = esHistorial;
        initComponents();
        personalizarVisual();
        cargarTablaAlquileres();
        setLocationRelativeTo(parent);
    }

    // Personalización visual (opcional)
    private void personalizarVisual() {
        java.awt.Font fuenteTitulo = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20);
        java.awt.Font fuenteTabla = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
        tablaAlquileres.setFont(fuenteTabla);
        btnAtras.setFont(fuenteTabla);
        getContentPane().setBackground(new java.awt.Color(245, 245, 245));
    }

    // Método para cargar los datos en la tabla
    private void cargarTablaAlquileres() {
        String[] columnas;
        if (esHistorial) {
            columnas = new String[]{"ID", "Película", "Fecha Alquiler", "Fecha Devolución"};
        } else {
            columnas = new String[]{"ID", "Película", "Fecha Alquiler", "Devolver"};
        }

        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return !esHistorial && column == 3;
            }
        };

        for (Alquiler a : alquileresActivos) {
            if (esHistorial) {
                Object[] fila = {
                    a.getIdAlquiler(),
                    a.getPelicula().getTitulo(),
                    a.getFechaAlquiler(),
                    a.getFechaEntrega()
                };
                modelo.addRow(fila);
            } else {
                Object[] fila = {
                    a.getIdAlquiler(),
                    a.getPelicula().getTitulo(),
                    a.getFechaAlquiler(),
                    "Devolver"
                };
                modelo.addRow(fila);
            }
        }

        tablaAlquileres.setModel(modelo);
        tablaAlquileres.setRowHeight(30);

        // Limpia listeners anteriores para evitar duplicados
        for (java.awt.event.MouseListener ml : tablaAlquileres.getMouseListeners()) {
            tablaAlquileres.removeMouseListener(ml);
        }

        if (!esHistorial) {
            tablaAlquileres.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = tablaAlquileres.rowAtPoint(evt.getPoint());
                    int col = tablaAlquileres.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col == 3) { // Columna "Devolver"
                        Alquiler alquilerSeleccionado = alquileresActivos.get(row);
                        int confirm = JOptionPane.showConfirmDialog(
                                VerAlquileresDialog.this,
                                "¿Seguro que quieres devolver la película \"" + alquilerSeleccionado.getPelicula().getTitulo() + "\"?",
                                "Confirmar devolución",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (confirm == JOptionPane.YES_OPTION) {
                            boolean exito = alquilerController.devolverAlquiler(alquilerSeleccionado);
                            if (exito) {
                                JOptionPane.showMessageDialog(
                                        VerAlquileresDialog.this,
                                        "Película devuelta correctamente.",
                                        "Devolución realizada",
                                        JOptionPane.INFORMATION_MESSAGE
                                );
                                alquileresActivos.remove(row);
                                ((DefaultTableModel) tablaAlquileres.getModel()).removeRow(row);
                            } else {
                                JOptionPane.showMessageDialog(
                                        VerAlquileresDialog.this,
                                        "No se pudo devolver la película.",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                );
                            }
                        }
                    }
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlquileres = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaAlquileres.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaAlquileres);

        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed
    // Método para cargar los datos en la tabla


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAlquileres;
    // End of variables declaration//GEN-END:variables
}
