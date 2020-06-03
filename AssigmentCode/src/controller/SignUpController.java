package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import Entity.Account;
import Entity.CreditCard;
import Server.mysqlConnection;
import client.ClientUI;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SignUpController extends Application {
	@FXML
	private TextField emailField;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private TextField name;
	@FXML
	private TextField fname;
	@FXML
	private TextField idnum;

	ObservableList<String> Items = FXCollections.observableArrayList("Cash", "Credit Card");
	ObservableList<String> Items1 = FXCollections.observableArrayList("MasterCard", "Visa");

	@FXML
	private Button submitButton;
	@FXML
	private ComboBox<String> combobox;
	@FXML
	private ComboBox<String> combobox1;
	@FXML
	private ImageView MasterCardIcon;
	@FXML
	private ImageView VisaIcon;
	@FXML
	private Label Text;
	@FXML
	private Label Text1;
	@FXML
	private Label Text2;
	@FXML
	private Label Text3;
	@FXML
	private Label Text4;
	@FXML
	private Label Text5;
	@FXML
	private Label Text6;
	@FXML
	private Label Text7;
	@FXML
	private TextField CCOwner;
	@FXML
	private TextField CCNumber;
	@FXML
	private TextField CCMDate;
	@FXML
	private TextField CCYDate;
	@FXML
	private TextField CCC;

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/SignUp.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setTitle("Student Managment Tool");
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	public void OnComboBoxSelected() {

		if (combobox.getValue().equals("Credit Card")) {
			Text.setDisable(false);
			Text1.setDisable(false);
			combobox1.setDisable(false);
		} else {
			MasterCardIcon.setOpacity(.5);
			VisaIcon.setOpacity(.5);
			Text.setDisable(true);
			Text1.setDisable(true);
			combobox1.setDisable(true);
			Text2.setDisable(true);
			Text3.setDisable(true);
			Text4.setDisable(true);
			Text5.setDisable(true);
			Text6.setDisable(true);
			Text7.setDisable(true);
			CCOwner.setDisable(true);
			CCNumber.setDisable(true);
			CCMDate.setDisable(true);
			CCYDate.setDisable(true);
			CCC.setDisable(true);
			// combobox1.setValue("Select");
		}

	}

	public void OnComboBoxSelected1() {
		Text2.setDisable(false);
		Text3.setDisable(false);
		Text4.setDisable(false);
		Text5.setDisable(false);
		Text6.setDisable(false);
		Text7.setDisable(false);
		CCOwner.setDisable(false);
		CCNumber.setDisable(false);
		CCMDate.setDisable(false);
		CCYDate.setDisable(false);
		CCC.setDisable(false);
		if (combobox1.getValue().equals("MasterCard")) {
			MasterCardIcon.setOpacity(1.0);
			VisaIcon.setOpacity(.5);
		} else {
			VisaIcon.setOpacity(1.0);
			MasterCardIcon.setOpacity(.5);
		}
	}

	@FXML
	private void initialize() {
		Image Micon = new Image("/gui/MasterCardIcon.png");
		Image Vicon = new Image("/gui/VisaIcon.png");
		MasterCardIcon.setImage(Micon);
		VisaIcon.setImage(Vicon);
		combobox.setItems(Items);
		combobox1.setItems(Items1);
		// combobox1.getItems().addAll("MasterCard","Visa");
		// ombobox.getItems().addAll("Cash","Credit Card");
	}

	public void SignUpClick() throws SQLException {
		// ClientUI.chat.accept("Client SignUp");
		// ClientUI.chat.accept("SignUp");
		if (username.getText().isEmpty() || password.getText().isEmpty() || name.getText().isEmpty()
				|| fname.getText().isEmpty() || idnum.getText().isEmpty() || emailField.getText().isEmpty()) {
			Window owner = submitButton.getScene().getWindow();
			AlertHelper.showAlert(Alert.AlertType.ERROR, owner, "Alert Message", "Please fill all the fields");
		} else {
			CreditCard cc;
			if (!combobox.getValue().equals("Credit Card"))
				cc = null;
			else
				cc = new CreditCard(Integer.parseInt(CCNumber.getText()), Integer.parseInt(CCC.getText()),
						Integer.parseInt(CCMDate.getText()), Integer.parseInt(CCYDate.getText()));

			Account account = new Account(username.getText(), password.getText(), Account.status.Customer,
					name.getText(), fname.getText(), Integer.parseInt(idnum.getText()), emailField.getText(), cc, 0);
			Packet packet = new Packet(Packet.actions.singup, account);
			ClientUI.chat.accept(packet);
			Window owner = submitButton.getScene().getWindow();
			AlertHelper.showAlert(Alert.AlertType.INFORMATION, owner, "Alert Message",
					" " + username.getText() + " Has been succesfully Added");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
