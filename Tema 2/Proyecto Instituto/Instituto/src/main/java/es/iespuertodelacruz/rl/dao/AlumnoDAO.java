package es.iespuertodelacruz.rl.dao;

import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import es.iespuertodelacruz.rl.entities.Alumno;

public class AlumnoDAO implements CRUD<Alumno, String>{
	
	BaseDeDatos bd;
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contrase�a.
	 * @param db
	 * @param user
	 * @param password
	 */
	public AlumnoDAO(String db, String user, String password) {
		this.bd = new BaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor solo con la BBDD
	 * @param bd
	 */
	public AlumnoDAO(BaseDeDatos bd) {
		this.bd = bd;
	}
	
	/**
	 * Busca a un alumno a través de su DNI
	 */
	@Override
	public Alumno findbyID(String id) {
		Alumno alumno=null;
		
		String sql = "SELECT dni, nombre, apellidos, fechanacimiento FROM alumnos"
        		+ " WHERE dni LIKE ?";
		
		try (
		Connection conexion = bd.getConection();
        PreparedStatement ps = conexion.prepareStatement(sql);
		)
		
		{	
			ps.setInt(1, Integer.parseInt(id)); 
			ResultSet rs = ps.executeQuery(sql);
	        
	        while(rs.next()){
	        	String dni = rs.getString("dni");
	        	String nombre = rs.getString("nombre");
	        	String apellidos = rs.getString("apellidos");
	        	Date fechaNacimiento = rs.getDate("fechanacimiento");
	        	alumno = new Alumno(dni, nombre, apellidos, fechaNacimiento, null);//arraylist null?
	        }
	    
		} catch(SQLException e) {}
	
		return alumno;
	}
	
	/**
	 * Devuelve todos los alumnos registrados en la BBDD
	 */
	@Override
	public List<Alumno> findAll() {
		
		ArrayList<Alumno>alumnos = new ArrayList();
		
		String sql = "SELECT dni, nombre, apellidos, fechanacimiento FROM alumnos";
		
		try (
		Connection conexion = bd.getConection(); 
        PreparedStatement ps = conexion.prepareStatement(sql);
			)
			{
			ResultSet rs = ps.executeQuery(sql); 
	        
	        while(rs.next()){
	        	String dni = rs.getString("dni");
	        	String nombre = rs.getString("nombre");
	        	String apellidos = rs.getString("apellidos");
	        	Date fechaNacimiento = rs.getDate("fechanacimiento");
	        	Alumno alumno = new Alumno(dni, nombre, apellidos, fechaNacimiento, null); //arraylist?
	        	alumnos.add(alumno);
	        	}
	        
		} catch (SQLException e) {}
		
		return alumnos;
	}
	
	/**
	 * Registra un nuevo alumno en la BBDD
	 */
	@Override
	public Alumno save(Alumno obj) {
		
		Alumno savedAlumno = null;
		
		String sql = "INSERT INTO alumnos (dni, nombre, apellidos, fechanacimiento) " 
				+ "VALUES (?,?,?,?)";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);
			)
		{
			
			ps.setString(1, obj.getDni());
			ps.setString(2, obj.getNombre());
			ps.setString(3, obj.getApellidos());
			ps.setDate(4, obj.getFechaNacimiento());
			
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				savedAlumno.setDni(obj.getDni());
				savedAlumno.setNombre(obj.getNombre());
				savedAlumno.setApellidos(obj.getApellidos());
				savedAlumno.setFechaNacimiento(obj.getFechaNacimiento());
			}
			
		} catch (SQLException e) {}
		
		return savedAlumno;
	}

	@Override
	public boolean update(Alumno obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
