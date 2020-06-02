package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Entity.LoginAssistant;
import client.ClientUI;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController extends Application implements Initializable {
	public static LoginController lc;
	@FXML
	private JFXTextField emailField;
	@FXML
	private MediaView mediaView;

	@FXML
	private JFXPasswordField passwordField;

	@FXML
	private JFXButton submitButton;

	@FXML
	private Stage primaryStage;
	@FXML
	private ActionEvent event;
	@FXML
	private Parent root;
	
	Window owner ;

	
	private  SceneSwitcher sc;
	@FXML
	public void handleSubmitButtonAction(ActionEvent event) {
		this.owner = submitButton.getScene().getWindow();

		if (emailField.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter your Username");
			return;
		}
		if (passwordField.getText().isEmpty()) {
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
			return;
		}

		LoginAssistant login = new LoginAssistant(emailField.getText(), passwordField.getText());
		Packet loginPacket = new Packet(Packet.actions.login, login);
		this.event = event;
		
		this.sc = new SceneSwitcher(event,"CustomerMain");
		lc = this;
		ClientUI.chat.accept(loginPacket);
		
	}

	public void ShowBtn(ActionEvent event) throws Exception {

		((javafx.scene.Node) event.getSource()).getScene().getWindow().hide();
		FXMLLoader loader = new FXMLLoader();
		Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/gui/SignUp.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setTitle("SignUp_Gui");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/LoginGui.fxml"));
		primaryStage.setTitle("Login_Gui");

		primaryStage.setScene(new Scene(root, 800, 450));
		primaryStage.show();
		this.primaryStage = primaryStage;

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void handleLoginFromServer(Object serverAnwer) throws IOException {
		Packet op = (Packet) serverAnwer;
		Window owner = submitButton.getScene().getWindow();
		System.out.println((String) op.GetObj());
		
		if (((String) op.GetObj()).equals("noUsername")) {
			System.out.println("there is no such uesrname");
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Alert Message",
					"There is no such User please contact company Marketin grep");
		}
		
		if (((String) op.GetObj()).equals("worgpass")) {
			System.out.println("wrong password Please try again");
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Alert Message", "Wrong password Please try again");

		}
		if (((String) op.GetObj()).equals("success")) {
            sc.swichScene();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Media media = new Media("file:///C:/Snowy.mp4");
		MediaPlayer player = new MediaPlayer(media);
		mediaView.setMediaPlayer(player);
		player.setVolume(0);
		player.play();
	}

}