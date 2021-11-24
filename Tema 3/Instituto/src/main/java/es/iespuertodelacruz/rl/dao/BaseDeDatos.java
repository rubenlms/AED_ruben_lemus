package es.iespuertodelacruz.rl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

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
	BasicDataSource basicDataSource;
	
	public BaseDeDatos(String nameDB, String user, String password) {
		this.nameDB = "jdbc:mysql://localhost/" + nameDB + "?serverTimezone=UTC";
		this.user = user;
		this.password = password;
		cargarDriverMysql();
		
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl(nameDB);
		
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(password);		
	}
	
	/**
	 * Crea la conexi�n a la BBDD y la devuelve
	 * @return
	 */
	public Connection getConection() {
		
		//synchronized(basicDataSource){ //para que haya concurrencia -> IMPLEMENTAR
		Connection conexion = null;
        try {
            conexion = basicDataSource.getConnection();

        } catch (SQLException ex) { 
        	ex.printStackTrace(); 
        	System.exit(1);
        	}
        return conexion;
	}

}
