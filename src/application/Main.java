package application;

import manager.MenuManager;
import view.controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage mainStage = new Stage();
	
	@Override
	public void start(Stage arg0) throws Exception {
		new MenuManager(mainStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
