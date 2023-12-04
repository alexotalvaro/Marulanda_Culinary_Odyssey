<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Plato, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administración</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<style>
a {
	color: black;
}
</style>
</head>
<body>

	<%
		List<Plato> listaPlatos = (List<Plato>) request.getAttribute("listaPlatos");
	%>


	<div class="mb-4 border m-3 p-3">
		<p>
		<h2>Introducir Plato en el menu</h2>
		</p>



		<form action="<%=request.getContextPath()%>/InsertarPlato"
			method="post">
			<div class="form-group row">
				<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="nombre" name="nombre"
						placeholder="nombre">
				</div>
			</div>
			<div class="form-group row">
				<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="descripcion"
						name="descripcion" placeholder="descripción">
				</div>
			</div>
			<div class="form-group row">
				<label for="precio" class="col-sm-2 col-form-label">Precio</label>
				<div class="col-sm-2">
					<input type="number" class="form-control" id="precio" name="precio"
						placeholder="precio" step="0.01">
				</div>
			</div>
			<div class="form-group row">
				<label for="origen" class="col-sm-2 col-form-label">Origen</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="origen" name="origen"
						placeholder="origen">
				</div>
			</div>
			<div class="form-group row">
				<label for="origen" class="col-sm-2 col-form-label">Imagen</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="imagen" name="imagen"
						placeholder="imagen">
				</div>
			</div>
			<fieldset class="form-group">
				<div class="row">
					<legend class="col-form-label col-sm-2 pt-0">Localización</legend>
					<div class="col-sm-10">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="opcion"
								id="nacional" value="nacional"> <label
								class="form-check-label" for="nacional"> Nacional </label>
						</div>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="opcion"
								id="internacional" value="internacional"> <label
								class="form-check-label" for="internacional">
								Internacional </label>
						</div>
					</div>
				</div>
			</fieldset>
			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Crear</button>
				</div>
			</div>
		</form>
	</div>
	<div>
		<table class="table table-bordered table-dark text-center">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Origen</th>
					<th>Baja</th>
					<th>Editar</th>
					<th>Dar de baja</th>
				</tr>
			</thead>
			<%
				for (Plato plato : listaPlatos) {
			%>
			<tbody>
				<tr>
					<td><%=plato.getNombre()%></td>
					<td><%=plato.getDescripcion()%></td>
					<td><%=plato.getPrecio()%></td>
					<td><%=plato.getOrigen()%></td>
					<td><%=plato.isBaja()%></td>
					<td><a href="<%=request.getContextPath()%>/EditarPlato?id=<%=plato.getId()%>"><i class="fa fa-pencil"></i></a></td>
					<td><a href="<%=request.getContextPath()%>/AltaOBaja?id=<%=plato.getId()%>"><i class="fa fa-sort"></i></a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>

</body>
</html>