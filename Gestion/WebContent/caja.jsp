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
<title>Insert title here</title>
</head>
<body>
	<div class="container">


		<h3 style="text-align: center">Registro de Caja</h3>

		<form action="registrarCaja.jsp" class="form-group">

			<button type="submit" class="btn btn-success">Registrar Caja</button>

		</form>


		<form action="listarCajas">
			<div class="row">
				<div class="col-sm-12">
					<!-- text input -->
					<fieldset class="form-group">
						<label for="inputBloque">Estante</label> <select
							class="form-control" name="nameSelectEstantes">

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



			<table class="table table-striped table-bordered table-hover">
				<tbody>

					<tr>
						<th class="col-sm-2">Fila</th>
						<th>Cajas</th>
					</tr>

					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=1 name="nameFil"
											placeholder="Fila1" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasUno" items="${listaCaja}">

							<td><c:out value="${cajasUno.numeroCaja}" /></td>

						</c:forEach>
					</tr>
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=2 name="nameFil"
											placeholder="Fila2" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasDos" items="${listaCaja}">

							<td><c:out value="${cajasDos.numeroCaja}" /></td>

						</c:forEach>
					</tr>
					
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=3 name="nameFil"
											placeholder="Fila3" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasTres" items="${listaCaja}">

							<td><c:out value="${cajasTres.numeroCaja}" /></td>

						</c:forEach>
					</tr>
					
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=4 name="nameFil"
											placeholder="Fila4" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasCuatro" items="${listaCaja}">

							<td><c:out value="${cajasCuatro.numeroCaja}" /></td>

						</c:forEach>
					</tr>
					
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=5 name="nameFila"
											placeholder="Fila5" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasCinco" items="${listaCaja}">

							<td><c:out value="${cajasCinco.numeroCaja}" /></td>

						</c:forEach>
					</tr>
					
					<tr>
						<td>
							<div class="row">
								<div class="col-sm-5">
									<!-- text input -->
									<fieldset class="form-group">
										<input class="form-control" value=6 name="nameFil"
											placeholder="Fila6" readonly="readonly">
									</fieldset>
								</div>
							</div>
						</td>
						<c:forEach var="cajasSeis" items="${listaCaja}">

							<td><c:out value="${cajasSeis.numeroCaja}" /></td>

						</c:forEach>
					</tr>
				</tbody>
			</table>

			<button type="submit">ACTUALIZAR DATOS</button>
		</form>

	</div>
</body>
</html>