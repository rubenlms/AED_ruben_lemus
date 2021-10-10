/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Vista;

import es.iespuertodelacruz.rl.Modelo.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Vista {
    
    /**
     * Pide al usuario la ruta del archivo y la devuelve
     * @return 
     */
    public String pedirRuta(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la ruta del fichero: ");
        String rutaFile = sc.nextLine();

        return rutaFile;
    }
    
    /**
     * Muestra el contenido del ArrayList que se le pasa por parámetro
     * @param f
     * @throws IOException 
     */
    public void mostrarFichero(ArrayList<Persona>personas) throws IOException{
        
        for (Persona persona : personas) {
                System.out.println(persona.getNombre()+" "+persona.getDni()+" "+persona.getEdad()+" "+persona.getPeso()+" "+persona.getAltura());
                }
    }

}
