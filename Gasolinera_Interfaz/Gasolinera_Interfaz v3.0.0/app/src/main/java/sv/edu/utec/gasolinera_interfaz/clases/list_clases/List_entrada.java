package sv.edu.utec.gasolinera_interfaz.clases.list_clases;

public class List_entrada {
    private int idImagen;
    private String textoEncima;

    public List_entrada (int idImagen, String textoEncima) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
    }
    public String get_textoEncima() {
        return textoEncima;
    }
    public int get_idImagen() {
        return idImagen;
    }
}

