package Job;

/**
 *
 * @author Grupo 4
 */
public class Marcador {

    private String Coordenada;
    private int Id_Mapa;
    private String Codigo_Pais;
    private String Estado;
    private String Id_Lugar;
    private String Calle_Principal;
    private String Calle_Secundaria;
    private String Refencias;

    public Marcador(String Coordenada, int Id_Mapa, String Codigo_Pais, String Estado, String Id_Lugar, String Calle_Principal, String Calle_Secundaria, String Refencias) {
        this.Coordenada = Coordenada;
        this.Id_Mapa = Id_Mapa;
        this.Codigo_Pais = Codigo_Pais;
        this.Estado = Estado;
        this.Id_Lugar = Id_Lugar;
        this.Calle_Principal = Calle_Principal;
        this.Calle_Secundaria = Calle_Secundaria;
        this.Refencias = Refencias;
    }

    // Getters y Setters para cada propiedad
    public String getCoordenada() {
        return Coordenada;
    }

    public void setCoordenada(String Coordenada) {
        this.Coordenada = Coordenada;
    }

    public int getId_Mapa() {
        return Id_Mapa;
    }

    public void setId_Mapa(int Id_Mapa) {
        this.Id_Mapa = Id_Mapa;
    }

    public String getCodigo_Pais() {
        return Codigo_Pais;
    }

    public void setCodigo_Pais(String Codigo_Pais) {
        this.Codigo_Pais = Codigo_Pais;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getId_Lugar() {
        return Id_Lugar;
    }

    public void setId_Lugar(String Id_Lugar) {
        this.Id_Lugar = Id_Lugar;
    }

    public String getCalle_Principal() {
        return Calle_Principal;
    }

    public void setCalle_Principal(String Calle_Principal) {
        this.Calle_Principal = Calle_Principal;
    }

    public String getCalle_Secundaria() {
        return Calle_Secundaria;
    }

    public void setCalle_Secundaria(String Calle_Secundaria) {
        this.Calle_Secundaria = Calle_Secundaria;
    }

    public String getRefencias() {
        return Refencias;
    }

    public void setRefencias(String Refencias) {
        this.Refencias = Refencias;
    }

    // Métodos
}
