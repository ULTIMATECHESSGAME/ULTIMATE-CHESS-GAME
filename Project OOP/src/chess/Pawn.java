package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.sun.prism.paint.Paint;

public class Pawn extends Bidak {

	public Pawn(Point point, String name, Color color, boolean isActive, ImageIcon img) {
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
	public void setStep(int step) {
		// TODO Auto-generated method stub
		super.setStep(step);
	}

	@Override
	public boolean legalMove(Point click, Point selected) {
//		System.out.println(p.x + " " + p.y);
//		System.out.println(Math.abs(click.y - selected.y));
		// TODO Auto-generated method stub
		try {
			if (ValidasiMap.map[click.y][click.x].getColor().equals(this.getColor()))
				return false;

		} catch (Exception e) {

		}
		if(Math.abs(click.y - selected.y) > 2 || Math.abs(click.x - selected.x) > 1 )return false;
		
		if (Math.abs(click.y - selected.y) == 2 && step == 0 &&Math.abs(click.x - selected.x)==0)
			return true;
		if (Math.abs(click.y - selected.y) != 1 && getStep() != 0) {
			System.out.println(false);
			return false;
		}

		if (ValidasiMap.map[click.y][click.x] != null && !ValidasiMap.map[click.y][click.x].getColor()
				.equals(ValidasiMap.map[selected.y][selected.x].getColor()))
			return true;
		if (click.x != selected.x)
			return false;
		if (ValidasiMap.map[selected.y][selected.x].getColor().equals(Color.BLACK)) {
			if (selected.y > click.y)
				return false;

		} else {
			if (selected.y < click.y)
				return false;
		}

		return true;
	}

	@Override
	public Graphics predictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub
		paint.setColor(Color.RED);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(legalMove(new Point(j, i), p)) {
					paint.drawRect(j * SIZE + RESIZE, i * SIZE + RESIZE, 500 / 8, 500 / 8);
				}
			}
		}
		
		return paint;
	}

}
