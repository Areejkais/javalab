package registration;

import java.util.regex.Pattern;
import javafx.application.Application;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Registration extends Application {    
    ImageView ci(){
        Image i = new Image("https://www.google.com/imgres?imgurl=http%3A%2F%2Flakhanipilgrimage.com%2Fimg%2Fslide-general.jpg&imgrefurl=http%3A%2F%2Flakhanipilgrimage.com%2Fregistration-form.php%3Fid%3D14&tbnid=boX0JZUArSWjhM&vet=1&docid=YKKZaoXAIrhfsM&w=1700&h=800&source=sh%2Fx%2Fim", 200 , 200, true,true);
      ImageView image = new ImageView(i);  
      return image;
    }
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
        HBox image = new HBox();
        image.getChildren().add(ci());
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
    
    
     GridPane pane = new GridPane();
     pane.setHgap(10);
     pane.setVgap(10);
     pane.setPadding(new Insets(10));
     
     pane.add(new Text("Name:"), 0, 0);
     TextField name =  new TextField();
     pane.add(name, 1, 0);
    name.setOnKeyTyped( e -> {
     if(e.getCharacter().matches("[a-zA-Z]*"));
         
     else errors.getChildren().add(nameerror);
     
});
     pane.add(new Text("Email:"), 0, 1);
     TextField email =  new TextField();
     pane.add(email, 1, 1);
   
      
     pane.add(new Text("Phone:"), 0, 2);
     TextField phone = new TextField();
     pane.add(phone, 1, 2);
    phone.setOnKeyTyped( e -> {
     if(e.getCharacter().matches("[0-9]*"));
         
     else errors.getChildren().add(phoneerror);
    });
     pane.add(new Text("Password: "), 0, 3);
     PasswordField password = new PasswordField();
     pane.add(password, 1, 3);
     
     password.setOnAction(e -> {
         checkString(password.getText());
     });
     
     
     pane.add(new Text("confirm: "), 0, 4);
     PasswordField confirm = new PasswordField();
     pane.add(confirm, 1, 4);
     confirm.setOnAction(e -> {
         if(password.getText() == null ? confirm.getText() != null : !password.getText().equals(confirm.getText()))
             errors.getChildren().add(passworderror);
       
     });
     
     pane.add(new Text("country:"), 0, 5);
     ComboBox<String> combobox = new ComboBox<String>();
     combobox.getItems().addAll("select...","Lebanon", "usa", "ksa", "uae", "canada");
     combobox.getSelectionModel().select(0);
     pane.add(combobox, 1, 5);
     
     pane.add(new Text("Gender"), 0,6);
     RadioButton rb2 = new RadioButton("Male");
     RadioButton rb3 = new RadioButton("Female");
     final ToggleGroup group = new ToggleGroup();
     rb2.setToggleGroup(group);
     rb3.setToggleGroup(group);
     HBox hboxradio = new HBox();
     hboxradio.setPadding(new Insets(10));
     hboxradio.getChildren().addAll(rb2,rb3);
     pane.add(hboxradio, 1, 6);
     
     pane.add(new Text("Language"), 0,7);
     CheckBox cb1 = new CheckBox();
     CheckBox cb2= new CheckBox();
     CheckBox cb3 = new CheckBox();
     cb1.setText("Arabic");
     cb2.setText("English");
     cb3.setText("French");
     HBox hboxcheckbox = new HBox(20);
     hboxcheckbox.getChildren().addAll(cb1,cb2,cb3);
     hboxcheckbox.setPadding(new Insets(20));
     pane.add(hboxcheckbox, 1, 7);
     
     pane.add(new Text("About you"), 0,8);
     TextArea textarea =new TextArea();
     textarea.setPrefWidth(250); 
     pane.add(textarea, 1, 8);
     
     Button register = new Button();
     register.setText("register");
     register.setPrefSize(width, 20);
     register.setAlignment(Pos.CENTER);
     register.setOnAction(e ->{
         if ( textarea.getLength()<50 )
             errors.getChildren().add(area);
           if( phone.getLength()< 8)
               errors.getChildren().add(phonenumber);
         if(isValid(email.getText())!= true)
             errors.getChildren().add(emailnotvalid);
     });
     HBox hboxbutton = new HBox();
     hboxbutton.getChildren().add(register);
     hboxbutton.setAlignment(Pos.CENTER);
     pane.add(hboxbutton, 0, 9,2,2);
     
     pane.setAlignment(Pos.CENTER);
     pane.getChildren().add(image);
    
     
     
     pane.add(errors,0, 11);
        Scene scene = new Scene(pane,height*2, width*2);
       
        primaryStage.setTitle("login form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
