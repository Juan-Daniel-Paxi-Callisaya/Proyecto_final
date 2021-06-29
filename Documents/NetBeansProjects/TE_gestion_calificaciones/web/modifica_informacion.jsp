<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="cabecera.jsp" %>

<section class="container">
	<div class="centrar"><h1>Modificar Informacion</h1></div>	
	<hr>	
<%@include file="opciones.jsp" %>
<!--<input name="area" type="hidden" value="finanzas" />-->
	<div class="col-md-offset-2 col-md-5">
		<h3>Modificar</h3>
		<form action="Controlador_docentes" method="post">
                <input type="hidden" name="area" value="${docente_buscado.area}" />
                <input type="hidden" name="id" value="${docente_buscado.cod_docente}" />
                
		<label for="descripcion">Descripcion:</label>
                <input type="text" name="descripcion" class="form-control" value="${docente_buscado.descripcion}">
		<label for="monto">Monto:</label>
                <input type="number" name="monto" class="form-control" value="${docente_buscado.monto}" >
		<label for="fecha">Fecha:</label>		
                <input type="date" name="fecha" class="form-control" value="${docente_buscado.fecha}" > <br>
		<input type="submit" value="Registrar" class="btn btn-primary"><br>
		</form>		
	</div>			
</section><br><br><br><br><br>

<%@ include file="piedepagina.jsp" %>

