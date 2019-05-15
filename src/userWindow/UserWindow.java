package userWindow;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserWindow {

	
	public void createUserWindow() throws IOException {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader();
		
		StackPane stackPane = loader.load(getClass().getResource("UserWindow.fxml"));
		
		Scene scene = new Scene(stackPane);
		
		stage.setTitle("Users");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}
}
