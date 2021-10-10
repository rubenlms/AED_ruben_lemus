/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ruben
 */
public class Modelo {
    
    int sizeNombre=50;
    int sizeApellido=50;
    int sizeEdad=3;
    ArrayList<Persona>personas;
    
    /**
     * Guarda a una persona nueva en el fichero en texto.
     * @param raf
     * @throws IOException 
     */
    public void guardarPersonaTexto(String nombre, String apellido, int edad) throws IOException {
        
        RandomAccessFile raf = new RandomAccessFile("personas.txt","rw");
        
        //Persona p = new Persona("Luis","Montero",34);
        Persona p = new Persona(nombre,apellido,edad);
        //personas.add(p);
        
        long pos = raf.getFilePointer();
        
        if(raf.length() >= pos){
           raf.seek(pos);
           raf.writeChars(p.getNombre()+"\0"+p.getApellido()+"\0"+p.getEdad()+"\0");
        }
        
        try{
            for (int i = 0; i < sizeNombre-(p.getNombre().length()+1); i++) {
                raf.writeChars(" ");
                break;
            }
            
            for (int i = 0; i < sizeApellido-(p.getApellido().length()+1); i++) {
                raf.writeChars(" ");
                break;
            }
            
            for (int i = 0; i < sizeEdad-2; i++) {
                raf.writeChars(" ");
                break;
            }
            
            raf.close();
            
        } catch(FileNotFoundException e){
            System.out.println("ERROR " + e);
        }
    }
    
    /**
     * Guarda en el fichero a una persona en Bytes.
     * @param nombre
     * @param apellido
     * @param edad
     * @throws IOException 
     */
    public void guardarPersonaBytes(String nombre, String apellido, int edad) throws IOException{
        
        RandomAccessFile raf = new RandomAccessFile("personas.txt","rw");
        
        //Persona p = new Persona("Ana Maria", "Diaz", 40);
        Persona p = new Persona(nombre,apellido,edad);
        //personas.add(p);
        
        try{
           
           long pos = raf.getFilePointer();
           
           if (raf.length()>=pos){
               raf.seek(pos);
               String datosPersona = p.getNombre()+"\0"+p.getApellido()+"\0"+p.getEdad()+"\0";
               
               byte[]datos = datosPersona.getBytes("UTF-8");
               raf.write(datos);
               System.out.println("Persona " + p.getNombre() + " guardada.");
           } 
        } catch(FileNotFoundException e){
            System.out.println("ERROR: " + e);
        } finally{
            raf.close();
        }
    }
    
    /**
     * busca una persona a través de una posición en el fichero y la muestra
     * @param pos
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void buscarPersona(long pos) throws FileNotFoundException, IOException{
        
        RandomAccessFile raf = new RandomAccessFile("personas.txt","rw");
        Persona p = new Persona();
           
        try{
            raf.seek(pos);
            String persona;
            while (raf.readUTF()!=null){
                for (int i = 0; i < 100; i++) {
                    persona = raf.readUTF();
                    String[]nombre = persona.split("\0");
                    p.setNombre(nombre[0]);
                }
                
                for (int i = 101; i < 200; i++) {
                    persona = raf.readUTF();
                    String[]apellido = persona.split("\0");
                    p.setApellido(apellido[0]);
                }
                
                for (int i = 201; i < 206; i++) {
                    persona = raf.readUTF();
                    String[]edad = persona.split("\0");
                    p.setEdad(Integer.parseInt(edad[0]));
                }
            }
            System.out.println("Nombre: " + p.getNombre()+"\nApellido: "+p.getApellido()+"\nEdad: " + p.getEdad());
            raf.close();
            
        } catch(FileNotFoundException e){
            System.out.println("ERROR " + e);
        }
        
    }

}
