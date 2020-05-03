package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR = ("com.mysql.cj.jdbc.Driver");
	private static final String URL = ("jdbc:mysql://localhost:3306/cine_db");
	private static final String USUARIO = "Carlos";
	private static final String CLAVE = "1995";

	static {
		try {
			Class.forName(CONTROLADOR);//CargarControlador
		} catch (ClassNotFoundException e) {
			System.err.print("Error al cargar Driver");
			e.printStackTrace();
		}
	}

	public Connection conectar() {
		Connection conexion = null;
		try {

			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);//conexionSQL
			System.out.println("\n"+"\nConectado");

		} catch (SQLException e) {
			System.err.print("Error en la conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}
