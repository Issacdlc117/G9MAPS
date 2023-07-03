package Job;

/**
 *
 * @author Grupo 4
 */
public class Transporte {

    private String idTransporte;
    private String tipoTransporte;
    private double velocidad;

    public Transporte(String idTransporte, String tipoTransporte, double velocidad) {
        this.idTransporte = idTransporte;
        this.tipoTransporte = tipoTransporte;
        this.velocidad = velocidad;
    }

    // Getters y Setters para cada propiedad
    public String getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    // Métodos
}
