package Job;

import java.security.Timestamp;

/**
 *
 * @author Grupo 4
 */
public class Lugar {

    private String idLugar;
    private String coordenada;
    private String codigoCiudad;
    private String nombreLugar;
    private Timestamp horaApertura;
    private Integer calificacionLugar;

    public Lugar(String idLugar, String coordenada, String codigoCiudad, String nombreLugar, Timestamp horaApertura, Integer calificacionLugar) {
        this.idLugar = idLugar;
        this.coordenada = coordenada;
        this.codigoCiudad = codigoCiudad;
        this.nombreLugar = nombreLugar;
        this.horaApertura = horaApertura;
        this.calificacionLugar = calificacionLugar;
    }

    // Getters y Setters para cada propiedad
    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public Timestamp getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Timestamp horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Integer getCalificacionLugar() {
        return calificacionLugar;
    }

    public void setCalificacionLugar(Integer calificacionLugar) {
        this.calificacionLugar = calificacionLugar;
    }

    // Métodos
}
