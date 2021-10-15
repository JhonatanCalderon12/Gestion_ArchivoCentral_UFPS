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
				<a href="#" class="navbar-brand"> Gestion de bloques</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Bloques </a></li>
			</ul>
		</nav>
	</header>
	
	<br />

	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Bloques</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/nuevo" class="btn btn-success">
					Agregar nuevos bloques</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Letra</th>
						<th>Ubicacion</th>
					</tr>
				</thead>
				<tbody>
				<!-- for(Todos todo: todos){ -->
				<c:forEach var="bloques" items="${lista}">
					<tr>
						<td><c:out value="${bloques.id}" /></td>

						<td><c:out value="${bloques.letra }" /></td>

						<td><c:out value="${bloques.ubicacion }" /></td>

						<td><a href="editar?id=<c:out value='${bloques.id }'/>">
								Editar </a> &nbsp;&nbsp;&nbsp;&nbsp; <a
							href="eliminar?id=<c:out value='${bloques.id}'/>">
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