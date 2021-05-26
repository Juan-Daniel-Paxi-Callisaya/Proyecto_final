
package com.emergentes.controlador;

import com.emergentes.DAO.UsuariosDAO;
import com.emergentes.DAO.UsuariosDAOimpl;
import com.energentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("usu");            
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
         
        UsuariosDAO userDao = new UsuariosDAOimpl();
         
        try {
            Usuarios usu = userDao.Validar(usuario, correo, clave);
            String destPage = "Login.jsp";
            if (usu.getUsuario()!=null && usu.getCorreo()!=null && usu.getClave()!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("usu", usu);
                destPage = "bienvenido.jsp";
            } else {
                String message = "Invalid datos";
                request.setAttribute("message", message);
            } 
            request.getRequestDispatcher(destPage).forward(request, response);
        } catch (Exception ex) {
            System.out.println("ERROR AL CONECTAR :   "+ex.getMessage());
        }        

    }

}
