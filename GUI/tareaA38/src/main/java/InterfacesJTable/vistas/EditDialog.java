package InterfacesJTable.vistas;

import InterfacesJTable.modelos.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Diálogo para editar la localidad y unidad de un estudiante Permite modificar
 * estos campos del estudiante seleccionado en la tabla principal Es necesario
 * para proporcionar una interfaz de edición controlada de los datos
 */
public class EditDialog extends javax.swing.JDialog {

    // Referencia a la ventana principal
    private final MainWindow parent;

    // Estudiante que se está editando
    private Student student;

    /**
     * Constructor del diálogo de edición
     *
     * @param parent ventana principal que lo invoca
     * @param modal determina si el diálogo bloquea la ventana principal
     * @param student estudiante a editar
     */
    public EditDialog(MainWindow parent, boolean modal, Student student) {
        super(parent, modal);
        this.parent = parent;
        this.student = student;

        // Inicializar componentes gráficos
        initComponents();

        // Cargar datos del estudiante seleccionado
        loadSelectedStudentData();

        // Centrar diálogo en la pantalla
        setLocationRelativeTo(parent);
    }

    /**
     * Carga los datos del estudiante seleccionado en los campos del diálogo y
     * los hace editables
     */
    private void loadSelectedStudentData() {
        // Mostrar datos en los campos
        nameField.setText(student.getNombre());
        nameField.setEditable(true);
        nameField.setBackground(Color.WHITE);

        // Configurar título del diálogo
        setTitle("Editar datos de " + student.getNombre());
    }

    /**
     * Inicialización de componentes de la interfaz gráfica
     */
    private void initComponents() {
// Crear componentes
        JLabel nameLabel = new JLabel("Nombre:");
        nameField = new JTextField();
        saveButton = new JButton("Guardar");
        cancelButton = new JButton("Cancelar");

// Configurar ventana
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

// Configurar botones
        saveButton.addActionListener(this::saveButtonActionPerformed);
        cancelButton.addActionListener(this::cancelButtonActionPerformed);

// Crear layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(nameLabel)
                                .addGap(15, 15, 15)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(saveButton)
                                .addComponent(cancelButton)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveButton)
                                        .addComponent(cancelButton))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();

        // Configurar layout vertical
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveButton))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)))
        );

        pack();
    }

    /**
     * Acción al pulsar el botón Guardar Guarda los cambios.
     */
    private void saveButtonActionPerformed(ActionEvent evt) {
        // Actualizar datos del estudiante en la gui
        student.setNombre(nameField.getText());
        parent.updateStudentInTable(student);
        dispose();
    }

    /**
     * Acción al pulsar el botón Cancelar Cierra el diálogo sin guardar cambios
     */
    private void cancelButtonActionPerformed(ActionEvent evt) {
        student.setNombre(nameField.getText());
        dispose();
    }

    // Variables de componentes
    private JTextField nameField;
    private JTextField locationField;
    private JTextField unitField;
    private JButton saveButton;
    private JButton cancelButton;
}
