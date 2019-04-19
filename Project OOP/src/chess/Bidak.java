package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ImageIcon;

import com.sun.prism.paint.Paint;

public abstract class Bidak {
	protected final int RESIZE = (720 / 8);
	protected final int SIZE = 500 / 8;
	protected Point point;
	protected String name;
	protected Color color;
	protected boolean active;
	protected ImageIcon img;
	protected int step = 0;
	
	public Vector<Point> getPointsLegalMove() {
		return pointsLegalMove;
	}

	public void setPointsLegalMove(Vector<Point> pointsLegalMove) {
		this.pointsLegalMove = pointsLegalMove;
	}

	protected Vector<Point>pointsLegalMove = new Vector<Point>();
	
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

	public abstract boolean legalMove(Point click, Point selected);

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
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

	public Bidak(Bidak bidak) {
		this.point = bidak.point;
		this.name = bidak.name;
		this.color = bidak.color;
		this.active = bidak.active;
		this.img = bidak.img;
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

	public abstract Graphics DrawpredictedMove(Graphics paint, Point p);
	public abstract void predictedMove( Point selected);
}
