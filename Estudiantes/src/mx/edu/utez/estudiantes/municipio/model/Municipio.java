package mx.edu.utez.estudiantes.municipio.model;

public class Municipio {

        private  int idMunicipio;
        private int idEstado;
        private String nombre;


    public Municipio(){}
    public Municipio(int idMunicipio, int idEstado, String nombre) {
        this.idMunicipio = idMunicipio;
        this.idEstado = idEstado;
        this.nombre = nombre;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" +
                "idMunicipio"+'\''+idMunicipio+
                "idEstado"+'\''+idEstado+
                "nombre"+'\''+nombre+
                "}";


    }
}
