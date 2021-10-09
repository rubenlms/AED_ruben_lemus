/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ruben
 */
public class GestorFichero {
    
    /**
     * Recibe un dni y devuelve todos los datos de la persona que coincide con ese dni.
     * @param dni
     * @return Objeto persona
     * @throws IOException 
     */
    public Persona getPersona(String dni) throws IOException{
        Persona p1 = null;
        
        Path p = Paths.get("personas.txt");
        
        BufferedReader br = Files.newBufferedReader(p);
        
        String persona;

        while ( (persona = br.readLine()) !=null ){

            String[]datos = persona.split(";");
            
            for (int i = 0; i < datos.length; i++) {
                if(datos[1].equals(dni)){
                    p1 = new Persona(datos[0], datos[1], Integer.parseInt(datos[2]));
                }
            }
        }
        
        return (Persona) p1;
    }
    
    /**
     * 
     * @param p 
     */
    public void crearPersona(Persona p){
        String persona = p.getNombre()+";"+p.getDni()+";"+p.getEdad()+"\n";
        
    }
    
    
}
