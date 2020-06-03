package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NetworkMenuController extends Application {

	@FXML
	private Button ViewMessages;
	@FXML
	private Button ViewReport;
	@FXML
	private Button LogOut;

	@Override
	public void start(Stage primaryStage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/gui/NetworkMenu.fxml"));
    	primaryStage.setTitle("SignUp_Gui");
    	primaryStage.setScene(new Scene(root,236,285));
    	primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
