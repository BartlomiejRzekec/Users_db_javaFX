package registerStatusWindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RegisterStatusController implements Initializable{
	
	
	@FXML
	Button registerStatusButton;
	
	@FXML
	Label registerSatusLabel;

	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		registerSatusLabel.setText("You are registered, you can log in");
		
	}
	
	public void closeRegisterStatusWindow() {
		Stage stage = (Stage) registerStatusButton.getScene().getWindow();
		stage.close();
	}

}
