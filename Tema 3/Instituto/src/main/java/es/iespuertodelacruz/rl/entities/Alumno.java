package es.iespuertodelacruz.rl.entities;

import java.sql.Date;
import java.util.ArrayList;

public class Alumno {
	
	String dni;
	String nombre;
	String apellidos;
	Date fechaNacimiento;
	//ArrayList<Matricula>matriculas;
	
	/**
	 * Constructor de la clase Alumno
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param matriculas
	 */
	public Alumno(String dni, String nombre, String apellidos, Date fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Alumno() {}
	
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
