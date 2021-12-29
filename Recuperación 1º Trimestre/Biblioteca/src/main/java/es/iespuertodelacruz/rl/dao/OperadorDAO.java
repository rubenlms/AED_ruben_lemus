package es.iespuertodelacruz.rl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import es.iespuertodelacruz.rl.entities.Operador;

public class OperadorDAO implements CRUD<Operador, String> {
	
	BaseDeDatos bd;
	
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contrase�a.
	 * @param db
	 * @param user
	 * @param password
	 */
	public OperadorDAO(String db, String user, String password) {
		this.bd = new BaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor solo con la BBDD
	 * @param bd
	 */
	public OperadorDAO(BaseDeDatos bd) {
		this.bd = bd;
	}

	public Operador findbyID(String id) {
		// TODO Auto-generated method stub
		Operador operador=null;
		String sql = "SELECT * FROM operadores WHERE operadorid = ?";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);
				)
				
				{	
					ps.setInt(1, Integer.parseInt(id)); 
					ResultSet rs = ps.executeQuery(sql);
			        
			        while(rs.next()){
			        	int operador_id = rs.getInt("operadorid");
			        	String nick = rs.getString("nick");
			        	String password = rs.getString("password");
			        	operador = new Operador(operador_id, nick, password);
			        }
			    
				} catch(SQLException e) {}
		
		return operador;
	}

	public List<Operador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Operador save(Operador obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Operador obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean checkOperador(String id, String pass) {
		
		Operador operador = null;
		boolean check = false;
		
		String sql = "SELECT * FROM operadores WHERE operadorID = ? AND password LIKE ?";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);
				)
				
				{	
					ps.setInt(1, Integer.parseInt(id));
					ps.setString(2, pass);
					ResultSet rs = ps.executeQuery(sql);
			        
			        while(rs.next()){
			        	int operador_id = rs.getInt("operadorid");
			        	String nick = rs.getString("nick");
			        	String password = rs.getString("password");
			        	operador = new Operador(operador_id, nick, password);
			        	
			        	if(id.equals(String.valueOf(operador_id)) && pass.equals(password)) {
			    			check = true;
			    		}
			        }
			    
				} catch(SQLException e) {}
		
		return check;
	}

}
