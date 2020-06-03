package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class typeOrC extends Application {

	@FXML
	private RadioButton RegF;
	
	@FXML
	private RadioButton HomF;
	@Override
	public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Type.fxml"));
        primaryStage.setTitle("Type");
       primaryStage.setScene(new Scene(root, 665, 462));
        primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void choise() throws IOException {
		System.out.println("pressed !!");
	/*	((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fx/RegFuel.fxml"));
        primaryStage.setTitle("FuelOrder");
        primaryStage.setScene(new Scene(root, 550, 550));
        primaryStage.show();*/
	}
}
