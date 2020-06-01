package controller;

import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class MainMenuController extends Application implements Initializable {
public static void main(String[] args) {
	launch(args);
}
//	@FXML
//	private JFXTabPane tabContainer;

	@FXML
	private Tab userProfileTab;

	@FXML
	private Tab settingsTab;

	@FXML
	private Tab logoutTab;

	/// 2.
	private double tabWidth = 90.0;
	public static int lastSelectedTabIndex = 0;

	

	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Parent root =
	
		// FXMLLoader.load(getClass().getResource("/application/ServerPort.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("/controller/MMA.fxml"));
		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("/gui/ServerPort.css").toExternalForm());
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//tabContainer.setSide(Side.LEFT);
	}
}
