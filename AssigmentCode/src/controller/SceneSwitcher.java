package controller;

import java.io.Serializable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * class contains functions for switch the screen in every move.
 *
 */
public class SceneSwitcher implements Serializable {
	private static final long serialVersionUID = 6887899815710461877L;
	/**
	 * defines relevant variables
	 */
	private ActionEvent event;
	private String sceneName;

	/**
	 * constructors for SceneSwitcher
	 */
	public SceneSwitcher(ActionEvent event, String sceneName) {

		this.event = event;
		this.sceneName = sceneName;
	}

	/**
	 * initialize and view main menu screen
	 */
	public boolean swichScene() {
		try {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					try {
						((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
						Stage primaryStage = new Stage();
						primaryStage.setTitle("Main Menu");
						FXMLLoader loader = new FXMLLoader();
						Pane root;
						root = loader.load(getClass().getResource("/gui/" + sceneName + ".fxml").openStream());
						Scene scene = new Scene(root);
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			});
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
