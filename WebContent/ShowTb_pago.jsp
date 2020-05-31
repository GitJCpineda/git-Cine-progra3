<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<meta charset="ISO-8859-1">
<title>Mostrar Tabla Pago</title>
</head>
<body>


<form class="login-form" action="CRUDTipoPago" method="post">
 
      <a href="AdminstradorMenu.jsp" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-white bg-dark" role="button" aria-pressed="true">Menu anterior</a>
      <button type="submit" name="accion" value="Listar Pago" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Listar</button>
      <button type="submit" name="accion" value="Agregar Pago" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Nuevo</button>
      </form>
      
    
     <div class="table-responsive">
      
       <table class="table table-striped table-bordered table-hover table-condensed">
       
       <tr>
         <th>ID</th>
         <th>Nombre </th>
         <th>Descripcion</th>
         <th>Acciones</th>
       </tr>
       
       <tbody>
       <c:forEach var="dato" items="${datos}">
       <tr>
       <td>${dato.getId_Tipo_Pago()}</td>
       <td>${dato.getNombre_Tipo_Pago()}</td>
       <td>${dato.getDescripcion()}</td>
       <td>
        <form action="CRUDTipoPago" method="post">
            <input type="hidden" name="id_Tipo_Pago" value="${dato.getId_Tipo_Pago()}">
            <input class="btn btn-warning"type="submit" name="accion" value="Editar">
            <input class="btn btn-danger" type="submit" name="accion" value="Delete">
        </form>
       
       </td>
       
       
       </tr>
       </c:forEach>
       
       </tbody>
     
       
       
       
       </table>
      </div>




<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>




</body>
</html>