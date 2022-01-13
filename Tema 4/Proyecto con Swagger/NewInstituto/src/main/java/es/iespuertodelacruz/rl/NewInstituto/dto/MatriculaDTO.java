package es.iespuertodelacruz.rl.NewInstituto.dto;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;

public class MatriculaDTO {
	
	private int idmatricula;

	private int year;
	
	private String dniAlumno;

	public MatriculaDTO(Matricula m) {
		super();
		this.idmatricula = m.getIdmatricula();
		this.year = m.getYear();
		this.dniAlumno = m.getAlumno().getDni();
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

	public String getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(String dniAlumno) {
		this.dniAlumno = dniAlumno;
	}
	

}
