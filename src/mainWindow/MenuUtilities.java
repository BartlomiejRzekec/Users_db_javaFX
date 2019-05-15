package mainWindow;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuUtilities {

	public static MenuBar prepareMenu() {
		
		MenuBar menuBar = new MenuBar();
		
		Menu menu = createMenuFile();
		MenuItem menuItemClose = createMenuItemClose();
		
		menu.getItems().add(menuItemClose);
		menuBar.getMenus().add(menu);
		
		return menuBar;
		
	}
	
	private static Menu createMenuFile() {
		Menu menu = new Menu("File");
		return menu;
	}
	
	private static MenuItem createMenuItemClose() { 
		MenuItem menuItem = new MenuItem("Close");
		menuItem.setOnAction(event -> MainWindowController.closeApplication());
		return menuItem;
		
	}
}
