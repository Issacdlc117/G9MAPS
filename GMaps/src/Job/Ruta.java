package Job;

import Table.TablaRuta;
import Table.TablaTransporte;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa una ruta.
 *
 * @author Grupo 4
 */
public class Ruta {

    private String idRuta;
    private String coordenadaInicial;
    private String coordenadaFinal;
    private double distancia;
    private double tiempo;
    private String ipUsuario;
    private String idTransporte;

    TablaRuta tablaRuta = new TablaRuta();

    public Ruta(String coordenadaInicial, String coordenadaFinal, double distancia, double tiempo, String ipUsuario, String idTransporte) {
        this.idRuta = generarIdRuta();
        this.coordenadaInicial = coordenadaInicial;
        this.coordenadaFinal = coordenadaFinal;
        this.distancia = distancia;
        this.tiempo = tiempo;
        this.ipUsuario = ipUsuario;
        this.idTransporte = idTransporte;
    }

    // Getters y Setters para cada propiedad
    public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
    }

    public String getCoordenadaInicial() {
        return coordenadaInicial;
    }

    public void setCoordenadaInicial(String coordenadaInicial) {
        this.coordenadaInicial = coordenadaInicial;
    }

    public String getCoordenadaFinal() {
        return coordenadaFinal;
    }

    public void setCoordenadaFinal(String coordenadaFinal) {
        this.coordenadaFinal = coordenadaFinal;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    // Métodos
    private String generarIdRuta() {

        int contadorRutas = tablaRuta.obtenerNumeroDeDatos(); // Contador para generar el ID de ruta
        String prefijo = "RUT"; // Prefijo para el ID de ruta
        int longitudMaxima = 6; // Longitud máxima del ID de ruta
        StringBuilder idRuta = new StringBuilder();
        idRuta.append(prefijo);

        // Generar el número de ruta único utilizando el contador
        int numeroRuta = contadorRutas + 1;
        String numeroRutaString = String.valueOf(numeroRuta);

        // Completar con ceros a la izquierda si es necesario
        int cerosFaltantes = longitudMaxima - prefijo.length() - numeroRutaString.length();
        for (int i = 0; i < cerosFaltantes; i++) {
            idRuta.append("0");
        }
        idRuta.append(numeroRutaString);

        contadorRutas++; // Incrementar el contador para la siguiente ruta
        return idRuta.toString();
    }

//    public double calcularDistancia() {
//        double latInicial = Double.parseDouble(coordenadaInicial.split(",")[0].trim());
//        double lonInicial = Double.parseDouble(coordenadaInicial.split(",")[1].trim());
//        double latFinal = Double.parseDouble(coordenadaFinal.split(",")[0].trim());
//        double lonFinal = Double.parseDouble(coordenadaFinal.split(",")[1].trim());
//
//        double radioTierra = 6371; // Radio de la Tierra en kilómetros
//        double dLat = Math.toRadians(latFinal - latInicial);
//        double dLon = Math.toRadians(lonFinal - lonInicial);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//                + Math.cos(Math.toRadians(latInicial)) * Math.cos(Math.toRadians(latFinal))
//                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double distancia = radioTierra * c;
//
//        return distancia;
//    }
//
//    public double calcularTiempo() {
//        double distancia = calcularDistancia();
//        double velocidad = 0;
//        try {
//            TablaTransporte tablaTransporte = new TablaTransporte(); // Crea una instancia de TablaTransporte
//            velocidad = tablaTransporte.buscarVelocidad(this.idTransporte);
//        } catch (SQLException ex) {
//            Logger.getLogger(Ruta.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        double tiempo = distancia / velocidad;
//        return tiempo;
//    }
}
