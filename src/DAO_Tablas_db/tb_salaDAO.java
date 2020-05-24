package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_sala;

public class tb_salaDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_sala u = new tb_sala();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listar
	public List listar() {
		List<tb_sala> lista = new ArrayList<>();

		String sql = "SELECT *FROM tb_sala";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_sala u = new tb_sala();
				u.setId_Sala(rs.getInt(1));
				u.setUbicacion(rs.getInt(2));
				u.setNombre_Sala(rs.getString(3));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// metodoAgregar
	public int agregar(tb_sala u) {

		int r = 0;
		String sql = "INSERT INTO tb_sala(Ubicacion,Nombre_Sala)VALUES(?,?)";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUbicacion());
			ps.setString(2, u.getNombre_Sala());
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
	public tb_sala listarid(int id_Sala) {

		String sql = "SELECT *FROM tb_sala WHERE id_Sala=" + id_Sala;
		tb_sala u = new tb_sala();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setUbicacion(rs.getInt(2));
				u.setNombre_Sala(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizar
	public int actualizar(tb_sala u) {
		int r = 0;

		String sql = "UPDATE tb_sala SET Ubicacion=?, Nombre_Sala=? WHERE id_Sala=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUbicacion());
			ps.setString(2, u.getNombre_Sala());
			ps.setInt(3, u.getId_Sala());
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
	public void delete(int id_Sala) {
		String sql = "DELETE FROM tb_sala WHERE id_Sala=" + id_Sala;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
