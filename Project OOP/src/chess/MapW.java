package chess;

public class MapW {
	public static Boolean[][] getMap() {
		return map;
	}

	public static void setMap(Boolean[][] map) {
		MapW.map = map;
	}

	static Boolean[][] map = new Boolean[8][8];

}
