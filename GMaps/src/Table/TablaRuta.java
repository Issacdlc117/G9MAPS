package Table;

import DatabaseManager.Conexion;
import Job.Buscar;
import Job.Ruta;
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
public class TablaRuta {

    static Connection connect;
    static Statement statement;
    static ResultSet resultset;
    static PreparedStatement preparedS;

    public String encontrarIdRuta(Ruta ruta) {
        String idRutaEncontrado = null;

        try {
            String sql = "SELECT IDRUTA FROM RUTA WHERE COORDENADAINICIAL = ? AND COORDENADAFINAL = ? AND DISTANCIA = ? AND TIEMPO = ? AND IPUSUARIO = ? AND IDTRANSPORTE = ?";
            connect = Conexion.Conectar();
            preparedS = connect.prepareStatement(sql);
            preparedS.setString(1, ruta.getCoordenadaInicial());
            preparedS.setString(2, ruta.getCoordenadaFinal());
            preparedS.setDouble(3, ruta.getDistancia());
            preparedS.setDouble(4, ruta.getTiempo());
            preparedS.setString(5, ruta.getIpUsuario());
            preparedS.setString(6, ruta.getIdTransporte());
            resultset = preparedS.executeQuery();

            if (resultset.next()) {
                idRutaEncontrado = resultset.getString("IDRUTA");
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            // Cerrar los recursos
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
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

        return idRutaEncontrado;
    }

    public void mostrarRuta(String aux) throws SQLException {
        try {
            String sql = "SELECT MI.REFERENCIAS AS REFERENCIAS_INICIAL, "
                    + "MI.CALLEPRINCIPAL AS CALLEPRINCIPAL_INICIAL, "
                    + "MF.REFERENCIAS AS REFERENCIAS_FINAL, "
                    + "MF.CALLEPRINCIPAL AS CALLEPRINCIPAL_FINAL, "
                    + "R.DISTANCIA, R.TIEMPO, "
                    + "T.TIPOTRANSPORTE "
                    + "FROM RUTA R "
                    + "JOIN MARCADOR MI ON R.COORDENADAINICIAL = MI.COORDENADAS "
                    + "JOIN MARCADOR MF ON R.COORDENADAFINAL = MF.COORDENADAS "
                    + "JOIN TRANSPORTE T ON R.IDTRANSPORTE = T.IDTRANSPORTE "
                    + "WHERE R.IDRUTA LIKE '%" + aux + "%'";

            connect = Conexion.Conectar();
            statement = connect.createStatement();
            resultset = statement.executeQuery(sql);

            while (resultset.next()) {
                String referenciasInicial = resultset.getString("REFERENCIAS_INICIAL");
                String callePrincipalInicial = resultset.getString("CALLEPRINCIPAL_INICIAL");
                String referenciasFinal = resultset.getString("REFERENCIAS_FINAL");
                String callePrincipalFinal = resultset.getString("CALLEPRINCIPAL_FINAL");
                double distancia = resultset.getDouble("DISTANCIA");
                double tiempo = resultset.getDouble("TIEMPO");
                String tipoTransporte = resultset.getString("TIPOTRANSPORTE");

                System.out.println("Referencias Inicial: " + referenciasInicial);
                System.out.println("Calle Principal Inicial: " + callePrincipalInicial);
                System.out.println("Referencias Final: " + referenciasFinal);
                System.out.println("Calle Principal Final: " + callePrincipalFinal);
                System.out.println("Distancia: " + distancia + " (m)");
                System.out.println("Tiempo: " + tiempo + " (min)");
                System.out.println("Tipo de transporte: " + tipoTransporte);
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el Statement: " + e.getMessage());
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

    public void desplegarRuta(String aux) throws SQLException {
        try {
            String sql = "SELECT * FROM RUTA ";
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            while (resultset.next()) {
                String idRuta = resultset.getString("IDRUTA");
                String coordenadaInicial = resultset.getString("COORDENADAINICIAL");
                String coordenadaFinal = resultset.getString("COORDENADAFINAL");
                String distancia = resultset.getString("DISTANCIA");
                String tiempo = resultset.getString("TIEMPO");
                String ipUsuario = resultset.getString("IPUSUARIO");
                String idTransporte = resultset.getString("IDTRANSPORTE");

                System.out.println("\tID Ruta: " + idRuta);
                System.out.println("\tCoordenada inicial: " + coordenadaInicial);
                System.out.println("\tCoordenada final: " + coordenadaFinal);
                System.out.println("\tDistancia: " + distancia + " (m)");
                System.out.println("\tTiempo: " + tiempo + " (min)");
                System.out.println("\tIP Usuario: " + ipUsuario);
                System.out.println("\tID Transporte: " + idTransporte);

            }
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public void guardarRuta(Ruta ruta) {
        String sql = "INSERT INTO RUTA (IDRUTA, COORDENADAINICIAL, COORDENADAFINAL, DISTANCIA, TIEMPO, IPUSUARIO, IDTRANSPORTE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            connect = Conexion.Conectar();
            preparedS = connect.prepareStatement(sql);
            preparedS.setString(1, ruta.getIdRuta());
            preparedS.setString(2, ruta.getCoordenadaInicial());
            preparedS.setString(3, ruta.getCoordenadaFinal());
            preparedS.setDouble(4, ruta.getDistancia());
            preparedS.setDouble(5, ruta.getTiempo());
            preparedS.setString(6, ruta.getIpUsuario());
            preparedS.setString(7, ruta.getIdTransporte());
            preparedS.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos se han guardado con éxito", "GMaps", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el Statement: " + e.getMessage());
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

    public int obtenerNumeroDeDatos() {
        int numeroDatos = 0;

        try {
            String sql = "SELECT COUNT(*) AS Total FROM RUTA";
            connect = Conexion.Conectar();
            statement = connect.createStatement();
            resultset = statement.executeQuery(sql);

            if (resultset.next()) {
                numeroDatos = resultset.getInt("Total");
            }
        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            // Cerrar los recursos
            if (resultset != null) {
                try {
                    resultset.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar el Statement: " + e.getMessage());
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

        return numeroDatos;
    }
}
