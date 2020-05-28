package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_tipo_pagoDAO;
import modelo.tb_tipo_pago;

/**
 * Servlet implementation class CRUDTipoPago
 */
@WebServlet("/CRUDTipoPago")
public class CRUDTipoPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_tipo_pagoDAO DAO = new tb_tipo_pagoDAO();
	tb_tipo_pago u = new tb_tipo_pago();
	int ide, ide2, set1, set2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDTipoPago() {
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

		case "Listar Pago":
			List<tb_tipo_pagoDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_TipoPago.jsp").forward(request, response);
			break;

		case "Agregar Pago":
			request.getRequestDispatcher("AddTipoPago.jsp").forward(request, response);
			break;

		case "Guardar":

			String Nombre_Tipo_Pago = request.getParameter("txtTipoPago");
			String Descripcion = request.getParameter("txtDescripcion");
			u.setNombre_Tipo_Pago(Nombre_Tipo_Pago);
			u.setDescripcion(Descripcion);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDTipoPago?accion= Listar Pago").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Tipo_Pago"));
			tb_tipo_pago us = DAO.listarid(ide);
			request.setAttribute("tb_tipo_pago", us);
			request.getRequestDispatcher("EdtarPago.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Nombre_Tipo_Pag = request.getParameter("txtTipoPago");
			String Descripcio = request.getParameter("txtDescripcion");
			u.setNombre_Tipo_Pago(Nombre_Tipo_Pag);
			u.setDescripcion(Descripcio);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDTipoPago?accion = Listar Pago").forward(request, response);
			break;

		case "Delete":

			ide2 = Integer.parseInt(request.getParameter("id_Tipo_Pago"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDTipoPago?accion= Listar Pago").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
