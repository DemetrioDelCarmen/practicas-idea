package mx.edu.utez.servletsbasico.usuario.model;

public class UsuarioRol {
        private String usuario, rol;
        private int idUsuario;

        public UsuarioRol (){

        }

        public UsuarioRol(String usuario, String rol, int idUsuario) {
                this.usuario = usuario;
                this.rol = rol;
                this.idUsuario = idUsuario;
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

        @Override
        public String toString() {
                return "UsuarioRol{" +
                        "usuario='" + usuario + '\'' +
                        ", rol='" + rol + '\'' +
                        ", idUsuario=" + idUsuario +
                        '}';
        }
}
