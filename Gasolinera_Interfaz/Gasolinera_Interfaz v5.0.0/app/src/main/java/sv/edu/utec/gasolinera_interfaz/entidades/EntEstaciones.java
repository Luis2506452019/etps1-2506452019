package sv.edu.utec.gasolinera_interfaz.entidades;

public class EntEstaciones {
    private int id_estaciones;
    private String nomb_gasolinera;
    private String nomb_sucursal;
    private String ubi_sucursal;
    private String tipo_diesel;
    private String tipo_regular;
    private String tipo_especial;

    public int getId_estaciones() {
        return id_estaciones;
    }

    public void setId_estaciones(int id_estaciones) {
        this.id_estaciones = id_estaciones;
    }

    public String getNomb_gasolinera() {
        return nomb_gasolinera;
    }

    public void setNomb_gasolinera(String nomb_gasolinera) {
        this.nomb_gasolinera = nomb_gasolinera;
    }

    public String getNomb_sucursal() {
        return nomb_sucursal;
    }

    public void setNomb_sucursal(String nomb_sucursal) {
        this.nomb_sucursal = nomb_sucursal;
    }

    public String getUbi_sucursal() {
        return ubi_sucursal;
    }

    public void setUbi_sucursal(String ubi_sucursal) {
        this.ubi_sucursal = ubi_sucursal;
    }

    public String getTipo_diesel() {
        return tipo_diesel;
    }

    public void setTipo_diesel(String tipo_diesel) {
        this.tipo_diesel = tipo_diesel;
    }

    public String getTipo_regular() {
        return tipo_regular;
    }

    public void setTipo_regular(String tipo_regular) {
        this.tipo_regular = tipo_regular;
    }

    public String getTipo_especial() {
        return tipo_especial;
    }

    public void setTipo_especial(String tipo_especial) {
        this.tipo_especial = tipo_especial;
    }
}
