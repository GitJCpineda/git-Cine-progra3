
//DataAccesObjet
package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_Usuarios;

public class tb_UsuariosDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_Usuarios u = new tb_Usuarios();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// metodoLogin
	public tb_Usuarios validar(String Usuario, String Password, String Tipo_Usuario) {

		String sql = "SELECT *FROM tb_usuarios WHERE Usuario=? and Password=? and Tipo_Usuario=?";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, Usuario);
			ps.setString(2, Password);
			ps.setString(3, Tipo_Usuario);
			rs = ps.executeQuery();

			while (rs.next()) {// RecorrerTabla

				u.setUsuario(rs.getString("Usuario"));
				u.setPassword(rs.getString("Password"));
				u.setTipo_Usuario(rs.getString("Tipo_Usuario"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return u;
	}
	// metodoListaUsuariosServlet

	public List listar() {

		List<tb_Usuarios> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_usuarios";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_Usuarios u = new tb_Usuarios();
				u.setId_Usuario(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setUsuario(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setTipo_Usuario(rs.getString(5));
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
