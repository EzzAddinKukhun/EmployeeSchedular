/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import animatefx.animation.BounceIn;
import animatefx.animation.FadeIn;
import animatefx.animation.Flash;
import animatefx.animation.Flip;
import animatefx.animation.GlowText;
import animatefx.animation.Hinge;
import animatefx.animation.Jello;
import animatefx.animation.RubberBand;
import animatefx.animation.Shake;
import animatefx.animation.SlideInLeft;
import animatefx.animation.SlideInRight;
import animatefx.animation.SlideInUp;
import animatefx.animation.Tada;
import animatefx.animation.Wobble;
import animatefx.animation.ZoomIn;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.ButtonGroup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class UserInterface implements Initializable {

    @FXML
    private AnchorPane home_pane;
    @FXML
    private Pane pane;
    @FXML
    private Label total_vacations_year;
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane11;
    @FXML
    private Pane pane111;
    @FXML
    private Label total_vacations_year111;
    @FXML
    private AnchorPane profile_settings;
    @FXML
    private AnchorPane leave_req_pane;
    @FXML
    private AnchorPane options_pane;
    
    int activate = 0; 
    @FXML
    private Button showLeaveReqPane;
    @FXML
    private AnchorPane vacation_pane_req;
    @FXML
    private AnchorPane Activites_Pane;
    @FXML
    private RadioButton first_choice;
    @FXML
    private RadioButton second_choice;
    @FXML
    private TableView<?> table1;
    @FXML
    private ToggleGroup choice;
    @FXML
    private TableView<?> table2;
    
    int select_table = 0; 
    @FXML
    private AnchorPane rootanchor;
    @FXML
    private Label account_name;
    @FXML
    private Label username;
    @FXML
    private Label current_vacations;
    @FXML
    private Label total_hour_leaves;
    @FXML
    private ImageView profile_photo;
    @FXML
    private Label fname;
    @FXML
    private Label midname;
    @FXML
    private Label lname;
    @FXML
    private Label id;
    @FXML
    private Label emp_number;
    @FXML
    private Label uname;
    @FXML
    private Label bdate;
    @FXML
    private Label state;
    @FXML
    private Label city;
    @FXML
    private Label email;
    @FXML
    private Label phone_number;
    String uniform_resource_locator= "jdbc:mysql://localhost:3306/employeedatabase?useSSL=true"; 
    String user = "root"; 
    String pass = ""; 
    int result; 
    @FXML
    private TableView<Leaves> leaves_table;
    @FXML
    private TableColumn<Leaves, String> le_id;
    @FXML
    private TableColumn<Leaves, String> le_date;
    @FXML
    private TableColumn<Leaves, String> le_start;
    @FXML
    private TableColumn<Leaves, String> le_end;
    @FXML
    private TableColumn<Leaves, String> le_duration;
    @FXML
    private TableColumn<Leaves, String> le_type;
    @FXML
    private TableColumn<Leaves, String> le_marked;

    /**
     * Initializes the controller class.
     */
    
    public void setMainInformation (String username)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
            Statement stmt = connection.createStatement(); 
            String select_main_info = "select * from emp where username='"+username+"'"; 
            ResultSet rs = stmt.executeQuery(select_main_info); 
            rs.next(); 
            this.account_name.setText(rs.getString(1)+" "+rs.getString(3));
            this.username.setText(rs.getString("username"));
            this.total_vacations_year.setText(rs.getInt(16)+"");
            this.current_vacations.setText(rs.getInt(17)+"");
            this.total_hour_leaves.setText(rs.getString(18));
            this.fname.setText(rs.getString(1));
            this.midname.setText(rs.getString(2));
            this.lname.setText(rs.getString(3));
            this.id.setText(rs.getInt(4)+"");
            this.uname.setText(rs.getString("username"));
            this.phone_number.setText(rs.getInt(12)+"");
            this.state.setText(rs.getString("state"));
            this.city.setText(rs.getString("city"));
            this.bdate.setText(rs.getString("Birthdate"));
            this.email.setText(rs.getString("email"));
            this.emp_number.setText(rs.getInt(15)+"");


            
        }
        
        catch (Exception e){
            
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                this.home_pane.setVisible(true);
                new FadeIn (this.home_pane).play();
                this.table1.setVisible(true);
                updateLeavesTable(); 

                            

                
                
        // TODO
    }    

    @FXML
    private void homePage(ActionEvent event) {
        this.home_pane.setVisible(true);
        this.profile_settings.setVisible(false);
                  this.leave_req_pane.setVisible(false);
                            this.vacation_pane_req.setVisible(false);
                                      this.Activites_Pane.setVisible(false);

                new SlideInUp (this.home_pane).play();


    }

    @FXML
    private void profilePage(ActionEvent event) {
                this.home_pane.setVisible(false);
                this.profile_settings.setVisible(true);
                          this.leave_req_pane.setVisible(false);
                                    this.vacation_pane_req.setVisible(false);
                                                                          this.Activites_Pane.setVisible(false);

          new SlideInUp  (this.profile_settings).play();

              

    }

    @FXML
    private void leavesPage(ActionEvent event) {
         this.home_pane.setVisible(false);
          this.profile_settings.setVisible(false);
          this.leave_req_pane.setVisible(true);
                    this.vacation_pane_req.setVisible(false);
                                                          this.Activites_Pane.setVisible(false);

                              new SlideInUp  (this.leave_req_pane).play();


    }

    @FXML
    private void vacationsPage(ActionEvent event) {
        this.home_pane.setVisible(false);
          this.profile_settings.setVisible(false);
          this.leave_req_pane.setVisible(false);
          this.vacation_pane_req.setVisible(true);
                    this.Activites_Pane.setVisible(false);

                                        new SlideInUp  (this.vacation_pane_req).play();

    }


    @FXML
    private void makeNewLeaveRequest(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader (getClass().getResource("LeaveRequest.fxml"));  
             Parent root = loader.load(); 
             LeaveRequest transfer = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             stage.setScene (new Scene (root)); 
             BoxBlur blur = new BoxBlur (9,9,9); 
             this.rootanchor.setEffect(blur);
             transfer.setInfo(stage, rootanchor,this.username.getText(),this);
             stage.show(); 
             
             
            
             
    }

    @FXML
    private void showMore(MouseEvent event) {
        
       setTransition (this.options_pane, this.home_pane); 

    }

    @FXML
    private void showMore2(MouseEvent event) {
        
        setTransition (this.options_pane, this.profile_settings); 
        
    }
    
    @FXML
    private void showMore3(MouseEvent event) {
         
        setTransition (this.options_pane, this.leave_req_pane); 
    }
    
    @FXML
    private void showMore4(MouseEvent event) {
        setTransition (this.options_pane, this.vacation_pane_req); 

    }

     @FXML
    private void showMore5(MouseEvent event) {
        setTransition (this.options_pane, this.Activites_Pane); 

    }
    
    
    private void setTransition (AnchorPane anchor1, AnchorPane anchor2)
    {
       if (activate ==1 )
        {
        TranslateTransition slide = new TranslateTransition (); 
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(anchor1);
        slide.setToX(-251);
        slide.play();
        
        TranslateTransition slide2 = new TranslateTransition (); 
                slide2.setDuration(Duration.seconds(0.7));
        slide2.setNode(anchor2);
        slide2.setToX(-125.5);
        slide2.play();
        activate = 0; 
        }
        
        else
        {
        TranslateTransition slide = new TranslateTransition (); 
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(anchor1);
        slide.setToX(0);
        slide.play();
        
        TranslateTransition slide2 = new TranslateTransition (); 
                slide2.setDuration(Duration.seconds(0.7));
        slide2.setNode(anchor2);
        slide2.setToX(0);
        slide2.play();
        activate = 1; 
        }  
    }

    
    @FXML
    private void makeNewVacationRequest(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader (getClass().getResource("VacationRequest.fxml"));  
        Parent root = loader.load(); 
            VacationRequest transfer = loader.getController(); 
             Stage stage = new Stage (); 
             stage.setScene (new Scene (root)); 
             stage.show(); 
 
    }

    

    @FXML
    private void showActivitesPane(ActionEvent event) {
          this.home_pane.setVisible(false);
          this.profile_settings.setVisible(false);
          this.leave_req_pane.setVisible(false);
          this.vacation_pane_req.setVisible(false);
          this.Activites_Pane.setVisible(true);
                                        new SlideInUp  (this.Activites_Pane).play();
    }

    @FXML
    private void selectTable1(ActionEvent event) {
        
       this.table1.setVisible(true);
              this.table2.setVisible(false);

    }
    
    @FXML
    private void selectTable2(ActionEvent event) {
        
       this.table2.setVisible(true);
       this.table1.setVisible(false);
    }

    @FXML
    private void editPassword(ActionEvent event) throws IOException {
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("ChangePassowrd.fxml"));  
             Parent root = loader.load(); 
             ChangePassword changepassword = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             changepassword.setStage(stage,this.rootanchor);
             this.rootanchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
              FXMLLoader loader = new FXMLLoader (getClass().getResource("LogInNew.fxml"));  
             Parent root = loader.load(); 
              LogInNew m = loader.getController(); 
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
             stage.setScene (new Scene (root)); 
             stage.show();
    }

    @FXML
    private void chooseProfilePhoto(ActionEvent event) {
    }
    
    
    
    public void setResultToUpdateTable (int result){
        
        if (result == 1){
          updateLeavesTable(); 
        } 
}
    
    
    public void updateLeavesTable (){
        
          try{   
            
            ObservableList <Leaves> List= FXCollections.observableArrayList(); 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
            Statement stmt = connection.createStatement(); 
            String select_main_info = "select * from leaves"; 
            ResultSet rs = stmt.executeQuery(select_main_info);
            
         while (rs.next()){
         List.add(new Leaves (rs.getInt(1)+"",rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7))); 
         this.le_id.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Id"));
         this.le_date.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Date"));
         this.le_start.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Start_time"));
         this.le_end.setCellValueFactory(new PropertyValueFactory<Leaves,String>("End_time"));
         this.le_duration.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Duration"));
         this.le_type.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Type"));  
         this.le_marked.setCellValueFactory(new PropertyValueFactory<Leaves,String>("Checkbox"));     

         this.leaves_table.setItems(List);   
         }       
        }
        
    catch (Exception e){
        
    }
          
    }
}