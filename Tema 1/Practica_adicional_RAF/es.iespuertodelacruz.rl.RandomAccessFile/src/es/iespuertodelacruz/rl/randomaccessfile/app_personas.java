/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Rubén Lemus 2ºDAM
 */
public class app_personas {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         Gestor g = new Gestor();
        
        RandomAccessFile fichero = fichero = new java.io.RandomAccessFile("personas.txt","rw");
        RandomAccessFile ficheroBytes = ficheroBytes = new java.io.RandomAccessFile("personasBytes.txt", "rw");
        
       
        //g.escribirFicheroTexto(fichero);
        //g.leerFicheroTexto(fichero);
        
        g.escribirFicheroBytes(ficheroBytes);
    }
    
    
}
