<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
 <link href="css/style.css" rel="stylesheet" type="text/css"/>

<meta charset="ISO-8859-1">

<title>Index</title>
</head>
<body>


 <div class="d-flex justify-content-center align-items-center login-container">
            <form class="login-form text-center" action="validarUsuario" method="post">
                <h1 class="mb-5 font-weight-light text-uppercase">Bienvenido</h1>
                <h1 class="mb-5 font-weight-light text-uppercase">Le Grand Rex Cinema</h1>
                <div class="form-group">
                    <input type="text" name="txtusuario"  class="form-control rounded-pill form-control-lg" placeholder="Usuario">
                </div>
                <div class="form-group">
                    <input type="password" name="txtpass"  class="form-control rounded-pill form-control-lg" placeholder="Contrase�a">
                </div>
                <div class="form-group">
                    <input type="txt" name="txttipo"  class="form-control rounded-pill form-control-lg" placeholder="admin,consulta,reporteria">
                </div>
               
                <button type="submit" name="accion" value="Ingresar" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Ingresar</button>
            </form>
        </div>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>