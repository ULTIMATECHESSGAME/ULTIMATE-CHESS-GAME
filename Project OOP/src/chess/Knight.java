package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Knight extends Bidak {

	private int[] a = { +1,-2, -1,-2, +1,+2, -1,+2 ,+2,-1 ,-2,-1 ,+2,+1 ,-2,+1 };

	public Knight(Point point, String name, Color color, boolean isActive, ImageIcon img) {
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

	@Override
	public Graphics DrawpredictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub
		predictedMove(p);
		for (Point point : pointsLegalMove) {
			paint.drawRect((point.x) * SIZE + RESIZE, (point.y) * SIZE + RESIZE, 500 / 8, 500 / 8);

		}

		return paint;
	}
	
	@Override
	public void predictedMove(Point selected) {
		// TODO Auto-generated method stub
		pointsLegalMove.removeAllElements();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (legalMove(new Point(j, i), selected))
					pointsLegalMove.add(new Point(j, i));
			}
		}

	}
	
	@Override
	public boolean legalMove(Point click, Point selected) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 16; i += 2) {
			if (selected.y + a[i + 1] > 7 || selected.y + a[i + 1] < 0 || selected.x + a[i] > 7
					|| selected.x + a[i] < 0)
				continue;

			if ((ValidasiMap.map[selected.y + a[i + 1]][selected.x + a[i]] == null
					|| !ValidasiMap.map[selected.y + a[i + 1]][selected.x + a[i]].getColor().equals(getColor()))
					&& selected.y + a[i + 1] == click.y && selected.x + a[i] == click.x)
				return true;
		}
		return false;
	}

}
