/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.numerosprimos.Vista;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ruben
 */
public class Vista {
    
    /**
     * Lee el fichero y muestra los números que lo contienen.
     * @param f 
     */
    public void mostrar(File f){
        boolean finArchivo=false;
        try{
            FileInputStream fis=new FileInputStream(f);
            DataInputStream dis=new DataInputStream(fis);
            int contador=0;
            
            //System.out.println("LEYENDO ARCHIVO Y MOSTRANDO LOS 100 PRIMEROS:");
            while (!finArchivo&&contador<100){
                int num = dis.readInt();
                contador++;
                for (int i = 0; i < contador; i++) {
                    System.out.println(num);
                    break;
                }
            }
            dis.close();
        } 
        catch(EOFException e){
            finArchivo=true;
        }
        catch(FileNotFoundException e){
            System.out.println("No se encontra el archivo");
        }
        catch(IOException e){
            System.out.println("Error al leer");
        }
    }
    
}
