<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Plato, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/css/estilos.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Pacifico&family=Varela+Round&display=swap"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
</head>
<body>
	<%
		Plato plato = (Plato) request.getAttribute("platoSeleccionado");
	%>
	<header class="header border"><%@ include
			file="fragments/header.jsp"%></header>
	<div class="gradient-background ">
		<div class="d-flex justify-content-center">
			<div class="cajaEnlaces">
				<a class="enlaces"
					href="<%=request.getContextPath()%>/Origen?origen=nacional">Platos
					Nacionales</a>
			</div>

			<div class="cajaEnlaces">
				<a class="enlaces"
					href="<%=request.getContextPath()%>/Origen?origen=internacional">Platos
					Internacionales</a>
			</div>

		</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-4 col-sm-6 mb-4 text-center">
					<div class="card ">
						<a href="<%=plato.getImagen()%>" target="target_blank"> <img
							class="img-fluid img-thumbnail" src="<%=plato.getImagen()%>"
							name="imagen" alt="plato" style="width: 249px; height: 249px"></a>
						<div class="card-body pb-3">
							<h5 class="card-title" name="nombre"><%=plato.getNombre()%></h5>
							<p class="card-text" name="descripcion"><%=plato.getDescripcion()%></p>
							<p class="card-text" name="origen">
								Origen:
								<%=plato.getOrigen()%></p>
							<p class="card-text" name="precio"><%=plato.getPrecio()%>&#0128;
							</p>
						</div>
					</div>
					<a href="<%=request.getContextPath()%>"><button type="button"
							class="btn btn-warning">Volver</button></a>
				</div>
			</div>
		</div>
		<footer><%@ include file="fragments/footer.jsp"%></footer>
	</div>
</body>
</html>