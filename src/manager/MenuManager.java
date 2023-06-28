package manager;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.controller.MenuController;

public class MenuManager extends MenuController {
	private Scene menuScene;

	public MenuManager() throws IOException {
		Parent loader = FXMLLoader.load(getClass().getResource("/view/MenuScene.fxml"));

		menuScene = new Scene(loader);
	}

	public MenuManager(Stage menuStage) throws IOException {
		this();
		menuStage.setScene(menuScene);
		menuStage.centerOnScreen();
		menuStage.setAlwaysOnTop(false);
		menuStage.show();

		Stage creditStage = new Stage();
		Stage helpStage = new Stage();
		Stage playStage = new Stage();

		Button exitButton = (Button) menuScene.lookup("#exitButton");
		exitButton.setOnAction(event -> Platform.exit());

		// CREDITBUTTON
		Button creditButton = (Button) menuScene.lookup("#creditButton");
		creditButton.setOnAction(event -> showCreditStage(creditStage, menuStage));
		// creditButton.setOnAction(event-> menuStage.hide());
// HELP BUTTON
		Button helpButton = (Button) menuScene.lookup("#helpButton");
		helpButton.setOnAction(event -> showHelpStage(helpStage,menuStage));
		// PLAYBUTTON
		Button playButton = (Button) menuScene.lookup("#startButton");
		playButton.setOnAction(event -> menuStage.hide());
		playButton.setOnAction(event -> showPlayStage(playStage, menuStage));
		// playButton.setOnAction(event->menuStage.hide());
	}

	public void showCreditStage(Stage creditStage, Stage menuStage) {
		try {

			Parent creditParent = FXMLLoader.load(getClass().getResource("/view/CreditScene.fxml"));
			Scene creditScene = new Scene(creditParent);
			creditStage.setScene(creditScene);
			creditStage.show();
			menuStage.hide();
			// BACkBUTTON
			Button backButton = (Button) creditParent.lookup("#backButton");
			// backButton.setOnAction(EventHandler -> start(primaryStage));
			backButton.setOnAction(event -> {
				menuStage.show();
				creditStage.hide();
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// HELP SCENE
	public void showHelpStage(Stage helpStage, Stage menuStage) {
		try {
			Parent helpParent = FXMLLoader.load(getClass().getResource("/view/HelpScene.fxml"));
			Scene helpScene = new Scene(helpParent);
			helpStage.setScene(helpScene);
			helpStage.show();
			menuStage.hide();
			// BACkBUTTON
			Button backButton = (Button) helpParent.lookup("#backButton");
			// backButton.setOnAction(EventHandler -> start(primaryStage));
			backButton.setOnAction(event -> {
				menuStage.show();
				helpStage.hide();

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showPlayStage(Stage playStage, Stage menuStage) {
		/*
		 * public void Play(ActionEvent event) throws IOException {
		 * 
		 * menuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 * menuStage.hide();
		 * 
		 * gameStage = new Stage(); new GamePlayManager(gameStage); gameStage.show(); }
		 */

		try {
			new GamePlayManager(playStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playStage.show();
		menuStage.hide();

	}
	
}
