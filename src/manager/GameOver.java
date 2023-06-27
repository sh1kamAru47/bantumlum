package manager;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.controller.GameOverController;

public class GameOver extends GamePlayManager {

	Stage playStage = new Stage();
	Stage menuStage = new Stage();

	public GameOver(Stage gameOverStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/view/GameOver.fxml"));
		Scene scene = new Scene(root, 1280, 800);
		gameOverStage.setScene(scene);
		gameOverStage.show();

		Button playAgainButton = (Button) root.lookup("#playAgainButton");
		// playAgainButton.setOnAction(event -> gameOverStage.hide());
		playAgainButton.setOnAction(event -> showPlayStage(playStage, gameOverStage));

		Button mainMenuButton = (Button) root.lookup("#mainMenuButton");
		mainMenuButton.setOnAction(event -> showMainMenuStage(gameOverStage, menuStage));

		// mainMenuButton.setOnAction(event-> )

	}

	public void showPlayStage(Stage playStage, Stage gameOverStage) {
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
		gameOverStage.hide();

	}

	public void showMainMenuStage(Stage gameOverStage, Stage menuStage) {
		try {
			new MenuManager(menuStage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		menuStage.show();
		gameOverStage.hide();
	}
}
