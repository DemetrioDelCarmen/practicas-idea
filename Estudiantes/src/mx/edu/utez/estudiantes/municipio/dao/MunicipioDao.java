package mx.edu.utez.estudiantes.municipio.dao;

import mx.edu.utez.estudiantes.municipio.model.Municipio;
import mx.edu.utez.estudiantes.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDao implements IDaoMunicipio {


    @Override
    public List<Municipio> obtenerMunicipio(int idEstado) {
        List<Municipio> municipios = new ArrayList<>();
        String sqlObtenerMunicipios = "SELECT idEstado, idMunicipio, nombre " +
                "FROM municipio WHERE idEstado = ?";

        try{

            Connection conexion =  new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sqlObtenerMunicipios);

            preparedStatement.setInt(1,idEstado);
            ResultSet resultSet =  preparedStatement.executeQuery();
            Municipio municipio;
            while (resultSet.next()){
                municipio = new Municipio();
                municipio.setIdMunicipio(resultSet.getInt("idMunicipio"));
                municipio.setIdEstado(resultSet.getInt("idEstado"));
                municipio.setNombre(resultSet.getString("nombre"));
                municipios.add(municipio);
            }
            resultSet.close();
            preparedStatement.close();
            conexion.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return municipios;
    }
}
