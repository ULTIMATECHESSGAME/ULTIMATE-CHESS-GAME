package chess;

import java.util.Vector;

public class Player {
	private Vector<Bidak>bidakList = new Vector<Bidak>();

	public Vector<Bidak> getBidakList() {
		return bidakList;
	}

	public void setBidakList(Vector<Bidak> bidakList) {
		this.bidakList = bidakList;
	}
	
}
