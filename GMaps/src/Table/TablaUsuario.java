package Table;

import Job.Usuario;
import DatabaseManager.Conexion;
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
public class TablaUsuario {

    static Connection connect;
    static PreparedStatement preparedS;
    static Statement statement;
    static ResultSet resultset;

    public void guardarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO USUARIO (IPUSUARIO, RANGO, POSICION) VALUES (?,?,?)";
        try {
            connect = Conexion.Conectar();
            preparedS = Conexion.getPreparedStatement(sql);
            preparedS.setString(1, usuario.getIpUsuario());
            preparedS.setString(2, usuario.getRango());
            preparedS.setString(3, usuario.getPosicion());
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han guardado con éxito", "GMaps", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar usuario", "GMaps", JOptionPane.ERROR_MESSAGE);
            System.err.println(e);
        } finally {
            if (preparedS != null) {
                Conexion.Cerrar(preparedS);
            }
            if (connect != null) {
                Conexion.Cerrar(connect);
            }
        }
    }

    public boolean buscarUsuario(String aux) throws SQLException {
        boolean existeDato = false;
        String sql = "SELECT * FROM USUARIO WHERE IPUSUARIO LIKE '%" + aux + "%'";
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
