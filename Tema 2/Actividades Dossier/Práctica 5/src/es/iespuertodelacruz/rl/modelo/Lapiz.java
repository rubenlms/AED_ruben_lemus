package es.iespuertodelacruz.rl.modelo;

public class Lapiz {
	
	int idLapiz;
	String marca;
	int numero;
	
	
	public Lapiz() {
		
	}

	public Lapiz(int idLapiz, String marca, int numero) {
		super();
		this.idLapiz = idLapiz;
		this.marca = marca;
		this.numero = numero;
	}


	public int getIdLapiz() {
		return idLapiz;
	}


	public void setIdLapiz(int idLapiz) {
		this.idLapiz = idLapiz;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}

}
