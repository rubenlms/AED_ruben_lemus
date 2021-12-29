package es.iespuertodelacruz.rl.entities;

public class Libro {
	
	int id;
	String editorial;
	String titulo;
	
	public Libro(int id, String editorial, String titulo) {
		super();
		this.id = id;
		this.editorial = editorial;
		this.titulo = titulo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
