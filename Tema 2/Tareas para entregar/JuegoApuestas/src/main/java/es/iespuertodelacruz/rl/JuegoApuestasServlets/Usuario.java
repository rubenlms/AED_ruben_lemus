package es.iespuertodelacruz.rl.JuegoApuestasServlets;

import java.util.TreeMap;
import java.util.ArrayList;

public class Usuario {
	
	String nombre;
	TreeMap<Long, Integer>apuestas;
	//ArrayList<Integer, long>apuestas;
	
	/*public Usuario(String nombre, ArrayList<Integer>apuestas) {
		this.nombre = nombre;
		this.apuestas = apuestas;
	}*/
	
	public Usuario(String nombre, TreeMap<Long, Integer>apuestas) {
		this.nombre = nombre;
		this.apuestas = apuestas;
	}
	
	
	//borrar apuestas si ya hay ganador
	/*
	fecha = apuestas.get(0) -> coge la fecha de la apuesta 0
	int i=0;
	
	while (fecha < fechaSecreto){
		i++
		fecha = apuestas.get(i);
	}
	apuestas.get(i);
	apuestas.remove(0);
	 */
}
