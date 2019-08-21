package mx.edu.utez.servletsbasico.usuario.controller;

import com.google.gson.Gson;
import mx.edu.utez.servletsbasico.rol.dao.RolDao;
import mx.edu.utez.servletsbasico.rol.model.Rol;
import mx.edu.utez.servletsbasico.usuario.dao.UsuarioDao;
import mx.edu.utez.servletsbasico.usuario.model.Usuario;
import mx.edu.utez.servletsbasico.usuario.model.UsuarioRol;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Es requisito indispensable que se ponga la diagonal en el nombre del servlet para
 * entrar al servlet
 */
@MultipartConfig
@WebServlet(name = "UsuarioServlet", urlPatterns = "UsuarioServlet")

public class UsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        switch (accion) {
            case "login": {
                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");

                Usuario user = new Usuario();
                user.setUsuario(usuario);
                user.setContrasena(contrasena);

                UsuarioDao usuarioDao = new UsuarioDao();
                user = usuarioDao.obtenerUsuario(user);

                if (user.getIdUsuario() == 0) {
                    request.setAttribute("error", "el nombre o el usuario no existe");
                    request.getRequestDispatcher("index.jsp").forward
                            (request, response);
                } else {
                    // HttpSession sesion = request.getSession();
                    //sesion.setAttribute("usuario", user);
                    // request.setAttribute("nombre", user.getUsuario());
                    response.sendRedirect("UsuarioServlet");
                }
                break;
            }

            case "registrar": {
                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                int rol = Integer.parseInt(request.getParameter("rol"));

                Usuario usuario1 = new Usuario();
                usuario1.setIdRol(rol);
                usuario1.setUsuario(usuario);
                usuario1.setContrasena(contrasena);

                UsuarioDao usuarioDao = new UsuarioDao();
                usuario1 = usuarioDao.registrarUsuario(usuario1);

                PrintWriter out = response.getWriter();
                if (usuario1.getIdUsuario() != 0) {
                    //  se insertó
                    out.print("true");

                } else {
                    //no se insertó

                    out.print("false");
                }
                break;
            }
            case "eliminar":{
                int id = Integer.parseInt(request.getParameter("id"));

                UsuarioDao usuarioDao = new UsuarioDao();
                    PrintWriter out = response.getWriter();
                if(usuarioDao.eliminarUsuario(id)){
                    //devolver a JS un true;
                    out.print("true");
                }else{
                    // devolver a JS un false;
                    out.print("false");
                }


                break;
            }
            case "cargar": {


                UsuarioDao usuarioDao = new UsuarioDao();
                List<UsuarioRol> usuarios = usuarioDao.obtenerUsuarios();

                PrintWriter out = response.getWriter();

                //Javascript Object Notation
                //Librería en Java
                //GSON... GOOGLE
                Gson gson = new Gson();
                out.print(gson.toJson(usuarios));
                break;

            }
            case "cargarUsuario":{

                int id = Integer.parseInt(request.getParameter("id"));
                UsuarioDao usuarioDao = new UsuarioDao();
                Usuario usuario = new Usuario();
                usuario = usuarioDao.cargarUsuario(id);
                PrintWriter out = response.getWriter();

                Gson gson = new Gson();
                out.print(gson.toJson(usuario));


                break;
            }
            case "actualizar":{
                // 1. Recibir los valores que se envían en AJAX mediante FORMDATA

                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                int rol = Integer.parseInt(request.getParameter("rol"));
                int id = Integer.parseInt(request.getParameter("id"));
                //2. Crear un objeto usuario con los datos recibidos
                Usuario usuario1 = new Usuario();
                usuario1.setIdUsuario(id);
                usuario1.setUsuario(usuario);
                usuario1.setContrasena(contrasena);
                usuario1.setIdRol(rol);

                //3. Mandar el objeto usuario al metodo actualizar del DAO
                UsuarioDao usuarioDao = new UsuarioDao();
                boolean actualizo = usuarioDao.modificarUsuario(usuario1);
                //4. Imprimir OK en caso de que esté correcto
                PrintWriter out = response.getWriter();
                if(actualizo)
                    out.print("OK");
                else
                    out.print("No Ok");


                break;
            }

            default: {
                break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "":request.getParameter("action");

            switch (action){
                case "verAsesorias":{
                   request.getRequestDispatcher("home2.jsp")
                           .forward(request,response);
                    break;
                }
                default:{
                    System.out.println("No se puede redirigir");
                }

            }
                RolDao rolDao = new RolDao();

                List<Rol> roles = rolDao.obtenerRoles();


                //codigo para enviar la lista de usuarios al home
                UsuarioDao usuarioDao = new UsuarioDao();
                List<UsuarioRol> usuarios = usuarioDao.obtenerUsuarios();
                request.setAttribute("usuarios", usuarios);
                request.setAttribute("roles",roles);
                request.getRequestDispatcher("home.jsp")
                        .forward(request, response);
            }

        }





