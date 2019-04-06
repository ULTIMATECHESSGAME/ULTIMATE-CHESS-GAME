package chess;

public  class ValidasiMap {
	static Bidak[][] map = new Bidak[8][8];
	
	public static Bidak[][] getMap() {
		return map;
	}

	public static void setMap(Bidak[][] map) {
		ValidasiMap.map = map;
	}

}
