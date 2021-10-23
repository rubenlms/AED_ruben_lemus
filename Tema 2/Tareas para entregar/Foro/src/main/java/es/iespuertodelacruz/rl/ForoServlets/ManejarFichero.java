package es.iespuertodelacruz.rl.ForoServlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManejarFichero {
	
File file;
    
    
   public ManejarFichero(String nombre){
        file = new File(nombre);
    }
    
    public boolean agregarTexto(String texto) throws IOException{
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(fw);
        
        bw.write(texto);
        bw.close();
        
        return false;
    }
    
    
    public String leerTodo() throws IOException {
        
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
