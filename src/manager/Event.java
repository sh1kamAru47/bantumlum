package manager;

import java.io.IOException;
import java.util.ArrayList;

import elements.EnermyShip;
import elements.Entity;
import elements.ExtraBullet;
import elements.HpMore;
import elements.SpaceShip;
import elements.Stone;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.Point;
import lib.Timer;
import view.controller.GamePlayController;

public class Event {
	private AnchorPane gamePane;
	private SpaceShip spaceShip;
	private Timer timer = new Timer();
	private GamePlayController controller;
	private Text bullet;
	private Text score;
	private ProgressBar hpBar;
	private ArrayList<Entity> E = new ArrayList<Entity>();
	
	private int timeWaitEnermyShip = 10;
	private int timeWaitEtraBullet = 10;
	private int timeWaitStone = 3;
	public Event(GamePlayController controller) {
		hpBar = controller.getHpBar();
		this.controller = controller;
		gamePane = controller.getGamePane();
		spaceShip = controller.getSpaceShip();
		bullet = controller.getCountBullet();
		score = controller.getScore();
	}
	
	public void timeLine(long now) {
		long t = timer.getT();
		timer.setT(now);
		
		if(t != timer.getT()) {
			if(timer.getT()%10==0){
				increase(10);
				keDichBayBay();
				
			}
			nemDaDauTay();
			bonusThemDan();
			if(timer.getT()%timeWaitEnermyShip==0)
				keDichBayBay();
			themHP();

		}
	}
	public void handleKey(boolean isLeftKeyPressed, boolean isRightKeyPressed, boolean isSpaceKeyPressed) {
		//chuyen 3 cai nay ra cho khac.
//		hpBar.setProgress(spaceShip.getHP()/10.0);
//		bullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
//		score.setText("Score: "+ spaceShip.getScore());
		if(spaceShip.canDiChuyen)spaceShip.spaceShipMove(isLeftKeyPressed, isRightKeyPressed);
		
		if (isSpaceKeyPressed && spaceShip.canShoot && spaceShip.getBulletStore() >= spaceShip.getCachBan()) {
			spaceShip.spaceShipAttack(gamePane,E);
			spaceShip.canShoot = false;
			
			PauseTransition shootDelay = new PauseTransition(Duration.seconds(0.2)); 
			shootDelay.setOnFinished(event->{
				spaceShip.canShoot = true;
			});	
			shootDelay.play();
		}
	}
	public void keDichBayBay() {
		EnermyShip enermyShip = new EnermyShip();
		E.add(enermyShip);
		enermyShip.move(spaceShip, gamePane);
	}
	public void increase(int bullets) {
		if (spaceShip.getBulletStore() <= 90) spaceShip.setBulletStore(spaceShip.getBulletStore()+10);
	
          bullet.setText("Bullets: "+String.valueOf(spaceShip.getBulletStore()));
	}
	public void bonusThemDan() {
		ExtraBullet extraBullet = new ExtraBullet();
		extraBullet.move(spaceShip, gamePane);
	}
	public void themHP() {
		HpMore hp = new HpMore();
		
		hp.move(spaceShip, gamePane);
	}
	public void nemDaDauTay() {
		Stone stone = new Stone();
		
		AnimationTimer timer = new AnimationTimer() {
			long lastTime = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
			if(now - lastTime>1e9/10) {
				if(stone.getCenter().getY()<spaceShip.getCenter().getY()-200) {
					Point position = spaceShip.getCenter();
					
					Point vector = new Point();
					vector.setLocation(stone.getCenter());
				
					vector.mul(-1);
			
					vector.add(position);
			
					vector.mul(3.0/vector.doDai());
			
					stone.setVector(vector);
					
				}
				
			}
			}
			
		};timer.start();
		E.add(stone);
		stone.move(spaceShip, gamePane);
	}
//	public void createBossText() {
//		Text bossText = new Text("BOSS");
//		bossText.setFont(Font.font("Arial", FontWeight.BOLD, 96));
//		bossText.setFill(Color.RED);
//		
//        double bossTextX = gamePane.getWidth()/ 2 - bossText.getBoundsInLocal().getWidth() / 2;
//        double bossTextY = gamePane.getHeight() / 2 - bossText.getBoundsInLocal().getHeight() / 2;
//        bossText.setLayoutX(bossTextX);
//        bossText.setLayoutY(bossTextY);
//
//        gamePane.getChildren().add(bossText);
//	}
	public void gameOver() throws IOException {
			Stage stage = new Stage();
			new GameOver(stage);
			spaceShip.setHP(-1);
		
	}
}