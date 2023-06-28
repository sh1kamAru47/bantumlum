package elements;

import javafx.scene.layout.AnchorPane;
import lib.Point;

public class BulletEnemy extends Bullet{

	public BulletEnemy(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
		// TODO Auto-generated constructor stub
	}

	public BulletEnemy() {
		this("/resourses/gamekit/spritesheets/enermy/danTim.png",40,40,new Point(0,7));
	}
	@Override
	public void attack(SpaceShip spaceShip, AnchorPane pane) {
		spaceShip.dau();
		if (!spaceShip.coKhien)
			if(spaceShip.getHP()>0)
				spaceShip.setHP(spaceShip.getHP()-1>0?spaceShip.getHP()-1:0);

	}

}
