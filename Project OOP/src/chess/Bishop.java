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

	private Graphics paintTemp;

	@Override
	public boolean legalMove(Point click, Point selected) {
		// TODO Auto-generated method stub
		boolean isTrue1 = true, isTrue2 = true, isTrue3 = true, isTrue4 = true;
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {

				if (selected.x < click.x && selected.y > click.y && selected.y + (i * -1) >= 0
						&& selected.x + (j) < 8) {
					System.out.println("1");
					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j)] != null && (j) == Math.abs(i * -1))
						isTrue2 = false;
					if (isTrue2 && selected.x + (j) == click.x && selected.y + (i * -1) == click.y
							&& (j) == Math.abs(i * -1)) {
						System.out.println("heheeheh");
						return true;
					}
				}
				if (selected.x < click.x && selected.y < click.y && selected.y + i < 8 && selected.x + j < 8) {
					if (ValidasiMap.map[selected.y + i][selected.x + j] != null && (j) == (i)) {
						isTrue3 = false;
						System.out.println("wewewewew");
					}
					if (isTrue3 && selected.x + j == click.x && selected.y + i == click.y && j == i) {
						System.out.println("heheeheh");
						return true;
					}

				}
				if (selected.x > click.x && selected.y > click.y && selected.y + (i * -1) >= 0
						&& selected.x + (j * -1) >= 0) {
					System.out.println("1");
					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j * -1)] != null && (j * -1) == (i * -1))
						isTrue2 = false;
					if (isTrue2 && selected.x + (j * -1) == click.x && selected.y + (i * -1) == click.y
							&& (j * -1) == (i * -1)) {
						System.out.println("heheeheh");
						return true;
					}
				}
				if (selected.x > click.x && selected.y < click.y && selected.y + (i) < 8
						&& selected.x + (j * -1) >= 0) {
					System.out.println("3");
					if (ValidasiMap.map[selected.y + (i)][selected.x + (j * -1)] != null && Math.abs(j * -1) == (i))
						isTrue2 = false;
					if (isTrue2 && selected.x + (j * -1) == click.x && selected.y + (i) == click.y
							&& Math.abs(j * -1) == (i)) {
						System.out.println("heheeheh");
						return true;
					}

				}
			}
		}
		return false;
	}

	public boolean drawPredictedMove(Point selected, Point click) {
		// TODO Auto-generated method stub
		boolean isTrue1 = true, isTrue2 = true, isTrue3 = true, isTrue4 = true;
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				if ((j) == (i) && isTrue1 && selected.y + i < 8 && selected.x + j < 8) {
					if (ValidasiMap.map[selected.y + i][selected.x + j] != null) {
						isTrue1 = false;

					} else
						paintTemp.drawRect((selected.x + j) * SIZE + RESIZE, (selected.y + i) * SIZE + RESIZE, 500 / 8,
								500 / 8);
				}
				if ((j * -1) == (i * -1) && isTrue2 && selected.y + (i * -1) >= 0 && selected.x + (j * -1) >= 0) {
					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j * -1)] != null)
						isTrue2 = false;
					else
						paintTemp.drawRect((selected.x + (j * -1)) * SIZE + RESIZE,
								(selected.y + (i * -1)) * SIZE + RESIZE, 500 / 8, 500 / 8);

				}
				if ((Math.abs(j * -1)) == i && isTrue3 && selected.x + (j * -1) >= 0 && selected.y + i < 8) {
					if (ValidasiMap.map[selected.y + (i)][selected.x + (j * -1)] != null)
						isTrue3 = false;
					else
						paintTemp.drawRect((selected.x + (j * -1)) * SIZE + RESIZE, (selected.y + (i)) * SIZE + RESIZE,
								500 / 8, 500 / 8);

				}
				if ((Math.abs(i * -1)) == j && isTrue4 && selected.y + (i * -1) >= 0 && selected.x + j < 8) {
					if (ValidasiMap.map[selected.y + (i * -1)][selected.x + (j)] != null)
						isTrue4 = false;
					else
						paintTemp.drawRect((selected.x + (j)) * SIZE + RESIZE, (selected.y + (i * -1)) * SIZE + RESIZE,
								500 / 8, 500 / 8);

				}
			}
		}
		return true;
	}

	@Override
	public Graphics predictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub
		paint.setColor(Color.red);
		paintTemp = paint;
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 8; j++) {
//				if (legalMove(p, new Point(j, i))) {
////					paint.drawRect(j * SIZE + RESIZE, i * SIZE + RESIZE, 500 / 8, 500 / 8);
//				}
//			}
//		}
		drawPredictedMove(p, new Point(1, 1));
		return paintTemp;
	}

}
