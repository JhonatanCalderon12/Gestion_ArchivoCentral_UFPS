<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="modelo.*, dao.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Control de posiciones</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Gestion de posiciones</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Posiciones </a></li>
			</ul>
		</nav>
	</header>

	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">


				<form action="actualizarPosiciones" method="POST">



					<c:if test="${posiciones!=null}">
						<input type="hidden" name="id"
							value="<c:out value='${posiciones.id}'/>" />
					</c:if>

					<div class="form-group">
						<label for="inputName">Columna</label> <select
							class="form-control" name="nameColumnaPosicion">
							<option>Seleccione la columna</option>
							<option>1</option>
							<option>2</option>
						</select>
					</div>

					<fieldset class="form-group">
						<label> Estado</label> <input type="text" class="form-control"
							name="estado" required="required" />
					</fieldset>

					<div class="form-group">
						<label for="inputDescription">Fila</label> <select
							class="form-control" name="nameFilaPosicion">
							<option>Seleccione la Fila</option>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
						</select>
					</div>

					<div class="form-group">
						<label for="inputBloque">Estante</label> <select
							class="form-control" name="nameSelectEstantes">
							<option>Seleccione el estante</option>
							<%
								EstanteDao estDao = new EstanteDao();
							List<Estante> estantes = null;

							estantes = estDao.selectAll();
							for (Estante e : estantes) {
								out.print("<option name=estante style='color: black;' > " + e.getNumero() + "</option>");
							}
							%>
						</select>
					</div>

					<button type="submit" class="btn btn-success">Actualizar</button>
				</form>
			</div>
		</div>
	</div>


</body>
</html>