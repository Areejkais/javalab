/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Labassignment4 extends Application {
     TextField username = new TextField();
   TextField password = new TextField();
    String filename;
    File file = new File("users.txt");
     public boolean check (){
         try {
             Scanner scanfile = new Scanner(file);
            while(scanfile.hasNext()){
               
               if(scanfile.next().equalsIgnoreCase(username.getText())){
                  checkpass();
                  return true;
               }
              
               else {
                   Alert a = new Alert(CONFIRMATION);
                   a.setTitle("username not found");
               }
                  

               
            }
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Labassignment4.class.getName()).log(Level.SEVERE, null, ex);
         }
     return false;
     }
     public boolean checkpass(){
         try {
             Scanner scanfile = new Scanner(file);
             while(scanfile.hasNext()){
               if(scanfile.next(). equalsIgnoreCase(password.getText())){
                   Alert b = new Alert(CONFIRMATION);
                   b.setTitle("login successful");
                   return true;
               }
               else {
                   Alert a = new Alert(CONFIRMATION);
                   a.setTitle("password not found");
                   return false;
               }
         }
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Labassignment4.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
     }
    @Override
    public void start(Stage primaryStage) {

      
       GridPane pane = new GridPane();
       pane.setAlignment(Pos.CENTER);
       pane.setPadding(new Insets(10));
       pane.setHgap(10);
       pane.setVgap(10);
       
       pane.add(new Label("username"), 0, 0);
        pane.add(username, 1, 0);
        username.getText();
        pane.add(new Label("password"), 0, 1);
        pane.add(password,1, 1);
        password.getText();
        
        Button log = new Button("login");
        log.setOnAction(e->{
            check();
           if(checkpass()== true){
           Scene s = new Scene(new Label("you logged in"));
           primaryStage.setScene(s);
           primaryStage.show();
           }   
        });

        pane.add(log, 1, 2);
       
       
        Scene scene = new Scene(pane, 300, 200);
        
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
