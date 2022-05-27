/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class Warning implements Initializable {

    /**
     * Initializes the controller class.
     */
    AnchorPane anchor; 
    Stage stage; 
    @FXML
    private ImageView image_icon;
    @FXML
    private Label Title;
    @FXML
    private Label message;
    
    public void setInfo (AnchorPane anchor, Stage stage){
        this.anchor = anchor; 
        this.stage = stage; 
    }
    
    
    public void setMainInfo (int i) throws FileNotFoundException{
        InputStream stream = null ; 
        Image image = null ;
   
        switch (i){
            case 0:
                stream = new FileInputStream("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\JavaApplication2\\src\\imgs\\alert.png");
                image = new Image (stream);         
                this.image_icon.setImage(image);
                this.image_icon.setPreserveRatio(true);
                this.image_icon.setFitWidth(100);
                this.Title.setText("WARNING");   
                this.Title.setTextFill(Color.RED);
                this.message.setText("There is a conflict in appintments");
                break;
            case 1:
                stream = new FileInputStream("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\JavaApplication2\\src\\imgs\\check.png");
                image = new Image (stream);         
                this.image_icon.setImage(image);
                this.Title.setText("SUCCESS");
                this.Title.setTextFill(Color.GREEN);
                this.message.setText("You have to wait reply");
                break; 
            case 2:
                stream = new FileInputStream("C:\\Users\\lenovo\\Documents\\NetBeansProjects\\JavaApplication2\\src\\imgs\\alert.png");
                image = new Image (stream);         
                this.image_icon.setImage(image);
                this.image_icon.setPreserveRatio(true);
                this.image_icon.setFitWidth(100);
                this.Title.setText("WARNING");   
                this.Title.setTextFill(Color.RED);
                this.message.setText("There is an invalid duration");
                break;
                
        }
        
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
