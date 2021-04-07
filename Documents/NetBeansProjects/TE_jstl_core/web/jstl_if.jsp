
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Mostrar sectores de forma condicional</h1>
        <p>para visualizar el texto condicionales necesita agregar un parametro en la barra de dorecciones
        ejemplo: ?login = ok </p>
        <c:if test="${param.login == 'ok'}" var="resultado" scope="request">
        <h3 style="color:red">ete texto solo se muestra se el parametro enviodo es ok</h3>
        </c:if>
        <a href="index.jsp">volver</a>
    </body>
</html>
