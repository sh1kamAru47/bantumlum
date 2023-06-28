package view.controller;

import elements.SpaceShip;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import lib.Point;
import lib.Timer;

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
		Timer time = new Timer();
		hpBar.setProgress(1);
		spaceShip = new SpaceShip();
		ImageView Khien = new ImageView(new Image("/resourses/gamekit/spritesheets/khienn.png"));
		Khien.setFitHeight(200);
		Khien.setFitWidth(200);
		
		GamePane.getChildren().add(Khien);
		AnimationTimer timer = new AnimationTimer() {
			Point position = new Point();
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				
				position.setLocation(spaceShip.getPosition());
				Khien.setX(position.getX()-55);
				Khien.setY(position.getY()-55);
				long t = time.getT();
				time.setT(now);
				if(t!=time.getT()) {
					

					if(time.getT()%3==0) {
						int k = spaceShip.getKhien();
						  spaceShip.setKhien(k-1>0?k-1:0);
						  		if(spaceShip.getKhien()<=0) {
									FadeTransition tat = new FadeTransition();
									tat.setNode(Khien);
									tat.setDuration(Duration.seconds(1));
									tat.setToValue(0);
									tat.play();
								}else {
									FadeTransition bat = new FadeTransition();
									bat.setNode(Khien);
									bat.setDuration(Duration.seconds(1));
									bat.setToValue(1);
									bat.play();
									
									
								}
							
							
					}
				  
				}
			}
			
		};timer.start();
		
		
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
