package no.nylend.api.chess;

public class Utils {

	public static int indexConverter(int x, int y) {
		return  y * 8 + x;
	}

	public static int indexConverter(Position position) {
		return indexConverter(position.getColumn(), position.getRow());
	}

	public static Position indexConverter(int index){
		return new Position(index % 8, index / 8);
	}

	public static int maxMin(int val){
		return Math.min(7, Math.max(0, val));
	}
}
