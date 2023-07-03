package Job;

import java.util.Date;

/**
 *
 * @author Grupo 4
 */
public class Comentario {

    private int idComentario;
    private String idLugar;
    private String ipUsuario;
    private String comentarioCliente;
    private Date fechaComentario;

    public Comentario(int idComentario, String idLugar, String ipUsuario, String comentarioCliente, Date fechaComentario) {
        this.idComentario = idComentario;
        this.idLugar = idLugar;
        this.ipUsuario = ipUsuario;
        this.comentarioCliente = comentarioCliente;
        this.fechaComentario = fechaComentario;
    }

    // Getters y Setters para cada propiedad
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getComentarioCliente() {
        return comentarioCliente;
    }

    public void setComentarioCliente(String comentarioCliente) {
        this.comentarioCliente = comentarioCliente;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    // Métodos
}
