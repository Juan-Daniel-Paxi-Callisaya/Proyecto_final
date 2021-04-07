<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ejemplo del choose</h1>
        <p>para visualizar el texto condicionales necesita agregar un parametro en
            la barra de direcciones con valores A, S, I ej.: ?estado=A</p>
        <c:choose>
            <c:when test="${param.estado == 'A'}">
                <h4 style='color:blue'>Activo</h4>
            </c:when>
            <c:when test="${param.estado == 'S'}">
                <h4 style='color:red'>Suspendido</h4>
            </c:when>
            <c:when test="${param.estado == 'I'}">
                <h4 style='color:green'>inactivo</h4>
            </c:when>
            <c:otherwise>
                <p>***sin estado***</p>
            </c:otherwise>
        </c:choose>
        <a href="index.jsp">volver</a>
    </body>

</html>
