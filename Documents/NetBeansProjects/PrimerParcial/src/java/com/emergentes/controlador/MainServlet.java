
package com.emergentes.controlador;

import com.emergentes.modelo.persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        persona objper = new persona();
        int id, pos;
        HttpSession ses = request.getSession();
        List<persona> lista = (List<persona>) ses.getAttribute("listaper");
        switch (opcion) {
            case "nuevo":
                //
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                //
                pos = buscarPorIndice(request, id);
                //
                objper = lista.get(pos);
                //
                request.setAttribute("miobjper", objper);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >= 0) {
                    lista.remove(pos);
                }
                //
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
                break;

            default:
                request.setAttribute("listaper", lista);
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<persona> lista = (ArrayList<persona>) ses.getAttribute("listaper");
        persona objper = new persona();
        objper.setId(id);
        objper.setNombres(request.getParameter("nombres"));
        objper.setPeso(Integer.parseInt(request.getParameter("peso")));
        objper.setTalla(Integer.parseInt(request.getParameter("talla")));
        objper.setVacuna(request.getParameter("vacuna"));
        System.out.println("el id es" + id);
        if (id == 0) {
            //
            int idNUEVO = obtenerId(request);
            objper.setId(idNUEVO);

            lista.add(objper);
            System.out.println(objper.toString());
        } else {
            //
            int pos = buscarPorIndice(request, id);
            lista.set(pos, objper);
            System.out.println(objper.toString());
        }
        System.out.println("enviando as index");
        request.setAttribute("listaper", lista);
        response.sendRedirect("index.jsp");
    }

    private int buscarPorIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        List<persona> lista = (List<persona>) ses.getAttribute("listaper");

        int pos = -1;
        if (lista != null) {
            for (persona ele : lista) {
                ++pos;
                if (ele.getId() == id) {
                    break;
                }
            }
        }
        return pos;
    }

    private int obtenerId(HttpServletRequest request) {
        HttpSession ses = request.getSession();
        ArrayList<persona> lista = (ArrayList<persona>) ses.getAttribute("listaper");
///
        int idn = 0;
        for (persona ele : lista) {
            idn = ele.getId();
        }
        return idn + 1;
    }
}

