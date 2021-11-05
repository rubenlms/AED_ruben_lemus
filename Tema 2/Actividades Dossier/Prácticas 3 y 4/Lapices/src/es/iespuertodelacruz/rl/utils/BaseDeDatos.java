package es.iespuertodelacruz.rl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
	
	String nameDB;
	String user;
	String password;
	
	private static void cargarDriverMysql(){
	      try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch(ClassNotFoundException ex) {
	        System.err.println("no carga el driver");
	        System.exit(1);
	      }        
	    }  
	
	/**
	 * Constructor
	 * @param nameDB
	 * @param user
	 * @param password
	 */
	public BaseDeDatos(String nameDB, String user, String password) {
		this.nameDB = nameDB;
		this.user = user;
		this.password = password;
		cargarDriverMysql();
	}
	
	/**
	 * Crea la conexión a la BBDD y la devuelve
	 * @return
	 */
	public Connection getConection() {
		
		Connection conexion = null;
        try {
            conexion = DriverManager.getConnection( 
                    "jdbc:mysql://localhost/" + nameDB + "oficina?serverTimezone=UTC",user,password);

        } catch (SQLException ex) { ex.printStackTrace(); 
        	}
        return conexion;
	}
	

}
