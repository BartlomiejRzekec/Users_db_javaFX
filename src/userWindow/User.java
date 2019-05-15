package userWindow;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {

	private SimpleStringProperty userName;
	private SimpleStringProperty sex;
	private SimpleStringProperty car;
	private SimpleIntegerProperty id;
	
	
	
	
	public int getId() {
		return id.get();
	}
	public SimpleIntegerProperty idProperty() {
		return id;
	}
	
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	
	
	public String getUserName() {
		return userName.get();
	}
	public SimpleStringProperty UserNameProperty() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = new SimpleStringProperty(userName);
	}

	public SimpleStringProperty SexProperty() {
		return sex;
	}
	public String getSex() {
		return sex.get();
	}

	public void setSex(String sex) {
		this.sex = new SimpleStringProperty(sex);
	}

	public SimpleStringProperty CarProperty() {
		return car;
	}
	public String getCar() {
		return car.get();
	}

	public void setCar(String car) {
		this.car = new SimpleStringProperty(car);
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", sex=" + sex + ", car=" + car + "]";
	}
	
	

}
