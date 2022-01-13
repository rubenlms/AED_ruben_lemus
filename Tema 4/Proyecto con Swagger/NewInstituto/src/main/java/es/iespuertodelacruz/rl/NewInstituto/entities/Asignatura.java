package es.iespuertodelacruz.rl.NewInstituto.entities;

import java.io.Serializable;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the asignaturas database table.
 * 
 */
@Entity
@Table(name="asignaturas")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(position = 3)
	private int idasignatura;
	
	@ApiModelProperty(position = 0)
	private String curso;
	
	@ApiModelProperty(position = 1)
	private String nombre;

	public Asignatura() {
	}

	public int getIdasignatura() {
		return this.idasignatura;
	}

	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}