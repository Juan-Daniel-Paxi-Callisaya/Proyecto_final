
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${roles.id == 0}" >nuevo</c:if>
            <c:if test="${roles.id != 0}" >editar</c:if>
            registro
        </h1>
        <form action="MainController" method="post">
            <input type="hidden" name="id" value="${roles.id}" />
            <label>Descripcion:</label>
            <input type="text" name="descripcion" value="${roles.descripcion}"/> 
            <br>
            <td><input type="submit" value="enviar"/>
        </form>
    </body>
</html>
