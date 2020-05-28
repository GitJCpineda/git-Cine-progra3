package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_sucursalDAO;
import modelo.tb_sucursal;

/**
 * Servlet implementation class CRUDsucursal
 */
@WebServlet("/CRUDsucursal")
public class CRUDsucursal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_sucursalDAO DAO = new tb_sucursalDAO();
	tb_sucursal u = new tb_sucursal();
	int ide, ide2, set1, set2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDsucursal() {
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

		case "Listar Sucursal":
			List<tb_sucursalDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_sucursal.jsp").forward(request, response);
			break;

		case "Agregar Sucursal":
			request.getRequestDispatcher("AddSucursal.jsp").forward(request, response);
			break;

		case "Guardar":
			String id_Ubicacion = request.getParameter("txtUbicacion");
			String Nombre_Sucursal = request.getParameter("txtSucursal");
			String Direccion = request.getParameter("txtDireccion");
			String tb_Departamento_id_Departamento = request.getParameter("txtDepartamento");
			set1 = Integer.parseInt(id_Ubicacion);
			set2 = Integer.parseInt(tb_Departamento_id_Departamento);

			u.setId_Ubicacion(set1);
			u.setNombre_Sucursal(Nombre_Sucursal);
			u.setDireccion(Direccion);
			u.setTb_Departamento_id_Departamento(set2);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDsucursal?accion= Listar Sucursal").forward(request, response);
			break;

		case "Editar":

			ide = Integer.parseInt(request.getParameter("id_Sucursal"));
			tb_sucursal us = DAO.listarid(ide);
			request.setAttribute("tb_sucursal", us);
			request.getRequestDispatcher("EditarSucursal.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Ubicacio = request.getParameter("txtUbicacion");
			String Nombre_Sucursa = request.getParameter("txtSucursal");
			String Direccio = request.getParameter("txtDireccion");
			String tb_Departamento_id_Departament = request.getParameter("txtDepartamento");
			set1 = Integer.parseInt(id_Ubicacio);
			set2 = Integer.parseInt(tb_Departamento_id_Departament);

			u.setId_Ubicacion(set1);
			u.setNombre_Sucursal(Nombre_Sucursa);
			u.setDireccion(Direccio);
			u.setTb_Departamento_id_Departamento(set2);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDsucursal?accion= Listar Sucursal").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Sucursal"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDsucursal?accion= Listar Sucursal").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
