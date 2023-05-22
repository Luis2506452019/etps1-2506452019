package sv.edu.utec.gasolinera_interfaz.clases.list_estacion;

public class List_entrada {
    private int idImagen;
    private String txtGasolinera, txtNombreGasolinera;

    public List_entrada (int idImagen, String txtGasolinera, String txtNombreGasolinera) {
        this.idImagen = idImagen;
        this.txtGasolinera = txtGasolinera;
        this.txtNombreGasolinera = txtNombreGasolinera;
    }

    public String get_txtGasolinera() {
        return txtGasolinera;
    }

    public String get_txtNombreGasolinera() { return txtNombreGasolinera; }

    public int get_idImagen() {
        return idImagen;
    }
}


