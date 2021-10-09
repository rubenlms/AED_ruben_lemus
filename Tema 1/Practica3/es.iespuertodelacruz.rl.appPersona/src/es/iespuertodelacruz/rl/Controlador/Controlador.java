/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Controlador;

import es.iespuertodelacruz.rl.Modelo.Modelo;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ruben
 */

public class Controlador {

    Modelo modelo;
    Vista vista;
    
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void saludar(){
        vista.saludo();
    }
    
    public void crearFichero() throws IOException{
        File personas = new File(vista.pedirRuta());
        //System.out.println(personas.getAbsolutePath() + " " + personas.getName());
        modelo.llenarFichero(personas);
        
    }
    
    public void mostrarFichero() throws IOException{
        File personas = new File("hola.txt");
        modelo.mostrarFichero(personas);
    }
}
