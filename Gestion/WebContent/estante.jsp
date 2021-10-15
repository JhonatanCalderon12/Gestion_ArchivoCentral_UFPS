<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="modelo.*, dao.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Control de bloques</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestion de Estantes</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listarEstantes"
					class="nav-link"> Estantes </a></li>
			</ul>
		</nav>
	</header>

	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${estantes!=null}">
					<form action="actualizarEstante" method="post">
				</c:if>

				<c:if test="${estantes == null}">
					<form action="insertarEstante" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${estantes!=null}">
						Editar estante
			</c:if>
						<c:if test="${estantes==null}">
						Insertar estante
			</c:if>
					</h2>
				</caption>

		<c:if test="${estantes!=null}">
			<input type="hidden" name="id" value="<c:out value='${estantes.id}'/>"/> 
			</c:if>
			
			<fieldset class="form-group">
			<label> Numero de estante </label> <input type="number" value="<c:out value='${estantes.numero}'/>" class="form-control" name="inputNEstante"/>
			</fieldset>
			
			
			<fieldset class="form-group">
			<label> Tipo de Estante </label> 
			<select type="number" value="<c:out value='${estantes.filas}'/>" class="form-control" name="selectTipoEstante">
			<option value="1" >Pequeño</option>
			<option value="2"> Grande</option>
			</select>
			</fieldset>
			
			<fieldset class="form-group">
			<label> Filas </label> 
			<select type="number" value="<c:out value='${estantes.filas}'/>" class="form-control" name="selectFilaEstante">
			<option>5</option>
			<option>6</option>
			</select>
			</fieldset>
			
			
			
			<div class="form-group">
                  <label for="inputBloque">Bloque</label>
                  <select class="form-control" name="cboBlock">
								<option>Seleccione el bloque</option>
								<%
								BloqueDao dao = new BloqueDao();
								List<Bloque> block = null;

								block = dao.selectAll();
							    for (Bloque b : block) {
									out.print("<option name=bloque style='color: black;' > " + b.getLetra() + "</option>");
								}
								%>
						</select>
                </div>
			
						
			<button type="submit" class="btn btn-success"> Guardar </button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>