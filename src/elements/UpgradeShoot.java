package elements;

import java.util.ArrayList;

import javafx.scene.layout.AnchorPane;

public class UpgradeShoot {
	private int soDan;
	public UpgradeShoot(int soDan) {
		this.soDan = soDan;
		for(int i = 0;i<soDan;i++) {
			bullet.add(new BulletHero());
		}
	}
	//ban nhieu tia
	ArrayList<BulletHero> bullet = new ArrayList<BulletHero>();
	
	public void Shoot(SpaceShip spaceShip,AnchorPane pane, ArrayList<Entity> E) {
			switch(soDan) {
			case 2: {
				bullet.get(0).getVector().rotateLeft(15.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(-15.0/180*3.14);
				break;
				}
			case 3: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(2).getVector().rotateLeft(-20.0/180*3.14);
				break;
				}
			case 4: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(12.0/180*3.14);
				bullet.get(2).getVector().rotateLeft(-12.0/180*3.14);
				bullet.get(3).getVector().rotateLeft(-20.0/180*3.14);
				break;
				
			}
			case 5: {
				bullet.get(0).getVector().rotateLeft(20.0/180*3.14);
				bullet.get(1).getVector().rotateLeft(5.0/180*3.14);
				bullet.get(3).getVector().rotateLeft(-5.0/180*3.14);
				bullet.get(4).getVector().rotateLeft(-20.0/180*3.14);
				break;
			}
			}
			for(int i = 0;i<soDan;i++) {
				bullet.get(i).Shoot(spaceShip, pane, E);
			}
			
				
		}
			
		
		
	}
	

