/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iespuertodelacruz.rl.Controlador;

import es.iespuertodelacruz.rl.Modelo.Gestor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author ruben
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private HTMLEditor htmlEditor;
    private Gestor gf;
    File selectedFile;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevoArchivo(ActionEvent event) {
        htmlEditor.setHtmlText(" ");
        
    }

    @FXML
    private void abrir(ActionEvent event) throws IOException {
            
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir fichero");
        Window ownerWindow = null;
        selectedFile = fileChooser.showOpenDialog(ownerWindow);
        
        gf.abrir(htmlEditor, selectedFile);
    }

    @FXML
    private void guardar(ActionEvent event) throws IOException {
        
        if (selectedFile==null){
                gf.guardarComo(htmlEditor, selectedFile);
            } else {
                gf.guardar(htmlEditor, selectedFile);
                }
    }

    @FXML
    private void guardarComo(ActionEvent event) throws IOException {
        
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Guardar fichero");
            Window ownerWindow = null;
            File selectedFile = fileChooser.showSaveDialog(ownerWindow);
               
            gf.guardarComo(htmlEditor, selectedFile);
            
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        }  
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
    
}
