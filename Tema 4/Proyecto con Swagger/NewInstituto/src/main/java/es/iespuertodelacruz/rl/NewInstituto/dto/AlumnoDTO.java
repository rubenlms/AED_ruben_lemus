package es.iespuertodelacruz.rl.NewInstituto.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.rl.NewInstituto.entities.Alumno;
import es.iespuertodelacruz.rl.NewInstituto.entities.Matricula;
import io.swagger.annotations.ApiModelProperty;

public class AlumnoDTO {
	
	@ApiModelProperty(position = 0)
	private String dni;
	
	@ApiModelProperty(position = 2)
	private String apellidos;
	
	@ApiModelProperty(position = 3)
	private BigInteger fechanacimiento;
	
	@ApiModelProperty(position = 1)
	private String nombre;
	
	@ApiModelProperty(hidden = true)
	private List<Matricula> matriculas;
	
	@ApiModelProperty(position = 4)
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
