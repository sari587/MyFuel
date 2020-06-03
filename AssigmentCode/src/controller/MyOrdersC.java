package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyOrdersC extends Application {
	
	@FXML
	private Button Add;
	
	@FXML
	private Button Trck;
	

	@Override
	public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/gui/MyOrders.fxml"));
        primaryStage.setTitle("MyOrders");
       primaryStage.setScene(new Scene(root, 705, 577));
        primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
	public void addBtn(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Type.fxml"));
        primaryStage.setTitle("Type");
        primaryStage.setScene(new Scene(root, 665, 462));
        primaryStage.show();
	}
}
