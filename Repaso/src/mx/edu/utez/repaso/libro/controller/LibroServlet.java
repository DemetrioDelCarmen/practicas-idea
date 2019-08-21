package mx.edu.utez.repaso.libro.controller;

import mx.edu.utez.repaso.libro.dao.LibroDao;
import mx.edu.utez.repaso.libro.model.Libro;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "LibroServlet", urlPatterns = "LibroServlet")
public class LibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String titulo = request.getParameter("titulo");
        String editorial = request.getParameter("editorial");
        int edicion = Integer.parseInt(request.getParameter("edicion"));
        String resumen = request.getParameter("resumen");
        int anio = Integer.parseInt(request.getParameter("anio"));


        Libro libro = new Libro();

        libro.setTitulo(titulo);
        libro.setEditorial(editorial);
        libro.setEdicion(edicion);
        libro.setResumen(resumen);
        libro.setAnio(anio);

        LibroDao  libroDao = new LibroDao();
        libroDao.registrarLibro(libro);


        if(libro.getIdLibro()==0)
            System.out.println("No Insertado");
        else
            System.out.println("Insertado");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
