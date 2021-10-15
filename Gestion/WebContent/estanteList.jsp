<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<nav class="navbar navbar-expand-md navbar-dark">
			<div>
				<a href="#" class="navbar-brand"> Gestion de Estantes</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listarEstantes"
					class="nav-link"> Estantes </a></li>
			</ul>
		</nav>
	</header>
	
	<br />

	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Estantes</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/nuevoEstante" class="btn btn-success">
					Agregar nuevos Estantes</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Columnas</th>
						<th>Filas</th>
						<th>Numero</th>
						<th>Bloque</th>
					</tr>
				</thead>
				<tbody>
				<!-- for(Todos todo: todos){ -->
				<c:forEach var="estantes" items="${listaEstantes}">
					<tr>
						<td><c:out value="${estantes.id}" /></td>

						<td><c:out value="${estantes.columnas}" /></td>

						<td><c:out value="${estantes.filas}" /></td>
						
						<td><c:out value="${estantes.numero}" /></td>
						
						<td><c:out value="${estantes.bloque}" /></td>

						<td><a href="editarEstante?id=<c:out value='${estantes.id }'/>">
								Editar </a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="eliminarEstante?id=<c:out value='${estantes.id}'/>">
								Eliminar </a></td>
					</tr>
				</c:forEach>
				<!-- } -->
				</tbody>
				
			</table>

		</div>
	</div>
				
</body>
</html>