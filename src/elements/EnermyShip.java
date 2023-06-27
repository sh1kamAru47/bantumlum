package elements;



import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;

public class EnermyShip extends Enermy{

	public EnermyShip(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh,3);
	}
	public EnermyShip() {
		this("/resourses/gamekit/spritesheets/enermy/enemyOverlord.png", 150, 100);
		Random random = new Random();
		this.setPosition(new Point(random.nextDouble()*1000, 10));
		setEndPosition(new Point(random.nextDouble()*1000, random.nextDouble()*400));
	}
	@Override
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		pane.getChildren().add(getImageView());
		Point vector = new Point();
		vector.setLocation(getEndPosition());
		vector.sub(getCenter());
		double x = vector.doDai();
		vector.mul(5.0/x);
		Point position = getPosition();
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				
				position.add(vector);
				setPosition(position);
				if(getCenter().distance(getEndPosition())<5) {
					this.stop();
					TranslateTransition ef = new TranslateTransition();
					ef.setNode(getImageView());
					ef.setDuration(Duration.seconds(2));
					ef.setAutoReverse(true);
					ef.setCycleCount(TranslateTransition.INDEFINITE);
					ef.setByX(100);
					ef.play();
				
				}
			
			}
			
		};timer.start();
		
		
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		// TODO Auto-generated method stub
		
	}
	public void no() {//nổ
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
	
	