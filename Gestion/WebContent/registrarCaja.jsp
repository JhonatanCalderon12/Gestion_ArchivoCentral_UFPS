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

				<c:if test="${cajas!=null}">
					<form action="actualizarCaja" method="post">
				</c:if>

				<c:if test="${cajas == null}">
					<form action="insertarCaja" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${cajas!=null}">
						Editar cajas
			</c:if>
						<c:if test="${cajas==null}">
						Insertar cajas
			</c:if>
					</h2>
				</caption>


				<c:if test="${cajas!=null}">
					<input type="hidden" name="id" value="<c:out value='${cajas.id}'/>" />
				</c:if>

				<div class="form-group">
					<label>Seleccionar Dependencia</label> <select class="form-control"
						name="nameNombreDependencia">
						<option>Seleccione dependencia</option>
						<%
							DependenciaDao dao = new DependenciaDao();
						List<Dependencia> dependencias = null;
						dependencias = dao.selectAll();

						for (Dependencia d : dependencias) {
							out.print("<option style='color: black;' > " + d.getNombre() + "</option>");
						}
						%>
					</select>
					<div>
						<p></p>
						<!-- Espacio Vacío entre el formulario -->
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<label>Serie:</label> <select class="form-control"
									name="nameNombreSerie">
									<option>Seleccione Serie</option>
									<%
										SerieDao serieDAO = new SerieDao();
									List<Serie> series = null;
									series = serieDAO.selectAll();

									for (Serie s : series) {
										out.print("<option style='color: black;' > " + s.getNombre() + "</option>");
									}
									%>
								</select>
							</div>
						</div>

						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<label>SubSerie:</label> <select class="form-control"
									name="nameNombreSubSerie">
									<option>Seleccione SubSerie</option>
									<%
										SubSerieDao subDAO = new SubSerieDao();
									List<SubSerie> subseries = null;
									subseries = subDAO.selectAll();
									for (SubSerie sub : subseries) {
										out.print("<option style='color: black;' > " + sub.getNombre() + "</option>");
									}
									%>
								</select>
							</div>
						</div>
					</div>

				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>Caja Nº:</label> <input
								th:errorclass="'form-control alert-danger'" name="nCaja"
								type="text" class="form-control" placeholder="">
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Nº Legajos:</label> <input
								th:errorclass="'form-control alert-danger'" name="nLegajos"
								type="number" class="form-control" placeholder="">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<fieldset class="form-group">
							<label for="fechaInicio">Fechas Extremas - Desde:</label> <input
								class="form-control" type="date" id="fechaDesde"
								name="fechaDesde">
						</fieldset>
					</div>
					<div class="col-sm-6">
						<fieldset class="form-group">
							<label for="fechaInicio">Fechas Extremas - Hasta:</label> <input
								class="form-control" type="date" id="fechaHasta"
								name="fechaHasta">
						</fieldset>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<!-- text input -->
						<fieldset class="form-group">
							<label for="inputBloque">Estante</label> <select
								class="form-control" name="nameSelectEstantes">
								<option>Seleccionar Estante</option>
								<%
									EstanteDao estDao = new EstanteDao();
								List<Estante> estantes = null;

								estantes = estDao.selectAll();
								for (Estante e : estantes) {
									out.print("<option name=estante style='color: black;' > " + e.getNumero() + "</option>");
								}
								%>
							</select>
						</fieldset>
					</div>
				</div>
				
					<div class="row">
						<div class="col-sm-12">
							<!-- text input -->
							<fieldset class="form-group">
								<label>Fila</label> <select class="form-control"
									name="nameSelectFilas">
									<option>Seleccionar Fila</option>
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
									<option>6</option>
									
								</select>
							</fieldset>
						</div>
					</div>
				

				<div class="row">
					<div class="col-sm-10">
						<!-- text input -->
						<fieldset class="form-group">
							<label> Retención</label> <input type="text"
								value="<c:out value='${cajas.retencion}'/>" class="form-control"
								name="nameRetencion"  />
						</fieldset>

						<fieldset class="form-group">
							<label>Observaciones:</label>
							<textarea class="form-control" name="nameObservaciones" rows="3"
								placeholder="Escriba aqui las Observaciones"></textarea>
						</fieldset>
					</div>

					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>Seleccionar Tamaño</label> <select class="form-control"
								name="nameTamanio">
								<option value="1">CAJA PEQUEÑA</option>
								<option value="1.5">CAJA GRANDE</option>
							</select>
						</div>
					</div>

				</div>
			</div>

			<button type="submit" class="btn btn-success">Registrar</button>
			</form>
		</div>
	</div>
	</div>


</body>
</html>