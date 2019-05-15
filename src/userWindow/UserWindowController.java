package userWindow;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class UserWindowController implements Initializable{

	
	@FXML
    private TableView<User> userTableView;
	
	@FXML
	private TableColumn<User, Integer> columnId;
	@FXML
	private TableColumn<User, String> columnUsername;
	@FXML
	private TableColumn<User, String> columnSex;
	@FXML
	private TableColumn<User, String> columnCar;

	
	private ObservableList<User> listOfUsers = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		columnId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
		columnUsername.setCellValueFactory(new PropertyValueFactory<User, String>("userName"));
		columnSex.setCellValueFactory(new PropertyValueFactory<User, String>("sex"));
		columnCar.setCellValueFactory(new PropertyValueFactory<User, String>("car"));
		
		try {
			userTableView.setItems(setTableView());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public  ObservableList<User> setTableView() throws SQLException {
		
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection = connectionClass.getConnection();
		
		String sql = "SELECT id_users, userName, sex, car FROM users";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			User user = new User();
			user.setId(resultSet.getInt(1));
			user.setUserName(resultSet.getString("userName"));
			user.setSex(resultSet.getString("sex"));
			user.setCar(resultSet.getString("car"));
			System.out.println(user);
			
			listOfUsers.add(user);
			
		}
		
		return listOfUsers;
	}

}
