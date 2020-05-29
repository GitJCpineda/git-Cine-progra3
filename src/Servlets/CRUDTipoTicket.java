package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_tipo_ticketDAO;
import modelo.tb_tipo_ticket;

/**
 * Servlet implementation class CRUDTipoTicket
 */
@WebServlet("/CRUDTipoTicket")
public class CRUDTipoTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_tipo_ticketDAO DAO = new tb_tipo_ticketDAO();
	tb_tipo_ticket u = new tb_tipo_ticket();
	int ide, ide2, set1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDTipoTicket() {
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

		case "Listar Tipo":
			List<tb_tipo_ticketDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTbTipoTicket.jsp").forward(request, response);

		case "Agregar Tipo":
			request.getRequestDispatcher("AddTipoTicket").forward(request, response);
			break;

		case "Guardar":

			String Nombre_Tipo = request.getParameter("txtNombre");
			String Descripcion = request.getParameter("txtDescripcion");
			u.setNombre_Tipo(Nombre_Tipo);
			u.setDescripcion(Descripcion);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDTipoTicket?accion= Listar Tipo").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Tipo"));
			tb_tipo_ticket us = DAO.listarid(ide);
			request.setAttribute("tb_tipo_ticket", us);
			request.getRequestDispatcher("EditarTipoTicket.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Nombre_Tip = request.getParameter("txtNombre");
			String Descripcio = request.getParameter("txtDescripcion");
			u.setNombre_Tipo(Nombre_Tip);
			u.setDescripcion(Descripcio);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDTipoTicket?accion= Listar Tipo").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Tipo"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDTipoTicket?accion= Listar Tipo").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
