package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_costo;

public class tb_costoDAO {

	Conexion c = new Conexion();
	tb_costo u = new tb_costo();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// Listausuarios

	public List listar() {

		List<tb_costo> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_costo";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				tb_costo u = new tb_costo();
				u.setId_Costo(rs.getInt(rs.getInt(1)));
				u.setNombre(rs.getString(2));
				u.setValor(rs.getFloat(3));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	public int agrear(tb_costo u) {

		int r = 0;
		String sql = "INSERT INTO tb_costo(Nombre,Valor)VALUES(?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setFloat(2, u.getValor());
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

	public tb_costo listarid(int id_Costo) {

		String sql = "SELECT *FROM tb_costo WHERE id_Costo" + id_Costo;
		tb_costo u = new tb_costo();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				u.setNombre(rs.getString(2));
				u.setValor(rs.getFloat(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// Actualizartabla

	public int actualizar(tb_costo u) {

		int r = 0;
		String sql = "UPDATE tb_costo SET Nombre=?, Valor=? WHERE id_Costo=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setFloat(2, u.getValor());
			ps.setInt(3, u.getId_Costo());
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

	public void delete(int id_Costo) {
		String sql = "DELETE FROM tb_costo WHERE id_Costo=" + id_Costo;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
