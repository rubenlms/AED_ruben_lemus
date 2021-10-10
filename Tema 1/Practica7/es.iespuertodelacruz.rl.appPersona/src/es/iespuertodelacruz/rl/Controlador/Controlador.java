/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Controlador;

import es.iespuertodelacruz.rl.Modelo.DNI;
import es.iespuertodelacruz.rl.Modelo.Modelo;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 * @author ruben
 */

public class Controlador {

    Modelo modelo;
    Vista vista;
    
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    /**
     * Llama al método que llena el fichero.
     * @throws IOException 
     */
    public void crearFichero() throws IOException{
        File personas = new File(vista.pedirRuta());
        //System.out.println(personas.getAbsolutePath() + " " + personas.getName());
        modelo.llenarFichero(personas);
        
    }
    
    /**
     * Muestra el contenido de un fichero.
     * @throws IOException 
     */
    public void mostrarFichero() throws IOException{
        File personas = new File("hola.txt");
        modelo.mostrarFichero(personas);
    }
    
    /**
     * Calcula el IMC a partir del peso y la altura
     * @param peso
     * @param altura
     * @return 
     */
    public String getIMC(int peso, double altura){
        DecimalFormat df = new DecimalFormat("#.00");
        
        double imc = 0;
        
        try {
            imc = peso/Math.pow(altura, 2);
        } catch (NullPointerException ex){
            System.out.println(ex);
        }
        
        return df.format(imc); 
    }
    
    /**
     * Comprueba si el dni que se pasa por parámetro es correcto.
     * @param dni 
     */
    public void comprobarDNI(String dni){
        
    try {
        char letras_dni [] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        DNI dniCheck = new DNI();
        
        String dniNumero = dni.substring(0, dni.length()-1);
        dniCheck.setNumero(Integer.parseInt(dniNumero));
        dniCheck.setLetra(dni.charAt(8));
        
        int calculoLetra = dniCheck.getNumero()%23;
        
        char letraCalculada = letras_dni[calculoLetra];
        
        if (dniCheck.getLetra() == letraCalculada){
            System.out.println("La letra es correcta.");
            } else {
                System.out.println("NO es correcta.");
                }
    
    } catch(NumberFormatException e) {
        System.out.println(e);
        }
    }
}
