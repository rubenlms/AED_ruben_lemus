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
import javafx.scene.control.TextArea;

/**
 *
 * @author dama
 */
public class GestorFicheros {
    
    public GestorFicheros(){
    }
    
     public void abrir(TextArea TAtexto, File selectedFile) throws FileNotFoundException, IOException{
        Path pathFile= selectedFile.toPath();
            
        if (pathFile != null) {

            try (BufferedReader bf = Files.newBufferedReader(pathFile)){
            String texto;
                
            while ((texto = bf.readLine())!=null){
                TAtexto.setText(texto);
                bf.close();
                }
            }
        }
    }
    
    public void guardar(TextArea TAtexto, File selectedFile) throws IOException{
        File archivo = new File(selectedFile.getAbsolutePath());
        FileWriter escribir = new FileWriter(archivo, true);
        escribir.write(TAtexto.getText());
        escribir.close();
    }
    
    public void guardarComo(TextArea TAtexto, File selectedFile) throws IOException{

        if (selectedFile != null) {

            File archivoNuevo = new File(selectedFile.getAbsolutePath());
        
            FileWriter escribir = new FileWriter(archivoNuevo);
                
            escribir.write(TAtexto.getText());
            
            escribir.close();
            
            System.out.println("Existe? " + archivoNuevo.exists());
            System.out.println("Ruta: " + archivoNuevo.getAbsolutePath());
        }
    }
}
