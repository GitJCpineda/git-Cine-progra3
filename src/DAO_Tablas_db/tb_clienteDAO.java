package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_cliente;

public class tb_clienteDAO {

	Conexion c = new Conexion();
	tb_cliente u = new tb_cliente();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public List listar() {
		List<tb_cliente> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_cliente";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				tb_cliente u = new tb_cliente();
				u.setId_Cliente(rs.getInt(1));
				u.setNombre_Cliente(rs.getString(2));
				u.setIdentidad_Cliente(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setTarjeta_Credito(rs.getString(5));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;

	}

	public int agregar(tb_cliente u) {
		int r = 0;
		String sql = "INSERT INTO tb_cliente(Nombre_Cliente,Identidad_Cliente,Email,Tarjeta_Credito)VALUES(?,?,?,?)";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Cliente());
			ps.setString(2, u.getIdentidad_Cliente());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getTarjeta_Credito());
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

	public tb_cliente listarid(int id_Cliente) {

		String sql = "SELECT *FROM tb_cliente WHERE id_Cliente" + id_Cliente;
		tb_cliente u = new tb_cliente();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setNombre_Cliente(rs.getString(2));
				u.setIdentidad_Cliente(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setTarjeta_Credito(rs.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public int actualizar(tb_cliente u) {

		int r = 0;
		String sql = "UPDATE tb_cliente SET Nombre_Cliente=?,Identidad_Cliente=?,Email=?,Tarjeta_Credito WHERE id_Cliente=?";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Cliente());
			ps.setString(2, u.getIdentidad_Cliente());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getTarjeta_Credito());
			ps.setInt(5, u.getId_Cliente());
			r = ps.executeUpdate();

			if (r == 1) {

			} else {
				r = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	public void delete(int id_Cliente) {

		String sql = "DELETE FROM tb_cliente WHERE id_Cliente" + id_Cliente;
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
