package mx.edu.utez.servletsbasico.usuario.dao;

import mx.edu.utez.servletsbasico.usuario.model.Usuario;
import mx.edu.utez.servletsbasico.usuario.model.UsuarioRol;

import java.util.List;

public interface IUsuarioDao {


        //obtener
        //Entrada: Usuario. Este usuario tiene
        //         nombre de usuario y contraseña
        //         No tiene ID
        // Funcionamiento: Este metodo verifica
        // que exista en la  base de datos.
        // Salida: Usuario. Este usuario tiene TODOS LOS DATOS.
        Usuario obtenerUsuario(Usuario usuario);
        //registrar
        Usuario registrarUsuario(Usuario usuario);
        //eliminar
        boolean eliminarUsuario(int id);
        //modificar
        boolean modificarUsuario(Usuario usuario);
        List<UsuarioRol> obtenerUsuarios();

         Usuario cargarUsuario(int idUsuario);

}
