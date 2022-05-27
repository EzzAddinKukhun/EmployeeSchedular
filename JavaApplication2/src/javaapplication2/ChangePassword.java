/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class ChangePassword implements Initializable {
    
    Stage gui; 
    AnchorPane root ; 
    /**
     * Initializes the controller class.
     * @param fxmlloader
     */
    
    public void setStage (Stage stage, AnchorPane anchor){
        
        gui = stage; 
        root = anchor; 
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeStage(MouseEvent event) {
        BoxBlur blur = new BoxBlur (0,0,0); 
        root.setEffect(blur);
        gui.close();
    }
    
}
