package mx.edu.utez.estudiantes.estado.dao;

import com.mysql.cj.protocol.Resultset;
import mx.edu.utez.estudiantes.estado.model.Estado;
import mx.edu.utez.estudiantes.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao  implements  IDaoEstado{


    @Override
    public List<Estado> obtenerEstados() {
        List<Estado>estados = new ArrayList<>();
        String sqlEstados = "SELECT idEstado, nombre FROM estado";

        try {
            Connection conexion =  new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sqlEstados);
            ResultSet resultset = preparedStatement.executeQuery();
            Estado estado;
            while (resultset.next()){
                estado = new Estado();
                estado.setIdEstado(resultset.getInt("idEstado"));
                estado.setNombre(resultset.getString("nombre"));
                estados.add(estado);
            }
            resultset.close();
            preparedStatement.close();
            conexion.close();

        }catch(SQLException ex){
            System.out.println(this.getClass().getCanonicalName()+"@"+ ex.getMessage());
        }
        return estados;
    }
}
