package chess;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Bidak {
	protected Point point;
	protected String name;
	protected Color color;
	protected boolean active;
	protected ImageIcon img;
	
	public String getName() {
		return name;
	}
	
	public Color getColor() {
		return color;
	}

	public boolean isActive() {
		return active;
	}

	public ImageIcon getImg() {
		return img;
	}

	public boolean legalMove(Point point) {

		return false;
	}


	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Bidak(Point point, String name, Color color, boolean isActive, ImageIcon img) {
		super();
		this.point = point;
		this.name = name;
		this.color = color;
		this.active = isActive;
		this.img = img;
	}

	public Bidak() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}
	

}
