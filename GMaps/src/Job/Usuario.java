package Job;

/**
 *
 * @author Grupo 4
 */
public class Usuario {

    private String ipUsuario;
    private String rango;
    private String posicion;

    public Usuario(String ipUsuario, String rango, String posicion) {
        this.ipUsuario = ipUsuario;
        this.rango = rango;
        this.posicion = posicion;
    }

    // Getters y Setters para cada propiedad
    public String getIpUsuario() {
        return ipUsuario;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    // Métodos
}
