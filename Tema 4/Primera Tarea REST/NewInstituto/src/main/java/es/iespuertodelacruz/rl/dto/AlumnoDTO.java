package es.iespuertodelacruz.rl.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.rl.entities.Alumno;
import es.iespuertodelacruz.rl.entities.Matricula;

public class AlumnoDTO {
	
	private String dni;

	private String apellidos;

	private BigInteger fechanacimiento;

	private String nombre;
	
	private List<Matricula> matriculas;
	
	private List<Integer>idmatriculas;

	public AlumnoDTO(Alumno a) {
		super();
		this.dni = a.getDni();
		this.nombre = a.getNombre();
		this.apellidos = a.getApellidos();
		this.fechanacimiento = a.getFechanacimiento();
		ArrayList<Integer>matAlumno = new ArrayList<Integer>();
		for(Matricula m : a.getMatriculas()) {
			idmatriculas.add(m.getIdmatricula());
		}
		this.idmatriculas = matAlumno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigInteger getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(BigInteger fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Integer> getIdmatriculas() {
		return idmatriculas;
	}

	public void setIdmatriculas(List<Integer> idmatriculas) {
		this.idmatriculas = idmatriculas;
	}
	
}
