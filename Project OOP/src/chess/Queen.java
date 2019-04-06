package chess;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Queen extends Bidak{

	public Queen(Point point, String name, Color color, boolean isActive, ImageIcon img) {
		super(point, name, color, isActive, img);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return super.getColor();
	}
	@Override
	public ImageIcon getImg() {
		// TODO Auto-generated method stub
		return super.getImg();
	}
	@Override
	public Point getPoint() {
		// TODO Auto-generated method stub
		return super.getPoint();
	}
	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return super.isActive();
	}
	@Override
	public void setActive(boolean isActive) {
		// TODO Auto-generated method stub
		super.setActive(isActive);
	}
	@Override
	public void setPoint(Point point) {
		// TODO Auto-generated method stub
		super.setPoint(point);
	}

}
