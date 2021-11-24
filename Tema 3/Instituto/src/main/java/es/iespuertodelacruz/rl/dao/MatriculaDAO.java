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
import es.iespuertodelacruz.rl.entities.Matricula;

public class MatriculaDAO implements CRUD<Matricula, String>{
	
	BaseDeDatos bd;
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contrase�a.
	 * @param db
	 * @param user
	 * @param password
	 */
	public MatriculaDAO(String db, String user, String password) {
		this.bd = new BaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor con la BBDD
	 * @param bd
	 */
	public MatriculaDAO(BaseDeDatos bd) {
		super();
		this.bd = bd;
	}
	
	/**
	 * Encuentra la matrícula a través del ID.
	 */
	@Override
	public Matricula findbyID(String id) {
		
		Matricula matricula=null;
		
		String sql = "SELECT idmatricula, dni, year FROM matriculas"
        		+ " WHERE idmatricula LIKE ?";
		
		String sql2 = "SELECT * FROM alumnos"
				+ " WHERE alumnos.dni LIKE '?'";//HACER LA CONSULTA ENTRE LAS DOS TABLAS PARA OBTENER EL ALUMNO A TRAVES DEL DNI
		
		try (
		Connection conexion = bd.getConection();
        PreparedStatement ps = conexion.prepareStatement(sql);
		)
		
		{	
			ps.setInt(1, Integer.parseInt(id)); 
			ResultSet rs = ps.executeQuery(sql);
	        
	        while(rs.next()){
	        	int idMatricula = rs.getInt("idmatricula");
	        	String dniAlumno = rs.getString("dni");//obj alumno, devolver?
	        	int year = rs.getInt("year");
	        	//falta crear el obj matricula, que se le debe pasar un objeto alumno
	        	//otra consulta?
	        	matricula=new Matricula();
	        }
	    
		} catch(SQLException e) {}
	
		return matricula;
	}
	
	/**
	 * Devuelve todos los registros de la tabla matrículas
	 */
	@Override
	public List<Matricula> findAll() {
		
		ArrayList<Matricula>matriculas = new ArrayList();
		
		String sql = "SELECT idmatricula, dni, year FROM matriculas";
		
		try (
		Connection conexion = bd.getConection(); 
        PreparedStatement ps = conexion.prepareStatement(sql);
			)
			{
			ResultSet rs = ps.executeQuery(sql); 
	        
	        while(rs.next()){
	        	//Falta crear el objeto a devolver
	        	Matricula matricula = new Matricula();
	        	matriculas.add(matricula);
	        	}
	        
		} catch (SQLException e) {}
		
		return matriculas;
	}
	
	/**
	 * Guarda un registro en la tabla matrículas
	 */
	@Override
	public Matricula save(Matricula obj) {
		
		Matricula savedMatricula = null;
		
		//Inserción en la tabla matrículas.
		String sql = "INSERT INTO matriculas () " 
				+ "VALUES (?,?,?)";
		
		//Inserción en la tabla asignatura_matrícula
		String sql2 = "INSERT INTO asignatura_matricula (id, idmatricula, idasignatura)"
				+ "VALUES (?,?,?)";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);
				PreparedStatement ps2 = conexion.prepareStatement(sql2);
		){
			
		if(obj.getAlumno().getDni()==null) {
		
			System.out.print("NO EXISTE EL DNI EN LA BASE DE DATOS"); //ver cómo ponerlo mejor
		
		} else {
			ps.setInt(1, obj.getIdMatricula());
			ps.setString(2, obj.getAlumno().getDni());
			ps.setInt(3, obj.getYear());
			
			ResultSet rs = ps.executeQuery(sql);//cascada?
			//falta la inserción en la tabla asignatura_matricula
			
			while(rs.next()) {
				savedMatricula.setIdMatricula(obj.getIdMatricula());
				Alumno alumnoSaved = new Alumno(
						obj.getAlumno().getDni(),
						obj.getAlumno().getNombre(),
						obj.getAlumno().getApellidos(),
						obj.getAlumno().getFechaNacimiento()
						);
				savedMatricula.setAlumno(alumnoSaved);
				AlumnoDAO alumnoDAO = new AlumnoDAO(bd);
				//alumnoDAO.findbyID()-> se le pasa el dni
				savedMatricula.setYear(obj.getYear());
			}
		}
			
		} catch (SQLException e) {}
		
		return savedMatricula;
	}

	@Override
	public boolean update(Matricula obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
