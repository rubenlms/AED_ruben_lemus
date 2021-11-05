package es.iespuertodelacruz.rl.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertodelacruz.rl.*;
import es.iespuertodelacruz.rl.dao.CRUD;
import es.iespuertodelacruz.rl.utils.BaseDeDatos;
import es.iespuertodelacruz.rl.modelo.Lapiz;

//public class GestorLapices implements CRUD {
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
	 * Devuelve un ArrayList con todos los elementos de la BBDD
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Lapiz> findAll() throws SQLException{
		
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
	 * Devuelve un Lapiz que coincida con el id que le pasa por parï¿½metro
	 * @param idBusqueda
	 * @return objeto Lápiz
	 */
	public Lapiz findbyID(int idBusqueda){
    		
			Lapiz lpz;
			
    		Connection conexion = bd.getConection();
    		
    		Statement s = conexion.createStatement();
            String sql = "SELECT idlapiz, nombre, numero FROM lapices"
            		+ " WHERE idlapiz LIKE " + idBusqueda;
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
            	int id = rs.getInt("idlapiz");
            	String marca = rs.getString("marca");
            	int numero = rs.getInt("numero");
            	lpz = new Lapiz(id, marca, numero);
            }
        
        s.close();
        conexion.close();
		
		return lpz;
	}
	
	/**
	 * Devuelve un objeto Lï¿½piz con las modificaciones que recibe
	 * @param lapizUP
	 * @return status
	 * @throws SQLException
	 */
	public boolean update(Lapiz lapizUP) {
		
		int idLapiz = lapizUP.getIdLapiz();
		String marca = lapizUP.getMarca();
		int numLapiz = lapizUP.getNumero();
		
		System.out.println("VALORES ACTUALES:\n"
				+"ID: " + idLapiz
				+"\nMarca: " + marca
				+"\nN.: " + numLapiz);
		
		System.out.println("INTRODUZCA LOS NUEVOS VALORES: ");
			lapizUP.setMarca(askString("Marca"));
			lapizUP.setNumero(askInt("Nï¿½mero"));
			
    		Connection conexion = bd.getConection();
    		Statement s = conexion.createStatement();
    		boolean status = false; //porque es una consulta de IUD?
    		
    		try {
    			s.executeUpdate("UPDATE oficina "
    					+ "SET marca='"+marca+"', numero="+numLapiz+" "
    					+ "WHERE idLapiz = "+idLapiz+";");
    		} catch (SQLException e) {}

        
        s.close();
        conexion.close();
		
		return status;
	}
	
	/**
	 * Borra en la base de datos el lapiz buscando por el id introducido por parï¿½metro
	 * @param idDelete
	 * @return status
	 */
	public boolean delete(int idDelete) {
			
    		Connection conexion = bd.getConection();
    		Statement s = conexion.createStatement();
    		boolean status = false; //porque es una consulta de IUD?
    		
    		try {
    			s.executeUpdate("DELETE FROM oficina "
    					+ "WHERE idLapiz = "+idDelete+";");
    		} catch (SQLException e) {}

        
        s.close();
        conexion.close();
        
        return status;
		
	}
	
	/**
	 * Recibe un objeto lapiz y lo introduce en la BBDD
	 * @param lapiz
	 * @return
	 */
	public Lapiz save(Lapiz lapiz) {
		
		Lapiz LapizSave;
		
		Connection conexion = bd.getConection();
		Statement s = conexion.createStatement();
		
		try {
			String sql = "INSERT INTO lapices (marca, numero) " 
					+ "VALUES ("+lapiz.getMarca()+", "+lapiz.getNumero()+");";
			s.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rs = s.getGeneratedKeys();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				LapizSave.setIdLapiz(id);
				LapizSave.setMarca(lapiz.getMarca());
				LapizSave.setNumero(lapiz.getNumero());
			}
			
			s.close();
			conexion.close();
			
		} catch (SQLException e) {}
		
		return LapizSave;
	}
	
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
	
	/*
	@Override
	public Object findbyID(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object save(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object id) {
		// TODO Auto-generated method stub
		return false;
	}
	*/

}
