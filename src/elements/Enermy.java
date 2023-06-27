package elements;

import javafx.scene.layout.AnchorPane;

public abstract class Enermy extends Entity{
	
	public Enermy(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh, 10);
	}
	
	public abstract void move(SpaceShip spaceShip, AnchorPane pane);
	public abstract void attack(SpaceShip spaceShip, AnchorPane pane);
}
