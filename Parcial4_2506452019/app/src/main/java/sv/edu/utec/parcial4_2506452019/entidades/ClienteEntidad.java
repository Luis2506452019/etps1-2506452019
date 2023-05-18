package sv.edu.utec.parcial4_2506452019.entidades;

public class ClienteEntidad {
    private int id_cliente;
    private String sNombreCliente;
    private String sDireccionCliente;
    private String sCiudadCliente;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getsNombreCliente() {
        return sNombreCliente;
    }

    public void setsNombreCliente(String sNombreCliente) {
        this.sNombreCliente = sNombreCliente;
    }

    public String getsDireccionCliente() {
        return sDireccionCliente;
    }

    public void setsDireccionCliente(String sDireccionCliente) {
        this.sDireccionCliente = sDireccionCliente;
    }

    public String getsCiudadCliente() {
        return sCiudadCliente;
    }

    public void setsCiudadCliente(String sCiudadCliente) {
        this.sCiudadCliente = sCiudadCliente;
    }
}
