package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_PeliculaDAO;
import modelo.tb_Pelicula;

/**
 * Servlet implementation class CRUDpelicula
 */
@WebServlet("/CRUDpelicula")
public class CRUDpelicula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_PeliculaDAO DAO = new tb_PeliculaDAO();
	tb_Pelicula u = new tb_Pelicula();
	int ide, ide2,ide3,ide4, ideTipo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDpelicula() {
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

		case "Listar Peliculas":
			List<tb_PeliculaDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_Pelicula.jsp").forward(request, response);
			break;

		case "Agregar Pelicula":
			request.getRequestDispatcher("AddPelicula.jsp").forward(request, response);
			break;

		case "Guardar":
			String Nombre = request.getParameter("txtNombre");
			String Descripcion = request.getParameter("txtDescripcion");
			String Tipo=request.getParameter("txtTipo");
			ide3 = Integer.parseInt(Tipo);
			
			u.setNombre_Pelicula(Nombre);
			u.setDescripcion(Descripcion);
			u.setTipo_Pelicula_id_Tipo(ide3);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDpelicula?accion=Listar Peliculas").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Pelicula"));
			tb_Pelicula us = DAO.listarid(ide);
			request.setAttribute("tb_Pelicula", us);
			request.getRequestDispatcher("EditarPelicula.jsp").forward(request, response);
			break;

		case "Actualizar":
			String Nombr = request.getParameter("txtNombre");
			String Descripcio = request.getParameter("txtDescripcion");
			String Tipo_Pelicula = request.getParameter("txtTipo");
			ide4 = Integer.parseInt(Tipo_Pelicula);
			

			u.setNombre_Pelicula(Nombr);
			u.setDescripcion(Descripcio);
			u.setTipo_Pelicula_id_Tipo(ide4);
			u.setId_Pelicula(ide);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDpelicula?accion=Listar Peliculas").forward(request, response);
			break;
		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Pelicula"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDpelicula?accion=Listar Peliculas").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
