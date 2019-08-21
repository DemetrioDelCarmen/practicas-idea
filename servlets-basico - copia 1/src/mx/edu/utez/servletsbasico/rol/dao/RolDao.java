package mx.edu.utez.servletsbasico.rol.dao;

import mx.edu.utez.servletsbasico.rol.model.Rol;
import mx.edu.utez.servletsbasico.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDao implements IRolDao {
    @Override
    public Rol obtenerRol(int idRol) {
        return null;
    }

    @Override
    public List<Rol> obtenerRoles() {
        List<Rol> roles = new ArrayList<>();
        //0 los metodos que devuelve un metodo se crea al inicio

        // 1- lo primero que debes hacer en el metodo del dao  es una consulta
        String consulta = "SELECT idRol,nombre FROM Rol";
        // 2 - Hacer la conexion, como es servicio externo debe ir dentro de try/catch
        try{
            Connection conexion = new Conexion().obtenerConexion();
            // 3 - preparar la consulta
            PreparedStatement preparedStatement =  conexion.prepareStatement(consulta);
            // 4 - proporcionar los valores que sustituyen los (?)
            // 5 - Ejecutar la consulta
             ResultSet resultSet = preparedStatement.executeQuery();
             // 6 - Llenar la lista
                Rol rol;
            while (resultSet.next()){
               rol = new Rol();
               rol.setIdRol(resultSet.getInt("idRol"));
               rol.setNombre(resultSet.getString("nombre"));
               roles.add(rol);
            }
            // 7 - Devolver la lista
        }catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }
        return roles;
    }
}
