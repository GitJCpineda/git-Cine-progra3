package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_salaDAO;
import modelo.tb_sala;

/**
 * Servlet implementation class CRUDsala
 */
@WebServlet("/CRUDsala")
public class CRUDsala extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_salaDAO DAO = new tb_salaDAO();
	tb_sala u = new tb_sala();
	int ide, ide2, set1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDsala() {
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

		case "Listar Sala":
			List<tb_sala> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_sala.jsp").forward(request, response);
			break;

		case "Agregar Sala":
			request.getRequestDispatcher("AddSala.jsp").forward(request, response);
			break;

		case "Guardar":

			String Ubicacion = request.getParameter("txtUbicacion");
			String Nombre_Sala = request.getParameter("txtNombreSala");
			set1 = Integer.parseInt(Ubicacion);

			u.setUbicacion(set1);
			u.setNombre_Sala(Nombre_Sala);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDsala?accion= Listar Sala").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Sala"));
			tb_sala us = DAO.listarid(ide);
			request.setAttribute("tb_sala", us);
			request.getRequestDispatcher("EditarSala.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Ubicacio = request.getParameter("txtUbicacion");
			String Nombre_Sal = request.getParameter("txtNombreSala");
			set1 = Integer.parseInt(Ubicacio);

			u.setUbicacion(set1);
			u.setNombre_Sala(Nombre_Sal);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDsala?accion= Listar Sala").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Sala"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDsala?accion= Listar Sala").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
