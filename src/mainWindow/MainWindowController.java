package mainWindow;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import registerWindow.RegisterWindow;
import registerWindow.RegisterWindowController;
import userWindow.User;
import userWindow.UserWindow;

public class MainWindowController implements Initializable{

	
	@FXML
	TextField userNameField;
	
	@FXML
	PasswordField passwordField;
	
	@FXML
	Label statusLabel;
	
	@FXML
	Button logInButton, signUpButton, usersButton, logoutButton;
	
	String logoutMessage = "Not connected! Please log in";
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		statusLabel.setText(logoutMessage);
		usersButton.setDisable(true);
		logoutButton.setDisable(true);
	}
	
	
	public void login() throws SQLException {
		
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		
		String sql = "SELECT * FROM users WHERE userName = '" + userNameField.getText() + "' AND password = '" + passwordField.getText() + "'";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()) {
			statusLabel.setText("User " + userNameField.getText() + " is connected");
			logInButton.setDisable(true);
			signUpButton.setDisable(true);
			usersButton.setDisable(false);
			logoutButton.setDisable(false);
		}
		else {
			statusLabel.setText("Wrong username or password!");
		}
		
	}
	
	public void logoutAction() {
		
		statusLabel.setText(logoutMessage);
		logInButton.setDisable(false);
		signUpButton.setDisable(false);
		usersButton.setDisable(true);
		logoutButton.setDisable(true);
	}
	
	public void openUserWindow() throws IOException {

		UserWindow userWindow = new UserWindow();
		userWindow.createUserWindow();
		
	}
	
	public void openRegisterWindow() throws IOException {

		RegisterWindow registerWindow = new RegisterWindow();
		registerWindow.createRegisterWindow();
	}
	
	public static void closeApplication() {
		Platform.exit();
		System.exit(0);
	}
	
}
