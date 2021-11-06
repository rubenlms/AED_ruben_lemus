package es.iespuertodelacruz.rl.entities;

public class AlumnoEntity {
	
	String dni;
	String nombre;
	String apellidos;
	long fechaNacimiento;
	
	/**
	 * Constructor de la Entity Alumno
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 */
	public AlumnoEntity(String dni, String nombre, String apellidos, long fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public AlumnoEntity() {}
	
	/**
	 * Getters y setters 
	 * @return
	 */
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public long getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(long fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	};

}
