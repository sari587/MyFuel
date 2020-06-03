package controller;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainMenuController {

    @FXML
    private JFXTabPane tabContainer;
	@FXML
	private Button Add;
	@FXML
	private Button Trck;
    @FXML
    private Tab userProfileTab;
    private String s;
    @FXML
    private AnchorPane userProfileContainer;
    @FXML
    private  Tab[] n;
    
    @FXML
    private Tab settingsTab;
    @FXML
    private Tab ordersTab;
    @FXML
    private AnchorPane OrdersContainer;
    @FXML
    private Tab PaymentsTap;
    @FXML
    private AnchorPane PaymentsCountainer;
    @FXML
    private AnchorPane settingsContainer;

    @FXML
    private Tab logoutTab;


    private double tabWidth = 90.0;
    public static int lastSelectedTabIndex = 0;

    /// Life cycle

    @FXML
    public void initialize() {
    	System.out.println("asdasd");
    	  n=new Tab[] {userProfileTab,ordersTab,PaymentsTap,settingsTab,logoutTab};
        configureView();
    }

    /// Private

    private void configureView() {
    	
        tabContainer.setTabMinWidth(tabWidth);
        tabContainer.setTabMaxWidth(tabWidth);
        tabContainer.setTabMinHeight(tabWidth);
        tabContainer.setTabMaxHeight(tabWidth);
        tabContainer.setRotateGraphic(true);

        EventHandler<Event> replaceBackgroundColorHandler = event -> {
            lastSelectedTabIndex = tabContainer.getSelectionModel().getSelectedIndex();
            Tab currentTab = (Tab) event.getTarget();
            //System.out.println("123");
          for (Tab i:n) {
        	  if(currentTab.getId().equals(i.getId()))
        		  i.setStyle("-fx-background-color: -fx-focus-color;");
        		 
        	  else 
        		  i.setStyle("");
		}
           
            
        };

        EventHandler<Event> logoutHandler = event -> {
            Tab currentTab = (Tab) event.getTarget();
            if (currentTab.isSelected()) {
                tabContainer.getSelectionModel().select(lastSelectedTabIndex);

                // TODO: logout action
                // good place to show Dialog window with Yes / No question
                System.out.println("Logging out!");
            }
        };

        configureTab(userProfileTab, "User\nProfile", "/gui/user-profile.png", userProfileContainer, getClass().getResource("userprofile.fxml"), replaceBackgroundColorHandler);
        configureTab(settingsTab, "Settings", "/gui/settings.png", settingsContainer, getClass().getResource("settings.fxml"), replaceBackgroundColorHandler);
        configureTab(ordersTab, "Orders", "/gui/settings.png", OrdersContainer, getClass().getResource("settings.fxml"), replaceBackgroundColorHandler);
        configureTab(PaymentsTap, "Payments", "/gui/settings.png", PaymentsCountainer, getClass().getResource("settings.fxml"), replaceBackgroundColorHandler);
        configureTab(logoutTab, "Logout", "/gui/logout.png", null, null, logoutHandler);

        userProfileTab.setStyle("-fx-background-color: -fx-accent;");
    }

    private void configureTab(Tab tab, String title, String iconPath, AnchorPane containerPane, URL resourceURL, EventHandler<Event> onSelectionChangedEvent) {
        double imageWidth = 40.0;

        ImageView imageView = new ImageView(new Image(iconPath));
        imageView.setFitHeight(imageWidth);
        imageView.setFitWidth(imageWidth);

        Label label = new Label(title);
        label.setMaxWidth(tabWidth - 20);
        label.setPadding(new Insets(5, 0, 0, 0));
        label.setStyle("-fx-text-fill: black; -fx-font-size: 8pt; -fx-font-weight: normal;");
        label.setTextAlignment(TextAlignment.CENTER);

        BorderPane tabPane = new BorderPane();
        tabPane.setRotate(90.0);
        tabPane.setMaxWidth(tabWidth);
        tabPane.setCenter(imageView);
        tabPane.setBottom(label);

        tab.setText("");
        tab.setGraphic(tabPane);

        tab.setOnSelectionChanged(onSelectionChangedEvent);

        if (containerPane != null && resourceURL != null) {
            try {
                Parent contentView = FXMLLoader.load(resourceURL);
                containerPane.getChildren().add(contentView);
                AnchorPane.setTopAnchor(contentView, 0.0);
                AnchorPane.setBottomAnchor(contentView, 0.0);
                AnchorPane.setRightAnchor(contentView, 0.0);
                AnchorPane.setLeftAnchor(contentView, 0.0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	public void addBtn() throws Exception {
		//((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Type.fxml"));
        primaryStage.setTitle("Type");
        primaryStage.setScene(new Scene(root, 665, 462));
        primaryStage.show();
	}

}