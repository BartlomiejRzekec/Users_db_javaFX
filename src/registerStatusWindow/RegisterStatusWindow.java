package registerStatusWindow;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import registerWindow.RegisterWindowController;

public class RegisterStatusWindow {

	
public void createRegisterStatusWindow() throws IOException {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader();
		
		StackPane stackPane = loader.load(getClass().getResource("RegisterStatusWindow.fxml").openStream());

		Scene scene = new Scene(stackPane);
		
		stage.setTitle("Register");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}
}
