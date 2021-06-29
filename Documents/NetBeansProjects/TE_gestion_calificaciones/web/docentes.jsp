<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="cabecera.jsp" %>

<section class="container">
	<div class="centrar"><h1>DOCENTES</h1></div>	
	<hr>	
<%@include file="opciones.jsp" %>
<input name="area" type="hidden" value="docentes" />
	<div class="col-md-offset-1 col-md-5">
		<h3>Docente</h3>
		<form action="Controlador_docentes" method="get">
                <input type="hidden" name="area_docente" value="docentes" />
                <input type="hidden" name="action" value="add" />
		<label for="descripcion"></label>
		<input type="text" name="descripcion_docente" class="form-control" placeholder="Ingresar descripcion">
		<label for="monto"></label>
		<input type="number" name="monto_docente" class="form-control" placeholder="Ingresar cantidad">
		<label for="fecha"></label>		
		<input type="date" name="fecha_docente" class="form-control"> <br>
		<input type="submit" value="Registrar" class="btn btn-primary"><br>
		</form>		
	</div>
	<div class="col-md-offset-0 col-md-5">
		<h3>Estudiante</h3>
		<form action="Controlador_estudiantes" method="get">
                <input type="hidden" name="area_estudiante" value="docentes" />
                <input type="hidden" name="action2" value="add" />
		<label for="descripcion_estudiante"></label>
		<input type="text" name="descripcion_estudiante" class="form-control" placeholder="Ingresar descripcion">
		<label for="monto_estudiante"></label>
		<input type="number" name="monto_estudiante" class="form-control" placeholder="Ingresar cantidad">
		<label for="fecha_estudiante"></label>		
		<input type="date" name="fecha_estudiante" class="form-control"><br>
		<input type="submit" value="Registrar" class="btn btn-primary"><br>
		</form>		
	</div>	
	<div class="col-md-offset-3 col-md-9">	<br>
	<div class="estadisticas centrar">
		<div class="info_estadistica">
			<h1><strong>${total_docentes_area} </strong></h1>
			<h3>docentes totales</h3>
		</div>
		<div class="info_estadistica">
			<h1><strong>${total_docentes_area - total_estudiantes_area}</strong></h1>
			<div class="text_info">
			<h3>Tareas Actual</h3>	
			</div>			
		</div>
		<div class="info_estadistica">
			<h1><strong>${total_estudiantes_area} </strong> </h1>
			<h3>estudiantes totales</h3>
		</div>
	</div>		
	</div>
	<div class="container">
            <div class="col-md-6"><br>
		<div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                    <th>Descripcion</th>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                    <th></th>
                    </tr>
                    </thead>
		<tbody>
                    <c:forEach var="item_docente" items="${docente}">
                <tr>
		<td>${item_docente.descripcion}</td>
		<td>${item_docente.fecha}</td>
		<td>${item_docente.monto}</td>
		<td>
                    <a href="Controlador_docentes?action=edit&id=${item_docente.cod_docente}" style="color: #4000F6;">Modificar</a>&nbsp;&nbsp;
		<a href="Controlador_docentes?action=delete&area_docente=${item_docente.area}&id=${item_docente.cod_docente}" style="color: #4000F6;">Eliminar</a>
		</td>
		</tr>
                    </c:forEach>
		</tbody>
		</table>
		</div>
            </div>
                <div class="col-md-6"><br>
		<div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                    <th>Descripcion</th>
                    <th>Fecha</th>
                    <th>Cantidad</th>
                    <th></th>
                    </tr>
                    </thead>
		<tbody>
                    <c:forEach var="item_estudiante" items="${estudiante}">
                <tr>
		<td>${item_estudiante.descripcion}</td>
		<td>${item_estudiante.fecha}</td>
		<td>${item_estudiante.monto}</td>
		<td>
		<a href="Controlador_estudiantes?action2=edit&id=${item_estudiante.cod_estudiante}" style="color: #4000F6;">Modificar</a>&nbsp;&nbsp;
		<a href="Controlador_estudiantes?action2=delete&area_estudiante=${item_estudiante.area}&id=${item_estudiante.cod_estudiante}" style="color: #4000F6;">Eliminar</a>
		</td>
		</tr>
                    </c:forEach>
		</tbody>
		</table>
		</div>
            </div>            
	</div>
</section><br><br><br><br><br>

<%@ include file="piedepagina.jsp" %>

