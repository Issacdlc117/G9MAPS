package Table;

import DatabaseManager.Conexion;
import static Table.TablaTransporte.connect;
import static Table.TablaTransporte.resultset;
import static Table.TablaTransporte.statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kedos
 */
public class TablaMarcador {

    static Connection connect;
    static PreparedStatement preparedS;
    static Statement statement;
    static ResultSet resultset;

    public void desplegarMarcador(String aux) throws SQLException {
        try {
            String sql = "SELECT COORDENADAS, IDMAPA, CODIGOPAIS, ESTADO, CALLEPRINCIPAL, CALLESECUNDARIA, REFERENCIAS FROM MARCADOR WHERE COORDENADAS LIKE '%" + aux + "%'";
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            while (resultset.next()) {
                String coordenadas = resultset.getString("COORDENADAS");
                String idMapa = resultset.getString("IDMAPA");
                String codigoPais = resultset.getString("CODIGOPAIS");
                String estado = resultset.getString("ESTADO");
                String callePrincipal = resultset.getString("CALLEPRINCIPAL");
                String calleSecundaria = resultset.getString("CALLESECUNDARIA");
                String referencias = resultset.getString("REFERENCIAS");

                System.out.println("\tCoordenadas: " + coordenadas);
                System.out.println("\tID Mapa: " + idMapa);
                System.out.println("\tCódigo País: " + codigoPais);
                System.out.println("\tEstado: " + estado);
                System.out.println("\tCalle Principal: " + callePrincipal);
                System.out.println("\tCalle Secundaria: " + calleSecundaria);
                System.out.println("\tReferencias: " + referencias);

            }
        } catch (SQLException e) {
            System.err.print(e);
        }
    }

    public boolean buscarMarcador(String aux) throws SQLException {
        boolean existeDato = false;
        String sql = "SELECT * FROM MARCADOR WHERE COORDENADAS LIKE '%" + aux + "%'";
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

    public String desplegarMarcadores() throws SQLException {
        StringBuilder coordenadasSeleccionadas = new StringBuilder();
        ArrayList<String> coordenadasList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM MARCADOR";
            connect = Conexion.Conectar();
            statement = Conexion.getStatement();
            resultset = Conexion.getResultSet(sql);

            int contador = 1;
            while (resultset.next()) {
                String coordenadas = resultset.getString("COORDENADAS");
                String idMapa = resultset.getString("IDMAPA");
                String codigoPais = resultset.getString("CODIGOPAIS");
                String estado = resultset.getString("ESTADO");
                String callePrincipal = resultset.getString("CALLEPRINCIPAL");
                String calleSecundaria = resultset.getString("CALLESECUNDARIA");
                String referencias = resultset.getString("REFERENCIAS");

                System.out.println("[" + contador + "]");
                System.out.println("\tCoordenadas: " + coordenadas);
                System.out.println("\tID Mapa: " + idMapa);
                System.out.println("\tCódigo País: " + codigoPais);
                System.out.println("\tEstado: " + estado);
                System.out.println("\tCalle Principal: " + callePrincipal);
                System.out.println("\tCalle Secundaria: " + calleSecundaria);
                System.out.println("\tReferencias: " + referencias);

                coordenadasList.add(coordenadas);
                contador++;
            }

            if (!coordenadasList.isEmpty()) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\n Selecciona un marcador: ");
                int seleccion = scanner.nextInt();

                if (seleccion >= 1 && seleccion <= coordenadasList.size()) {
                    String coordenadaSeleccionada = coordenadasList.get(seleccion - 1);
                    coordenadasSeleccionadas.append(coordenadaSeleccionada);
                } else {
                    System.out.println("¡Selección inválida!");
                }
            }
        } catch (SQLException e) {
            System.err.print(e);
        }

        return coordenadasSeleccionadas.toString();
    }

}
