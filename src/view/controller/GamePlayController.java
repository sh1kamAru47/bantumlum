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
	@FXML private ImageView background1;
	@FXML private ImageView background2;
	@FXML private Text countBullet;
	@FXML private Text score;
	@FXML private ProgressBar ultiBar;
	public ProgressBar getUltiBar() {
		return ultiBar;
	}
	public void setUltiBar(ProgressBar ultiBar) {
		this.ultiBar = ultiBar;
	}
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
	private int countBackground = 1;
	public void createMoveBackground() {
		background1.setLayoutY(background1.getLayoutY()+0.5);
		background2.setLayoutY(background2.getLayoutY()+0.5);
		if (background1.getLayoutY()> 808) {
			background1.setLayoutY(-808);
		}
		if (background2.getLayoutY() > 808) {
			background2.setLayoutY(-808);
		}
		if (countBackground > 5) {
			//win// 
		}
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
		ultiBar.setProgress(spaceShip.getUltiCount()/3.0);
		score.setText("Score: "+ spaceShip.getScore());
	}

	
	
}
