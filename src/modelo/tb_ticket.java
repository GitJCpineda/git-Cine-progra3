package modelo;

public class tb_ticket {

	int id_Ticket;
	int id_Funcion;
	int id_Tipo_Pago;
	int id_Cliente;
	int id_Posteo_Empleado;
	String Fecha_Compra;
	int id_Sucursal;
	int id_Tipo;
	int id_Asiento;
	int id_Costo;
	int tb_Funcion_id_Funcion;
	int tb_Funcion_tb_Pelicula_id_Pelicula;
	int tb_Cliente_id_Cliente;
	int tb_Costo_id_Costo;
	int tb_Tipo_Pago_id_Tipo_Pago;
	int tb_Tipo_Ticket_id_Tipo;
	int tb_Empleado_id_Empleado;
	int tb_Asiento_id_Asiento;
	int tb_Sucursal_id_Sucursal;
	int tb_Sucursal_tb_Departamento_id_Departamento;

	public tb_ticket() {

	}

	public tb_ticket(int id_Ticket, int id_Funcion, int id_Tipo_Pago, int id_Cliente, int id_Posteo_Empleado,
			String Fecha_Compra, int id_Sucursal, int id_Tipo, int id_Asiento, int id_Costo, int tb_Funcion_id_Funcion,
			int tb_Funcion_tb_Pelicula_id_Pelicula, int tb_Cliente_id_Cliente, int tb_Costo_id_Costo,
			int tb_Tipo_Pago_id_Tipo_Pago, int tb_Tipo_Ticket_id_Tipo, int tb_Empleado_id_Empleado,
			int tb_Asiento_id_Asiento, int tb_Sucursal_id_Sucursal, int tb_Sucursal_tb_Departamento_id_Departamento) {

		this.id_Ticket = id_Ticket;
		this.id_Funcion = id_Funcion;
		this.id_Tipo_Pago = id_Tipo_Pago;
		this.id_Cliente = id_Cliente;
		this.id_Posteo_Empleado = id_Posteo_Empleado;
		this.Fecha_Compra = Fecha_Compra;
		this.id_Sucursal = id_Sucursal;
		this.id_Tipo = id_Tipo;
		this.id_Asiento = id_Asiento;
		this.id_Costo = id_Costo;
		this.tb_Funcion_id_Funcion = tb_Funcion_id_Funcion;
		this.tb_Funcion_tb_Pelicula_id_Pelicula = tb_Funcion_tb_Pelicula_id_Pelicula;
		this.tb_Cliente_id_Cliente = tb_Cliente_id_Cliente;
		this.tb_Costo_id_Costo = tb_Costo_id_Costo;
		this.tb_Tipo_Pago_id_Tipo_Pago = tb_Tipo_Pago_id_Tipo_Pago;
		this.tb_Tipo_Ticket_id_Tipo = tb_Tipo_Ticket_id_Tipo;
		this.tb_Empleado_id_Empleado = tb_Empleado_id_Empleado;
		this.tb_Asiento_id_Asiento = tb_Asiento_id_Asiento;
		this.tb_Sucursal_id_Sucursal = tb_Sucursal_id_Sucursal;
		this.tb_Sucursal_tb_Departamento_id_Departamento = tb_Sucursal_tb_Departamento_id_Departamento;

	}

	public int getId_Ticket() {
		return id_Ticket;
	}

	public void setId_Ticket(int id_Ticket) {
		this.id_Ticket = id_Ticket;
	}

	public int getId_Funcion() {
		return id_Funcion;
	}

	public void setId_Funcion(int id_Funcion) {
		this.id_Funcion = id_Funcion;
	}

	public int getId_Tipo_Pago() {
		return id_Tipo_Pago;
	}

	public void setId_Tipo_Pago(int id_Tipo_Pago) {
		this.id_Tipo_Pago = id_Tipo_Pago;
	}

	public int getId_Cliente() {
		return id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}

	public int getId_Posteo_Empleado() {
		return id_Posteo_Empleado;
	}

	public void setId_Posteo_Empleado(int id_Posteo_Empleado) {
		this.id_Posteo_Empleado = id_Posteo_Empleado;
	}

	public String getFecha_Compra() {
		return Fecha_Compra;
	}

	public void setFecha_Compra(String fecha_Compra) {
		Fecha_Compra = fecha_Compra;
	}

	public int getId_Sucursal() {
		return id_Sucursal;
	}

	public void setId_Sucursal(int id_Sucursal) {
		this.id_Sucursal = id_Sucursal;
	}

	public int getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(int id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public int getId_Asiento() {
		return id_Asiento;
	}

	public void setId_Asiento(int id_Asiento) {
		this.id_Asiento = id_Asiento;
	}

	public int getId_Costo() {
		return id_Costo;
	}

	public void setId_Costo(int id_Costo) {
		this.id_Costo = id_Costo;
	}

	public int getTb_Funcion_id_Funcion() {
		return tb_Funcion_id_Funcion;
	}

	public void setTb_Funcion_id_Funcion(int tb_Funcion_id_Funcion) {
		this.tb_Funcion_id_Funcion = tb_Funcion_id_Funcion;
	}

	public int getTb_Funcion_tb_Pelicula_id_Pelicula() {
		return tb_Funcion_tb_Pelicula_id_Pelicula;
	}

	public void setTb_Funcion_tb_Pelicula_id_Pelicula(int tb_Funcion_tb_Pelicula_id_Pelicula) {
		this.tb_Funcion_tb_Pelicula_id_Pelicula = tb_Funcion_tb_Pelicula_id_Pelicula;
	}

	public int getTb_Cliente_id_Cliente() {
		return tb_Cliente_id_Cliente;
	}

	public void setTb_Cliente_id_Cliente(int tb_Cliente_id_Cliente) {
		this.tb_Cliente_id_Cliente = tb_Cliente_id_Cliente;
	}

	public int getTb_Costo_id_Costo() {
		return tb_Costo_id_Costo;
	}

	public void setTb_Costo_id_Costo(int tb_Costo_id_Costo) {
		this.tb_Costo_id_Costo = tb_Costo_id_Costo;
	}

	public int getTb_Tipo_Pago_id_Tipo_Pago() {
		return tb_Tipo_Pago_id_Tipo_Pago;
	}

	public void setTb_Tipo_Pago_id_Tipo_Pago(int tb_Tipo_Pago_id_Tipo_Pago) {
		this.tb_Tipo_Pago_id_Tipo_Pago = tb_Tipo_Pago_id_Tipo_Pago;
	}

	public int getTb_Tipo_Ticket_id_Tipo() {
		return tb_Tipo_Ticket_id_Tipo;
	}

	public void setTb_Tipo_Ticket_id_Tipo(int tb_Tipo_Ticket_id_Tipo) {
		this.tb_Tipo_Ticket_id_Tipo = tb_Tipo_Ticket_id_Tipo;
	}

	public int getTb_Empleado_id_Empleado() {
		return tb_Empleado_id_Empleado;
	}

	public void setTb_Empleado_id_Empleado(int tb_Empleado_id_Empleado) {
		this.tb_Empleado_id_Empleado = tb_Empleado_id_Empleado;
	}

	public int getTb_Asiento_id_Asiento() {
		return tb_Asiento_id_Asiento;
	}

	public void setTb_Asiento_id_Asiento(int tb_Asiento_id_Asiento) {
		this.tb_Asiento_id_Asiento = tb_Asiento_id_Asiento;
	}

	public int getTb_Sucursal_id_Sucursal() {
		return tb_Sucursal_id_Sucursal;
	}

	public void setTb_Sucursal_id_Sucursal(int tb_Sucursal_id_Sucursal) {
		this.tb_Sucursal_id_Sucursal = tb_Sucursal_id_Sucursal;
	}

	public int getTb_Sucursal_tb_Departamento_id_Departamento() {
		return tb_Sucursal_tb_Departamento_id_Departamento;
	}

	public void setTb_Sucursal_tb_Departamento_id_Departamento(int tb_Sucursal_tb_Departamento_id_Departamento) {
		this.tb_Sucursal_tb_Departamento_id_Departamento = tb_Sucursal_tb_Departamento_id_Departamento;
	}

}