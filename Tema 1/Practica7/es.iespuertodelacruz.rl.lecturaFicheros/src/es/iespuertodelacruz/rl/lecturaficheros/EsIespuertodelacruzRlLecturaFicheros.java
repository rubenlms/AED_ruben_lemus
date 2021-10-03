/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dama
 */
public class EsIespuertodelacruzRlLecturaFicheros {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ArrayList<Persona>listaPersonas = new ArrayList();
        
        Path p = Paths.get("personas.txt");
        
        BufferedReader br = Files.newBufferedReader(p);
        
        String persona;

        
        while ( (persona = br.readLine()) !=null ){
        /*
        while ( (Files.readAllLines(p)) !=null ){
        */
            String[]datos = persona.split(";");
            Persona p1 = null;
            
            for (int i = 0; i < datos.length; i++) {
                p1 = new Persona(datos[0], datos[1], Integer.parseInt(datos[2]));
                listaPersonas.add(p1);
            }
            
            
            System.out.println("Nombre: " + p1.getNombre() + "\nDNI: " + p1.getDni() + "\nEdad: " + p1.getEdad());
        }

    }
    
    
    
    
    
}
