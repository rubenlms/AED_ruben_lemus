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
        RandomAccessFile fichero = null;
        //Persona p = new Persona("13572468P", "Luis", 1.86, 80);
        Persona p = new Persona("24681357S", "Ana", 1.70, 60);
        
        try{
           fichero = new RandomAccessFile("personas.txt","rw");
           long pos = fichero.getFilePointer();
           
           if (fichero.length()>=pos){
               fichero.seek(pos);
               String datosPersona = p.getDni() + ";" + p.getNombre()+ ";" + p.getAltura() + ";" + p.getPeso();
               fichero.writeChars(datosPersona);
           } else {
               System.out.println("no hace nada");
           }
        } catch(FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } finally{
            fichero.close();
        }
        
        
    }
    
    
}
