package chess;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Bishop extends Bidak {

	public Bishop(Point point, String name, Color color, boolean isActive, ImageIcon img) {
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

	private Graphics paintTemp ;

//	@Override
//	public boolean legalMove(Point selected, Point click) {
//		// TODO Auto-generated method stub
//		int x = 0, x2 = 0;
//		int y = 0, y2 = 0;
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				//ValidasiMap.map[selected.y + i][selected.x + j] == null
//				if ((selected.x + j) == (selected.y+i)) {
//					System.out.println(selected.x+j + " "+ selected.y+i);
//					paintTemp.drawRect((selected.x + j) * SIZE + RESIZE, (selected.y + i) * SIZE + RESIZE, 500 / 8, 500 / 8);
//				}
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public Graphics predictedMove(Graphics paint, Point p) {
//		// TODO Auto-generated method stub
//		paint.setColor(Color.red);
//		paintTemp = paint;
////		for (int i = 0; i < 8; i++) {
////			for (int j = 0; j < 8; j++) {
////				if (legalMove(p, new Point(j, i))) {
//////					paint.drawRect(j * SIZE + RESIZE, i * SIZE + RESIZE, 500 / 8, 500 / 8);
////				}
////			}
////		}
//		legalMove(p, new Point(1, 1));
//		return paintTemp;
//	}

}
