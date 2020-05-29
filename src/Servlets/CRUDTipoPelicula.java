package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_tipo_peliculaDAO;
import modelo.tb_tipo_pelicula;

/**
 * Servlet implementation class CRUDTipoPelicula
 */
@WebServlet("/CRUDTipoPelicula")
public class CRUDTipoPelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_tipo_peliculaDAO DAO = new tb_tipo_peliculaDAO();
	tb_tipo_pelicula u = new tb_tipo_pelicula();
	int ide, ide2, set1;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDTipoPelicula() {
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

		case "Listar Tipo Pelicla":
			List<tb_tipo_peliculaDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_TipoPelicula.jsp").forward(request, response);
			break;

		case "Agregar Tipo":
			request.getRequestDispatcher("AddTipoPelicula.jsp").forward(request, response);
			break;

		case "Guardar":

			String Genero = request.getParameter("txtGenero");
			String Descripcion = request.getParameter("Descripcion");
			String tb_Pelicula_id_Pelicula = request.getParameter("txtTbPelicula");
			set1 = Integer.parseInt(tb_Pelicula_id_Pelicula);

			u.setGenero(Genero);
			u.setDescripcion(Descripcion);
			u.setTb_Pelicula_id_Pelicula(set1);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDTipoPelicula?accion= Listar Tipo Pelicula").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Tipo"));
			tb_tipo_pelicula us = DAO.listarid(ide);
			request.setAttribute("tb_tipo_pelicula", us);
			request.getRequestDispatcher("EdtarTipoPelicula").forward(request, response);
			break;

		case "Actualizar":

			String Gener = request.getParameter("txtGenero");
			String Descripcio = request.getParameter("Descripcion");
			String tb_Pelicula_id_Pelicul = request.getParameter("txtTbPelicula");
			set1 = Integer.parseInt(tb_Pelicula_id_Pelicul);

			u.setGenero(Gener);
			u.setDescripcion(Descripcio);
			u.setTb_Pelicula_id_Pelicula(set1);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDTipoPelicula?accion=  Listar Tipo Pelicula").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Tipo"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDTipoPelicula?accion = Listar Tipo Pelicula").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
