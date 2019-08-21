package mx.edu.utez.repaso.libro.dao;

import mx.edu.utez.repaso.libro.model.Libro;
import mx.edu.utez.repaso.utility.Conexion;

import java.sql.*;

public class LibroDao implements ILibroDao {
    @Override
    public Libro registrarLibro(Libro libro) {
        String registrarLibro = "INSERT INTO Libro(titulo,editorial,edicion,anio,resumen) values(?,?,?,?,?);";

        Connection conexion = new Conexion().obtenerConexion();

        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(registrarLibro, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, libro.getTitulo());
            preparedStatement.setString(2, libro.getEditorial());
            preparedStatement.setInt(3, libro.getEdicion());
            preparedStatement.setInt(4,libro.getAnio());
            preparedStatement.setString(5, libro.getResumen());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            libro.setIdLibro(id);

        } catch (SQLException ex) {
            System.out.println(this.getClass().getCanonicalName() + "@" + ex.getMessage());
        }


        return libro;
    }
}
