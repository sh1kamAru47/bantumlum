package elements;

import java.util.Random;

import lib.Point;

public class HpMore extends ExtraPresent{
	
	public HpMore() {
		super("/resourses/gamekit/spritesheets/pixelHeart.png", 32, 32);
		this.setVector(new Point(0,15));
		Random random = new Random();
		this.setPosition(new Point((int) (random.nextDouble()*1100 + 100),0));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effectPresent(SpaceShip spaceShip) {
		if (spaceShip.getHP() < 10)
			spaceShip.setHP(spaceShip.getHP()+1);
		
	}

}
