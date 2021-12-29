package es.iespuertodelacruz.rl.entities;

public class Ejemplar {
	
	int id;
	String localizacion;
	int id_libro;
	
	public Ejemplar(int id, String localizacion, int id_libro) {
		super();
		this.id = id;
		this.localizacion = localizacion;
		this.id_libro = id_libro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	
}
