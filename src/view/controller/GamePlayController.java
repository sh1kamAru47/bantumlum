package view.controller;

import elements.SpaceShip;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GamePlayController {
	@FXML private AnchorPane GamePane;
	public AnchorPane getGamePane() {
		return GamePane;
	}
	@FXML private ProgressBar hpBar;
	public ProgressBar getHpBar() {
		return hpBar;
	}

	public void setHpBar(ProgressBar hpBar) {
		this.hpBar = hpBar;
	}
	@FXML private ImageView background;
	@FXML private Text countBullet;
	@FXML private Text score;


	public Text getCountBullet() {
		return countBullet;
	}

	public void setCountBullet(Text countBullet) {
		this.countBullet = countBullet;
	}

	public Text getScore() {
		return score;
	}

	public void setScore(Text score) {
		this.score = score;
	}

	public void initialize() {
		hpBar.setProgress(1);
		spaceShip = new SpaceShip();
		GamePane.getChildren().add(spaceShip.getImageView());

		countBullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		hpBar.setProgress(spaceShip.getHP()/10.0);
		//bullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		score.setText("Score: "+ spaceShip.getScore());
	}
	
	public void createMoveBackground() {
		if (background.getLayoutY() < 0)
			background.setLayoutY(background.getLayoutY()+0.5);
	
	}
	

	private SpaceShip spaceShip;
	public SpaceShip getSpaceShip() {
		return spaceShip;
	}

	private boolean canShoot = true;
	private Text bossText;
	
	
	public void displayInfor() {
		countBullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		hpBar.setProgress(spaceShip.getHP()/10.0);
		//bullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
		score.setText("Score: "+ spaceShip.getScore());
	}

	
	
}