package mx.edu.utez.estudiantes.municipio.dao;
import mx.edu.utez.estudiantes.municipio.model.Municipio;

import java.util.List;

public interface IDaoMunicipio {

        List<Municipio> obtenerMunicipio(int idEstado);

}
