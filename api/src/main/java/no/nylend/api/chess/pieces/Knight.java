package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.BitSet;

public class Knight extends Piece {
	public Knight(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	public BitSet updateMoves() {
		return moveSet;
		//TODO!
	}
}
