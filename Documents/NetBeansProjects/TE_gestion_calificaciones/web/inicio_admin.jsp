<%
    if (session.getAttribute("login")!= "OK") {
        response.sendRedirect("inicio.jsp");
        System.out.println("INICIO_ADMIN OK CON SESION");
    }
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="cabecera.jsp" %>


<section class="container">
	<div class="centrar"><h1>Bienvenido</h1></div>	
	<hr>	
<%@include file="opciones.jsp" %>
	<div class="centrar">
		<h4>Areas</h4>
		<p>
			<a style="width: 200px;" href="Controlador_estados?action=tareas&area=tareas" class="btn btn-primary">TAREAS</a><br><br>
			<a style="width: 200px;" href="Controlador_estados?action=recursos&area=recursos" class="btn btn-primary">ESTUDIANTES</a><br><br>
			<a style="width: 200px;" href="Controlador_estados?action=docentes&area=docentes" class="btn btn-primary">DOCENTES</a><br><br>
		</p>
	</div><hr>
	<div class="col-md-offset-3 col-md-9">
	<div class="estadisticas centrar">
		<div class="info_estadistica">
			<h1><strong>${total_docentes}</strong></h1>			
			<h3>Docentes Totales</h3>				                    
		</div>
		<div class="info_estadistica">
                        <h1><strong>${total_docentes - total_estudiantes}</strong></h1>
                        <div class="text_info">
			<h3>Tareas Actual</h3>
                        </div>
		</div>
		<div class="info_estadistica">
			<h1><strong>${total_estudiantes}</strong> </h1>
			<h3>Estudiantes Totales</h3>
		</div>
	</div>		
	</div>

</section><br><br><br><br><br>


<%@ include file="piedepagina.jsp" %>


