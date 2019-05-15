package mainWindow;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;


public class MainWindow extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MainWindow.fxml"));
			StackPane stackPane = loader.load();
			
			Scene scene = new Scene(stackPane);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			stackPane.getChildren().add(MenuUtilities.prepareMenu());
			stackPane.setAlignment(Pos.TOP_CENTER);
			
			primaryStage.setTitle("User Service");
			primaryStage.setOnCloseRequest(event -> MainWindowController.closeApplication());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
