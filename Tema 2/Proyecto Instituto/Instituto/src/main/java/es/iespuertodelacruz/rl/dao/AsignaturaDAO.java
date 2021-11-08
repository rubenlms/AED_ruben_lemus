package es.iespuertodelacruz.rl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.rl.entities.Alumno;
import es.iespuertodelacruz.rl.entities.Asignatura;

public class AsignaturaDAO implements CRUD<Asignatura, String> {
	
	BaseDeDatos bd;
	
	/**
	 * Constructor de la clase con el nombre de la BBDD, el usuario y su contrase�a.
	 * @param db
	 * @param user
	 * @param password
	 */
	public AsignaturaDAO(String db, String user, String password) {
		this.bd = new BaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor con la BBDD
	 * @param bd
	 */
	public AsignaturaDAO(BaseDeDatos bd) {
		this.bd = bd;
	}

	@Override
	public Asignatura findbyID(String id) {
		
		Asignatura asignatura = null;
		
		String sql = "SELECT idasignatura, nombre, curso FROM asignatura" 
        		+ " WHERE idasignatura LIKE ?";
		
		try (
		Connection conexion = bd.getConection();
        PreparedStatement ps = conexion.prepareStatement(sql);)
		
		{
			
			ps.setInt(1, Integer.parseInt(id)); 
			ResultSet rs = ps.executeQuery(sql);
	        
	        while(rs.next()){
	        	int idAsignatura = rs.getInt("idasignatura");
	        	String nombre = rs.getString("nombre");
	        	String curso = rs.getString("curso");
	        	asignatura = new Asignatura(idAsignatura, nombre, curso, null);
	        }
	    
		} catch(SQLException e) {}
		
		return asignatura;
	}
	
	/**
	 * Devuelve todos los registros de la tabla asignaturas
	 */
	@Override
	public List<Asignatura> findAll() {
		
		ArrayList<Asignatura>asignaturas = new ArrayList();
		
		String sql = "SELECT idasignatura, nombre, curso FROM asignaturas";
		
		try (
		Connection conexion = bd.getConection(); 
        PreparedStatement ps = conexion.prepareStatement(sql);
			)
			{
			ResultSet rs = ps.executeQuery(sql); 
	        
	        while(rs.next()){
	        	int idAsignatura = rs.getInt("idasignatura");
	        	String nombre = rs.getString("nombre");
	        	String curso = rs.getString("curso");
	        	Asignatura asignatura = new Asignatura(idAsignatura, nombre, curso, null); //arraylist?
	        	asignaturas.add(asignatura);
	        	}
	        
		} catch (SQLException e) {}
		
		return asignaturas;
	}
	
	/**
	 * Guarda un nuevo registro en la tabla asignaturas
	 */
	@Override
	public Asignatura save(Asignatura obj) {
		
		Asignatura savedAsignatura = null;
		
		String sql = "INSERT INTO asignatura (idasignatura, nombre, curso) " 
				+ "VALUES (?,?,?)";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);){
			
			ps.setInt(1, obj.getIdAsignatura());//incremental?
			ps.setString(2, obj.getNombre());
			ps.setString(3, obj.getCurso());
			
			
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				savedAsignatura.setIdAsignatura(obj.getIdAsignatura());
				savedAsignatura.setNombre(obj.getNombre());
				savedAsignatura.setCurso(obj.getCurso());
			}
			
		} catch (SQLException e) {}
		
		return savedAsignatura;
	}

	@Override
	public boolean update(Asignatura obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
