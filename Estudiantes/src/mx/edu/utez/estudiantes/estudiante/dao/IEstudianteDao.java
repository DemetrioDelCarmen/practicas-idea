package mx.edu.utez.estudiantes.estudiante.dao;

import mx.edu.utez.estudiantes.estudiante.model.EstudianteBean;

import java.util.List;

public interface IEstudianteDao {
     boolean registrarEstudiante(EstudianteBean estudianteBean);
     EstudianteBean obtenerEstudiante (String matricula);
     boolean borrarEstudiante (String matricula);
     List<EstudianteBean> obtenerEstudiantes();
     boolean modificarEstudiante (EstudianteBean estudianteBean);

}
