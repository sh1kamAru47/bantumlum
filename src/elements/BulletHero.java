package elements;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lib.Point;
public class BulletHero extends Bullet{
	Point position = new Point(20, 15);//vị trí so với ufo
	public BulletHero(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
	}
	public BulletHero() {
		this("/resourses/gamekit/spritesheets/basicBullet.png",
			 20, 20, new Point(0, -15));
	}
	
	public void Shoot(SpaceShip spaceShip, AnchorPane pane,ArrayList<Entity> E) {
		spaceShip.setBulletStore(spaceShip.getBulletStore()-1);
		position.add(spaceShip.getPosition());
		this.setPosition(position);
		
		pane.getChildren().add(this.getImageView());
		
		AnimationTimer bulletTimer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				position.add(getVector());
				
				setPosition(position);
				for(int i = 0;i<E.size();i++) {
					Entity e = E.get(i);
					
					if(hasVaCham(e)) {
						e.setHP(e.getHP()-1);
						if(e instanceof Stone) {
					
							 if(e.getHP()==1)((Stone) e).dau();
							 if(e.getHP()==0) {
								 spaceShip.setScore(spaceShip.getScore()+1);
								 ((Stone)e).no();
							
								 
								 PauseTransition delay = new PauseTransition(Duration.seconds(0.8));
								 delay.setOnFinished(event->{
									e.setPosition(new Point(1000,1000));
								
										E.remove(E.indexOf(e));
										System.out.println("pum`");
						
										
									 
								 });delay.play();
								
									
							 }
						}
						pane.getChildren().remove(getImageView());
						this.stop();
					}
				}
                 
				if (position.getY() < 0) {
					pane.getChildren().remove(getImageView());
					this.stop();// dung animationTimer lai
				}	
			}
		};
		bulletTimer.start();
	}
}
