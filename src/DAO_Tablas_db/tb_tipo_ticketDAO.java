package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_tipo_ticket;

public class tb_tipo_ticketDAO {

	Conexion c = new Conexion();
	tb_tipo_ticket u = new tb_tipo_ticket();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// metodoListar

	public List listar() {

		List<tb_tipo_ticket> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_tipo_ticket";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				tb_tipo_ticket u = new tb_tipo_ticket();
				u.setId_Tipo(rs.getInt(1));
				u.setNombre_Tipo(rs.getString(2));
				u.setDescripcion(rs.getString(3));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// insertarTabla
	public int agregar(tb_tipo_ticket u) {

		int r = 0;
		String sql = "INSERT INTO tb_tipo_ticket(Nombre_Tipo,Descripcion)VALUES(?,?)";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo());
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

	public tb_tipo_ticket listarid(int id_Tipo) {

		String sql = "SELECT *FROM tb_tipo_ticket WHERE id_Tipo=" + id_Tipo;
		tb_tipo_ticket u = new tb_tipo_ticket();

		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setNombre_Tipo(rs.getString(2));
				u.setDescripcion(rs.getString(2));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	public int actualizar(tb_tipo_ticket u) {
		int r = 0;
		String sql = "UPDATE tb_tipo_ticket SET Nombre_Tipo=?, Descripcion=? WHERE id_Tipo=?";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre_Tipo());
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

	public void delete(int id_Tipo) {

		String sql = "DELETE FROM tb_tipo_ticket WHERE id_Tipo=" + id_Tipo;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
