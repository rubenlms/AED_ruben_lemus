package main;

import java.sql.SQLException;
import java.util.Scanner;

import es.iespuertodelacruz.rl.modelo.GestorLapices;
import es.iespuertodelacruz.rl.modelo.Lapiz;

public class Main {
	
	private static  void cargarDriverMysql(){
	      try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch(ClassNotFoundException ex) {
	        System.err.println("no carga el driver");
	        System.exit(1);
	      }        
	    }  

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		GestorLapices gl = new GestorLapices("oficina","root","");
		
		System.out.print("Introduzca el id del Lapiz a actualizar:");
		int idUpdate = sc.nextInt();
		Lapiz l = gl.findbyID(idUpdate);
		gl.update(l);
		
		System.out.print("Introduzca el id del Lapiz a ELIMINAR:");
		int idDelete = sc.nextInt();
		gl.delete(idDelete);

	}

}
