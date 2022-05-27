/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class NewPassword implements Initializable {

    @FXML
    private PasswordField first_pass;
    @FXML
    private PasswordField second_Pass;
    @FXML
    private Label war;
    Stage stage; 
    AnchorPane anchor; 
    String email; 
    String uniform_resource_locator= "jdbc:mysql://localhost:3306/employeedatabase?useSSL=true"; 
    String user = "root"; 
    String pass = ""; 
    /**
     * Initializes the controller class.
     */
    
    public void setInformation (Stage stage, AnchorPane anchor, String email){
       this.anchor = anchor; 
       this.stage = stage; 
       this.email = email; 
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeStage(MouseEvent event) {
         BoxBlur blur = new BoxBlur (0,0,0); 
         this.anchor.setEffect(blur);
         this.stage.close();
    }

    @FXML
    private void verifyCode(ActionEvent event) {
        try
        {
        if (!this.first_pass.getText().equals(this.second_Pass.getText())){
            this.war.setVisible(true);
        }
        else
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
            Statement stmt = connection.createStatement();    
            String select = "update emp set password='"+this.first_pass.getText()+"' where email='"+this.email+"'"; 
            stmt.executeUpdate(select); 
             this.stage.close(); 
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("SuccPane.fxml"));  
             Parent root = loader.load(); 
             SuccPane succ = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             succ.setInfo(this.anchor, stage);
             this.anchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
        }
        }
        catch (Exception e)
        {
            
        }
        
    }
    
}
