/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.apppersona;

import es.iespuertodelacruz.rl.Controlador.Controlador;
import es.iespuertodelacruz.rl.Modelo.Modelo;
import es.iespuertodelacruz.rl.Vista.Vista;
import java.io.IOException;

/**
 *
 * @author ruben
 */
public class appPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(modelo, vista);
        
        //controlador.saludar();
        //controlador.crearFichero();
        controlador.mostrarFichero();
    }
    
}
