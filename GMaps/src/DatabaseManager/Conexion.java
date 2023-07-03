package DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {

    public static Connection Conectar() {

        Connection link = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=GMaps;"
                    + "user=sa;"
                    + "password=010664;"
                    + "loginTimeout=30;";
            link = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return link;
    }

    public static Statement getStatement() throws SQLException {
        Statement st = null;
        st = Conectar().createStatement();
        return st;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        PreparedStatement ps = Conectar().prepareStatement(sql);
        return ps;
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        ResultSet rs = null;
        rs = getStatement().executeQuery(sql);
        return rs;
    }

    public static void Cerrar(Connection cn) throws SQLException {
        cn.close();
    }

    public static void Cerrar(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void Cerrar(ResultSet rs) throws SQLException {
        rs.close();
    }
}
