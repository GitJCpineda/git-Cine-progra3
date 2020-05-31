package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_costoDAO;
import modelo.tb_costo;

/**
 * Servlet implementation class CRUDcosto
 */
@WebServlet("/CRUDcosto")
public class CRUDcosto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_costoDAO DAO = new tb_costoDAO();
	tb_costo u = new tb_costo();
	int ide, ide2, set3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDcosto() {
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

		case "Listar Costo":
			List<tb_costoDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_costo.jsp").forward(request, response);
			break;

		case "Agregar Costo":
			request.getRequestDispatcher("AddCosto.jsp").forward(request, response);
			break;

		case "Guardar":
			String Nombre = request.getParameter("txtNombre");
			String Valor = request.getParameter("txtValor");
			set3 = Integer.parseInt(Valor);
			u.setNombre(Nombre);
			u.setValor(set3);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDcosto?accion=Listar Costo").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Costo"));
			tb_costo us = DAO.listarid(ide);
			request.setAttribute("tb_costo", us);
			request.getRequestDispatcher("EditarCosto.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Nombr = request.getParameter("txtNombre");
			String Valo = request.getParameter("txtValor");
			set3 = Integer.parseInt(Valo);
			u.setNombre(Nombr);
			u.setValor(set3);
			u.setId_Costo(ide);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDcosto?accion=Listar Costo").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Costo"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDcosto?accion=Listar Costo").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
