/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.raf;

import es.iespuertodelacruz.rl.Controlador.Controlador;
import es.iespuertodelacruz.rl.Modelo.Modelo;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author ruben
 */
public class appPersonasRAF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(modelo, vista);
        
        //controlador.añadirPersonaTexto();
        //controlador.añadirPersonaBytes();
        //controlador.buscarPersona();
    }
    
}
