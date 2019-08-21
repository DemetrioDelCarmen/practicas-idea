package mx.edu.utez.servletsbasico.usuario.model;

import java.io.InputStream;

public class UsuarioRol {
        private String usuario, rol;
        private int idUsuario;
        private String  imagen;
        public UsuarioRol (){

        }

        public UsuarioRol(String usuario, String rol, int idUsuario, String imagen) {
                this.usuario = usuario;
                this.rol = rol;
                this.idUsuario = idUsuario;
                this.imagen = imagen;
        }

        public String getUsuario() {
                return usuario;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
        }

        public String getRol() {
                return rol;
        }

        public void setRol(String rol) {
                this.rol = rol;
        }

        public int getIdUsuario() {
                return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
                this.idUsuario = idUsuario;
        }

        public String getImagen() {
                return imagen;
        }

        public void setImagen(String imagen) {
                this.imagen = imagen;
        }

        @Override
        public String toString() {
                return "UsuarioRol{" +
                        "usuario='" + usuario + '\'' +
                        ", rol='" + rol + '\'' +
                        ", idUsuario=" + idUsuario +
                        ", imagen=" + imagen +
                        '}';
        }

}
