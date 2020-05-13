package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_UsuariosDAO;
import modelo.tb_Usuarios;

/**
 * Servlet implementation class CRUDusuarios
 */
@WebServlet("/CRUDusuarios")
public class CRUDusuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_UsuariosDAO DAO = new tb_UsuariosDAO();
	tb_Usuarios u = new tb_Usuarios();
	int ide, ide2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDusuarios() {
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

		case "Listar Usuarios":
			List<tb_UsuariosDAO> datos = DAO.listar();
			request.setAttribute("Datos", datos);
			request.getRequestDispatcher("/showTbUsuarios.jsp").forward(request, response);
			break;

		case "Agregar Usuario":
			request.getRequestDispatcher("AddUsuario.jsp").forward(request, response);
			break;

		case "Guardar":
			String Nombre = request.getParameter("txtNombre");
			String Usuario = request.getParameter("txtUsuario");
			String password = request.getParameter("txtPassword");
			String Tipo_Usuario = request.getParameter("txtTipoUsuario");
			u.setNombre(Nombre);
			u.setUsuario(Usuario);
			u.setPassword(password);
			u.setTipo_Usuario(Tipo_Usuario);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDusuarios?accion=Listar").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Usuarios"));
			tb_Usuarios us = DAO.listarid(ide);
			request.setAttribute("tb_Usuarios", us);
			request.getRequestDispatcher("editarusuario.jsp").forward(request, response);
			break;

		case "Actualizar":
			String Nombr = request.getParameter("txtusers");
			String Usuari = request.getParameter("txtusuario");
			String passwor = request.getParameter("txtpass");
			String Tipo_Usuari = request.getParameter("txtrol");
			u.setNombre(Nombr);
			u.setUsuario(Usuari);
			u.setPassword(passwor);
			u.setTipo_Usuario(Tipo_Usuari);
			u.setId_Usuario(ide);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDusuarios?accion=Listar").forward(request, response);
			break;
		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Usuarios"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDusuarios?accion=Listar").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
