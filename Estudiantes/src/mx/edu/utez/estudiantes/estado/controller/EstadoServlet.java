package mx.edu.utez.estudiantes.estado.controller;

import com.google.gson.Gson;
import mx.edu.utez.estudiantes.estado.dao.EstadoDao;
import mx.edu.utez.estudiantes.estado.model.Estado;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EstadoServlet", urlPatterns = "EstadoServlet")
public class EstadoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out  = response.getWriter();
        EstadoDao  estadoDao =  new EstadoDao();
        List<Estado> estados =   estadoDao.obtenerEstados();

        Gson gson = new Gson();
        out.print(gson.toJson(estados));

    }
}
