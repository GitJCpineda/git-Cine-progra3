package modelo;

public class tb_salas {
	
	int id_Sucursal;//TomarENCUENTA//NoAUTOINCREMENTAL
	int id_Sala;
	int tb_Sala_id_Sala;
	int tb_Sucursal_id_Sucursal;
	
	public tb_salas() {
		
	}
	
	public tb_salas(int id_Sucursal, int id_Sala, int tb_Sala_id_Sala, int tb_Sucursal_id_Sucursal) {
		
		this.id_Sucursal= id_Sucursal;
		this.id_Sala= id_Sala;
		this.tb_Sala_id_Sala= tb_Sala_id_Sala;
		this.tb_Sucursal_id_Sucursal=tb_Sucursal_id_Sucursal;
		
	}

	public int getId_Sucursal() {
		return id_Sucursal;
	}

	public void setId_Sucursal(int id_Sucursal) {
		this.id_Sucursal = id_Sucursal;
	}

	public int getId_Sala() {
		return id_Sala;
	}

	public void setId_Sala(int id_Sala) {
		this.id_Sala = id_Sala;
	}

	public int getTb_Sala_id_Sala() {
		return tb_Sala_id_Sala;
	}

	public void setTb_Sala_id_Sala(int tb_Sala_id_Sala) {
		this.tb_Sala_id_Sala = tb_Sala_id_Sala;
	}

	public int getTb_Sucursal_id_Sucursal() {
		return tb_Sucursal_id_Sucursal;
	}

	public void setTb_Sucursal_id_Sucursal(int tb_Sucursal_id_Sucursal) {
		this.tb_Sucursal_id_Sucursal = tb_Sucursal_id_Sucursal;
	}
	
	
	

}
