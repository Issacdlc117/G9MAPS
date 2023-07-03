package GUI;

import DatabaseManager.Conexion;
import Job.Buscar;
import Job.Ruta;
import Job.Usuario;
import Table.TablaBuscar;
import Table.TablaMarcador;
import Table.TablaRuta;
import Table.TablaTransporte;
import Table.TablaUsuario;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GMaps {

    public static void main(String[] args) {
        TablaMarcador tablaMarcador = new TablaMarcador();
        TablaBuscar tablaBuscar = new TablaBuscar();
        TablaRuta tablaRuta = new TablaRuta();
        TablaTransporte tablaTransporte = new TablaTransporte();
        // Obtener la dirección IP pública desde un servicio web
        extractIP();

        boolean band = true;
        while (band == true) {
            // TODO code application logic here
            Scanner scanner = new Scanner(System.in);
            int opcion = 0;

            while (opcion != 4) {
                System.out.println("************ Bienvenido a GMaps ************");
                System.out.println("1. Ver ubicacion actual");
                System.out.println("2. Crear ruta");
                System.out.println("3. Mostrar puntos de interes");
                System.out.println("4. Buscar lugar");
                System.out.println("5. Compartir ubicacion de lugar");
                System.out.println("6. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        try {
                        // Verificador y obtención de dirección IP
                        String ip = extractIP();

                        // Obtener las coordenada geográficas de la dirección IP
                        double[] coordinates = buscarCoordenadas(ip);
                        double latitude = coordinates[0];
                        double longitude = coordinates[1];
                        String coordenada = latitude + ", " + longitude;

                        if (tablaMarcador.buscarMarcador(coordenada) == true) {
                            System.out.println("\n\nTU UBICACIÓN ACTUAL ES: ");
                            tablaMarcador.desplegarMarcador(coordenada);
                            if (tablaBuscar.buscarRegistro(coordenada) == false) {
                                String terminoBuscado = "Mi ubicacion actual";
                                String resultado = "Ubicacion encontrada";
                                Buscar buscar = new Buscar(ip, coordenada, terminoBuscado, resultado);
                                tablaBuscar.guardarBusqueda(buscar);
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                    case 2:
                        String coordenadaInicial = "";
                        String coordenadaFinal = "";
                        String idTransporte = "";
                        try {
                            System.out.println("\n\nSELECCIONA LA COORDENADA INICIAL: ");
                            coordenadaInicial = tablaMarcador.desplegarMarcadores();
                            System.out.println(coordenadaInicial);

                            System.out.println("\n\nSELECCIONA LA COORDENADA FINAL: ");
                            coordenadaFinal = tablaMarcador.desplegarMarcadores();
                            System.out.println(coordenadaFinal);

                            System.out.println("\n\nSELECCIONA EL TIPO DE TRANSPORTE: ");
                            idTransporte = tablaTransporte.buscarIDTransporte();
                            double distancia = (calcularDistancia(coordenadaInicial, coordenadaFinal)) * 1000;
                            double tiempo = (calcularDistancia(coordenadaInicial, coordenadaFinal) / tablaTransporte.buscarVelocidad(idTransporte)) * 60;

                            System.out.println("DISTANCIA: " + distancia + " (m)");
                            System.out.println("TIEMPO: " + tiempo + " (min)");

                            // Verificador y obtención de dirección IP
                            String ip = extractIP();

                            Ruta ruta = new Ruta(coordenadaInicial, coordenadaFinal, distancia, tiempo, ip, idTransporte);
                            tablaRuta.guardarRuta(ruta);

                            String idRutaEncontrado = tablaRuta.encontrarIdRuta(ruta);
                            System.out.println("\n\nTU RUTA ES: ");
                            tablaRuta.mostrarRuta(idRutaEncontrado);
                           
////                        if (tablaMarcador.buscarMarcador(coordenada) == true) {
////                            System.out.println("\n\nTU UBICACIÓN ACTUAL ES: ");
////                            tablaMarcador.desplegarMarcador(coordenada);
////                            if (tablaBuscar.buscarRegistro(coordenada) == false) {
////                                String terminoBuscado = "Mi ubicacion actual";
////                                String resultado = "Ubicacion encontrada";
////                                Buscar buscar = new Buscar(ip, coordenada, terminoBuscado, resultado);
////                                tablaBuscar.guardarBusqueda(buscar);
////                            }
//                        }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:

                    case 4:

                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }

                System.out.println();
            }
        }
    }

    private static double[] buscarCoordenadas(String ip) {
        double[] coordinates = new double[2];
        try {
            String apiKey = "0070ea7df4f74380bafe25042a96fe68";
            URL geolocationUrl = new URL("https://api.ipgeolocation.io/ipgeo?apiKey=" + apiKey + "&ip=" + ip);
            HttpURLConnection connection = (HttpURLConnection) geolocationUrl.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader geolocationReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder geolocationResponse = new StringBuilder();
                String geolocationLine;
                while ((geolocationLine = geolocationReader.readLine()) != null) {
                    geolocationResponse.append(geolocationLine);
                }
                geolocationReader.close();

                // Procesar la respuesta JSON para obtener las coordenada
                String geolocationJsonString = geolocationResponse.toString();
                coordinates[0] = extractCoordinate(geolocationJsonString, "latitude");
                coordinates[1] = extractCoordinate(geolocationJsonString, "longitude");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return coordinates;
    }

    private static double extractCoordinate(String json, String key) {
        int startIndex = json.indexOf("\"" + key + "\":") + key.length() + 3;
        int endIndex = json.indexOf(",", startIndex);
        String coordinateString = json.substring(startIndex, endIndex).trim();
        if (coordinateString.startsWith("\"") && coordinateString.endsWith("\"")) {
            coordinateString = coordinateString.substring(1, coordinateString.length() - 1);
        }
        return Double.parseDouble(coordinateString);
    }

    private static String extractIP() {
        String ip = null;
        TablaUsuario tablaUsuario = new TablaUsuario();
        try {
            URL ipifyUrl = new URL("https://api.ipify.org");
            BufferedReader ipifyReader = new BufferedReader(new InputStreamReader(ipifyUrl.openStream()));
            ip = ipifyReader.readLine();
            if (tablaUsuario.buscarUsuario(ip) == false) {
                Usuario usuario = new Usuario(ip, "Rango Local", "Posición Local");

                // Guardar los datos en la base de datos
                tablaUsuario.guardarUsuario(usuario);
            }
            ipifyReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ip;
    }

    private static double calcularDistancia(String coordenadaInicial, String coordenadaFinal) {
        double latInicial = Double.parseDouble(coordenadaInicial.split(",")[0].trim());
        double lonInicial = Double.parseDouble(coordenadaInicial.split(",")[1].trim());
        double latFinal = Double.parseDouble(coordenadaFinal.split(",")[0].trim());
        double lonFinal = Double.parseDouble(coordenadaFinal.split(",")[1].trim());

        double radioTierra = 6371; // Radio de la Tierra en kilómetros
        double dLat = Math.toRadians(latFinal - latInicial);
        double dLon = Math.toRadians(lonFinal - lonInicial);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(latInicial)) * Math.cos(Math.toRadians(latFinal))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distancia = radioTierra * c;

        return distancia;
    }

}
