<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Editar Costo</title>
</head>
<body>

	<form class="login-form text-center" action="CRUDcosto" method="post">
		<h1 class="mb-5 font-weight-light text-uppercase">Formulario de
			edicion</h1>
		<div class="form-group">
			<label>Nombre</label> <input type="text" name="txtNombre"
				class="form-control rounded-pill form-control-lg"
				value="${tb_costo.getNombre()}">
		</div>
		<div class="form-group">
			<label>Valor</label> <input type="txt" name="txtValor"
				class="form-control rounded-pill form-control-lg"
				value="${tb_costo.getValor()}">
		</div>


		<button type="submit" name="accion" value="Actualizar"
			class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Actualizar</button>
		<a href="ShowTb_costo.jsp"
			class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-white bg-dark"
			role="button" aria-pressed="true">Ver Costos</a>






		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
			crossorigin="anonymous"></script>
		<script
			src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
			integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
			crossorigin="anonymous"></script>
	</form>

</body>
</html>