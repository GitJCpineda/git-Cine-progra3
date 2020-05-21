package modelo;

public class tb_tipo_ticket {

	int id_Tipo;
	String Nombre_Tipo;
	String Descripcion;

	public tb_tipo_ticket() {

	}

	public tb_tipo_ticket(int id_Tipo, String Nombre_Tipo, String Descripcion) {

		this.id_Tipo = id_Tipo;
		this.Nombre_Tipo = Nombre_Tipo;
		this.Descripcion = Descripcion;

	}

	public int getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(int id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public String getNombre_Tipo() {
		return Nombre_Tipo;
	}

	public void setNombre_Tipo(String nombre_Tipo) {
		Nombre_Tipo = nombre_Tipo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

}
