package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase de utilidades para manejar conexiones y consultas SQL con JDBC.
 */
public class UtilidadesJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    /**
     * Método para obtener una conexión a la base de datos.
     * 
     * @return Conexión activa o null si falla la conexión.
     */
    public static Connection obtenerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver de MySQL
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método para cerrar una conexión.
     * 
     * @param conexion Objeto Connection a cerrar.
     */
    public static void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null)
                conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para cerrar un PreparedStatement.
     * 
     * @param statement Objeto PreparedStatement a cerrar.
     */
    public static void cerrarStatement(PreparedStatement statement) {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para cerrar un ResultSet.
     * 
     * @param resultSet Objeto ResultSet a cerrar.
     */
    public static void cerrarResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método genérico para ejecutar una consulta SELECT.
     * 
     * @param sql Consulta SQL a ejecutar.
     * @return ResultSet con los resultados de la consulta.
     */
    public static ResultSet ejecutarConsulta(String sql) {
        Connection conexion = obtenerConexion();
        if (conexion == null)
            return null;
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            cerrarConexion(conexion);
            return null;
        }
    }

    /**
     * Método genérico para ejecutar una consulta INSERT, UPDATE o DELETE.
     * 
     * @param sql Consulta SQL a ejecutar.
     * @return Número de filas afectadas o -1 si ocurre un error.
     */
    public static int ejecutarActualizacion(String sql) {
        Connection conexion = obtenerConexion();
        if (conexion == null)
            return -1;
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            int filasAfectadas = statement.executeUpdate();
            cerrarStatement(statement);
            cerrarConexion(conexion);
            return filasAfectadas;
        } catch (SQLException e) {
            e.printStackTrace();
            cerrarConexion(conexion);
            return -1;
        }
    }
}
