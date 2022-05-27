/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class EditTotalVacations implements Initializable {

    @FXML
    private RadioButton custom;
    @FXML
    private ToggleGroup choice;
    @FXML
    private RadioButton stage;
    @FXML
    private Pane edit_pane1;
    @FXML
    private Pane edit_pane2;
    Stage passedstage; 
    AnchorPane passedanchor; 
    /**
     * Initializes the controller class.
     */
    
    public void setStage (Stage stage,AnchorPane anchor)
    {
        this.passedstage = stage; 
        this.passedanchor = anchor; 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeStage(MouseEvent event) {
        this.passedstage.close();
        BoxBlur blur = new BoxBlur (0,0,0); 
        this.passedanchor.setEffect(blur);
        
        
    }

    @FXML
    private void viewFirstPane(ActionEvent event) {
        this.edit_pane1.setVisible(true);
                this.edit_pane2.setVisible(false);

    }

    @FXML
    private void viewSecondPane(ActionEvent event) {
          this.edit_pane2.setVisible(true);
                this.edit_pane1.setVisible(false);

    }
    
}
