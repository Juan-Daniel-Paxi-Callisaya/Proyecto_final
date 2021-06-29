package com.emergentes.controlador;

import com.emergentes.dao.EstudiantesDAO;
import com.emergentes.dao.EstudiantesDAOimpl;
import com.emergentes.dao.DocentesDAO;
import com.emergentes.dao.DocentesDAOimpl;
import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOimpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador_usuarios", urlPatterns = {"/Controlador_usuarios"})
public class Controlador_usuarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {            
            UsuariosDAO dao = new UsuariosDAOimpl();                                   
            Usuarios usu = new Usuarios();
            int id;
            String action = (request.getParameter("action")!=null) ? request.getParameter("action") : "view";
            
            DocentesDAO daodocentes = new DocentesDAOimpl();
            EstudiantesDAO daoestudiantes = new EstudiantesDAOimpl();
            double total_docentes = 0.0;
            double total_estudiantes = 0.0;
            
            switch(action){
                case "add":
                    request.setAttribute("usuario", usu);
                    request.getRequestDispatcher("registrarse.jsp").forward(request, response);
                    break;
                case "edit":

                    Usuarios usuario_validado1 = new Usuarios();
                    HttpSession sesion1 = request.getSession();
        try {

                int cod = Integer.parseInt(request.getParameter("cod"));
                String propietario = request.getParameter("propietario");
                String colegio = request.getParameter("colegio");
                String email = request.getParameter("email");
                String contrasena = request.getParameter("contrasena");                
                
                usuario_validado1.setCod_usuario(cod);
                usuario_validado1.setPropietario(propietario);
                usuario_validado1.setColegio(colegio);
                usuario_validado1.setEmail(email);
                usuario_validado1.setPassword(contrasena);
                
                dao.update_usuario(usuario_validado1);
                
                sesion1.setAttribute("login", "OK");
                sesion1.setAttribute("cod_usuario", usuario_validado1.getCod_usuario());
                sesion1.setAttribute("propietario", usuario_validado1.getPropietario());
                sesion1.setAttribute("colegio", usuario_validado1.getColegio());
                sesion1.setAttribute("email", usuario_validado1.getEmail());
                sesion1.setAttribute("password", usuario_validado1.getPassword());
                sesion1.setAttribute("confirmacion", "conf_si");
                response.sendRedirect("configuracion.jsp");
        } catch (Exception e) {
                sesion1.setAttribute("error", "NoEncontrado");
                response.sendRedirect("configuracion.jsp");
        }                    
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("cod"));
                    dao.delete_usuario(id);
                    response.sendRedirect("Controlador_usuarios");
                    break;
                case "inicio":
                DocentesDAO daodocentes_inicio = new DocentesDAOimpl();
                EstudiantesDAO daoestudiantes_inicio = new EstudiantesDAOimpl();
                double total_docentes_inicio = 0.0;
                double total_estudiantes_inicio = 0.0;                    
                total_docentes_inicio = daodocentes_inicio.docentes_totales();
                request.setAttribute("total_docentes", total_docentes_inicio);
                
                total_estudiantes_inicio = daoestudiantes_inicio.estudiantes_totales();
                request.setAttribute("total_estudiantes", total_estudiantes_inicio);                
                
                request.getRequestDispatcher("inicio_admin.jsp").forward(request, response);                    
                    break;
                case "cerrar_sesion":
                    HttpSession ses = request.getSession();
                    String login = (String) ses.getAttribute("login");
                    if (login.equals("OK")) {
                        ses.invalidate();
                        response.sendRedirect("inicio.jsp");
                    }                    
                    break;
                //case "configurar":
                    
                  //  break;
                case "inicio_sesion":
                    String email = request.getParameter("email");
                    String contrasena = request.getParameter("contrasena");                                                                  
                    Usuarios usuario_validado = new Usuarios();
                    HttpSession sesion = request.getSession();
        try {
            usuario_validado = dao.getId_usuario(email, contrasena);
            if (usuario_validado.getEmail().equals(email) && usuario_validado.getPassword().equals(contrasena)){
                System.out.println("Usuario validado");
                System.out.println("VAriable email"+email);
                System.out.println("Varialbe contraseña"+contrasena);
                
                sesion.setAttribute("login", "OK");
                sesion.setAttribute("cod_usuario", usuario_validado.getCod_usuario());
                sesion.setAttribute("propietario", usuario_validado.getPropietario());
                sesion.setAttribute("colegio", usuario_validado.getColegio());
                sesion.setAttribute("email", usuario_validado.getEmail());
                sesion.setAttribute("password", usuario_validado.getPassword());
                
                System.out.println("SESION"+sesion.getAttribute("login"));
                System.out.println("SESION"+sesion.getAttribute("cod_usuario"));
                System.out.println("SESION"+sesion.getAttribute("propietario"));
                System.out.println("SESION"+sesion.getAttribute("colegio"));
                System.out.println("SESION"+sesion.getAttribute("email"));
                System.out.println("SESION"+sesion.getAttribute("password"));

                
                total_docentes = daodocentes.docentes_totales();
                total_estudiantes = daoestudiantes.estudiantes_totales();
                request.setAttribute("total_estudiantes", total_estudiantes);
                request.setAttribute("total_docentes", total_docentes); 
                
                System.out.println("total_docentes:"+total_docentes);
                System.out.println("total_estudiantes:"+total_estudiantes);
                System.out.println("ENVIADO");
                
                request.getRequestDispatcher("inicio_admin.jsp").forward(request, response);
            }
        } catch (Exception e) {
                sesion.setAttribute("error", "NoEncontrado");
                System.out.println("NO ENVIADO");
                response.sendRedirect("inicio.jsp");
        }
                    break;
                default:

                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                    break;
                
            }
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuariosDAO dao = new UsuariosDAOimpl();
        //int id = Integer.parseInt(request.getParameter("cod"));  
        String propietario = request.getParameter("propietario");
        String colegio = request.getParameter("colegio");
        String email = request.getParameter("email");
        String contraseña = request.getParameter("contrasena");        
        Usuarios usu = new Usuarios();
        HttpSession sesion = request.getSession();                
        usu.setPropietario(propietario);
        usu.setColegio(colegio);
        usu.setEmail(email);
        usu.setPassword(contraseña);        
            try {
                dao.insert_usuario(usu);                
                sesion.setAttribute("creado", "registrado");
                response.sendRedirect("registrarse.jsp");
            } catch (Exception e) {
                System.out.println("error"+ e.getMessage());
                sesion.setAttribute("creado", "fallo");
            }

    }   
}
