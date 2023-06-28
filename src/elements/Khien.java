package elements;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.AnchorPane;
import lib.Point;

public class Khien extends Bullet{

	public Khien(String linkImage, float width, float heigh, Point vector) {
		super(linkImage, width, heigh, vector);
		// TODO Auto-generated constructor stub
	}
	public void baoVe(SpaceShip spaceShip) {
		Point position = new Point(-105, -105);
		spaceShip.coKhien = true;
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (now >= 5*10e9) {
					spaceShip.coKhien = false;
					this.stop();
				}
			}
		};
	}
}
