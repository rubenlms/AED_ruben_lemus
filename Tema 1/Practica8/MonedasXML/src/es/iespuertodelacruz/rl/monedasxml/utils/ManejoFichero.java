/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.monedasxml.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ruben
 */
public class ManejoFichero {
    
    
    File file;
    
    
    public ManejoFichero(String nombre){
        file = new File(nombre);
    }
    
    public boolean agregarTexto(String texto) throws IOException{
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        bw.write(texto);
        bw.close();
        
        return false;
    }
    
    public boolean borrarYAgregar(String texto){
        return false;    
    }
    
    public String leerTodo() throws IOException {
        //no lee :( 
        System.out.println("Estoy dentro de leer todo");
        Path path = Paths.get(file.getAbsolutePath());
        
        try (BufferedReader br = Files.newBufferedReader(path)){
           
            try {
                String texto;
                while ( (texto = br.readLine() ) !=null){
                    System.out.println(texto);
                }
            } catch (IOException ex){
                System.out.println(ex);
            }

            System.out.println("Existe? "+ file.exists());
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        return null;
    }
    
}
