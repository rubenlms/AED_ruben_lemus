package es.iespuertodelacruz.rl.NewInstituto.dto;

import es.iespuertodelacruz.rl.NewInstituto.entities.Asignatura;

public class AsignaturaDTO {
	
	private int idasignatura;

	private String curso;

	private String nombre;

	public AsignaturaDTO(Asignatura a) {
		super();
		this.idasignatura = a.getIdasignatura();
		this.curso = a.getCurso();
		this.nombre = a.getNombre();
	}

	public int getIdasignatura() {
		return idasignatura;
	}

	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
