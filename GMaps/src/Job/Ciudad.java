package Job;

/**
 *
 * @author Grupo 4
 */
public class Ciudad {

    private String codigoCiudad;
    private int idMapa;
    private String codigoPais;
    private String estado;
    private String nombreCiudad;
    private double areaMostrar;
    private int numLugaresInteres;

    public Ciudad(String codigoCiudad, int idMapa, String codigoPais, String estado, String nombreCiudad, double areaMostrar, int numLugaresInteres) {
        this.codigoCiudad = codigoCiudad;
        this.idMapa = idMapa;
        this.codigoPais = codigoPais;
        this.estado = estado;
        this.nombreCiudad = nombreCiudad;
        this.areaMostrar = areaMostrar;
        this.numLugaresInteres = numLugaresInteres;
    }

    // Getters y Setters para cada propiedad
    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public double getAreaMostrar() {
        return areaMostrar;
    }

    public void setAreaMostrar(double areaMostrar) {
        this.areaMostrar = areaMostrar;
    }

    public int getNumLugaresInteres() {
        return numLugaresInteres;
    }

    public void setNumLugaresInteres(int numLugaresInteres) {
        this.numLugaresInteres = numLugaresInteres;
    }

    // Métodos
}
