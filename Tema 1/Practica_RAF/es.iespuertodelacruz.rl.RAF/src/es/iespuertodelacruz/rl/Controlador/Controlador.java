/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Controlador;

import es.iespuertodelacruz.rl.Modelo.Modelo;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.io.IOException;

/**
 *
 * @author ruben
 */
public class Controlador {
    
    Modelo modelo = new Modelo();
    Vista vista = new Vista();

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
    }
    
    /**
     * Pide datos de una persona y llama a la función guardar en formato texto.
     * @throws IOException 
     */
    public void añadirPersonaTexto() throws IOException{
        String nombre = vista.pedirString("Nombre");
        String apellido = vista.pedirString("Apellido");
        int edad = vista.pedirInt("Edad");
        
        modelo.guardarPersonaTexto(nombre,apellido,edad);
    }
    
    /**
     * Pide datos de una persona y llama a la función guardar en Bytes.
     * @throws IOException 
     */
    public void añadirPersonaBytes() throws IOException{
        String nombre = vista.pedirString("Nombre");
        String apellido = vista.pedirString("Apellido");
        int edad = vista.pedirInt("Edad");
        
        modelo.guardarPersonaBytes(nombre, apellido, edad);
    }
    
    /**
     * Pide la posición en la que se encuentra y llama a la función que busca a la persona. 
     *  Se multiplica por 206 ya que es el número fijo de bytes de cada persona.
     * @throws IOException 
     */
    public void buscarPersona() throws IOException{
        long pos = vista.pedirPosicion("Posición que busca: ")*206;
        
        modelo.buscarPersona(pos);
    }
    
}
