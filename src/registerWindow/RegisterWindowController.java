package registerWindow;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import registerStatusWindow.RegisterStatusWindow;
import userWindow.Car;

public class RegisterWindowController implements Initializable{

	
	@FXML
	Button registerCancelButton;
	
	@FXML
	TextField registerUsernameField, registerPasswordField;
	
	@FXML
	RadioButton femaleRadioButton, maleRadioButton;
	
	@FXML
	ComboBox<Car> carComboBox;
	

	
	private static ToggleGroup toggleGroup;
	private static String carModel;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ObservableList<Car> listOfCars = FXCollections.observableArrayList(
				new Car("Mercedes"),
				new Car("BMW"),
				new Car("Audi"),
				new Car("Bentley")
				);
		
		carComboBox.setItems(listOfCars);
		
		List<RadioButton> radioButtonList = Arrays.asList(femaleRadioButton, maleRadioButton);
		
		addRadioButtonsToToggle(radioButtonList);
		addComboBoxAction();
		
	}

	
	public void registerUser() throws SQLException, IOException {
		
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		
		RadioButton clickedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
		String sexValue = clickedRadioButton.getText();
		
		
		
		String sql = "INSERT INTO users (userName, password, sex, car) VALUES ('" + registerUsernameField.getText() +
																			"', '" + registerPasswordField.getText() +
																			"', '" + sexValue +
																			"', '" + carModel +
																			"')";
		Statement statement = connection.createStatement();		
		statement.executeUpdate(sql);
		
		openRegisterStatusWindow();
		
	}
	
	
	private void addRadioButtonsToToggle(List<RadioButton> list) { 
		toggleGroup = new ToggleGroup();
		list.forEach(e -> settingRadioButtons(e));
		
	}
	
	private void settingRadioButtons(RadioButton rb) {
		rb.setToggleGroup(toggleGroup);
	}
	
	
	
	
	public void addComboBoxAction() {
		
		carComboBox.getSelectionModel().selectedItemProperty().addListener(RegisterWindowController::carsFromComboBox);
		
	}
	
	private static void carsFromComboBox(ObservableValue<? extends Car> observable, Car oldValue, Car newValue) {
		if(newValue != null) {
			carModel = String.valueOf(newValue.getModel());
		}
	}
	
	
	
	public void openRegisterStatusWindow() throws IOException {
		RegisterStatusWindow register = new RegisterStatusWindow();
		register.createRegisterStatusWindow();
	}
	
	public void closeRegisterWindow() {
		Stage stage = (Stage) registerCancelButton.getScene().getWindow();
		stage.close();
	}

}
