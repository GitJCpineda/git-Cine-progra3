package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_salasDAO;
import modelo.tb_salas;

/**
 * Servlet implementation class CRUDsalas
 */
@WebServlet("/CRUDsalas")
public class CRUDsalas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_salasDAO DAO = new tb_salasDAO();
	tb_salas u = new tb_salas();
	int ide, ide2, set1, set2, set3;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDsalas() {
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

		case "Listar Salas":
			List<tb_salasDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_salas.jsp").forward(request, response);
			break;

		case "Agregar Salas":
			request.getRequestDispatcher("AddSalas.jsp").forward(request, response);
			break;

		case "Guardar":

			String id_Sala = request.getParameter("txtSala");
			String tb_Sala_id_Sala = request.getParameter("txtTbSala");
			String tb_Sucursal_id_Sucursal = request.getParameter("txtSucursal");
			set1 = Integer.parseInt(id_Sala);
			set2 = Integer.parseInt(tb_Sala_id_Sala);
			set3 = Integer.parseInt(tb_Sucursal_id_Sucursal);

			u.setId_Sala(set1);
			u.setTb_Sala_id_Sala(set2);
			u.setTb_Sucursal_id_Sucursal(set3);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDsalas?accion= Listar Salas").forward(request, response);
			break;

		case "Editar":

			ide = Integer.parseInt(request.getParameter("id_Sucursal"));
			tb_salas us = DAO.listarid(ide);
			request.setAttribute("tb_salas", us);
			request.getRequestDispatcher("EditarSalas.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Sal = request.getParameter("txtSala");
			String tb_Sala_id_Sal = request.getParameter("txtTbSala");
			String tb_Sucursal_id_Sucursa = request.getParameter("txtSucursal");
			set1 = Integer.parseInt(id_Sal);
			set2 = Integer.parseInt(tb_Sala_id_Sal);
			set3 = Integer.parseInt(tb_Sucursal_id_Sucursa);

			u.setId_Sala(set1);
			u.setTb_Sala_id_Sala(set2);
			u.setTb_Sucursal_id_Sucursal(set3);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDsalas?accion = Listar Salas").forward(request, response);
			break;

		case "Delete":

			ide2 = Integer.parseInt(request.getParameter("id_Sucursal"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDsalas?accion= Listar Salas").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
