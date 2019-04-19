package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

public class Rook extends Bidak {

	public Rook(Point point, String name, Color color, boolean isActive, ImageIcon img) {
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
	public boolean legalMove(Point click, Point selected) {
		// TODO Auto-generated method stub
		boolean isTrue1 = true, isTrue2 = true, isTrue3 = true, isTrue4 = true;
		for (int i = 1; i < 8; i++) {
			if (click.x == selected.x && click.y > selected.y && selected.y + i < 8 && isTrue1) {
//				System.out.println("bambang");
				if (click.y == selected.y + i && (ValidasiMap.map[selected.y + i][selected.x] == null
						|| !ValidasiMap.map[selected.y + i][selected.x].getColor().equals(getColor()))) {
					return true;
				}
				if (ValidasiMap.map[selected.y + i][selected.x] != null)
					isTrue1 = false;
			}
			if (click.x == selected.x && click.y < selected.y && selected.y - i >= 0 && isTrue2) {
				if (click.y == selected.y - i && (ValidasiMap.map[selected.y - i][selected.x] == null
						|| !ValidasiMap.map[selected.y - i][selected.x].getColor().equals(getColor()))) {
					return true;
				}
				if (ValidasiMap.map[selected.y - i][selected.x] != null)
					isTrue2 = false;
			}
			if (click.y == selected.y && click.x > selected.x && selected.x + i < 8 && isTrue3) {
				if (click.x == selected.x + i && (ValidasiMap.map[selected.y][selected.x + i] == null
						|| !ValidasiMap.map[selected.y][selected.x + i].getColor().equals(getColor()))) {
					return true;
				}
				if (ValidasiMap.map[selected.y][selected.x + i] != null)
					isTrue3 = false;
			}
			if (click.y == selected.y && click.x < selected.x && selected.x - i >= 0 && isTrue4) {
				if (click.x == selected.x - i && (ValidasiMap.map[selected.y][selected.x - i] == null
						|| !ValidasiMap.map[selected.y][selected.x - i].getColor().equals(getColor()))) {
					return true;
				}
				if (ValidasiMap.map[selected.y][selected.x - i] != null)
					isTrue4 = false;
			}
		}

		return false;
	}
	
	
	@Override
	public Graphics DrawpredictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub

		predictedMove(p);
		for (Point point : pointsLegalMove) {
			paint.drawRect((point.x) * SIZE + RESIZE, ((point.y)) * SIZE + RESIZE, 500 / 8, 500 / 8);
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

}
