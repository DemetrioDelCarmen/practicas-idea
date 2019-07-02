package mx.edu.utez.estudiantes.estudiante.controller;

import mx.edu.utez.estudiantes.estudiante.dao.EstudianteDao;
import mx.edu.utez.estudiantes.estudiante.model.EstudianteBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EstudianteServlet", urlPatterns = "/EstudianteServlet")
public class EstudianteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String asignatura = request.getParameter("asignatura");
        int calificacion = Integer.parseInt(request.getParameter("calificacion"));

        EstudianteBean unEstudiante = new EstudianteBean();

        unEstudiante.setMatricula(matricula);
        unEstudiante.setNombre(nombre);
        unEstudiante.setApellidos(apellidos);
        unEstudiante.setAsignatura(asignatura);
        unEstudiante.setCalificacion(calificacion);

        EstudianteDao estudianteDao = new EstudianteDao();
        estudianteDao.registrarEstudiante(unEstudiante);

        response.sendRedirect("EstudianteServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EstudianteDao estudianteDao = new EstudianteDao();
            List<EstudianteBean> estudiantes = estudianteDao.obtenerEstudiantes();

            request.setAttribute("estudiantes",estudiantes);

            request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
