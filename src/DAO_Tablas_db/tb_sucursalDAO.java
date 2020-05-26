package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_sucursal;

public class tb_sucursalDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_sucursal u = new tb_sucursal();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public List listar() {

		List<tb_sucursal> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_sucursal";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_sucursal u = new tb_sucursal();
				u.setId_Sucursal(rs.getInt(1));
				u.setId_Ubicacion(rs.getInt(2));
				u.setNombre_Sucursal(rs.getString(3));
				u.setDireccion(rs.getString(4));
				u.setTb_Departamento_id_Departamento(rs.getInt(5));
				lista.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// MetodoidAgregar
	public int agregar(tb_sucursal u) {

		int r = 0;
		String sql = "INSERT INTO tb_sucursal(id_Ubicacion, Nombre_Sucursal, Direccion, tb_Departamento_id_Departamento)VALUES(?,?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Ubicacion());
			ps.setString(2, u.getNombre_Sucursal());
			ps.setString(3, u.getDireccion());
			ps.setInt(4, u.getTb_Departamento_id_Departamento());
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
	public tb_sucursal listarid(int id_Sucursal) {

		String sql = "SELECT *FROM tb_sucursal WHERE id_Sucursal" + id_Sucursal;
		tb_sucursal u = new tb_sucursal();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setId_Ubicacion(rs.getInt(2));
				u.setNombre_Sucursal(rs.getString(3));
				u.setDireccion(rs.getString(4));
				u.setTb_Departamento_id_Departamento(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizarTabla

	public int actualizar(tb_sucursal u) {

		int r = 0;
		String sql = "UPDATE tb_sucursal SET id_Ubicacion=?, Nombre_Sucursal=?, Direccion=?, tb_Departamento_id_Departamento=? WHERE id_Sucursal=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Ubicacion());
			ps.setString(2, u.getNombre_Sucursal());
			ps.setString(3, u.getDireccion());
			ps.setInt(4, u.getTb_Departamento_id_Departamento());
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
	public void delete(int id_Sucursal) {
		String sql = "DELETE FROM tb_sucursal WHERE id_Sucursal" + id_Sucursal;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
