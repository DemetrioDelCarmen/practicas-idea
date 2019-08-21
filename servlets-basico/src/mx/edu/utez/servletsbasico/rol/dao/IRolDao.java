package mx.edu.utez.servletsbasico.rol.dao;

import mx.edu.utez.servletsbasico.rol.model.Rol;

import java.util.List;

public interface IRolDao {
    Rol obtenerRol(int idRol);
    List<Rol>obtenerRoles();
}
