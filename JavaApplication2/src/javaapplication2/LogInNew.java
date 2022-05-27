/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javaapplication2;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class LogInNew implements Initializable {

    String uniform_resource_locator= "jdbc:mysql://localhost:3306/employeedatabase?useSSL=true"; 
    String user = "root"; 
    String pass = ""; 
    String [] names = new String [2]; 
    int i = 0; 
    int randomcode; 
    @FXML
    private Label hello1;
    @FXML
    private ImageView pic1;
    @FXML
    private Label hello2;
    @FXML
    private ImageView forgotimage;
    @FXML
    private Label mainLabelForget;
    @FXML
    private Label signlogo;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label usernamelabel;
    @FXML
    private Label passwordlabel;
    @FXML
    private ImageView userimage;
    @FXML
    private ImageView lockimage;
    @FXML
    private Label emaillabel;
    @FXML
    private TextField email;
    @FXML
    private ImageView emailicon;
    @FXML
    private Label forgotLogo;
    @FXML
    private Button sign;
    @FXML
    private Button send;
    @FXML
    private Button toForget;
    @FXML
    private Button toLgIn;
    @FXML
    private AnchorPane layer2;
    @FXML
    private AnchorPane layer1;
    @FXML
    private TextField non_hidden_password;
    @FXML
    private ImageView open_eye;
    @FXML
    private ImageView close_eye;
    @FXML
    private Label war;
    @FXML
    private AnchorPane rootanchor;
    @FXML
    private Label email_war;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.forgotimage.setVisible(false);
        this.toLgIn.setVisible(false);
        this.mainLabelForget.setVisible(false);
        this.email.setVisible(false);
        this.emailicon.setVisible(false);
        this.emaillabel.setVisible(false);
        this.send.setVisible(false);
        this.forgotLogo.setVisible(false);
        
        
    } 

    @FXML
    private void toForgetBtn(ActionEvent event) {
        TranslateTransition slide = new TranslateTransition (); 
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);
        slide.setToX(584);
        slide.play();
        this.layer1.setTranslateX(-543);
        
        this.userimage.setVisible(false);
        this.username.setVisible(false);
        this.usernamelabel.setVisible(false);
        this.hello1.setVisible(false);
        this.hello2.setVisible(false);
        this.passwordlabel.setVisible(false);
        this.password.setVisible(false);
        this.sign.setVisible(false);
        this.signlogo.setVisible(false);
        this.pic1.setVisible(false);
        this.toLgIn.setVisible(true);
        this.lockimage.setVisible(false);
        
        
        
        
        
        this.forgotimage.setVisible(true);
        this.toForget.setVisible(false);
        this.mainLabelForget.setVisible(true);
        this.email.setVisible(true);
        this.emailicon.setVisible(true);
        this.emaillabel.setVisible(true);
        this.send.setVisible(true);
        this.forgotLogo.setVisible(true);
        
        this.open_eye.setVisible(false);
        this.close_eye.setVisible(false);
        this.non_hidden_password.setVisible(false);
        this.war.setVisible(false);
        
        
        
        
        
        
        
    }

    @FXML
    private void toLogInBtn(ActionEvent event) {
           TranslateTransition slide = new TranslateTransition (); 
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);
        slide.setToX(0);
        slide.play();
        this.layer1.setTranslateX(0);
        
        this.userimage.setVisible(true);
        this.username.setVisible(true);
        this.usernamelabel.setVisible(true);
        this.hello1.setVisible(true);
        this.hello2.setVisible(true);
        this.passwordlabel.setVisible(true);
        this.password.setVisible(true);
        this.sign.setVisible(true);
        this.signlogo.setVisible(true);
        this.pic1.setVisible(true);
        this.toLgIn.setVisible(false);
        this.lockimage.setVisible(true);
        
        
        
        
        
        this.forgotimage.setVisible(false);
        this.toForget.setVisible(true);
        this.mainLabelForget.setVisible(false);
        this.email.setVisible(false);
        this.emailicon.setVisible(false);
        this.emaillabel.setVisible(false);
        this.send.setVisible(false);
        this.forgotLogo.setVisible(false);
        
         this.open_eye.setVisible(true);
         this.email_war.setVisible(false);
        
        
        
    }

    @FXML
    private void showHiddenPassword(MouseEvent event) {
        
        String password_text = this.password.getText(); 
        this.password.setVisible(false);
        this.non_hidden_password.setVisible(true);
        this.non_hidden_password.setText(password_text);
        this.open_eye.setVisible(false);
        this.close_eye.setVisible(true);
    }

    @FXML
    private void hidePassword(MouseEvent event) {
        String password_text = this.non_hidden_password.getText(); 
        this.non_hidden_password.setVisible(false);
        this.password.setVisible(true);
        this.password.setText(password_text);
        this.open_eye.setVisible(true);
        this.close_eye.setVisible(false);
    }

    @FXML
    private void logIn(ActionEvent event)  {
      try
      {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
            Statement stmt = connection.createStatement(); 
            String username = this.username.getText(); 
            String password = this.password.getText().trim(); 
            String select = "select * from emp where username='"+this.username.getText()+"'"; 
            ResultSet rs = stmt.executeQuery(select); 
            
            if (!rs.next()){
                this.war.setText("This account doesn't exist");
                this.war.setVisible(true);
            }
            
            else
            {
                String select2 = "select * from emp where username='"+this.username.getText()+"'"; 
                rs = stmt.executeQuery(select2); 
                rs.next(); 
                int counter = rs.getInt("counter"); 
               
                if (counter >= 3){
                  this.war.setVisible(true);
                  this.war.setText("This account is blocked ,You exceeded allowed trials of log In");
                 
                }
                
                else{
                    
                String data_base_password = rs.getString("password");
                if (data_base_password.equals(password) || data_base_password.equals(this.non_hidden_password.getText()) ){
                    
                    String update = "update emp set counter='0' where username='"+username+"'"; 
                    stmt.executeUpdate(update); 
                    FXMLLoader loader = new FXMLLoader (getClass().getResource("UserInterface.fxml"));  
                    Parent root = loader.load(); 
                    UserInterface user_interface = loader.getController(); 
                    user_interface.setMainInformation(username);
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
                    stage.setScene (new Scene (root)); 
                    stage.show();
                }
                else
                {
                    counter ++; 
                    String update = "update emp set counter='"+counter+"' where username='"+username+"'"; 
                    stmt.executeUpdate(update); 
                    this.war.setVisible(true);
                    this.war.setText("You Entered password "+counter+" times wrong");
                    
                    if (counter == 2){
                       update = "update emp set blocked='1' where username='"+username+"'"; 
                       stmt.executeUpdate(update);   
                    }
                        
                    
                }
                }
            }
            
             
            
             
         
             
      }
      catch (Exception e){
          
      }
    }

    @FXML
    private void resetPasswordByEmail(ActionEvent event) throws AddressException {
        try
        {
            
        String user_email = this.email.getText(); 
        
        
        if (user_email.isEmpty())
        {
            this.email_war.setVisible(true);
            this.email_war.setText("Please Fill Blank By Your Email");
        }
        else
        {
        this.email_war.setVisible(false);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(this.uniform_resource_locator,user,pass);
        Statement stmt = connection.createStatement(); 
        String email_query = "select * from emp where email='"+user_email+"'"; 
        ResultSet rs = stmt.executeQuery(email_query); 
        
        if (!rs.next())
        {
            this.email_war.setVisible(true);
            this.email_war.setText("This Email Doesn't Exist"); 
        }
        
        else
        {
        rs = stmt.executeQuery(email_query); 
        rs.next(); 
        Random rand = new Random (); 
        randomcode = rand.nextInt(9999); 
        String host = "smtp.gmail.com"; 
        String user = "ezkukhun2000@gmail.com"; 
        String pass = "ecvxjyprbcaryxbk"; 
        String to = this.email.getText(); 
        String subject = "Reset Password";
        String message = "Your reset code is "+randomcode+""; 
        boolean sessionDebug = false; 
        Properties pros = System.getProperties(); 
        pros.put("mail.smtp.starttls.enable", "true"); 
        pros.put("mail.smtp.host", "host"); 
        pros.put("mail.smtp.port", "587"); 
        pros.put("mail.smtp.auth", "true"); 
        pros.put("mail.smtp.starttls.required", "true"); 
        pros.put("mail.smtp.ssl.protocols", "TLSv1.2");
        java.security.Security.addProvider(new  com.sun.net.ssl.internal.ssl.Provider()); 
        Session mail_session = Session.getDefaultInstance(pros,null); 
        mail_session.setDebug(sessionDebug);
        Message msg = new MimeMessage(mail_session); 
        msg.setFrom(new InternetAddress(user));
        InternetAddress [] address = {new InternetAddress(to)}; 
        msg.setRecipients(Message.RecipientType.TO, address);
        msg.setSubject(subject);
        msg.setText(message);
        Transport transport = mail_session.getTransport("smtp"); 
        transport.connect(host, user, pass);
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();
        
             BoxBlur blur = new BoxBlur (9,9,9); 
             FXMLLoader loader = new FXMLLoader (getClass().getResource("VerificationWindow.fxml"));  
             Parent root = loader.load(); 
             VerificationWindow verify = loader.getController(); 
             Stage stage = new Stage (); 
             stage.initStyle(StageStyle.UNDECORATED);
             verify.setInformation(stage,this.rootanchor,this.randomcode, to);
             this.rootanchor.setEffect(blur);
             stage.setScene (new Scene (root)); 
             stage.show(); 
        
        }
        }
        }
        catch (Exception e)
        {
            System.err.print(e);
        }
        
       

       

        

        
        
        
    }
    
    
    
    
    
}
