package no.nylend.api.chess;

import java.util.Objects;

/**
 * Representation of each square at the chess board
 */
public class Position {
	private int column; // column index [0-7]
	private int row; // row index [0-7]

	public Position(int column, int row) {
		this.column = column;
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Position position = (Position) o;
		return row == position.row &&
				column == position.column;
	}

	@Override
	public int hashCode() {
		return Objects.hash(row, column);
	}

	@Override
	public String toString(){
		return "[" + getColumn() + ", " + getRow() + "]";
	}

}
