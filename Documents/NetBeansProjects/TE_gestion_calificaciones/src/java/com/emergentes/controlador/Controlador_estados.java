package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.DocentesDAO;
import com.emergentes.dao.DocentesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Docentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controlador_estados", urlPatterns = {"/Controlador_estados"})
public class Controlador_estados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            DocentesDAO daodocentes = new DocentesDAOimpl();
            EstudiantesDAO daoestudiantes = new EstudiantesDAOimpl();
            double total_docentes_tareas = 0.0;
            double total_docentes_r_estudiantes = 0.0;
            double total_docentes_docentes = 0.0;
            double total_estudiantes_tareas = 0.0;
            double total_estudiantes_r_estudiantes = 0.0;
            double total_estudiantes_docentes = 0.0;
         try {                        
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            String area = request.getParameter("area");
            switch(action){                
                case "tareas":
                total_docentes_tareas = daodocentes.docentes_totales_areas(area);
                total_estudiantes_tareas = daoestudiantes.estudiantes_totales_areas(area);
                System.out.println("TOTAL_DOCENTES:"+total_docentes_tareas);
                System.out.println("TOTAL_DOCENTES:"+total_estudiantes_tareas);
                request.setAttribute("total_docentes_area", total_docentes_tareas);
                request.setAttribute("total_estudiantes_area", total_estudiantes_tareas);
                
                DocentesDAO dao = new DocentesDAOimpl();
                List<Docentes> lista = dao.getAll_docente_area(area);
                request.setAttribute("docente", lista);
                EstudiantesDAO dao1 = new EstudiantesDAOimpl();
                List<Estudiantes> lista1 = dao1.getAll_estudiante_area(area);
                request.setAttribute("estudiante", lista1);                
                request.getRequestDispatcher("tareas.jsp").forward(request, response);
           
                    break;
                case "recursos":
                total_docentes_tareas = daodocentes.docentes_totales_areas(area);
                total_estudiantes_tareas = daoestudiantes.estudiantes_totales_areas(area);
                System.out.println("TOTAL_DOCENTES:"+total_docentes_tareas);
                System.out.println("TOTAL_DOCENTES:"+total_estudiantes_tareas);
                request.setAttribute("total_docentes_area", total_docentes_tareas);
                request.setAttribute("total_estudiantes_area", total_estudiantes_tareas);
                
                DocentesDAO daorh = new DocentesDAOimpl();
                List<Docentes> listarh = daorh.getAll_docente_area(area);
                request.setAttribute("docente", listarh);
                EstudiantesDAO daogrh = new EstudiantesDAOimpl();
                List<Estudiantes> listagrh = daogrh.getAll_estudiante_area(area);
                request.setAttribute("estudiante", listagrh);                
                request.getRequestDispatcher("estudiantes.jsp").forward(request, response);
                    break;
                case "docentes":
                total_docentes_tareas = daodocentes.docentes_totales_areas(area);
                total_estudiantes_tareas = daoestudiantes.estudiantes_totales_areas(area);
                System.out.println("TOTAL_DOCENTES:"+total_docentes_tareas);
                System.out.println("TOTAL_DOCENTES:"+total_estudiantes_tareas);
                request.setAttribute("total_docentes_area", total_docentes_tareas);
                request.setAttribute("total_estudiantes_area", total_estudiantes_tareas);
                
                DocentesDAO daom = new DocentesDAOimpl();
                List<Docentes> listam = daom.getAll_docente_area(area);
                request.setAttribute("docente", listam);
                EstudiantesDAO daogm = new EstudiantesDAOimpl();
                List<Estudiantes> listagm = daogm.getAll_estudiante_area(area);
                request.setAttribute("estudiante", listagm);                
                request.getRequestDispatcher("docentes.jsp").forward(request, response);
                    break;
                default:

                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
