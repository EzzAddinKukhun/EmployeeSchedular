/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class VerificationWindow implements Initializable {

    @FXML
    private TextField entered_code;
    @FXML
    private Label war;
    
    Stage window; 
    AnchorPane rootanchor; 
    int code; 
    String email=""; 

    /**
     * Initializes the controller class.
     */
    
    public void setInformation (Stage stage, AnchorPane anchor, int code, String email)
    {
       window = stage; 
       rootanchor = anchor; 
       this.code = code; 
       this.email = email; 
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verifyCode(ActionEvent event) throws IOException {
        
        int current_code = Integer.parseInt(this.entered_code.getText()); 
        
        if (this.code == current_code)
        {
            this.window.close();
            BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("NewPassword.fxml"));  
             Parent root = loader.load(); 
             NewPassword newpassword = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             newpassword.setInformation(stage,this.rootanchor,this.email);
             this.rootanchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
        }
        else
        {
            this.war.setVisible(true);
        }
        
        
    }

    @FXML
    private void closeStage(MouseEvent event) {
        BoxBlur blur = new BoxBlur (0,0,0); 
        this.rootanchor.setEffect(blur);
        this.window.close();
    }

    
}
