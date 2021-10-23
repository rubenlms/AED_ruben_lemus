package es.iespuertodelacruz.rl.JuegoApuestasServlets;

import java.util.TreeMap;
import java.util.ArrayList;

public class Usuario {
	
	String nombre;
	//TreeMap<Integer>apuesta;
	ArrayList<Integer>apuestas;
	
	public Usuario(String nombre, ArrayList<Integer>apuestas) {
		this.nombre = nombre;
		this.apuestas = apuestas;
	}
}
