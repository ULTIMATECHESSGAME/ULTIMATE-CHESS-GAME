package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.ImageIcon;

import com.sun.prism.paint.Paint;

public class Bidak {
	protected final int RESIZE = (720/8);
	protected final int SIZE = 500/8;
	protected Point point;
	protected String name;
	protected Color color;
	protected boolean active;
	protected ImageIcon img;
	protected int step = 0;
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

	public boolean legalMove(Point selected, Point click) {

		return true;
	}


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
	
	public Graphics predictedMove(Graphics paint, Point p) {
//		paint.setColor(Color.blue);
//		paint.fillRect(p.x, p.y, 500/8, 500/8);
//		paint.fillRect(p.x + 1, p.y, 500/8, 500/8);
		
		
//		paint.drawRect(0,0, 100, 100);
		return paint;
	}
	

}
