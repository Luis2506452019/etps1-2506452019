package sv.edu.utec.gasolinera_interfaz.clases.list_clases;

public class List_entrada {
    private int idImagen;
    private String textoEncima;
    private String textoDebajo;

    public List_entrada (int idImagen, String textoEncima, String textoDebajo) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoDebajo = textoDebajo;
    }
    public String get_textoEncima() {
        return textoEncima;
    }
    public String get_textoDebajo() { return textoDebajo; }
    public int get_idImagen() {
        return idImagen;
    }
}

