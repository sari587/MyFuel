package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MarketingMenuController extends Application {

	@FXML
	private Button ViewRates;
	@FXML
	private Button Customerperiodiccharacteriazationreport;
	@FXML
	private Button ReportForamarketingsaleresponse;
	@FXML
	private Button LaunchSale;
	@FXML
	private Button LogOut;

	@Override
	public void start(Stage primaryStage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/MarketingMenu.fxml"));
    	primaryStage.setTitle("SignUp_Gui");
    	primaryStage.setScene(new Scene(root,422,440));
    	primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
