package Servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import DAO_Tablas_db.tb_UsuariosDAO;
import modelo.tb_Usuarios;

/**
 * Servlet implementation class validarUsuario
 */
@WebServlet(description = "Validacion de usuario en la base de datos", urlPatterns = { "/validarUsuario" })
public class validarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_UsuariosDAO DAO = new tb_UsuariosDAO();
	tb_Usuarios u = new tb_Usuarios();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public validarUsuario() {
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

		String accion = request.getParameter("accion");// referenciaBotonJSp

		if (accion.contentEquals("Ingresar")) {// comprobacionJsp
			String usuario = request.getParameter("txtusuario");
			String password = request.getParameter("txtpass");
			String tipo = request.getParameter("txttipo");
			u = DAO.validar(usuario, password, tipo);

			if (u.getUsuario() != null) {
				request.setAttribute("Usuario", u);// agregarAtributos
				if (tipo.equals("administrador")) {// tipoDeUsuarios

					request.getRequestDispatcher("AdminstradorMenu.jsp").forward(request, response);
				}
				if (tipo.equals("consulta")) {
					request.getRequestDispatcher("ConsultaMenu.jsp").forward(request, response);
				}
				if (tipo.equals("reporteria")) {
					request.getRequestDispatcher("ReporteriaMenu.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("login.jsp").forward(request, response);

				}
			} else {

				request.getRequestDispatcher("login.jsp").forward(request, response);

			}

		}
	}

}
