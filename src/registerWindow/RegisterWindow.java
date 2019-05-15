package registerWindow;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import userWindow.User;

public class RegisterWindow {
	
	
	
	

	public void createRegisterWindow() throws IOException {
		
		Stage stage = new Stage();
		
		FXMLLoader loader = new FXMLLoader();
		
		StackPane stackPane = loader.load(getClass().getResource("RegisterWindow.fxml").openStream());
		
		RegisterWindowController controller =(RegisterWindowController) loader.getController();

		
		Scene scene = new Scene(stackPane);
		
		stage.setTitle("Register");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(scene);
		stage.show();
	}
	
	
}
