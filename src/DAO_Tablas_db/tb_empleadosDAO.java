package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_empleados;

public class tb_empleadosDAO {

	Conexion c = new Conexion();
	tb_empleados u = new tb_empleados();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listartb

	public List listar() {
		List<tb_empleados> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_empleados";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_empleados u = new tb_empleados();
				u.setId_Sucursal(rs.getInt(1));
				u.setId_Empleado(rs.getInt(2));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(3));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// agregarElementos
	public int agregar(tb_empleados u) {

		int r = 0;
		String sql = "INSERT INTO tb_empleados(id_Empleado,tb_Sucursal_id_Sucursal)VALUES(?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Empleado());
			ps.setInt(2, u.getTb_Sucursal_id_Sucursal());
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

	// ListarId
	public tb_empleados listarid(int id_Sucursal) {
		String sql = "SELECT *FROM tb_empleados WHERE id_Sucursal=" + id_Sucursal;
		tb_empleados u = new tb_empleados();
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setId_Empleado(rs.getInt(2));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// Actualizar
	public int actualizar(tb_empleados u) {
		int r = 0;
		String sql = "UPDATE tb_empleados SET id_Empleado=?, tb_Sucursal_id_Sucursal=? WHERE id_Sucursal=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Empleado());
			ps.setInt(2, u.getTb_Sucursal_id_Sucursal());
			ps.setInt(3, u.getId_Sucursal());
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
		String sql = "DELETE FROM tb_empleados WHERE id_Sucursal=" + id_Sucursal;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
