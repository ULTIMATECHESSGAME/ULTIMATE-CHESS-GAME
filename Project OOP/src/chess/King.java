package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ImageIcon;

public class King extends Bidak {
	public boolean isRokade() {
		return rokade;
	}

	public void setRokade(boolean rokade) {
		this.rokade = rokade;
	}

	private boolean rokade = false;
	
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

	private boolean checkJalurRokade(Boolean [][] check, Point click) {
		if(getColor().equals(Color.BLACK)) {
			if(click.x < 4) {
				for (int i = 1; i <= 3; i++) {
					if((check[0][i]!=null&&check[0][i])  )
						return false;
					if(ValidasiMap.map[0][i] != null)return false;
				}
			}
			else {
				for (int i = 5; i <= 6; i++) {
					if((check[0][i]!=null&&check[0][i]) )
						return false;
					if(ValidasiMap.map[0][i] != null)return false;
				}
			}
		}
		else {
			
		}
		return true;
	}
	
	@Override
	public boolean legalMove(Point click, Point selected) {
		// TODO Auto-generated method stub
//		if(ValidasiMap.map[click.y][click.x]!=null)return false;
		int [] kordinat = {
				0,0 ,0,7 , 7,0 ,7,7 
		};
		int [] kordinatRokade = {
			2,0 ,6,0 ,2,7 ,6,7	
		};
		
		for (int i = 0; i < 8; i+=2) {
			if(this.point.y == kordinat[i+1]) {
				if(this.step == 0 && ValidasiMap.map[kordinat[i + 1]][kordinat[i]].getStep() == 0) {
					for (int j = 0; j < 8; j+=2) {
						if(click.x == kordinatRokade[j] && click.y == kordinatRokade[j+1] && 
							checkJalurRokade(MapW.map, click) )return true;
					}
				}
			}
		}
		
		if(Math.abs(click.x - selected.x) == 2)return false;
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (ValidasiMap.map[i][j] == null)
					continue;
				if (ValidasiMap.map[i][j].getColor().equals(getColor()))
					continue;
				if (!ValidasiMap.map[i][j].getColor().equals(getColor()) && !(ValidasiMap.map[i][j] instanceof King)) {
					if (ValidasiMap.map[click.y][click.x] != null
							&& ValidasiMap.map[click.y][click.x].getColor().equals(getColor()))
						return false;
					if (ValidasiMap.map[i][j].legalMove(click, new Point(j, i))) {
						System.out.println(i + " " + j);
						return false;
					}
				}

			}
		}

		return true;
	}
	@Override
	public void predictedMove(Point p) {
		// TODO Auto-generated method stub
		int[] kordinat = { -1, -1, 0, -1, +1, -1, +1, 0, +1, +1, 0, +1, -1, +1, -1, 0 , +2,0 ,-2,0};
		pointsLegalMove.removeAllElements();
		
		for (int i = 0; i < 20; i+=2) {
			if (p.x + kordinat[i] < 8 && p.x + kordinat[i] >= 0 && p.y + kordinat[i + 1] < 8
					&& p.y + kordinat[i + 1] >= 0) {
				if (legalMove(new Point(p.x + kordinat[i], p.y + kordinat[i + 1]), p))
					pointsLegalMove.add(new Point(p.x + kordinat[i], p.y + kordinat[i+1]));
			}
		}
	}

	@Override
	public Graphics DrawpredictedMove(Graphics paint, Point p) {
		// TODO Auto-generated method stub
		predictedMove(p);
		for (Point i : pointsLegalMove) {
			paint.drawRect((i.x) * SIZE + RESIZE, ((i.y)) * SIZE + RESIZE, 500 / 8,
					500 / 8);
		}
		
		return paint;
	}
}
