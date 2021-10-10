/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Vista;

import es.iespuertodelacruz.rl.Modelo.Modelo;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Vista {
    
    Scanner sc = new Scanner(System.in);
    
    /**
     * Pide datos de tipo cadena de texto(String)
     * @param datoAsked
     * @return 
     */
    public String pedirString(String datoAsked){
        System.out.print(datoAsked+": ");
        String datoReturn = sc.nextLine();
        return datoReturn;
    }
    
    /**
     * Pide datos de tipo entero(int)
     * @param datoAsked
     * @return 
     */
    public int pedirInt(String datoAsked){
        System.out.println(datoAsked+": ");
        int datoReturn = sc.nextInt();
        return datoReturn;
    }
    
    /**
     * Pide la posición de una persona en el fichero.
     * @param datoAsked
     * @return 
     */
    public long pedirPosicion(String datoAsked){
        System.out.println("Introduce posicion");
        long pos = sc.nextLong();
        return pos;
    }
    
}
