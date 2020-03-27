package loose.oose.fis.lab.student.manager.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

import java.util.*; import java.lang.*; import java.net.*; import java.applet.*; import java.io.*; import java.awt.*;
import java.io.StringWriter;
import java.io.PrintWriter;

public class LoginController {
    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField usernameField;

    @FXML
    public void handleLoginButtonAction(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        if( username == null || username.isEmpty()){
            loginMessage.setText("Please type in a username!");
            return;
        }
        if( password == null || password.isEmpty()){
            loginMessage.setText("Password cannot be empty!");
            return;
        }
        if(username.equals("student") && password.equals("student")){
            loginMessage.setText("Logged in as a student!");
            return;
        }
        if (username.equals("teacher") && password.equals("teacher")) {
            try {
                Stage stage = (Stage) loginMessage.getScene().getWindow();
                Parent viewStudentsRoot = FXMLLoader.load(getClass().getResource("../fxml/view-students.fxml"));
                Scene scene = new Scene(viewStudentsRoot, 600, 400);
                stage.setScene(scene);
            } catch (IOExeption e) {
                e.printStackTrace();
            }

            return;
        }

        loginMessage.setText("Incorrect login!");
    }
}