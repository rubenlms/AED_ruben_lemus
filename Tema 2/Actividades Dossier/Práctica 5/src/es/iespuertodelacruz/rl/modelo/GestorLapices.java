package es.iespuertodelacruz.rl.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.iespuertodelacruz.rl.dao.CRUD;
import es.iespuertodelacruz.rl.utils.BaseDeDatos;

//public class GestorLapices implements CRUD<Lapiz, E> {
public class GestorLapices {
	
	
	BaseDeDatos bd;
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contraseï¿½a.
	 * @param db
	 * @param user
	 * @param password
	 */
	public GestorLapices(String db, String user, String password) {
		this.bd = new BaseDeDatos(db, user, password);
	}
	
	/**
	 * Constructor solo con la BBDD
	 * @param bd
	 */
	public GestorLapices(BaseDeDatos bd) {
		this.bd = bd;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Lapiz findbyID(int id) {
		Lapiz lpz=null;
		
		String sql = "SELECT idlapiz, nombre, numero FROM lapices"
        		+ " WHERE idlapiz LIKE ?";
		
		try (
		Connection conexion = bd.getConection();
        PreparedStatement ps = conexion.prepareStatement(sql);)
		
		{
			
			ps.setInt(1, id); //se le pone la posicion y luego el valor del parámetro
			ResultSet rs = ps.executeQuery(sql);
	        
	        while(rs.next()){
	        	int idNew = rs.getInt("idlapiz");
	        	String marca = rs.getString("marca");
	        	int numero = rs.getInt("numero");
	        	lpz = new Lapiz(idNew, marca, numero);
	        }
	    
	    ps.close();
	    conexion.close();
	    
		} catch(SQLException e) {}
        
		
	
	return lpz;
	}
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Lapiz> findAll() throws SQLException {
		ArrayList<Lapiz>lapices = new ArrayList();
	
		Connection conexion = bd.getConection(); //para tener los valores de la bbdd
		
        String sql = "SELECT idLapiz, marca, numero FROM lapices";
        PreparedStatement ps = conexion.prepareStatement(sql); //lanza la consulta
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
        	int id = rs.getInt("idlapiz");
        	String marca = rs.getString("marca");
        	int numero = rs.getInt("numero");
        	Lapiz lpz = new Lapiz(id, marca, numero);
        	lapices.add(lpz);
        	}
		
        ps.close();
        conexion.close();
        
		return lapices;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public Lapiz save(Lapiz obj) {
		
		Lapiz LapizSave=null;
		
		String sql = "INSERT INTO lapices (idLapiz, marca, numero) " 
				+ "VALUES (?,?,?)";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);){
			
			ps.setInt(1, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(2, obj.getMarca());
			ps.setInt(3, obj.getNumero());
			
			ResultSet rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				LapizSave.setIdLapiz(id);
				LapizSave.setMarca(obj.getMarca());
				LapizSave.setNumero(obj.getNumero());
			}
			
			ps.close();
			conexion.close();
			
		} catch (SQLException e) {}
		
		return LapizSave;
	}

	public boolean update(Lapiz obj) {
		int idLapiz = askInt("idLapiz");
		String marca = askString("Marca");
		int numLapiz = askInt("Numero");
		
		boolean status=false;
		
		String sql = "UPDATE oficina "
				+ "SET idLapiz=?, marca='?', numero=?"
				+ "WHERE idLapiz = ?";
			
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);){
			
			ps.setInt(1, idLapiz);
			ps.setString(2, marca);
			ps.setInt(3, numLapiz);
			ps.setInt(4, obj.getIdLapiz());
			
			ResultSet rs = ps.executeQuery(sql);
			
			ps.close();
			conexion.close();
			
		} catch (SQLException e) {}
		
		return status;
	}

	public boolean delete(int id) {

		boolean status = false; //porque es una consulta de IUD?
		
		String sql = "DELETE FROM oficina "
					+ "WHERE idLapiz = ?";
		
		try (
				Connection conexion = bd.getConection();
		        PreparedStatement ps = conexion.prepareStatement(sql);){
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery(sql);
			
			ps.close();
			conexion.close();
			
		} catch (SQLException e) {}
    
    return status;
	}
	
	/*
	@Override
	public Lapiz findbyID(E id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean delete(E id) {
		// TODO Auto-generated method stub
		return false;
	}
	*/
	
	/**
	 * Pide por teclado un entero y lo devuelve
	 * @param ask
	 * @return
	 */
	public int askInt(String ask) {
		Scanner sc = new Scanner(System.in);
		System.out.print(ask + ": ");
		int valor = sc.nextInt();
		
		return valor;
		
	}
	
	/**
	 * Pide por teclado una cadena de texto y la devuelve
	 * @param ask
	 * @return
	 */
	public String askString(String ask) {
		Scanner sc = new Scanner(System.in);
		System.out.print(ask + ": ");
		String valor = sc.nextLine();
		
		return valor;
	}
	
}
