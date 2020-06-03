package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ProfileController extends Application {

	@FXML
	private Label AdminProfile;

	@FXML
	private Label FullName;

	@FXML
	private Label Emale;

	@FXML
	private Label IdNumber;

	@FXML
	private Label CustomerType;

	@FXML
	private ImageView ProfileImage;

	@Override
	public void start(Stage primaryStage) throws IOException  {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/profile.fxml"));
    	primaryStage.setTitle("SignUp_Gui");
    	primaryStage.setScene(new Scene(root,472,515));
    	primaryStage.show();
    	
    	
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}

}
