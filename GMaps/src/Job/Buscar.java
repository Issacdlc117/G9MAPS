package Job;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Grupo 4
 */
public class Buscar {

    private String idBusqueda;
    private String ipUsuario;
    private String coordenada;
    private String terminoBuscado;
    private String fechaBusqueda;
    private String resultado;

    public Buscar(String ipUsuario, String coordenada, String terminoBuscado, String resultado) {
        this.idBusqueda = generarIdBusqueda();
        this.ipUsuario = ipUsuario;
        this.coordenada = coordenada;
        this.terminoBuscado = terminoBuscado;
        this.fechaBusqueda = obtenerFechaHoraActual();
        this.resultado = resultado;
    }

    // Getters y Setters para cada propiedad
    public String getIdBusqueda() {
        return idBusqueda;
    }

    public void setIdBusqueda(String idBusqueda) {
        this.idBusqueda = idBusqueda;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getTerminoBuscado() {
        return terminoBuscado;
    }

    public void setTerminoBuscado(String terminoBuscado) {
        this.terminoBuscado = terminoBuscado;
    }

    public String getFechaBusqueda() {
        return fechaBusqueda;
    }

    public void setFechaBusqueda(String fechaBusqueda) {
        this.fechaBusqueda = fechaBusqueda;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    // Métodos
    private String generarIdBusqueda() {
        LocalDateTime now = LocalDateTime.now();
        String fechaHoraActual = now.format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));
        int numeroAleatorio = (int) (Math.random() * 100000);
        String id = fechaHoraActual + String.format("%05d", numeroAleatorio);
        return id.substring(0, 10);
    }

    private String obtenerFechaHoraActual() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
