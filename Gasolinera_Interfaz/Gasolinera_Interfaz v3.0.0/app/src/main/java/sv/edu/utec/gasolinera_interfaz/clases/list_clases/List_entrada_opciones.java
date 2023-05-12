package sv.edu.utec.gasolinera_interfaz.clases.list_clases;

public class List_entrada_opciones {
    private String txtSucursalGasolinera, txtUbicacionGasolinera, txtPrecioDiesel, txtPrecioRegular, txtPrecioEspecial;

    public List_entrada_opciones(String txtSucursalGasolinera, String txtUbicacionGasolinera, String txtPrecioDiesel, String txtPrecioRegular, String txtPrecioEspecial) {
        this.txtSucursalGasolinera = txtSucursalGasolinera;
        this.txtUbicacionGasolinera = txtUbicacionGasolinera;
        this.txtPrecioDiesel = txtPrecioDiesel;
        this.txtPrecioRegular = txtPrecioRegular;
        this.txtPrecioEspecial = txtPrecioEspecial;
    }
    public String get_txtSucursalGasolinera() {
        return txtSucursalGasolinera;
    }

    public String get_txtUbicacionGasolinera() {
        return txtUbicacionGasolinera;
    }

    public String get_txtPrecioDiesel() {
        return txtPrecioDiesel;
    }

    public String get_txtPrecioRegular() {
        return txtPrecioRegular;
    }

    public String get_txtPrecioEspecial() {
        return txtPrecioEspecial;
    }
}

