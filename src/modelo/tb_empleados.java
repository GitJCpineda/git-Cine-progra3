package modelo;

public class tb_empleados {
	
	int id_Sucursal;
	int id_Empleado;
	int tb_Sucursal_id_Sucursal;
	
	public tb_empleados() {
		
	}
	
	public tb_empleados(int id_Sucursal, int id_Empleado, int tb_Sucursal_id_Sucursal) {
		
		this.id_Sucursal= id_Sucursal;
		this.id_Empleado= id_Empleado;
		this.tb_Sucursal_id_Sucursal= tb_Sucursal_id_Sucursal;
		
	}

	public int getId_Sucursal() {
		return id_Sucursal;
	}

	public void setId_Sucursal(int id_Sucursal) {
		this.id_Sucursal = id_Sucursal;
	}

	public int getId_Empleado() {
		return id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		this.id_Empleado = id_Empleado;
	}

	public int getTb_Sucursal_id_Sucursal() {
		return tb_Sucursal_id_Sucursal;
	}

	public void setTb_Sucursal_id_Sucursal(int tb_Sucursal_id_Sucursal) {
		this.tb_Sucursal_id_Sucursal = tb_Sucursal_id_Sucursal;
	}
	
	

}
