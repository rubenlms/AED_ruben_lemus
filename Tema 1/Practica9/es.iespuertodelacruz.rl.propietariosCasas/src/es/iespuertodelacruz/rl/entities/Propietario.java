/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author ruben
 */
@XmlRootElement(name="casa")
public class Propietario implements Serializable {
    
    String nombre;
    int edad;

    public Propietario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Propietario(){}

    public String getNombre() {
        return nombre;
    }
    
    @XmlElement(name="nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    @XmlElement(name="edad")
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}
