/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.lecturaficheros;

import java.io.Serializable;

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

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }  
    
    /*
    public Persona getPersona(String dni){
        Persona p = null;
        
        return p;
    }
    
    public void crearPersona(Persona p){
        try (
            PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                    new FileWriter(
                        //true-> para que no sobreescriba
                        //completar método para que cree una persona
                            //hacer un try with resources
                        )
                    )
                )
            )
    }
    
    public ArrayList<Persona>per getPersona(){
    }
        
    }
    */
}
