
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>     
        <h1>Roles</h1>
        <p><a href="MainController?action=add">Nuevo</a></p>   
        <table border="2">
            <tr>
                <th>id</th>
                <th>descripcion</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${roles}">
            <tr>
                <th>${item.id}</th>
                <th>${item.descripcion}</th>
                <th><a href="MainController?action=edit&id=${item.id}">editar</a></th>
                <th><a href="MainController?action=delete&id=${item.id}">eliminar</a></th>
            </tr>
            </c:forEach>
        </table>        
    </body>
</html>
