package chess;

import java.awt.Color;
import java.awt.Point;

import javax.swing.ImageIcon;

public class King extends Bidak {
	
	public King(Point point, String name, Color color, boolean isActive, ImageIcon img) {
		// TODO Auto-generated constructor stub
		super(point, name, color, isActive, img);
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
//	@Override
//	public boolean legalMove(Point p) {
//		System.out.println(p.x + " " + p.y);
//		// TODO Auto-generated method stub
//		try {
//			if (ValidasiMap.map[p.y][p.x].getColor().equals(this.getColor()))
//				return false;
//		} catch (Exception e) {
//
//		}
//		return true;
//	}
}
