/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arij;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.regex.Pattern;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author HP
 */
public class Arij extends Application {
      
     public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
   private static boolean checkString(String str) {
    char ch;
    boolean capitalFlag = false;
    boolean lowerCaseFlag = false;
    boolean numberFlag = false;
    for(int i=0;i < str.length();i++) {
        ch = str.charAt(i);
        if( Character.isDigit(ch)) {
            numberFlag = true;
        }
        else if (Character.isUpperCase(ch)) {
            capitalFlag = true;
        } else if (Character.isLowerCase(ch)) {
            lowerCaseFlag = true;
        }
        if(numberFlag && capitalFlag && lowerCaseFlag)
            return true;
    }
    return false;
}
     VBox errors = new VBox();
   
    @Override
    public void start(Stage primaryStage) {
      Images imagepane = new Images();
      imagepane.setOpacity(5);
      Images imagepane1 = new Images();
      imagepane.setOpacity(5);
      Images imagepane2 = new Images();
      imagepane.setOpacity(5);
        
         Stage loginstage = new Stage();
        Stage registerstage = new Stage();
        
        
        
        
        
        Label nameerror = new Label("only letters");
        nameerror.setTextFill(Color.RED);
    int  height= 500, width=500;
    
    
        Label phoneerror = new Label("only numbers");
        phoneerror.setTextFill(Color.RED);
        
       
    Label emailerror = new Label("invalid email");
        emailerror.setTextFill(Color.RED);
        
     Label passworderror = new Label("password doesn't match");
        passworderror.setTextFill(Color.RED);
    
    Label area = new Label("not enough characters ");
        area.setTextFill(Color.RED);
    
    Label phonenumber = new Label("phone number must be 8 characters");
        phonenumber.setTextFill(Color.RED);
        
        Label emailnotvalid = new Label("email not valid");
        emailnotvalid.setTextFill(Color.RED);
    
    
     GridPane registerpane = new GridPane();
     registerpane.setHgap(10);
     registerpane.setVgap(10);
     registerpane.setPadding(new Insets(10));
     
     registerpane.add(new Text("Name:"), 0, 0);
     TextField name =  new TextField();
     registerpane.add(name, 1, 0);
    name.setOnKeyTyped( e -> {
     if(e.getCharacter().matches("[a-zA-Z]*"));
         
     else errors.getChildren().add(nameerror);
     
});
     registerpane.add(new Text("Email:"), 0, 1);
     TextField email =  new TextField();
     registerpane.add(email, 1, 1);
   
      
     registerpane.add(new Text("Phone:"), 0, 2);
     TextField phone = new TextField();
     registerpane.add(phone, 1, 2);
    phone.setOnKeyTyped( e -> {
     if(e.getCharacter().matches("[0-9]*"));
         
     else errors.getChildren().add(phoneerror);
    });
     registerpane.add(new Text("Password: "), 0, 3);
     PasswordField password = new PasswordField();
     registerpane.add(password, 1, 3);
     
     password.setOnAction(e -> {
         checkString(password.getText());
     });
     
     
     registerpane.add(new Text("confirm: "), 0, 4);
     PasswordField confirm = new PasswordField();
     registerpane.add(confirm, 1, 4);
     confirm.setOnAction(e -> {
         if(password.getText() == null ? confirm.getText() != null : !password.getText().equals(confirm.getText()))
             errors.getChildren().add(passworderror);
       
     });
     
     registerpane.add(new Text("country:"), 0, 5);
     ComboBox<String> combobox = new ComboBox<String>();
     combobox.getItems().addAll("select...","Lebanon", "usa", "ksa", "uae", "canada");
     combobox.getSelectionModel().select(0);
     registerpane.add(combobox, 1, 5);
     
     registerpane.add(new Text("Gender"), 0,6);
     RadioButton rb2 = new RadioButton("Male");
     RadioButton rb3 = new RadioButton("Female");
     final ToggleGroup group = new ToggleGroup();
     rb2.setToggleGroup(group);
     rb3.setToggleGroup(group);
     HBox hboxradio = new HBox();
     hboxradio.setPadding(new Insets(10));
     hboxradio.getChildren().addAll(rb2,rb3);
     registerpane.add(hboxradio, 1, 6);
     
     registerpane.add(new Text("Language"), 0,7);
     CheckBox cb1 = new CheckBox();
     CheckBox cb2= new CheckBox();
     CheckBox cb3 = new CheckBox();
     cb1.setText("Arabic");
     cb2.setText("English");
     cb3.setText("French");
     HBox hboxcheckbox = new HBox(20);
     hboxcheckbox.getChildren().addAll(cb1,cb2,cb3);
     hboxcheckbox.setPadding(new Insets(20));
     registerpane.add(hboxcheckbox, 1, 7);
     
     registerpane.add(new Text("About you"), 0,8);
     TextArea textarea =new TextArea();
     textarea.setPrefWidth(250); 
     registerpane.add(textarea, 1, 8);
    Button loginbutton = new Button();
    loginbutton.setText("login");
     loginbutton.setPrefSize(width/2, 20);
     loginbutton.setOnAction( e -> {
         registerstage.hide();
         loginstage.show();
     });
     Button registerbutton = new Button();
     registerbutton.setText("register");
     registerbutton.setPrefSize(width/2, 20);
     registerbutton.setAlignment(Pos.CENTER);
     registerbutton.setOnAction(e ->{
         if ( textarea.getLength()<50 )
             errors.getChildren().add(area);
           if( phone.getLength()< 8)
               errors.getChildren().add(phonenumber);
         if(isValid(email.getText())!= true)
             errors.getChildren().add(emailnotvalid);
     });
     HBox hboxbutton = new HBox();
     hboxbutton.getChildren().addAll(registerbutton,loginbutton);
     hboxbutton.setAlignment(Pos.CENTER);
     registerpane.add(hboxbutton, 0, 9,2,2);
     
     registerpane.setAlignment(Pos.CENTER);
   
    
     StackPane rpane = new StackPane();
      rpane.getChildren().add(imagepane2);
           
     
     registerpane.add(errors,0, 11);
     rpane.getChildren().add(registerpane);
        Scene regiseterscene = new Scene(rpane,height, width);
       
       registerstage.setScene(regiseterscene);
        
        
        
        
        
        
        
        
        
        
        
        
        GridPane loginpane = new GridPane();
       loginpane.setAlignment(Pos.CENTER);
       loginpane.setPadding(new Insets(10));
       loginpane.setHgap(10);
       loginpane.setVgap(10);
       
       loginpane.add(new Label("username"), 0, 0);
        loginpane.add(new TextField(), 1, 0);
        loginpane.add(new Label("password"), 0, 1);
        loginpane.add(new TextField(),1, 1);
        
        Button log = new Button("login");
        Button reg = new Button("register");
        reg.setOnAction(e ->{
            loginstage.hide();
            registerstage.show();
        });
        loginpane.add(log, 1, 2);
        loginpane.add(reg, 0, 2);
       
       
        
       
        StackPane p = new StackPane();
        p.getChildren().add(imagepane1);
        p.getChildren().addAll(loginpane);
         
        Scene loginscene = new Scene(p, width, height);
       
        loginstage.setScene(loginscene);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Button login = new Button("login");
        login.setOnAction( e ->{
            primaryStage.hide();
            loginstage.show();
        });
        
        
        
        
        Button register = new Button("register");
        register.setOnAction(e -> {
            primaryStage.hide();
            registerstage.show();
        });
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(login, register);
       buttons.setAlignment(Pos.CENTER);
       buttons.setPadding(new Insets(10));
       buttons.setSpacing(10);
       StackPane root = new StackPane();
       root.getChildren().add(imagepane); 
       root.getChildren().add(buttons);
        
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,width, height);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
