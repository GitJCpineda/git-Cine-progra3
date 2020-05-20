package modelo;

public class tb_funcion {
	
	int id_Funcion;
	int id_Sala;
	int id_Pelicula;
	String Horario;
	int tb_Pelicula_id_Pelicula;
	int tb_Sala_id_Sala;
	
	
	public tb_funcion() {
		
	}
	
	public tb_funcion(int id_Funcion, int id_Sala, int id_Pelicula, String Horario,int tb_Pelicula_id_Pelicula,int tb_Sala_id_Sala) {
		
		this.id_Funcion= id_Funcion;
		this.id_Sala= id_Sala;
		this.id_Pelicula= id_Pelicula;
		this.Horario= Horario;
		this.tb_Pelicula_id_Pelicula= tb_Pelicula_id_Pelicula;
		this.tb_Sala_id_Sala= tb_Sala_id_Sala;
		
		
		
	}

	public int getId_Funcion() {
		return id_Funcion;
	}

	public void setId_Funcion(int id_Funcion) {
		this.id_Funcion = id_Funcion;
	}

	public int getId_Sala() {
		return id_Sala;
	}

	public void setId_Sala(int id_Sala) {
		this.id_Sala = id_Sala;
	}

	public int getId_Pelicula() {
		return id_Pelicula;
	}

	public void setId_Pelicula(int id_Pelicula) {
		this.id_Pelicula = id_Pelicula;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}

	public int getTb_Pelicula_id_Pelicula() {
		return tb_Pelicula_id_Pelicula;
	}

	public void setTb_Pelicula_id_Pelicula(int tb_Pelicula_id_Pelicula) {
		this.tb_Pelicula_id_Pelicula = tb_Pelicula_id_Pelicula;
	}

	public int getTb_Sala_id_Sala() {
		return tb_Sala_id_Sala;
	}

	public void setTb_Sala_id_Sala(int tb_Sala_id_Sala) {
		this.tb_Sala_id_Sala = tb_Sala_id_Sala;
	}
	
	
	

}
