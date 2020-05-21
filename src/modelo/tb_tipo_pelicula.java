package modelo;

public class tb_tipo_pelicula {
	
	int id_Tipo;
	String Genero;
	String Descripcion;
	int tb_Pelicula_id_Pelicula;
	
	
	public tb_tipo_pelicula() {
		
	}
	
	public tb_tipo_pelicula(int id_Tipo, String Genero,String Descripcion, int tb_Pelicula_id_Pelicula) {
		
		this.id_Tipo=id_Tipo;
		this.Genero=Genero;
		this.Descripcion=Descripcion;
		this.tb_Pelicula_id_Pelicula= tb_Pelicula_id_Pelicula;
		
	}

	public int getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(int id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getTb_Pelicula_id_Pelicula() {
		return tb_Pelicula_id_Pelicula;
	}

	public void setTb_Pelicula_id_Pelicula(int tb_Pelicula_id_Pelicula) {
		this.tb_Pelicula_id_Pelicula = tb_Pelicula_id_Pelicula;
	}
	
	

	
}
