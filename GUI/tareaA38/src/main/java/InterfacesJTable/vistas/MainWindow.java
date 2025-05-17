package InterfacesJTable.vistas;

import InterfacesJTable.modelos.Student;
import InterfacesJTable.modelos.StudentList;
import InterfacesJTable.modelos.StudentTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Ventana principal de la aplicación Muestra la lista de estudiantes en una
 * tabla y proporciona opciones para editarlos Es el punto central de
 * interacción del usuario con la aplicación
 */
public class MainWindow extends JFrame {

    // Ruta al archivo CSV
    private static final String CSV_FILE_PATH = "RegAlum.csv";

    // Lista de estudiantes cargada desde el CSV
    private final StudentList studentList;

    // Modelo de la tabla
    private final StudentTableModel tableModel;

    // Componentes de la interfaz
    private JTable studentTable;
    private JButton updateButton;
    private JScrollPane scrollPane;
    private JLabel titleLabel;
    private JPanel buttonPanel;

    /**
     * Constructor que inicializa la ventana principal
     */
    public MainWindow() {
        // Inicializar la lista de estudiantes desde el CSV
        studentList = new StudentList(CSV_FILE_PATH);

        // Crear el modelo de la tabla con la lista de estudiantes
        tableModel = new StudentTableModel();
        tableModel.loadData(studentList);

        // Configurar la ventana
        initComponents();
        setTitle("Gestión de Estudiantes");
        setBounds(100, 100, 800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cargar los datos en la tabla
        loadDataIntoTable();
    }

    /**
     * Inicializa y configura los componentes de la interfaz
     */
    private void initComponents() {
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título
        titleLabel = new JLabel("Información de Estudiantes");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Tabla
        studentTable = new JTable(tableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Listener para el doble clic y la edición mediante diálogo
        studentTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Detectar doble clic
                    int row = studentTable.rowAtPoint(evt.getPoint());
                    int col = studentTable.columnAtPoint(evt.getPoint());
                    if (row >= 0 && (col == 2 || col == 3)) { // Localidad o Unidad (índices 2 y 3)
                        Student student = studentList.getStudent(row);
                        if (student != null) {
                            EditDialog dialog = new EditDialog(MainWindow.this, true, student);
                            dialog.setVisible(true);
                        }
                    }
                }
            }
        });

        // Panel de desplazamiento para la tabla
        scrollPane = new JScrollPane(studentTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel de botones
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        updateButton = new JButton("Actualizar");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(evt -> System.exit(0));

        buttonPanel.add(updateButton);
        buttonPanel.add(exitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Añadir el panel principal al frame
        setContentPane(mainPanel);
    }

    /**
     * Carga los datos de la lista de estudiantes en la tabla
     */
    private void loadDataIntoTable() {
        tableModel.loadData(studentList);
        tableModel.fireTableDataChanged(); // Notificar a la tabla que los datos han cambiado
    }

    /**
     * Obtiene el índice de la fila seleccionada en la tabla
     *
     * @return índice de la fila seleccionada o -1 si no hay selección
     */
    private int getSelectedRow() {
        return studentTable.getSelectedRow();
    }

    /**
     * Manejador del evento para el botón Actualizar Guarda los cambios
     * realizados directamente en la tabla (nombre del estudiante)
     */
    private void updateButtonActionPerformed(ActionEvent evt) {
        int selectedRow = getSelectedRow();
        if (selectedRow >= 0) {
            Student student = studentList.getStudent(selectedRow);
            if (student != null) {
                EditDialog dialog = new EditDialog(this, true, student);
                dialog.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, seleccione un estudiante para editar",
                    "No hay selección",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    /**
     * Método para actualizar la información de un estudiante en la lista y en
     * la tabla después de la edición en el diálogo.
     */
    public void updateStudentInTable(Student updatedStudent) {
        int row = studentList.getList().indexOf(updatedStudent);
        if (row >= 0) {
            tableModel.fireTableRowsUpdated(row, row);//fundamental para mostrar la actualizacion
            studentList.saveToCSV("RegAlum.csv"); // Guarda cambios en el CSV
            studentList.printAllStudents();       // Muestra la lista por consola
        }
    }

    /**
     * Obtiene la lista de estudiantes
     *
     * @return lista de estudiantes
     */
    public StudentList getStudentList() {
        return studentList;
    }

    /**
     * Obtiene la tabla de estudiantes
     *
     * @return la tabla de estudiantes
     */
    public JTable getStudentTable() {
        return studentTable;
    }
}
