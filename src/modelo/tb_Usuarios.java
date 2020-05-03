//ModeloBaseDedatosSQL
package modelo;

public class tb_Usuarios {
	//CamposSQL
	int id_Usuario;
	String Nombre;
	String Usuario;
	String Password;
	String Tipo_Usuario;
	
	public tb_Usuarios() {
		
	}
	
	public tb_Usuarios(int id_Usuario, String Nombre, String Usuario, String Password, String Tipo_Usuario) {
		
		this.id_Usuario=id_Usuario;
		this.Nombre=Nombre;
		this.Usuario=Usuario;
		this.Password= Password;
		this.Tipo_Usuario= Tipo_Usuario;
		
	}

	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getTipo_Usuario() {
		return Tipo_Usuario;
	}

	public void setTipo_Usuario(String tipo_Usuario) {
		Tipo_Usuario = tipo_Usuario;
	}

}
