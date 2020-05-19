package modelo;

public class tb_empleado {
	
	int id_Empleado;
	String Jefe;
	int id_Cargo;
	String Nombre_Empleado;
	String Apellido_Empleado;
	String Identidad_Empleado;
	String Fecha_Ingreso;
	float Salario;
	int tb_Empleados_id_Sucursal;
	int tb_Empleados_id_Empleado;
	int tb_Empleados_tb_Sucursal_id_Sucursal;
	int tb_Usuarios_id_Usuario;
	int tb_Tipo_Cargo_Id_Tipo_Cargo;
	
	public tb_empleado() {
		
	}
	
	public tb_empleado(int id_Empleado, String Jefe, int id_Cargo, String Nombre_Empleado,String Apellido_Empleado, String Identidad_Empleado, String Fecha_Ingreso, float Salario,int tb_Empleados_id_Sucursal,int tb_Empleados_id_Empleado,int tb_Empleados_tb_Sucursal_id_Sucursal,int tb_Usuarios_id_Usuario,int tb_Tipo_Cargo_Id_Tipo_Cargo) {
		
		this.id_Empleado= id_Empleado;
		this.Jefe=Jefe;
		this.id_Cargo= id_Cargo;
		this.Nombre_Empleado= Nombre_Empleado;
		this.Apellido_Empleado= Apellido_Empleado;
		this.Identidad_Empleado= Identidad_Empleado;
		this.Fecha_Ingreso= Fecha_Ingreso;
		this.Salario= Salario;
		this.tb_Empleados_id_Sucursal= tb_Empleados_id_Sucursal;
		this.tb_Empleados_id_Empleado= tb_Empleados_id_Empleado;
		this.tb_Empleados_tb_Sucursal_id_Sucursal= tb_Empleados_tb_Sucursal_id_Sucursal;
		this.tb_Usuarios_id_Usuario=tb_Usuarios_id_Usuario;
		this.tb_Tipo_Cargo_Id_Tipo_Cargo=tb_Tipo_Cargo_Id_Tipo_Cargo;	
		
	}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public String getJefe() {
		return Jefe;
	}

	public void setJefe(String jefe) {
		Jefe = jefe;
	}

	public int getId_Cargo() {
		return id_Cargo;
	}

	public void setId_Cargo(int id_Cargo) {
		this.id_Cargo = id_Cargo;
	}

	public String getNombre_Empleado() {
		return Nombre_Empleado;
	}

	public void setNombre_Empleado(String nombre_Empleado) {
		Nombre_Empleado = nombre_Empleado;
	}

	public String getApellido_Empleado() {
		return Apellido_Empleado;
	}

	public void setApellido_Empleado(String apellido_Empleado) {
		Apellido_Empleado = apellido_Empleado;
	}

	public String getIdentidad_Empleado() {
		return Identidad_Empleado;
	}

	public void setIdentidad_Empleado(String identidad_Empleado) {
		Identidad_Empleado = identidad_Empleado;
	}

	public String getFecha_Ingreso() {
		return Fecha_Ingreso;
	}

	public void setFecha_Ingreso(String fecha_Ingreso) {
		Fecha_Ingreso = fecha_Ingreso;
	}

	public float getSalario() {
		return Salario;
	}

	public void setSalario(float salario) {
		Salario = salario;
	}

	public int getTb_Empleados_id_Sucursal() {
		return tb_Empleados_id_Sucursal;
	}

	public void setTb_Empleados_id_Sucursal(int tb_Empleados_id_Sucursal) {
		this.tb_Empleados_id_Sucursal = tb_Empleados_id_Sucursal;
	}

	public int getTb_Empleados_id_Empleado() {
		return tb_Empleados_id_Empleado;
	}

	public void setTb_Empleados_id_Empleado(int tb_Empleados_id_Empleado) {
		this.tb_Empleados_id_Empleado = tb_Empleados_id_Empleado;
	}

	public int getTb_Empleados_tb_Sucursal_id_Sucursal() {
		return tb_Empleados_tb_Sucursal_id_Sucursal;
	}

	public void setTb_Empleados_tb_Sucursal_id_Sucursal(int tb_Empleados_tb_Sucursal_id_Sucursal) {
		this.tb_Empleados_tb_Sucursal_id_Sucursal = tb_Empleados_tb_Sucursal_id_Sucursal;
	}

	public int getTb_Usuarios_id_Usuario() {
		return tb_Usuarios_id_Usuario;
	}

	public void setTb_Usuarios_id_Usuario(int tb_Usuarios_id_Usuario) {
		this.tb_Usuarios_id_Usuario = tb_Usuarios_id_Usuario;
	}

	public int getTb_Tipo_Cargo_Id_Tipo_Cargo() {
		return tb_Tipo_Cargo_Id_Tipo_Cargo;
	}

	public void setTb_Tipo_Cargo_Id_Tipo_Cargo(int tb_Tipo_Cargo_Id_Tipo_Cargo) {
		this.tb_Tipo_Cargo_Id_Tipo_Cargo = tb_Tipo_Cargo_Id_Tipo_Cargo;
	}
	
	
	

}








