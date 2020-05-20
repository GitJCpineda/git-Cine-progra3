package modelo;

public class tb_asiento {

	int id_Asiento;
	int id_Sala;
	int Numero_Asiento;
	int tb_Sala_id_Sala;

	public tb_asiento() {

	}

	public tb_asiento(int id_Asiento, int id_Sala, int Numero_Asiento, int tb_Sala_id_Sala) {

		this.id_Asiento = id_Asiento;
		this.id_Sala = id_Sala;
		this.Numero_Asiento = Numero_Asiento;
		this.tb_Sala_id_Sala = tb_Sala_id_Sala;

	}

	public int getId_Asiento() {
		return id_Asiento;
	}

	public void setId_Asiento(int id_Asiento) {
		this.id_Asiento = id_Asiento;
	}

	public int getId_Sala() {
		return id_Sala;
	}

	public void setId_Sala(int id_Sala) {
		this.id_Sala = id_Sala;
	}

	public int getNumero_Asiento() {
		return Numero_Asiento;
	}

	public void setNumero_Asiento(int numero_Asiento) {
		Numero_Asiento = numero_Asiento;
	}

	public int getTb_Sala_id_Sala() {
		return tb_Sala_id_Sala;
	}

	public void setTb_Sala_id_Sala(int tb_Sala_id_Sala) {
		this.tb_Sala_id_Sala = tb_Sala_id_Sala;
	}

}
