package es.iespuertodelacruz.rl.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import es.iespuertodelacruz.rl.*;
import es.iespuertodelacruz.rl.utils.BaseDeDatos;
import modelo.Lapiz;

public class GestorLapices {
	
	BaseDeDatos bd;
	
	/**
	 * Constructor de la clase con la BBDD, el usuario y su contraseña.
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
	 * Devuelve un Lapiz que coincida con el id que le pasa por parámetro
	 * @param marcaBusqueda
	 * @return
	 * @throws SQLException
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
	 * Devuelve un objeto Lápiz con las modificaciones que recibe
	 * @param marcaBusqueda
	 * @return
	 * @throws SQLException
	 */
	public Lapiz update(Lapiz lapizUP) {
		
		int idLapiz = lapizUP.getIdLapiz();
		String marca = lapizUP.getMarca();
		int numLapiz = lapizUP.getNumero();
		
		System.out.println("VALORES ACTUALES:\n"
				+"ID: " + idLapiz
				+"\nMarca: " + marca
				+"\nNº: " + numLapiz);
		
		System.out.println("INTRODUZCA LOS NUEVOS VALORES: ");
			marca = askString("Marca");
			numLapiz = askInt("Número");
			
			Lapiz lapiz = new Lapiz(idLapiz, marca, numLapiz);
			
    		Connection conexion = bd.getConection();
    		Statement s = conexion.createStatement();
    		
    		try {
    			s.executeUpdate("UPDATE oficina "
    					+ "SET marca='"+marca+"', numero='"+numLapiz+"' "
    					+ "WHERE idLapiz = "+idLapiz+";");
    		} catch (SQLException e) {}

        
        s.close();
        conexion.close();
		
		return lapiz;
	}
	
	/**
	 * Borra en la base de datos el lapiz buscando por el id introducido por parámetro
	 * @param marcaBusqueda
	 * @return
	 * @throws SQLException
	 */
	public void delete(int idDelete) {
			
    		Connection conexion = bd.getConection();
    		Statement s = conexion.createStatement();
    		
    		try {
    			s.executeUpdate("DELETE FROM oficina "
    					+ "WHERE idLapiz = "+idDelete+";");
    		} catch (SQLException e) {}

        
        s.close();
        conexion.close();
		
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

}
