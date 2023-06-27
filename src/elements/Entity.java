package elements;

import lib.Point;
import javafx.scene.image.ImageView;

public class Entity {
	private ImageView imageView;
	private Point position = new Point();
	private double domainX,domainY;
	private double Width,Height;//Chiều rộng và chiều dài của thực thể
	private int HP;// máu
	
	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public double getWidth() {
		return Width;
	}

	public void setWidth(double width) {
		Width = width;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position.setLocation(position);
		imageView.setLayoutX(position.getX());
		imageView.setLayoutY(position.getY());
	}

	public ImageView getImageView() {
		return imageView;
	}

	public Entity(String linkImage, float width, float heigh, int HP) {
		this.Width = width;
		this.Height = heigh;
		this.HP = HP;
		imageView = new ImageView(linkImage);
		imageView.setFitWidth(width);
		imageView.setFitHeight(heigh);
		domainY = heigh/2;
		domainX = width/2;
		
	}
	//lấy tâm của thực thể
	public Point getCenter() {
		Point point = new Point(Width/2,Height/2);
		point.add(position);
		return point;
	}
	
	public boolean hasVaCham(Entity entity) {
		Point vector = new Point();
		vector.setLocation(getCenter());
		vector.sub(entity.getCenter());
		if(Math.abs(vector.getX())<=this.domainX+entity.domainX&&Math.abs(vector.getY())<=this.domainY+entity.domainY)return true;

		return false;
	}
}
