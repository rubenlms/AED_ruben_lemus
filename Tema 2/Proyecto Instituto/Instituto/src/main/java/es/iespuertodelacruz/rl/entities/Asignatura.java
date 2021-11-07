package es.iespuertodelacruz.rl.entities;

import java.util.ArrayList;

public class Asignatura {
	
	int idAsignatura;
	String nombre;
	String curso;
	ArrayList<Alumno>alumnos;
	
	/**
	 * Constructor de la clase asignatura
	 * @param idAsignatura
	 * @param nombre
	 * @param curso
	 * @param alumnos
	 */
	public Asignatura(int idAsignatura, String nombre, String curso, ArrayList<Alumno> alumnos) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.curso = curso;
		this.alumnos = alumnos;
	}
	
	public Asignatura() {}
	
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
	}

	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
