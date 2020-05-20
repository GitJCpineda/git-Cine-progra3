package modelo;

public class tb_costo {

	int id_Costo;
	String Nombre;
	float Valor;
	
	public tb_costo() {
		
	}
	
	public tb_costo(int id_Costo, String Nombre, float Valor) {
		
		this.id_Costo=id_Costo;
		this.Nombre= Nombre;
		this.Valor= Valor;
		
	}

	public int getId_Costo() {
		return id_Costo;
	}

	public void setId_Costo(int id_Costo) {
		this.id_Costo = id_Costo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public float getValor() {
		return Valor;
	}

	public void setValor(float valor) {
		Valor = valor;
	}
	
	
	
	
}
