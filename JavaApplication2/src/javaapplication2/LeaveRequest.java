/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
public class LeaveRequest implements Initializable {

    @FXML
    private DatePicker leave_date;
    @FXML
    private ComboBox<String> shour;
    @FXML
    private ComboBox<String> smin;
    @FXML
    private ComboBox<String> ehour;
    @FXML
    private ComboBox<String> emin;
    @FXML
    private RadioButton first_choice;
    @FXML
    private RadioButton second_choice;
    @FXML
    private ToggleGroup choicess;
    String uniform_resource_locator= "jdbc:mysql://localhost:3306/employeedatabase?useSSL=true"; 
    String user = "root"; 
    String pass = ""; 

    /**
     * Initializes the controller class.
     */
    int result; 
    Stage stage; 
    AnchorPane anchor; 
    String username; 
    UserInterface userinterface; 
    
    public void setInfo (Stage stage, AnchorPane anchor, String username, UserInterface userinterface){
        this.stage = stage; 
        this.anchor = anchor; 
        this.username = username; 
        this.userinterface = userinterface;
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        String [] hours = {"56"}; 
        
        this.shour.getItems().addAll(
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16"       
        
        
        
        );
        
         this.ehour.getItems().addAll(
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16"       
        
        
        
        );
         
          this.smin.getItems().addAll(
                "00",
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31",
                "32",
                "33",    
                "34",
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48",
                "49",
                "50",
                "51",
                "52",
                "53",
                "54",
                "55",
                "56",
                "57",
                "58",
                "59"
        
        
        
        );
          
           this.emin.getItems().addAll(
                "00",
                "01",
                "02",
                "03",
                "04",
                "05",
                "06",
                "07",
                "08",
                "09",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31",
                "32",
                "33",    
                "34",
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48",
                "49",
                "50",
                "51",
                "52",
                "53",
                "54",
                "55",
                "56",
                "57",
                "58",
                "59"
        
        
        
        );
        
    }    

    @FXML
    private void closeStage(MouseEvent event) {
         BoxBlur blur = new BoxBlur (0,0,0); 
        anchor.setEffect(blur);
        stage.close();  
    }

    @FXML
    private void submitLeave(ActionEvent event) throws IOException {
        
        
        if (this.leave_date.getValue()==null || this.ehour.getSelectionModel().isEmpty()
                || this.smin.getSelectionModel().isEmpty() || this.shour.getSelectionModel().isEmpty()
                || this.emin.getSelectionModel().isEmpty() || this.choicess.getSelectedToggle() == null 
           
                ){
            
            System.out.println("FILL ALL DATA");
            
        }
        
        else{
        
        
        int start_time_min = Integer.parseInt(this.smin.getSelectionModel().getSelectedItem());    
        int start_time_hour = Integer.parseInt(this.shour.getSelectionModel().getSelectedItem());    
        int end_time_min = Integer.parseInt(this.emin.getSelectionModel().getSelectedItem()); 
        int end_time_hour = Integer.parseInt(this.ehour.getSelectionModel().getSelectedItem()); 
        
        String duration = this.calculateDuration(start_time_min, start_time_hour, end_time_min, end_time_hour);
        
        if (duration.equals("This is invalid time")){
            
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("Warning.fxml"));  
             Parent root = loader.load(); 
             Warning war = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             war.setInfo(this.anchor,stage);
             war.setMainInfo(2);
             this.anchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
             
             this.stage.close();
            
        }
        
        else{
        
        
        String leave_date = this.leave_date.getValue().toString(); 
        RadioButton selectedRadioButton = (RadioButton) this.choicess.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        String username = this.username; 
        String start_time = start_time_hour +":"+start_time_min;
        String end_time = end_time_hour +":"+end_time_min;
          
        this.insertDataIntoLeavesTable(username, leave_date, start_time, end_time, duration, toogleGroupValue);
        
        
                     
        
    }
    
    }
    }  
    public String calculateDuration (int smin, int shour, int emin, int ehour){
        
        String Duration = null; 
        if (ehour <  shour){
            return "This is invalid time"; 
        }
        else{
           if (emin <= smin){
               emin += 60; 
               int final_min = emin-smin; 
               ehour -= 1; 
               int final_hour = ehour-shour; 
               Duration = final_hour + ":" + final_min;         
           } 
           else if (emin >= smin){
               int final_min = emin-smin; 
               int final_hour = ehour-shour; 
               Duration = final_hour + ":" + final_min; 
           }      
        }
        
        return Duration;
            
        
        
    }
    
    
    public void insertDataIntoLeavesTable (String username, String Date, String start_time, String end_time, String duration, String type){
        
        try{
            
            int flag = 0; 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
            Statement stmt = connection.createStatement(); 
            String select_id = "select * from emp where username='"+username+"'"; 
            ResultSet rs = stmt.executeQuery(select_id); 
            rs.next(); 
            String ID = rs.getInt("ID")+""; 
            System.out.println(ID);
            
            String select_leaves = "select * from leaves where ID_person ='"+ID+"'"; 
            ResultSet rs2 = stmt.executeQuery(select_leaves);

            while (rs2.next()){
                if (flag == 1){
                    break; 
                }
                else{
                    flag = this.checkValidLeave(start_time, end_time, rs2.getString("start_time"), rs2.getString("end_time"),Date, rs2.getString(3)); 
                }
                
            }
                
            if (flag ==0){
            String insert_data = "insert into leaves values ('0','"+ID+"','"+Date+"','"+start_time+"','"+end_time+"','"+duration+"','"+type+"','0')"; 
            stmt.executeUpdate(insert_data);
            
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("Warning.fxml"));  
             Parent root = loader.load(); 
             Warning war = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             war.setInfo(this.anchor,stage);
             war.setMainInfo(1);
             this.anchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
             
             this.stage.close();
             
             this.userinterface.setResultToUpdateTable(1);
             
             
            
            
            
            }
            
            else if (flag == 1){
                
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("Warning.fxml"));  
             Parent root = loader.load(); 
             Warning war = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             war.setInfo(this.anchor,stage);
             war.setMainInfo(0);
             this.anchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
             
             this.stage.close();
             this.userinterface.setResultToUpdateTable(0);
             
                
                
            }
            
            
            
        }
        
        catch (Exception e){
            
            e.printStackTrace(); 
        }
            
        
    }
    
    public int checkValidLeave (String start_time, String end_time, String data_base_start, String data_base_end,String Date, String data_base_date){
        
        int flag = 0; 
        
        String data_base_start_splitter [] = data_base_start.split(":"); 
        int shour = Integer.parseInt(data_base_start_splitter[0]);  
        int smin = Integer.parseInt(data_base_start_splitter[1]); 
        
        
        String data_base_end_splitter [] = data_base_end.split(":"); 
        int ehour = Integer.parseInt(data_base_end_splitter[0]);   
        int emin = Integer.parseInt(data_base_end_splitter[1]);       

        
        String current_start_splitter [] = start_time.split(":"); 
        int current_start_hour = Integer.parseInt(current_start_splitter[0]);    
        int current_start_min = Integer.parseInt(current_start_splitter[1]); 

        
        
        String current_end_splitter [] = end_time.split(":"); 
        int current_end_hour = Integer.parseInt(current_end_splitter[0]);
        int current_end_min = Integer.parseInt(current_end_splitter[1]);  
        
        
        if (Date.equals(data_base_date)){
        
        
        if ((current_start_hour <= shour) && (current_end_hour >= ehour)) {
            
            flag = 1; 
        }
        else if (current_end_hour == shour){
            if (current_end_min <= smin){
                flag = 0; 
            }
            else flag = 1; 
        }
        else if (current_start_hour == ehour){
            if (current_start_min >= emin){
                flag = 0; 
            }
            else flag = 1; 
        }
        else if ((shour < current_start_hour) && (current_start_hour < ehour)){
            flag = 1; 
        }
        else if ((shour < current_end_hour) && (current_end_hour < ehour)){
            flag = 1; 
        }
        
        }
        
        else flag = 0; 
            
          
                
        
        
        
        
        return flag; 
        
        
        
       
    }
    
    
    
    public void setResult (int result){
        this.result = result; 
    }
    
    public int getResult (){
        
        return this.result; 
    }
    


}
     