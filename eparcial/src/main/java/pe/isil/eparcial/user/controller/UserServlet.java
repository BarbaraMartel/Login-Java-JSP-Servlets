
package pe.isil.eparcial.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import pe.isil.eparcial.user.dao.UserDao;
import pe.isil.eparcial.user.model.User;

/**
 *
 * @author Barbara
 */

@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {      
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userDao = new UserDao();
        int rowsAffected = 0;
        String mensaje = "";
        
        String nombre = request.getParameter("nombre");
        String apePaterno = request.getParameter("apePaterno");
        String apeMaterno = request.getParameter("apeMaterno");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");

        
        User user = new User();
        
        user.setNombre(nombre);
        user.setApePaterno(apePaterno);
        user.setApeMaterno(apeMaterno);
        user.setDireccion(direccion);
        user.setCorreo(correo);
        user.setPass(pass);
        
        try {
            rowsAffected = userDao.registerUser(user);
            
            mensaje = "Usuario registrado satisfactoriamente";
            
        } catch (Exception e) {
            mensaje = "Error al registrar el usuario: " + e.toString();
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultregister.jsp");
        request.setAttribute("message", mensaje);
        dispatcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
