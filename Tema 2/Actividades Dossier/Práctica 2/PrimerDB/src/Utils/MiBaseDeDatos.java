package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiBaseDeDatos {
	
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
	public MiBaseDeDatos(String nameDB, String user, String password) {
		this.nameDB = nameDB;
		this.user = user;
		this.password = password;
		cargarDriverMysql();
	}
	
	/**
	 * Crea la conexi�n a la BBDD y la devuelve
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

