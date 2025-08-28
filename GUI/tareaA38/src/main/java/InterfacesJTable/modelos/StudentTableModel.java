package InterfacesJTable.modelos;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    private StudentList studentList;
    private final String[] columnNames = {"ID", "NOMBRE", "LOCALIDAD", "UNIDAD", "F. NACIMIENTO", "SEXO", "PAÍS"};

    public StudentTableModel() {
        // No necesitas setColumnIdentifiers ni nada más aquí
    }

    // Este método lo llamas desde MainWindow para conectar el modelo a la lista real
    public void loadData(StudentList studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getRowCount() {
        return (studentList == null) ? 0 : studentList.getList().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (studentList == null) {
            return null;
        }
        Student student = studentList.getList().get(rowIndex);
        return switch (columnIndex) {
            case 0 -> student.getId();
            case 1 -> student.getNombre();
            case 2 -> student.getLocalidad();
            case 3 -> student.getUnidad();
            case 4 -> student.getFechaNacimiento();
            case 5 -> student.getSexo();
            case 6 -> student.getPaisNacimiento();
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Ninguna celda editable directamente
    }
}
