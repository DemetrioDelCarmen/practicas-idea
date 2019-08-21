package mx.edu.utez.servletsbasico.archivo.model;

import java.io.InputStream;

public class Archivo {

        private int idArchivo;
        private String nombreArchivo;
        private String tipo;
        private InputStream contenido;
        private double  tamanio;
        public Archivo(){}

    public Archivo(int idArchivo, String nombreArchivo, String tipo, InputStream contenido) {
        this.idArchivo = idArchivo;
        this.nombreArchivo = nombreArchivo;
        this.tipo = tipo;
        this.contenido = contenido;
        this.tamanio = tamanio;
    }

    public int getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public InputStream getContenido() {
        return contenido;
    }

    public void setContenido(InputStream contenido) {
        this.contenido = contenido;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Archivo{" +
                "idArchivo=" + idArchivo +
                ", nombreArchivo='" + nombreArchivo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", contenido=" + contenido +
                '}';
    }
}
