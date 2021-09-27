/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imc;

import com.sun.glass.events.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author dama
 */
public class ImcController implements Initializable {

    @FXML
    private Label lblNombre;
    @FXML
    private TextField tflNombre;
    @FXML
    private Label lblApellidos;
    @FXML
    private TextField tflApellidos;
    @FXML
    private RadioButton rbtMujer;
    @FXML
    private ToggleGroup sexo;
    @FXML
    private RadioButton rbtHombre;
    @FXML
    private Label lblEdad;
    @FXML
    private Label lblAltura;
    @FXML
    private TextField tflEdad;
    @FXML
    private TextField tflAltura;
    @FXML
    private TextField tflPeso;
    @FXML
    private TextArea txaInformacion;
    @FXML
    private Button bttCalcular;
    
    /**
     * Calcula el IMC.
     * @param altura
     * @param peso 
     */
    public String calcularIMC(double altura, double peso){
        DecimalFormat df = new DecimalFormat("#.00");
        
        double imc = 0;
        
        try {
            imc = peso/Math.pow(altura, 2);
            
        } catch (NullPointerException ex){
            txaInformacion.setText("Error: " + ex);
        }
        return df.format(imc); 
    }
    
    /**
     * Initializes the controller class.
     * 
     * 
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bttCalcular.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                String nombre = tflNombre.getText();
                String apellidos = tflApellidos.getText();
                int edad = Integer.parseInt(tflEdad.getText());
                double altura = Double.parseDouble(tflAltura.getText());
                double peso = Double.parseDouble(tflPeso.getText());
                String sexo = "No definido";
                    if (rbtHombre.isSelected()==true){
                        sexo = "Hombre";
                    }
                    if (rbtMujer.isSelected()==true){
                        sexo = "Mujer";
                    }

                txaInformacion.setText("Nombre completo: " + nombre + " " + apellidos 
                        + "\nSexo: " + sexo
                        + "\nEdad: " + edad 
                        + "\nAltura: " + altura 
                        + "\nPeso: " + peso
                        + "\nIMC: " + calcularIMC(altura, peso));
            }
        });
   
    }

}
