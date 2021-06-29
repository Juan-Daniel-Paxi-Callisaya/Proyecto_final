
package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.modelo.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controlador_estudiantes", urlPatterns = {"/Controlador_estudiantes"})
public class Controlador_estudiantes extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
         try {                                    
            EstudiantesDAO dao = new EstudiantesDAOimpl();
            Estudiantes estudiantes = new Estudiantes();
            int id;
            HttpSession ses = request.getSession();                     
            String action = (request.getParameter("action2")!=null) ? request.getParameter("action2") : "view";
            String area = request.getParameter("area_estudiante");
            switch(action){
                case "add":                                    
                System.out.println("Adicionando");                
                String descripcion = request.getParameter("descripcion_estudiante");
                String area_docente = request.getParameter("area_estudiante");               
                Double monto = Double.parseDouble(request.getParameter("monto_estudiante"));                                
                System.out.println("SESION:"+ses.getAttribute("cod_usuario"));
                String usu = String.valueOf(ses.getAttribute("cod_usuario"));
                
                int usuario = Integer.parseInt(usu);
                
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fec = request.getParameter("fecha_gasto");
                 
                Date fecha;
                
                java.util.Date nfecha = null;
                try {
                    nfecha = formato.parse(fec);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador_docentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                fecha = new java.sql.Date(nfecha.getTime());
                
                Estudiantes est = new Estudiantes();
                est.setDescripcion(descripcion);
                est.setArea(area_docente);
                est.setMonto(monto);
                est.setFecha(fecha);
                est.setUsuario(usuario);                
            try {                
                dao.insert_estudiante(est);
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);
            }                    
            request.setAttribute("estudiantes", estudiantes);
            request.getRequestDispatcher("Controlador_estudiantes").forward(request, response);
                    break;
                case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                Estudiantes estudiante_buscado = new Estudiantes();
                estudiante_buscado = dao.getId_estudiante(id);
                request.setAttribute("estudiante_buscado", estudiante_buscado);
                request.getRequestDispatcher("modifica_informacion_estudiantes.jsp").forward(request, response);
                    break;                    
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete_estudiante(id);
                    response.sendRedirect("Controlador_estados?action="+area+"&area="+area);                    
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
        try {               
                System.out.println("MODIFICANDO");
                Estudiantes estudiante = new Estudiantes();
                EstudiantesDAO dao = new EstudiantesDAOimpl();
                int id = Integer.parseInt(request.getParameter("id"));
                String area = request.getParameter("area");
                String descripcion_nuevo = request.getParameter("descripcion");
                double monto_nuevo = Double.parseDouble(request.getParameter("monto"));
                
                SimpleDateFormat formato_nuevo = new SimpleDateFormat("yyyy-MM-dd");
                String fe_nuevo = request.getParameter("fecha");
                 
                Date fecha_nuevo;
                
                java.util.Date nfecha_nuevo = null;
                try {
                    nfecha_nuevo = formato_nuevo.parse(fe_nuevo);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador_docentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                fecha_nuevo = new java.sql.Date(nfecha_nuevo.getTime());
                                               
                estudiante.setCod_estudiante(id);
                estudiante.setDescripcion(descripcion_nuevo);
                estudiante.setMonto(monto_nuevo);
                estudiante.setFecha(fecha_nuevo);

                dao.update_estudiante(estudiante);
                
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);                
        } catch (Exception e) {                
                response.sendRedirect("modifica_informacion.jsp");
        }                                                                    
    }
}
