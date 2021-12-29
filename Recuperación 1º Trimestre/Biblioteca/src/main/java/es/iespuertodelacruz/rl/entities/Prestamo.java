package es.iespuertodelacruz.rl.entities;

import java.sql.Date;

public class Prestamo {
	
	int id;
	int id_ejemplar;
	Date fecha_prestamo;
	Date fecha_devolucion;
	
	public Prestamo(int id, int id_ejemplar, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.id = id;
		this.id_ejemplar = id_ejemplar;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_ejemplar() {
		return id_ejemplar;
	}

	public void setId_ejemplar(int id_ejemplar) {
		this.id_ejemplar = id_ejemplar;
	}

	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}

	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	
}
