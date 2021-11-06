package es.iespuertodelacruz.rl.entities;

public class AsignaturaEntity {
	
	int idAsignatura;
	String nombre;
	String curso;
	
	/**
	 * Constructor de la Entity Asignatura
	 * @param idAsignatura
	 * @param nombre
	 * @param curso
	 */
	public AsignaturaEntity(int idAsignatura, String nombre, String curso) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	public AsignaturaEntity() {}
	
	/**
	 * Getters y setters
	 * @return
	 */
	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	};

}
