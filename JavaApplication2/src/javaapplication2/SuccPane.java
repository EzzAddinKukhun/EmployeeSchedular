/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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
public class SuccPane implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    AnchorPane anchor; 
    Stage stage; 
    
    public void setInfo (AnchorPane anchor, Stage stage){
        this.anchor = anchor; 
        this.stage = stage; 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeStage(MouseEvent event) {
        this.stage.close();
        BoxBlur blur = new BoxBlur (0,0,0); 
        this.anchor.setEffect(blur);
    }
    
}
