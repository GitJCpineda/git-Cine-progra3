package modelo;

public class tb_cliente {
	
	int id_Cliente;
	String Nombre_Cliente;
	String Identidad_Cliente;
	String Email;
	String Tarjeta_Credito;
	
	public tb_cliente() {
		
	}
	
	public tb_cliente(int id_Cliente, String Nombre_Cliente, String Identidad_Cliente,String Email,String Tarjeta_Credito) {
		
		this.id_Cliente= id_Cliente;
		this.Nombre_Cliente= Nombre_Cliente;
		this.Identidad_Cliente= Identidad_Cliente;
		this.Email= Email;
		this.Tarjeta_Credito= Tarjeta_Credito;
		
	}

	public int getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}

	public String getNombre_Cliente() {
		return Nombre_Cliente;
	}

	public void setNombre_Cliente(String nombre_Cliente) {
		Nombre_Cliente = nombre_Cliente;
	}

	public String getIdentidad_Cliente() {
		return Identidad_Cliente;
	}

	public void setIdentidad_Cliente(String identidad_Cliente) {
		Identidad_Cliente = identidad_Cliente;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTarjeta_Credito() {
		return Tarjeta_Credito;
	}

	public void setTarjeta_Credito(String tarjeta_Credito) {
		Tarjeta_Credito = tarjeta_Credito;
	}
	
	
	

}
