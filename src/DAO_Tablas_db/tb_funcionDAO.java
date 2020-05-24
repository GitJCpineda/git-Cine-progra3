package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_funcion;

public class tb_funcionDAO {

	Conexion c = new Conexion();
	tb_funcion u = new tb_funcion();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listar
	public List listar() {
		List<tb_funcion> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_funcion";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_funcion u = new tb_funcion();
				u.setId_Funcion(rs.getInt(1));
				u.setId_Sala(rs.getInt(2));
				u.setId_Pelicula(rs.getInt(3));
				u.setHorario(rs.getString(4));
				u.setTb_Pelicula_id_Pelicula(rs.getInt(5));
				u.setTb_Sala_id_Sala(rs.getInt(6));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public int agregar(tb_funcion u) {

		int r = 0;
		String sql = "INSERT INTO tb_funcion(id_Sala, id_Pelicula, Horario, tb_Pelicula_id_Pelicula,tb_Sala_id_Sala)VALUES(?,?,?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getId_Pelicula());
			ps.setString(3, u.getHorario());
			ps.setInt(4, u.getTb_Pelicula_id_Pelicula());
			ps.setInt(5, u.getTb_Sala_id_Sala());
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

	// listar

	public tb_funcion listarid(int id_Funcion) {

		String sql = "SELECT *FROM tb_funcion WHERE id_Funcion=" + id_Funcion;
		tb_funcion u = new tb_funcion();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setId_Sala(rs.getInt(2));
				u.setId_Pelicula(rs.getInt(3));
				u.setHorario(rs.getString(4));
				u.setTb_Pelicula_id_Pelicula(rs.getInt(5));
				u.setTb_Sala_id_Sala(rs.getInt(6));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizar
	public int actualizar(tb_funcion u) {

		int r = 0;
		String sql = "UPDATE tb_funcion SET id_Sala=?, id_Pelicula=?, Horario=?, tb_Pelicula_id_Pelicula=?, tb_Sala_id_Sala=? WHERE id_Funcion=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getId_Pelicula());
			ps.setString(3, u.getHorario());
			ps.setInt(4, u.getTb_Pelicula_id_Pelicula());
			ps.setInt(5, u.getTb_Sala_id_Sala());
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

	// eliminar
	public void delete(int id_Funcion) {
		String sql = "DELETE FROM tb_funcion WHERE id_Funcion=" + id_Funcion;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
