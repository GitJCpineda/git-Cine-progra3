package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_departamentoDAO;
import modelo.tb_departamento;

/**
 * Servlet implementation class CRUDdepartamento
 */
@WebServlet("/CRUDdepartamento")
public class CRUDdepartamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_departamentoDAO DAO = new tb_departamentoDAO();
	tb_departamento u = new tb_departamento();
	int ide, ide2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDdepartamento() {
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

		case "Listar Departamento":
			List<tb_departamento> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_departamento.jsp").forward(request, response);
			break;

		case "Agregar Departamento":
			request.getRequestDispatcher("AddDepartamento.jsp").forward(request, response);
			break;

		case "Guardar":
			String Nombre_Departamento = request.getParameter("txtNombre");
			u.setNombre_Departamento(Nombre_Departamento);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDdepartamento?accion= Listar Departamento").forward(request, response);
			break;

		case "Actualizar":

			String Nombre_Departament = request.getParameter("txtNombre");
			u.setNombre_Departamento(Nombre_Departament);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDdepartamento?accion= Listar Departamento").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Departamento"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDdepartamento?accion=Listar Departamento").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
