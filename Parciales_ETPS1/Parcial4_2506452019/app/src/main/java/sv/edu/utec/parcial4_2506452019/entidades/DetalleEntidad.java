package sv.edu.utec.parcial4_2506452019.entidades;

public class DetalleEntidad {

    private int id_detalle;
    private int id_cliente;
    private int id_vehiculo;

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    private String sMatricula;
    private String iKilometros;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getsMatricula() {
        return sMatricula;
    }

    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }

    public String getiKilometros() {
        return iKilometros;
    }

    public void setiKilometros(String iKilometros) {
        this.iKilometros = iKilometros;
    }
}
