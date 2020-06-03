package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class LoginController extends Application  {
	@FXML
	private MediaView mediaView;
	public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/controller/Login.fxml"));
        primaryStage.setTitle("Login_Gui");
       primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}
	public void initialize(URL url,ResourceBundle rb)
	{
		Media media =new Media("");
	}
}
