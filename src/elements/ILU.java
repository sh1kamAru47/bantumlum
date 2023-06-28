package elements;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import lib.Point;

public class ILU extends Entity {
	private ILU ilu = this;
	private AnimationTimer timer ;

	public AnimationTimer getTimer() {
		return this.timer;
	}
	public ILU(String linkImage, float width, float heigh,int HP, Point vector) {
		super(linkImage, width, heigh, HP);
		this.vector = vector;
	}
	
	private Point vector = new Point();
	public void setVector(Point p) {
		this.vector = p;
	}
	public Point getVector() {
		return vector;
	}

	
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		pane.getChildren().add(this.getImageView());
		Point position = this.getPosition();
		
		 timer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				 effect();
				position.add(vector);
				setPosition(position);
				
				if (position.getY() > 890 || position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// stop animationTimer
					
					
				}
				else if (hasVaCham(spaceShip)) {
					System.out.println("BOOM");
					pane.getChildren().remove(getImageView());
					attack(spaceShip, pane);
					this.stop();
			
				
				
				}
				
			}
		};
		timer.start();
	}
	public void attack(SpaceShip spaceShip, AnchorPane pane) {}
	public void init(SpaceShip spaceShip) {}
	public void effect() {}
}
