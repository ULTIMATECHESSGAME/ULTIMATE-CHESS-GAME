package chess;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

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

	private Graphics paintTemp;

	@Override
	public boolean legalMove(Point click, Point selected) {
		// TODO Auto-generated method stub
		boolean isTrue1 = true, isTrue2 = true, isTrue3 = true, isTrue4 = true;
//		System.out.println(click.x);
		if (ValidasiMap.map[click.y][click.x] != null
				&& ValidasiMap.map[click.y][click.x].getColor().equals(getColor())) {
			return false;
		}
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {

				if (selected.x < click.x && selected.y > click.y && selected.y + (i * -1) >= 0
						&& selected.x + (j) < 8) {
//					System.out.println("1");
					if (isTrue2 && selected.x + (j) == click.x && selected.y + (i * -1) == click.y
							&& (j) == Math.abs(i * -1)) {
//						System.out.println("heheeheh");
						return true;
					}

					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j)] != null && (j) == Math.abs(i * -1))
						isTrue2 = false;
				}
				if (selected.x < click.x && selected.y < click.y && selected.y + i < 8 && selected.x + j < 8) {
					if (isTrue3 && selected.x + j == click.x && selected.y + i == click.y && j == i) {
//						System.out.println("heheeheh");
						return true;
					}

					if (ValidasiMap.map[selected.y + i][selected.x + j] != null && (j) == (i)) {
						isTrue3 = false;
//						System.out.println("wewewewew");
					}

				}
				if (selected.x > click.x && selected.y > click.y && selected.y + (i * -1) >= 0
						&& selected.x + (j * -1) >= 0) {
//					System.out.println("1");
					if (isTrue4 && selected.x + (j * -1) == click.x && selected.y + (i * -1) == click.y
							&& (j * -1) == (i * -1)) {
//						System.out.println("heheeheh");
						return true;
					}

					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j * -1)] != null && (j * -1) == (i * -1))
						isTrue4 = false;

				}
				if (selected.x > click.x && selected.y < click.y && selected.y + (i) < 8
						&& selected.x + (j * -1) >= 0) {
//					System.out.println("3");

					if (isTrue1 && selected.x + (j * -1) == click.x && selected.y + (i) == click.y
							&& Math.abs(j * -1) == (i)) {
//						System.out.println("heheeheh");
						return true;
					}
					if (ValidasiMap.map[selected.y + (i)][selected.x + (j * -1)] != null && Math.abs(j * -1) == (i))
						isTrue1 = false;

				}
			}
		}
		return false;
	}
	
	@Override
	public void predictedMove( Point selected) {
		// TODO Auto-generated method stub
		pointsLegalMove.removeAllElements();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (legalMove(new Point(j, i), selected)) 
					pointsLegalMove.add(new Point(j, i));
//					paint.drawRect((  (j)) * SIZE + RESIZE, ( (i)) * SIZE + RESIZE, 500 / 8, 500 / 8);
				
			}
		}
	}
	
	@Override
	public Graphics DrawpredictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub
		paint.setColor(Color.red);
		predictedMove(p);
		
		for (Point point : pointsLegalMove) {
			paint.drawRect((  (point.x)) * SIZE + RESIZE, ( (point.y)) * SIZE + RESIZE, 500 / 8, 500 / 8);
		}
		return paint;
	}

}
