<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Mostrar Tabla Ticket</title>
</head>
<body>



<form class="login-form" action="CRUDticket" method="post">
 
      <a href="AdminstradorMenu.jsp" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-white bg-dark" role="button" aria-pressed="true">Menu anterior</a>
      <button type="submit" name="accion" value="Listar Ticket" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Listar</button>
      <button type="submit" name="accion" value="Agregar Ticket" class="btn mt-5 rounded-pill btn-lg btn-custom btn-block text-uppercase">Nuevo</button>
      </form>
      
    
     <div class="table-responsive">
      
       <table class="table table-striped table-bordered table-hover table-condensed">
       
       <tr>
         <th>ID</th>
         <th>Funcion</th>
         <th>Pago</th>
         <th>Cliente</th>
         <th>Puesto Empleado</th>
         <th>Fecha Compra</th>
         <th>Sucursal</th>
         <th>Tipo Ticket</th>
         <th>Numero Asiento</th>
         <th>Id Costo</th>
         <th>Id Funcion</th>
         <th>Tb Funcion id Pelicula</th>
         <th>tb_Cliente_id_Cliente</th>
         <th>tb_Costo_id_Costo</th>
         <th>tb_Tipo_Pago_id_Tipo_pago</th>
         <th>tb_Tipo_Ticket_id_Tipo</th>
          <th>tb_Empleado_id_Empleado</th>
          <th>tb_Asiento_id_Asiento</th>
          <th>tb_Sucursal_id_Sucursal</th>
          <th>tb_Sucursal_tb_Departamento_id_Departamento</th>
          <th>Acciones</th>
       </tr>
       
       <tbody>
       <c:forEach var="dato" items="${datos}">
       <tr>
       <td>${dato.getId_Ticket()}</td>
       <td>${dato.getId_Funcion()}</td>
       <td>${dato.getId_Tipo_Pago()}</td>
       <td>${dato.getId_Cliente()}</td>
        <td>${dato.getId_Posteo_Empleado()}</td>
        <td>${dato.getFecha_Compra()}</td>
       <td>${dato.getId_Sucursal()}</td>
       <td>${dato.getId_Tipo()}</td>
       <td>${dato.getId_Asiento()}</td>
        <td>${dato.getId_Costo()}</td>
        <td>${dato.getTb_Funcion_id_Funcion()}</td>
       <td>${dato.getTb_Funcion_tb_Pelicula_id_Pelicula()}</td>
       <td>${dato.getTb_Cliente_id_Cliente()}</td>
       <td>${dato.getTb_Costo_id_Costo()}</td>
        <td>${dato.getTb_Tipo_Pago_id_Tipo_Pago()}</td>
        <td>${dato.getTb_Tipo_Ticket_id_Tipo()}</td>
       <td>${dato.getTb_Empleado_id_Empleado()}</td>
       <td>${dato.getTb_Asiento_id_Asiento()}</td>
       <td>${dato.getTb_Sucursal_id_Sucursal()}</td>
        <td>${dato.getTb_Sucursal_tb_Departamento_id_Departamento()}</td>
       <td>
        <form action="CRUDticket" method="post">
            <input type="hidden" name="id_Ticket" value="${dato.getId_Ticket()}">
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