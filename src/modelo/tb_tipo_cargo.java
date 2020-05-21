package modelo;

public class tb_tipo_cargo {

	int Id_Tipo_Cargo;
	String Nombre_Tipo_Cargo;
	String Descripcion;

	public tb_tipo_cargo() {

	}

	public tb_tipo_cargo(int Id_Tipo_Cargo, String Nombre_Tipo_Cargo, String Descripcion) {

		this.Id_Tipo_Cargo = Id_Tipo_Cargo;
		this.Nombre_Tipo_Cargo = Nombre_Tipo_Cargo;
		this.Descripcion = Descripcion;

	}

	public int getId_Tipo_Cargo() {
		return Id_Tipo_Cargo;
	}

	public void setId_Tipo_Cargo(int id_Tipo_Cargo) {
		Id_Tipo_Cargo = id_Tipo_Cargo;
	}

	public String getNombre_Tipo_Cargo() {
		return Nombre_Tipo_Cargo;
	}

	public void setNombre_Tipo_Cargo(String nombre_Tipo_Cargo) {
		Nombre_Tipo_Cargo = nombre_Tipo_Cargo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	

}
