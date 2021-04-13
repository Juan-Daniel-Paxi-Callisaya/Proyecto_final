
<%@page import="com.emergentes.modelo.persona"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("listaper") == null) {
        ArrayList<persona> la = new ArrayList<persona>();
        session.setAttribute("listaper", la);
    }
    ArrayList<persona> lista = (ArrayList<persona>) session.getAttribute("listaper");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC Persona</title>
    </head>
    <body>
        <h1>Registro de vacunas</h1>
        <h2>Gestionar las vacunas suministradas a estudiantes de primaria</h2>
        <a href="MainServlet?op=nuevo">NUEVO</a>
        <br><br>
        <table border ="3">
            <tr>
                <th>id</th>
                <th>nombres</th>
                <th>peso</th>
                <th>talla</th>
                <th>vacuna</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                    for (persona item : lista) {
            %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombres()%></td>
                <td><%= item.getPeso()%></td>
                <td><%= item.getTalla()%></td>
                <td><%= item.getVacuna()%></td>
                <td><a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</td>
                <td><a href="MainServlet?op=eliminar&id=<%= item.getId()%>" onclick="return(confirm('esta seguro de eliminar??'))">eliminar</a></td>
            </tr>
            <%
                    }
                }
            %>

        </table>
    </body>
</html>
