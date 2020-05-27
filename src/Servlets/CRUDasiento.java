package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_asientoDAO;
import modelo.tb_asiento;

/**
 * Servlet implementation class CRUDasiento
 */
@WebServlet("/CRUDasiento")
public class CRUDasiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_asientoDAO DAO = new tb_asientoDAO();
	tb_asiento u = new tb_asiento();
	int ide, ide2;
	int set1, set2, set3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDasiento() {
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

		case "Listar Asiento":
			List<tb_asiento> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_asiento.jsp").forward(request, response);
			break;

		case "Agregar Asiento":
			request.getRequestDispatcher("Addasiento.jsp").forward(request, response);
			break;

		case "Guardar":

			String id_Sala = request.getParameter("txtSala");
			String Numero_Asiento = request.getParameter("txtNumero_Asiento");
			String tb_Sala_id_Sala = request.getParameter("txtid_Sala");

			// ConvirtiendoEntero
			set1 = Integer.parseInt(id_Sala);
			set2 = Integer.parseInt(Numero_Asiento);
			set3 = Integer.parseInt(tb_Sala_id_Sala);

			u.setId_Sala(set1);
			u.setNumero_Asiento(set2);
			u.setTb_Sala_id_Sala(set3);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDasiento?accion=Listar Asiento").forward(request, response);
			break;

		case "Editar":

			ide = Integer.parseInt(request.getParameter("id_Asiento"));
			tb_asiento us = DAO.listarid(ide);
			request.setAttribute("tb_asiento", us);
			request.getRequestDispatcher("EditarAsiento.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Sal = request.getParameter("txtSala");
			String Numero_Asient = request.getParameter("txtNumero_Asiento");
			String tb_Sala_id_Sal = request.getParameter("txtid_Sala");

			// ConvirtiendoEntero
			set1 = Integer.parseInt(id_Sal);
			set2 = Integer.parseInt(Numero_Asient);
			set3 = Integer.parseInt(tb_Sala_id_Sal);

			u.setId_Sala(set1);
			u.setNumero_Asiento(set2);
			u.setTb_Sala_id_Sala(set3);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDasiento?accion=Listar Asiento").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Asiento"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDasiento?accion=Listar Asiento").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
