
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

	// MetodoAgregarUsuarios
	public int agregar(tb_Usuarios u) {

		int r = 0;
		String sql = "INSERT INTO tb_Usuarios(Nombre,Usuario,Password,Tipo_Usuario)VALUES(?,?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getUsuario());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getTipo_Usuario());
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

	// listarporId
	public tb_Usuarios listarid(int id_Usuarios) {

		String sql = "SELECT *FROM tb_Usuarios WHERE id_Usuario=" + id_Usuarios;
		tb_Usuarios u = new tb_Usuarios();

		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setNombre(rs.getString(2));
				u.setUsuario(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setTipo_Usuario(rs.getString(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;

	}

	//actualizarTabla
	public int actualizar(tb_Usuarios u) {

		int r = 0;
		String sql = "UPDATE tb_Usuarios SET Nombre=?, Usuario=?, Password=?, Tipo_Usuario=? WHERE id_Usuario";

		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getNombre());
			ps.setString(2, u.getUsuario());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getTipo_Usuario());
			ps.setInt(5, u.getId_Usuario());
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
	
	//eliminarUsuario
	public void delete(int id_Usuario) {
		
		String sql="DELETE FROM tb_Usuarios WHERE id_Usuario="+id_Usuario;
		try {
			con=c.conectar();
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}





















