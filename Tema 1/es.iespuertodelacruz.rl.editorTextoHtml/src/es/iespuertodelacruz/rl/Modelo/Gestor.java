/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import javafx.scene.web.HTMLEditor;

/**
 *
 * @author ruben
 */
public class Gestor {
    
       public void abrir(HTMLEditor htmlEditor, File selectedFile) throws FileNotFoundException, IOException{
        Path pathFile = selectedFile.toPath();

            if (pathFile != null) {
                try (BufferedReader bf = Files.newBufferedReader(pathFile)){
                String texto;
                
                while ((texto = bf.readLine())!=null){
                    htmlEditor.setHtmlText(texto);
                    }
                }
            }
    }
    
    public void guardar(HTMLEditor htmlEditor, File selectedFile) throws IOException{
        try{
            File archivo = new File(selectedFile.getAbsolutePath());
            FileWriter escribir = new FileWriter("", true);
            escribir.write(transformarHTML(htmlEditor));
            System.out.println("contenido guardado");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public void guardarComo(HTMLEditor htmlEditor, File selectedFile) throws IOException{
        
        if (selectedFile != null) {
                Path pathFile = selectedFile.toPath();
                System.out.println("File selected: " + pathFile.toString());
            
                //System.out.println(htmlEditor.getHtmlText());
            
                File archivoNuevo = new File(selectedFile.getAbsolutePath());
        
                FileWriter escribir = new FileWriter(archivoNuevo);
                
                escribir.write(transformarHTML(htmlEditor));
            
                escribir.close();
            
                System.out.println("Existe? " + archivoNuevo.exists());
                System.out.println("Ruta: " + archivoNuevo.getAbsolutePath());
            }
    }
    
    public String transformarHTML(HTMLEditor htmlEditor){
        
        String texto = htmlEditor.getHtmlText();
        
        String conversor = texto.replaceAll("<[^>]*>", " ");
        
        String tPlano = conversor.replaceAll("\\s{2,}", " ");
        
        System.out.println("TextoHTML: " + texto + "\nTexto Plano: " + tPlano);
        
        return tPlano;
    } 
}
