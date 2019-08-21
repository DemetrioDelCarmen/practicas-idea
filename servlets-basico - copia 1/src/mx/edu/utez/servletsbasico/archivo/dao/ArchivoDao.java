package mx.edu.utez.servletsbasico.archivo.dao;

import com.mysql.cj.protocol.Resultset;
import mx.edu.utez.servletsbasico.archivo.model.Archivo;
import mx.edu.utez.servletsbasico.utility.Conexion;

import java.sql.*;
import java.util.function.Predicate;

public class ArchivoDao implements IArchivoDao {
    @Override
    public int registrarArchivo(Archivo archivo) {


        String sqlInsertarArchivo = "INSERT INTO archivo(nombreArchivo,tipo,contenido,tamanio) values(?,?,?,?);";

        try {
            Connection conexion = new Conexion().obtenerConexion();

            PreparedStatement preparedStatement =
                    conexion.prepareStatement(sqlInsertarArchivo, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, archivo.getNombreArchivo());
            preparedStatement.setString(2, archivo.getTipo());
            preparedStatement.setBinaryStream(3, archivo.getContenido());
            preparedStatement.setDouble(4, archivo.getTamanio());

            preparedStatement.execute();
            ResultSet resultset = preparedStatement.getGeneratedKeys();

            resultset.next();
            int idArchivo = resultset.getInt(1);
            return idArchivo;
        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + " - " + ex.getMessage());
        }

        return 0;
    }

    @Override
    public Archivo obtenerArchivo(int id) {
        String sqlObtenerDocumento = "SELECT nombreArchivo, tipo, contenido, tamanio FROM " +
                "archivo WHERE idArchivo = ?";
        Archivo archivo = new Archivo();
        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sqlObtenerDocumento);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            archivo.setNombreArchivo(resultSet.getString("nombreArchivo"));
            archivo.setTipo(resultSet.getString("tipo"));
            archivo.setContenido(resultSet.getBinaryStream("contenido"));
            archivo.setTamanio(resultSet.getDouble("tamanio"));


        } catch (SQLException ex) {

            System.out.println(this.getClass().getCanonicalName() +"@"+ex.getMessage());
        }

        return archivo;
    }
}
