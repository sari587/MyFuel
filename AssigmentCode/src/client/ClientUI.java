package client;


import controller.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static ClientController chat;

	public static void main( String args[] ) throws Exception
	   { 
		    launch(args);  
	   } // end main
	 
	@Override
	public void start(Stage primaryStage) throws Exception {
		 chat= new ClientController("localhost", 5555);
			// TODO Auto-generated method stub
		
		LoginController aFrame = new LoginController(); // create StudentFrame
		 aFrame.start(primaryStage);
	}
	
	
}
