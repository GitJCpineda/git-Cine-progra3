package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_clienteDAO;
import modelo.tb_cliente;

/**
 * Servlet implementation class CRUDcliente
 */
@WebServlet("/CRUDcliente")
public class CRUDcliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_clienteDAO DAO = new tb_clienteDAO();
	tb_cliente u = new tb_cliente();
	int ide, ide2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDcliente() {
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

		case "Listar Clientes":
			List<tb_clienteDAO> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_cliente.jsp").forward(request, response);
			break;

		case "Agregar Cliente":
			request.getRequestDispatcher("Addcliente.jsp").forward(request, response);
			break;

		case "Guardar":

			String Nombre_Cliente = request.getParameter("txtNombre");
			String Identidad_Cliente = request.getParameter("txtIdentidad");
			String Email = request.getParameter("txtEmail");
			String Tarjeta_Credito = request.getParameter("txtTarjeta_Credito");
			u.setNombre_Cliente(Nombre_Cliente);
			u.setIdentidad_Cliente(Identidad_Cliente);
			u.setEmail(Email);
			u.setTarjeta_Credito(Tarjeta_Credito);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDcliente?accion=Listar Cliente").forward(request, response);
			break;

		case "Editar":
			ide = Integer.parseInt(request.getParameter("id_Cliente"));
			tb_cliente us = DAO.listarid(ide);
			request.setAttribute("tb_cliente", us);
			request.getRequestDispatcher("Editar_Cliente.jsp").forward(request, response);
			break;

		case "Actualizar":

			String Nombre_Client = request.getParameter("txtNombre");
			String Identidad_Client = request.getParameter("txtIdentidad");
			String Emai = request.getParameter("txtEmail");
			String Tarjeta_Credit = request.getParameter("txtTarjeta_Credito");
			u.setNombre_Cliente(Nombre_Client);
			u.setIdentidad_Cliente(Identidad_Client);
			u.setEmail(Emai);
			u.setTarjeta_Credito(Tarjeta_Credit);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDcliente?accion=Listar Cliente").forward(request, response);
			break;

		case "Delete":
			ide2 = Integer.parseInt(request.getParameter("id_Cliente"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDcliente?accion=Listar Cliente").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
