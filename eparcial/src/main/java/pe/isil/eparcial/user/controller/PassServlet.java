
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

@WebServlet(name = "PassServlet", urlPatterns = {"/PassServlet"})
public class PassServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PassServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/showpass.jsp");
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao userDao = new UserDao();
        String mensaje = "";
        
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        
        User user = new User();
        
        user.setCorreo(correo);
        user.setPass(pass);
        
        try {
        mensaje = userDao.showPassword(user);
        //mensaje = "Tu contraseña es: " + yourpass;
        } catch (Exception e) {
            mensaje = e.toString();
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/resultregister.jsp");
        request.setAttribute("message", mensaje);
        dispatcher.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
