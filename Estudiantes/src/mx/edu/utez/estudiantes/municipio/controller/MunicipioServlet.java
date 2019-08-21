package mx.edu.utez.estudiantes.municipio.controller;

import com.google.gson.Gson;
import mx.edu.utez.estudiantes.estado.dao.EstadoDao;
import mx.edu.utez.estudiantes.estado.model.Estado;
import mx.edu.utez.estudiantes.municipio.dao.MunicipioDao;
import mx.edu.utez.estudiantes.municipio.model.Municipio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MunicipioServlet", urlPatterns = "MunicipioServlet")
public class MunicipioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        BufferedReader readed = request.getReader();
        Gson gson = new Gson();
        Estado estado = gson.fromJson(readed,Estado.class);

        MunicipioDao muncionDao = new MunicipioDao();
        List<Municipio> municipios = muncionDao.obtenerMunicipio( (estado.getIdEstado()));

        PrintWriter out = response.getWriter();
        gson = new Gson();
        out.print(gson.toJson(municipios));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
