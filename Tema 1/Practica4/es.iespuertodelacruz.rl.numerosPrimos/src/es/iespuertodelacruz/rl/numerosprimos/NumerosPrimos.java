/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.numerosprimos;

import es.iespuertodelacruz.rl.numerosprimos.Modelo.GestorFichero;
import java.io.IOException;

/**
 *
 * @author rubenlemusDAM
 */
public class NumerosPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        GestorFichero gf = new GestorFichero();
        System.out.println("Comprobando números primos");
        gf.escribirPrimos();
        
    }
    
}
