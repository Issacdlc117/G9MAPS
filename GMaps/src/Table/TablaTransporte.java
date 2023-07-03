package Table;

import DatabaseManager.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kedos
 */
public class TablaTransporte {

    static Connection connect;
    static PreparedStatement preparedS;
    static Statement statement;
    static ResultSet resultset;

    public void desplegarTransporte(String aux) throws SQLException {
        try {
            String sql = "SELECT * FROM TRANSPORTE";
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            while (resultset.next()) {
                String idTransporte = resultset.getString("IDTRANSPORTE");
                String tipoTransporte = resultset.getString("TIPOTRANSPORTE");
                String velocidad = resultset.getString("VELOCIDAD");

                System.out.println("\tID Transporte: " + idTransporte);
                System.out.println("\tTipo Transporte: " + tipoTransporte);
                System.out.println("\tVelocidad: " + velocidad);
            }
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public String buscarIDTransporte() throws SQLException {
        StringBuilder opcionesTransporte = new StringBuilder();
        ArrayList<String> transportesList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM TRANSPORTE";
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            // Mostrar las opciones de transporte
            int contador = 1;
            while (resultset.next()) {
                String idTransporte = resultset.getString("IDTRANSPORTE");
                String tipoTransporte = resultset.getString("TIPOTRANSPORTE");
                String velocidad = resultset.getString("VELOCIDAD");

                System.out.println("[" + contador + "]");
                System.out.println("\tID Transporte: " + idTransporte);
                System.out.println("\tTipo Transporte: " + tipoTransporte);
                System.out.println("\tVelocidad: " + velocidad);

                transportesList.add(idTransporte);
                contador++;
            }

            if (!transportesList.isEmpty()) {
                // Pedir al usuario que seleccione una opción mediante un número
                Scanner scanner = new Scanner(System.in);
                System.out.print("\n Selecciona un transporte: ");
                int seleccion = scanner.nextInt();

                // Obtener el ID_TRANSPORTE correspondiente a la selección
                if (seleccion >= 1 && seleccion <= transportesList.size()) {
                    String opcioneTransporte = transportesList.get(seleccion - 1);
                    opcionesTransporte.append(opcioneTransporte);
                } else {
                    System.out.println("¡Selección inválida!");
                }
            }
        } catch (SQLException e) {
            System.err.print(e);
        }

        return opcionesTransporte.toString();
    }

    public double buscarVelocidad(String aux) throws SQLException {
        double velocidadTransporte = 0;
        String sql = "SELECT * FROM TRANSPORTE WHERE IDTRANSPORTE LIKE '%" + aux + "%'";
        try {
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            while (resultset.next()) {
                String idTransporte = resultset.getString("IDTRANSPORTE");
                String tipoTransporte = resultset.getString("TIPOTRANSPORTE");
                String velocidad = resultset.getString("VELOCIDAD");

                System.out.println("\tID Transporte: " + idTransporte);
                System.out.println("\tTipo Transporte: " + tipoTransporte);
                System.out.println("\tVelocidad: " + velocidad);
                velocidadTransporte = Double.parseDouble(velocidad);
            }

        } catch (SQLException e) {
            System.err.print(e);
        }

        return velocidadTransporte;
    }

}
