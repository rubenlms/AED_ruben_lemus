package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Utils.MiBaseDeDatos;
import modelo.Lapiz;
import prueba.GestorLapices;

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
	
		GestorLapices gl = new GestorLapices("oficina","root","1q2w3e4r");
		
		String busqueda = "Alpino";
		
		for(Lapiz l : gl.leerTodo()) {
			System.out.print(l.getIdLapiz()+" "+l.getMarca()+" "+l.getNumero());
		}
		
		for(Lapiz lpz : gl.leerbyMarca(busqueda)) {
			System.out.print(lpz.getIdLapiz()+" "+lpz.getMarca()+" "+lpz.getNumero());
		}
		
		
	}

}
