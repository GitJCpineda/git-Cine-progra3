package modelo;

public class tb_tipo_pago {
	
	
	int id_Tipo_Pago;
	String Nombre_Tipo_Pago;
	String Descripcion;
	
	public tb_tipo_pago() {
		
	}
	
	public tb_tipo_pago(int id_Tipo_Pago, String Nombre_Tipo_Pago,String Descripcion) {
		
		this.id_Tipo_Pago= id_Tipo_Pago;
		this.Nombre_Tipo_Pago= Nombre_Tipo_Pago;
		this.Descripcion= Descripcion;
		
	}

	public int getId_Tipo_Pago() {
		return id_Tipo_Pago;
	}

	public void setId_Tipo_Pago(int id_Tipo_Pago) {
		this.id_Tipo_Pago = id_Tipo_Pago;
	}

	public String getNombre_Tipo_Pago() {
		return Nombre_Tipo_Pago;
	}

	public void setNombre_Tipo_Pago(String nombre_Tipo_Pago) {
		Nombre_Tipo_Pago = nombre_Tipo_Pago;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	

}
