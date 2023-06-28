package elements;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.AnchorPane;
import lib.Point;

public class TaoCoKhien extends ExtraPresent{

	public TaoCoKhien(String linkImage, float width, float heigh) {
		super(linkImage, width, heigh);
		// TODO Auto-generated constructor stub
	}
	public TaoCoKhien() {
		super("/resourses/gamekit/spritesheets/khien.png", 70, 70);
		this.setVector(new Point(0,5));
		Random random = new Random();
		this.setPosition(new Point((int) (random.nextDouble()*1100 + 100),0));
	}
	@Override
	public void effectPresent(SpaceShip spaceShip) {
		// TODO Auto-generated method stub
		spaceShip.setKhien(15);
		
	}
}
