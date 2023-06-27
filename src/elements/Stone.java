package elements;

import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;

public class Stone extends ILU {
	private boolean no = false;
	public Stone(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh,2, vector);
	}
	public Stone() {
		this("/resourses/gamekit/spritesheets/enermy/stoneEnermy/stone1.png",
			 50, 50, new Point(0, 5));
		setPosition(new Point(ThreadLocalRandom.current().nextInt(40,1250), 0));
	}
	
	private double imageAngle = 0;
	
	@Override
	public void effect() {
		getImageView().setRotate(imageAngle);
		imageAngle += 3;
	}
	
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		if(spaceShip.getHP()>0)spaceShip.setHP(spaceShip.getHP()-1>0?spaceShip.getHP()-1:0);
		if(!no)spaceShip.dau();
	}
	public void dau() {//đau
		
		FadeTransition fade = new FadeTransition();
		fade.setNode(getImageView());
		fade.setDuration(Duration.millis(100));
		fade.setCycleCount(4);
		fade.setInterpolator(Interpolator.LINEAR);
		fade.setFromValue(1);
		fade.setToValue(0.1);
		fade.setAutoReverse(true);
		fade.play();
		
	}
	public void no() {//nổ
		no = true;
		String[] FRAME_PATH = {
				"/resourses/gamekit/spritesheets/explosion1.png",
				"/resourses/gamekit/spritesheets/explosion2.png",
				"/resourses/gamekit/spritesheets/explosion3.png",
				"/resourses/gamekit/spritesheets/explosion4.png",
				"/resourses/gamekit/spritesheets/explosion5.png",
				"/resourses/gamekit/spritesheets/explosion6.png",
				"/resourses/gamekit/spritesheets/explosion7.png",
				"/resourses/gamekit/spritesheets/explosion8.png"
		};
		
		AnimationTimer timer = new AnimationTimer() {
			int currentFrame = 0;
			long lastTime = 0;
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				if(currentFrame == 8) {
					this.stop();
					
				}
				if(now - lastTime>=1e9/10) {
					Image image = new Image(FRAME_PATH[currentFrame]);
					getImageView().setImage(image);
					currentFrame++;
					lastTime = now;
				}

			}
			
		};timer.start();
	}
	
}
