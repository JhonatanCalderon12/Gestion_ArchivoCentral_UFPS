<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<a href="#" class="navbar-brand"> Gestion de bloques</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link"> Bloques </a></li>
			</ul>
		</nav>
	</header>

	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${bloques!=null}">
					<form action="actualizar" method="post">
				</c:if>

				<c:if test="${bloques == null}">
					<form action="insertar" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${bloques!=null}">
						Editar bloque
			</c:if>
						<c:if test="${bloques==null}">
						Insertar bloque
			</c:if>
					</h2>
				</caption>

		<c:if test="${bloques!=null}">
			<input type="hidden" name="id" value="<c:out value='${bloques.id}'/>"/> 
			</c:if>

			<fieldset class="form-group">
			<label> Letra</label> <input type="text" value="<c:out value='${bloques.letra}'/>" class="form-control" name="letra" required="required"/>
			</fieldset>
			
			<fieldset class="form-group">
			<label> Ubicacion</label> <select type="text" value="<c:out value='${bloques.ubicacion}'/>" class="form-control" name="ubicacion">
					<option>1 Piso</option>
					<option>2 Piso</option>
					<option>3 Piso</option>
			</select>
			</fieldset>
						
			<button type="submit" class="btn btn-success"> Guardar </button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>