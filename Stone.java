package GameElements;

import lib.Point;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;

public class Stone extends Enermy{
	
	public Stone(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh);
	}
	public Stone() {
		this("/resourses/gamekit/spritesheets/enermy/stoneEnermy/stone1.png", 50, 50);
		setPosition(new Point(ThreadLocalRandom.current().nextInt(100,301), 0));
	}
	
	private static final double SPEED = -5;
	private double imageAngle;
	
	@Override
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		pane.getChildren().add(this.getImageView());
		Point position = getPosition();
		
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				position.setLocation(getPosition().getX(), getPosition().getY() - SPEED);
				setPosition(position);
				
				if (position.getY() > 650) {
					pane.getChildren().remove(getImageView());
					this.stop();// stop animationTimer
					return;
				}
				
				if (hasVaCham(spaceShip)) {
					System.out.println("BOOM");
					pane.getChildren().remove(getImageView());
					this.stop();
					attack(spaceShip, pane);
					return;
				}
				
				getImageView().setRotate(imageAngle);
				imageAngle += 3;
			}
		};
		timer.start();
	}

	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		spaceShip.getImageView().setRotate(360);
	}
}
