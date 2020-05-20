package modelo;

public class tb_sala {
	
	int id_Sala;
	int Ubicacion;
	String Nombre_Sala;
	
	public tb_sala() {
		
	}

	public tb_sala(int id_Sala, int Ubicacion,String Nombre_Sala) {
		
		this.id_Sala= id_Sala;
		this.Ubicacion= Ubicacion;
		this.Nombre_Sala= Nombre_Sala;
		
		
	}

	public int getId_Sala() {
		return id_Sala;
	}

	public void setId_Sala(int id_Sala) {
		this.id_Sala = id_Sala;
	}

	public int getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		Ubicacion = ubicacion;
	}

	public String getNombre_Sala() {
		return Nombre_Sala;
	}

	public void setNombre_Sala(String nombre_Sala) {
		Nombre_Sala = nombre_Sala;
	}
	
	
}
