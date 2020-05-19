package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_empleado;

public class tb_empleadoDAO {

	Conexion c = new Conexion();
	tb_empleado u = new tb_empleado();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listartabla
	public List listar() {

		List<tb_empleado> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_empleado";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				tb_empleado u = new tb_empleado();
				u.setId_Empleado(rs.getInt(1));
				u.setJefe(rs.getString(2));
				u.setId_Cargo(rs.getInt(3));
				u.setNombre_Empleado(rs.getString(4));
				u.setApellido_Empleado(rs.getString(5));
				u.setIdentidad_Empleado(rs.getString(6));
				u.setFecha_Ingreso(rs.getString(7));
				u.setSalario(rs.getFloat(8));
				u.setTb_Empleados_id_Sucursal(rs.getInt(9));
				u.setTb_Empleados_id_Empleado(rs.getInt(10));
				u.setTb_Empleados_tb_Sucursal_id_Sucursal(rs.getInt(11));
				u.setTb_Usuarios_id_Usuario(rs.getInt(12));
				u.setTb_Tipo_Cargo_Id_Tipo_Cargo(rs.getInt(13));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	// Agregar

	public int agregar(tb_empleado u) {

		int r = 0;
		String sql = "INSERT INTO tb_empleado(Jefe,Id_Cargo,Nombre_Empleado,Apellido_Empleado,Identidad_Empleado,Fecha_Ingreso,Salario,Tb_Empleados_id_Sucursal,Tb_Empleados_id_Empleado,Tb_Empleados_tb_Sucursal_id_Sucursal,Tb_Usuarios_id_Usuario,Tb_Tipo_Cargo_Id_Tipo_Cargo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getJefe());
			ps.setInt(2, u.getId_Cargo());
			ps.setString(3, u.getNombre_Empleado());
			ps.setString(4, u.getApellido_Empleado());
			ps.setString(5, u.getIdentidad_Empleado());
			ps.setString(6, u.getFecha_Ingreso());
			ps.setFloat(7, u.getSalario());
			ps.setInt(8, u.getTb_Empleados_id_Sucursal());
			ps.setInt(9, u.getTb_Empleados_id_Empleado());
			ps.setInt(10, u.getTb_Empleados_tb_Sucursal_id_Sucursal());
			ps.setInt(11, u.getTb_Usuarios_id_Usuario());
			ps.setInt(12, u.getTb_Tipo_Cargo_Id_Tipo_Cargo());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;

	}

	// listarId
	public tb_empleado listarid(int id_Empleado) {

		String sql = "SELECT *FROM tb_empleado WHERE id_Empleado" + id_Empleado;
		tb_empleado u = new tb_empleado();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				u.setJefe(rs.getString(2));
				u.setId_Cargo(rs.getInt(3));
				u.setNombre_Empleado(rs.getString(4));
				u.setApellido_Empleado(rs.getString(5));
				u.setIdentidad_Empleado(rs.getString(6));
				u.setFecha_Ingreso(rs.getString(7));
				u.setSalario(rs.getFloat(8));
				u.setTb_Empleados_id_Sucursal(rs.getInt(9));
				u.setTb_Empleados_id_Empleado(rs.getInt(10));
				u.setTb_Empleados_tb_Sucursal_id_Sucursal(rs.getInt(11));
				u.setTb_Usuarios_id_Usuario(rs.getInt(12));
				u.setTb_Tipo_Cargo_Id_Tipo_Cargo(rs.getInt(13));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}

//actualizarDatos
	public int actualizar(tb_empleado u) {

		int r = 0;
		String sql = "UPDATE tb_empleado SET Jefe=?,Id_Cargo=?,Nombre_Empleado=?,Apellido_Empleado=?,Identidad_Empleado=?,Fecha_Ingreso=?,Salario=?,Tb_Empleados_id_Sucursal=?,Tb_Empleados_id_Empleado=?,Tb_Empleados_tb_Sucursal_id_Sucursal=?,Tb_Usuarios_id_Usuario=?,Tb_Tipo_Cargo_Id_Tipo_Cargo=?";

		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getJefe());
			ps.setInt(2, u.getId_Cargo());
			ps.setString(3, u.getNombre_Empleado());
			ps.setString(4, u.getApellido_Empleado());
			ps.setString(5, u.getIdentidad_Empleado());
			ps.setString(6, u.getFecha_Ingreso());
			ps.setFloat(7, u.getSalario());
			ps.setInt(8, u.getTb_Empleados_id_Sucursal());
			ps.setInt(9, u.getTb_Empleados_id_Empleado());
			ps.setInt(10, u.getTb_Empleados_tb_Sucursal_id_Sucursal());
			ps.setInt(11, u.getTb_Usuarios_id_Usuario());
			ps.setInt(12, u.getTb_Tipo_Cargo_Id_Tipo_Cargo());

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

	// EliminarEmpleado

	public void delete(int id_empleado) {

		String sql = "DELETE FROM tb_empleado WHERE id_empleado=" + id_empleado;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
