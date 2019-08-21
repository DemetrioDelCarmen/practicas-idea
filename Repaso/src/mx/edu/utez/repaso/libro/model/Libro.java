package mx.edu.utez.repaso.libro.model;

public class Libro {

    private int idLibro;
    private String titulo;
    private String editorial;
    private int edicion;
    private String resumen;
    private int anio;

    public Libro (){

    }

    public Libro(int idLibro, String titulo, String editorial, int edicion, String resumen, int anio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.editorial = editorial;
        this.edicion = edicion;
        this.resumen = resumen;
        this.anio = anio;
    }


    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", edicion=" + edicion +
                ", resumen='" + resumen + '\'' +
                ", anio=" + anio +
                '}';
    }
}
