package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_tipo_pelicula;

public class tb_tipo_peliculaDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_tipo_pelicula u = new tb_tipo_pelicula();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// Listartabla

	public List listar() {

		List<tb_tipo_pelicula> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_tipo_pelicula";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_tipo_pelicula u = new tb_tipo_pelicula();
				u.setId_Tipo(rs.getInt(1));
				u.setGenero(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				u.setTb_Pelicula_id_Pelicula(rs.getInt(4));
				lista.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// agregar

	public int agregar(tb_tipo_pelicula u) {

		int r = 0;
		String sql = "INSERT INTO tb_tipo_pelicula(Genero, Descripcion, tb_Pelicula_id_Pelicula)VALUES(?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getGenero());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getTb_Pelicula_id_Pelicula());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	// listarid

	public tb_tipo_pelicula listarid(int id_Tipo) {

		String sql = "SELECT *FROM tb_tipo_pelicula WHERE id_Tipo=" + id_Tipo;
		tb_tipo_pelicula u = new tb_tipo_pelicula();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				u.setGenero(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				u.setTb_Pelicula_id_Pelicula(rs.getInt(4));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizar

	public int actualizar(tb_tipo_pelicula u) {

		int r = 0;
		String sql = "UPDATE tb_tipo_pelicula SET Genero=?, Descripcion=?, tb_Pelicula_id_Pelicula=? WHERE id_Tipo=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getGenero());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getTb_Pelicula_id_Pelicula());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}
	
	//eliminar

	public void delete(int id_Tipo) {
		String sql = "DELETE FROM tb_tipo_pelicula WHERE id_Tipo=" + id_Tipo;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
