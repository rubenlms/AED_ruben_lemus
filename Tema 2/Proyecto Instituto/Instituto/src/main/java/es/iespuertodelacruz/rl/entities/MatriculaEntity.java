package es.iespuertodelacruz.rl.entities;

public class MatriculaEntity {
	
	int idMatricula;
	String dni;
	int year;
	
	/**
	 * Constructor de la Entity Matrícula
	 * @param idMatricula
	 * @param dni
	 * @param year
	 */
	public MatriculaEntity(int idMatricula, String dni, int year) {
		super();
		this.idMatricula = idMatricula;
		this.dni = dni;
		this.year = year;
	}
	
	public MatriculaEntity() {}
	
	/**
	 * Getters y setters
	 * @return
	 */
	public int getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(int idMatricula) {
		this.idMatricula = idMatricula;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	};
	
}
