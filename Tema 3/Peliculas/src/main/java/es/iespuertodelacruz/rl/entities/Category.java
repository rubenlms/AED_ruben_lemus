package es.iespuertodelacruz.rl.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private byte categoryId;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String name;
	/*
	@ManyToMany
	@JoinTable(name=""
	)COPIAR DE LOS APUNTES (P. 27)LA RELACIÓN ENTRE TABLAS DE LAS QUE NO SE IMPORTÓ COMO CLASE
	
	*/
	public Category() {
	}

	public byte getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(byte categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}