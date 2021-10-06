/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.randomaccessfile;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ruben
 */
public class Gestor {
    
    public Gestor(){
    }
    
    /**
     * Escribe texto en el fichero que recibe.
     * @param fichero
     * @throws IOException 
     */
    
    public void escribirFicheroTexto(RandomAccessFile fichero) throws IOException{
        Persona p = new Persona("13572468P", "Luis", 1.86, 80);
        //Persona p = new Persona("24681357S", "Ana", 1.70, 60);
        
        try{
           
           long pos = fichero.getFilePointer();
           
           if (fichero.length()>=pos){
               fichero.seek(pos);
               String datosPersona = p.getDni() + ";" + p.getNombre()+ ";" + p.getAltura() + ";" + p.getPeso();
               fichero.writeChars(datosPersona);
           } 
        } catch(FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } finally{
            fichero.close();
        }
    }
    
    /**
     * Lee el fichero de texto que recibe.
     * @param fichero
     * @throws IOException 
     */
    public void leerFicheroTexto(RandomAccessFile fichero) throws IOException{
        
        //HashMap<String, long>indice = new HashMap<String, long>();
        
        try{
            fichero.readChar();
            fichero.close();
            
        } catch(FileNotFoundException e){
            System.out.println("ERROR " + e);
        }
        
        
    }
    
    /**
     * Escribe el fichero en Bytes
     * @param fichero
     * @throws IOException 
     */
    
    public void escribirFicheroBytes(RandomAccessFile fichero) throws IOException{
        //Persona p = new Persona("24681357S", "Ana", 1.70, 60);
        Persona p = new Persona("13572468P", "Luis", 1.86, 80);
        
        try{
           
           long pos = fichero.getFilePointer();
           
           if (fichero.length()>=pos){
               fichero.seek(pos);
               String datosPersona = p.getDni() + ";" + p.getNombre()+ ";" + p.getAltura() + ";" + p.getPeso();
               
               byte[]datos = datosPersona.getBytes("UTF-8");
               fichero.write(datos);

           } 
        } catch(FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } finally{
            fichero.close();
        }
    }
    
}
