
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("listaper") == null){
                ArrayList<Persona> lista = new ArrayList<Persona> ();
                lista.add(new Persona(1,"Freddy Condori","72012354", "freddycondo@gmail.com"));
                lista.add(new Persona(2,"german siñani","75241896", "germansiña@gmail.com"));
                lista.add(new Persona(3,"rocio Condori","72012354", "freddycondo@gmail.com"));
                
                session.setAttribute("listaper", lista);
             }
            %>
            <h1>ejemplo de jstl core</h1>
            <ul>
                <li><a href="jstl_if.jsp">ejemplo if</a></li>
                <li><a href="jstl_choose.jsp">probando el choose</a></li>
                <li><a href="jstl_foreach.jsp">recoriendo la coleccion de forEach</a></li>
            </ul>
    </body>
</html>
