package modelo;

public class tb_sucursal {
	
	int id_Sucursal;
	int id_Ubicacion;
	String Nombre_Sucursal;
	String Direccion;
	int tb_Departamento_id_Departamento;
	
	public tb_sucursal() {
		
	}
	
	public tb_sucursal(int id_Sucursal, int id_Ubicacion,String Nombre_Sucursal,String Direccion,int tb_Departamento_id_Departamento) {
		
		this.id_Sucursal= id_Sucursal;
		this.id_Ubicacion= id_Ubicacion;
		this.Nombre_Sucursal= Nombre_Sucursal;
		this.Direccion= Direccion;
		this.tb_Departamento_id_Departamento= tb_Departamento_id_Departamento;
		
	}

	public int getId_Sucursal() {
		return id_Sucursal;
	}

	public void setId_Sucursal(int id_Sucursal) {
		this.id_Sucursal = id_Sucursal;
	}

	public int getId_Ubicacion() {
		return id_Ubicacion;
	}

	public void setId_Ubicacion(int id_Ubicacion) {
		this.id_Ubicacion = id_Ubicacion;
	}

	public String getNombre_Sucursal() {
		return Nombre_Sucursal;
	}

	public void setNombre_Sucursal(String nombre_Sucursal) {
		Nombre_Sucursal = nombre_Sucursal;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public int getTb_Departamento_id_Departamento() {
		return tb_Departamento_id_Departamento;
	}

	public void setTb_Departamento_id_Departamento(int tb_Departamento_id_Departamento) {
		this.tb_Departamento_id_Departamento = tb_Departamento_id_Departamento;
	}
	
	
	
	
	
	
}
