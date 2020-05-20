package modelo;

public class tb_departamento {
	
	int id_Departamento;
	String Nombre_Departamento;
	
	public tb_departamento() {
		
	}
	
	public tb_departamento( int id_Departamento, String Nombre_Departamento) {
		
		this.id_Departamento=id_Departamento;
		this.Nombre_Departamento= Nombre_Departamento;
		
	}

	public int getId_Departamento() {
		return id_Departamento;
	}

	public void setId_Departamento(int id_Departamento) {
		this.id_Departamento = id_Departamento;
	}

	public String getNombre_Departamento() {
		return Nombre_Departamento;
	}

	public void setNombre_Departamento(String nombre_Departamento) {
		Nombre_Departamento = nombre_Departamento;
	}
	
	

}
