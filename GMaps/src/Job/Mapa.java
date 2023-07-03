package Job;

import java.util.Date;

/**
 *
 * @author Grupo 4
 */
public class Mapa {

    private int idMapa;
    private String codigoPais;
    private String paisNombre;
    private String estado;
    private Date fechaMapa;

    public Mapa(int idMapa, String codigoPais, String paisNombre, String estado, Date fechaMapa) {
        this.idMapa = idMapa;
        this.codigoPais = codigoPais;
        this.paisNombre = paisNombre;
        this.estado = estado;
        this.fechaMapa = fechaMapa;
    }

    // Getters y Setters para cada propiedad
    public int getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaMapa() {
        return fechaMapa;
    }

    public void setFechaMapa(Date fechaMapa) {
        this.fechaMapa = fechaMapa;
    }

    // Métodos
}
