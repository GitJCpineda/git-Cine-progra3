package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import Controlador.Conexion;
import modelo.tb_Pelicula;

public class tb_PeliculaDAO {
	
	Conexion c= new Conexion();
	tb_Pelicula u = new tb_Pelicula();//TablaPeliculas
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	public List listar() {
		
		List<tb_Pelicula> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_Pelicula";
		
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tb_Pelicula u = new tb_Pelicula();
				u.setId_Pelicula(rs.getInt(1));
				u.setNombre_Pelicula(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				u.setTipo_Pelicula_id_Tipo(rs.getInt(4));
				lista.add(u);
						
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	//MetodoAgregarPelicula
	
	public int agregar(tb_Pelicula u) {
		
		int r=0;
		String sql="INSERT INTO tb_Pelicula(Nombre_Pelicula,Descripcion,tb_Tipo_Pelicula_id_Tipo)VALUES(?,?,?)";
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);	
			ps.setString(1, u.getNombre_Pelicula());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getTipo_Pelicula_id_Tipo());
			r=ps.executeUpdate();
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
	
	
	//listarId
	
	public tb_Pelicula listarid(int id_Pelicula) {
		
		String sql="SELECT *FROM tb_Pelicula WHERE id_Pelicula="+id_Pelicula;
		tb_Pelicula u = new tb_Pelicula();
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				u.setNombre_Pelicula(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				u.setTipo_Pelicula_id_Tipo(rs.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return u;
	}
	
	//actualizarTb
	
	public int actualizar(tb_Pelicula u) {
		
		int r= 0;
		String sql="UPDATE tb_Pelicula SET Nombre_Pelicula=?, Descripcion=?, tb_Tipo_Pelicula_id_Tipo=? WHERE id_Pelicula=?";
		
		try {
			
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Pelicula());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getTipo_Pelicula_id_Tipo());
			ps.setInt(4, u.getId_Pelicula());
			r = ps.executeUpdate();
			
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
	
	//EliminarPelicula
	public void delete(int id_Pelicula) {
		String sql ="DELETE FROM tb_Pelicula WHERE id_Pelicula="+id_Pelicula;
		try {
			
			con= c.conectar();
			ps= con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





























