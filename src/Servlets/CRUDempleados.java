package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_empleadosDAO;
import modelo.tb_empleados;

/**
 * Servlet implementation class CRUDempleados
 */
@WebServlet("/CRUDempleados")
public class CRUDempleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_empleadosDAO DAO = new tb_empleadosDAO();
	tb_empleados u = new tb_empleados();
	int ide, ide2, set1, set2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDempleados() {
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

		case "Listar Empleados":
			List<tb_empleadosDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_empleados.jsp").forward(request, response);
			break;

		case "Agregar Empleados":
			request.getRequestDispatcher("AddEmpleados.jsp").forward(request, response);
			break;

		case "Guardar":

			String id_Empleado = request.getParameter("txtEmpleado");
			String tb_Sucursal_id_Sucursal = request.getParameter("txtSucursal");
			set1 = Integer.parseInt(id_Empleado);
			set2 = Integer.parseInt(tb_Sucursal_id_Sucursal);
			u.setId_Empleado(set1);
			u.setTb_Sucursal_id_Sucursal(set2);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDempleados?accion= Listar Empleados").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Sucursal"));
			tb_empleados us = DAO.listarid(ide);
			request.setAttribute("tb_empleados", us);
			request.getRequestDispatcher("EditarEmpleados.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Emplead = request.getParameter("txtEmpleado");
			String tb_Sucursal_id_Sucursa = request.getParameter("txtSucursal");
			set1 = Integer.parseInt(id_Emplead);
			set2 = Integer.parseInt(tb_Sucursal_id_Sucursa);
			u.setId_Empleado(set1);
			u.setTb_Sucursal_id_Sucursal(set2);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDempleados?accion=Listar Empleados").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Sucursal"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDempleados?accion= Listar Empleados").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
