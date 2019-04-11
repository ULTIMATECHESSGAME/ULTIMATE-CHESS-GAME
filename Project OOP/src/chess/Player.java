package chess;

import java.awt.Color;
import java.util.Vector;

public class Player {
	private Color playerColor;
	private Vector<Bidak> bidakList = new Vector<Bidak>();

	public Vector<Bidak> getBidakList() {
		return bidakList;
	}

	public void setBidakList(Vector<Bidak> bidakList) {
		this.bidakList = bidakList;
	}

	public Player(Color color) {
		// TODO Auto-generated constructor stub
		this.playerColor = color;
	}

	public Color getPlayerColor() {
		return playerColor;
	}

}
