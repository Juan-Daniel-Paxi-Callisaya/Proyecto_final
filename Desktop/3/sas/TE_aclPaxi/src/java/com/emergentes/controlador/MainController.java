
package com.emergentes.controlador;

import com.emergentes.DAO.RolesDAO;
import com.emergentes.DAO.RolesDAOimpl;
import com.energentes.modelo.Roles;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 try {
            RolesDAO dao = new RolesDAOimpl();
            int id;
            Roles pro = new Roles();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                // n r
                case "add":
                    request.setAttribute("roles", pro);
                    request.getRequestDispatcher("formroles.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    request.setAttribute("roles", pro);
                    request.getRequestDispatcher("formroles.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    //request.getRequestDispatcher("Inicio").forward(request, response);
                    response.sendRedirect("MainController");
                    break;
                default:
                    List<Roles> lista = dao.getAll();
                    request.setAttribute("roles", lista);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RolesDAO dao = new RolesDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String descripcion = request.getParameter("descripcion");
        Roles pro = new Roles();
        pro.setId(id);
        pro.setDescripcion(descripcion);
        if (id == 0) {
            //new reg
            try {
                dao.insert(pro);
                response.sendRedirect("MainController");
            } catch (Exception e) {
                System.out.println("error en driver" + e.getMessage());
            }
        } else {
            try {
                dao.update(pro);
                response.sendRedirect("MainController");
            } catch (Exception e) {
                System.out.println("error en driver" + e.getMessage());
            }
        }        

    }
}
