/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editortextota.Controlador.FXMLDocumentController;

import es.iespuertodelacruz.rl.Modelo.GestorFicheros;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author dama
 */
public class Controlador implements Initializable {

    @FXML
    private TextArea TAtexto;
    private GestorFicheros gf;
    private File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abrir(ActionEvent event) throws IOException {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Abrir fichero");
            Window ownerWindow = null;
            File selectedFile = fileChooser.showOpenDialog(ownerWindow);
            
            gf.abrir(TAtexto, selectedFile);
               
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        }
    }

    @FXML
    private void nuevo(ActionEvent event) {
        TAtexto.clear();
    }

    @FXML
    private void guardar(ActionEvent event) throws IOException {
        
        if (selectedFile==null){
            gf.guardarComo(TAtexto, selectedFile);
        } else {
            gf.guardar(TAtexto, selectedFile);
        }
    }

    @FXML
    private void guardarComo(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar fichero");
        Window ownerWindow = null;
        selectedFile = fileChooser.showSaveDialog(ownerWindow);
        
        gf.guardarComo(TAtexto, selectedFile);
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
    
}
