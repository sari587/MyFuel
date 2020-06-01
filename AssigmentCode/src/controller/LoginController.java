package controller;

import java.io.IOException;

import client.ClientUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController extends Application{
  
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        Window owner = submitButton.getScene().getWindow();
        
        if(emailField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter your Username");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", 
                    "Please enter a password");
            return;
        }

        AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, owner, "Login Successful!", 
                "Welcome " + emailField.getText());
       // ClientUI.chat.accept("")
    }
    public void ShowBtn(ActionEvent event) throws Exception {
    	
    	
    	((javafx.scene.Node) event.getSource()).getScene().getWindow().hide();
    	FXMLLoader loader = new FXMLLoader();
    	Stage primaryStage = new Stage();
    	Pane root = loader.load(getClass().getResource("/controller/SignUp.fxml").openStream());
    	Scene scene = new Scene(root);
    	primaryStage.setTitle("SignUp_Gui");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/controller/LoginGUI.fxml"));
        primaryStage.setTitle("Login_Gui");
       primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}

}