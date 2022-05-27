/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import animatefx.animation.SlideInUp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
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
public class Admin implements Initializable {

    @FXML
    private AnchorPane add_new_page;
    @FXML
    private AnchorPane profile_settings;
    @FXML
    private Button blockedAccountsPage;
    @FXML
    private AnchorPane leave_req_pane;
    @FXML
    private AnchorPane vacation_pane_req;
    @FXML
    private AnchorPane employee_dic_page;
    @FXML
    private AnchorPane blocked_accounts_page;
    @FXML
    private AnchorPane Activites_Pane;
    @FXML
    private TableView<?> table1;
    @FXML
    private RadioButton first_choice;
    @FXML
    private ToggleGroup choice;
    @FXML
    private RadioButton second_choice;
    @FXML
    private TableView<?> table2;
    @FXML
    private AnchorPane rootanchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.add_new_page.setVisible(true);
    }    

    @FXML
    private void addNewEmployeePage(ActionEvent event) {
        this.add_new_page.setVisible(true);
        this.profile_settings.setVisible(false);
        this.leave_req_pane.setVisible(false);
        this.vacation_pane_req.setVisible(false);
        this.Activites_Pane.setVisible(false);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(false);
        new SlideInUp (this.add_new_page).play(); 
    }

    @FXML
    private void profilePage(ActionEvent event) {
        this.add_new_page.setVisible(false);
        this.profile_settings.setVisible(true);
        this.leave_req_pane.setVisible(false);
        this.vacation_pane_req.setVisible(false);
        this.Activites_Pane.setVisible(false);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(false);
        new SlideInUp (this.profile_settings).play(); 
    }

    @FXML
    private void leaveRequestPage(ActionEvent event) {
        this.add_new_page.setVisible(false);
        this.profile_settings.setVisible(false);
        this.leave_req_pane.setVisible(true);
        this.vacation_pane_req.setVisible(false);
        this.Activites_Pane.setVisible(false);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(false);
        new SlideInUp (this.leave_req_pane).play(); 
    }

    @FXML
    private void reviewVacationsPage(ActionEvent event) {
        this.add_new_page.setVisible(false);
        this.profile_settings.setVisible(false);
        this.leave_req_pane.setVisible(false);
        this.vacation_pane_req.setVisible(true);
        this.Activites_Pane.setVisible(false);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(false);
        new SlideInUp (this.vacation_pane_req).play(); 
    }

    @FXML
    private void employeeDictionaryPage(ActionEvent event) {
         this.add_new_page.setVisible(false);
        this.profile_settings.setVisible(false);
        this.leave_req_pane.setVisible(false);
        this.vacation_pane_req.setVisible(false);
        this.Activites_Pane.setVisible(false);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(true);
        new SlideInUp (this.employee_dic_page).play(); 
    }

    @FXML
    private void activitesPage(ActionEvent event) {
        this.add_new_page.setVisible(false);
        this.profile_settings.setVisible(false);
        this.leave_req_pane.setVisible(false);
        this.vacation_pane_req.setVisible(false);
        this.Activites_Pane.setVisible(true);
        this.blocked_accounts_page.setVisible(false);
        this.employee_dic_page.setVisible(false);
        new SlideInUp (this.Activites_Pane).play(); 
    }

    @FXML
    private void viewEditVacationWindow(ActionEvent event) throws IOException {
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("EditVacations.fxml"));  
             Parent root = loader.load(); 
             EditTotalVacations edittotal = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             edittotal.setStage(stage,this.rootanchor);
             this.rootanchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
    }

    @FXML
    private void makeNewLeaveRequest(ActionEvent event) {
    }

    @FXML
    private void showMore3(MouseEvent event) {
    }

    @FXML
    private void makeNewVacationRequest(ActionEvent event) {
    }

    @FXML
    private void selectTable1(ActionEvent event) {
    }

    @FXML
    private void selectTable2(ActionEvent event) {
    }

    
    
    
    
}
