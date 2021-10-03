/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author dama
 */
public class Persona implements Serializable {
    
    String nombre;
    String dni;
    int edad;

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
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
    
    public void crearPersona(Persona p){

    }
    
}
