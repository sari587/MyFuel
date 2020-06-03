package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditcreditController extends Application {
	@FXML
	private Button clickclose;
	@FXML
	private Button Visa;
	@FXML
	private Button Mastercard;
	@FXML
	private Button Isracard;
	@FXML
	private Button Save;
	
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/Editcaredit.fxml"));

		//Scene scene = new Scene(root);

		primaryStage.setTitle("Academic Managment Tool");
		
		primaryStage.setScene(new Scene(root,550,550));
		primaryStage.show();

	}

	public void onclick() throws Exception {

		/*FXMLLoader loader = new FXMLLoader();

		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/application/ServerPort.fxml").openStream());// cahnge to the
																										// right
																										// controller
																										// and FXML
		ServerPortFrameController AcademicFrameController = loader.getController();
		AcademicFrameController.start(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setTitle("Academic Managment Tool");

		primaryStage.setScene(scene);
		primaryStage.show();*/
}
	public void PaymentType() throws Exception
	{
	}
	public static void main(String[] args) {
		launch(args);
	}
}
