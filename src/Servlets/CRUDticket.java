package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO_Tablas_db.tb_ticketDAO;
import modelo.tb_ticket;

/**
 * Servlet implementation class CRUDticket
 */
@WebServlet("/CRUDticket")
public class CRUDticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	tb_ticketDAO DAO = new tb_ticketDAO();
	tb_ticket u = new tb_ticket();
	int ide, ide2, set1;
	int set2, set3, set4, set5, set6, set7, set8, set9, set10, set11, set12, set13, set14, set15, set16, set17, set18,
			set19;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CRUDticket() {
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

		case "Listar Ticket":
			List<tb_ticket> datos = DAO.listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ShowTb_ticket.jsp").forward(request, response);
			break;

		case "Agregar Ticket":
			request.getRequestDispatcher("AddTicket.jsp").forward(request, response);
			break;

		case "Guardar":

			String id_Funcion = request.getParameter("txtFuncion");
			String id_Tipo_Pago = request.getParameter("txtTipoPago");
			String id_Cliente = request.getParameter("txtCliente");
			String id_Posteo_Empleado = request.getParameter("txtPosteoEmpleado");
			String Fecha_Compra = request.getParameter("txtFecha");// String
			String id_Sucursal = request.getParameter("txtSucursal");
			String id_Tipo = request.getParameter("txtTipo");
			String id_Asiento = request.getParameter("txtAsiento");
			String id_Costo = request.getParameter("txtCosto");
			String tb_Funcion_id_Funcion = request.getParameter("txtTbFuncion");
			String tb_Funcion_tb_Pelicula_id_Pelicula = request.getParameter("txtTbPelicula");
			String tb_Cliente_id_Cliente = request.getParameter("txtTb;Cliente");
			String tb_Costo_id_Costo = request.getParameter("txtTbCosto");
			String tb_Tipo_Pago_id_Tipo_pago = request.getParameter("txtTbTipoPago");
			String tb_Tipo_Ticket_id_Tipo = request.getParameter("txtTipoTicket");
			String tb_Empleado_id_Empleado = request.getParameter("txtEmpleado");
			String tb_Asiento_id_Asiento = request.getParameter("txtTbAsiento");
			String tb_Sucursal_id_Sucursal = request.getParameter("txtTbSucursal");
			String tb_Sucursal_tb_Departamento_id_Departamento = request.getParameter("txtTbDepartamento");
			set1 = Integer.parseInt(id_Funcion);
			set2 = Integer.parseInt(id_Tipo_Pago);
			set3 = Integer.parseInt(id_Cliente);
			set4 = Integer.parseInt(id_Posteo_Empleado);
			set5 = Integer.parseInt(id_Sucursal);
			set6 = Integer.parseInt(id_Tipo);
			set7 = Integer.parseInt(id_Asiento);
			set8 = Integer.parseInt(id_Costo);
			set9 = Integer.parseInt(tb_Funcion_id_Funcion);
			set10 = Integer.parseInt(tb_Funcion_tb_Pelicula_id_Pelicula);
			set11 = Integer.parseInt(tb_Cliente_id_Cliente);
			set12 = Integer.parseInt(tb_Costo_id_Costo);
			set13 = Integer.parseInt(tb_Tipo_Pago_id_Tipo_pago);
			set14 = Integer.parseInt(tb_Tipo_Ticket_id_Tipo);
			set15 = Integer.parseInt(tb_Empleado_id_Empleado);
			set16 = Integer.parseInt(tb_Asiento_id_Asiento);
			set17 = Integer.parseInt(tb_Sucursal_id_Sucursal);
			set18 = Integer.parseInt(tb_Sucursal_tb_Departamento_id_Departamento);

			u.setId_Funcion(set1);
			u.setId_Tipo_Pago(set2);
			u.setId_Cliente(set3);
			u.setId_Posteo_Empleado(set4);
			u.setFecha_Compra(Fecha_Compra);
			u.setId_Sucursal(set5);
			u.setId_Tipo(set6);
			u.setId_Asiento(set7);
			u.setId_Costo(set8);
			u.setTb_Funcion_id_Funcion(set9);
			u.setTb_Funcion_tb_Pelicula_id_Pelicula(set10);
			u.setTb_Cliente_id_Cliente(set11);
			u.setTb_Costo_id_Costo(set12);
			u.setTb_Tipo_Pago_id_Tipo_Pago(set13);
			u.setTb_Tipo_Ticket_id_Tipo(set14);
			u.setTb_Empleado_id_Empleado(set15);
			u.setTb_Asiento_id_Asiento(set16);
			u.setTb_Sucursal_id_Sucursal(set17);
			u.setTb_Sucursal_tb_Departamento_id_Departamento(set18);
			DAO.agregar(u);
			request.getRequestDispatcher("CRUDticket?accion= Listar Ticket").forward(request, response);
			break;

		case "Editar":

			ide = Integer.parseInt(request.getParameter("id_Ticket"));
			tb_ticket us = DAO.listarid(ide);
			request.setAttribute("tb_ticket", us);
			request.getRequestDispatcher("EditarTicket.jsp").forward(request, response);
			break;

		case "Actualizar":

			String id_Funcio = request.getParameter("txtFuncion");
			String id_Tipo_Pag = request.getParameter("txtTipoPago");
			String id_Client = request.getParameter("txtCliente");
			String id_Posteo_Emplead = request.getParameter("txtPosteoEmpleado");
			String Fecha_Compr = request.getParameter("txtFecha");// String
			String id_Sucursa = request.getParameter("txtSucursal");
			String id_Tip = request.getParameter("txtTipo");
			String id_Asient = request.getParameter("txtAsiento");
			String id_Cost = request.getParameter("txtCosto");
			String tb_Funcion_id_Funcio = request.getParameter("txtTbFuncion");
			String tb_Funcion_tb_Pelicula_id_Pelicul = request.getParameter("txtTbPelicula");
			String tb_Cliente_id_Client = request.getParameter("txtTb;Cliente");
			String tb_Costo_id_Cost = request.getParameter("txtTbCosto");
			String tb_Tipo_Pago_id_Tipo_pag = request.getParameter("txtTbTipoPago");
			String tb_Tipo_Ticket_id_Tip = request.getParameter("txtTipoTicket");
			String tb_Empleado_id_Emplead = request.getParameter("txtEmpleado");
			String tb_Asiento_id_Asient = request.getParameter("txtTbAsiento");
			String tb_Sucursal_id_Sucursa = request.getParameter("txtTbSucursal");
			String tb_Sucursal_tb_Departamento_id_Departament = request.getParameter("txtTbDepartamento");
			set1 = Integer.parseInt(id_Funcio);
			set2 = Integer.parseInt(id_Tipo_Pag);
			set3 = Integer.parseInt(id_Client);
			set4 = Integer.parseInt(id_Posteo_Emplead);
			set5 = Integer.parseInt(id_Sucursa);
			set6 = Integer.parseInt(id_Tip);
			set7 = Integer.parseInt(id_Asient);
			set8 = Integer.parseInt(id_Cost);
			set9 = Integer.parseInt(tb_Funcion_id_Funcio);
			set10 = Integer.parseInt(tb_Funcion_tb_Pelicula_id_Pelicul);
			set11 = Integer.parseInt(tb_Cliente_id_Client);
			set12 = Integer.parseInt(tb_Costo_id_Cost);
			set13 = Integer.parseInt(tb_Tipo_Pago_id_Tipo_pag);
			set14 = Integer.parseInt(tb_Tipo_Ticket_id_Tip);
			set15 = Integer.parseInt(tb_Empleado_id_Emplead);
			set16 = Integer.parseInt(tb_Asiento_id_Asient);
			set17 = Integer.parseInt(tb_Sucursal_id_Sucursa);
			set18 = Integer.parseInt(tb_Sucursal_tb_Departamento_id_Departament);

			u.setId_Funcion(set1);
			u.setId_Tipo_Pago(set2);
			u.setId_Cliente(set3);
			u.setId_Posteo_Empleado(set4);
			u.setFecha_Compra(Fecha_Compr);
			u.setId_Sucursal(set5);
			u.setId_Tipo(set6);
			u.setId_Asiento(set7);
			u.setId_Costo(set8);
			u.setTb_Funcion_id_Funcion(set9);
			u.setTb_Funcion_tb_Pelicula_id_Pelicula(set10);
			u.setTb_Cliente_id_Cliente(set11);
			u.setTb_Costo_id_Costo(set12);
			u.setTb_Tipo_Pago_id_Tipo_Pago(set13);
			u.setTb_Tipo_Ticket_id_Tipo(set14);
			u.setTb_Empleado_id_Empleado(set15);
			u.setTb_Asiento_id_Asiento(set16);
			u.setTb_Sucursal_id_Sucursal(set17);
			u.setTb_Sucursal_tb_Departamento_id_Departamento(set18);
			DAO.actualizar(u);
			request.getRequestDispatcher("CRUDticket?accion= Listar Ticket").forward(request, response);
			break;

		case "Delete":

			ide2 = Integer.parseInt(request.getParameter("id_Ticket"));
			DAO.delete(ide2);
			request.getRequestDispatcher("CRUDticket= Listar Ticket").forward(request, response);
			break;

		default:
			throw new AssertionError();

		}

	}

}
