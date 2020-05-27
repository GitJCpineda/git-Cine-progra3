package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_funcionDAO;
import modelo.tb_funcion;

/**
 * Servlet implementation class CRUDfuncion
 */
@WebServlet("/CRUDfuncion")
public class CRUDfuncion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_funcionDAO DAO = new tb_funcionDAO();
	tb_funcion u = new tb_funcion();
	int ide, ide2, set1, set2, set3, set4;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDfuncion() {
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

		case "Listar Funcion":
			List<tb_funcionDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_funcion.jsp").forward(request, response);
			break;

		case "Agregar Funcion":
			request.getRequestDispatcher("AddFuncion.jsp").forward(request, response);
			break;

		case "Guardar":
			String id_Sala = request.getParameter("txtSAla");
			String id_Pelicula = request.getParameter("txtPelicula");
			String Horario = request.getParameter("txtHorario");
			String tb_Pelicula_id_Pelicula = request.getParameter("txtid_pelicula");
			String tb_Sala_id_Sala = request.getParameter("txtidSala");
			set1 = Integer.parseInt(id_Sala);
			set2 = Integer.parseInt(id_Pelicula);
			set3 = Integer.parseInt(tb_Pelicula_id_Pelicula);
			set4 = Integer.parseInt(tb_Sala_id_Sala);

			u.setId_Sala(set1);
			u.setId_Pelicula(set2);
			u.setHorario(Horario);
			u.setTb_Pelicula_id_Pelicula(set3);
			u.setTb_Sala_id_Sala(set4);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDfuncion?accion= Listar Funcion").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Funcion"));
			tb_funcion us = DAO.listarid(ide);
			request.setAttribute("tb_funcion", us);
			request.getRequestDispatcher("EditarFuncion.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Sal = request.getParameter("txtSAla");
			String id_Pelicul = request.getParameter("txtPelicula");
			String Horari = request.getParameter("txtHorario");
			String tb_Pelicula_id_Pelicul = request.getParameter("txtid_pelicula");
			String tb_Sala_id_Sal = request.getParameter("txtidSala");
			set1 = Integer.parseInt(id_Sal);
			set2 = Integer.parseInt(id_Pelicul);
			set3 = Integer.parseInt(tb_Pelicula_id_Pelicul);
			set4 = Integer.parseInt(tb_Sala_id_Sal);

			u.setId_Sala(set1);
			u.setId_Pelicula(set2);
			u.setHorario(Horari);
			u.setTb_Pelicula_id_Pelicula(set3);
			u.setTb_Sala_id_Sala(set4);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDfuncion?accion= Listar Funcion").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Funcion"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDfuncion?accion= Listar Funcion").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
