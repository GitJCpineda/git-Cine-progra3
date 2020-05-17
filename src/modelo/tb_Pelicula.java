package modelo;

public class tb_Pelicula {
	//camposSQL
	int id_Pelicula;
	String Nombre_Pelicula;
	String Descripcion;
	int  Tipo_Pelicula_id_Tipo;
	
	public tb_Pelicula() {
		
	}
	
	public tb_Pelicula(int id_Pelicula, String Nombre_Pelicula, String Descripcion, int Tipo_Pelicula_id_Tipo) {
	
		this.id_Pelicula=id_Pelicula;
		this.Nombre_Pelicula=Nombre_Pelicula;
		this.Descripcion=Descripcion;
		this.Tipo_Pelicula_id_Tipo=Tipo_Pelicula_id_Tipo;
		
	}

	public int getId_Pelicula() {
		return id_Pelicula;
	}

	public void setId_Pelicula(int id_Pelicula) {
		this.id_Pelicula = id_Pelicula;
	}

	public String getNombre_Pelicula() {
		return Nombre_Pelicula;
	}

	public void setNombre_Pelicula(String nombre_Pelicula) {
		Nombre_Pelicula = nombre_Pelicula;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getTipo_Pelicula_id_Tipo() {
		return Tipo_Pelicula_id_Tipo;
	}

	public void setTipo_Pelicula_id_Tipo(int tipo_Pelicula_id_Tipo) {
		Tipo_Pelicula_id_Tipo = tipo_Pelicula_id_Tipo;
	}
	

}
