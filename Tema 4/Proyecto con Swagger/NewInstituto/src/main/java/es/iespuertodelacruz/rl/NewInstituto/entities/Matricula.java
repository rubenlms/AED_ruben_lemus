package es.iespuertodelacruz.rl.NewInstituto.entities;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(position = 2)
	private int idmatricula;

	@ApiModelProperty(position = 1)
	private int year;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="dni")
	@ApiModelProperty(position = 0)
	private Alumno alumno;

	public Matricula() {
	}

	public int getIdmatricula() {
		return this.idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}