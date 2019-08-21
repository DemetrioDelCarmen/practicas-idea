package mx.edu.utez.servletsbasico.archivo.dao;

import mx.edu.utez.servletsbasico.archivo.model.Archivo;

public interface IArchivoDao {


     int registrarArchivo(Archivo archivo);


     Archivo obtenerArchivo(int id);


}
