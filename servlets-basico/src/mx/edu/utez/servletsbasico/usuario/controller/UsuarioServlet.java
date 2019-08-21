package mx.edu.utez.servletsbasico.usuario.controller;

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
                if (usuario1.getIdUsuario() != 0) {
                    request.setAttribute("mensaje", "El registro se hizo correctamente");
                } else {
                    request.setAttribute("error", "Ocurrió un error en la insercción");
                }

                RolDao rolDao = new RolDao();
                List<Rol> roles = rolDao.obtenerRoles();
                request.setAttribute("roles", roles);
                request.getRequestDispatcher("usuario/form.jsp").forward(request, response);
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

            default: {
                break;
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion") == null ? "":request.getParameter("accion");
        switch (accion) {
            case "agregar": {
                HttpSession sesion = request.getSession();
                if (sesion.getAttribute("usuario") == null) {


                    response.sendRedirect("index.jsp");
                } else {
                    RolDao rolDao = new RolDao();
                    List<Rol> roles = rolDao.obtenerRoles();
                    request.setAttribute("roles", roles);
                    request.getRequestDispatcher("usuario/form.jsp")
                            .forward(request, response);
                }
                break;
            }
            default: {
                //codigo para enviar la lista de usuarios al home
                UsuarioDao usuarioDao = new UsuarioDao();
                List<UsuarioRol> usuarios = usuarioDao.obtenerUsuarios();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("home.jsp")
                        .forward(request, response);
            }

        }

    }
}


