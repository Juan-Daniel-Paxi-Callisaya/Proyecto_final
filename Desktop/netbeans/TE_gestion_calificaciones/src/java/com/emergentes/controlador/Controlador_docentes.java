package com.emergentes.controlador;

import com.emergentes.dao.DocentesDAO;
import com.emergentes.dao.DocentesDAOimpl;
import com.emergentes.modelo.Docentes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador_docentes", urlPatterns = {"/Controlador_docentes"})
public class Controlador_docentes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {            
            DocentesDAO dao = new DocentesDAOimpl();
            Docentes docente = new Docentes();
            int id;
            HttpSession ses = request.getSession();                     
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            String area = request.getParameter("area_docente");
            switch(action){
                case "add":                  
                  
                System.out.println("Adicionando");
                
                String descripcion = request.getParameter("descripcion_docente");
                String area_docente = request.getParameter("area_docente");               
                Double monto = Double.parseDouble(request.getParameter("monto_docente"));                

                System.out.println("SESION:"+ses.getAttribute("cod_usuario"));
                String usu = String.valueOf(ses.getAttribute("cod_usuario"));
                
                int usuario = Integer.parseInt(usu);
                
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fe = request.getParameter("fecha_docente");
                 
                Date fecha;
                
                java.util.Date nfecha = null;
                try {
                    nfecha = formato.parse(fe);
                } catch (ParseException ex) {
                    Logger.getLogger(Controlador_docentes.class.getName()).log(Level.SEVERE, null, ex);
                }
        
                fecha = new java.sql.Date(nfecha.getTime());
                
                Docentes ing = new Docentes();
                ing.setDescripcion(descripcion);
                ing.setArea(area_docente);
                ing.setMonto(monto);
                ing.setFecha(fecha);
                ing.setUsuario(usuario);
                
                System.out.println("aqui"+descripcion);
                System.out.println("aqui"+area_docente);
                System.out.println("aqui"+fecha);
                System.out.println("aqui"+usuario);
                System.out.println("aqui"+monto);
            try {                
                dao.insert_docente(ing);
                System.out.println("Registrado exitosamente");
                System.out.println("LA RUTA     Controlador_estados?action="+area);
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
                System.out.println("Cod_usu: "+usuario);
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);
            }                    
                    request.setAttribute("docente", docente);
                    request.getRequestDispatcher("Controlador_docentes").forward(request, response);
                    break;
                case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                Docentes docente_buscado = new Docentes();
                docente_buscado = dao.getId_docente(id);
                request.setAttribute("docente_buscado", docente_buscado);
                request.getRequestDispatcher("modifica_informacion.jsp").forward(request, response);                                
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete_docente(id);
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
                Docentes docente = new Docentes();
                DocentesDAO dao = new DocentesDAOimpl();
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
                                               
                docente.setCod_docente(id);
                docente.setDescripcion(descripcion_nuevo);
                docente.setMonto(monto_nuevo);
                docente.setFecha(fecha_nuevo);
                System.out.println("POST:"+id);
                System.out.println("POST:"+descripcion_nuevo);
                System.out.println("POST:"+fecha_nuevo);
                System.out.println("POST:"+monto_nuevo);
                System.out.println("URL URL Controlador_estados?action="+area+"&area="+area );
                dao.update_docente(docente);
                //request.getRequestDispatcher("Controlador_estados?action="+area+"&area="+area).forward(request, response);
                response.sendRedirect("Controlador_estados?action="+area+"&area="+area);
                
        } catch (Exception e) {                
                response.sendRedirect("modifica_informacion.jsp");
        }                                                                    
    }
}
