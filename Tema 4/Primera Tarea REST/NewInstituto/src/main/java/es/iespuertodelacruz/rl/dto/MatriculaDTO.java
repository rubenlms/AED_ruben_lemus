package es.iespuertodelacruz.rl.dto;

import es.iespuertodelacruz.rl.entities.Alumno;

public class MatriculaDTO {
	
	private int idmatricula;

	private int year;
	
	private Alumno alumno;

	public MatriculaDTO(int idmatricula, int year, Alumno alumno) {
		super();
		this.idmatricula = idmatricula;
		this.year = year;
		this.alumno.setDni(alumno.getDni());;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
