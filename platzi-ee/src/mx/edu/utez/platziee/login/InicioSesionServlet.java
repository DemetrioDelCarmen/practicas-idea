package mx.edu.utez.platziee.login;

import mx.edu.utez.platziee.estudiante.modelo.Estudiante;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/InicioSesionServlet", urlPatterns = "/InicioSesionServlet")
public class InicioSesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasena");

            Estudiante estudiante = new Estudiante();
            estudiante.setUsuario(usuario);
            estudiante.setContrasena(contrasena);
            boolean autenticado  = estudiante.autentication();

            RequestDispatcher dispatcher = null;

            if (autenticado){
                dispatcher = request.getRequestDispatcher("welcome.jsp");
            }else{
                dispatcher = request.getRequestDispatcher("error.jsp");
            }

            dispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
