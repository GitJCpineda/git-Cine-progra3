package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import Controlador.Conexion;
import modelo.tb_asiento;

public class tb_asientoDAO {

	Conexion c = new Conexion();
	tb_asiento u = new tb_asiento();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public List listar() {
		List<tb_asiento> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_asiento";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				tb_asiento u = new tb_asiento();
				u.setId_Asiento(rs.getInt(1));
				u.setId_Sala(rs.getInt(2));
				u.setNumero_Asiento(rs.getInt(3));
				u.setTb_Sala_id_Sala(rs.getInt(4));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}
	
	
	
	public int agregar(tb_asiento u) {
		
		int r=0;
		String sql="INSERT INTO tb_asiento(id_Asiento,id_Sala,Numero_Asiento,tb_Sala_id_Sala)VALUES(?,?,?,?)";
		
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getNumero_Asiento());
			ps.setInt(3, u.getTb_Sala_id_Sala());
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
		
		
		
	}
	
	public tb_asiento listarid(int id_Asiento) {
		
		String sql ="SELECT *FROM tb_asiento  WHERE id_Asiento"+id_Asiento;
		tb_asiento u = new tb_asiento();
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				u.setId_Sala(rs.getInt(2));
				u.setNumero_Asiento(rs.getInt(3));
				u.setTb_Sala_id_Sala(rs.getInt(4));
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
		
		
	}
	
	public int actualizar(tb_asiento u) {
		
		int r=0;
		
		String sql= "UPDATE tb_asiento SET id_Sala=?, Numero_Asiento=?, tb_Sala_id_Sala=?";
		
		try {
			
			
			con= c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getNumero_Asiento());
			ps.setInt(3, u.getTb_Sala_id_Sala());
			
			if(r==1) {
				r=1;
			}
			else {
				r=0;
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
		
	}
	
	public void delete(int id_Asiento) {
		
		String sql = "DELETE FROM tb_asiento WHERE id_Asiento="+id_Asiento;
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
