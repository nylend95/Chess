package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.Set;

public class Queen extends Piece {

	public Queen(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	public Set<Position> getMoves() {
		return null;
	}

	@Override
	public Set<Position> getAttack() {
		return null;
	}
}
