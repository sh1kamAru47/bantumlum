package elements;

import javafx.scene.layout.AnchorPane;

public class EnermyShip extends Enermy{

	public EnermyShip(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh);
	}
	public EnermyShip() {
		this("/resourses/gamekit/spritesheets/enermy/stoneEnermy/stone2.png", 20, 20);
	}
	
	@Override
	public void move(SpaceShip spaceShip, AnchorPane pane) {
		// cho di chuyen sang ngang hai ben
		
	}

	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		// ban dan 3 tia
		
	}

}
