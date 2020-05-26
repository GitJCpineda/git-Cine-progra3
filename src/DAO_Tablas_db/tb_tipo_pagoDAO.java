package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_tipo_pago;

public class tb_tipo_pagoDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_tipo_pago u = new tb_tipo_pago();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// Metodolistar

	public List listar() {

		List<tb_tipo_pago> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_tipo_pago";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_tipo_pago u = new tb_tipo_pago();
				u.setId_Tipo_Pago(rs.getInt(1));
				u.setNombre_Tipo_Pago(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	// metodoAgregar
	public int agregar(tb_tipo_pago u) {
		int r = 0;
		String sql = "INSERT INTO tb_tipo_pago(Nombre_Tipo_Pago,Descripcion)VALUES(?,?)";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo_Pago());
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

	// listarId
	public tb_tipo_pago listarid(int id_Tipo_Pago) {

		String sql = "SELECT *FROM tb_tipo_pago WHERE id_Tipo_Pago" + id_Tipo_Pago;
		tb_tipo_pago u = new tb_tipo_pago();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setNombre_Tipo_Pago(rs.getString(2));
				u.setDescripcion(rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizar
	public int actualizar(tb_tipo_pago u) {

		int r = 0;
		String sql = "UPDATE tb_tipo_usuario SET Nombre_Tipo_Pago=?, Descripcion=? WHERE id_Tipo_Pago=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo_Pago());
			ps.setString(2, u.getDescripcion());
			ps.setInt(3, u.getId_Tipo_Pago());
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
	public void delete(int id_Tipo_Pago) {
		String sql = "DELETE FROM tb_tipo_pago WHERE id_Tipo_Pago=" + id_Tipo_Pago;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
