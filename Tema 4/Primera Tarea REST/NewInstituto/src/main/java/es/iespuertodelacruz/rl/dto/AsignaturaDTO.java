package es.iespuertodelacruz.rl.dto;

public class AsignaturaDTO {
	
	private int idasignatura;

	private String curso;

	private String nombre;

	public AsignaturaDTO(int idasignatura, String curso, String nombre) {
		super();
		this.idasignatura = idasignatura;
		this.curso = curso;
		this.nombre = nombre;
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
