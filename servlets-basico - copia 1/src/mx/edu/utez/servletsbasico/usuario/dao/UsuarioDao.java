package mx.edu.utez.servletsbasico.usuario.dao;

import mx.edu.utez.servletsbasico.usuario.model.Usuario;
import mx.edu.utez.servletsbasico.usuario.model.UsuarioRol;
import mx.edu.utez.servletsbasico.utility.Conexion;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/*
*
*
* */
public class UsuarioDao implements IUsuarioDao {
    /**
     *
     * @param usuario
     * @return usuario;
     */
    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        String sql = "SELECT idUsuario,usuario, contrasena FROM usuario WHERE  usuario = ? " +
                "AND contrasena = ?";

        try {

            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);

            preparedStatement.setString(1, usuario.getUsuario());
            preparedStatement.setString(2, usuario.getContrasena());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            usuario.setIdUsuario(resultSet.getInt("idUsuario"));
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }

        return usuario;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        String sqlRegistrar = "INSERT INTO usuario(usuario, contrasena,rol) values(?,?,?)";

        try{

            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement= conexion.prepareStatement(sqlRegistrar, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1,usuario.getUsuario());
            preparedStatement.setString(2,usuario.getContrasena());
            preparedStatement.setInt(3,usuario.getIdRol());

            preparedStatement.execute();
            ResultSet  resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            usuario.setIdUsuario(resultSet.getInt(1));


        }catch (SQLException ex){
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }

        return usuario;
    }

    @Override
    public boolean eliminarUsuario(int idUsuario) {

                String sqlEliminar = "DELETE FROM usuario WHERE idUsuario = ?";

                try{

                    Connection  conexion = new Conexion().obtenerConexion();
                    PreparedStatement preparedStatement = conexion.prepareStatement(sqlEliminar);

                    preparedStatement.setInt(1,idUsuario);
                    preparedStatement.execute();
                    return true;

                }catch(SQLException ex){

                    System.out.println(this.getClass().getCanonicalName() +"@" + ex.getMessage());
                    return false;
                }
    }

    @Override
    public boolean modificarUsuario(Usuario usuario) {

        String sqlActualizarUsuario = "call actualizarUsuario(?,?,?,?)";
        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareCall(sqlActualizarUsuario);
            preparedStatement.setInt(1,usuario.getIdUsuario());
            preparedStatement.setString(2,usuario.getUsuario());
            preparedStatement.setString(3,usuario.getContrasena());
            preparedStatement.setInt(4,usuario.getIdRol());

            preparedStatement.execute();

            return true;

        }catch (SQLException ex){
            System.out.println(this.getClass().getCanonicalName() +"@"+ ex.getMessage());

        }


        return false;
    }

    @Override
    public List<UsuarioRol> obtenerUsuarios() {
        List<UsuarioRol> usuarios = new ArrayList<>();
        String obtenerUs ="SELECT idUsuario, usuario, nombre, imagen FROM usuario u JOIN rol r ON u.rol = r.idRol;";

        try{
                Connection conexion = new Conexion().obtenerConexion();
                PreparedStatement preparedStatement = conexion.prepareStatement(obtenerUs);

                ResultSet resultSet = preparedStatement.executeQuery();
            UsuarioRol usuarioRol;
            while (resultSet.next()){
                usuarioRol = new UsuarioRol();
                usuarioRol.setIdUsuario(resultSet.getInt("idUsuario"));
                usuarioRol.setUsuario(resultSet.getString("usuario"));
                usuarioRol.setRol(resultSet.getString("nombre"));


                byte [] bytes = IOUtils.toByteArray(resultSet.getBinaryStream("imagen"));
                String base64String = Base64.getEncoder().encodeToString(bytes);
                usuarioRol.setImagen(base64String);
                //<img src="base64:cadenaDeByteCodificadaEnBase64"/>
                System.out.println(usuarioRol.getIdUsuario());

                usuarios.add(usuarioRol);
            }



        }catch (SQLException | IOException ex){
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }

        return usuarios;
    }

    @Override
    public Usuario cargarUsuario(int idUsuario) {
            Usuario usuario  = new Usuario();
         String sql_cargarUsuario = "SELECT  usuario, contrasena, rol FROM usuario WHERE idUsuario = ?;";
            Connection conexion  =  new Conexion().obtenerConexion();

            try{
                PreparedStatement preparedStatement = conexion.prepareStatement(sql_cargarUsuario);
                preparedStatement.setInt(1,idUsuario);
                ResultSet resultSet =  preparedStatement.executeQuery();

                resultSet.next();
                usuario.setUsuario(resultSet.getString("usuario"));
                usuario.setContrasena(resultSet.getString("contrasena"));
                usuario.setIdRol(resultSet.getInt("rol"));



            }catch (SQLException ex){

                System.out.println(this.getClass().getCanonicalName() +"@"+ ex.getMessage());

            }

        return usuario;
    }
}
