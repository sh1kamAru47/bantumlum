package view.controller;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import manager.GameOver;
import manager.GamePlayManager;
import manager.MenuManager;

public class GameOverController  {
	/*public GameOverController() throws IOException {
		super();
		Stage gameOverStage = new Stage();
		Stage playStage = new Stage();
		Parent gameOverParent = FXMLLoader.load(getClass().getResource("/view/GameOver.fxml"));

		Scene gameOverScene = new Scene(gameOverParent);
		gameOverStage.setScene(gameOverScene);
		Button playAgainButton = (Button) gameOverScene.lookup("#playAgainButton");
	//	playAgainButton.setOnAction(event -> gameOverStage.hide());
		playAgainButton.setOnAction(event -> showPlayStage(playStage));

	}

	public void showPlayStage(Stage playStage) {
		
		 * public void Play(ActionEvent event) throws IOException {
		 * 
		 * menuStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 * menuStage.hide();
		 * 
		 * gameStage = new Stage(); new GamePlayManager(gameStage); gameStage.show(); }
		 

		try {
			new GamePlayManager(playStage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playStage.show();
	}
	*/
}
