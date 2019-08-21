package mx.edu.utez.servletsbasico.archivo.controller;

import mx.edu.utez.servletsbasico.archivo.dao.ArchivoDao;
import mx.edu.utez.servletsbasico.archivo.model.Archivo;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@MultipartConfig
@WebServlet(name = "ArchivoServlet", urlPatterns = "ArchivoServlet")
public class ArchivoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String accion = request.getParameter("accion");

        switch (accion){
            case "cargar":{

                Part part =  request.getPart("archivo");
                Archivo archivo = new Archivo();


                archivo.setNombreArchivo(part.getSubmittedFileName());
                archivo.setTamanio(part.getSize());
                archivo.setTipo(part.getContentType());
                archivo.setContenido(part.getInputStream());
                System.out.println(archivo);

                ArchivoDao archivoDao = new ArchivoDao();
                int id = archivoDao.registrarArchivo(archivo);

                if(id!=0)
                    System.out.println("Se insertó");
                else
                    System.out.println("No se insertó");

                break;
            }

            case "descargar":{
                int idArchivo = Integer.parseInt(request.getParameter("id"));
                ArchivoDao archivoDao = new ArchivoDao();

                Archivo archivo  = archivoDao.obtenerArchivo(idArchivo);


                //tipo archivo
                response.setContentType(archivo.getTipo());
                // ne lugar del text/html
                response.setHeader("Content-Disposition","attachment;filename=".concat(archivo.getNombreArchivo()));


                OutputStream out = response.getOutputStream();
                out.write(IOUtils.toByteArray(archivo.getContenido()));
                out.flush();


                break;
            }
            default:
                System.out.println("Nelson");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getRequestDispatcher("archivo/cargarArchivo.jsp")
            .forward(request,response);

    }
}
