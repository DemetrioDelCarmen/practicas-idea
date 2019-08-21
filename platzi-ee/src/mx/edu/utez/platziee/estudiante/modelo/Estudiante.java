package mx.edu.utez.platziee.estudiante.modelo;

import java.io.Serializable;

public class Estudiante implements Serializable {
     private  String usuario;
     private String contrasena;

     public Estudiante () {}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
         return "Usuario{"+
                 "usuario = "+usuario +'\''+
                 ",contrasena =" +contrasena+'\''+
                 "}";

    }

    public boolean autentication(){
         return (contrasena.equals("holaplatzi"))?true:false;
    }
}
