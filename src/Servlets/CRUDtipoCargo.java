package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_tipo_cargoDAO;
import modelo.tb_tipo_cargo;

/**
 * Servlet implementation class CRUDtipoCargo
 */
@WebServlet("/CRUDtipoCargo")
public class CRUDtipoCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_tipo_cargoDAO DAO = new tb_tipo_cargoDAO();
	tb_tipo_cargo u = new tb_tipo_cargo();
	int ide, ide2, set1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDtipoCargo() {
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

		case "Listar Cargo":
			List<tb_tipo_cargoDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_Cargo.jsp").forward(request, response);
			break;

		case "Agregar Cargo":
			request.getRequestDispatcher("AddCargo.jsp").forward(request, response);
			break;

		case "Guardar":
			String Nombre_Tipo_Cargo = request.getParameter("txtNombreTipo");
			String Descripcion = request.getParameter("txtDescripcion");
			u.setNombre_Tipo_Cargo(Nombre_Tipo_Cargo);
			u.setDescripcion(Descripcion);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDtipoCargo?accion= Listar Cargo").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Tipo_Cargo"));
			tb_tipo_cargo us = DAO.listarid(ide);
			request.setAttribute("tb_tipo_Cargo", us);
			request.getRequestDispatcher("EditarTipoCargo.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Nombre_Tipo_Carg = request.getParameter("txtNombreTipo");
			String Descripcio = request.getParameter("txtDescripcion");
			u.setNombre_Tipo_Cargo(Nombre_Tipo_Carg);
			u.setDescripcion(Descripcio);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDtipoCargo?accion = Listar Cargo").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Tipo_Cargo"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDtipoCargo?accion = Listar Cargo").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
