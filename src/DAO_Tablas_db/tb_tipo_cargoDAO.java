package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_tipo_cargo;

public class tb_tipo_cargoDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_tipo_cargo u = new tb_tipo_cargo();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listar

	public List listar() {

		List<tb_tipo_cargo> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_tipo_cargo";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_tipo_cargo u = new tb_tipo_cargo();
				u.setId_Tipo_Cargo(rs.getInt(1));
				u.setNombre_Tipo_Cargo(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// Agregar

	public int agregar(tb_tipo_cargo u) {

		int r = 0;
		String sql = "INSERT INTO tb_tipo_cargo(Nombre_Tipo_Cargo, Descripcion)VALUES(?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo_Cargo());
			ps.setString(2, u.getDescripcion());
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

	// Listarid
	public tb_tipo_cargo listarid(int id_Tipo_Cargo) {

		String sql = "SELECT *FROM tb_tipo_cargo WHERE id_Tipo_Cargo" + id_Tipo_Cargo;
		tb_tipo_cargo u = new tb_tipo_cargo();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setNombre_Tipo_Cargo(rs.getString(2));
				u.setDescripcion(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizarTabla
	public int actualizar(tb_tipo_cargo u) {

		int r = 0;
		String sql = "UPDATE tb_tipo_cargo SET Nombre_Tipo_Cargo=?, Descripcion=? WHERE id_Tipo_Cargo=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo_Cargo());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getId_Tipo_Cargo());
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

	public void delete(int id_Tipo_Cargo) {
		String sql = "DELETE FROM tb_tipo_cargo WHERE id_Tipo_Cargo" + id_Tipo_Cargo;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
