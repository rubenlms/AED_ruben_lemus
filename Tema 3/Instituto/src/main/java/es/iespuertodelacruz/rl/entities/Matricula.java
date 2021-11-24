package es.iespuertodelacruz.rl.entities;

import java.util.ArrayList;

public class Matricula {
	
	int idMatricula;
	Alumno alumno;
	int year;
	ArrayList<Asignatura>asignaturas;
	
	/**
	 * Constructor de la clase matrícula
	 * @param idMatricula
	 * @param alumno
	 * @param year
	 * @param asignaturas
	 */
	public Matricula(int idMatricula, Alumno alumno, int year, ArrayList<Asignatura> asignaturas) {
		super();
		this.idMatricula = idMatricula;
		this.alumno = alumno;
		this.year = year;
		this.asignaturas = asignaturas;
	}
	
	public Matricula() {}
	
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

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
}
