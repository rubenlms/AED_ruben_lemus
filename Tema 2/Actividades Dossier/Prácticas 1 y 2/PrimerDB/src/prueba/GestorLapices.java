package prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Utils.MiBaseDeDatos;
import modelo.Lapiz;

public class GestorLapices {
	
	MiBaseDeDatos bd;
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contraseña.
	 * @param db
	 * @param user
	 * @param password
	 */
	public GestorLapices(String db, String user, String password) {
		this.bd = new MiBaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor solo con la BBDD
	 * @param bd
	 */
	public GestorLapices(MiBaseDeDatos bd) {
		this.bd = bd;
	}
	
	/**
	 * Devuelve un ArrayList con todos los elementos de la BBDD
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Lapiz> leerTodo() throws SQLException{
		
		ArrayList<Lapiz>lapices = new ArrayList();
		Connection conexion = bd.getConection(); //para tener los valores de la bbdd
		
		Statement s = conexion.createStatement(); //crea la consulta
        String sql = "select * from lapices";
        ResultSet rs = s.executeQuery(sql); //lanza la consulta 
        
        while(rs.next()){
        	int id = rs.getInt("idlapiz");
        	String marca = rs.getString("marca");
        	int numero = rs.getInt("numero");
        	Lapiz lpz = new Lapiz(id, marca, numero);
        	lapices.add(lpz);
        	}
        s.close();
        conexion.close();
        
		return lapices;
		
	}
    
	/**
	 * Devuelve un ArrayList con todos los elementos de la BBDD cuya marca sea la introducida por parámetro
	 * @param marcaBusqueda
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Lapiz> leerbyMarca(String marcaBusqueda) throws SQLException{
    		
    		ArrayList<Lapiz>lapices = new ArrayList();
    		Connection conexion = bd.getConection();
    		
    		Statement s = conexion.createStatement();
            String sql = "select * from lapices"
            		+ " where marca like " + marcaBusqueda;
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
            	int id = rs.getInt("idlapiz");
            	String marca = rs.getString("marca");
            	int numero = rs.getInt("numero");
            	Lapiz lpz = new Lapiz(id, marca, numero);
            	lapices.add(lpz);
            }
        
        s.close();
        conexion.close();
		
		return lapices;
	}

}
