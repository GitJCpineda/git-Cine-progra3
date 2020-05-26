package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_ticket;

public class tb_ticketDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_ticket u = new tb_ticket();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// metodoListar

	public List listar() {
		List<tb_ticket> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_ticket";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_ticket u = new tb_ticket();
				u.setId_Ticket(rs.getInt(1));
				u.setId_Funcion(rs.getInt(2));
				u.setId_Tipo_Pago(rs.getInt(3));
				u.setId_Cliente(rs.getInt(4));
				u.setId_Posteo_Empleado(rs.getInt(5));
				u.setFecha_Compra(rs.getString(6));
				u.setId_Sucursal(rs.getInt(7));
				u.setId_Tipo(rs.getInt(8));
				u.setId_Asiento(rs.getInt(9));
				u.setId_Costo(rs.getInt(10));
				u.setTb_Funcion_id_Funcion(rs.getInt(11));
				u.setTb_Funcion_tb_Pelicula_id_Pelicula(rs.getInt(12));
				u.setTb_Cliente_id_Cliente(rs.getInt(13));
				u.setTb_Costo_id_Costo(rs.getInt(14));
				u.setTb_Tipo_Pago_id_Tipo_Pago(rs.getInt(15));
				u.setTb_Tipo_Ticket_id_Tipo(rs.getInt(16));
				u.setTb_Empleado_id_Empleado(rs.getInt(17));
				u.setTb_Asiento_id_Asiento(rs.getInt(18));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(19));
				u.setTb_Sucursal_tb_Departamento_id_Departamento(rs.getInt(20));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public int agregar(tb_ticket u) {
		int r = 0;

		String sql = "INSERT INTO tb_ticket(id_Funcion,id_Tipo_Pago,id_Cliente,id_Posteo_Empleado,Fecha_Compra,id_Sucursal,id_Tipo,id_Asiento,id_Costo,tb_Funcion_id_Funcion,tb_Funcion_tb_Pelicula_id_Pelicula,tb_Cliente_id_Cliente,tb_Costo_id_Costo,tb_Tipo_Pago_id_Tipo_Pago,tb_Tipo_Ticket_id_Tipo,tb_Empleado_id_Empleado,tb_Asiento_id_Asiento,tb_Sucursal_id_Sucursal,tb_Sucursal_tb_Departamento_id_Departamento)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Funcion());
			ps.setInt(2, u.getId_Tipo_Pago());
			ps.setInt(3, u.getId_Cliente());
			ps.setInt(4, u.getId_Posteo_Empleado());
			ps.setString(5, u.getFecha_Compra());
			ps.setInt(6, u.getId_Sucursal());
			ps.setInt(7, u.getId_Tipo());
			ps.setInt(8, u.getId_Asiento());
			ps.setInt(9, u.getId_Costo());
			ps.setInt(10, u.getTb_Funcion_id_Funcion());
			ps.setInt(11, u.getTb_Funcion_tb_Pelicula_id_Pelicula());
			ps.setInt(12, u.getTb_Cliente_id_Cliente());
			ps.setInt(13, u.getTb_Costo_id_Costo());
			ps.setInt(14, u.getTb_Tipo_Pago_id_Tipo_Pago());
			ps.setInt(15, u.getTb_Tipo_Ticket_id_Tipo());
			ps.setInt(16, u.getTb_Empleado_id_Empleado());
			ps.setInt(17, u.getTb_Asiento_id_Asiento());
			ps.setInt(18, u.getTb_Sucursal_id_Sucursal());
			ps.setInt(19, u.getTb_Sucursal_tb_Departamento_id_Departamento());
			r= ps.executeUpdate();
			if(r==1) {
				r=1;
			}else {
				r=0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		
		
		
		
		
		return r;
	}
	
	//listarporid
	public tb_ticket listarid(int id_Ticket) {
		
		String sql = "SELECT *FROM tb_ticket WHERE id_Ticket="+id_Ticket;
		tb_ticket u = new tb_ticket();
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				u.setId_Funcion(rs.getInt(2));
				u.setId_Tipo_Pago(rs.getInt(3));
				u.setId_Cliente(rs.getInt(4));
				u.setId_Posteo_Empleado(rs.getInt(5));
				u.setFecha_Compra(rs.getString(6));
				u.setId_Sucursal(rs.getInt(7));
				u.setId_Tipo(rs.getInt(8));
				u.setId_Asiento(rs.getInt(9));
				u.setId_Costo(rs.getInt(10));
				u.setTb_Funcion_id_Funcion(rs.getInt(11));
				u.setTb_Funcion_tb_Pelicula_id_Pelicula(rs.getInt(12));
				u.setTb_Cliente_id_Cliente(rs.getInt(13));
				u.setTb_Costo_id_Costo(rs.getInt(14));
				u.setTb_Tipo_Pago_id_Tipo_Pago(rs.getInt(15));
				u.setTb_Tipo_Ticket_id_Tipo(rs.getInt(16));
				u.setTb_Empleado_id_Empleado(rs.getInt(17));
				u.setTb_Asiento_id_Asiento(rs.getInt(18));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(19));
				u.setTb_Sucursal_tb_Departamento_id_Departamento(rs.getInt(20));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return u;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
