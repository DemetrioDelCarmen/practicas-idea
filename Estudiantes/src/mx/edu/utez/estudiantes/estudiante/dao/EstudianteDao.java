package mx.edu.utez.estudiantes.estudiante.dao;

import mx.edu.utez.estudiantes.estudiante.model.EstudianteBean;
import mx.edu.utez.estudiantes.utility.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao implements IEstudianteDao {

    @Override
    public boolean registrarEstudiante(EstudianteBean estudianteBean) {
        String SQL_REGISTRAR_ESTUDIANTE = "INSERT INTO calificacion(matricula,nombre,apellidos,asignatura,calificacion) " +
                "VALUES(?,?,?,?,?)";

        try{
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(SQL_REGISTRAR_ESTUDIANTE);

            preparedStatement.setString(1,estudianteBean.getMatricula());
            preparedStatement.setString(2,estudianteBean.getNombre());
            preparedStatement.setString(3,estudianteBean.getApellidos());
            preparedStatement.setString(4,estudianteBean.getAsignatura());
            preparedStatement.setInt(5,estudianteBean.getCalificacion());

            preparedStatement.execute();
            return true;

        }catch (Exception ex){
            System.out.println(this.getClass().getCanonicalName()+ " " + ex.getMessage());
        }

        return false;
    }

    @Override
    public EstudianteBean obtenerEstudiante(String matricula) {
        return null;
    }

    @Override
    public boolean borrarEstudiante(String matricula) {
        return false;
    }

    @Override
    public List<EstudianteBean> obtenerEstudiantes() {
        List<EstudianteBean> listaEstudiantes = new ArrayList<>();

        String sql = "SELECT matricula,nombre,apellidos,asignatura," +
                "calificacion FROM calificacion";

        try {
            Connection conexion = new Conexion().obtenerConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet =  preparedStatement.executeQuery();

            EstudianteBean estudiante;

            while(resultSet.next()){
                estudiante = new EstudianteBean();

                estudiante.setMatricula(resultSet.getString("matricula"));
                estudiante.setNombre(resultSet.getString("nombre"));
                estudiante.setApellidos(resultSet.getString("apellidos"));
                estudiante.setAsignatura(resultSet.getString("asignatura"));
                estudiante.setCalificacion(resultSet.getInt("calificacion"));

                listaEstudiantes.add(estudiante);
            }
            return listaEstudiantes;
        }catch (Exception ex){
            System.out.println(this.getClass().getCanonicalName()+ " " + ex.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public boolean modificarEstudiante(EstudianteBean estudianteBean) {
        return false;
        }
}
