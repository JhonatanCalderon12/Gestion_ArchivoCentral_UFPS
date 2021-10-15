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
				<a href="#" class="navbar-brand"> Gestion de legajos</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listarEstantes"
					class="nav-link"> legajos </a></li>
			</ul>
		</nav>
	</header>

	<div class="container col-md-5">

		<div class="card">
			<div class="card-body">

				<c:if test="${legajos!=null}">
					<form action="actualizarEstante" method="post">
				</c:if>

				<c:if test="${legajos == null}">
					<form action="insertarLegajo" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${legajos!=null}">
						Editar legajo
			</c:if>
						<c:if test="${legajos==null}">
						Insertar legajo
			</c:if>
					</h2>
				</caption>

		<c:if test="${legajos!=null}">
			<input type="hidden" name="id" value="<c:out value='${legajos.id}'/>"/> 
			</c:if>
                
                <div class="form-group">
                  <label for="inputBloque">Caja</label>
                  <select class="form-control" name="nameSelectCajas">
								<option>Seleccione la caja</option>
								<%
								CajaDao cjdao = new CajaDao();
								List<Caja> cajas = null;

								cajas = cjdao.selectAll();
							    for (Caja c : cajas) {
							    	
							    	%>
							    	
							    	<option value=" <%= c.getIdCaja() %> "> <%=c.getNumeroCaja() +  "-" + c.getDependencia() + "-" + c.getSerie() + "-" + c.getSubserie() %> </option>
							    	
							    	<%
							    }
							    	%>
						</select>
                </div>
			
			<fieldset class="form-group">
			<label> Numero de legajo </label> <input type="number" value="<c:out value='${legajo.numeroLegajo}'/>" class="form-control" name="nameNumeroLegajo"/>
			</fieldset>
			
			<fieldset class="form-group">
			<label> Expediente </label> <input type="text" value="<c:out value='${legajo.expediente}'/>" class="form-control" name="nameExpediente"/>
			</fieldset>
			
			<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<fieldset class="form-group">
							<label for="fechaInicio">Fechas Extremas - Desde:</label> <input
								class="form-control" type="date" id="fechaDesde"
								name="nameFechaDesde">
						</fieldset>
					</div>
					<div class="col-sm-6">
						<fieldset class="form-group">
							<label for="fechaInicio">Fechas Extremas - Hasta:</label> <input
								class="form-control" type="date" id="fechaHasta"
								name="nameFechaHasta">
						</fieldset>
					</div>
				</div>
				
				<fieldset class="form-group">
			<label> Total folios </label> <input type="number" value="<c:out value='${legajo.folios}'/>" class="form-control" name="nameTotalFolios"/>
			</fieldset>
			
						
			<button type="submit" class="btn btn-success"> Insertar Legajo </button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>