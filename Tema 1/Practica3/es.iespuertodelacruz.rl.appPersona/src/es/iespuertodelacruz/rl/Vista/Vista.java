/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Vista;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Vista {
    
    public String pedirRuta(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la ruta del fichero: ");
        String rutaFile = sc.nextLine();

        return rutaFile;
    }
    
    public void mostrarFichero(File f){
        
    }
    
    public void saludo(){
        System.out.println("HOLA!");
    }
    
}
