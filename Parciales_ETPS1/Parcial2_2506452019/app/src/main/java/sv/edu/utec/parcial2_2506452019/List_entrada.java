package sv.edu.utec.parcial2_2506452019;

public class List_entrada {
    private int idImagen;
    private String textoEncima;
    private String textoIntermedio;
    private String textoDebajo;

    public List_entrada (int idImagen, String textoEncima, String textoIntermedio, String textoDebajo) {
        this.idImagen = idImagen;
        this.textoEncima = textoEncima;
        this.textoIntermedio = textoIntermedio;
        this.textoDebajo = textoDebajo;
    }
    public String get_textoEncima() {
        return textoEncima;
    }
    public String get_textoIntermedio() {
        return textoIntermedio;
    }
    public String get_textoDebajo() {
        return textoDebajo;
    }
    public int get_idImagen() {
        return idImagen;
    }
}
