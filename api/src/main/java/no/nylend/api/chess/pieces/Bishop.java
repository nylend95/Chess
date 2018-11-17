package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.*;

public class Bishop extends Piece {


	public Bishop(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	public Set<Position> getMoves() {
		return new HashSet<>(Collections.singletonList(new Position(position.getRow() + color.getValue(), position.getColumn())));
	}


	@Override
	public Set<Position> getAttack() {
		return new HashSet<>(Arrays.asList(
				new Position(position.getRow() + color.getValue(), position.getColumn() - 1),
				new Position(position.getRow() + color.getValue(), position.getColumn() + 1)));
	}
}
