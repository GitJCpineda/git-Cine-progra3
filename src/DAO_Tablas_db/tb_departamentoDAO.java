package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_departamento;

public class tb_departamentoDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_departamento u = new tb_departamento();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public List listar() {

		List<tb_departamento> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_departamento";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_departamento u = new tb_departamento();
				u.setId_Departamento(rs.getInt(1));
				u.setNombre_Departamento(rs.getString(2));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public int agregar(tb_departamento u) {

		int r = 0;
		String sql = "INSERT INTO tb_departamento(Nombre_Departamento)VALUES(?)";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Departamento());
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

	// listaid
	public tb_departamento listarid(int id_Departamento) {
		String sql = "SELECT *FROM tb_departamento WHERE id_Departamento" + id_Departamento;
		tb_departamento u = new tb_departamento();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setNombre_Departamento(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizartabla
	public int actualizar(tb_departamento u) {

		int r = 0;
		String sql = "UPDATE tb_departamento SET Nombre_Departamento=? WHERE id_Departamento=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Departamento());
			ps.setInt(2, u.getId_Departamento());
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
//eliminar datos
	public void delete(int id_Departamento) {

		String sql = "DELETE FROM tb_departamento WHERE id_Departamento=" + id_Departamento;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
