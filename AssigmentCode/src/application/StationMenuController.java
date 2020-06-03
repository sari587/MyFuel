package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StationMenuController extends Application {

	@FXML
	private Button ThreeShouldLevel;

	@FXML
	private Button InventoruAmountOfItemsReport;
	@FXML
	private Button PeportByProductTypes;
	@FXML
	private Button QuarterlyIncomeReport;
	@FXML
	private Button Mail;
	@FXML
	private Button LogOut;

	@FXML
	private ComboBox AmountInStock;
	
	@FXML
	private TextField ThreeShouldLevel1;
	
	@FXML
	private TextField AmountInStock1;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/StationMenu.fxml"));
    	primaryStage.setTitle("SignUp_Gui");
    	primaryStage.setScene(new Scene(root,454.4,456));
    	primaryStage.show();
	}

	

	public static void main(String[] args) {
		launch(args);
	}
}
