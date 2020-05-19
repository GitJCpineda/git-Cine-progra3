package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_empleadoDAO;
import modelo.tb_empleado;

/**
 * Servlet implementation class CRUDempleado
 */
@WebServlet("/CRUDempleado")
public class CRUDempleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_empleadoDAO DAO = new tb_empleadoDAO();
	tb_empleado u = new tb_empleado();
	int ide, ide2, ide3, ide4, ideTipo;
	int set1, set2, set3, set4, set5, set6;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDempleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String accion = request.getParameter("accion");
		switch (accion) {

		case "Listar Empleado":
			List<tb_empleado> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_empleado.jsp").forward(request, response);
			break;

		case "Agregar Empleado":
			request.getRequestDispatcher("AddEmpleado.jsp").forward(request, response);
			break;

		case "Guardar":
			String Jefe = request.getParameter("txtJefe");
			String Cargo = request.getParameter("txtCargo");
			String Nombre = request.getParameter("txtNombre");
			String Apellido = request.getParameter("txtApellido");
			String Identidad = request.getParameter("txtIdentidad");
			String Fecha_Ingreso = request.getParameter("txtFecha");
			String tb_Empleados_id_Sucursal = request.getParameter("txtIdSucursal");
			String tb_Empleados_id_Empleado = request.getParameter("id_empleado");
			String tb_Empleados_tb_Sucursal_id_Sucursal = request.getParameter("id_Tbsucursal");
			String tb_Usuarios_id_Usuario = request.getParameter("id_Usuario");
			String tb_Tipo_Cargo_Id_Tipo_Cargo = request.getParameter("id_Cargo");
			// ConvertirDeEnteroAstring
			set1 = Integer.parseInt(tb_Empleados_id_Sucursal);
			set2 = Integer.parseInt(tb_Empleados_id_Empleado);
			set3 = Integer.parseInt(tb_Empleados_tb_Sucursal_id_Sucursal);
			set4 = Integer.parseInt(tb_Usuarios_id_Usuario);
			set5 = Integer.parseInt(tb_Tipo_Cargo_Id_Tipo_Cargo);
			set6 = Integer.parseInt(Cargo);

			u.setJefe(Jefe);
			u.setId_Cargo(set6);
			u.setNombre_Empleado(Nombre);
			u.setApellido_Empleado(Apellido);
			u.setIdentidad_Empleado(Identidad);
			u.setFecha_Ingreso(Fecha_Ingreso);
			u.setTb_Empleados_id_Sucursal(set1);
			u.setTb_Empleados_id_Empleado(set2);
			u.setTb_Empleados_tb_Sucursal_id_Sucursal(set3);
			u.setTb_Usuarios_id_Usuario(set4);
			u.setTb_Tipo_Cargo_Id_Tipo_Cargo(set5);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDempleado?accion=Listar Empleado").forward(request, response);
			break;

		case "Editar":

			ide = Integer.parseInt(request.getParameter("id_Empleado"));
			tb_empleado us = DAO.listarid(ide);
			request.setAttribute("tb_empleado", us);
			request.getRequestDispatcher("EditarEmpleado.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Jef = request.getParameter("txtJefe");
			String Carg = request.getParameter("txtCargo");
			String Nombr = request.getParameter("txtNombre");
			String Apellid = request.getParameter("txtApellido");
			String Identida = request.getParameter("txtIdentidad");
			String Fecha_Ingres = request.getParameter("txtFecha");
			String tb_Empleados_id_Sucursa = request.getParameter("txtIdSucursal");
			String tb_Empleados_id_Emplead = request.getParameter("id_empleado");
			String tb_Empleados_tb_Sucursal_id_Sucursa = request.getParameter("id_Tbsucursal");
			String tb_Usuarios_id_Usuari = request.getParameter("id_Usuario");
			String tb_Tipo_Cargo_Id_Tipo_Carg = request.getParameter("id_Cargo");
			// ConvertirDeEnteroAstring
			set1 = Integer.parseInt(tb_Empleados_id_Sucursa);
			set2 = Integer.parseInt(tb_Empleados_id_Emplead);
			set3 = Integer.parseInt(tb_Empleados_tb_Sucursal_id_Sucursa);
			set4 = Integer.parseInt(tb_Usuarios_id_Usuari);
			set5 = Integer.parseInt(tb_Tipo_Cargo_Id_Tipo_Carg);
			set6 = Integer.parseInt(Carg);

			u.setJefe(Jef);
			u.setId_Cargo(set6);
			u.setNombre_Empleado(Nombr);
			u.setApellido_Empleado(Apellid);
			u.setIdentidad_Empleado(Identida);
			u.setFecha_Ingreso(Fecha_Ingres);
			u.setTb_Empleados_id_Sucursal(set1);
			u.setTb_Empleados_id_Empleado(set2);
			u.setTb_Empleados_tb_Sucursal_id_Sucursal(set3);
			u.setTb_Usuarios_id_Usuario(set4);
			u.setTb_Tipo_Cargo_Id_Tipo_Cargo(set5);
			DAO.actualizar(u);

			request.getRequestDispatcher("CRUDempleado?accion= Listar Empleado").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Empleado"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDempleado?accion=Listar Empleado").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}
	}

}
