package Table;

import DatabaseManager.Conexion;
import Job.Buscar;
import static Table.TablaMarcador.connect;
import static Table.TablaMarcador.resultset;
import static Table.TablaMarcador.statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kedos
 */
public class TablaBuscar {

    static Connection connect;
    static Statement statement;
    static ResultSet resultset;
    static PreparedStatement preparedS;

    public void guardarBusqueda(Buscar buscar) {
        String sql = "INSERT INTO BUSCAR (IDBUSQUEDA, IPUSUARIO, COORDENADAS, TERMINOBUSCADO, FECHABUSQUEDA, RESULTADO) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            connect = Conexion.Conectar();
            preparedS = connect.prepareStatement(sql);
            preparedS.setString(1, buscar.getIdBusqueda());
            preparedS.setString(2, buscar.getIpUsuario());
            preparedS.setString(3, buscar.getCoordenada());
            preparedS.setString(4, buscar.getTerminoBuscado());
            preparedS.setString(5, buscar.getFechaBusqueda());
            preparedS.setString(6, buscar.getResultado());
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han guardado con éxito", "GMaps", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la búsqueda", "GMaps", JOptionPane.ERROR_MESSAGE);
            System.err.println(e);
        } finally {
            if (preparedS != null) {
                try {
                    preparedS.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            if (connect != null) {
                try {
                    connect.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public boolean buscarRegistro(String aux) throws SQLException {
        boolean existeDato = false;
        String sql = "SELECT * FROM BUSCAR WHERE COORDENADAS LIKE '%" + aux + "%'";
        try {
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            // Verificar si el resultado contiene algún registro
            if (resultset.next()) {
                existeDato = true; // El dato ya está ingresado
            }

        } catch (SQLException e) {
            System.err.print(e);
        }
        return existeDato;
    }

}
