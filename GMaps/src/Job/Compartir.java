package Job;

import java.util.Date;

/**
 *
 * @author Grupo 4
 */
public class Compartir {

    private int idCompartir;
    private String coordenada;
    private String ipUsuario;
    private Date tiempoVisualizacion;

    public Compartir(int idCompartir, String coordenada, String ipUsuario, Date tiempoVisualizacion) {
        this.idCompartir = idCompartir;
        this.coordenada = coordenada;
        this.ipUsuario = ipUsuario;
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    // Getters y Setters para cada propiedad
    public int getIdCompartir() {
        return idCompartir;
    }

    public void setIdCompartir(int idCompartir) {
        this.idCompartir = idCompartir;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public Date getTiempoVisualizacion() {
        return tiempoVisualizacion;
    }

    public void setTiempoVisualizacion(Date tiempoVisualizacion) {
        this.tiempoVisualizacion = tiempoVisualizacion;
    }

    // Métodos
}
